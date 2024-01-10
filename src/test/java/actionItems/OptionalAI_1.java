package actionItems;

import Practice.Reusable_Methods;
import org.testng.annotations.Test;

public class OptionalAI_1 extends testBase{
    @Test
    public static void tc001_optionalAI_1() throws InterruptedException {
       //navigate to fidelis Care
        driver.navigate().to("https://www.fideliscare.org/");
        //click on shop for a plan
        Reusable_Methods.clickWithJSE(driver, "//*[@id='root-3']" , "ShopforaPLanButton");
        //click on medicaid manage care
        Reusable_Methods.clickWithJSE(driver,  "//*[text()='Medicaid Managed Care']" , "MedicaidManageCareButton");
        //capture Medeicaid manage care link
        String URL = Reusable_Methods.getAttribute(driver, "//*[text()='Medicaid Managed Care']", "href", "MedicaidManagedCareLink");
        //open new tab with captured Medeicaid manage care link
        Reusable_Methods.openNewTabWithURL(driver, URL , "MedicaidManagedCareURL");

        Thread.sleep(5000);

    }//end of tc001_optionalAI_1 method
}//end of class
