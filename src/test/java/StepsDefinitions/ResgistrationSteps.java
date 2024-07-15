package StepsDefinitions;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.BrowserFactory;
import managers.PageObjectManager;
import utilities.BaseTest;

public class ResgistrationSteps extends BaseTest {

    BrowserFactory browserFactory = new BrowserFactory();
    PageObjectManager pageObjectManager = new PageObjectManager(browserFactory.getDriver());


    @Given("^I am on the registration page$")
    public void iAmOnTheRegistrationPage() throws Throwable{
        pageObjectManager.getregistrationPage().launchEnvironment();
    }

    @When("^I enter valid registration details$")
    public void iEnterValidRegistrationDetails()throws Throwable{
        pageObjectManager.getregistrationPage().add_registration_details();

    }

    @And("^I click the submit button$")
    public void iClickTheSubmitButton() throws Throwable{
        pageObjectManager.getregistrationPage().submit();
    }

    @Then("^I should see a success message$")
    public void iShouldSeeASuccessMessage() throws Throwable{
        pageObjectManager.getregistrationPage().success_message();

    }

    @When("^I enter valid registration details with newsletter subscription$")
    public void iEnterValidRegistrationDetailsWithNewsletterSubscription() throws Throwable{
        pageObjectManager.getregistrationPage().add_registration_details_with_newsletter();
    }
}
