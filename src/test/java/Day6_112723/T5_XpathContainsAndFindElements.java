package Day6_112723;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T5_XpathContainsAndFindElements {
    public static void main(String[] args) throws InterruptedException {
        //set up the chromeDriver webDriverManager
        WebDriverManager.chromedriver().setup();

        //declare the ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        //define the WebDriver
        WebDriver driver = new ChromeDriver(options);

        //navigate to googles homepage
        driver.navigate().to("https://www.yahoo.com/");

        //wait 2 seconds
        Thread.sleep(2000);

        //click on finance by Xpath Contains() and findElements
        driver.findElements(By.xpath("//*[contains(@class, '_yb_yc0wu')]")).get(1).click();
        //wait 2 seconds
        Thread.sleep(2000);

        //quit the browser
        driver.quit();
    }//end of main
}//end of class
