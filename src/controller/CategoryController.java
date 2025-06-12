package controller;

import javax.swing.JOptionPane;
import dao.CategoryDao;
import dao.CategoryInf;
import model.CategoryModel;
import view.CategoryView;
import view.MainView;

public class CategoryController {
    private CategoryView frame;
    private CategoryInf infCat;

    public CategoryController(CategoryView frame){
        this.frame = frame;
        infCat = new CategoryDao();
    }

    public void insertData(){
        String categoryName = frame.getTxtCategory().getText();

        if (categoryName.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Data tidak boleh kosong!");
            return;
        }

        CategoryModel newCategory = new CategoryModel();
        newCategory.setCategoryName(categoryName);

        try {
            infCat.insert(newCategory);
            JOptionPane.showMessageDialog(frame, "Berhasil menambahkan data baru");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(frame, "Gagal menambahkan data: " + e.getMessage());
        }
    }

    public void back(){
        frame.dispose();
        new MainView().setVisible(true);
    }
}
