package tests.US_04_13_22_28_40;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.TestException;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.*;

public class US_40 extends TestBaseRapor {

    static AdminPage adminPage = new AdminPage();
    static Actions actions = new Actions(Driver.getDriver());

    public static void coupon() {
        adminPage = new AdminPage();
        Driver.getDriver().get("https://qa.mealscenter.com/backoffice/login");
        WebElement usernameLocate = Driver.getDriver().findElement(By.id("LoginForm_username"));
        usernameLocate.sendKeys(ConfigReader.getProperty("adminUsername"));

        //Homepage > login/password textbox
        WebElement passwordLocate = Driver.getDriver().findElement(By.id("LoginForm_password"));
        passwordLocate.sendKeys(ConfigReader.getProperty("adminPassword"));

        //Homepage > login/signin Button
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();

        ReusableMethods.waitAndClick(adminPage.promoField);
        ReusableMethods.waitAndClick(adminPage.couponField);
    }

    @Test
    public void TC_01() {
        extentTest = extentReports.createTest("Admin dashboard coupon testi");
        //1-https://qa.mealscenter.com/backoffice/login adresine gider
        //2-Kullanıcı adı ve sifre girer
        //3-Sing in butonunu tıklar
        //4-Dashboard panelinde Promo secenegine tıklar
        //5-Coupon secenegine tklar
        coupon();
        extentTest.info("Coupon sayfasına ulasıldı");

        //6-Add new butonuna tıklar
        ReusableMethods.waitAndClick(adminPage.addNewButton);
        extentTest.info("Add new butonu tıklandı");
        //7-Driver kapatılır
    }

    @Test
    public void TC_02() {
        actions = new Actions(Driver.getDriver());
        extentTest = extentReports.createTest("Add Coupon testi");
        //1-https://qa.mealscenter.com/backoffice/login adresine gider
        //2-Kullanıcı adı ve sifre girer
        //3-Sing in butonunu tıklar
        //4-Dashboard panelinde Promo seceneginin erişiiebilir oldugunu test eder ve tıklar
        //5-Coupon seceneginin erişilebilir oldugunu test eder ve tklar
        coupon();
        extentTest.info("Coupon sayfasına ulasıldı");

        //6-Add new butonunun erişilebilir oldugunu test eder ve tıklar
        ReusableMethods.waitAndClick(adminPage.addNewButton);
        extentTest.info("Add new butonu tıklandı");

        //7-"Coupon name","Coupon Type","Days Available", "Applicable to merchant","Coupon Options","Status"
        //  kutuları uygun bilgilerle doldurulup "Save" butonuna tıklar
        ReusableMethods.waitAndClick(adminPage.couponNameField, 2);
        actions.sendKeys("team6");
        extentTest.info("kpon ismi eklendi");

        ReusableMethods.selectByVisibleText(adminPage.couponTypeField, "fixed amount");
        extentTest.info("Coupon type secildi");

        ReusableMethods.waitAndClick(adminPage.amountField, 2);
        actions.sendKeys("15");
        extentTest.info("Miktar bilgisi girildi");

        ReusableMethods.waitAndClick(adminPage.minOrderField, 2);
        actions.sendKeys("3");
        extentTest.info("gecerli urun sayısı girildi");

        ReusableMethods.selectByVisibleText(adminPage.daysAvailableField, "wednesday");
        extentTest.info("Gecerli oldugu gun secildi");

        JSUtilities.scrollToBottom(Driver.getDriver());

        ReusableMethods.waitAndClick(adminPage.searchMearchantField, 2);
        ReusableMethods.waitAndClick(adminPage.taiRestaurant);
        extentTest.info("Gecerli oldugu restaurant secildi");

        ReusableMethods.waitAndClick(adminPage.expirationField, 2);
        ReusableMethods.waitAndClick(adminPage.tarihField);
        extentTest.info("gecerli oldugu gun secildi");

        ReusableMethods.selectByVisibleText(adminPage.couponOptions, "Use only once");
        extentTest.info("coupon Options secildi");

        ReusableMethods.selectByVisibleText(adminPage.statusField, "Publish");
        extentTest.info("Coupon statusu secildi");

        ReusableMethods.waitAndClick(adminPage.coponSaveButton);


        //8-Olusturulan yeni kuponun coupon List kısmında gorundugunu test eder
        //9-Driver kapatılır
    }

