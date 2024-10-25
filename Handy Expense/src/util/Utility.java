package util;

import java.util.Scanner;

public class Utility {

    public final String DATE_VALID = "^\\d{1}|[0-3]{1}\\d{1}-[a-zA-Z]{3}-\\d{4}$";
    public final String REGEX_STRING = "[a-zA-Z0-9 ]+";
    Scanner scanner = new Scanner(System.in);

    public int getInt(String message, int min, int max) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty !!");
                } else {
                    int number = Integer.parseInt(input);
                    if (number < min && number > max) {
                        System.out.println("Out Of Range");
                    } else {
                        return number;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Incorrect format");
            }
        }
    }

    public double getDouble(String message, double min, double max) {
        while (true) {
            try {
                System.out.print(message);
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Input cannot be empty !!");
                } else {
                    double number = Double.parseDouble(input);
                    if (number < min && number > max) {
                        System.out.println("Out Of Range");
                    } else {
                        return number;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Incorrect format");
            }
        }
    }

    public String getDate(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty !!");
            } else {
                if (input.matches(DATE_VALID)) {
                    return input;
                } else {
                    System.out.println("Incorrect format");
                }
            }
        }
    }

    public String getString(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty !!");
            } else {
                if (input.matches(REGEX_STRING)) {
                    return input;
                } else {
                    System.out.println("Incorrect format");
                }
            }
        }
    }
}
