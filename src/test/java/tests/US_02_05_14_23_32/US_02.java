package tests.US_02_05_14_23_32;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_02 extends TestBaseRapor {
    UserPage userPage;
    SoftAssert softAssert = new SoftAssert();

    @Test(priority = 10)
    public void test_0201() {
        extentTest = extentReports.createTest("Header elements Test","Navbar Elements should be visible and clickable on HomePage.");

        // userpage  firmLogo test
        Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));
        extentTest.info("Gone to MealsCenter HomePage");

        userPage = new UserPage();
        ReusableMethods.wait(1);
        userPage.cookie.click();
        extentTest.info("Cookies accepted");
        ReusableMethods.wait(1);
        softAssert.assertTrue(userPage.firmLogo.isDisplayed());
        extentTest.pass("Confirmed that brand logo has been displayed");

        userPage.firmLogo.click();
        extentTest.info("Clicked brand logo");
        String expectedUrl = "https://qa.mealscenter.com/";
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), expectedUrl);
        extentTest.pass("Confirmed that brand logo is clickable and redirect proper URL");

        //userpage signInButton test

        softAssert.assertTrue(userPage.signInButton.isDisplayed());
        extentTest.pass("Confirmed that sign in button is displayed on homepage");

        userPage.signInButton.click();
        extentTest.info(" Clicked sign in button on homepage");
        String expectedContent = "account/login";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains(expectedContent));
        extentTest.pass("Confirmed that sign in button is clickable and redirect proper URL");

        Driver.getDriver().navigate().back();


        //userpage cartButton test

        ReusableMethods.wait(2);
        softAssert.assertTrue(userPage.cartButton.isDisplayed());
        extentTest.pass("Confirmed that cart button is displayed");

        userPage.cartButton.click();
        extentTest.info("Clicked cart button");
        ReusableMethods.wait(1);
        userPage.closeCartIcon.click();
        softAssert.assertTrue(userPage.cartText.isDisplayed());
        extentTest.pass("Confirmed that cart button is clickable and works properly");



        //userpage cartIcon test

        ReusableMethods.wait(2);
        softAssert.assertTrue(userPage.cartIcon.isDisplayed());
        extentTest.pass("Confirmed that cart icon is displayed");

        userPage.cartIcon.click();
        extentTest.info("Clicked cart icon");
        ReusableMethods.wait(1);
        softAssert.assertTrue(userPage.cartText.isDisplayed());
        extentTest.pass("Confirmed that cart icon is clickable and works properly");

        userPage.closeCartIcon.click();
        softAssert.assertAll();
        Driver.closeDriver();

    }

    @Test(priority = 50)
    public void test_0202() {

        //userPage searchBox test
        extentTest = extentReports.createTest("Address SearchBox Test","Address searchBox should be displayed and works properly on HomePage");

        Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));
        extentTest.info("Gone to MealsCenter HomePage");

        userPage = new UserPage();
        ReusableMethods.wait(1);
        userPage.cookie.click();
        extentTest.info("Cookies accepted");
        ReusableMethods.wait(1);
        softAssert.assertTrue(userPage.searchBoxButton.isDisplayed());
        extentTest.pass("Confirmed that address searchBox is displayed");

        for (int i = 4; i < 9; i++) {

            Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));

            ReusableMethods.wait(1);
            userPage.searchBoxButton.sendKeys("Texas");
            ReusableMethods.wait(2);

            userPage.searchData(i).click();
            ReusableMethods.wait(2);

            String expected2 = "restaurants";

            Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expected2));
            extentTest.pass("Confirmed that searchBox accepts the user inputs and redirect " + (i-3)+ ". clicked addresses");
            softAssert.assertAll();
        }

        Driver.closeDriver();

    }


}



