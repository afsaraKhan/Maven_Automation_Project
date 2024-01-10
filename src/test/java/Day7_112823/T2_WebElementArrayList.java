package Day7_112823;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class T2_WebElementArrayList {
    public static void main(String[] args) {
        //set up the chromeDriver webDriverManager
        WebDriverManager.chromedriver().setup();

        //declare the ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        //define the WebDriver
        WebDriver driver = new ChromeDriver(options);

        //navigate to yahoo's homepage
        driver.navigate().to("https://www.yahoo.com/");

        //store multiple elements on an ArrayList
        ArrayList<WebElement> headers = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class, '_yb_yc')]")));

        //print how many elements are there
        System.out.println("The yahoo.com has " + headers.size() + " headers");

        //print all the headers text
        for(int i = 0; i< headers.size(); i++){
            System.out.println("Yahoo headers are " + headers.get(i).getText());
        }

        //quit the browser
        driver.quit();
    }//end of main
}//end of class
