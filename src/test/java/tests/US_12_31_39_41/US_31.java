package tests.US_12_31_39_41;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MerchantPage;
import pages.UserPage;
import utilities.*;

public class US_31 extends TestBaseRapor {
    MerchantPage merchantPage ;
    Actions actions;
    SoftAssert softAssert;

    @Test
    public void Test_3101(){
        merchantPage = new MerchantPage();
        actions = new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("All Orders Page Test","There should be a page where all orders placed in the restaurant can be seen.");

        // https://qa.mealscenter.com/backoffice/login sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));
        extentTest.info("Go to mealscenter.com merchant login page");

        // Gecerli username ve password girisi yapilir
        merchantPage.merchantLogin(ConfigReader.getProperty("baiThongUsername"),ConfigReader.getProperty("partnerPassword"));
        extentTest.info("Valid username and password entered");

        // All Orders menusunun aktif oldugu dogrulanir
        merchantPage.orders.click();
        merchantPage.allOrders.click();
        ReusableMethods.isDisplayed(merchantPage.allOrders,"All Orders menu is displayed");
        extentTest.pass("Confirmed that the All Orders menu is active");

        // All Orders/Order history sayfasının oldugu dogrulanir
        ReusableMethods.isDisplayed(merchantPage.orderHistory,"Order history page is displayed");
        extentTest.pass("Verified that the Order history page exists");

    }


