package Day2_111323;

import java.util.ArrayList;

public class T3_ForLoop {
    public static void main(String[] args) {

        //declare an ArrayList
        ArrayList<String> countries = new ArrayList<>();
        //adding items to the countries ArrayList
        countries.add("USA");
        countries.add("India");
        countries.add("Bangladesh");
        countries.add("Pakistan");

        //for loop to print all the countries
        for (int i = 0; i < countries.size(); i++) {
            //print out i to see which iteration we are in
            System.out.println(" we are in iteration " + i);
            //print out all the countries
            System.out.println("The country is " + countries.get(i));
        } // end of for loop

        //Declaring Integer ArrayList
        ArrayList<Integer> studentGrades = new ArrayList<>();
        studentGrades.add(30);
        studentGrades.add(50);
        studentGrades.add(90);
        studentGrades.add(70);

        //USing for loop to print the ArrayList
        for (int i = 0; i < studentGrades.size(); i++) {
            System.out.println("The number of student " + (i + 1) + " is : " + studentGrades.get(i));
        }

    }//end of main

}//end of class
