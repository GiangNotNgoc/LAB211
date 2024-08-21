/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Validation;
import Model.Circle;
import Model.Rectangle;
import Model.Shape;
import Model.Triagle;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Main {

    public static void main(String[] args) {
        ArrayList<Shape> list;
        list = new ArrayList<>();
        while (true) {
            //1. Display the menu
            displayMenu();
            //2. select the option
            int choice = Validation.getChoice("Enter an option: ", 1, 5);
            //3. calling the method
            switch (choice) {
                case 1://calling the Circle method
                    Shape circle = new Circle();
                    list.add(circle);
                    break;
                case 2://calling the Rectangle method
                    Shape rectange = new Rectangle();
                    list.add(rectange);
                    break;
                case 3://calling the Triagle method
                    Shape triagle = new Triagle();
                    list.add(triagle);
                    break;
                case 4:
                    for (Shape shape : list) {
                        shape.input();
                    }
                    break;
                case 5:
                    for (Shape shape : list) {
                        shape.printResult();
                    }
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }

    private static void displayMenu() {
        System.out.println("");
        System.out.println("1. Circle\n"
                + "2. Rectangle\n"
                + "3. Triagle\n"
                + "4. Input\n"
                + "5. Print Result\n"
                + "6. Exit");
    }
}
