package Day13_121923;

import Practice.Reusable_Methods;
import org.testng.annotations.Test;

public class T1_Google_Inheritance extends TestParent {

    @Test
    public void tc001_searchForACar() throws InterruptedException {
        //navigate to google web page
        driver.navigate().to("https://www.google.com");
        //search for BMW
        Reusable_Methods.sendKeys(driver,"//*[@name= 'q']","BMW","SearchField");
        //hit submit on the Google search button
        Reusable_Methods.submit(driver,"//*[@name= 'btnK']","Submit");
    }//end of test case 1

    @Test(dependsOnMethods = "tc001_searchForACar")
    public void tc002_captureSearchResult(){
        //store the search result into a string variable
        String result = Reusable_Methods.getText(driver,"//*[@id = 'result-stats']","SearchResult");
        //split the result
        String[] searchResultArray = result.split(" ");
        //print out the number only
        System.out.println("Search Result Number is " + searchResultArray[1]);
    }//end of test case 2

}//end of class
