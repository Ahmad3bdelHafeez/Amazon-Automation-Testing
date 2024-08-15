//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class P01_login extends PageBase {
    By EmailInput = By.id("ap_email");
    By ContinueBtn = By.id("continue");
    By ErrorMessage = By.id("auth-error-message-box");
    WebDriverWait wait;
    public P01_login(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void EnterEmail(String Email) {
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(this.EmailInput));

        emailInput = wait.until(ExpectedConditions.elementToBeClickable(this.EmailInput));

        emailInput.sendKeys(Email);
    }


    public void ClickOnContinueBtn() {
        this.driver.findElement(this.ContinueBtn).click();
    }


    public void VerifyUnsuccessfulLogin() {

        String ErrorMessageText = this.driver.findElement(this.ErrorMessage).getText();
        System.out.println(ErrorMessageText);
        String textDirection = this.driver.findElement(this.ErrorMessage).getCssValue("direction");
        System.out.println(textDirection);
        this.softAssert.assertTrue(this.driver.findElement(this.ErrorMessage).isDisplayed(), "Expected: True, Actual: " + this.driver.findElement(this.ErrorMessage).isDisplayed());

        if(!textDirection.equals("rtl"))
            this.softAssert.assertTrue(ErrorMessageText.toLowerCase().contains("There was a problem\nWe cannot find an account with that email address".toLowerCase()),
                                    "Expected: There was a problem\nWe cannot find an account with that email address, Actual: " + this.driver.findElement(this.ErrorMessage).getText());
        else
            this.softAssert.assertTrue(ErrorMessageText.contains("حدث خطأ\nلا يمكننا العثور على حساب بعنوان البريد الإلكتروني هذا."),
                                    "Expected: حدث خطأ\nلا يمكننا العثور على حساب بعنوان البريد الإلكتروني هذا., Actual: " + this.driver.findElement(this.ErrorMessage).getText());
        this.softAssert.assertTrue(this.driver.getCurrentUrl().contains("https://www.amazon.eg/ap/signin"), "Expected: https://www.amazon.eg/ap/signin, Actual: " + this.driver.getCurrentUrl());
        this.softAssert.assertAll();
    }
}
