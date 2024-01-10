package Day11_121223;

import Day10_121123.ReUsableMethods;
import org.openqa.selenium.WebDriver;

public class T1_ReusableMetlife {
    public static void main(String[] args) throws InterruptedException {
        //instantiate the driver
        WebDriver driver = ReUsableMethods.setUpDriver();

        //navigate to metlife website
        driver.navigate().to("https://www.metlife.com");

        //click on solutions tab
        ReUsableMethods.click(driver, "//*[@aria-controls='section1']", "Solutions Tab");
        //click on dental tab
        ReUsableMethods.click(driver, "//*[text()='Dental']", "Dental Tab");

        //wait 2 seconds
        Thread.sleep(2000);

        //quit the driver
        driver.quit();

    }//end of main
}//end of class
