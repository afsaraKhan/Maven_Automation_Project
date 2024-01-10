package Day9_120523;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class T1_TryCatch {
    public static void main(String[] args) throws InterruptedException {
        //set up the chromeDriver webDriverManager
        WebDriverManager.chromedriver().setup();

        //declare the ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        //define the WebDriver
        WebDriver driver = new ChromeDriver(options);

        //navigating to mortgage calculator website
        driver.navigate().to("https://www.mortgagecalculator.org/");

        //wait few seconds
        Thread.sleep(1500);

        try {
            //clear and set a new home value
            WebElement homeVal = driver.findElement(By.xpath("//*[@id='homeval']"));
            homeVal.clear();
            homeVal.sendKeys("950000");
        } catch(Exception e){
            System.out.println("Unable to enter home value: " + e);
        }//end of home value try-catch

        try{
            //clear and set a new down payment value
            WebElement dPayment = driver.findElement(By.xpath("//*[@id='downpayment']"));
            dPayment.clear();
            dPayment.sendKeys("200000");
        } catch (Exception e){
            System.out.println("Unable to enter down payment: " + e);
        }//end of down payment try-catch

        //wait few seconds
        Thread.sleep(1500);

        //quit the driver
        driver.quit();


    }//end of main
}//end of class
