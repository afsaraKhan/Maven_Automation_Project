package Practice;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashMap;

public class practise_1 {
    public static void main(String[] args) throws InterruptedException {
        //linear array
//        String[] names = new String[3];
//        names[0] = "Apon";
//        names[1] = "Roysa";
//        names[2] = "Khan";
//        String[] names = new String[]{"Apon", "Roysa", "Khan"};
//        System.out.println(names.length);

// ArrayList
//        ArrayList<String> names = new ArrayList<>();
//        ArrayList<Integer> code = new ArrayList<>();
//        names.add("Apon");
//        names.add("Roysa");
//        code.add(880);
//        code.add(192);
//        names.add("khan");

//        System.out.println(names.get(1));
//        System.out.println(names.size());

        // for loop
//        for(int i = 0 ; i < names.size() ; i++){
//            System.out.println("The name is " + names.get(i) );
//        }
//          //while loop
//        int i = 0;
//        while(i < names.size()){
//            System.out.println("The name is " + names.get(i));
//            i++;
//        }

//        //enhanced for loop/ for-each loop
//        for(int num: code){
//            System.out.println(num);
//        }

        // if-else if-else
//        if(code.get(1)==192) {
//            System.out.println("The zip code is " + code.get(1));
//        }
//        else {
//            System.out.println("Zipe code not found");
//        }

        //Grade Assignment
//        int Grade = 89;
//        if(Grade >= 90 && Grade <= 100){
//            System.out.println("Grade A");
//        } else if (Grade >=80 && Grade <= 89) {
//            System.out.println("Grade B");
//        }
//        else {
//            System.out.println("Grade C");
//        }

        //HashMap (key-value pair)
//        HashMap<String, Integer> data = new HashMap<>();
//        data.put("Apon", 26);
//        data.put("Roysa", 25);

//        if(data.containsKey("Apon")){
//            System.out.println(data.get("Roysa"));
//        }
//
//        data.replace("Apon", 27);
//        System.out.println(data.get("Apon"));

        //split
//        String text = "My_speed_is_3457_meter_per_second";
//        String[] splitWords = text.split("_");
//        System.out.println(splitWords[3]);

    // Automation

//        //setting up the WebDriverManager
//        WebDriverManager.chromedriver().setup();
//
//        //creating a Chrome browser driver
//        WebDriver driver = new ChromeDriver();
//
//        //navigating to an address on web
//        driver.navigate().to("https://www.bing.com/");
//
//        //maximize the window
//        driver.manage().window().maximize();
//
//        // how to find an element by xpath
//        driver.findElement(By.xpath("//*[@id='sb_form_q']")).sendKeys();
//
//        //click the submit button
//        driver.findElement(By.xpath("/*[@id='search_icon']")).submit();

//        //taking the search result number
//        String result = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();
//        //split text
//        String[] res_arr = result.split(" ");

//
//        System.out.println(res_arr[1]);
//
//
//
//        //to delay the process
//        Thread.sleep(2000);
//
//        //to quit the browser instance
//        driver.quit();



        // Action Item 3

        //Create new ArrayList with 5 country values
//        ArrayList<String> countries = new ArrayList<>();
//        countries.add("USA");
//        countries.add("UK");
//        countries.add("Canada");
//        countries.add("Mexico");
//        countries.add("Thailand");
////
////        //setting up webDriver
//        WebDriverManager.chromedriver().setup();
////
////        //creating chromeBrowser Driver
//        WebDriver driver = new ChromeDriver();
////
//        //while loop
//        int i = 0;
//        while(i < countries.size()){
//
//            //navigating to an address to web
//            driver.navigate().to("https://www.bing.com");
//            Thread.sleep(1000);
//
//            //maximize window
//            driver.manage().window().maximize();
//
//            //find element
//            driver.findElement(By.xpath("//*[@id='sb_form_q']")).sendKeys(countries.get(i));
//
//            //submit
//            driver.findElement(By.xpath("//*[@id='search_icon']")).submit();
//            Thread.sleep(1000);
//
//            //search result number
//           String result = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();
//
//           //split
//           String[] result_arr = result.split(" ");
//            System.out.println(result_arr[1]);
//
//            i++;
//
//        }// loop end
//
//        //quit
//        driver.quit();



        //---------------------------------------- action item 4
//        //setup webdriver manager
//        WebDriverManager.chromedriver().setup();
//
//        //setup chrome options
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
//        options.addArguments("incognito");
//
//        //setup chrome driver
//        WebDriver driver = new ChromeDriver(options);
//
//
//        //creating Array List
//
//        ArrayList<String> zipCodes = new ArrayList<>();
//        zipCodes.add("19082");
//        zipCodes.add("90001");
//        zipCodes.add("10008");
//
//        //for loop
//        for(int i=0 ; i < zipCodes.size() ; i++){
//
//            //step1
//            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");
//
//            //step2
//
//            Thread.sleep(2000); //wait
//
//            driver.findElement(By.xpath("//*[text()='Find a Workshop']")).click();
//
//            //step3
//            driver.findElement(By.xpath("//*[text()='In-Person']")).click();
//
//            //step4
//            Thread.sleep(2000); //wait
//            WebElement search = driver.findElement(By.xpath("//*[@class='input input-3TfT5']"));
//
//            search.clear(); //erase
//            search.sendKeys(zipCodes.get(i)); //search zipcodes
//
//            //step5
//            driver.findElement(By.xpath("//*[@type='submit']")).click(); //click arrow
//
//            //step6
//            Thread.sleep(2000); //wait
//
//            //step7
//            ArrayList<WebElement> studioLinks = new ArrayList<>(driver.findElements(By.xpath("//*[@class='wrapperLink-2NobU']")));
//
//            if(i == 0){
//                studioLinks.get(1).click();
//            } if(i == 1){
//                studioLinks.get(2).click();
//            } if(i == 2){
//                studioLinks.get(0).click();
//            }
//
//            //step7
//            Thread.sleep(2000); //wait
//
//            String address = driver.findElement(By.xpath("//*[@class='address-2PZwW']//child::div[1]")).getText() + ", " + driver.findElement(By.xpath("//*[@class='address-2PZwW']//child::div[2]")).getText();
//
//            System.out.println("The Address is " + address);
//
//            //step8
//            JavascriptExecutor jse = (JavascriptExecutor) driver;
//
//            WebElement workshopSchedule = driver.findElement(By.xpath("//*[@class='title-bEfSM']"));
//
//            jse.executeScript("arguments[0].scrollIntoView(true)", workshopSchedule);
//
//            String table = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
//
//            System.out.println(table);
//
//        }
//
//    //quit the driver
//        driver.quit();

        //handling tabs
        //setup webdriver manager
//        WebDriverManager.chromedriver().setup();
//
//        //setup chrome options
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("start-maximized");
//        options.addArguments("incognito");
//
//        //setup chrome driver
//        WebDriver driver = new ChromeDriver(options);
//
//        //navigate to fieldscare website
//        driver.navigate().to("https://www.usps.com/");

//        Thread.sleep(3000);
//
//        try {
//            //click on shop for a plan
//            driver.findElement(By.xpath("//*[text()='Shop For a Plan']")).click();
//            Thread.sleep(1500);
//        } catch (Exception e){
//            System.out.println("Unable to click shop for a plan for reason :" + e);
//        }
//
//        try {
//            //click on next shop for a plan
//            driver.findElements(By.xpath("//*[@href='/Shop-for-a-Plan']")).get(0).click();
//        } catch (Exception e){
//            System.out.println("Unable to click on next Shop for a Plan for reason: " + e);
//        }

//        //scroll to find a doctor
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        WebElement findADoctor = driver.findElements(By.xpath("//*[text()='Find a Doctor']")).get(2);
//        jse.executeScript("arguments[0].scrollIntoView(true)", findADoctor);
//        Thread.sleep(2000);
//
//        //click on search under find a doctor
//        driver.findElement(By.xpath("//*[@href='/Find-A-Doctor' and @type='button']")).click();
//
//        //switch to second tab
//        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
//
//        //send "19082" to the location search box
//        WebElement LocationBox = driver.findElement(By.xpath("//*[@id='searchLocation']"));
//        LocationBox.clear();
//        LocationBox.sendKeys("19082");
//
//        //wait 2 seconds
//        Thread.sleep(2000);
//
//
//        //select speciality from dropdown
//        WebElement searchType = driver.findElement(By.xpath("//*[@formcontrolname='searchType']"));
//        Select searchTypeDropdown = new Select(searchType);
//        searchTypeDropdown.selectByVisibleText("Specialty");
//
////        driver.findElement(By.xpath("//*[@formcontrolname='searchType']")).click();
////        driver.findElement(By.xpath("//*[text()='Specialty']")).click();
//
//        Thread.sleep(2000);
//
//        //close the tab
//        driver.close();
//
//        //switch back to previous tab
//        driver.switchTo().window(tabs.get(0));
//
//        //click on get coverage
//        driver.findElement(By.xpath("//*[text()='Get Coverage' and @href='/Blog/Year-Round']")).click();
//        Thread.sleep(2000);


//        Actions mouseActions = new Actions(driver);
//        WebElement shop = driver.findElement(By.xpath("//*[text()='Shop']"));
//        mouseActions.moveToElement(shop).perform();
//
//        //driver.findElement(By.xpath("//*[text()='Collectors']")).click();
//        WebElement collectors = driver.findElement(By.xpath("//*[text()='Collectors']"));
//        mouseActions.moveToElement(collectors).click().perform();
//
//        Thread.sleep(3000);
//
//
//        //quit the driver
//        driver.quit();

        //implicit and explicit wait

    } //end of main
}//end of class
