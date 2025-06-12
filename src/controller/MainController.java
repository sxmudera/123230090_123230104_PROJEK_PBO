package controller;

import dao.TaskDao;
import dao.TaskInf;
import model.TaskModel;
import model.TableTaskModel;
import view.MainView;
import view.InsertView;
import view.CategoryView;
import view.DetailView;

import java.util.List;

public class MainController {
    private MainView frame;
    private TaskInf infTask;
    private List<TaskModel> listTask;

    public MainController(MainView frame){
        this.frame = frame;
        infTask = new TaskDao();
        listTask = infTask.getData();
    }

    public void load_table(){
        TableTaskModel ttm = new TableTaskModel(listTask);
        frame.getTabelTask().setModel(ttm);
    }

    public void insert_page(){
        frame.dispose();
        new InsertView().setVisible(true);
    }

    public void category_page(){
        frame.dispose();
        new CategoryView().setVisible(true);
    }

    public void detail_page(int row){
        frame.dispose();
        TaskModel task1 = listTask.get(row);

        new DetailView(task1).setVisible(true);
    }

    

}


