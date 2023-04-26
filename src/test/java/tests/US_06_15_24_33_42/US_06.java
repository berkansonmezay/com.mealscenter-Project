package tests.US_06_15_24_33_42;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_06 extends TestBaseRapor {

    Faker faker;
    Actions actions;
    UserPage userPage;
    @Test(groups = "smoke")
    public void TC0601(){
        extentTest = extentReports.createTest("User Register Test");
        extentTest.info("Browser acildi");
        Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));
        extentTest.info("User sayfasina gidildi");
        faker = new Faker();
        actions = new Actions(Driver.getDriver());
        userPage=new UserPage();
        String sifre = "TeaM06";
        userPage.cookie.click();
        extentTest.info("Cookies kabul edildi");
        ReusableMethods.wait(1);
        userPage.signInButton.click();
        extentTest.pass("Sign in linkine tiklandi");
        ReusableMethods.wait(1);
        userPage.loginSignUpButton.click();
        extentTest.pass("Sign up linkine tiklandi");
        ReusableMethods.wait(3);
        ReusableMethods.waitAndClick(userPage.regFirstNameBox,1);
        actions.sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone())
                .sendKeys(Keys.TAB)
                .sendKeys(sifre)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(sifre).perform();
        ReusableMethods.wait(2);
        extentTest.pass("Tum bilgiler dolduruldu");
        userPage.regSignUpButtton.click();
        extentTest.pass("Sign up butonuna tiklandi");
        Driver.closeDriver();
        extentTest.info("Browser kapandi");
    }

}
