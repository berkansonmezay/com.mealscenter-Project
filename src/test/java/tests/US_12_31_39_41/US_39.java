package tests.US_12_31_39_41;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminPage;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_39 extends TestBaseRapor {
    AdminPage adminPage;
    MerchantPage merchantPage;
    Actions actions;
    SoftAssert softAssert;

    @Test
    public void Test_3901() {
        adminPage= new AdminPage();
        actions = new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("Merchant Earnings Page Test", "As an admin, there should be a page where Merchant balances can be viewed");

        // https://qa.mealscenter.com/backoffice/login sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Go to mealscenter admin login page");

        // Gecerli username ve password girisi yapilir
       AdminPage.adminLogin(ConfigReader.getProperty("adminUsername"), ConfigReader.getProperty("adminPassword"));
        extentTest.info("Valid username and password entered");

        // Earnings/Earnings menusunun aktif oldugu dogrulanir
        AdminPage.menuList(6).click();
        ReusableMethods.wait(2);
        ReusableMethods.isDisplayed(adminPage.menuList(6),"Earnings menu is displayed");
        extentTest.pass("Confirmed Earnings menu is active");

        // Earnings/Merchant Earnings menusunun aktif oldugu dogrulanir
        AdminPage.menuList(7).click();
        ReusableMethods.wait(2);
        ReusableMethods.isDisplayed(adminPage.menuList(7),"Merchant Earnings menu is displayed");
        extentTest.pass("Merchant Earnings menu is clickable");


    }



    @Test
    public void Test_3902() {
        adminPage = new AdminPage();
        actions = new Actions(Driver.getDriver());
        merchantPage=new MerchantPage();
        extentTest = extentReports.createTest("Merchant Earnings Page Test", "Admin should be able to list Merchant Earnings values,\n" +
                "You should be able to see the details and use various filters.\n" +
                "should be able to. You should also be able to search");

        // https://qa.mealscenter.com/backoffice/login sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Go to mealscenter admin login page");

        // Gecerli username ve password girisi yapilir
        AdminPage.adminLogin(ConfigReader.getProperty("adminUsername"), ConfigReader.getProperty("adminPassword"));
        extentTest.info("Valid username and password entered");

        // Earnings/Earnings menusunun aktif oldugu dogrulanir
        AdminPage.menuList(6).click();
        ReusableMethods.wait(2);
        ReusableMethods.isDisplayed(adminPage.menuList(6),"Earnings menu is displayed");
        extentTest.pass("Confirmed Earnings menu is active");

        // Earnings/Merchant Earnings menusunun aktif oldugu dogrulanir
        AdminPage.menuList(7).click();
        ReusableMethods.wait(2);
        ReusableMethods.isDisplayed(adminPage.menuList(7),"Merchant Earnings menu is displayed");
        extentTest.pass("Confirmed that the Merchant Earnings menu is active");

        // Merchant Earnings/Total Commission gorunur oldugu dogrulanir
        ReusableMethods.isDisplayed(adminPage.totalCommission,"Total Commission is displayed");
        extentTest.pass("Total Commission is displayed");

        // Merchant Earnings/Total Balance gorunur oldugu dogrulanir
        ReusableMethods.isDisplayed(adminPage.totalBalance,"Total Commission is displayed");
        extentTest.pass("Total Commission is displayed");

        // Merchant Earnings/Search gorunur oldugu dogrulanir
        merchantPage.inAttributeSearchBoxButton.isDisplayed();
        extentTest.pass("Search Box is displayed");

        // Merchant Earnings/Search aktif oldugu dogrulanir
        actions.sendKeys("Thai"+ Keys.ENTER);
        String expected="Thai";
        String actual=merchantPage.inAttributeSearchBoxButton.getText();
        if(expected.equals(actual)){
            extentTest.pass("Search is clickable");
        }else {
            extentTest.fail("Search is not clickable");
        }

        // Merchant Earnings/Create a Transaction Button gorunur oldugu dogrulanir
        ReusableMethods.isDisplayed(adminPage.createATransaction,"Create a Transaction Button is displayed");
        extentTest.pass("Create a Transaction Button is displayed");

        // Merchant Earnings/Create a Transaction Button tıklanabilir oldugu dogrulanir
        adminPage.createATransaction.click();
        extentTest.pass("Create a Transaction Button is clickable");
        ReusableMethods.wait(2);

        // Merchant Earnings/Create a Transaction Button/Adjustment tıklanabilir oldugu dogrulanir
        adminPage.adjustment.click();
        extentTest.pass("Adjustment is clickable");
        ReusableMethods.wait(2);

        // Merchant Earnings/Create a Transaction Button/Adjustment/Create adjustment gorunur oldugu dogrulanir
        ReusableMethods.isDisplayed(adminPage.createATransaction,"Create adjustment is displayed");
        extentTest.pass("Create adjustment is displayed");
        ReusableMethods.wait(2);

        // Merchant Earnings/Create a Transaction Button/Adjustment/Create adjustment/x tıklanabilir oldugu dogrulanir
        adminPage.createAdjustmentXButton.click();
        extentTest.pass("x is clickable");
        ReusableMethods.wait(2);


    }
}