package Day5_112123;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_GoogleSearchTest {
    public static void main(String[] args) throws InterruptedException {
        //set up the chromeDriver webDriverManager
        WebDriverManager.chromedriver().setup();

        //define the WebDriver
        WebDriver driver = new ChromeDriver();

        //navigate to googles homepage
        driver.navigate().to("https://www.google.com/");

        //maximize the window
        driver.manage().window().maximize();

        //wait for 2 seconds
        Thread.sleep(2000);

        //search for caRS
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");
        //hit submit on Google search button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();

        //store the result in a string variable
        String searchResult = driver.findElement(By.xpath("//*[@id = 'result-stats']")).getText();
        //print the search result number only by splitting the text
        String[] searchResultArray = searchResult.split(" ");
        System.out.println("Search result number is: " + searchResultArray[1]);


        //quiting the driver
        driver.quit();
    }//end of main
}
