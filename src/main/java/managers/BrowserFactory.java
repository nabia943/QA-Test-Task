package managers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserFactory {

    private static WebDriver driver ;

    public WebDriver createDriver () {
           if (driver==null) {
               ChromeOptions chromeOptions = new ChromeOptions();
               WebDriverManager.chromedriver().setup();
               System.setProperty("webdriver.chrome.driver","C:\\Users\\DELL\\Downloads\\chromedriver-win32\\chromedriver.exe");
               chromeOptions.addArguments("--remote-allow-origins=*");
               chromeOptions.setAcceptInsecureCerts(true);
               driver = new ChromeDriver(chromeOptions);


           }
           return driver;
        }

    public WebDriver getDriver(){
        return driver;
    }

    public void closeDriver(){
        driver.quit();
         driver=null;
    }
}

