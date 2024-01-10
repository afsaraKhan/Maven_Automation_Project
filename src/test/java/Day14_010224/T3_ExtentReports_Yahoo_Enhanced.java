package Day14_010224;

import Practice.Reusable_Methods;
import Practice.Reusable_Methods_Logger;
import Practice.testBase;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class T3_ExtentReports_Yahoo_Enhanced extends testBase {
    @Test
    public void tc001_VerifyingStaySignedInIsChecked(){
        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com");
        //click on Sign In button
        Reusable_Methods_Logger.click(driver, "//*[text()='Sign in']", logger, "Sign In Button");
        //store checked option in a boolean variable
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        //print out if checkbox is selected
        System.out.println("The checkbox is checked: " + isStaySignedInChecked);
        Reusable_Methods_Logger.isConditionTrue(isStaySignedInChecked, logger);
    }//end of tc001

    @Test
    public void tc002_testtingGitHub() {
        //practice committing
    }
}//end of class
