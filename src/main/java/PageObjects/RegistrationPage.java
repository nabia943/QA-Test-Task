package PageObjects;
import java.lang.Thread;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.BaseTest;
import utilities.DefaultConfiguration;

public class RegistrationPage extends BaseTest{
    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath="//a[contains(text(),'Register')]")
    private WebElement register_button;

    @FindBy(xpath="//input[@id='input-fullname']")
    private WebElement fullname;
    @FindBy(xpath="//input[@id='input-email']")
    private WebElement email;

    @FindBy(xpath="//input[@id='input-password']")
    private WebElement password;
    @FindBy(xpath="//input[@id='input-confirm']")
    private WebElement confirm_password;
    @FindBy(xpath="//input[@id='dateofbirth']")
    private WebElement date_of_birth;
    @FindBy(xpath = "//input[@id='gender']")
    private WebElement gender;
    @FindBy(xpath="//body/div[@id='newsletter_subscription']")
    private WebElement newsletter_subscription;
    @FindBy(xpath="//body/div[@id='account-register']")
    private WebElement register;

    @FindBy(xpath = "//body/div[@id='success-message']")
    private WebElement success_message;



    public static Faker faker = new Faker();
    static String fakeEmail = faker.internet().emailAddress();


    public void  launchEnvironment() {
        driver.get(DefaultConfiguration.getProperty("uiEnvironment"));
        driver.manage().window().maximize();

    }
    public void nav_to_registration() throws InterruptedException{

        clickElement(register_button,"registration button");
    }

    public void add_registration_details() throws InterruptedException{

        sendText(fullname,faker.name().firstName(),"first name");
        sendText(email,fakeEmail,"email");
        sendText(password,"1234678","password");
        sendText(confirm_password,"1234678","re-enter password");
        sendText(date_of_birth,faker.date().birthday().toString(),"date of birth");
        selectOption(gender,"Male", "gender");
        clickElement(register,"confirm registration");


    }
    public void add_registration_details_with_newsletter() throws InterruptedException{

        sendText(fullname,faker.name().firstName(),"first name");
        sendText(email,fakeEmail,"email");
        sendText(password,"1234678","password");
        sendText(confirm_password,"1234678","re-enter password");
        sendText(date_of_birth,faker.date().birthday().toString(),"date of birth");
        selectOption(gender,"Male", "gender");
        clickElement(newsletter_subscription,"newsletter_subscription");

    }

    public void submit() {
        clickElement(register,"confirm registration");

    }
    public void success_message(){
        Assert.assertTrue(success_message.isDisplayed());
    }

}
