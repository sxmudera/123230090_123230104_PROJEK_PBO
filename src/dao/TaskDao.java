package dao;

import model.TaskModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TaskDao implements TaskInf {
    private Connection conn;
    private final String insert = "INSERT INTO task (title, description, priority, status, id_category, deadline) VALUES (?, ?, ?, 'Not Started', ?, ?)";
    private final String update = "UPDATE task SET title=?, description=?, priority=?, status=?, id_category=?, deadline=? WHERE id_task=?";
    private final String delete = "DELETE FROM task WHERE id_task=?";
    private final String select = "SELECT t.id_task, t.title, t.description, t.priority, t.status, t.id_category, c.name as category_name, t.deadline FROM task t LEFT JOIN category c ON t.id_category = c.id_category ORDER BY t.priority ASC";

    public TaskDao() {
        conn = ConnectDB.getConnection();
    }

    @Override
    public void insert(TaskModel task) {
        try (PreparedStatement stmt = conn.prepareStatement(insert)) {
            stmt.setString(1, task.getTitle());
            stmt.setString(2, task.getDesc());
            stmt.setString(3, task.getPriority());
            stmt.setInt(4, task.getCategoryId());
            if (task.getDeadline() != null) {
                stmt.setObject(5, task.getDeadline());
            } else {
                stmt.setNull(5, java.sql.Types.TIMESTAMP);
            }
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Failed to insert task", ex);
        }
    }

    @Override
    public void update(int id_task, String title, String desc, String priority, String status, int categoryId, LocalDateTime deadline) {
        try (PreparedStatement stmt = conn.prepareStatement(update)) {
            stmt.setString(1, title);
            stmt.setString(2, desc);
            stmt.setString(3, priority);
            stmt.setString(4, status);
            stmt.setInt(5, categoryId);
            if (deadline != null) {
                stmt.setObject(6, deadline);
            } else {
                stmt.setNull(6, java.sql.Types.TIMESTAMP);
            }
            stmt.setInt(7, id_task);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Failed to update task", ex);
        }
    }
    
    @Override
    public List<TaskModel> getData() {
        List<TaskModel> listTask = new ArrayList<>();
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(select)) {
            while (rs.next()) {
                TaskModel task = new TaskModel();
                task.setId(rs.getInt("id_task"));
                task.setTitle(rs.getString("title"));
                task.setDesc(rs.getString("description"));
                task.setPriority(rs.getString("priority"));
                task.setStatus(rs.getString("status"));
                task.setCategoryId(rs.getInt("id_category"));
                task.setCategoryName(rs.getString("category_name"));
                LocalDateTime deadline = rs.getObject("deadline", LocalDateTime.class);
                task.setDeadline(deadline);
                listTask.add(task);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TaskDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTask;
    }

    @Override
    public void delete(int id_task) {
        try (PreparedStatement stmt = conn.prepareStatement(delete)) {
            stmt.setInt(1, id_task);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException("Failed to delete task", ex);
        }
    }
}