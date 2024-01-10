package Day6_112723;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T2_ChromeOptions {
    public static void main(String[] args) throws InterruptedException {
        //set up the chromeDriver webDriverManager
        WebDriverManager.chromedriver().setup();

        //declare the ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //adding the arguments
        options.addArguments("start-maximized");
        options.addArguments("incognito");
//        options.addArguments("headless");

        //define the WebDriver
        WebDriver driver = new ChromeDriver(options);

        //navigate to googles homepage
        driver.navigate().to("https://www.yahoo.com/");

        System.out.println("Chrome opened");

        //wait 2 seconds
        Thread.sleep(3000);

        //quit the browser
        driver.quit();
    }//end of main
}//end of class
