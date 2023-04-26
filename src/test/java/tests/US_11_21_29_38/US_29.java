package tests.US_11_21_29_38;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantPage;
import pages.UserPage;
import utilities.*;

public class US_29 extends TestBaseRapor {

    UserPage userPage;
    MerchantPage merchantPage;


    @Test(priority = 10, groups = "endtoend")
    public void test2901() {

        extentTest = extentReports.createTest("TC_2901 Test","The restaurant manager goes through all the stages of the order given.\n" +
                "It completes in the Completed section.");

        userPage = new UserPage();
        merchantPage = new MerchantPage();


        // launch browser
        extentTest.info("Browser opened");

        // Go to https://qa.mealscenter.com/.
        Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));
        extentTest.pass("Go to Mealscenter homepage");

        // 2.Sign in button is clicked
        // 3.User login is made with the given information.
        UserPage.userLogin(ConfigReader.getProperty("customerEmail"), ConfigReader.getProperty("customerPassword"));
        extentTest.info("Correct username and password entered");

        // Go to a restaurant page random.
        ReusableMethods.wait(1);
        ReusableMethods.waitAndSendText(userPage.enterDeliveryAddressBox, "Seattle");
        ReusableMethods.wait(2);
        extentTest.pass("Valid address entered in address box");

        ReusableMethods.waitAndClick(userPage.firstDeliveryAdresOnBox, 1);
        extentTest.pass("Address selected");


        ReusableMethods.wait(1);
        JSUtilities.scrollToBottom(Driver.getDriver());
        ReusableMethods.waitAndClick(userPage.baiTongRestaurant, 1);
        extentTest.pass("Restaurant selected");

        // 5.A product is added to the cart from the restaurant menu.
        userPage.addToCartButton.click();
        extentTest.pass("An item has been added to the cart");
        if (userPage.tuccartavisye.isDisplayed()) {
            userPage.tuccartavisye.click();
        }
        userPage.checkoutButton.click();
        extentTest.pass("Cart clicked");

        // 6.Click on the Checkout button and select Cash On Delivery from the
        // 7.Payment Methods section.
        // 8.Payment is added with the Add Cash button that comes with the warning message.

        ReusableMethods.wait(4);
        JSUtilities.scrollToElement(Driver.getDriver(), userPage.paymentKaydiriciBaslik);
        ReusableMethods.wait(2);
        // 9.Place order button is clicked
        ReusableMethods.waitAndClick(userPage.placeOrderButton, 1);
        extentTest.pass("Click the order button");

        // 10.Order is confirmed
        Assert.assertTrue(userPage.confirmingOrderLabel.isDisplayed(), "Order failed");
        extentTest.pass("Confirmed that the order has been placed");
        WebElement orderIdElement = Driver.getDriver().findElement(By.xpath("(//p[@class='m-0 mb-1 bold'])[1]"));
        String orderIDStr = orderIdElement.getText().replaceAll("[^\\d]", "");

        // 11.https://qa.mealscenter.com/backoffice/auth/login page is accessed.
        Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));
        extentTest.info("Go to Merchant login page");

        // 12.Restaurant administrator login is made.
        MerchantPage.merchantLogin((ConfigReader.getProperty("baiThongUsername")), ConfigReader.getProperty("baiThongPassword"));
        extentTest.info("Merchant name and password entered");

        // 13.Tested that the order placed is visible in New Orders under the Orders menu
        ReusableMethods.waitAndClick(merchantPage.ordersDDM);
        extentTest.pass("Accessed Orders page ");
        ReusableMethods.waitAndClick(merchantPage.newOrdersDdm);
        extentTest.pass("Accessed New Orders page");
        merchantPage.orderFilterBox.sendKeys(orderIDStr);
        ReusableMethods.wait(2);
        Assert.assertTrue(merchantPage.orderIdInformation.getText().contains(orderIDStr));

        // 14.The order is accepted in the New Orders section
        ReusableMethods.waitAndClick(merchantPage.acceptedButton);
        extentTest.pass("Order placed was accepted in New Orders");


        // 15.For the given order, click the Ready for pickup button in the Orders Processing section
        ReusableMethods.waitAndClick(merchantPage.ordersProcessingDdm);
        extentTest.pass("Accessed Orders Processing page");
        merchantPage.orderFilterBox.sendKeys(orderIDStr);
        ReusableMethods.wait(2);
        ReusableMethods.waitAndClick(merchantPage.readiyForPickupButton);
        extentTest.pass("Order placed is accepted as Ready for pickup");


        // 16.Orders for the given order Completed is done in the Ready section
        ReusableMethods.waitAndClick(merchantPage.ordersReadyDdm);
        extentTest.pass("Accessed Orders Ready page");
        merchantPage.orderFilterBox.sendKeys(orderIDStr);
        ReusableMethods.wait(1);
        ReusableMethods.waitAndClick(merchantPage.deliveredButton);
        extentTest.pass("Order placed has been confirmed as Delivered");

        // 17.It is verified that the order is visible in the Completed section
        ReusableMethods.waitAndClick(merchantPage.orderCompletedDdm);
        extentTest.pass("Accessed Orders Completed page");
        ReusableMethods.waitAndSendText(merchantPage.orderFilterBox, orderIDStr);
        ReusableMethods.wait(2);
        Assert.assertTrue(merchantPage.orderIdInformation.getText().contains(orderIDStr),
                "order not found in completed orders");
        extentTest.pass("Confirmed that the placed order is complete");

        Driver.closeDriver();
        extentTest.info("Browser closed");


    }
}
