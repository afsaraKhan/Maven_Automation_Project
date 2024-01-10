package Day3_111423;

import java.util.ArrayList;

public class T6_EnhancedForLoop {
    public static void main(String[] args) {
        //declare an ArrayList
        ArrayList<String> Cities = new ArrayList<>();
        Cities.add("New York");
        Cities.add("Dhaka");
        Cities.add("Helsinki");
        Cities.add("Paris");

        //write an enhanced for loop/ for-each loop to iterate the ArrayList
        for(String cityName: Cities){
            System.out.println(cityName);
        }
    }//end of main
}//end of class
