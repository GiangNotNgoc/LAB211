
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ApH3lios
 */
public class ManageFruit {

    ArrayList<Fruit> fruitList = new ArrayList<>();
    Utility utility = new Utility();
    void mockData(){
        fruitList.add(new Fruit("1", "1", 1, 100, "A"));
        fruitList.add(new Fruit("2", "2", 1, 100, "B"));
        fruitList.add(new Fruit("3", "3", 1, 100, "C"));
        fruitList.add(new Fruit("4", "4", 1, 100, "D"));
    }
    void createFruit() {
        while (true) {
            //enter attribute
            String id, name;
            double price;
            int quantity;
            String origin;
            while (true) {
                id = utility.getString("Enter ID: ", "Wrong", utility.REGEX_STRING);
                if (checkDuplicate(id)) {
                    System.out.println("Duplicate!");
                } else {
                    break;
                }
            }
            name = utility.getString("Enter name: ", "Wrong", utility.REGEX_STRING);
            price = utility.getDouble("Enter price: ", "Wrong", "Wrong", "Wrong", 0, Double.MAX_VALUE);
            quantity = utility.getInt("Enter quantity: ", "Wrong", "Wrong", "Wrong", 0, Integer.MAX_VALUE);
            origin = utility.getString("Enter origin: ", "Wrong", utility.REGEX_STRING);

            Fruit fruit = new Fruit(id, name, price, quantity, origin);
            fruitList.add(fruit);

            if (!checkYesNo()) {
                break;
            }
        }
        displayListFruit(fruitList);
    }

    private boolean checkDuplicate(String id) {
        for (Fruit fruit : fruitList) {
            if (fruit.getId().equalsIgnoreCase(id)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkYesNo() {
        String result = utility.getString("Do you want to countinue(Y/N)? ", "Wrong", utility.REGEX_YN);
        if (result.equalsIgnoreCase("y")) {
            return true;
        } else {
            return false;
        }
    }

    public void displayListFruit(ArrayList<Fruit> fruitList) {
        System.out.format("%-15s %-15s %-15s %-15s %-15s\n","item","name","price","quantity","origin");
        for (Fruit fruit : fruitList) {
            System.out.println(fruit);
        }
    }

    void shopping() {
        if (fruitList.isEmpty()) {
            System.out.println("empty!");
            return;
        }
        displayListFruit(fruitList);
        //enter item and display item
        Fruit fruitChoice;
        while (true) {            
        String item = utility.getString("Enter item: ", "Wrong", utility.REGEX_STRING);
        fruitChoice = getFruitById(item);
        //null => wrong item
        //yes => display
            if (fruitChoice == null) {
                System.out.println("Wrong item");
            } else {
                System.out.println("You selected: "+fruitChoice.getName());
                break;
            }
        }
        //enter quantity
        int quantityOrder = utility.getInt("Enter Quantity: ", "Wrong", "Wrong", "Wrong", 0, fruitChoice.getQuantity());
        //set quantity
        fruitChoice.setQuantity(fruitChoice.getQuantity()-quantityOrder);
        
        if (fruitChoice.getQuantity() == 0){
            fruitList.remove(fruitChoice);
        }
        
        Fruit fruitOrder = new Fruit(fruitChoice.getId(),fruitChoice.getName(),fruitChoice.getPrice(),quantityOrder,fruitChoice.getOrigin());
        //add fruit order to invoice
        Invoice invoice = new Invoice();
        invoice.addFruit(fruitOrder);
    }

    private Fruit getFruitById(String item) {
        for (Fruit fruit : fruitList) {
            if (fruit.getId().equalsIgnoreCase(item)) {
                return fruit;
            }
        }
        return null;
    }

}
