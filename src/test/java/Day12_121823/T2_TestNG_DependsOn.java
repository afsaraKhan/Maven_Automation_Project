package Day12_121823;

import Day10_121123.ReUsableMethods;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T2_TestNG_DependsOn {
    WebDriver driver;

    @BeforeSuite
    public void setUpChromeDriver() {
        driver = ReUsableMethods.setUpDriver();
    }//end of before suite

    @Test
    public void tc001_searchForACar() throws InterruptedException {
        //navigate to google web page
        driver.navigate().to("https://www.google.com");
        //search for BMW
        ReUsableMethods.sendKeys(driver,"//*[@name= 'q']","BMW","SearchField");
        //hit submit on the google search button
        ReUsableMethods.submit(driver,"//*[@name= 'btnK']","Submit");
    }//end of test case 1

    @Test(dependsOnMethods = "tc001_searchForACar")
    public void tc002_captureSearchResult(){
        //store the search result into a string variable
        String result = ReUsableMethods.getText(driver,"//*[@id = 'result-stats']","SearchResult");
        //split the result
        String[] searchResultArray = result.split(" ");
        //print out the number only
        System.out.println("Search Result Number is " + searchResultArray[1]);
    }//end of test case 2

    @AfterSuite
    public void quitDriver(){
        driver.quit();
    }//end of after suite
}//end of class
