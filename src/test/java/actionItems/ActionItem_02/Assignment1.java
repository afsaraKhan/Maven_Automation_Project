package actionItems.ActionItem_02;

import java.util.ArrayList;

public class Assignment1 {
    public static void main(String[] args) {
        //declaring regions and areaCodes ArrayList
        ArrayList<String> regions = new ArrayList<>();
        ArrayList<Integer> areaCodes = new ArrayList<>();

        //adding regions
        regions.add("New York");
        regions.add("Pennsylvania");
        regions.add("Buffalo");
        regions.add("Michigan");
        //adding areaCodes
        areaCodes.add(212);
        areaCodes.add(610);
        areaCodes.add(716);
        areaCodes.add(989);

        //using for loop to print regions with the areaCodes
        for (int i = 0; i < regions.size(); i++) {
            //printing each region along with the area code
            System.out.println("My Region is " + regions.get(i) + " and my Area Code is " + areaCodes.get(i) + ".");
        }// end of for loop

    }//end of main
}//end of class
