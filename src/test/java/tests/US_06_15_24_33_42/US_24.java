package tests.US_06_15_24_33_42;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.MerchantPage;
import utilities.*;

import javax.swing.*;
import java.security.Key;

public class US_24  extends TestBaseRapor{

    //Bir restaurant yöneticisi olarak (restaurantima ait
    // category'leri görüntüleyebilmek, yeni bir category
    // ekleyebilmek , duzenleyebilmek ve silebilmek icin)
    // Category List sayfasinin bulunmasini istiyorum.
    AdminPage adminPage;
    MerchantPage merchantPage;
    Actions actions;

    @Test(priority = 10)
    public void test2401(){
        adminPage = new AdminPage();
        actions = new Actions(Driver.getDriver());
        merchantPage =new MerchantPage();
        extentTest = extentReports.createTest("Test Category list", "Category list sayfasi goruntulenmeli");

        MerchantPage merchantPage=new MerchantPage();
        Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));
        extentTest.info("mealscenter Merchant giris sayfasına gidildi");
        //Gecerli username ve password ile giris yapilir
        MerchantPage.merchantLogin(ConfigReader.getProperty("baiThongUsername"),ConfigReader.getProperty("partnerPassword"));
        extentTest.info("Gecerli username ve password girisi yapıldı");
        merchantPage.foodButton.click();
        merchantPage.categoryButton.click();
        Assert.assertTrue(merchantPage.categoryListCheck.isDisplayed());
        extentTest.pass("Category list gorunebilirliyi chek edeldi");
    }

    @Test(priority = 20)
    public void test2402(){

        merchantPage=new MerchantPage();
        adminPage = new AdminPage();
        actions = new Actions(Driver.getDriver());
        extentTest = extentReports.createTest("Test Category list", "Category list sayfasi goruntulenmeli");

        MerchantPage merchantPage=new MerchantPage();
        Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));
        extentTest.info("mealscenter Merchant giris sayfasına gidildi");
        //Gecerli username ve password ile giris yapilir
        MerchantPage.merchantLogin(ConfigReader.getProperty("baiThongUsername"),ConfigReader.getProperty("partnerPassword"));
        extentTest.info("Gecerli username ve password girisi yapıldı");
        merchantPage.foodButton.click();
        merchantPage.categoryButton.click();
        merchantPage.addNewButton.click();
        extentTest.pass("Add new iconuna tiklandi");
        ReusableMethods.wait(2);
        merchantPage.addNameBox.sendKeys("Fried Tofu test"+Keys.TAB+"Thai Tofu test"+Keys.TAB+Keys.ENTER);
        ReusableMethods.wait(1);
        merchantPage.addFriedTofuButton.click();
        extentTest.pass("Fried Tofu secildi");
        ReusableMethods.wait(1);
        merchantPage.addFilesButton.click();
        extentTest.pass("secilmis bilgiler kaydedildi");
        ReusableMethods.wait(1);
        merchantPage.addBrowseButton2.click();
        extentTest.pass("ikinci bilgi ekrani acildi");
        ReusableMethods.wait(1);
        merchantPage.addFriedTofuButton2.click();
        extentTest.pass("ikinci bilgi secildi");
        ReusableMethods.wait(1);
        merchantPage.addFilesButton2.click();
        extentTest.pass("ikinci bilgiler kaydedildi");
        ReusableMethods.wait(3);
        merchantPage.addsaveCategoryButton.sendKeys(Keys.PAGE_DOWN);
        ReusableMethods.wait(3);
        merchantPage.addsaveCategoryButton.click();
        extentTest.pass("yeni category eklendi");
        ReusableMethods.wait(1);


    }
}
