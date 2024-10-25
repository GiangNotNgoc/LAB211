package controller;

import java.util.ArrayList;
import model.Expense;
import util.Utility;

public class manageExpense {

    ArrayList<Expense> list = new ArrayList();
    util.Utility utility = new Utility();

    public void addExpense(ArrayList<Expense> list, int id) {
        String date = utility.getDate("Enter Date: ");
        Double number = utility.getDouble("Enter amount of money: ", 0, Double.MAX_VALUE);
        String content = utility.getString("Enter content: ");
        list.add(new Expense(id, date, number, content));
    }

    public void displayExpense(ArrayList<Expense> list) {
        double total = 0;
        if (list.isEmpty()) {
            System.out.println("The list is empty!");
        }
        System.out.format("%-15s %-15s %-15s %-15s", "ID", "Date", "Amount of money", "Content");
        for (int i = 0; i < list.size(); i++) {
            System.out.format("%-15s %-15s %-15s %-15s", list.get(i).getId(), list.get(i).getDate(), list.get(i).getNumber(), list.get(i).getContent());
            total += list.get(i).getNumber();
        }
        System.out.println("Total: " + total);
    }

    public void deleteExpense(ArrayList<Expense> list) {
        int id = utility.getInt("Enter Id", 0, Integer.MAX_VALUE);
        int checkIdExist = checkIdExist(list, id);
        if (checkIdExist != -1) {
            list.remove(checkIdExist);
            System.out.println("Delete an expense successful");
            for (int i = id - 1; i < list.size(); i++) {
                list.get(i).setId(list.get(i).getId() - 1);
            }
        } else {
            System.err.println("Delete an expense fail");
        }
    }

    private int checkIdExist(ArrayList<Expense> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

}
