package tests.US_02_05_14_23_32;



import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


public class US_23 extends TestBaseRapor {

    @Test
    public void test_2301 () {
        extentTest = extentReports.createTest("Merchant Dashboard Test","Restaurant information and graphs should displayed on Merchant Dashboard.");

        MerchantPage merchantPage = new MerchantPage();

        Driver.getDriver().get((ConfigReader.getProperty("merchantUrl")));
        extentTest.info("Gone to Merchant Login Page");

        MerchantPage.merchantLogin(ConfigReader.getProperty("baiThongUsername"), ConfigReader.getProperty("partnerPassword"));
        extentTest.info("Logged in website as a Merchant User");

        ReusableMethods.wait(2);

        merchantPage.checkContent(merchantPage.totalOrdersImg,"Total Orders" );
        extentTest.pass("Confirmed that Total Orders block has been displayed");
        merchantPage.checkContent(merchantPage.totalCancelImg,"Total Cancel" );
        extentTest.pass("Confirmed that Total Cancel block has been displayed");
        merchantPage.checkContent(merchantPage.totalRefundImg,"Total refund" );
        extentTest.pass("Confirmed that Total Refund block has been displayed");
        merchantPage.checkContent(merchantPage.totalSalesImg,"Total Sales" );
        extentTest.pass("Confirmed that Total Sales block has been displayed");
        merchantPage.checkContent(merchantPage.salesWeekBox,"Sales this week" );
        extentTest.pass("Confirmed that Sales This Week block has been displayed");
        merchantPage.checkContent(merchantPage.earningWeekBox,"Earning this week" );
        extentTest.pass("Confirmed that Earning This Week block has been displayed");
        merchantPage.checkContent(merchantPage.balanceBox,"Your balance" );
        extentTest.pass("Confirmed that Your Balance block has been displayed");
        merchantPage.checkContent(merchantPage.orderReceivedBox,"Order received" );
        extentTest.pass("Confirmed that Order Received block has been displayed");
        merchantPage.checkContent(merchantPage.todayDeliveredBox,"Today delivered" );
        extentTest.pass("Confirmed that Today Delivered block has been displayed");
        merchantPage.checkContent(merchantPage.todaySalesBox,"Today sales" );
        extentTest.pass("Confirmed that Today Sales block has been displayed");
        merchantPage.checkContent(merchantPage.todayRefundBox,"Today refund" );
        extentTest.pass("Confirmed that Today Refund block has been displayed");
        merchantPage.checkContent(merchantPage.todaySalesBox,"Today sales" );
        extentTest.pass("Confirmed that Today Sales block has been displayed");
        merchantPage.checkContent(merchantPage.salesOverviewGraph,"Sales overview" );
        extentTest.pass("Confirmed that Sales Overview Graph has been displayed");
        merchantPage.checkContent(merchantPage.lastOrdersBox,"Last Orders");
        extentTest.pass("Confirmed that Last Orders block has been displayed");
        merchantPage.checkContent(merchantPage.popularItemsBox,"Popular items", "populer items block hasn't displayed");
        extentTest.pass("Confirmed that Popular Items block has been displayed");
        merchantPage.checkContent(merchantPage.topCustomersBox,"Top Customers", "top customers block hasn't displayed");
        extentTest.pass("Confirmed that Top Costumers block has been displayed");
        merchantPage.checkContent(merchantPage.checkoutReviewGraph,"Overview of Review", "overview graph hasn't displayed");
        extentTest.pass("Confirmed that Overview of Graph has been displayed");


        ReusableMethods.wait(1);

        SoftAssert softAssert=new SoftAssert();
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();

        // merchantPage.processingButton.click();
        jse.executeScript("arguments[0].click();", merchantPage.processingButton);
        Assert.assertTrue(merchantPage.processingButton.getAttribute("class").contains("active"));
        extentTest.pass("Confirmed that Processing button clicked and active tab on Last Orders block");
        jse.executeScript("arguments[0].click();", merchantPage.readyButton);
        Assert.assertTrue(merchantPage.readyButton.getAttribute("class").contains("active"));
        extentTest.pass("Confirmed that Ready button clicked and active tab on Last Orders block");
        jse.executeScript("arguments[0].click();", merchantPage.completedButton);
        Assert.assertTrue(merchantPage.completedButton.getAttribute("class").contains("active"));
        extentTest.pass("Confirmed that Complete button clicked and active tab on Last Orders block");
        jse.executeScript("arguments[0].click();", merchantPage.allButton);
        Assert.assertTrue(merchantPage.allButton.getAttribute("class").contains("active"));
        extentTest.pass("Confirmed that All button clicked and active tab on Last Orders block");
        jse.executeScript("arguments[0].click();", merchantPage.last30DaysSalesButton);
        Assert.assertTrue(merchantPage.last30DaysSalesButton.getAttribute("class").contains("active"));
        extentTest.pass("Confirmed that last 30 Days Sales button clicked and active tab on Popular Items block");
        jse.executeScript("arguments[0].click();", merchantPage.populerItemsButton);
        Assert.assertTrue(merchantPage.populerItemsButton.getAttribute("class").contains("active"));
        extentTest.pass("Confirmed that Popular Items  button clicked and active tab on Popular Items block");


        ReusableMethods.wait(1);
        jse.executeScript("arguments[0].click();", merchantPage.allCustomerButton);
        String expected="customer/list";
        ReusableMethods.wait(2);
        softAssert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expected));
        extentTest.pass("Confirmed that View All Customer button is clicked and redirect proper URL");

        Driver.getDriver().navigate().back();
        ReusableMethods.wait(2);
        jse.executeScript("arguments[0].click();", merchantPage.checkoutReviewButton);
        expected="customer/reviews";
        softAssert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expected));
        extentTest.pass("Confirmed that Checkout All Reviews button is clicked and redirect proper URL");
        softAssert.assertAll();






    }
}
