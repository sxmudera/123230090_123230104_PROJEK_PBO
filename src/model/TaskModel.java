package model;

import java.time.LocalDateTime;

public class TaskModel {
    private int id;
    private String title;
    private String desc;
    private String priority;
    private String status;
    private int categoryId;
    private String categoryName;
    private LocalDateTime deadline;

    public TaskModel() {
    }

    public TaskModel(int id, String title, String desc, String priority, String status, int categoryId, String categoryName, LocalDateTime deadline) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.priority = priority;
        this.status = status;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.deadline = deadline;
    }

    public int getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }
    
    public String getDesc(){
        return this.desc;
    }

    public String getPriority(){
        return this.priority;
    }

    public String getStatus(){
        return this.status;
    }

    public int getCategoryId(){
        return this.categoryId;
    }

    public String getCategoryName(){
        return this.categoryName;
    }

    public LocalDateTime getDeadline() { 
        return deadline;
    }

    public int setId(int id){
        return this.id = id;
    }

    public String setTitle(String title){
        return this.title = title;
    }
    
    public String setDesc(String desc){
        return this.desc =  desc;
    }

    public String setPriority(String priority){
        return this.priority = priority;
    }

    public String setStatus(String status){
        return this.status = status;
    }

    public int setCategoryId(int categoryId){
        return this.categoryId= categoryId;
    }

    public String setCategoryName(String categoryName){
        return this.categoryName = categoryName;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

}
