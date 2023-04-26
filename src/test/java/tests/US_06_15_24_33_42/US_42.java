package tests.US_06_15_24_33_42;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminPage;
import pages.MerchantPage;
import utilities.*;

public class US_42 extends TestBaseRapor {
    //Admin olarak bütün Reviews'lere erişebilmeliyim.
    // liste halinde görebilmeli veMerchant'a göre sıralayabilmeliyim.
    // Review oluşturamamalı, silememeli ama update edebilmeliyim

    AdminPage adminPage;
    Actions actions;
    SoftAssert softAssert;


    @Test(priority = 10) //Merchant baslik
    public void test4101(){

        adminPage = new AdminPage();
        actions = new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("Test Reviews Page", "Buyers Reviews  sayfa goruntulenmeli");

        // https://qa.mealscenter.com/backoffice/login admin giris sayfasi
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("mealscenter admin giris sayfasına gidildi");

        // Gecerli username ve password girisi yapilir
        AdminPage.adminLogin(ConfigReader.getProperty("adminsinan"), ConfigReader.getProperty("adminpassword"));
        extentTest.info("Gecerli username ve password girisi yapıldı");

        // Buyers/Reviews menusunun aktif oldugu dogrulanir
        AdminPage.menuList(10).click();
        AdminPage.menuList(12).click();
        ReusableMethods.wait(2);
        Assert.assertTrue(AdminPage.reviewsChek(2).isDisplayed(),"Reviews is displayed");
        ReusableMethods.wait(1);
        ReusableMethods.clickWithJS(AdminPage.reviewsBaslikChek(2));
        extentTest.pass("Merchant baslik tiklanadi");

        Driver.closeDriver();
    }

    @Test(priority = 20) //Reviews baslik
    public void test4102(){

        adminPage = new AdminPage();
        actions = new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("Test Reviews Page", "Buyers Reviews  sayfa goruntulenmeli");

        // https://qa.mealscenter.com/backoffice/login admin giris sayfasi
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("mealscenter admin giris sayfasına gidildi");

        // Gecerli username ve password girisi yapilir
        AdminPage.adminLogin(ConfigReader.getProperty("adminsinan"), ConfigReader.getProperty("adminpassword"));
        extentTest.info("Gecerli username ve password girisi yapıldı");

        // Buyers/Reviews menusunun aktif oldugu dogrulanir
        AdminPage.menuList(10).click();
        AdminPage.menuList(12).click();
        ReusableMethods.wait(2);
        Assert.assertTrue(AdminPage.reviewsChek(2).isDisplayed(),"Reviews is displayed");
        ReusableMethods.wait(1);
        ReusableMethods.clickWithJS(AdminPage.reviewsBaslikChek(3));
        extentTest.pass("Reviews baslik tiklandi");
        Driver.closeDriver();

    }
    @Test(priority = 30) //ACtions baslik
    public void test4103(){

        adminPage = new AdminPage();
        actions = new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("Test Reviews Page", "Buyers Reviews  sayfa goruntulenmeli");

        // https://qa.mealscenter.com/backoffice/login admin giris sayfasi
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("mealscenter admin giris sayfasına gidildi");

        // Gecerli username ve password girisi yapilir
        AdminPage.adminLogin(ConfigReader.getProperty("adminsinan"), ConfigReader.getProperty("adminpassword"));
        extentTest.info("Gecerli username ve password girisi yapıldı");

        // Buyers/Reviews menusunun aktif oldugu dogrulanir
        AdminPage.menuList(10).click();
        AdminPage.menuList(12).click();
        ReusableMethods.wait(2);
        Assert.assertTrue(AdminPage.reviewsChek(2).isDisplayed(),"Reviews is displayed");
        ReusableMethods.wait(1);
        ReusableMethods.clickWithJS(AdminPage.reviewsBaslikChek(3));
        extentTest.pass("Actions baslik tiklanabiliyor");
        Driver.closeDriver();


    }
    @Test(priority = 40) //Update
    public void test4104(){

        adminPage = new AdminPage();
        actions = new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("Test Reviews Page", "Buyers Reviews  sayfa goruntulenmeli");

        // https://qa.mealscenter.com/backoffice/login admin giris sayfasi
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("mealscenter admin giris sayfasına gidildi");

        // Gecerli username ve password girisi yapilir
        AdminPage.adminLogin(ConfigReader.getProperty("adminsinan"), ConfigReader.getProperty("adminpassword"));
        extentTest.info("Gecerli username ve password girisi yapıldı");

        // Buyers/Reviews menusunun aktif oldugu dogrulanir
        AdminPage.menuList(10).click();
        AdminPage.menuList(12).click();
        ReusableMethods.wait(2);
        Assert.assertTrue(AdminPage.reviewsChek(2).isDisplayed(),"Reviews is displayed");
        ReusableMethods.wait(3);
        if (AdminPage.reviewsUpdateDeleteIcon(1).isDisplayed()){
            AdminPage.reviewsUpdateDeleteIcon(1).click();
            extentTest.pass("Update icon tiklanabiliyor");
        }else {
            extentTest.pass("Update yapilacak yorum bulunamadi");
        }

        Driver.closeDriver();

    }
    @Test(priority = 50) //Delete
    public void test4105(){

        adminPage = new AdminPage();
        actions = new Actions(Driver.getDriver());
        MerchantPage merchantPage=new MerchantPage();

        extentTest = extentReports.createTest("Test Reviews Page", "Buyers Reviews  sayfa goruntulenmeli");

        // https://qa.mealscenter.com/backoffice/login admin giris sayfasi
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("mealscenter admin giris sayfasına gidildi");

        // Gecerli username ve password girisi yapilir
        AdminPage.adminLogin(ConfigReader.getProperty("adminsinan"), ConfigReader.getProperty("adminpassword"));
        extentTest.info("Gecerli username ve password girisi yapıldı");

        // Buyers/Reviews menusunun aktif oldugu dogrulanir
        AdminPage.menuList(10).click();
        AdminPage.menuList(12).click();
        ReusableMethods.wait(2);
        Assert.assertTrue(AdminPage.reviewsChek(2).isDisplayed(),"Reviews is displayed");
        ReusableMethods.wait(2);
        if (AdminPage.reviewsUpdateDeleteIcon(2).isDisplayed()){
            AdminPage.reviewsUpdateDeleteIcon(2).click();
            extentTest.pass("Delete baslik tiklanabiliyor");
            merchantPage.deleteOKButton.click();

        }else {
            extentTest.pass("Silinicek yorum bulunamadi");
        }


        Driver.closeDriver();


    }
}