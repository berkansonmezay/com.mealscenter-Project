package tests.US_12_31_39_41;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.*;

public class US_12 extends TestBaseRapor {
    UserPage userPage;
    SoftAssert softAssert;


    @Test
    public void Test_1201(){
        userPage = new UserPage();
        softAssert = new SoftAssert();
        extentTest = extentReports.createTest("Cuisines Page Test","It should be a page of restaurants belonging to cuisine");

        // https://qa.mealscenter.com/ sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));
        extentTest.info("Go to mealscenter.com homepage");

        // Gecerli username ve password girisi yapilir
        UserPage.userLogin(ConfigReader.getProperty("customerEmail"),ConfigReader.getProperty("customerPassword"));
        extentTest.info("Valid username and password entered");

        // Enter Delivery Address Box in aktif oldugu dogrulanir
        ReusableMethods.isEnabled(userPage.enterDeliveryAddressBox,"Enter Delivery Address Box is anabled");
        extentTest.pass("Verified that the Enter Delivery Address Box is active");

        // Enter Delivery Address Box a Seatle yazilir
        userPage.enterDeliveryAddressBox.sendKeys("Seatle");
        extentTest.info("Seattle typed into Enter Delivery Address Box");

        // Secenekler arasında cıkan Seatle yazısı gorunur oldugu dogrulanir
        ReusableMethods.isDisplayed(userPage.seatle,"Seatle text is dsplayed");
       //softAssert.assertTrue(ReusableMethods.waitForClickablility(userPage.Seatle,2).isDisplayed(),"Seatle text is dsplayed");
        extentTest.pass("Seatle text is dsplayed");

        // Secenekler arasında cıkan Seatle yazısına tıklanır
        userPage.seatle.click();

        //Cuisines in gorunur oldugu dogrulanir
        ReusableMethods.isDisplayed(userPage.cuisines,"Cuisines is displayed");
        //softAssert.assertTrue(userPage.Cuisines.isDisplayed(),"Cuisines is displayed");
        extentTest.pass("Cuisines is displayed");
        ReusableMethods.wait(2);

    }


