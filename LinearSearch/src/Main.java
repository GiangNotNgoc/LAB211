
public class Main {

    public static void main(String[] args) {
        LinearSearch linearSearch = new LinearSearch();
        
        //input number of array
        int sizeArray = linearSearch.inputNumberOfArray();
        
        //create array
        linearSearch.createArray(sizeArray);
        
        //generate random integer
        linearSearch.generateRandomNumber();
        
        //display unsorted array
        linearSearch.displayArray("Array: ");
        
        //enter search value
        int searchValue = linearSearch.inputSearchValue();
        
        //display index search number
        linearSearch.displayIndexOfSearchNumber(searchValue);
    }
}
