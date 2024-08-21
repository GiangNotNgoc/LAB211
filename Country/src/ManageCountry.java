
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ManageCountry {

    public void displayMenu() {
        System.out.println("                               MENU\n"
                + "==========================================================================\n"
                + "1. Input the information of 11 countries in East Asia\n"
                + "2. Display the information of country you've just input\n"
                + "3. Search the information of country by user-entered name\n"
                + "4. Display the information of countries sorted name in ascending order  \n"
                + "5. Exit \n"
                + "========================================================================== ");
    }

    public void addCountry(ArrayList<EastAsiaCountry> countryList) {
        //check 11 countries
        if (countryList.size() > 10) {
            System.out.println("Enough countries!");
            return;
        }
        String name, code;
        //code
        while (true) {
            code = Inputter.getString("Enter code of country: ", "[A-Za-z0-9 ]+");
            //check dupplicate code
            if (checkDupplicateCode(code, countryList)) {
                System.out.println("Code is dupplicate");
            } else {
                break;
            }
        }
        //name
        while (true) {
            name = Inputter.getString("Enter name of country: ", "[A-Za-z0-9 ]+");
            //check dupplicate
            if (checkDupplicateName(name, countryList)) {
                System.out.println("Name is dupplicate");
            } else {
                break;
            }
        }
        //area
        float area = Inputter.getFloat("Enter total Area: ", 1, Float.MAX_VALUE);
        //terrain
        String terrain = Inputter.getString("Enter terrain of country: ", "[A-Za-z0-9 ]+");

        EastAsiaCountry eastAsiaCountry = new EastAsiaCountry(code, name, area, terrain);

        countryList.add(eastAsiaCountry);
    }

    public boolean checkDupplicateCode(String code, ArrayList<EastAsiaCountry> countryList) {
        for (EastAsiaCountry eastAsiaCountry : countryList) {
            if (eastAsiaCountry.getCode().compareToIgnoreCase(code) == 0) {
                return true; // dupplicate
            }
        }
        return false;
    }

    public boolean checkDupplicateName(String name, ArrayList<EastAsiaCountry> countryList) {
        for (EastAsiaCountry eastAsiaCountry : countryList) {
            if (eastAsiaCountry.getName().compareToIgnoreCase(name) == 0) {
                return true; // dupplicate
            }
        }
        return false;
    }

    void displayCountryJustInput(ArrayList<EastAsiaCountry> countryList) {
        int lastIndex = countryList.size() - 1;
        if (lastIndex < 0) {
            return;
        }
        System.out.format("%-16s %-16s %-16s %-16s\n", "ID", "Name", "Total Area", "Terrain");
        EastAsiaCountry country = countryList.get(lastIndex);
        country.display();
    }

    void searchByName(ArrayList<EastAsiaCountry> countryList) {

        String sName = Inputter.getString("Enter the name you want to search for: ",
                "[A-Za-z0-9 ]+");

        ArrayList<EastAsiaCountry> searchList = new ArrayList<>();
        for (EastAsiaCountry eastAsiaCountry : countryList) {
            if (eastAsiaCountry.getName().toUpperCase().contains(sName.toUpperCase())) {
                searchList.add(eastAsiaCountry);
            }
        }
        //not found
        if (searchList.isEmpty()) {
            System.out.println("Not found");
        } else {
            System.out.format("%-16s %-16s %-16s %-16s\n", "ID", "Name", "Total Area", "Terrain");
            //display
            for (EastAsiaCountry eastAsiaCountry : searchList) {
                eastAsiaCountry.display();
            }
        }
    }

    void sortCountryByName(ArrayList<EastAsiaCountry> countryList) {
        ArrayList<EastAsiaCountry> sortList = new ArrayList<>();
        sortList.addAll(countryList);
        // Using a bubble sort algorithm to sort the list by name
        for (int i = 0; i < sortList.size() - 1; i++) {
            for (int j = 0; j < sortList.size() - 1 - i; j++) {
                if(sortList.get(j).getName().compareToIgnoreCase(sortList.get(j+1).getName())>0){
                    EastAsiaCountry temp = sortList.get(j);
                    sortList.set(j, sortList.get(j+1));
                    sortList.set(j+1, temp);
                           
                }
            }
        }

        System.out.format("%-16s %-16s %-16s %-16s\n", "ID", "Name", "Total Area", "Terrain");
        for (EastAsiaCountry eastAsiaCountry : sortList) {
            eastAsiaCountry.display();
        }
    }

}
