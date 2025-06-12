package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TableTaskModel extends AbstractTableModel {
    List<TaskModel> list_task;

    public TableTaskModel(List<TaskModel> list_task){
        this.list_task = list_task;
    }

    @Override
    public int getColumnCount(){
        return 5;
    }

    @Override
    public int getRowCount(){
        return list_task.size();
    }

    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Title";
            case 1:
                return "Priority";
            case 2:
                return "Status";
            case 3:
                return "Category";
            case 4:
                return "Deadline";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column){
        switch(column){
            case 0:
                return list_task.get(row).getTitle();
            case 1:
                return list_task.get(row).getPriority();
            case 2:
                return list_task.get(row).getStatus();
            case 3:
                return list_task.get(row).getCategoryName();
            case 4:
                LocalDateTime deadlineDateTime = list_task.get(row).getDeadline();
                
                if (deadlineDateTime == null) {
                    return "";
                }

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

                return deadlineDateTime.format(formatter);


            default:
                return null;
        }
    }
}