package actionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class ActionItem_03 {
    public static void main(String[] args) throws InterruptedException {
        //declaring an ArrayList with 5 countries
        ArrayList<String> countries = new ArrayList<>();
        //adding countries to the ArrayList
        countries.add("Bangladesh");
        countries.add("USA");
        countries.add("India");
        countries.add("Spain");
        countries.add("Argentina");

        //set up the chromeDriver webDriverManager
        WebDriverManager.chromedriver().setup();
        //define the WebDriver
        WebDriver driver = new ChromeDriver();

        //using for loop to iterate through the ArrayList
        for(int i = 0; i < countries.size(); i++){
            //navigate to Bing.com
            driver.navigate().to("https://www.bing.com/");
            //maximize the window
            driver.manage().window().maximize();

            //wait for 2 seconds
            Thread.sleep(2000);

            //sending a country name on bing's search bar
            driver.findElement(By.xpath("//*[@id='sb_form_q']")).sendKeys(countries.get(i));
            //hit submit on bing's search button
            driver.findElement(By.xpath("//*[@id='search_icon']")).submit();

            //wait for 2 seconds
            Thread.sleep(2000);

            //capturing the search result message
            String searchResult = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();
            //splitting the text
            String[] searchResultArray = searchResult.split(" ");
            //print the search result number of each country
            System.out.println("Search number for " + countries.get(i) + " is " + searchResultArray[1]);
        }//end of for loop

        //quitting the driver
        driver.quit();

    }//end of main
}//end of class
