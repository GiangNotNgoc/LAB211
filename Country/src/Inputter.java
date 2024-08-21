
import java.util.Scanner;

public class Inputter {
    public static int getInteger(String msg, int min, int max){
        Scanner sc = new Scanner(System.in);
        int data;
        while(true){
            try {
                System.out.println(msg);
                String input = sc.nextLine();
                if(input.isEmpty()){
                    System.out.println("Can not blank!");
                }else{
                    data = Integer.parseInt(input);
                    if(data >= min && data <= max){
                        return data;
                    }else{
                        System.out.println("You must enter between " + min + 
                                " to " +  max);
                    }
                }
            } catch (Exception e) {
                System.out.println("Please enter integer number!");
            }
            
        }
    }
    public static String getString(String msg, String regex){
        Scanner sc = new Scanner(System.in);
        while (true) {   
            System.out.println(msg);
            String input = sc.nextLine();
            if(input.isEmpty()){
                System.out.println("Can not blank!");
            }else{
                if(input.matches(regex)){
                    return input;
                }else{
                    System.out.println("Please enter string!");
                }
            }
        }
    }
    
    public static float getFloat(String msg, float min, float max){
        Scanner sc = new Scanner(System.in);
        float data;
        while(true){
            try {
                System.out.println(msg);
                String input = sc.nextLine();
                if(input.isEmpty()){
                    System.out.println("Can not blank!");
                }else{
                    data = Float.parseFloat(input);
                    if(data >= min && data <= max){
                        return data;
                    }else{
                        System.out.println("You must enter between " + min + 
                                " to " +  max);
                    }
                }
            } catch (Exception e) {
                System.out.println("Please enter number!");
            }
            
        }
    }
}
