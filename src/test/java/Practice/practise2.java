package Practice;

import org.testng.annotations.Test;

public class practise2 extends testBase {
    @Test
    public static void tc01(){
        //navigate
        driver.navigate().to("https://www.fideliscare.org");
        //click on search
        Reusable_Methods.click(driver,"//*[@class='tool dropdown search']//following::a[1]","Search");
        //Enter 'get dental coverage' on search
        Reusable_Methods.sendKeys(driver,"//*[@class='form-control search-input']","get dental coverage","searchBox");
        //click search icon
        Reusable_Methods.click(driver,"//*[@class='btn btn-primary btn-search']","searchIcon");
        //capture search result
        String Result = Reusable_Methods.getText(driver,"//*[@class='gsc-result-info']","searchResult");
        //split & print the number
        String[] resultArr = Result.split(" ");
        System.out.println("The Search Result Number is : " + resultArr[1]);
        //click on get dental coverage link
        Reusable_Methods.click(driver,"//*[text()='Get Dental Coverage']","dentalCoverageLink");
    }//end of tc01

    @Test(dependsOnMethods = "tc01")
    public static void tc02(){
        //switch to tab by index
        Reusable_Methods.switchToTabByIndex(driver, 1);
        Reusable_Methods.sendKeys(driver,"//*[@id='firstName']", "Roysa","FirstNameBox");
        Reusable_Methods.sendKeys(driver,"//*[@id='lastName']", "Khan","LastNameBox");
        Reusable_Methods.sendKeys(driver,"//*[@id='zipCode']", "19082","ZipCodeBox");
        Reusable_Methods.selectByVisibleText(driver,"//*[@id='county']" , "Delaware" , "SelectCounty");
        Reusable_Methods.sendKeys(driver,"//*[@id='phoneNumber']", "4656767953","PhoneNumberBox");
        Reusable_Methods.sendKeys(driver,"//*[@id='email']", "roysa@gmail.com","EmailBox");
        Reusable_Methods.click(driver,"//*[@for='contactMe']","ClickCheckBox");
        Reusable_Methods.click(driver,"//*[@class='btn btn-primary' and @type='submit']","contactMeBtn");
        String ThankUtxt = Reusable_Methods.getText(driver,"//*[@class='alert alert-success']" ,"ThankTouText");
        System.out.println(ThankUtxt);
        driver.close();
    }//end of tc02

    @Test
    public static void tc03(){
        
    }
}//end of class
