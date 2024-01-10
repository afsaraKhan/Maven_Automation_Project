package Day11_121223;

import Day10_121123.ReUsableMethods;
import org.openqa.selenium.WebDriver;

public class T2_ReusableYahoo {
    public static void main(String[] args) {
        //instantiate web driver
        WebDriver driver = ReUsableMethods.setUpDriver();

        //navigate to yahoo
        driver.navigate().to("https://www.yahoo.com");

        //click on sports tab (index 2)
        ReUsableMethods.clickByIndex(driver, "//*[contains(@class,'_yb_q22uj')]", 2, "yahoo headers");
        //quit the driver
        driver.quit();

    }//end of main
}//end of class
