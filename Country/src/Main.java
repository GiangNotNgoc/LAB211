
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        ManageCountry view = new ManageCountry();
        ArrayList<EastAsiaCountry> countryList = new ArrayList<>();
        while (true) {
            //display menu
            view.displayMenu();
            //select option
            int option = Inputter.getInteger("Enter option: ", 1, 5);
            //call method
            switch (option) {
                case 1://input the infomation of 11 countries in East Asia
                    view.addCountry(countryList);
                    break;
                case 2:////Display the information of country you've just input
                    view.displayCountryJustInput(countryList);
                    break;
                case 3://Search the information of country by user-entered name
                    view.searchByName(countryList);
                    break;
                case 4://Display the information of countries sorted name in ascending order
                    view.sortCountryByName(countryList);
                    break;
                case 5://Exit
                    System.exit(0);
            }
        }

    }

    
}
