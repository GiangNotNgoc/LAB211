/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author PHAM KHAC VINH
 */
public class Main {

    public static void main(String[] args) {
        Utility valid = new Utility();
        View_Task view = new View_Task();
        while (true) {
            //Step 1: Display the menu
            displayMenu();
            //Step 2: Let user input option
            int option = valid.getInt("Enter option: ", "Wrong", "Wrong", "Wrong", 1, 4);
            //Step 3: Call the method
            switch (option) {
                case 1:
                    view.input();
                    break;
                case 2:
                    view.deleteTask();
                    break;
                case 3:
                    view.display();
                    break;
                case 4:
                    System.exit(0);
                    break;

            }

        }
    }

    private static void displayMenu() {
        System.out.println("========= Task program =========\n"
                + "1.	Add Task\n"
                + "2.	Delete task\n"
                + "3.	Display Task\n"
                + "4.	exit");
    }
}
