package tests.US_04_13_22_28_40;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.*;

import javax.swing.*;

public class US_13 extends TestBaseRapor {
    static UserPage userPage = new UserPage();
    static SoftAssert softAssert = new SoftAssert();


    public static void sepeteEkle() {
        userPage = new UserPage();

        //1-https://qa.mealscenter.com/ adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));
        extentTest.info("Home Page e ulasıldı");

        //2-Sing in butonuna tıklar
        //JSUtilities.clickWithJS(Driver.getDriver(),userPage.signInButton);
        // extentTest.pass("Sing in butonunu erişilebilirligini test eder");

        //3-email ve password ile giris yapar
        UserPage.userLogin(ConfigReader.getProperty("customerEmail"), ConfigReader.getProperty("customerPassword"));
        extentTest.info("Dogru kullanıcı adı ve password ile login olundu");

        //4-"Enter Delivery Address" cubuguna adres bilgileri girilir ve "Enter" a basılır
        ReusableMethods.wait(2);
        ReusableMethods.waitAndSendText(userPage.enterDeliveryAddressBox, "Orlando");
        ReusableMethods.waitAndClick(userPage.firstDeliveryAdresOnBox, 1);
        extentTest.info("Adress cubuguna adres bilgisi girildi");

        //5-Gelen restarantlardan biri tıklanır
        ReusableMethods.waitAndClick(userPage.baiTongRestaurant);
        extentTest.info("Sepete urun eklemek için restauranta tıklar");

        //6-Menulerden biri "Add to card" butonuna tıklanarak sepeteeklenir
        ReusableMethods.waitAndClick(userPage.addToCartButton);
        extentTest.info("Sepete eklemek icin urune tıklar");

        //7- checkout butonununa tıklar
        ReusableMethods.waitAndClick(userPage.checkoutButton);
        extentTest.info("urunu sepete ekler");


    }


    @Test
    public void TC_01() {
        extentTest = extentReports.createTest("HomePage Kullanıcı giriş testi", "HomePage de kullanıcı Sing in olabilmeli");
        sepeteEkle();


    }

    @Test
    public void TC_02() {
        extentTest = extentReports.createTest("Card fonksiyonunu Testi", "Ordertype and time basligı altındakı ozellikler");
        //1-https://qa.mealscenter.com/ adresine gider
        //2-Sing in fonksiyonuna tıklar
        //3-email ve password girer
        //4-Sing in butonuna tıklar
        //5-"Enter Delivery Address" cubuguna adres bilgileri girilir ve "Enter" a basılır
        //6-Gelen restarantlardan biri tıklanır
        //7-Menulerden biri "Add to card" butonuna tıklanarak sepete eklenir
        //8- checkout butonunun erişileblir oldugu testedilir
        //9-checkout butonunu tıklar
        sepeteEkle();

        //10-"Order type and time" baslıgı altındalı ilk kutu tıklanır
        ReusableMethods.waitAndClick(userPage.deliveryButton);
        extentTest.info("Delivery cubuguna tıklandı");

        ReusableMethods.waitAndClick(userPage.deliveryRadioButton);
        softAssert.assertTrue(userPage.deliveryRadioButton.isEnabled());
        extentTest.pass("radio buttonun  secildiğini test edildi");

        ReusableMethods.waitAndClick(userPage.dineinRadioButton);
        softAssert.assertTrue(userPage.dineinRadioButton.isEnabled());
        extentTest.pass("radio buttonun  secildiğini test edildi");

        ReusableMethods.waitAndClick(userPage.picupRadioButton);
        softAssert.assertTrue(userPage.picupRadioButton.isEnabled());
        extentTest.pass("radio buttonun  secildiğini test edildi");

        //11-Order type secilir
        ReusableMethods.waitAndClick(userPage.deliveryRadioButton);

        //12-Save butonu tıklanmalı
        ReusableMethods.waitAndClick(userPage.saveButton);

        //13-Driver kapatılır
        //Driver.closeDriver();
    }

