package Day3_111423;

public class T4_ConditionsWithLoop {
    public static void main(String[] args) {
        String[] fruitBasket = new String[]{"Grape", "Orange", "Apple", "Banana"};

        //pick out Apple from the basket/Array
        //start loop to check all items in basket/Array
        for(int i = 0; i < fruitBasket.length; i++) {
            // '==' double equal sign is a comparison operator
            // '=' single equal sign assigns value  to variables
            if (fruitBasket[i] == "Apple") {
                System.out.println("An apple a day keep doctor away");
            } //end of if
            else if (fruitBasket[i] == "Grape") {
                System.out.println("My fruit is " + fruitBasket[i]);
            }//end of else if
        }//end of for loop
    }//end of main
}// end of class
