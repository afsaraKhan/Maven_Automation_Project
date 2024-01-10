package Day13_121923;

import Practice.Reusable_Methods;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_Google_HardAssert extends TestParent{

    @Test(priority = 1)
    public void tc001_verifyTitle() throws InterruptedException {
        //navigate to google web page
        driver.navigate().to("https://www.google.com");
        //store actual title
        String actualTitle = driver.getTitle();
        //store expectedTitle
        String expectedTitle = "Google";
        Assert.assertEquals(actualTitle, expectedTitle);
    }//end of test case 1

    @Test(priority = 2)
    public void tc002_searchForACar() throws InterruptedException {
        //navigate to google web page
        driver.navigate().to("https://www.google.com");
        //search for BMW
        Reusable_Methods.sendKeys(driver,"//*[@name= 'q']","BMW","SearchField");
        //hit submit on the Google search button
        Reusable_Methods.submit(driver,"//*[@name= 'btnK']","Submit");
    }//end of test case 1

    @Test(priority = 3)
    public void tc003_captureSearchResult(){
        //store the search result into a string variable
        String result = Reusable_Methods.getText(driver,"//*[@id = 'result-stats']","SearchResult");
        //split the result
        String[] searchResultArray = result.split(" ");
        //print out the number only
        System.out.println("Search Result Number is " + searchResultArray[1]);
        String actualSearchNumber = searchResultArray[1];
        String expectedSearchNumber = "১,৭০,০০,০০,০০০টি";
        Assert.assertEquals(actualSearchNumber, expectedSearchNumber);
    }//end of test case 2

}//end of class