    @Test
    public void Test_1202(){
        userPage = new UserPage();
        softAssert = new SoftAssert();

        extentTest = extentReports.createTest("Filter Page Test","User should be able to filter between restaurants");

        // https://qa.mealscenter.com/ sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));
        extentTest.info("Go to mealscenter.com homepage");

        // Gecerli username ve password girisi yapilir
        UserPage.userLogin(ConfigReader.getProperty("customerEmail"),ConfigReader.getProperty("customerPassword"));
        extentTest.info("Valid username and password entered");
        ReusableMethods.wait(5);

        // Enter Delivery Address Box a Seatle yazilir
        ReusableMethods.waitAndSendText(userPage.enterDeliveryAddressBox,"Seatle");
        // userPage.enterDeliveryAddressBox.sendKeys("Seatle");
        extentTest.info("Type Settle into the Enter Delivery Address Box");

        // Secenekler arasında cıkan Seatle yazısına tıklanır
        ReusableMethods.waitForClickablility(userPage.seatle,3).click();
        extentTest.info("Click on the Seattle text that appears among the options");

        // Drop Down Menu is anabled
        userPage.deliveryDropDown.isEnabled();
        extentTest.pass("Delivery Drop Down Menu is anabled");

        // Drop Down Menu de seceneklerin aktif olduğu test edilir
        userPage.deliveryDropDown.click();
        userPage.deliveryDropDown.click();
        extentTest.pass("Drop Down Menu contains Delivery");
        ReusableMethods.wait(2);
        userPage.deliveryDropDown.click();
        ReusableMethods.wait(2);
        userPage.pickupDropDown.click();
        extentTest.pass("Drop Down Menu contains Pickup");
        ReusableMethods.wait(2);
        userPage.deliveryDropDown.click();
        ReusableMethods.wait(2);
        userPage.dineinDropDown.click();
        extentTest.pass("Drop Down Menu contains Dinein");
        ReusableMethods.wait(3);

        // Place Now Menu is anabled
        userPage.placeNowMenu.isEnabled();
        extentTest.pass("Place Now Menu is anabled");

        // Delivery details window is displayed
        userPage.placeNowMenu.click();
        ReusableMethods.isDisplayed(userPage.deliveryDetailsWindow,"Delivery details window is displayed");
        extentTest.pass("Delivery details window is displayed");
        ReusableMethods.wait(2);

        // Done Button is enabled
        userPage.doneButton.click();
        extentTest.pass("Done Button is enabled");

        // Search Box is enabled
        softAssert.assertTrue(userPage.searchBox.isEnabled(),"Done Button is enabled");
        extentTest.pass("Done Button is enabled");

        // Filter menusunun gorunur oldugunu dogrulayın
        softAssert.assertTrue(userPage.filter.isDisplayed(),"Filter is displayed");
        extentTest.pass("Filter is displayed");

        // Filter menusu icinceki seceneklerin aktif oldugu dogrulanir
        userPage.mostPopularRadioButton.click();
        extentTest.pass("Most Popular Radio Button is anabled");
        ReusableMethods.wait(1);

        userPage.ratingRadioButton.click();
        extentTest.pass("Rating Radio Button is anabled");
        ReusableMethods.wait(1);

        userPage.promoRadioButton.click();
        extentTest.pass("Promo Radio Button is anabled");
        ReusableMethods.wait(1);

        userPage.freeDeliveryFirstOrderRadioButton.click();
        extentTest.pass("Free Delivery First Order Radio Button is anabled");
        ReusableMethods.wait(1);

        // Clear All seceneğinin aktif olduğunu test edin
        userPage.clearAll2.click();
        extentTest.pass("Clear All Button is anabled for Filter");
        ReusableMethods.wait(1);

        // Filter menusu uzerine basıldıgında kapanır
        userPage.filter.click();
        extentTest.pass("Hide filter menu options is anabled");
        ReusableMethods.wait(1);

        // Filter menusu icinceki seceneklerin aktif oldugu dogrulayın
        userPage.showMore.click();
        extentTest.pass("Show More + is anabled");
        ReusableMethods.wait(1);

        userPage.americanChechBox.click();
        extentTest.pass("American Chech Box is anabled");
        ReusableMethods.wait(1);

        userPage.sandwichesChechBox.click();
        extentTest.pass("Sandwiches Chech Box is anabled");
        ReusableMethods.wait(1);

        userPage.mexicanChechBox.click();
        extentTest.pass("Mexican Chech Box is anabled");
        ReusableMethods.wait(1);

        userPage.mediterraneanChechBox.click();
        extentTest.pass("Mediterranean Chech Box is anabled");
        ReusableMethods.wait(1);

        userPage.italianChechBox.click();
        extentTest.pass("Italian Chech Box is anabled");
        ReusableMethods.wait(1);

        userPage.burgersChechBox.click();
        if(!userPage.burgers2ChechBox.isSelected()){
            extentTest.fail("Burgers Chech Box is not anabled");
        }else{
            extentTest.pass("Burgers Chech Box is anabled");
        }
        ReusableMethods.wait(1);

        userPage.japaneseChechBox.click();
        extentTest.pass("Japanese Chech Box is anabled");
        ReusableMethods.wait(1);

        userPage.chineseChechBox.click();
        extentTest.pass("Chinese Chech Box is anabled");
        ReusableMethods.wait(1);

        userPage.halalChechBox.click();
        extentTest.pass("Halal Chech Box is anabled");
        ReusableMethods.wait(1);

        userPage.thaiChechBox.click();
        extentTest.pass("Thai Chech Box is anabled");
        ReusableMethods.wait(1);

        userPage.kosherChechBox.click();
        extentTest.pass("Kosher Chech Box is anabled");
        ReusableMethods.wait(1);

        userPage.vegetarianChechBox.click();
        extentTest.pass("Vegetarian Chech Box is anabled");
        ReusableMethods.wait(1);

        // Cuisines menusu uzerine basıldıgında kapanır
        userPage.cuisines.click();
        extentTest.pass("Hide cuisines menu options is anabled");
        ReusableMethods.wait(2);

        userPage.cuisines.click();
        ReusableMethods.wait(2);
        userPage.filter.click();

        ReusableMethods.wait(2);
        // Clear All seceneğinin aktif olduğunu test edin
        userPage.clearAll2.click();
        extentTest.pass("Clear All Button is anabled for Cuisines");
        ReusableMethods.wait(2);

        // Max Delivery Fee menusunun gorunur oldugunu dogrulayın
        softAssert.assertTrue(userPage.maxDeliveryFee.isDisplayed(),"Max Delivery Fee is displayed");
        extentTest.pass("Max Delivery Fee is displayed");

        //  Max Delivery Fee  menusu uzerine basıldıgında kapanır
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        userPage.maxDeliveryFee.click();
        extentTest.pass("Hide Max Delivery Fee menu options is anabled");
        ReusableMethods.wait(2);
        userPage.maxDeliveryFee.click();

        //  Max Delivery Fee  menusu flitreleme ozelliğini test edin
        actions.click(userPage.maxDeliveryFeeSlider).sendKeys(Keys.ARROW_RIGHT).perform();
        String expected = "Delivery Fee 16";
        String actual = userPage.maxDeliveryFeeSliderLevel.getText();
        softAssert.assertEquals(actual,expected);
        extentTest.pass("Max Delivery Fee Slider is enabled");
        ReusableMethods.wait(2);

        // Raporlam yapılması icin yazılan kod
        softAssert.assertAll();

        Driver.closeDriver();


    }



}
