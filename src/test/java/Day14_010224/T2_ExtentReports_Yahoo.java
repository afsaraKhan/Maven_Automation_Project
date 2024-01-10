package Day14_010224;

import Practice.Reusable_Methods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class T2_ExtentReports_Yahoo {
    WebDriver driver;
    //declare ExtentReports variable
    ExtentReports reports;
    //declare logger variable
    ExtentTest logger;

    @BeforeSuite
    public void setupChromeDriver(){
        //set up the driver
        driver = Reusable_Methods.setUpDriver();
        //set up the report path
        reports = new ExtentReports("src/main/java/HTML_Reports/AutomationReport.html", true);
    }//end of before suite

    @Test
    public void tc001_VerifyingStaySignedInIsChecked(){
        //give the test a name
        logger = reports.startTest("tc001_VerifyingStaySignedInIsChecked");
        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com");
        //click on Sign In button
        Reusable_Methods.click(driver, "//*[text()='Sign in']", "Sign In Button");
        //use logger info to log that user clicked on Sign In
        logger.log(LogStatus.INFO, "Successfully clicked the SignIn Button");
        //store checked option in a boolean variable
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        //print out if checkbox is selected
        System.out.println("The checkbox is checked: " + isStaySignedInChecked);
        //assert if it's true
        if(isStaySignedInChecked){
            logger.log(LogStatus.PASS, "The checkbox is checked: " + isStaySignedInChecked);
        } else {
            logger.log(LogStatus.FAIL, "The checkbox is checked: " + isStaySignedInChecked);
        }
    }//end of tc001

    @AfterSuite
    public void quitDriver(){
        driver.quit();
        //flush the reports
        reports.flush();
    }//end of quitDriver

}//end of class
