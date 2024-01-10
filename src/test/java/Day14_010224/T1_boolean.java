package Day14_010224;

import Practice.Reusable_Methods;
import actionItems.testBase;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_boolean extends testBase {
    @Test
    public static void tc001_VerifyingStaySignedInIsChecked(){
        //navigate to yahoo.com
        driver.navigate().to("https://www.yahoo.com");
        //click on Sign In button
        Reusable_Methods.click(driver, "//*[text()='Sign in']", "Sign In Button");
        //store checked option in a boolean variable
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        //print out if checkbox is selected
        System.out.println("The checkbox is checked: " + isStaySignedInChecked);
        //assert if it's true
        Assert.assertTrue(isStaySignedInChecked);

    }//end of tc001

    @Test
    public static void tc002_VerifyIfStaySignedInIsUnchecked(){
        //click on the checkbox to uncheck
        Reusable_Methods.click(driver, "//*[@class='stay-signed-in checkbox-container']", "checkbox click");
        //store checked option in a boolean variable (should be false)
        boolean isStaySignedInChecked = driver.findElement(By.xpath("//*[@id='persistent']")).isSelected();
        //print out if checkbox is selected
        System.out.println("The checkbox is checked: " + isStaySignedInChecked);
        //assert if it's false
        Assert.assertFalse(isStaySignedInChecked);
    }//end of tc002
}//end of class
