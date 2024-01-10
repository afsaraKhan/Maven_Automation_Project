package Day4_112023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T3_GoogleSearch {
    public static void main(String[] args) throws InterruptedException {
        //set up the chromeDriver webDriverManager
        WebDriverManager.chromedriver().setup();

        //define the WebDriver
        WebDriver driver = new ChromeDriver();

        //navigate to googles homepage
        driver.navigate().to("https://www.google.com/");

        //maximize the window
        driver.manage().window().maximize();

        //wait for 3 seconds
        Thread.sleep(3000);


        //quiting the driver
        driver.quit();
    }//end of main
}//end of class
