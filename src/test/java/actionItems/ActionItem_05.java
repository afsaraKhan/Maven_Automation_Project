package actionItems;

import Day10_121123.ReUsableMethods;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class ActionItem_05 {
    public static void main(String[] args) throws InterruptedException {
        //declaring ArrayList to store and add 3 zipcodes
        ArrayList<String> zipCodes = new ArrayList<>();
        zipCodes.add("19082");
        zipCodes.add("90001");
        zipCodes.add("10008");

        //calling setUpDriver reusable-method to set up web driver
        WebDriver driver = ReUsableMethods.setUpDriver();

        //for loop to iterate the steps
        for(int i = 0; i < zipCodes.size(); i++){
            //printing iteration number for better viewing the output
            System.out.println("------------> Iteration : " + i + " <----------------");
            System.out.println(" ");

            //navigate to weight watchers
            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");

            //clicking on 'Find a Workshop' button
            ReUsableMethods.click(driver, "//*[text()='Find a Workshop']", "Find a Workshop");
            //clicking on 'In Person' link
            ReUsableMethods.click(driver, "//*[text() = 'In-Person']", "In Person");

            //sending the zipcode to the searchBar
            ReUsableMethods.sendKeys(driver, "//*[@id='location-search']", zipCodes.get(i), "Search Bar");
            //finding the arrow-submit button using contains()
            ReUsableMethods.submit(driver, "//*[contains(@class, 'button primary')]", "Arrow Submit");

            //clicking to the specific studio links according to the given conditions
            if(i == 0){
                ReUsableMethods.clickByIndex(driver, "//*[contains(@class, 'wrapperLink-2NobU')]", 1, "2nd Studio Link");
            }
            else if(i == 1){
                ReUsableMethods.clickByIndex(driver, "//*[contains(@class, 'wrapperLink-2NobU')]", 2, "3rd Studio Link");
            }
            else if(i == 2){
                ReUsableMethods.clickByIndex(driver, "//*[contains(@class, 'wrapperLink-2NobU')]", 0, "1st Studio Link");
            }

            //store the address in a variable and then print
            String address = ReUsableMethods.getText(driver, "//*[@class='address-2PZwW']", "Address");
            System.out.println(">>>>Address for iteration-" + i + " : " + address);
            System.out.println(" ");

            //scroll into 'In-Person Workshops'
            ReUsableMethods.scrollIntoElement(driver, "//*[contains(@class, 'scheduleContainerMobile')]", "In-Person Workshops Table");
            Thread.sleep(1000);

            //print the table
            String table = ReUsableMethods.getText(driver, "//*[contains(@class, 'scheduleContainerMobile')]", "In-Person Workshop Table");
            System.out.println(">>>>Table for iteration-" + i + " : " + table);
            //adding extra empty lines to distinguish between each iteration's output
            System.out.println(" ");
            System.out.println(" ");
        }//end of for loop

        //quit the browser
        driver.quit();

    }//end of main
}//end of class
