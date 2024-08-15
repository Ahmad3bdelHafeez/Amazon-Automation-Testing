//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package StepDef;

import Pages.P01_login;
import Pages.P02_homePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class D01_loginStepDef {
    P01_login p01_login;
    P02_homePage p02_homePage;

    public D01_loginStepDef() {
    }

    @Before
    public void preConditions() {
        this.p01_login = new P01_login(TestBase.driver);
        this.p02_homePage = new P02_homePage(TestBase.driver);
    }

    @Given("user go to Amazon website")
    public void userGoToAmazonWebsite() {
        TestBase.driver.navigate().to("https://www.amazon.eg/");
    }

    @When("user clicks on the login button in the navigation bar")
    public void userClicksOnTheLoginButtonInTheNavigationBar() {
            this.p02_homePage.ClickOnLoginBtn();
    }

    @And("user login with valid email")
    public void userLoginWithValidEmail() {
        this.p01_login.EnterEmail("ahmad.m.abdelhafeez@gmail.com");
    }

    @And("user press on continue button")
    public void userPressOnContinueButton() {
        this.p01_login.ClickOnContinueBtn();
    }

    @Then("user can't login by displaying an error message")
    public void userCanTLoginByDisplayingAnErrorMessage() {
        this.p01_login.VerifyUnsuccessfulLogin();
    }
}
