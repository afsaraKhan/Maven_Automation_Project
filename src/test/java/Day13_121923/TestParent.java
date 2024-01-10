package Day13_121923;

import Practice.Reusable_Methods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestParent {
    //declare a global public driver variable
    public static WebDriver driver;

    @BeforeSuite
    public void setUpChromeDriver() {
        driver = Reusable_Methods.setUpDriver();
    }//end of before suite

    @AfterSuite
    public void quitDriver(){
        driver.quit();
    }//end of after suite

}//end of Test Parent class
