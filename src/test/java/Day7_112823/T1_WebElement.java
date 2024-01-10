package Day7_112823;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_WebElement {
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
        driver.navigate().to("https://www.mortgagecalculator.org");

        //declare an WebElement variable to store homevalue
        WebElement homeValue = driver.findElement(By.xpath("//*[@id='homeval']"));
        //clear the existing value and send 900000 on the homevalue field
        homeValue.clear();
        homeValue.sendKeys("900000");

        //wait 2 seconds
        Thread.sleep(2000);

        //quit the driver
        driver.quit();

    }//end of main
}//end of class
