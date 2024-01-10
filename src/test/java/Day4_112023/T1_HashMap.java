package Day4_112023;

import java.util.HashMap;

public class T1_HashMap {
    public static void main(String[] args) {
        //declare a HashMap
        HashMap<String, Integer> triageStudents = new HashMap<>();

        //add values to triageStudents
        triageStudents.put("Asif", 25);
        triageStudents.put("Noor", 26);
        triageStudents.put("Justin", 27);

        //print the size of the hashMap
        System.out.println("The size of the HashMap is " + triageStudents.size());

        //print the HashMap
        System.out.println(triageStudents);

        //check Asif's age
        if(triageStudents.containsKey("Asif")){
            int asifsAge = triageStudents.get("Asif");
            System.out.println("Asif's age is " + asifsAge);
        }

        //check Afsana's age who's not it the HashMap
        System.out.println("Afsana's age is " + triageStudents.get("Afsana"));

    }//end of main
}//end of class
