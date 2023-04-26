package tests.US_06_15_24_33_42;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.security.Key;

public class US_33 extends TestBaseRapor {

    //Bir restaurant yöneticisi olarak ürünlerimi daha
    // cok musteriye ulastirabilmek icin cesitli promo'lar
    // olusturup müsterilerime kullandirtmak icin bir Promo menusunun olmasini istiyorum.
    AdminPage adminPage;
    MerchantPage merchantPage;
    Actions actions;
    @Test(priority = 10) //test
    public void test3301(){
        adminPage = new AdminPage();
        actions = new Actions(Driver.getDriver());
        merchantPage =new MerchantPage();
        extentTest = extentReports.createTest("Test Coupon", "Coupon sayfasi goruntulenmeli");

        MerchantPage merchantPage=new MerchantPage();
        Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));
        extentTest.info("mealscenter Merchant giris sayfasına gidildi");
        //Gecerli username ve password ile giris yapilir
        MerchantPage.merchantLogin(ConfigReader.getProperty("baiThongUsername"),ConfigReader.getProperty("partnerPassword"));
        extentTest.info("Gecerli username ve password girisi yapıldı");
        merchantPage.promoButton.click();
        merchantPage.couponButton.click();
        Assert.assertTrue(merchantPage.couponButton.isDisplayed());
        extentTest.pass("Coupon safyasi gorunebilirliyi chek edeldi");


    }
    @Test(priority = 20)// add new coupon
    public void test3302(){
        Faker faker=new Faker();
        adminPage = new AdminPage();
        actions = new Actions(Driver.getDriver());
        merchantPage =new MerchantPage();
        extentTest = extentReports.createTest("Test Coupon", "Coupon sayfasi goruntulenmeli");

        MerchantPage merchantPage=new MerchantPage();
        Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));
        extentTest.info("mealscenter Merchant giris sayfasına gidildi");
        //Gecerli username ve password ile giris yapilir
        MerchantPage.merchantLogin(ConfigReader.getProperty("baiThongUsername"),ConfigReader.getProperty("partnerPassword"));
        extentTest.info("Gecerli username ve password girisi yapıldı");
        merchantPage.promoButton.click();
        merchantPage.couponButton.click();
        Assert.assertTrue(merchantPage.couponButton.isDisplayed());
        extentTest.pass("Coupon safyasi gorunebilirliyi chek edeldi");
        merchantPage.addNewButton.click();
        ReusableMethods.wait(2);
        merchantPage.addCouponBox.sendKeys(faker.name().username()+ Keys.TAB+
                Keys.TAB+
                "20"+ Keys.TAB+
                "200"+Keys.TAB+
                "m"+Keys.ENTER+
                Keys.TAB+
                Keys.PAGE_DOWN);
        extentTest.pass("Yeni coupon bilgiler girilerek eklendi");
        ReusableMethods.wait(2);
        MerchantPage.couponDateClick(35).click();
        extentTest.pass("Tarih bilgisi girildi");
        ReusableMethods.wait(3);
        merchantPage.addsaveCategoryButton.click();
        extentTest.pass("Coupon kaydedildi");


    }

    @Test(priority = 30)// delete button
    public void test3303() {
        adminPage = new AdminPage();
        actions = new Actions(Driver.getDriver());
        merchantPage =new MerchantPage();
        extentTest = extentReports.createTest("Test Delete", "Delete Coupon iconu goruntulenmeli");

        MerchantPage merchantPage=new MerchantPage();
        Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));
        extentTest.info("mealscenter Merchant giris sayfasına gidildi");
        //Gecerli username ve password ile giris yapilir
        MerchantPage.merchantLogin(ConfigReader.getProperty("baiThongUsername"),ConfigReader.getProperty("partnerPassword"));
        extentTest.info("Gecerli username ve password girisi yapıldı");
        merchantPage.promoButton.click();
        merchantPage.couponButton.click();
        Assert.assertTrue(merchantPage.couponButton.isDisplayed());
        extentTest.pass("Coupon sayfasi gorunebilirliyi chek edeldi");
        ReusableMethods.wait(3);
        if (merchantPage.couponKontrol.isDisplayed())
        {
            merchantPage.deleteButton.click();
            extentTest.pass("Delete icona tiklandi");
            ReusableMethods.wait(1);
            merchantPage.deleteOKButton.click();
            extentTest.pass("Delete onay yapildi");

        }
        else {
            System.out.println("Ekli coupon bulunamadi");
            extentTest.pass("Aktif silinebilecek coupon Bulunamadi");
        }
    }

    @Test(priority = 40)// update button
    public void test3304() {
        adminPage = new AdminPage();
        actions = new Actions(Driver.getDriver());
        merchantPage =new MerchantPage();
        Faker faker=new Faker();
        extentTest = extentReports.createTest("Test Update Coupon", "Update coupon iconu goruntulenmeli");

        MerchantPage merchantPage=new MerchantPage();
        Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));
        extentTest.info("mealscenter Merchant giris sayfasına gidildi");
        //Gecerli username ve password ile giris yapilir
        MerchantPage.merchantLogin(ConfigReader.getProperty("baiThongUsername"),ConfigReader.getProperty("partnerPassword"));
        extentTest.info("Gecerli username ve password girisi yapıldı");
        merchantPage.promoButton.click();
        merchantPage.couponButton.click();
        Assert.assertTrue(merchantPage.couponButton.isDisplayed());
        extentTest.pass("Coupon sayfasi gorunebilirliyi chek edeldi");
        ReusableMethods.wait(1);
        if (merchantPage.couponKontrol.isDisplayed()){
            ReusableMethods.wait(1);
            merchantPage.updateIcon.click();
            extentTest.pass("Update iconuna tiklandi");
            ReusableMethods.wait(3);
            merchantPage.addCouponBox.clear();
            merchantPage.addCouponBox.sendKeys(faker.name().username()+Keys.TAB+
                    Keys.TAB+
                    "35"+
                    Keys.TAB+
                    "250"+
                    Keys.TAB+
                    "w"+
                    Keys.ENTER+
                    Keys.PAGE_DOWN);
            extentTest.pass("Coupon bilgileri duzenlendi");
            ReusableMethods.wait(5);
            merchantPage.addsaveCategoryButton.click();
            extentTest.pass("Coupon kaydedildi");
            ReusableMethods.wait(3);

        }
        else {
            System.out.println("Ekli coupon bulunamadi");
            extentTest.pass("Aktif update yapilabilecek coupon Bulunamadi");
        }
    }
}
