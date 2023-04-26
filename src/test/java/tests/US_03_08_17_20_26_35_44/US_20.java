package tests.US_03_08_17_20_26_35_44;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_20 extends TestBaseRapor {

    //Bir restaurant yöneticisi olarak password'ü unuttugumda
// iceriklerime ulasmami saglayacak
// yeni sifremi olusturmak icin
// Forgot Password sayfasinin olmasini istiyorum.

    MerchantPage merchantPage;
    Actions actions=new Actions(Driver.getDriver());
    @Test
    public  void test20(){
         merchantPage=new MerchantPage();

         extentTest=extentReports.createTest("Merchant Login forgot password testi","restoran " +
                 "yoneticisi olarak passwordumu unuttugumda tekrar password olusturabilmeliyim");

        //1-https://qa.mealscenter.com/backoffice/auth/login adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));
        extentTest.info("web sayfasina erisildi");

        //2-Merchant Login sayfasina gecerli username  girilir
        actions.click(merchantPage.usernameMarchant)
                .sendKeys(ConfigReader.getProperty("baiThongUsername")).perform();
        extentTest.pass("Merchant Login sayfasina gecerli username girildi");


        //3-Forgot password butonuna basilir
        merchantPage.forgotPasswordMarchant.click();
        ReusableMethods.wait(2);
        extentTest.pass("Forgot password is clickable");

        //4-forgot password sayfasindaki EmailAdress butonuna gecerli email girilir
         actions=new Actions(Driver.getDriver());
        actions.click(merchantPage.forgotPasswordEmailMerchant)
                .sendKeys(ConfigReader.getProperty("customerEmail")).perform();
        ReusableMethods.wait(2);
        extentTest.pass("gecerli EmailAdress  girildi");


        //5-gecerli email adresi girdikten sonra "Login here"butonuna basilir
        merchantPage.loginHereMerchant.click();
        ReusableMethods.wait(2);
        extentTest.pass("Login here is clickable");

        //6-merchant login sayfasina girince tekrar gecerli username ve password  girilir
        MerchantPage.merchantLogin(ConfigReader.getProperty("baiThongUsername"),ConfigReader.getProperty("partnerPassword"));
        extentTest.pass("gecerli username ve password girildi");

       //gecerli username ve password girdikten sonra "sign in"butonuna basar
        merchantPage.signInButtonMarchant.click();
        ReusableMethods.wait(2);
        extentTest.pass("sign in is clickable");

         //sayfayi kapatir
        Driver.getDriver().close();
        extentTest.info("browser kapandi");









    }

}




