package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class Reusable_Methods {
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
    public static void click(WebDriver driver, String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 30);

        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
        } catch (Exception e){
            System.out.println("Unable to access " + elementName + " for reason: " + e);
        }
    }//end of click method

    //clickByIndex method
    public static void clickByIndex(WebDriver driver , String xpath , int index, String elementName){
        WebDriverWait wait = new WebDriverWait(driver , 30);
        try{
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
        }catch(Exception e){
            System.out.println("Unable to access " + elementName + " for reason: " + e);
        }
    }

    //submit: a reusable-method for submit on any web element
    public static void submit(WebDriver driver, String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
        } catch (Exception e){
            System.out.println("Unable to access " + elementName + " for reason :" + e );
        }
    }//end of submit method

    //sendKeys method
    public static void sendKeys(WebDriver driver , String xpath , String keys , String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        try {
            WebElement textField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            textField.clear();
            textField.sendKeys(keys);
        }catch(Exception e){
            System.out.println("Unable to access " + elementName + " for reason: " + e);
        }
    }// end of senKeys method

    //getText method
    public static String getText(WebDriver driver , String xpath , String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        String text = "";
        try {
             text = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).getText();
        } catch (Exception e) {
            System.out.println("Unable to access " + elementName + " for reason: " + e);
        }
        return text;
    }

    //selectByVisibleText method
    public static void selectByVisibleText(WebDriver driver, String xpath,String text, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 30);

        try{
            WebElement list = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select dropdown = new Select(list);
            dropdown.selectByVisibleText(text);
        }catch (Exception e){
            System.out.println("Unable to access " + elementName + " for reason: " + e);
        }
    }


    //scrollToElement method
    public static void scrollToElement(WebDriver driver, String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        JavascriptExecutor jse = (JavascriptExecutor) driver;

        try{
           WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
           jse.executeScript("arguments[0].scrollIntoView(true)", element);
        }catch (Exception e){
            System.out.println("Unable to access " + elementName + " for reason: " + e);
        }
    }

    //mouseHover method
    public static void mouseHover(WebDriver driver , String xpath , String elementName){
        WebDriverWait wait = new WebDriverWait(driver ,30);

        try {
            Actions mouseActions = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            mouseActions.moveToElement(element).perform();
        }catch (Exception e){
            System.out.println("Unable to access " + elementName + " for reason: " + e);
        }
    }


    //mouseClick method
    public static void mouseClick(WebDriver driver , String xpath , String elementName){
        WebDriverWait wait = new WebDriverWait(driver ,30);

        try {
            Actions mouseActions = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            mouseActions.moveToElement(element).click().perform();
        }catch (Exception e){
            System.out.println("Unable to access " + elementName + " for reason: " + e);
        }
    }//end of mouseClick method

    //switchToTabByIndex
    public static void switchToTabByIndex(WebDriver driver, int index){
        try{
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(index));
        }catch (Exception e){
            System.out.println("Unable to switch tab for reason: " + e);
        }
    }// end of switchToTabByIndex method

    //scrollByPixel
    public static void scrollByPixel(WebDriver driver, String pixel){
        try {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(0, "+ pixel +")");
        }catch (Exception e){
            System.out.println("Unable to scroll by pixel for reason: " + e);
        }
    }

    //sendKeysWithJSE
    public static void sendKeysWithJSE(WebDriver driver, String xpath, String keys, String elementName){
        WebDriverWait wait = new WebDriverWait(driver ,30);

        try{
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            WebElement textBox = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jse.executeScript("arguments[0].value='" + keys + "';", textBox);
        } catch (Exception e){
            System.out.println("Unable to send keys with JSE for reason: " + e);
        }
    }//end of sendKeysWithJSE method

    //getAttribute
    public static String getAttribute(WebDriver driver, String xpath, String attributeName, String elementName){
        WebDriverWait wait = new WebDriverWait(driver ,30);
        String value = "";
        try{
            value = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).getAttribute(attributeName);
        }catch (Exception e){
            System.out.println("Unable to access "+ elementName +"'s "+attributeName+" for reason: " + e);
        }
        return value;
    }//end of getAttribute method

    //openNewTabWithURL
    public static void openNewTabWithURL(WebDriver driver, String url, String elementName){

        try{
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.open('"+url+"')");
        } catch (Exception e){
            System.out.println("Unable to access "+ elementName +" for reason: " + e);

        }
    }//end of openNewTabWithURL method

    //click with JSE
    public static void clickWithJSE(WebDriver driver, String xpath , String elementName){
        WebDriverWait wait = new WebDriverWait(driver ,30);
        try{
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("arguments[0].click();", element);
        }
        catch(Exception e){
            System.out.println("Unable to click" + elementName + "with JSE for reason: " + e);
        }
    }//end of click with JSE method

    //mouseDoubleClick
    public static void mouseDoubleClick(WebDriver driver , String xpath , String elementName){
        WebDriverWait wait = new WebDriverWait(driver ,30);

        try {
            Actions mouseActions = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            mouseActions.doubleClick(element).perform();
        }catch (Exception e){
            System.out.println("Unable to double click " + elementName + " for reason: " + e);
        }
    }//end of mouseDoubleClick method

    //mouseRightClick
    public static void mouseRightClick(WebDriver driver , String xpath , String elementName){
        WebDriverWait wait = new WebDriverWait(driver ,30);

        try {
            Actions mouseActions = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            mouseActions.contextClick(element).perform();
        }catch (Exception e){
            System.out.println("Unable to double click " + elementName + " for reason: " + e);
        }
    }//end of mouseRightClick method


    //upload
    public static void upload(WebDriver driver, String xpath ,String filePath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver ,30);
        try{
            WebElement uploadElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            uploadElement.sendKeys(filePath);
        }
        catch(Exception e){
            System.out.println("Unable to upload " + elementName + " for reason: " + e);
        }

    }//end of upload file method


}//end of class
