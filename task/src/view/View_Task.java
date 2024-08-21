/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ManageTask;
import java.util.List;
import model.Task;

/**
 *
 * @author PHAM KHAC VINH
 */
public class View_Task {

    Utility valid = new Utility();
    ManageTask manage = new ManageTask();

    void input() {
        //nhap thong tin
        String requirementName, date, assignee, reviewer;
        int taskType;
        double from, to;

        requirementName = valid.getString("requirement name: ", "Wrong", valid.REGEX_STRING);
        taskType = valid.getInt("tasktype: ", "Wrong", "Wrong", "Wrong", 1, 4);
        date = valid.getDate("Enter date: ", "Date doest not exist !!");
        from = valid.getDouble("Enter from: ", "Wrong", "Wrong", "Wrong", 8, 17);
        to = valid.getDouble("Enter to: ", "Wrong", "Wrong", "Wrong", from + 0.5, 17.5);
        assignee = valid.getString("assignee : ", "Wrong", valid.REGEX_STRING);
        reviewer = valid.getString("reviewer : ", "Wrong", valid.REGEX_STRING);

        //them vao ben trong danh sach
        int result = manage.addTask(requirementName, taskType, date, from, to, assignee, reviewer);
        if (result == -1) {
            System.out.println("Duplicate task");
        } else {
            System.out.println("Add successfull !!");

        }
    }

    void deleteTask() {
        int id = valid.getInt("Enter id: ", "Wrong", "Wrong", "Wrong", 0, Integer.MAX_VALUE);

        Task task = manage.getTaskByID(id);

        if (task == null) {
            System.out.println("Not found !!");
        } else {
            manage.delete(task);
        }
    }

    void display() {
        List<Task> list = manage.getList();
        
        for (Task task : list) {
            System.out.println(task);
        }
    }

}
