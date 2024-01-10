package actionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class ActionItem_04 {
    public static void main(String[] args) throws InterruptedException {
        //declaring ArrayList to store and add 3 zipcodes
        ArrayList<String> zipCodes = new ArrayList<>();
        zipCodes.add("19082");
        zipCodes.add("90001");
        zipCodes.add("10008");

        //set up the ChromeDriver WebDriverManager
        WebDriverManager.chromedriver().setup();
        //using ChromeOptions to set the browser maximized & incognito
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //define the WebDriver with options
        WebDriver driver = new ChromeDriver(options);

        //for loop to iterate the steps
        for(int i = 0; i < zipCodes.size(); i++){
            //printing iteration number for better viewing the output
            System.out.println("------------> Iteration : " + i + " <----------------");
            System.out.println(" ");

            //navigate to weight watchers
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");
            //wait 3 seconds
            Thread.sleep(3000);

            //clicking on 'Find a Workshop' button
            driver.findElement(By.xpath("//*[text()='Find a Workshop']")).click();
            //clicking on 'In Person' link
            driver.findElement(By.xpath("//*[text() = 'In-Person']")).click();
            //wait 3 seconds
            Thread.sleep(3000);

            //storing the searchBar in a WebElement
            WebElement searchBar = driver.findElement(By.xpath("//*[@id='location-search']"));
            searchBar.clear(); //clearing the searchbar
            searchBar.sendKeys(zipCodes.get(i)); //passing the zipCode
            //finding the arrow-submit button using contains()
            driver.findElement(By.xpath("//*[contains(@class, 'button primary')]")).submit();
            //wait 5 seconds
            Thread.sleep(5000);

            //storing all the studio links in an ArrayList of WebElement
            ArrayList<WebElement> studioLinks = new ArrayList<>(driver.findElements(By.xpath("//*[contains(@class, 'wrapperLink-2NobU')]")));

            //if conditions
            if(i == 0){
                studioLinks.get(1).click();
            }
            else if(i == 1){
                studioLinks.get(2).click();
            }
            else if(i == 2){
                studioLinks.get(0).click();
            }
            //wait 3 seconds
            Thread.sleep(3000);

            //store the address in a variable and then print
            String address = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
            System.out.println(">>>>Address for iteration-" + i + " : " + address);
            System.out.println(" ");

            //scroll into 'In-Person Workshops'
            //declare JavascriptExecutor
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            //find the 'In-Person Workshops' table element and store it in a WebElement
            WebElement table =  driver.findElement(By.xpath("//*[contains(@class, 'scheduleContainerMobile')]"));
            //scrolling to the start of the table
            jse.executeScript("arguments[0].scrollIntoView(true)", table);
            //wait 3 seconds
            //Thread.sleep(3000);
            //print the table
            System.out.println(">>>>Table for iteration-" + i + " : " + table.getText());
            //adding extra empty lines to distinguish between each iteration's output
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
        }//end of for loop

        //quit the browser
        driver.quit();

    }//end of main
}//end of class
