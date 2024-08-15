//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package StepDef;

import Pages.P02_homePage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class D02_ShoppingCartStepDef {
    P02_homePage p02_homePage;

    public D02_ShoppingCartStepDef() {
    }

    @Before
    public void preConditions() {
        this.p02_homePage = new P02_homePage(TestBase.driver);
    }

    @When("user clicks on All Tab button")
    public void userClicksOnAllTabButton() {
        this.p02_homePage.ClickOnAllTabBtn();
    }

    @And("user click on Today's Deals")
    public void userClickOnTodaySDeals() {
        this.p02_homePage.ClickOnTodaysDeals();
    }

    @And("user clicks on second category")
    public void userClicksOnSecondCategory() {
        this.p02_homePage.ClickOnSecondCategory();
    }

    @And("user clicks on the first product")
    public void userClicksOnTheFirstProduct() {
        this.p02_homePage.ClickOnFirstProduct();
    }

    @And("user clicks on the second item in the selected product")
    public void userClicksOnTheSecondItemInTheSelectedProduct() {
        this.p02_homePage.ClickOnSecondItem();
    }

    @And("user add this product with qty equals two")
    public void userAddThisProductWithQtyEqualsTwo() {
        this.p02_homePage.Add2QuantityToTheCart();
        this.p02_homePage.ClickOnAddToCartBtn();
    }

    @And("user clicks on the Shopping Cart")
    public void userClicksOnTheShoppingCart() {
        this.p02_homePage.ClickOnCartBtn();
    }

    @Then("Verify that Items are added to cart correctly")
    public void verifyThatItemsAreAddedToCartCorrectly() {
        this.p02_homePage.VerifyItemsInCart();
    }
}
