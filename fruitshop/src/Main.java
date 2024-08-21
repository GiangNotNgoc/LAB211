/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ApH3lios
 */
public class Main {

    public static void main(String[] args) {
        ManageFruit manage = new ManageFruit();
        Utility utility = new Utility();
        manage.mockData();
        while (true) {
            //1. display the menu
            displayMenu();
            //2. choose the option
            int option = utility.getInt("Enter option: ", "Wrong", "Wrong", "Wrong", 1, 5);
            //3.calling the method
            switch (option) {
                case 1://create fruit
                    manage.createFruit();
                    break;
                case 2://view order
                    
                    break;
                case 3://Shoppping
                    manage.shopping();
                    break;
                case 4://Exit
                    System.exit(0);
                    break;
                case 5://display all fruit
                    manage.displayListFruit(manage.fruitList);
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("FRUIT SHOP SYSTEM\n"
                + "1. Create Fruit\n"
                + "2. View orders\n"
                + "3. Shopping (for buyer)\n"
                + "4. Exit\n");
    }
}
