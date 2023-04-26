package tests.US_01_07_16_25_34_43;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.JSUtilities;
import utilities.ReusableMethods;

public class US_07 {


    @Test
    public void contactUsSuccesfulMessageSubmitTesti() {

        Actions actions = new Actions(Driver.getDriver());
        UserPage userPage = new UserPage();

        Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));
        userPage.cookie.click();
        ReusableMethods.wait(2);
        JSUtilities.scrollToBottom(Driver.getDriver());
        ReusableMethods.wait(2);
        UserPage.userFooter(5).click();
        userPage.getContactUsfullname.click();
        actions.sendKeys("alonso")
                .sendKeys(Keys.TAB)
                .sendKeys("tolga@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("Hello").perform();
        ReusableMethods.wait(2);
        JSUtilities.scrollToElement(Driver.getDriver(),userPage.getContactUsSubmit);
        ReusableMethods.wait(2);

        userPage.getContactUsSubmit.click();
        ReusableMethods.verifyAssertTrue("Your request has been sent",userPage.getContactUsYourMessage.getText()," ");
        Driver.closeDriver();


    }
}






