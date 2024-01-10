package Day10_121123;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class T4_GoogleReusableMethods {
    public static void main(String[] args) throws InterruptedException {
        //set up the chromeDriver webDriverManager
        WebDriverManager.chromedriver().setup();

        //declare the ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        //define the WebDriver
        WebDriver driver = new ChromeDriver(options);

        //set up the explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 10);

        //navigate to google site
        driver.navigate().to("https://www.google.com");

        ReUsableMethods.click(driver, "//a[@class='gb_E' and contains(@aria-label, 'Gmail')]", "Gmail Link");

        //wait few seconds
        Thread.sleep(3000);

        //quit the driver
        driver.quit();
    }//end of main
}//end of class
