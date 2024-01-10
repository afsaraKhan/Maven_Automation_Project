package actionItems;

import Practice.Reusable_Methods;
import org.testng.annotations.Test;

public class OptionalAI_3 extends testBase {
    @Test
    public static void tc001_usps() {
        //navigate to usps
        driver.navigate().to("https://www.usps.com/");
        //mouse hover to business tab
        Reusable_Methods.mouseHover(driver, "//a[text()='Business']", "Business");
        //click on calculate a business price
        Reusable_Methods.click(driver, "//*[text()='Calculate a Business Price']", "calculate a business price link");
        //type the shipping date using JSE
        Reusable_Methods.sendKeysWithJSE(driver, "//*[@id='ShippingDate']", "12/31/2023", "Shipping Date");
        //click on postcards
        Reusable_Methods.click(driver, "//*[@id='option_0']", "PostCards");
        //capture the href attribute of new mailing link
        String link = Reusable_Methods.getAttribute(driver, "//a[text()='New Mailing']", "href", "New Mailing Link");
        //open a new blank tab using JSE
        Reusable_Methods.openNewTabWithURL(driver, link, "Open new Tab");
        //switch to new tab
        Reusable_Methods.switchToTabByIndex(driver,1);
        //Enter value on number of pieces
        Reusable_Methods.sendKeysWithJSE(driver , "//*[@id='NumberOfPieces']" , "3" ,"#ofPiecesBox");
        //Enter value on number of pounds
        Reusable_Methods.sendKeysWithJSE(driver , "//*[@id='Pounds']" , "5" ,"PoundBox");
        //Enter value on number of ounces
        Reusable_Methods.sendKeysWithJSE(driver , "//*[@id='Ounces']" , "3" ,"OunceBox");
    }//end of tc001_usps
}//end of class
