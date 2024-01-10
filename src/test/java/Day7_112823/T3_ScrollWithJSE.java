package Day7_112823;

import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.swing.interop.DispatcherWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T3_ScrollWithJSE {
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
        driver.navigate().to("https://www.mlcalc.com/");

        //declare the javascript executor
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //scroll down
        jse.executeScript("scroll(0, 800)");
        //wait 2 seconds
        Thread.sleep(2000);
        //scroll up
        jse.executeScript("scroll(0, -400)");
        //wait 2 seconds
        Thread.sleep(2000);

        //store the Calculate button in an WebElement
        WebElement calcBtn = driver.findElement(By.xpath("//*[@value='Calculate']"));
        //scroll to a specific element
        jse.executeScript("arguments[0].scrollIntoView(true)", calcBtn);


        //wait 2 seconds
        Thread.sleep(2000);

        //quit the browser
        driver.quit();

    }//end of main
}//end of class
