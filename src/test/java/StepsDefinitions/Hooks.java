package StepsDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import managers.BrowserFactory;
import org.openqa.selenium.WebDriver;

public class Hooks {
    BrowserFactory browserFactory = new BrowserFactory();
    WebDriver driver;
  
    
   
    @Before
    public void beforeScenario(Scenario scenario) {
        driver=browserFactory.createDriver();

        
    }

   @After
    public void afterScenario(Scenario scenario) {

        browserFactory.closeDriver();
    }

}