package tests.US_09_10_18_27_30_36;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.security.Key;

public class US_09 {

    @Test
    public void TC0901(){
        UserPage userPage=new UserPage();

        // Kullanici https://qa.mealscenter.com/ sayfasına gider
        Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.END).perform();
        ReusableMethods.wait(2);

        userPage.privacyPolicyButton.click();

        String expectedText="Privacy policy";
        String actualText=userPage.privacyPolicyPage.getText();

        Assert.assertEquals(expectedText,actualText);

        Driver.closeDriver();
    }
}
