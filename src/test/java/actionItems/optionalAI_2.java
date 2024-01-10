package actionItems;

import Practice.Reusable_Methods;
import org.testng.annotations.Test;

public class optionalAI_2 extends testBase{
    @Test
    public static void tc001_OptionalAI2() throws InterruptedException {
        //navigate to demoqa
        driver.navigate().to("https://demoqa.com/buttons");
        //automate double click
        Reusable_Methods.mouseDoubleClick(driver, "//*[@id='doubleClickBtn']" , "doubleClickButton");
        //automate right click
        Reusable_Methods.mouseRightClick(driver, "//*[@id='rightClickBtn']" , "rightClickButton");
        //navigate to demoqa uploadDownload
        driver.navigate().to("https://demoqa.com/upload-download");
        //upload file
        Reusable_Methods.upload(driver , "//*[@id='uploadFile']" , "C:\\fakepath\\sampleFile.jpeg" , "upload");
    }//end of tc001_OptionalAI2 method
}//end of class