    @Test
    public void TC_03() {

        extentTest = extentReports.createTest("Card fonksiyonunu Testi", "Ordertype and time basligı altındakı tarih ve zaman secme ozellikleri");
        //1-https://qa.mealscenter.com/ adresine gider
        //2-Sing in fonksiyonuna tıklar
        //3-email ve password girer
        //4-Sing in butonuna tıklar
        //5-"Enter Delivery Address" cubuguna adres bilgileri girilir ve "Enter" a basılır
        //6-Gelen restarantlardan biri tıklanır
        //7-Menulerden biri "Add to card" butonuna tıklanarak sepeteeklenir
        //8- checkout butonunun erişileblir oldugu testedilir
        //9-checkout butonunu tıklar
        sepeteEkle();

        //10-"Order type and time" baslıgı altındalı ilk kutu tıklanır
        ReusableMethods.wait(4);
        ReusableMethods.waitAndClick(userPage.deliveryButton);
        extentTest.info("Delivery cubuguna tıklandı");

        //11-Radio butondan Order Type secilir
        ReusableMethods.waitAndClick(userPage.deliveryButton);
        extentTest.info("Delivery Radio Button tıklandı");

        //12-"Desired deliver time" kısmında "schedule for later" fonksiyonu secilir
        ReusableMethods.waitAndClick(userPage.scheduleForLaterButton);
        ReusableMethods.wait(3);
        softAssert.assertTrue(userPage.scheduleForLaterButton.isSelected());
        extentTest.pass("schedule for later butonunun setili oldugunu test edildi");

        //13-Cıkan kutuya tıklanarak acılan menuden tarih secilir
        ReusableMethods.selectByValue(userPage.scheduleTarihDropDown, "2023-03-29");
        ReusableMethods.wait(2);
        extentTest.info("Teslimat Tarihi secildi");

        //14-Alttakı kutu tıklanır ve acılan menuden zaman aralıgı secilir
        ReusableMethods.selectByVisibleText(userPage.scheduleTimeDropDown, "10:30 AM - 10:45 AM");
        extentTest.info("Teslimat Saati secildi");

        //15-Save butonuna tıklanır
        ReusableMethods.waitAndClick(userPage.saveButton);
        extentTest.info("secimler onaylandı");

        //16-"Order type and time" baslıgı altındakı ilk kutuda istenen tarih ve zamanın yer aldıgı test edilir
        Select ddm = new Select(userPage.scheduleTarihDropDown);
        String expectedTarih = ddm.getFirstSelectedOption().getText();
        String actual = userPage.tarihDateKontrolFieid.getText();
        softAssert.assertTrue(actual.contains(expectedTarih));
        extentTest.pass("İstenen tarihinsecildigi test edildi");

        ddm = new Select(userPage.scheduleTimeDropDown);
        String expectedTime = ddm.getFirstSelectedOption().getText();
        String actual1 = userPage.tarihDateKontrolFieid.getText();
        softAssert.assertTrue(actual1.contains(expectedTime));
        extentTest.pass("İstenen tarihinsecildigi test edildi");

    }

    @Test
    public void TC_04() {
        extentTest = extentReports.createTest("Promosyon secme testi");
        //1-https://qa.mealscenter.com/ adresine gider
        //2-Sing in fonksiyonuna tıklar
        //3-email ve password girer
        //4-Sing in butonuna tıklar
        //5-"Enter Delivery Address" cubuguna adres bilgileri girilir ve "Enter" a basılır
        //6-Gelen restarantlardan biri tıklanır
        //7-Menulerden biri "Add to card" butonuna tıklanarak sepeteeklenir
        //8- checkout butonunun erişileblir oldugu testedilir
        //9-checkout butonunu tıklar
        sepeteEkle();

        //10-"Order type and time" baslıgı altındaki "Promotion applied" yazan kutu tıklanır.
        ReusableMethods.waitAndClick(userPage.promotionButton, 4);
        extentTest.info("Promotion available kutusu tıklandı");

        //11-Acılan radio butonların secilebildigini test eder
        ReusableMethods.waitAndClick(userPage.promoRadioButton1);
        Assert.assertTrue(userPage.promoRadioButton1.isEnabled());
        extentTest.pass("radio buttonun  secildiğini test edildi");

        ReusableMethods.waitAndClick(userPage.promoRadioButton2);
        Assert.assertTrue(userPage.promoRadioButton2.isEnabled());
        extentTest.pass("radio buttonun  secildiğini test edildi");

        ReusableMethods.waitAndClick(userPage.promoRadioButton3);
        Assert.assertTrue(userPage.promoRadioButton3.isEnabled());
        extentTest.pass("radio buttonun  erişilebilirligi test edildi");

        ReusableMethods.waitAndClick(userPage.promoRadioButton1);

        //13-Save butonuna tıklanır
        ReusableMethods.waitAndClick(userPage.promoSaveButton);


        //14-Driver kapatılır

    }

