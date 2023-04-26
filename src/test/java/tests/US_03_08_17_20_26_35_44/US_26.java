package tests.US_03_08_17_20_26_35_44;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MerchantPage;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

public class US_26 {
    UserPage userPage;
    MerchantPage merchantPage;

    @Test
    public void Test26(){

        userPage=new UserPage();
        merchantPage=new MerchantPage();

        // launch browser
        // Go to https://qa.mealscenter.com/.
        Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));

        // 2.Sign in button is clicked
        // 3.User login is made with the given information.
        UserPage.userLogin(ConfigReader.getProperty("customerEmail"),ConfigReader.getProperty("customerPassword"));

        // Go to a restaurant page random.
        ReusableMethods.wait(1);
        ReusableMethods.waitAndSendText(userPage.enterDeliveryAddressBox,"Orlando");
        ReusableMethods.wait(2);

        ReusableMethods.waitAndClick(userPage.firstDeliveryAdresOnBox,1);

        ReusableMethods.wait(1);
        ReusableMethods.waitAndClick(userPage.baiTongRestaurant,1);

        // 5.A product is added to the cart from the restaurant menu.
        userPage.addToCartButton.click();
        userPage.checkoutButton.click();

        // 6.Click on the Checkout button and select Cash On Delivery from the
        // 7.Payment Methods section.
        // 8.Payment is added with the Add Cash button that comes with the warning message.

        ReusableMethods.wait(4);
        JSUtilities.scrollToElement(Driver.getDriver(),userPage.paymentKaydiriciBaslik);
        ReusableMethods.wait(2);
        // 9.Place order button is clicked
        ReusableMethods.waitAndClick(userPage.placeOrderButton,1);

        // 10.Order is confirmed
        Assert.assertTrue(userPage.confirmingOrderLabel.isDisplayed(),"Order failed");
        // 11.https://qa.mealscenter.com/backoffice/auth/login page is accessed.
        Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));

        // 12.Restaurant administrator login is made.
        MerchantPage.merchantLogin((ConfigReader.getProperty("baiThongUsername")),ConfigReader.getProperty("partnerPassword"));

        // 13.Tested that the order placed is visible in New Orders under the Orders menu
        ReusableMethods.waitAndClick(merchantPage.ordersDDM);
        ReusableMethods.waitAndClick(merchantPage.newOrdersDdm);

        ReusableMethods.wait(2);

        // 14.The order is accepted in the New Orders section
        ReusableMethods.waitAndClick(merchantPage.acceptedButton);



        Driver.closeDriver();


    }
}
