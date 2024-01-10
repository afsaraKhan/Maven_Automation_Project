package Day4_112023;

public class T2_SplitCommand {
    public static void main(String[] args) {
        //declare a string with a message
        String message = "My name is John";

        //split the message with space
        String[] splitMessage = message.split(" ");

        //print out the name john
        System.out.println("The name is " + splitMessage[3]);

        //try splitting with an _
        String message2 = "Automation_01";
        String[] splitMessage2 = message2.split("_");
        System.out.println("The automation number is " + splitMessage2[1]);

    }//end of main
}//end of class
