package tests.US_01_07_16_25_34_43;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;



public class US_01 {
    UserPage userPage = new UserPage();

    // User home page testi
    @Test
    public void homePageTest(){

        Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));

        String expectedTitle = "Meals Center";
        String actualTitle = Driver.getDriver().getTitle();

        userPage = new UserPage();
        ReusableMethods.wait(1);

        userPage.cookie.click();
        ReusableMethods.wait(1);

        Assert.assertTrue(actualTitle.contains(expectedTitle));
        Driver.closeDriver();

    }

}
