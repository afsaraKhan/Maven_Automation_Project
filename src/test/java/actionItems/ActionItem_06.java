package actionItems;

import Day13_121923.TestParent;
import Practice.Reusable_Methods;
import org.testng.annotations.Test;

public class ActionItem_06 extends TestParent {

    @Test(priority = 1)
    public static void tc001() throws InterruptedException {
        //navigate to fideliscare.org
        driver.navigate().to("https://www.fideliscare.org");
        //click on search
        Reusable_Methods.click(driver, "//div[@class='tool dropdown search']", "Search");
        //enter 'get dental coverage' on search box
        Reusable_Methods.sendKeys(driver, "//input[contains(@class, 'search-input')]", "get dental coverage", "Search Box");
        //click on search icon
        Reusable_Methods.click(driver, "//button[@aria-label='Execute Search']", "Search Icon");
        //get search result
        String searchResultText = Reusable_Methods.getText(driver, "//div[@class='gsc-result-info']", "Search Result Text");
        //split the text and print search result number
        String[] searchResultTextArray = searchResultText.split(" ");
        String searchResultNumber = searchResultTextArray[1];
        System.out.println("Search Result Number: " + searchResultNumber);
        //click on 'Get Dental Coverage'
        Reusable_Methods.click(driver, "//*[text()='Get Dental Coverage']", "Get Dental Coverage link");
        //Thread.sleep(3000);
    }//end of tc001

    @Test(priority = 2)
    public static void tc002(){
        //switch to the newly opened tab
        Reusable_Methods.switchToTabByIndex(driver, 1);
        //scroll
        //Enter first name
        Reusable_Methods.sendKeys(driver, "//input[@id='firstName']", "Afsara", "First Name");
        //Enter last name
        Reusable_Methods.sendKeys(driver, "//input[@id='lastName']", "Khan", "Last Name");
        //Enter Zip Code
        Reusable_Methods.sendKeys(driver, "//input[@id='zipCode']", "19082", "Zip Code");
        //Select County
        Reusable_Methods.selectByVisibleText(driver, "//*[@id='county']", "Wayne", "County");
        //Input phone number
        Reusable_Methods.sendKeys(driver, "//input[@id='phoneNumber']", "2105442828", "Phone Number");
        //Enter email
        Reusable_Methods.sendKeys(driver, "//input[@id='email']", "abc@gmail.com", "Email");
        //tick the checkbox
        Reusable_Methods.click(driver, "//input[@id='contactMe']//following::label", "Checkbox");
        //click the contact me button
        Reusable_Methods.click(driver, "//button[text()='Contact Me']", "Click Me button");
        //capture the message and print it out
        String message = Reusable_Methods.getText(driver, "//div[@class='alert alert-success']", "thank you message");
        System.out.println("The entire message: " + message);
        //close the current tab
        driver.close();
    }//end of tc002

    @Test(priority = 3)
    public static void tc003() throws InterruptedException {
        //Thread.sleep(3000);
        //switch back to default tab
        Reusable_Methods.switchToTabByIndex(driver, 0);
        //click on login
        Reusable_Methods.click(driver, "//*[@class='dropdown-toggle']", "Login Button");
        Thread.sleep(1000);
        //click on Member Online Portal
        Reusable_Methods.click(driver, "//*[text()='Member Online Portal']", "Member Online Portal Link");
        Thread.sleep(3000);
        //switch to the  new tab
        Reusable_Methods.switchToTabByIndex(driver, 1);
        String text = Reusable_Methods.getText(driver, "//*[@id='dnn_ctr5328_HtmlModule_lblContent']", "Helpful Hints");
        System.out.println("The Entire Text: " + text);
        //close current tab
        driver.close();
    }//end of tc003

}//end of class
