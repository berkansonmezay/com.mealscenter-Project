package tests.US_03_08_17_20_26_35_44;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.*;

public class US_08 extends TestBaseRapor {
//Bir ziyaretçi olarak alisveris yaptigim sitenin
    // ödeme ve iade koşullarının belirtildiği bir sayfanın olmasını istiyorum.


    UserPage userPage;
    SoftAssert softAssert;

    @Test
    public void test08() {
        softAssert=new SoftAssert();
        userPage = new UserPage();

        extentTest = extentReports.createTest("home page  test","alisveris yaptigim sitenin odeme ve iade kosularinin " +
                "belirtildigi  bir sayfa olmasi gerek");

        // https://qa.mealscenter.com/ sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));
        extentTest.info("https://qa.mealscenter.com/ sayfasina gidildi");

        //cookies'i kabul eder
       userPage.cookiesUser.click();
        extentTest.info("cookies kabul edildi");

        // home page sayfasinin footer bolumune iner
        ReusableMethods.wait(3);
        JSUtilities.scrollToBottom(Driver.getDriver());
        ReusableMethods.wait(4);
        extentTest.pass("home page sayfainin footer bolumune indi");

        //"Terms and conditions"yazisinin  tiklanabildigi dogrulanmali
        UserPage.userFooter1(7).click();
        extentTest.pass("Terms and conditions yazisinin aktifligi dogrulandi");

        //"Terms and conditions" sayfasina ersildigi dogrulanmali

        String expectedIcerik = "terms-and-conditions";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        if (actualUrl.contains(expectedIcerik)){
            extentTest.pass("terms-and-conditions yazisi web sayfasında bulunmaktadır");
        }else{
            extentTest.fail("terms-and-conditions web sayfasında bulunmamaktadır");
        }

        // "Terms and conditions" sayfasindan "Orders and Payment" yazisinin gorunurlugu dogrulanir
        ReusableMethods.isDisplayed(userPage.termsAndConditionsyazisi, "Orders and Payment");
        extentTest.pass("Orders and Payment is displayed");

        ReusableMethods.wait(2);
        JSUtilities.scrollToElement(Driver.getDriver(),userPage.contactUsYazisiUser);
        ReusableMethods.wait(2);


        //Terms and conditions" sayfasindan "Contact Us"yazisinin gorunurlugiu dogrulanmali
        ReusableMethods.isDisplayed(userPage.contactUsYazisiUser, "Contact Us");
        extentTest.pass("Contact Us is displayed");

        //"Contact Us" yazisinin aciklama kismindaki " info@mealscenter.com."sitesinin aktif olmadigi dogrulanmali
        userPage.contacUsUsEmailButton.click();
        expectedIcerik = "https://qa.mealscenter.com/terms-and-conditions";
        actualUrl = Driver.getDriver().getCurrentUrl();
        if (!(actualUrl.equals(expectedIcerik))){
            extentTest.pass("terms-and-conditions yazisi web sayfasında bulunmaktadır");
        }else{
            extentTest.fail("terms-and-conditions web sayfasında bulunmamaktadır");
        }

        softAssert.assertAll();


        Driver.getDriver().close();
        extentTest.info("browser kapandi");


    }
}










