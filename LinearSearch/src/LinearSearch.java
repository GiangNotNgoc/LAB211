
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class LinearSearch {

    private int[] array;

    int inputNumberOfArray() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter number of array: ");
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.err.println("Input cannot be emty");
                } else {
                    int number = Integer.parseInt(input);
                    //chack number in range
                    if (number >= 0 && number <= Integer.MAX_VALUE) {
                        return number;
                    }
                }
            } catch (Exception e) {
                System.err.println("must be a number");
            }
        }
    }

    void createArray(int sizeArray) {
        array = new int[sizeArray];
    }

    void generateRandomNumber() {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomNumber = random.nextInt(array.length);
            array[i] = randomNumber;
        }
    }

    void displayArray(String message) {
        System.out.print(message + "[");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");

        }
        System.out.print(array[array.length - 1]);
        System.out.println("]");
    }

    int inputSearchValue() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Enter search number: ");
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.err.println("Input cannot be emty");
                } else {
                    int number = Integer.parseInt(input);
                    //chack number in range
                    if (number >= Integer.MIN_VALUE && number <= Integer.MAX_VALUE) {
                        return number;
                    }
                }
            } catch (Exception e) {
                System.err.println("must be a number");
            }
        }
    }

    void displayIndexOfSearchNumber(int searchValue) {
        //search
        List<Integer> list = searchByLinearSearch(searchValue);
        //display

        //if =-1 => not found
        if (list.isEmpty()) {
            System.out.println("Not found");
        } else {
            System.out.println("Index is: " + list.toString());
        }
    }

    private List<Integer> searchByLinearSearch(int searchValue) {
        //array list
        List<Integer> list = new ArrayList<>();
        //lap tung phan tu
        for (int i = 0; i < array.length; i++) {
            int element = array[i];
            //kiem tra
            if (element == searchValue) {
                //co thi tra ve index
                list.add(i);
            }
        }
        return list;
    }
}
