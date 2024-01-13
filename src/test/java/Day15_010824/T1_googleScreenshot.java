package Day15_010824;

import Practice.Reusable_Methods;
import Practice.Reusable_Methods_Logger;
import Practice.testBase;
import org.testng.annotations.Test;

public class T1_googleScreenshot extends testBase {
    @Test
    public void tc001_searchForACar() throws InterruptedException {
        //navigate to google web page
        driver.navigate().to("https://www.google.com");
        //search for BMW
        Reusable_Methods_Logger.sendKeys(driver,"//*[@name= 'q']", logger, "BMW","SearchField");
        //hit submit on the Google search button
        Reusable_Methods_Logger.submit(driver,"//*[@name= 'btnK']", logger, "Submit");
    }//end of test case 1

}//end of class
