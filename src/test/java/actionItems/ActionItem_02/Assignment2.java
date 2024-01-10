package actionItems.ActionItem_02;

public class Assignment2 {
    public static void main(String[] args) {
        //declaring grade variable and assigning a numeric value manually
        int grade = 78;

        //determine the grade with if-elseif-else conditional statements
        if(grade >= 90 && grade <= 100){
            System.out.println("Student's Grade is: A");
        } else if(grade >= 80 && grade < 90){
            System.out.println("Student's Grade is: B");
        } else if(grade >= 70 && grade < 80){
            System.out.println("Student's Grade is: C");
        } else if(grade >= 60 && grade < 70){
            System.out.println("Student's Grade is: D");
        } else if (grade < 60 && grade >= 0) {
            System.out.println("Student's grade is : F");
        } else {
            System.out.println("Kindly set the grade variable's value to any positive number within 0-100");
        } //end of if-elseif-else

    }//end of main
}//end of class
