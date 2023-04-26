package tests.US_09_10_18_27_30_36;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.UserPage;
import utilities.*;

public class US_10 extends TestBaseRapor {

    UserPage userPage;
    Actions actions;
    Faker faker;
    @Test(groups = "endtoend")
    public void TC_1001Test(){

        extentTest = extentReports.createTest("New Restaurant Register","Yeni bir restaurant kaydı olusturur");
        extentTest.info("Browser acildi");
        actions = new Actions(Driver.getDriver());
        userPage = new UserPage();
        faker = new Faker();
        Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));
        extentTest.info("User login sayfasina gidildi");
        ReusableMethods.waitAndClick(userPage.cookie,1);
        ReusableMethods.wait(3);
        JSUtilities.scrollToElement(Driver.getDriver(),userPage.kaydirici);
        extentTest.info("Sayfada asagi inildi");
        ReusableMethods.wait(1);
        ReusableMethods.waitAndClick(userPage.joinButton,1);
        extentTest.pass("Join butonuna tiklandi");
        ReusableMethods.waitAndClick(userPage.storeName,1);
        actions.sendKeys("Team06")
                .sendKeys(Keys.TAB)
                .sendKeys(faker.address().fullAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().emailAddress())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone()).perform();
       ReusableMethods.waitAndClick(userPage.commissionCheckbox,1);
       ReusableMethods.waitAndClick(userPage.submitButton,1);
       ReusableMethods.wait(1);
       ReusableMethods.waitAndClick(userPage.storeName,1);
        extentTest.pass("Tum restaurant bilgileri dolduruldu");
       actions.sendKeys("Team06")
               .sendKeys(Keys.TAB)
               .sendKeys(faker.name().lastName())
               .sendKeys(Keys.TAB)
               .sendKeys(faker.internet().emailAddress())
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.TAB)
               .sendKeys(faker.phoneNumber().cellPhone())
               .sendKeys(Keys.TAB)
               .sendKeys(faker.name().username())
               .sendKeys(Keys.TAB)
               .sendKeys("TeaM06")
               .sendKeys(Keys.TAB)
               .sendKeys(Keys.TAB)
               .sendKeys("TeaM06").perform();
        extentTest.pass("Tum Kullanici bilgileri dolduruldu");
       ReusableMethods.wait(2);
       JSUtilities.scrollToElement(Driver.getDriver(),userPage.kaydirici2);
       extentTest.info("Sayfada asagi inildi");
       ReusableMethods.wait(1);
       ReusableMethods.waitAndClick(userPage.JoinSignUP,2);
       extentTest.pass("SignUp butonuna tiklandi");
       extentTest.pass("Browser kapandi");




    }
}
