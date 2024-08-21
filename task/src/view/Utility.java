/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author PHAM KHAC VINH
 */
public class Utility {

    public final String REGEX_STRING = "[a-zA-Z0-9 ]+";

    /**
     * This function use to get a string input
     *
     * @param message: message required input
     * @param error: message error
     * @param regex: pattern use to check input
     * @return : user's input
     */
    public String getString(String message, String error, String regex) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();

            if (input.matches(regex)) {
                return input;
            } else {
                System.out.println(error);
            }
        }
    }

    /*
    lay ve 1 so dang integer
     */
    public int getInt(String message, String firstError, String secondError,
            String thirdError, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                int number = Integer.parseInt(input);

                //check range
                if (number > max) {
                    System.out.println(firstError);
                } else if (number < min) {
                    System.out.println(secondError);
                } else {
                    return number;
                }

            } catch (Exception e) {
                System.out.println(thirdError);
            }
        }
    }

    public double getDouble(String message, String firstError, String secondError,
            String thirdError, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                double number = Double.parseDouble(input);

                //check range
                if (number > max) {
                    System.out.println(firstError);
                } else if (number < min) {
                    System.out.println(secondError);
                } else if (number % 0.5 != 0) {
                    System.out.println("Must be modulo 0.5");
                } else {
                    return number;
                }
            } catch (Exception e) {
                System.out.println(thirdError);
            }
        }
    }

    public float getFloat(String message, String firstError, String secondError,
            String thirdError, float min, float max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine();
                float number = Float.parseFloat(input);

                //check range
                if (number > max) {
                    System.out.println(firstError);
                } else if (number < min) {
                    System.out.println(secondError);
                } else {
                    return number;
                }
            } catch (Exception e) {
                System.out.println(thirdError);
            }
        }
    }

    public String getDate(String message, String error) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine();
            //check format
            if (input.matches("\\d{1,2}[-]\\d{1,2}[-]\\d{4}") == false) {
                System.out.println("Date to correct format(dd/mm/yyyy) ");

            } else {
                //check date exist
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                dateFormat.setLenient(false);

                try {
                    Date dateInput = dateFormat.parse(input);
                    Date currentDate = new Date();
                    currentDate = dateFormat.parse(dateFormat.format(currentDate));

                    //so sanh
                    if (dateInput.before(currentDate)) {
                        System.out.println("Date input must be greater or equal current date");
                    } else {
                        return input;
                    }

                } catch (ParseException ex) {
                    System.out.println(error);
                }
            }
        }
    }

}
