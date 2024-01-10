package Day6_112723;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class T1_GoogleSearchForLoop {
    public static void main(String[] args) throws InterruptedException {
        //set up the chromeDriver webDriverManager
        WebDriverManager.chromedriver().setup();

        //define the WebDriver
        WebDriver driver = new ChromeDriver();

        //navigate to googles homepage
        driver.navigate().to("https://www.google.com/");

        //maximize the window
        driver.manage().window().maximize();

        //declare an ArrayList
        ArrayList<String> carBrands = new ArrayList<>();
        carBrands.add("BMW");
        carBrands.add("Mercedes");
        carBrands.add("Toyota");

        //add a loop to iterate the ArrayList
        for(int i = 0; i < carBrands.size(); i++) {
            //search for caRS
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(carBrands.get(i));
            //hit submit on Google search button
            driver.findElement(By.xpath("//*[@name='btnK']")).submit();
            //wait for 2 seconds
            Thread.sleep(2000);
            //store the result in a string variable
            String searchResult = driver.findElement(By.xpath("//*[@id = 'result-stats']")).getText();
            //print the search result number only by splitting the text
            String[] searchResultArray = searchResult.split(" ");
            System.out.println("Search result number for " + carBrands.get(i) + " is: " + searchResultArray[1]);
        }

        //quiting the driver
        driver.quit();
    }//end of main
}//end of class
