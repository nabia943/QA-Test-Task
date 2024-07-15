package managers;

import PageObjects.*;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;


    private RegistrationPage registrationPage;


    public PageObjectManager(WebDriver driver) {

        this.driver = driver;

    }


    public RegistrationPage getregistrationPage(){

        return (registrationPage == null) ? registrationPage = new RegistrationPage(driver) : registrationPage;

    }


}
