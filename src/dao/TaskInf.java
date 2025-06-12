package dao;

import model.TaskModel;
import java.util.List;
import java.time.LocalDateTime;

public interface TaskInf {
    
    public void insert(TaskModel task1);
    
    public void update(int id_task, String title, String desc, String priority, String status, int categoryId, LocalDateTime deadline);

    public void delete(int id_task);

    public List<TaskModel> getData();

}
