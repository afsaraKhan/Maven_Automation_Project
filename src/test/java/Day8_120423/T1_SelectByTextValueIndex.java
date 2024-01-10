package Day8_120423;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class T1_SelectByTextValueIndex {
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

        //wait few second
        Thread.sleep(3000);

        //clear and set a new home value
        WebElement homeVal = driver.findElement(By.xpath("//*[@id='homeval']"));
        homeVal.clear();
        homeVal.sendKeys("500000");

        //clear and set a new down payment value
        WebElement dPayment = driver.findElement(By.xpath("//*[@id='downpayment']"));
        dPayment.clear();
        dPayment.sendKeys("7500");

        //select a different start month using Select by Visible Text method
        //store the dropdown element in a webElement
        WebElement monthList = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        //define the Select element
        Select startMonth = new Select(monthList);
        //select the month feb by visible text
        startMonth.selectByVisibleText("Feb");
        Thread.sleep(2000);
        //select the month dec by visible text
        startMonth.selectByVisibleText("Dec");

        //wait few seconds
        Thread.sleep(5000);
        //quit the driver
        driver.quit();

    }//end of main
}//end of class
