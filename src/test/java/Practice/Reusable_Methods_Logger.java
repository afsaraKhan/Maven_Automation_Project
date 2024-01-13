package Practice;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Reusable_Methods_Logger {
    //setUpDriver: a reusable-method for set up web driver
    public static WebDriver setUpDriver(){
        //set up the chromeDriver webDriverManager
        WebDriverManager.chromedriver().setup();

        Map<String,Object> preferences= new HashMap<>();
        preferences.put("profile.default_content_settings.popups", 0);
        String downloadPath =  System.getProperty("user.dir")+ File.separator+"DownloadFolder"+File.separator;
        preferences.put("download.default_directory",downloadPath);

        //declare the ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        options.setExperimentalOption("prefs",preferences);

        // instead of writing "WebDriver driver = new ChromeDriver(options)",
        // we can declare and return the instance of WebDriver directly
        return new ChromeDriver(options);
    }// end of setUpDriver

    //click method
    public static void click(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 30);

        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
            logger.log(LogStatus.PASS, "Clicked on " + elementName);
        } catch (Exception e){
            System.out.println("Unable to access " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to click on " + elementName);
            //attach screenshot if click method fails
            getScreenShot(driver, elementName, logger);
        }
    }//end of click method

    //clickByIndex method
    public static void clickByIndex(WebDriver driver , String xpath, ExtentTest logger, int index, String elementName){
        WebDriverWait wait = new WebDriverWait(driver , 30);
        try{
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
            logger.log(LogStatus.PASS, "Clicked on " + index + "th " + elementName);
        }catch(Exception e){
            System.out.println("Unable to access " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Failed to Click on " + index + "th " + elementName);
            //attach screenshot if clickByIndex method fails
            getScreenShot(driver, elementName, logger);
        }
    }

    //submit: a reusable-method for submit on any web element
    public static void submit(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
            logger.log(LogStatus.PASS, "Submit on " + elementName);
        } catch (Exception e){
            System.out.println("Unable to access " + elementName + " for reason :" + e );
            logger.log(LogStatus.FAIL, "Failed to Submit on " + elementName);
            //attach screenshot if submit method fails
            getScreenShot(driver, elementName, logger);
        }
    }//end of submit method

    //sendKeys method
    public static void sendKeys(WebDriver driver , String xpath, ExtentTest logger, String keys , String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        try {
            WebElement textField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            textField.clear();
            textField.sendKeys(keys);
            logger.log(LogStatus.PASS, "Entered "+ keys + "to " + elementName + " textField");
        }catch(Exception e){
            System.out.println("Unable to access " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Failed to enter "+ keys + "to " + elementName+ " textField");
            //attach screenshot if sendKeys method fails
            getScreenShot(driver, elementName, logger);
        }
    }// end of senKeys method

    //getText method
    public static String getText(WebDriver driver , String xpath, ExtentTest logger, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        String text = "";
        try {
            text = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).getText();
            logger.log(LogStatus.PASS, "getText successful from " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to access " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "getText failed from " + elementName);
        }
        return text;
    }

    //selectByVisibleText method
    public static void selectByVisibleText(WebDriver driver, String xpath, ExtentTest logger, String text, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 30);

        try{
            WebElement list = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropdown = new Select(list);
            dropdown.selectByVisibleText(text);
            logger.log(LogStatus.PASS, "Selected " + text + " option from " + elementName);
        }catch (Exception e){
            System.out.println("Unable to access " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Failed to Select " + text + " option from " + elementName);

        }
    }


    //scrollToElement method
    public static void scrollToElement(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jse.executeScript("arguments[0].scrollIntoView(true)", element);
            logger.log(LogStatus.PASS, "Scrolled to "+ elementName);
        }catch (Exception e){
            System.out.println("Unable to access " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Failed to scroll to"+ elementName);
        }
    }

    //mouseHover method
    public static void mouseHover(WebDriver driver , String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver ,30);

        try {
            Actions mouseActions = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            mouseActions.moveToElement(element).perform();
            logger.log(LogStatus.PASS, "Hover on "+ elementName);
        }catch (Exception e){
            System.out.println("Unable to access " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Failed to hover on "+ elementName);
        }
    }


    //mouseClick method
    public static void mouseClick(WebDriver driver , String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver ,30);

        try {
            Actions mouseActions = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            mouseActions.moveToElement(element).click().perform();
            logger.log(LogStatus.PASS, "Clicked my mouse on"+ elementName);
        }catch (Exception e){
            System.out.println("Unable to access " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Failed to click by mouse on "+ elementName);
        }
    }//end of mouseClick method

    //switchToTabByIndex
    public static void switchToTabByIndex(WebDriver driver, ExtentTest logger, int index){
        try{
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(index));
            logger.log(LogStatus.PASS, "Switched tab");
        }catch (Exception e){
            System.out.println("Unable to switch tab for reason: " + e);
            logger.log(LogStatus.FAIL, "Unable to switch tab");
        }
    }// end of switchToTabByIndex method

    //scrollByPixel
    public static void scrollByPixel(WebDriver driver, String pixel, ExtentTest logger){
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(0, "+ pixel +")");
            logger.log(LogStatus.PASS, "Scrolled by "+ pixel + " pixel");
        }catch (Exception e){
            System.out.println("Unable to scroll by pixel for reason: " + e);
            logger.log(LogStatus.PASS, "Failed to Scroll by "+ pixel + " pixel");
        }
    }

    //sendKeysWithJSE
    public static void sendKeysWithJSE(WebDriver driver, String xpath, ExtentTest logger, String keys, String elementName){
        WebDriverWait wait = new WebDriverWait(driver ,30);

        try{
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebElement textBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jse.executeScript("arguments[0].value='" + keys + "';", textBox);
            logger.log(LogStatus.PASS, "Entered "+ keys + " on " + elementName);
        } catch (Exception e){
            System.out.println("Unable to send keys with JSE for reason: " + e);
            logger.log(LogStatus.FAIL, "Failed to Enter "+ keys + " on " + elementName);
            //attach screenshot if sendKeysWithJSE method fails
            getScreenShot(driver, elementName, logger);
        }
    }//end of sendKeysWithJSE method

    //getAttribute
    public static String getAttribute(WebDriver driver, String xpath, ExtentTest logger, String attributeName, String elementName){
        WebDriverWait wait = new WebDriverWait(driver ,30);
        String value = "";
        try{
            value = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).getAttribute(attributeName);
            logger.log(LogStatus.PASS, "Get "+ value + " from " + elementName);
        }catch (Exception e){
            System.out.println("Unable to access "+ elementName +"'s "+attributeName+" for reason: " + e);
            logger.log(LogStatus.FAIL, "Failed to Get value from " + elementName);
        }
        return value;
    }//end of getAttribute method

    //openNewTabWithURL
    public static void openNewTabWithURL(WebDriver driver, String url, ExtentTest logger, String elementName){

        try{
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.open('"+url+"')");
            logger.log(LogStatus.PASS, "Opened new tab by url");
        } catch (Exception e){
            System.out.println("Unable to access "+ elementName +" for reason: " + e);
            logger.log(LogStatus.FAIL, "Failed to Open new tab by url");

        }
    }//end of openNewTabWithURL method

    //click with JSE
    public static void clickWithJSE(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver ,30);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click();", element);
            logger.log(LogStatus.PASS, "Clicked on "+elementName);
        }
        catch(Exception e){
            System.out.println("Unable to click" + elementName + "with JSE for reason: " + e);
            logger.log(LogStatus.PASS, "Failed to Click on "+ elementName);
            //attach screenshot if clickWithJSE method fails
            getScreenShot(driver, elementName, logger);
        }
    }//end of click with JSE method

    //mouseDoubleClick
    public static void mouseDoubleClick(WebDriver driver , String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver ,30);

        try {
            Actions mouseActions = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            mouseActions.doubleClick(element).perform();
            logger.log(LogStatus.PASS, "Double Clicked on "+ elementName);
        }catch (Exception e){
            System.out.println("Unable to double click " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Failed to double Click on "+ elementName);
            //attach screenshot if mouseDoubleClick method fails
            getScreenShot(driver, elementName, logger);
        }
    }//end of mouseDoubleClick method

    //mouseRightClick
    public static void mouseRightClick(WebDriver driver , String xpath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver ,30);

        try {
            Actions mouseActions = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            mouseActions.contextClick(element).perform();
            logger.log(LogStatus.PASS, "Clicked on "+ elementName);
        }catch (Exception e){
            System.out.println("Unable to double click " + elementName + " for reason: " + e);
            logger.log(LogStatus.FAIL, "Failed to click on "+elementName);
            //attach screenshot if mouseRightClick method fails
            getScreenShot(driver, elementName, logger);
        }
    }//end of mouseRightClick method


    //upload
    public static void upload(WebDriver driver, String xpath ,String filePath, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver ,30);
        try{
            WebElement uploadElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            uploadElement.sendKeys(filePath);
            logger.log(LogStatus.PASS, "Upload Successful");
        }
        catch(Exception e){
            System.out.println("Unable to upload " + elementName + " for reason: " + e);
            logger.log(LogStatus.PASS, "Upload Unsuccessful");
        }

    }//end of upload file method

    //check isConditionTrue or not
    public static void isConditionTrue(boolean b, ExtentTest logger){
        if(b){
            logger.log(LogStatus.PASS, "The condition is " + true);
        } else{
            logger.log(LogStatus.FAIL, "The condition is " + false);
        }
    }//end of isConditionTrue

    //getScreenshot method
    public static void getScreenShot(WebDriver driver, String imageName, ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Reports/Screenshots/";
            snPath = "Screenshots//";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error occurred while taking SCREENSHOT!!!");
            e.printStackTrace();
        }
    }//end of getScreenshot method

}//end of class
