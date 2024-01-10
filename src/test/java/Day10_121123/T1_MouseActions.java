package Day10_121123;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class T1_MouseActions {
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
        driver.navigate().to("https://www.usps.com/");

        //wait few seconds
        Thread.sleep(1000);

        //setup Actions for mouse actions
        Actions mouseActions = new Actions(driver);

        //find quick tools element
        WebElement quickTool = driver.findElement(By.xpath("//*[text()='Quick Tools']"));
        //move the mouse to an element(hover over on an element): i.e., quick tools
        mouseActions.moveToElement(quickTool).perform();

        //find an element: track a package
        WebElement trackPackage = driver.findElement(By.xpath("//*[text()='Track a Package']"));
        mouseActions.moveToElement(trackPackage).click().perform();

        //wait few seconds
        Thread.sleep(1000);

        //find the textarea, click on it, enter tracking code
        //textarea tag requires to click on it first. Then we can use sendKeys
        WebElement textBox = driver.findElement(By.xpath("//*[@id='tracking-input']"));
        mouseActions.moveToElement(textBox).click().sendKeys("111222333").perform();


        //wait few seconds
        Thread.sleep(3000);
        //quit driver
        driver.quit();
    }//end of main
}//end of class

