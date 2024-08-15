//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;


public class P02_homePage extends PageBase {
    By Login = By.cssSelector("#nav-link-accountList");
    By LoginBtn = By.xpath("//*[@id=\"nav-flyout-ya-signin\"]/a");
    By AllTabBtn = By.id("nav-hamburger-menu");
    By TodayDealsBtn = By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[17]/a");
    By SecondCategory = By.xpath("//*[@id=\"anonCarousel1\"]/ol/li[2]/a");
    By FirstProduct = By.xpath("//*[@id=\"sobe_d_b_2_1\"]/a");
    By SecondItem = By.xpath("//*[@id=\"a-page\"]/div[1]/div[2]/div[3]/div[1]/div/div[2]/div[2]/ul/li[2]/span/div/a");
    By SeconduantityOption = By.xpath("//option[@value='2']");
    By AddToCartBtn = By.id("add-to-cart-button");
    By CartBtn = By.id("nav-cart");
    By ItemNameActual = By.xpath("//span[@class='a-truncate-cut']");
    By ItemPriceActual = By.xpath("//div[@data-asin='B09FPTBVMC']//span[contains(@class, 'sc-price')]");
    By ItemQuantityActual = By.xpath("//span[@class='a-dropdown-prompt']");
    By ItemSubTotalActual = By.xpath("//*[@id=\"sc-subtotal-amount-activecart\"]/span");
    By ItemNameExpected = By.id("productTitle");
    String ItemNameExpectedText;
    By ItemPriceExpected = By.xpath("//*[@id=\"corePriceDisplay_desktop_feature_div\"]/div[1]/span[2]/span[2]/span[2]");
    String ItemPriceExpectedText;
    By ItemQuantityExpected = By.xpath("//*[@id=\"a-autoid-5-announce\"]/span[2]");
    String ItemQuantityExpectedText;
    String ItemSubTotalExpected;
    WebDriverWait wait;
    public P02_homePage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
    }

    public void ClickOnLoginBtn(){
        Actions actions = new Actions(this.driver);
        actions.moveToElement(this.driver.findElement(this.Login)).perform();

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(this.driver.findElement(this.LoginBtn)));
        this.driver.findElement(this.LoginBtn).click();
    }

    public void ClickOnAllTabBtn(){
        WebElement allTab = wait.until(ExpectedConditions.elementToBeClickable(AllTabBtn));
        allTab.click();
    }

    public void ClickOnTodaysDeals(){
        WebElement todaysDeals = wait.until(ExpectedConditions.elementToBeClickable(TodayDealsBtn));
        todaysDeals.click();
    }

    public void ClickOnSecondCategory(){
        WebElement secondCategory = wait.until(ExpectedConditions.visibilityOfElementLocated(SecondCategory));
        secondCategory.click();
    }

    public void ClickOnFirstProduct(){
        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(FirstProduct));
        firstProduct.click();
    }

    public void ClickOnSecondItem(){
        WebElement secondItemOption = wait.until(ExpectedConditions.elementToBeClickable(SecondItem));
        secondItemOption.click();
    }

    public void Add2QuantityToTheCart(){
        WebElement selectQuantity = wait.until(ExpectedConditions.elementToBeClickable(SeconduantityOption));
        selectQuantity.click();
    }

    public void ClickOnAddToCartBtn(){
        ItemNameExpectedText = this.driver.findElement(ItemNameExpected).getText();
        ItemPriceExpectedText = this.driver.findElement(ItemPriceExpected).getText();
        ItemQuantityExpectedText = this.driver.findElement(ItemQuantityExpected).getText();
        WebElement addToCartButton = driver.findElement(AddToCartBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartButton);
    }

    public void ClickOnCartBtn(){
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(CartBtn));
        cartButton.click();
    }

    public void VerifyItemsInCart(){
        WebElement cartItemName = wait.until(ExpectedConditions.visibilityOfElementLocated(ItemNameActual));
        WebElement cartItemPrice = driver.findElement(ItemPriceActual);
        WebElement cartItemQty = driver.findElement(ItemQuantityActual);
        WebElement cartItemSubtotal = driver.findElement(ItemSubTotalActual);
        this.softAssert.assertEquals(ItemNameExpectedText.toLowerCase().trim(), cartItemName.getText().toLowerCase().trim(),
                "Expected: " + ItemNameExpectedText + ", Actual: " + cartItemName.getText());
        this.softAssert.assertEquals(Float.parseFloat(ItemPriceExpectedText.toLowerCase().trim()), Float.parseFloat(cartItemPrice.getText().toLowerCase().trim().replaceAll("[^\\d.]", "")),
                "Expected: " + ItemPriceExpectedText + ", Actual: " + cartItemPrice.getText().replaceAll("[^\\d.]", ""));

        this.softAssert.assertEquals(ItemQuantityExpectedText.toLowerCase().trim(), cartItemQty.getText().toLowerCase().trim(),
                "Expected: " + ItemQuantityExpectedText + ", Actual: " + cartItemQty.getText());
        float ItemSubtotalExtectedText = Float.parseFloat(ItemPriceExpectedText) * Integer.parseInt(ItemQuantityExpectedText);

        this.softAssert.assertEquals(ItemSubtotalExtectedText, Float.parseFloat(cartItemSubtotal.getText().toLowerCase().trim().replaceAll("[^\\d.]", "")),
                "Expected: " + ItemSubtotalExtectedText + ", Actual: " + cartItemSubtotal.getText().replaceAll("[^\\d.]", ""));
        this.softAssert.assertAll();
    }
}