    @Test
    public void TC_05() {
        extentTest = extentReports.createTest("Odeme secenegi testi");
        //-https://qa.mealscenter.com/ adresine gider
        //2-Sing in fonksiyonuna tıklar
        //3-email ve password girer
        //4-Sing in butonuna tıklar
        //5-"Enter Delivery Address" cubuguna adres bilgileri girilir ve "Enter" a basılır
        //6-Gelen restarantlardan biri tıklanır
        //7-Menulerden biri "Add to card" butonuna tıklanarak sepeteeklenir
        //8- checkout butonunun erişileblir oldugu testedilir
        //9-checkout butonunu tıklar
        sepeteEkle();

        //10-"Payment Methods" baslıgı altında "Cash on deliver" secenegine tıklar
        JSUtilities.scrollToElement(Driver.getDriver(), userPage.paymentKaydiriciBaslik);
        ReusableMethods.waitAndClick(userPage.cashButton, 2);
        extentTest.info("cash odeme secenegine tıklandı");

        //11-Acılan sayfada Add cash butonuna tıklar ve Secimin yapıldıgını test eder
        JSUtilities.scrollToBottom(Driver.getDriver());
        ReusableMethods.waitAndClick(userPage.addCashButton, 2);
        JSUtilities.scrollToBottom(Driver.getDriver());
        Assert.assertTrue(userPage.cashOnayField.isDisplayed());
        extentTest.pass("Cash on Delivery seceneginin eklendigi test edildi");

        //12-"Payment Methods" baslıgı altında "Stripe"  secenegine tıklar
        JSUtilities.scrollToBottom(Driver.getDriver());
        ReusableMethods.waitAndClick(userPage.cashSilmeField);
        ReusableMethods.waitAndClick(userPage.cashDelete);
        userPage.stripeButton.click();
        ReusableMethods.wait(2);
        extentTest.info("stripe secenegi tıklandı");

        //13-Acılan sayfada kart numarası kutusuna tıklar
        Actions actions = new Actions(Driver.getDriver());
        Driver.getDriver().switchTo().frame(userPage.iframeUser);
        ReusableMethods.wait(7);
        userPage.iframeKrediClick.click();
        ReusableMethods.wait(3);
        extentTest.info("Kart bilgileri için uygun yer tıklandı");

        //14-Uygun kart bilgilerini girer
        actions.sendKeys("4242424242424242042424242424").perform();
        ReusableMethods.wait(3);
        Driver.getDriver().switchTo().defaultContent();
        extentTest.info("Kart bilgileri girildi");

        //15-"Add Stripe" butonuna tıklar
        userPage.kredicartKaydet.click();
        //16-secimin yapıldıgını test eder
        Assert.assertTrue(userPage.spriteOnayField.isDisplayed());
        //17-Driver kapatılır
    }

    @Test
    public void TC_06() {
        extentTest = extentReports.createTest("Urun sayısı testi");
        //1-https://qa.mealscenter.com/ adresine gider
        //2-Sing in fonksiyonuna tıklar
        //3-email ve password girer
        //4-Sing in butonuna tıklar
        //5-"Enter Delivery Address" cubuguna adres bilgileri girilir ve "Enter" a basılır
        //6-Gelen restarantlardan biri tıklanır
        //7-Menulerden biri "Add to card" butonuna tıklanarak sepete eklenir
        //8- checkout butonunun erişileblir oldugu testedilir
        //9-checkout butonunu tıklar
        sepeteEkle();

        //10-Restaurant ismine tıklar ve menu secme sayfasın dondugunu test eder
        ReusableMethods.waitAndClick(userPage.baiTongRestaurant);
        JSUtilities.scrollToTop(Driver.getDriver());
        Assert.assertTrue(userPage.addToCartButton.isEnabled());
        extentTest.pass("Restaurant ismine tıklandıgında menu secme sayfasına ulasıldı");

        //11- Urun arttırma eksiltme ve silme fonksiyonlarını test eder
        ReusableMethods.waitAndClick(userPage.checkoutButton);
        String adet = userPage.urunAdetField.getText();
        int ilkadet = Integer.parseInt(adet);
        ReusableMethods.waitAndClick(userPage.plusButton);
        ReusableMethods.wait(2);
        String yeniadet = userPage.urunAdetField.getText();
        int expectedadet = Integer.parseInt(yeniadet);
        Assert.assertTrue(expectedadet > ilkadet);
        extentTest.pass("Urun sayısının arttıgı testedildi");

        ReusableMethods.waitAndClick(userPage.lessButton);
        ReusableMethods.wait(7);
        String sonadet = userPage.urunAdetField.getText();
        int eksiadet = Integer.parseInt(sonadet);
        Assert.assertEquals(ilkadet, eksiadet);
        extentTest.pass("Urun sayısının aaldıgı test edildi");

        ReusableMethods.waitAndClick(userPage.urunSilmeButonu);
        ReusableMethods.wait(2);
        Assert.assertTrue(userPage.emptyCartField.isDisplayed());
        extentTest.pass("Urun sayısının sıfırlandıgı test edildi");

        //12-Place Order butonununa tıklar
        Driver.getDriver().navigate().back();
        ReusableMethods.waitAndClick(userPage.addToCartButton);
        ReusableMethods.waitAndClick(userPage.checkoutButton);
        ReusableMethods.waitAndClick(userPage.placeOrderButton);

        //13-Confirming your order bilgisine ulastıgını test eder
        Assert.assertTrue(userPage.siparisactiveField.isDisplayed());
        extentTest.pass("Siparisin alındıgı test edildi");


        //14-Driver kapatılır

    }
}