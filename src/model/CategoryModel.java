package model;

public class CategoryModel {
    private String categoryName;
    private int id;

    public int getIdCategory(){
        return this.id;
    }

    public int setIdCategory(int id){
        return this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
