package actionItems;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class InClassActionItem2 {
    public static void main(String[] args) {
        //setup web driver manager
        WebDriverManager.chromedriver().setup();

        //setup chrome options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");

        //setup chrome driver
        WebDriver driver = new ChromeDriver(options);

        //navigate to equinox's website
        driver.navigate().to("https://www.equinox.com/");
    }//end of main
}//end of class
