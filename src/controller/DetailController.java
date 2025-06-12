package controller;

import dao.CategoryDao;
import dao.TaskDao;
import dao.TaskInf;
import view.DetailView;
import view.MainView;
import model.TaskModel;
import model.CategoryModel;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DetailController {
    private DetailView frame;
    private TaskInf InfTask;
    private CategoryDao categoryDao;
    private TaskModel currentTask;

    public DetailController(DetailView frame){
        this.frame = frame;
        InfTask = new TaskDao();
        categoryDao = new CategoryDao();
    }

    public void showData(TaskModel task1){

        this.currentTask = task1;

        frame.setOutTitle(task1.getTitle());
        frame.setOutDesc(task1.getDesc());
        frame.setOutPriority(task1.getPriority());
        frame.setOutStatus(task1.getStatus());
        frame.setOutCategory(task1.getCategoryName());
        frame.setOutDeadline(task1.getDeadline());
        frame.setFieldsEditable(false);
    }

    public void deleteData(int id_task){
        int confirm = JOptionPane.showConfirmDialog(
            frame,
            "Apakah Anda yakin ingin menghapus task ini?",
            "Konfirmasi Hapus",
            JOptionPane.YES_NO_OPTION
        );

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                InfTask.delete(id_task);
                JOptionPane.showMessageDialog(frame, "Task berhasil dihapus!");
                back();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    public void editData(int id_task){
        try {
            String title = frame.getOutTitle().trim();
            String desc = frame.getOutDesc().trim();
            String priority = frame.getOutPriority();
            String status = frame.getOutStatus();
            String selectedCategoryName = frame.getOutCategory();
            LocalDateTime deadline = frame.getOutDeadline();

            if (title.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Title tidak boleh kosong!");
                return;
            }

            if (desc.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Description tidak boleh kosong!");
                return;
            }

            if (priority == null || priority.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Priority tidak boleh kosong!");
                return;
            }
            
            if (status == null || status.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Status tidak boleh kosong!");
                return;
            }

            if (selectedCategoryName == null || selectedCategoryName.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Kategori tidak boleh kosong!");
                return;
            }

            int categoryId = -1;
            CategoryModel selectedCategory = categoryDao.getCategoryByName(selectedCategoryName);
            if (selectedCategory != null) {
                categoryId = selectedCategory.getIdCategory();
            } else {
                JOptionPane.showMessageDialog(frame, "Kategori tidak valid!");
                return;
            }

            System.out.println("Updating task with ID: " + id_task);
            System.out.println("New Title: " + title);
            System.out.println("New Description: " + desc);
            System.out.println("New Priority: " + priority);
            System.out.println("New Status: " + status);
            System.out.println("New Category Name: " + selectedCategoryName);
            System.out.println("New Category ID: " + categoryId);
            if (deadline != null) {
                System.out.println("New Deadline: " + deadline.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
            } else {
                System.out.println("New Deadline: No Deadline");
            }

            InfTask.update(id_task, title, desc, priority, status, categoryId, deadline);

            JOptionPane.showMessageDialog(frame, "Task berhasil diupdate!");

            currentTask.setTitle(title);
            currentTask.setDesc(desc);
            currentTask.setPriority(priority);
            currentTask.setStatus(status);
            currentTask.setCategoryName(selectedCategoryName);
            currentTask.setDeadline(deadline);

            frame.setFieldsEditable(false);
            frame.setEditButtonText("EDIT");
            
            showData(currentTask); 
            

        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Error saat mengupdate task: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void back(){
        frame.dispose();
        new MainView().setVisible(true);
    }
}