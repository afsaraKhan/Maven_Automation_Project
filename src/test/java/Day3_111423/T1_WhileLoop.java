package Day3_111423;

import java.util.ArrayList;

public class T1_WhileLoop {
    public static void main(String[] args) {
        //declare an arrayList of boroughs
        ArrayList<String> boroughs = new ArrayList<>();

        //add boroughs to the arrayList
        boroughs.add("Brooklyn");
        boroughs.add("Manhattan");
        boroughs.add("Queens");
        boroughs.add("Bronx");
        boroughs.add("State Island");

        //set the counter's initial value for a while loop
        int i = 0;
        while (i < boroughs.size()) {
            //print the index
            System.out.println("index " + i);
            //print the borough name
            System.out.println("My borough is " + boroughs.get(i));
            i++;
        }

    }
}
