package tests.US_11_21_29_38;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserPage;
import utilities.*;

public class US_11 extends TestBaseRapor {
    Actions actions=new Actions(Driver.getDriver());
    UserPage userPage=new UserPage();

    @Test
    public void test1101(){
        Actions actions=new Actions(Driver.getDriver());
        UserPage userPage=new UserPage();
        extentTest = extentReports.createTest("TC_1101 Test","The user sees the restaurant pages.");

        // launch browser
        extentTest.info("Browser opened");

        //1.User goes to qa.mealscenter.com
        Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));
        extentTest.pass("Go to Mealscenter homepage");

        //2.Accepts cookies
        if (userPage.cookie.isDisplayed()){
        userPage.cookie.click();
        }
        extentTest.pass("Cookies accepted");

        // 3.Clicks on the first restaurant under Popular Nearby
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.pass("Page navigated");
        ReusableMethods.wait(2);
        userPage.firstRestaurantAtNearby.click();
        extentTest.pass("Clicked on a restaurant");
        Assert.assertTrue(userPage.menuCategory.getText().contains("Menu"));
        extentTest.pass("Verified access to restaurant page");

        // 4.Clicks a product from the menu on the Restaurant page
        Assert.assertTrue(userPage.firstProductAtRestaurant.isEnabled());
        extentTest.pass("Confirmed that there is a product in the selected restaurant");

        //5.Closes the page
        ReusableMethods.wait(3);
        Driver.closeDriver();
        extentTest.info("Browser closed");

    }

    @Test
    public void test1102(){
        UserPage userPage=new UserPage();
        extentTest = extentReports.createTest("TC_1102 Test","The user navigates between restaurant pages.");
        // launch browser
        extentTest.info("Browser opened");;

        //2.User goes to qa.mealscenter.com
        Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));
        extentTest.pass("Go to Mealscenter homepage");

        //2.Accepts cookies
        if (userPage.cookie.isDisplayed()){
            userPage.cookie.click();
        }
        extentTest.pass("Cookies accepted");


        // 3.goes through restaurants with the right arrow button under Nearby
        ReusableMethods.wait(2);
        JSUtilities.scrollToElement(Driver.getDriver(),userPage.motoKuryeResim);
        extentTest.pass("Page navigated");
        ReusableMethods.wait(1);
        ReusableMethods.waitAndClick(userPage.rightArrowButton,1);
        extentTest.pass("Navigated through restaurants");

        // 4.Clicks on the restaurant at the far right of the list
        ReusableMethods.waitAndClick(userPage.restaurantUnderArrows,2);
        extentTest.pass("Clicked on a restaurant");

        // 5.Restaurant page click
        ReusableMethods.isEnabled(userPage.firstProductAtRestaurant,"First product not accesseble");
        ReusableMethods.isDisplayed(userPage.firstProductAtRestaurant,"First product not displayed");

        // 6.closes page
        Driver.closeDriver();
        extentTest.info("Browser closed");



    }




}
