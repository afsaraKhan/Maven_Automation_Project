package Day3_111423;

public class T5_MultipleConditionLoop {
    public static void main(String[] args) {
        String[] fruitBasket = new String[]{"Grape", "Orange", "Apple", "Banana"};

        for (int i = 0; i < fruitBasket.length; i++) {
            // || (OR) operator operates when one of two condition is true
            if (fruitBasket[i] == "Apple" || fruitBasket[i] == "Grape") {
                System.out.println("My fruit is " + fruitBasket[i]);
            } //end of if
        }//end of first for loop

        for (int i = 0; i < fruitBasket.length; i++) {
            // && (AND) operator operates when both conditions are true
            if (fruitBasket[i] == "Apple" && fruitBasket[i] == "Grape") {
                System.out.println("xxxx");
                System.out.println("My fruit is " + fruitBasket[i]);
            } // end of if
        } //end of second for loop
    }//end of main
}//end of class
