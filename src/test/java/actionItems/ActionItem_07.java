package actionItems;

import Practice.Reusable_Methods_Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.HashMap;

public class ActionItem_07 extends testBase{
    public static HashMap<String, String> planDetails = new HashMap<>();
    @Test(priority = 1)
    public static void tc001_fillUpBasicInformation() throws InterruptedException {
        //navigate to anthem.com
        driver.navigate().to("https://www.anthem.com/");
        //click on “Insurance Plans” button
        Reusable_Methods_Logger.click(driver, "//a[@href='#InsurancePlans']", logger, "Insurance Plans link");
        //Click on “Individual and Family plans”
        Reusable_Methods_Logger.click(driver, "//a[@class='nav-item' and @href='/individual-and-family']", logger, "Individual and Family plans link");
        Thread.sleep(1000);
        //Click on “Shop Plans” button under “Health Insurance”
        Reusable_Methods_Logger.click(driver, "//*[@data-analytics-name='Health Insurance - Shop Plans']", logger, "Shop Plans button");
        //switch to the newly opened tab
        Reusable_Methods_Logger.switchToTabByIndex(driver, logger, 1);
        //enter zip code 10004
        Reusable_Methods_Logger.sendKeys(driver, "//input[@id='demographics.zip5']", logger, "10004", "ZipCode");
        Thread.sleep(1000);
        //click on “Show me only Dental with optional Vision Plans” radio button
        Reusable_Methods_Logger.click(driver,"//input[@id='onlyDental']", logger, "Show me only Dental with optional Vision Plans radio button");
        //click on “Richer Benefits” radio button
        Reusable_Methods_Logger.click(driver, "//input[@id='richerBenefits']", logger, "Richer Benefits radio button");
        //Give first name: Afsara
        Reusable_Methods_Logger.sendKeys(driver, "//input[@id='demographics.applicants0.firstName']", logger, "Afsara", "First Name");
        //Give date of birth: 12/27/1987
        Reusable_Methods_Logger.sendKeys(driver, "//input[@id='demographics.applicants0.dob']", logger, "12/27/1987", "Date of Birth");
        //click on “Applicant Only” radio button
        Reusable_Methods_Logger.click(driver, "//input[@id='ApplicantOnly']", logger, "Applicant Only radio button");
        //Click “Continue” button
        Reusable_Methods_Logger.click(driver, "//input[@id='button/shop/getaquote/next']", logger, "Continue Button");
        //click “skip this step” on bundle plans
        Reusable_Methods_Logger.click(driver, "//a[@id='skipStepToDental']", logger, "Skip this step link");
    }//end of tc001_fillUpBasicInformation

    @Test(priority = 2)
    public static void tc002_selectDentalPlan_addMyDentist(){
        //click on “Show me my dentist”
        Reusable_Methods_Logger.click(driver, "//span[text()='Show me my dentist']", logger, "Show me my dentist link");
        //enter dentists name “CHARLES E. HASHIM”
        Reusable_Methods_Logger.sendKeys(driver, "//input[@id='doctorsName']", logger, "CHARLES E. HASHIM", "DoctorName");
        //select located within “2 miles”
        Reusable_Methods_Logger.selectByVisibleText(driver, "//select[@id='distanceInMiles']", logger, "2 miles", "Located Within Dropdown");
        //click on "search" Button
        Reusable_Methods_Logger.click(driver, "//span[text()='Search']", logger, "Search button");
        //click the checkbox beside the doctor’s name  on “Dentist Name Match”
        Reusable_Methods_Logger.click(driver, "//input[@id='providerRow_0_check']", logger, "CheckBox");
        //click on “Add Dentist to my List” button
        Reusable_Methods_Logger.click(driver, "//span[text()='Add dentists to my list']", logger, "Add Dentist to my List button");
        //click on “Match dentists to listed plans” button
        Reusable_Methods_Logger.click(driver, "//span[text()='Match dentists to listed plans']", logger, "Match dentists to listed plans button");
    }//end of tc002_selectDentalPlan_addMyDentist