    @Test
    public void TC_03() {
        extentTest = extentReports.createTest("Coupon Updaye testi");
        //1-https://qa.mealscenter.com/backoffice/login adresine gider
        //2-Kullanıcı adı ve sifre girer
        //3-Sing in butonunu tıklar
        //4-Dashboard panelinde Promo seceneginin erişiiebilir oldugunu test eder ve tıklar
        //5-Coupon seceneginin erişilebilir oldugunu test eder ve tklar
        coupon();
        //6-Update butonunun erişilebiliroldugunu test eder ve tıklar
        ReusableMethods.waitAndClick(adminPage.updateButton);
        //7-kupon bilgilerini gunceller ve Save butonuna tıklar
        ReusableMethods.waitAndClick(adminPage.couponNameField);
        actions.sendKeys("bizimkupon");


        ReusableMethods.waitAndClick(adminPage.couponNameField, 2);
        actions.sendKeys("team");
        extentTest.info("kpon ismi eklendi");

        ReusableMethods.selectByVisibleText(adminPage.couponTypeField, "fixed amount");
        extentTest.info("Coupon type secildi");

        ReusableMethods.waitAndClick(adminPage.amountField, 2);
        actions.sendKeys("10");
        extentTest.info("Miktar bilgisi girildi");

        ReusableMethods.waitAndClick(adminPage.minOrderField, 2);
        actions.sendKeys("30");
        extentTest.info("gecerli urun sayısı girildi");

        ReusableMethods.selectByVisibleText(adminPage.daysAvailableField, "wednesday");
        extentTest.info("Gecerli oldugu gun secildi");

        JSUtilities.scrollToBottom(Driver.getDriver());

        ReusableMethods.waitAndClick(adminPage.searchMearchantField, 2);
        ReusableMethods.waitAndClick(adminPage.taiRestaurant);
        extentTest.info("Gecerli oldugu restaurant secildi");

        ReusableMethods.waitAndClick(adminPage.expirationField, 2);
        ReusableMethods.waitAndClick(adminPage.tarihField);
        extentTest.info("gecerli oldugu gun secildi");

        ReusableMethods.selectByVisibleText(adminPage.couponOptions, "Use only once");
        extentTest.info("coupon Options secildi");

        ReusableMethods.selectByVisibleText(adminPage.statusField, "Publish");
        extentTest.info("Coupon statusu secildi");

        ReusableMethods.waitAndClick(adminPage.coponSaveButton);

        //8-Aynı sayfada "Succesfully updated" yazısının cıktıgını test eder
        Assert.assertTrue(adminPage.succesUpdateField.isDisplayed());
        extentTest.pass("Update basarılı gerceklestigi test edildi");
        //9-Driver kapatılır
    }

    @Test
    public void TC_04() {
        extentTest = extentReports.createTest("All coupon testi");
        //1-https://qa.mealscenter.com/backoffice/login adresine gider
        //2-Kullanıcı adı ve sifre girer
        //3-Sing in butonunu tıklar
        //4-Dashboard panelinde Promo seceneginin erişiiebilir oldugunu test eder ve tıklar
        //5-Coupon seceneginin erişilebilir oldugunu test eder ve tklar
        coupon();
        //6-Update butonunun erişilebiliroldugunu test eder ve tıklar
        ReusableMethods.waitAndClick(adminPage.updateButton);

        //7-kupon bilgilerini gunceller ve Save butonuna tıklar
        //8-"All Coupons" fonksiyonuna tıklar ve Coupon List menusune ulastıgını test eder
        ReusableMethods.waitAndClick(adminPage.allCouponField, 3);
        Assert.assertTrue(adminPage.couponList.isDisplayed());
        extentTest.pass("All coupon a tıklandıgında coupon list e ulasıldı");
    }
}

