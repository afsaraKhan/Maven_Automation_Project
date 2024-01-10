package actionItems;

import Practice.Reusable_Methods;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class testBase {
    //declare driver
    public static WebDriver driver;
    //declare ExtentReports variable
    public static ExtentReports reports;
    //declare ExtentTest logger variable
    public static ExtentTest logger;

    //setup chrome driver
    @BeforeSuite
    public static void setupChromeDriver(){
        //set up driver
        driver = Reusable_Methods.setUpDriver();
        //setup report path
        reports = new ExtentReports("src/main/java/HTML_Reports/AutomationReport.html", true);
    }

    @BeforeMethod
    public static void setTestName(Method methodName){
        //set the methodName
        logger = reports.startTest(methodName.getName());
    }

    @AfterMethod
    public static void endTest(){
        //end the test logger
        reports.endTest(logger);
    }

    //quit driver
    @AfterSuite
    public static void quitDriver(){
        //quit the driver
        driver.quit();
        //generate final report
        reports.flush();
    }

}//end of class