    @Test(priority = 3)
    public static void tc003_selectDentalPlan_getDentalPlanData(){
        //Capture the plan name and store
        String planName = Reusable_Methods_Logger.getText(driver, "//a[@id='dental:hypertext/shop/addothercoverage/planname_1']", logger, "First Dental Plan Name");
        planDetails.put("Dental Plan Name", planName);
        //Capture the monthly plan cost and store
        String planCost = Reusable_Methods_Logger.getText(driver, "//div[contains(@class, 'planRate')]", logger, "First Dental Plan cost").split(" ")[0];
        //Assert if dental plan price is $8.96
        Assert.assertEquals(planCost, "$8.96");
        planDetails.put("Dental Plan Cost", planCost);
        //click “Select” on the first plan of the list and store
        Reusable_Methods_Logger.click(driver, "//div[@class='selectButton']", logger, "Select Button");
    }//end of tc003_selectDentalPlan_getDentalPlanData

    @Test(priority = 4)
    public static void tc004_selectVisionPlan_addMyEyeDoctor(){
        //click on “Show me my eye doctor”
        Reusable_Methods_Logger.click(driver, "//span[text()='Show me my eye doctor']", logger, "Show me my eye doctor link");
        //enter dentists name “JACOB NACHUM OD PC”
        Reusable_Methods_Logger.sendKeys(driver, "//input[@id='doctorsName']", logger, "JACOB NACHUM OD PC", "EyeDoctorName");
        //check the “Optician” checkbox from specialties
        Reusable_Methods_Logger.click(driver, "//span[text()='Optician']", logger, "Optician check box");
        //Select “Materials” from Services dropdown
        Reusable_Methods_Logger.selectByVisibleText(driver, "//select[@id='servicesIn']", logger, "Materials(Frames, Lenses and Contacts)", "Materials");
        //select located within “2 miles”
        Reusable_Methods_Logger.selectByVisibleText(driver, "//select[@id='distanceInMiles']", logger, "2 miles", "Miles");
        //click on "search" Button
        Reusable_Methods_Logger.click(driver, "//span[text()='Search']", logger, "Search button");
        //click the checkbox beside the doctor’s name on “Eye Doctor Name Match”
        Reusable_Methods_Logger.click(driver, "//input[@id='providerRow_0_check']", logger, "CheckBox");
        //click on “Add Eye doctors to my List” button
        Reusable_Methods_Logger.click(driver, "//span[text()='Add eye doctors to my list']", logger, "Add Eye Doctors to my List button");
        //click on “Match eye doctors to listed plans” button
        Reusable_Methods_Logger.click(driver, "//span[text()='Match eye doctor to Listed plans']", logger, "Match eye doctors to listed plans button");
    }//end of tc004_selectVisionPlan_addMyEyeDoctor

    @Test(priority = 5)
    public static void tc005_selectVisionPlan_getVisionPlanData(){
        //Capture the first plan name
        String planName = Reusable_Methods_Logger.getText(driver, "//a[@id='dental:hypertext/shop/addothercoverage/planname_1']", logger, "First Vision Plan Name");
        planDetails.put("Vision Plan Name", planName);
        //Capture the monthly plan cost
        String planCost = Reusable_Methods_Logger.getText(driver, "//div[contains(@class, 'planRate')]", logger, "First Vision Plan cost").split(" ")[0];
        //Assert if vision plan price is $7.21
        Assert.assertEquals(planCost, "$7.21");
        planDetails.put("Vision Plan Cost", planCost);
        //click “Select” on the first plan of the list
        Reusable_Methods_Logger.click(driver, "//div[@class='selectButton']", logger, "Select Button");
    }

    @Test(priority = 6)
    public static void tc006_getFinalCost(){
        //store the total monthly cost
        String totalPlanCost = Reusable_Methods_Logger.getText(driver, "//div[@class='topMargin5 left width150 textCenter hgt68px']", logger, "Total Plan Cost").split(" ")[0];
        planDetails.put("Total Plan Cost", totalPlanCost);
        //print all the captured plan details along with total cost
        System.out.println("Full Plan Details: ");
        planDetails.forEach((key, value) -> System.out.println(key + " : " + value));
    }
}//end of class
