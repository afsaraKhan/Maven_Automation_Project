package Day10_121123;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReUsableMethods {
    //setUpDriver: a reusable-method for set up web driver
    public static WebDriver setUpDriver(){
        //set up the chromeDriver webDriverManager
        WebDriverManager.chromedriver().setup();

        //declare the ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        // instead of writing "WebDriver driver = new ChromeDriver(options)",
        // we can declare and return the instance of WebDriver directly
        return new ChromeDriver(options);
    }// end of setUpDriver

    //clickMethod: a reusable-method for clicking on any web element
    public static void click(WebDriver driver, String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).click();
        } catch (Exception e){
            System.out.println("Unable to access " + elementName + " for reason :" + e );
        }
    }//end of click method

    //submit: a reusable-method for submit on any web element
    public static void submit(WebDriver driver, String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try{
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).submit();
        } catch (Exception e){
            System.out.println("Unable to access " + elementName + " for reason :" + e );
        }
    }//end of submit method

    //clickByIndex: a reusable-method to click by index on any webElement from a list
    public static void clickByIndex(WebDriver driver, String xpath, int index, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try{
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(index).click();
        } catch (Exception e){
            System.out.println("Unable to access " + elementName + " for reason :" + e );
        }
    }//end of clickByIndex method

    // captureText: a reusable-method to get text from any webElement
    public static String getText(WebDriver driver, String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        String result = "";
        try{
            result = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath))).getText();
        } catch (Exception e){
            System.out.println("Unable to access " + elementName + " for reason: " + e);
        }
        return result;
    }//end of captureText method

    //sendKeys: a reusable-method to send keys to text fields
    public static void sendKeys(WebDriver driver, String xpath, String keys, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try{
            WebElement field = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            field.clear();
            field.sendKeys(keys);
        }catch (Exception e){
            System.out.println("Unable to access " + elementName + " for reason :" + e );
        }
    }//end of sendKeys method

    //scrollIntoElement: a reusable-method to scroll into a web element
    public static void scrollIntoElement(WebDriver driver, String xpath, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try{
            WebElement element =  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            jse.executeScript("arguments[0].scrollIntoView(true)", element);
        }catch (Exception e){
            System.out.println("Unable to access " + elementName + " for reason :" + e );
        }
    }//end of scrollIntoElement method

    //selectByVisibleText: a reusable method to select an option from a dropdown by visible text
    public static void selectByVisibleText(WebDriver driver, String dropdownXpath, String visibleText, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try{
            WebElement listOfItems = wait.until(ExpectedConditions.presenceOfElementLocated((By.xpath(dropdownXpath))));
            Select dropDown = new Select(listOfItems);
            dropDown.selectByVisibleText(visibleText);
        } catch (Exception e){
            System.out.println("Unable to access " + elementName + " for reason :" + e );
        }
    }// end of selectByVisibleText method

}//end of class
