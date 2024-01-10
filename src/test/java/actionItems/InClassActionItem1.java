package actionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class InClassActionItem1 {
    public static void main(String[] args) throws InterruptedException {

        //creating Array Lists
        ArrayList<String> firstName = new ArrayList<>();
        firstName.add("Amy");
        firstName.add("Jake");

        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("Santiago");
        lastName.add("Peralta");

        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11216");
        zipCode.add("10956");

        ArrayList<String> dob = new ArrayList<>();
        dob.add("11/03/1983");
        dob.add("07/24/1981");

        ArrayList<String> address = new ArrayList<>();
        address.add("1454 Atlantic Ave, Brooklyn");
        address.add("66 N Main St, New City");

        ArrayList<String> vehicleYear = new ArrayList<>();
        vehicleYear.add("2023");
        vehicleYear.add("2022");

        ArrayList<String> vehicleMake = new ArrayList<>();
        vehicleMake.add("Audi");
        vehicleMake.add("BMW");

        ArrayList<String> vehicleModel = new ArrayList<>();
        vehicleModel.add("A3 Hybrid");
        vehicleModel.add("3 Series");

        ArrayList<String> daysPerWeek = new ArrayList<>();
        daysPerWeek.add("3");
        daysPerWeek.add("4");

        ArrayList<String> miles = new ArrayList<>();
        miles.add("200");
        miles.add("300");

        ArrayList<String> gender = new ArrayList<>();
        gender.add("Female");
        gender.add("Male");

        //setup web driver manager
        WebDriverManager.chromedriver().setup();

        //setup chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        //setup chrome driver
        WebDriver driver = new ChromeDriver(options);

        //for loop for iterating
        for(int i = 0; i < firstName.size(); i++) {
            //navigate to geico's website
            driver.navigate().to("https://www.geico.com/");

            try {
                //clicking AutoCheckbox
                driver.findElement(By.xpath("//p[text()='Auto']")).click();
            } catch (Exception e){
                System.out.println("Unable to clicking Auto for reason " + e);
            }

            try {
                //clicking StartMyQuote
                driver.findElement(By.xpath("//a[text()='Start My Quote']")).click();
                //wait few seconds
                Thread.sleep(3000);
            } catch (Exception e){
                System.out.println("Unable to click StartMyQuote for reason " + e);
            }

            //enter ZipCode
            try {
                WebElement ZipCodeField = driver.findElement(By.xpath("//input[@id='bundle-modal-zip']"));
                ZipCodeField.clear();
                ZipCodeField.sendKeys(zipCode.get(i));
            } catch(Exception e){
                System.out.println("Unable to enter Zipcode for reason " + e);
            }

            try {
                //click on HomeOwners checkbox
                driver.findElements(By.xpath("//p[text()='Homeowners']")).get(2).click();
            } catch (Exception e){
                System.out.println("Unable to click HomeOwners checkbox for reason " + e);
            }

            try {
                //clicking continue button
                driver.findElement(By.xpath("//*[@value='Continue']")).click();
                //wait few seconds
                Thread.sleep(8000);
            } catch (Exception e){
                System.out.println("Unable to click continue button for reason " + e);
            }

            try {
                //Entering DOB
                driver.findElement(By.xpath("//input[contains(@id, 'Id_GiveDateOfBirth')]")).sendKeys(dob.get(i));
            } catch (Exception e){
                System.out.println("Unable to Enter DOB for reason " + e);
            }

            try {
                //clicking next
                driver.findElement(By.xpath("//button[contains(@id, 'Id_GiveDateOfBirth')]")).click();
                //wait few seconds
                Thread.sleep(8000);
            } catch (Exception e){
                System.out.println("Unable to click next button for reason " + e);
            }

            try {
                //Entering First Name
                driver.findElement(By.xpath("//*[@data-formotivid='GiveFirstName']")).sendKeys(firstName.get(i));
            } catch (Exception e){
                System.out.println("Unable to Enter First Name for reason " + e);
            }

            try {
                //Entering Last Name
                driver.findElement(By.xpath("//*[@data-formotivid='GiveLastName']")).sendKeys(lastName.get(i));
            } catch (Exception e){
                System.out.println("Unable to Enter Last Name for reason " + e);
            }

            try {
                //clicking next button
                driver.findElement(By.xpath("//button[contains(@id, 'Id_Next')]")).click();
                //wait few seconds
                Thread.sleep(8000);
            } catch (Exception e){
                System.out.println("Unable to click next for reason " + e);
            }

            try {
                //entering valid address
                driver.findElement(By.xpath("//input[contains(@id, 'Id_GiveStreet')]")).sendKeys(address.get(i));
            } catch (Exception e){
                System.out.println("Unable to Enter Address for reason " + e);
            }

            try {
                //entering apt
                driver.findElement(By.xpath("//input[contains(@id, 'Id_GiveUnitNumber')]")).sendKeys("1");
            } catch (Exception e){
                System.out.println("Unable to Enter Apt no. for reason " + e);
            }

            try {
                //clicking next button
                driver.findElement(By.xpath("//button[contains(@id, 'Id_Next')]")).click();
                //wait few seconds
                Thread.sleep(18000);
            } catch (Exception e){
                System.out.println("Unable to click next for reason " + e);
            }

            try {
                //clicking yes on radio button
                driver.findElement(By.xpath("//label[contains(@for, 'Id_IsHomeAddressActivity') and @id='labelForYes']")).click();
            } catch (Exception e){
                System.out.println("Unable to click yes on radio button for reason " + e);
            }

            try {
                //clicking next button
                driver.findElement(By.xpath("//*[contains(@id, 'Id_IsHomeAddressActivity') and @type='submit']")).click();
                //wait few seconds
                Thread.sleep(8000);
            } catch (Exception e){
                System.out.println("Unable to click next button for reason " + e);
            }

            try {
                //clicking no on radio button
                driver.findElement(By.xpath("//label[contains(@for, 'Id_YesNoIsPurchasingHome') and @id='labelForNo']")).click();
            } catch (Exception e){
                System.out.println("Unable to click no on radio button for reason " + e);
            }

            try {
                //clicking next button
                driver.findElement(By.xpath("//button[contains(@id, 'Id_Next')]")).click();
                //wait few seconds
                Thread.sleep(8000);
            } catch (Exception e){
                System.out.println("Unable to click next button for reason " + e);
            }

            try {
                //clicking yes on radio button
                driver.findElement(By.xpath("//label[contains(@for, 'Id_HasMovedRecently') and @id='labelForYes']")).click();
            } catch (Exception e){
                System.out.println("Unable to click yes on radio button for reason " + e);
            }

            try {
                //clicking next
                driver.findElement(By.xpath("//*[contains(@id, 'Id_HasMovedRecently') and @type='submit']")).click();
                //wait few seconds
                Thread.sleep(8000);
            } catch (Exception e){
                System.out.println("Unable to click next button for reason " + e);
            }

            try {
                //entering prior address
                driver.findElement(By.xpath("//input[contains(@id, 'Id_GiveStreet')]")).sendKeys(address.get(i));
            } catch (Exception e){
                System.out.println("Unable to put prior address for reason " + e);
            }

            try {
                //entering apt
                driver.findElement(By.xpath("//input[contains(@id, 'Id_GiveUnitNumber')]")).sendKeys("1");
            } catch (Exception e){
                System.out.println("Unable to put Apt no. for reason " + e);
            }

            try {
                //entering zip
                driver.findElement(By.xpath("//input[contains(@id, 'Id_GiveZip')]")).sendKeys(zipCode.get(i));
            } catch (Exception e){
                System.out.println("Unable to enter zip for reason " + e);
            }

            try {
                //clicking next button
                driver.findElement(By.xpath("//button[contains(@id, 'Id_Next')]")).click();
                //wait few seconds
                Thread.sleep(8000);
            } catch (Exception e){
                System.out.println("Unable to click next button for reason " + e);
            }

            try {
                //clicking no on have VIN
                driver.findElement(By.xpath("//label[contains(@for, 'Id_YesNoPreQuoteHaveFullVinActivity') and @id='labelForNo']")).click();
            } catch (Exception e){
                System.out.println("Unable to click no on Have Vin for reason " + e);
            }

            try {
                //clicking next button
                driver.findElement(By.xpath("//button[contains(@id, 'Id_YesNoPreQuoteHaveFullVinActivity') and @type='submit']")).click();
                //wait few seconds
                Thread.sleep(8000);
            } catch (Exception e){
                System.out.println("Unable to click next button for reason " + e);
            }

            try {
                //select year of vehicle
                WebElement vehicleYearList = driver.findElement(By.xpath("//select[contains(@id, 'Id_GiveYear')]"));
                Select vehicleYearDropdown = new Select(vehicleYearList);
                vehicleYearDropdown.selectByVisibleText(vehicleYear.get(i));
                //wait few seconds
                Thread.sleep(3000);
            } catch (Exception e){
                System.out.println("Unable to Select year for reason " + e);
            }

            try {
                //select vehicle maker
                WebElement vehicleMakerList = driver.findElement(By.xpath("//select[contains(@id, 'Id_GiveMake')]"));
                Select vehicleMakerDropdown = new Select(vehicleMakerList);
                vehicleMakerDropdown.selectByVisibleText(vehicleMake.get(i));
                //wait few seconds
                Thread.sleep(3000);
            } catch (Exception e){
                System.out.println("Unable to select vehicle maker for reason " + e);
            }

            try {
                //select vehicle model
                WebElement vehicleModelList = driver.findElement(By.xpath("//select[contains(@id, 'Id_GiveModel')]"));
                Select vehicleModelDropdown = new Select(vehicleModelList);
                vehicleModelDropdown.selectByVisibleText(vehicleModel.get(i));
            } catch (Exception e){
                System.out.println("Unable to select vehicle model for reason " + e);

            }

            try {
                //clicking next
                driver.findElement(By.xpath("//button[contains(@id, 'Id_Next')]")).click();
                //wait few seconds
                Thread.sleep(8000);
            } catch (Exception e){
                System.out.println("Unable to click next button for reason " + e);
            }

            try {
                //selecting leased radio button
                driver.findElement(By.xpath("//label[contains(@for, 'Id_GiveVehicleOwnerShip') and @id='labelForL']")).click();
            } catch (Exception e){
                System.out.println("Unable to click leased radio button for reason " + e);
            }

            try {
                //clicking next
                driver.findElement(By.xpath("//button[contains(@id, 'Id_GiveVehicleOwnerShip') and @type='submit']")).click();
                //wait few seconds
                Thread.sleep(8000);
            } catch (Exception e){
                System.out.println("Unable to click next button for reason " + e);
            }

            try {
                //clicking on commute radio btn
                driver.findElement(By.xpath("//label[contains(@for, 'Id_GiveVehiclePrimaryUse') and @id='labelForC']")).click();
            } catch (Exception e){
                System.out.println("Unable to click commute radio button for reason " + e);
            }

            try {
                //clicking next
                driver.findElement(By.xpath("//button[contains(@id, 'Id_GiveVehiclePrimaryUse') and @type='submit']")).click();
                //wait few seconds
                Thread.sleep(8000);
            } catch ( Exception e){
                System.out.println("Unable to click next button for reason " + e);
            }

            try {
                //select days per week dropdown
                WebElement daysPerWeekList = driver.findElement(By.xpath("//select[contains(@id, 'Id_GiveMake')]"));
                Select daysPerWeekListDropdown = new Select(daysPerWeekList);
                daysPerWeekListDropdown.selectByVisibleText(daysPerWeek.get(i));
            } catch (Exception e){
                System.out.println("Unable to select days per week dropdown for reason " + e);
            }

            try {
                //enter miles
                driver.findElement(By.xpath("//input[contains(@id, 'Id_GiveMilesOneWay')]")).sendKeys(miles.get(i));
            } catch (Exception e){
                System.out.println("Unable to enter miles for reason " + e);
            }

            try {
                //clicking next
                driver.findElement(By.xpath("//button[contains(@id, 'Id_Next')]")).click();
                //wait few seconds
                Thread.sleep(8000);
            } catch (Exception e){
                System.out.println("Unable to click next for reason " + e);
            }

            try {
                //clicking next
                driver.findElement(By.xpath("//button[contains(@id, 'Id_GiveAnnualMileage') and @type='submit']")).click();
                //wait few seconds
                Thread.sleep(8000);
            } catch (Exception e){
                System.out.println("Unable to click next for reason " + e);
            }

            try {
                //select not yet purchase radio button
                driver.findElement(By.xpath("//label[contains(@for, 'Id_GiveLengthOfOwnership') and @id='labelFor1']")).click();
            } catch (Exception e){
                System.out.println("Unable to select not yet purchase radio button for reason " + e);
            }

            try {
                //clicking next
                driver.findElement(By.xpath("//button[contains(@id, 'Id_GiveLengthOfOwnership') and @type='submit']")).click();
                //wait few seconds
                Thread.sleep(8000);
            } catch (Exception e){
                System.out.println("Unable to click next for reason " + e);
            }

            try {
                //clicking next again
                driver.findElement(By.xpath("//button[contains(@id, 'Id_Continue') and @type='submit']")).click();
                //wait few seconds
                Thread.sleep(8000);
            } catch (Exception e){
                System.out.println("Unable to click next for reason " + e);
            }

            try {
                //select gender on dropdown
                WebElement genderList = driver.findElement(By.xpath("//select[contains(@id, 'Id_GiveMake')]"));
                Select genderListDropdown = new Select(genderList);
                genderListDropdown.selectByVisibleText(gender.get(i));
            } catch (Exception e){
                System.out.println("Unable to select gender on dropdown for reason " + e);
            }

            try {
                //clicking agree and continue
                driver.findElement(By.xpath("//button[contains(@id, 'Id_ComboActivity') and @type='submit']")).click();
                //wait few seconds
                Thread.sleep(8000);
            } catch (Exception e){
                System.out.println("Unable to click agree and continue for reason " + e);
            }
        }

        Thread.sleep(3000);
        //quit driver
        driver.quit();

    }//end of main
}//end of class
