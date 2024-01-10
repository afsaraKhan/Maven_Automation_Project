package Day8_120423;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T3_HandlingTabs {
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
        driver.navigate().to("https://www.fideliscare.org/");

        //wait few seconds
        Thread.sleep(1500);

        //click on Shop For a Plan button
        driver.findElement(By.xpath("//*[text()='Shop For a Plan']")).click();

        //wait few seconds
        Thread.sleep(1000);

        //click on Shop for a Plan button from dropdown
        driver.findElement(By.xpath("//*[text()='Shop for a Plan']")).click();

        //click on Search button under Find a Doctor Section
        driver.findElements(By.xpath("//*[@href='/Find-A-Doctor']")).get(0).click();

        //wait few seconds
        Thread.sleep(1500);

        //to switch to the new opened tab declare an ArrayList to store the tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());

        //switch to new tab
        driver.switchTo().window(tabs.get(1));

        //put zip code on search location field
        driver.findElement(By.xpath("//*[@id='searchLocation']")).sendKeys("19082");

        //wait few seconds
        Thread.sleep(1000);

        //close the new tab
        driver.close();

        //switch back to previous tab
        driver.switchTo().window(tabs.get(0));

        //click on other Find a Doctor button at the bottom
        driver.findElements(By.xpath("//*[@href='/Find-A-Doctor']")).get(1).click();

        //wait few seconds
        Thread.sleep(1500);

        //quit the driver
        driver.quit();

    }//end of main
}//end of class
