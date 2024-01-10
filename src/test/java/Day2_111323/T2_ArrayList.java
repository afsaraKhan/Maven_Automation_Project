package Day2_111323;

import java.util.ArrayList;

public class T2_ArrayList {
    public static void main(String[] args) {
        //declare an ArrayList
        ArrayList<String> countries = new ArrayList<>();
        //adding items to the countries ArrayList
        countries.add("USA");
        countries.add("India");
        countries.add("Bangladesh");
        countries.add("Pakistan");

        //print the country Bangladesh
        System.out.println("The third country is " + countries.get(2));
        //print the size of the countries ArrayList
        System.out.println("The total size of the countries ArrayList is " + countries.size());

        //add a new country
        countries.add("Canada");
        //print the size of the countries ArrayList
        System.out.println("The total size of the countries ArrayList is " + countries.size());

        //declare an Integer ArrayList
        ArrayList<Integer> studentGrades = new ArrayList<>();
        //add values to studentGrades
        studentGrades.add(90);
        studentGrades.add(76);
        studentGrades.add(50);
        studentGrades.add(30);
        //print the grade of second student
        System.out.println("The second student's grade is " + studentGrades.get(1));

    }
}