    @Test
    public void Test_3102(){
        merchantPage = new MerchantPage();
        actions = new Actions(Driver.getDriver());
        softAssert = new SoftAssert();

        extentTest = extentReports.createTest("All Orders Page Test","Is it possible to access the summary information of all orders from the restaurant, various filters should be possible");

        // https://qa.mealscenter.com/backoffice/login sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));
        extentTest.info("Go to mealcenter merchant login page");
        ReusableMethods.wait(2);

        // Gecerli username ve password girisi yapilir
        merchantPage.merchantLogin(ConfigReader.getProperty("baiThongUsername"),ConfigReader.getProperty("partnerPassword"));
        extentTest.info("Valid username and password entered");
        merchantPage.orders.click();
        ReusableMethods.wait(2);
        merchantPage.allOrders.click();
        ReusableMethods.wait(2);

        // Homepage > Login > Orders/All Orders/Order history/Orders  oldugu dogrulanir
        ReusableMethods.isDisplayed(merchantPage.ordersTotal,"Order(total order quantity) is displayed");
        extentTest.pass("Order(total order quantity) is displayed");
        ReusableMethods.wait(2);

        // Homepage > Login > Orders/All Orders/Order history/Cancel  oldugu dogrulanir
        ReusableMethods.isDisplayed(merchantPage.cancel,"Cancel is displayed");
        extentTest.pass("Cancel is displayed");

        // Homepage > Login > Orders/All Orders/Order history/Total refund  oldugu dogrulanir
        ReusableMethods.isDisplayed(merchantPage.totalRefund,"Total refund is displayed");
        extentTest.pass("Total refund is displayed");

        // Homepage > Login > Orders/All Orders/Order history/Start date -- End date  oldugu dogrulanir
        ReusableMethods.isDisplayed(merchantPage.startEndDate,"Start date -- End date is displayed");
        extentTest.pass("Start date -- End date is displayed");

        // Homepage > Login > Orders/All Orders/Order history/Filters Button  oldugu dogrulanir
        ReusableMethods.isDisplayed(merchantPage.filtersButton,"Filters Button is displayed");
        extentTest.pass("Filters Button is displayed");

        // Homepage > Login > Orders/All Orders/Order history/Order ID  oldugu dogrulanir
        ReusableMethods.isDisplayed(merchantPage.orderId,"Order ID is displayed");
        extentTest.pass("Order ID is displayed");

        // Homepage > Login > Orders/All Orders/Order history/Order ID  tıklanır olduğu dogrulanir
        String expected= merchantPage.lastOrderId.getText();
        merchantPage.customer.click();
        ReusableMethods.wait(2);
        String actual= merchantPage.lastOrderId.getText();
        if(expected.equals(actual)){
            extentTest.fail("Customer is not clickable");
        }else {
            extentTest.pass("Customer ID is clickable");
        }

        // Homepage > Login > Orders/All Orders/Order history/Customer oldugu dogrulanir
        ReusableMethods.isDisplayed(merchantPage.customer,"Customer is displayed");
        extentTest.pass("Customer is displayed");

        // Homepage > Login > Orders/All Orders/Order history/Customer tıklanır olduğu dogrulanir
        expected= merchantPage.lastOrderId.getText();
        merchantPage.orderId.click();
        ReusableMethods.wait(2);
        actual= merchantPage.lastOrderId.getText();
        if(expected.equals(actual)){
            extentTest.fail("Order ID is not clickable");
        }else {
            extentTest.pass("Order ID is clickable");
        }

        // Homepage > Login > Orders/All Orders/Order history/Order Information oldugu dogrulanir
        ReusableMethods.isDisplayed(merchantPage.orderInformation,"Order Information is displayed");
        extentTest.pass("Order Information is displayed");

        // Homepage > Login > Orders/All Orders/Order history/Order Information  tıklanır olduğu dogrulanir
        expected= merchantPage.lastOrderId.getText();
        merchantPage.orderInformation.click();
        ReusableMethods.wait(2);
        actual= merchantPage.lastOrderId.getText();
        if(expected.equals(actual)){
            extentTest.fail("Order Information is not clickable");
        }else {
            extentTest.pass("Order Information is clickable");
        }

        // Homepage > Login > Orders/All Orders/Order history/Actions oldugu dogrulanir
        ReusableMethods.isDisplayed(merchantPage.actions,"Actions Information ");
        extentTest.pass("Actions Information is displayed");

        // Homepage > Login > Orders/All Orders/Order history/Start date -- End date box a istenen tarih girilir
        merchantPage.startEndDate.click();
        actions.sendKeys("2023-03-22 -- 2023-03-29"+Keys.ENTER).perform();
        ReusableMethods.wait(2);
        extentTest.pass("Start date -- End date box is enabled");

        // Homepage > Login > Orders/All Orders/Order history/Filter Butonu ile filitreleme secenekleri test edilir
        merchantPage.filtersButton.click();
        ReusableMethods.isDisplayed(merchantPage.byCustomer,"By customer is displayed");
        extentTest.pass("By customer is displayed");

        // Homepage > Login > Orders/All Orders/Order history/Filter Butonu/By customer ile filitreleme secenekleri test edilir
        merchantPage.byCustumerDropDownMenu.click();
        merchantPage.byCustomerDropDownMenuSecilenMenu.click();
        extentTest.pass("The option given from the By customer menu has been selected");
        ReusableMethods.wait(2);

        // Homepage > Login > Orders/All Orders/Order history/Filter Butonu/By status ile filitreleme secenekleri test edilir
        merchantPage.byStatusDropDownMenu.click();
        merchantPage.byCustomerDropDownMenuSecilenMenu.click();
        extentTest.pass("The option given from the By status menu has been selected");
        ReusableMethods.wait(2);

        // Homepage > Login > Orders/All Orders/Order history/Filter Butonu/By Order Type Drop Down Menu ile filitreleme secenekleri test edilir
        merchantPage.byOrderTypeDropDownMenu.click();
        ReusableMethods.wait(2);
        merchantPage.byOrderTypeDropDownMenuSecilen.click();
        extentTest.pass("The option given from the By Order Type menu has been selected");
        ReusableMethods.wait(2);

        ReusableMethods.wait(2);
        WebElement ddm2 =Driver.getDriver().findElement(By.xpath("(//div[@class='form-label-group mb-4'])[3]"));
        ddm2.click();

        // Homepage > Login > Orders/All Orders/Order history/Filter Butonu/Apply Buttona basılır
        merchantPage.applyButton.click();
        ReusableMethods.wait(2);

        // Homepage > Login > Orders/All Orders/Order history/Filter Butonu ile filitreleme secenekleri test edilir
        merchantPage.filtersButton.click();

        // Homepage > Login > Orders/All Orders/Order history/Filter Butonu/By customer ile filitreleme secenekleri test edilir
        merchantPage.byCustumerDropDownMenu.click();
        merchantPage.byCustomerDropDownMenuSecilenMenu.click();

        ReusableMethods.wait(2);

        // Homepage > Login > Orders/All Orders/Order history/Filter Butonu/By status ile filitreleme secenekleri test edilir
        merchantPage.byStatusDropDownMenu.click();
        merchantPage.byCustomerDropDownMenuSecilenMenu.click();
        ReusableMethods.wait(2);

        // Homepage > Login > Orders/All Orders/Order history/Filter Butonu/By Order Type Drop Down Menu ile filitreleme secenekleri test edilir
        merchantPage.byOrderTypeDropDownMenu.click();
        ReusableMethods.wait(2);
        merchantPage.byOrderTypeDropDownMenuSecilen.click();
        ReusableMethods.wait(2);

        // Homepage > Login > Orders/All Orders/Order history/Filter Butonu/Apply Buttona basılır
        merchantPage.clearButton.click();
        ReusableMethods.wait(2);

        // Homepage > Login > Orders/All Orders/Order history/Filter Butonu/Apply Buttona basılır
        merchantPage.applyButton.click();
        ReusableMethods.wait(2);

        ReusableMethods.isDisplayed(merchantPage.byStatus,"By Status is displayed");
        extentTest.pass("By Status is displayed");
        ReusableMethods.isDisplayed(merchantPage.byOrderType,"By Order Type is displayed");
        extentTest.pass("By Order Type is displayed");

        // Homepage > Login > Orders/All Orders/Order history sayfa sonu testlerin calışması için yapıldı
        merchantPage.startEndDate.click();
        merchantPage.last30DaysDate.click();

        // Homepage > Login > Orders/All Orders/Order history/Next Butonu tıklanır olduğu dogrulanir
        expected= merchantPage.lastOrderId.getText();
        JSUtilities.scrollToBottom(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN);
        actions.sendKeys(Keys.ARROW_DOWN);
        ReusableMethods.wait(2);
        merchantPage.nextButton.click();
        ReusableMethods.wait(2);
        actual= merchantPage.lastOrderId.getText();
        if(expected.equals(actual)){
            extentTest.fail("Next is not clickable");
        }else {
            extentTest.pass("Next is clickable");
        }

        // Homepage > Login > Orders/All Orders/Order history/Previous Butonu tıklanır olduğu dogrulanir
        expected= merchantPage.lastOrderId.getText();
        ReusableMethods.wait(2);
        merchantPage.previousButton.click();
        ReusableMethods.wait(2);
        actual= merchantPage.lastOrderId.getText();
        if(expected.equals(actual)){
            extentTest.fail("Previous is not clickable");
        }else {
            extentTest.pass("Previous is clickable");
        }
        ReusableMethods.wait(1);

        softAssert.assertAll();

    }
}
