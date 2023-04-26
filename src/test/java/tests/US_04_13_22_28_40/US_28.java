package tests.US_04_13_22_28_40;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantPage;
import pages.UserPage;
import utilities.*;

public class US_28 extends TestBaseRapor {

    MerchantPage merchantPage=new MerchantPage();
    @Test
    public void TC_28_01(){
        extentTest=extentReports.createTest("Orders Ready testi");
        //Yeni orders olusturulur
        UserPage userPage=new UserPage();
        US_13.sepeteEkle();
        // ReusableMethods.waitAndClick(userPage.deliveryButton,2);
        //ReusableMethods.waitAndClick(userPage.deliveryRadioButton,2);
        //ReusableMethods.waitAndClick(userPage.saveButton);
        JSUtilities.scrollToBottom(Driver.getDriver());
        ReusableMethods.waitAndClick(userPage.cashButton, 2);
        ReusableMethods.waitAndClick(userPage.addCashButton, 2);
        ReusableMethods.waitAndClick(userPage.placeOrderButton);
        Driver.closeDriver();


        merchantPage=new MerchantPage();
        extentTest=extentReports.createTest("Orders Ready testi");
        //1-https://qa.mealscenter.com/backoffice/auth/login adresine gider
        //2-Kullanıcı adı ve password girer
        //3-Sing in butonuna tıklar
        MerchantPage.merchantLogin(ConfigReader.getProperty("baiThongUsername"), ConfigReader.getProperty("partnerPassword"));
        extentTest.info("Mechant sayfaya login yapıldı");

        //4-Dashboard menusunden Orders secenegine tıklar
        ReusableMethods.waitAndClick(merchantPage.orders);
        ReusableMethods.waitAndClick(merchantPage.newOrdersButtonMerchant);
        ReusableMethods.waitAndClick(merchantPage.AcceptedButtonMerchant);
        ReusableMethods.waitAndClick(merchantPage.orderProcesingField);
        ReusableMethods.waitAndClick(merchantPage.readyForPicupButton);
        extentTest.info("Orders, Orders Ready basamagından onceki iki asama gecildi");

        //5-Orders Ready secenegine tıklar
        ReusableMethods.waitAndClick(merchantPage.ordersReadyField);
        extentTest.info("Orders Ready basmagına gecildi");

        //6-"ready for picup" yazısının gorunur oldugunu test eder
        Assert.assertTrue(merchantPage.ordersReadyOnayField.isDisplayed());
        extentTest.pass("Ordes ın Orders Ready sayfasında gorundugu test edildi");
        //7-Driver kapatılır
    }
}
