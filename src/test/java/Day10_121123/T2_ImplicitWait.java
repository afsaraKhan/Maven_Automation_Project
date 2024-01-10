package Day10_121123;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class T2_ImplicitWait {
    public static void main(String[] args) {
        //set up the chromeDriver webDriverManager
        WebDriverManager.chromedriver().setup();

        //declare the ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        //define the WebDriver
        WebDriver driver = new ChromeDriver(options);

        //set up the implicit wait
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        //navigate to google site
        driver.navigate().to("https://www.google.com");

        //search for a car
        try{
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");
        }catch (Exception e){
            System.out.println("Unable to enter value on search field: " + e);
        }//end of search exception

        //click search
        try{
            driver.findElement(By.xpath("//*[@name='btnK']")).submit();
        }catch (Exception e){
            System.out.println("Unable to submit on search button: " + e);
        }//end of submit exception

        //capture the result and print it
        try{
            String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
            System.out.println("Result is: " + result);
        }catch (Exception e){
            System.out.println("Unable to capture search result: " + e);
        }//end of search result exception

        //quit the driver
        driver.quit();

    }//end of main
}//end of class
