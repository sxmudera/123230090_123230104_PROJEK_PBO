package dao;

import model.CategoryModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao implements CategoryInf {
    private Connection conn;

    public CategoryDao() {
        conn = ConnectDB.getConnection();
    }

    @Override
    public void insert(CategoryModel category) {
        String sql = "INSERT INTO category (name) VALUES (?)";
        try (PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, category.getCategoryName());
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<CategoryModel> getAllCategoryNames() {
        List<CategoryModel> categories = new ArrayList<>();
        String sql = "SELECT id_category, name FROM category";

        try (PreparedStatement pst = conn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                CategoryModel category = new CategoryModel();
                category.setIdCategory(rs.getInt("id_category"));
                category.setCategoryName(rs.getString("name"));
                categories.add(category);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return categories;
    }

    public CategoryModel getCategoryByName(String name) {
        String sql = "SELECT * FROM category WHERE name = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                CategoryModel category = new CategoryModel();
                category.setIdCategory(rs.getInt("id_category"));
                category.setCategoryName(rs.getString("name"));
                return category;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}