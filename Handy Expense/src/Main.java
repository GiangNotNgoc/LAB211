
import controller.manageExpense;
import java.util.ArrayList;
import model.Expense;
import util.Utility;

public class Main {

    public static void main(String[] args) {
        ArrayList<Expense> list = new ArrayList<>();
        manageExpense manage = new manageExpense();
        int id = 0;
        Utility utility = new Utility();
        while (true) {
            displayMenu();
            int option = utility.getInt("Enter option: ", 1, 5);
            switch (option) {
                case 1:
                    manage.addExpense(list, ++id);
                    break;
                case 2:
                    manage.displayExpense(list);
                    break;
                case 3:
                    manage.deleteExpense(list);
                    id--;
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("Handy Expense\n"
                + "1. Add an expense\n"
                + "2. Display all expenses\n"
                + "3. Remove an expense\n"
                + "4. Exit");
    }
}
