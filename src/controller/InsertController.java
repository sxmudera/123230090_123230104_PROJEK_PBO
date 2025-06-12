package controller;

import java.time.LocalDateTime;

import javax.swing.JOptionPane;
import dao.TaskDao;
import dao.CategoryDao;
import model.TaskModel;
import model.CategoryModel;
import view.InsertView;
import view.MainView;
import java.time.LocalDateTime;

public class InsertController {
    private InsertView frame;
    private TaskDao taskDao;
    private CategoryDao categoryDao;

    public InsertController(InsertView frame) {
        this.frame = frame;
        this.taskDao = new TaskDao();
        this.categoryDao = new CategoryDao();
    }

    public void insertData() {
        try {
            String title = frame.getTxtTitle().getText().trim();
            String desc = frame.getTxtDesc().getText().trim();
            String priority = (String) frame.getCBoxPriority().getSelectedItem();
            String categoryName = (String) frame.getCBoxCategory().getSelectedItem();
            LocalDateTime deadline = frame.getOutDeadline(); 

            if (title.isEmpty() || desc.isEmpty()) {
                JOptionPane.showMessageDialog(frame, 
                    "Judul dan deskripsi tidak boleh kosong!", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (categoryName == null) {
                JOptionPane.showMessageDialog(frame, 
                    "Pilih kategori terlebih dahulu!", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            CategoryModel category = categoryDao.getCategoryByName(categoryName);
            if (category == null) {
                JOptionPane.showMessageDialog(frame, 
                    "Kategori tidak valid!", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            TaskModel newTask = new TaskModel();
            newTask.setTitle(title);
            newTask.setDesc(desc);
            newTask.setPriority(priority);
            newTask.setCategoryId(category.getIdCategory());
            newTask.setDeadline(deadline);

            taskDao.insert(newTask);
            JOptionPane.showMessageDialog(frame, "Berhasil menambahkan task baru");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, 
                "Error: " + e.getMessage(), 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    public void back() {
        frame.dispose();
        new MainView().setVisible(true);
    }
}