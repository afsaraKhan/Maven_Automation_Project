package Day3_111423;

public class T3_MultipleConditionalStatements {
    public static void main(String[] args) {
        //declare some int values
        int a = 34, b = 2, c = 23;

        //start of conditional statement
        if (a + b > c) {
            System.out.println("Sum of a and b is greater than c");
        } else if (a + b < c) {
            System.out.println("Sum of a and b is lesser than c");
        } else {
            System.out.println("a and b are equal");
        }
    } // end of main
} // end of class
