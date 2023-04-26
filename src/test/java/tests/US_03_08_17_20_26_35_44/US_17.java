package tests.US_03_08_17_20_26_35_44;

import io.opentelemetry.sdk.trace.ReadableSpan;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_17  extends TestBaseRapor {

    //Bir kullanici olarak sitede hesabıma ait ödeme bilgilerini görüntüleyip,
    // ekleyip, silip ve değiştirebileceğim bir sayfanın olmasını istiyorum.


    UserPage userPage;
    SoftAssert softAssert;


    @Test
    public  void test17(){
        userPage=new UserPage();

        extentTest=extentReports.createTest("payments options test","hesabimdan odeme bilgilerini" +
                "goruntulemeli,silmeli,degistirebilmeli");

        // https://qa.mealscenter.com/ sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));
        extentTest.info("mealscenter ana sayfaya gidildi");

        // ana sayfadaki cookies'i kabul eder
        userPage.cookiesUser.click();
        extentTest.pass("cookies'i kabul etti");

        // kullanici sign in butonuna basar
        userPage.signinButtonUser.click();
        ReusableMethods.wait(2);
        extentTest.info("sign in is clickable");

        //login sayfasindaki username ve password textbox'ina gerekli bilgileri girer
        // UserPage.userLogin(ConfigReader.getProperty("customerEmail"),ConfigReader.getProperty("customerPassword"));

        userPage.usernameUser.sendKeys("umreaslan@gmail.com" + Keys.ENTER);
        userPage.passwordUser.sendKeys("Umre2455" + Keys.ENTER);
        ReusableMethods.wait(2);
        extentTest.pass("gecerli username ve passwordu girdi");


        //login sayfasindaki bilgileri girdikten sonra sign up butonuna basar
        userPage.signUpUser.click();
        extentTest.pass("sign up is clickable");

      //hesabim menusunden "Payments Options" butonuna basar
      userPage.paymentsOptionsUser.click();
      extentTest.pass("Payments Options is clickable");

        //Kullnici  odeme sayfasinda oldugunu test eder

         //String expectedIcerik="/account/payments";
         //String actualUrl=Driver.getDriver().getCurrentUrl();
         //softAssert.assertTrue(actualUrl.contains(expectedIcerik));
       // if (actualUrl.contains(expectedIcerik)){
       //     extentTest.pass("account/payments yazısı web sayfasında bulunmaktadır");
       // }else{
         //   extentTest.fail("account/payments yazısı web sayfasında bulunmamaktadır");
       // }


        //payments sayfasindan "Add new payments"butonuna basar ve odeme ekler
        userPage.addNewpaymentsButtonUser.click();
        ReusableMethods.wait(2);
        extentTest.pass("Add new payments is clickable");

        //payments >Add new payments/cash on delivery butonuna basar
        userPage.cashOnDeliveryButtonUser.click();
        ReusableMethods.wait(2);
        extentTest.pass("cash on delivery is clickable");

        //Cash on delivery  butonuna bastiktan sonra "Add cash"butonuna basar
        userPage.addcashButtonUser.click();
        ReusableMethods.wait(2);
        extentTest.pass("add cash is clickable");

        // add cash butonuna bastiktan sonra eger odeme secenegi onceden varsa icon(x) butonuna basar
        userPage.addCashIconUser.click();
        ReusableMethods.wait(2);
        extentTest.pass("Add cash icon is clickable");

        //Cash On delivery butonundaki delete,edit,... butonlarinin aktif olmadigini test et
        ReusableMethods.waitAndClick(userPage.ucNoktaButtonUser);
        ReusableMethods.wait(1);
        extentTest.fail("... tiklanabilir degil");
        ReusableMethods.verifyAssertTrue("...",Driver.getDriver().getCurrentUrl(), "Url ... icermiyor");

        ReusableMethods.waitAndClick(userPage.deleteButtonUser);
        ReusableMethods.wait(1);
        extentTest.fail("Delete iconu tiklanabilir degil");
        ReusableMethods.verifyAssertTrue("delete",Driver.getDriver().getCurrentUrl(), "url delete icermiyor");

        ReusableMethods.waitAndClick(userPage.editButtonUser);
        ReusableMethods.wait(1);
        extentTest.fail("Edit iconu tiklanabilir degil");
        ReusableMethods.verifyAssertTrue("edit",Driver.getDriver().getCurrentUrl(), "Url edit icermiyor");


        //payments sayfasindan "close payments" butonuna tiklar
        userPage.closePaymentsButtonUser.click();
        ReusableMethods.wait(2);
        extentTest.pass("close payments is clickable");

        //browser'i kapat
        Driver.getDriver().close();
        extentTest.info("browser kapandi");







    }
}





