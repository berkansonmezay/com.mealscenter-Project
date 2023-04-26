package tests.US_19_37_45;

import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.*;

public class US_45 extends TestBaseRapor {
    AdminPage adminPage;
    @Test
    public void TC_4501Test(){

        extentTest = extentReports.createTest("TC_4501 Testi");
        adminPage = new AdminPage();
        // 1- launch browser
        extentTest.info("Browser acildi");
        // 2- https://qa.mealscenter.com/backoffice/login sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Admin login sayfasina gidildi");

        // 3- cookies cikiyorsa kabul edin

        // 4- username ve password kutusuna dogru bilgiler girilerek “sign in” butonuna basin.
        AdminPage.adminLogin(ConfigReader.getProperty("adminUsername"),ConfigReader.getProperty("adminPassword"));
        extentTest.info("Dogru username ve password girildi");

        // 5- Basarili giris yapildigini dogrulayın
        ReusableMethods.isDisplayed(adminPage.adminloginKullaniciAdixLink,"Kullanici adi gorunur degil");
        extentTest.pass("Kullanici adinin gorunur oldugu dogrulandi");

        // 6- menuden "reports" tiklayin ardından "order earnings"  secin
        AdminPage.menuList(13).click();
        extentTest.pass("Menuden Reports tiklandi");
        ReusableMethods.wait(1);
        AdminPage.menuList(17).click();
        extentTest.pass("Reports alt basligi olan Order earnings tiklandi");

        // 7- acilan sayfanin "Order earnings report" oldugunu dogrulayin
        ReusableMethods.isDisplayed(adminPage.adminloginVerifyxLabel,"Order earnings report texti gorunur degil");
        extentTest.pass("Order earnings report textinin gorunur oldugu dogrulandi");

        // 8- close browser
        Driver.closeDriver();
        extentTest.info("Browser kapandi");
    }

    @Test
    public void TC_4502Test(){

        extentTest = extentReports.createTest("TC_4501 Testi");
        adminPage = new AdminPage();
        // 1- launch browser
        extentTest.info("Browser acildi");
        // 2- https://qa.mealscenter.com/backoffice/login sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Admin login sayfasina gidildi");

        // 3- cookies cikiyorsa kabul edin

        // 4- username ve password kutusuna dogru bilgiler girilerek “sign in” butonuna basin.
        AdminPage.adminLogin(ConfigReader.getProperty("adminUsername"),ConfigReader.getProperty("adminPassword"));
        extentTest.info("Dogru username ve password girildi");

        // 5- Basarili giris yapildigini dogrulayın
        ReusableMethods.isDisplayed(adminPage.adminloginKullaniciAdixLink,"Kullanici adi gorunur degil");
        extentTest.pass("Kullanici adinin gorunur oldugu dogrulandi");

        // 6- menuden "reports" tiklayin ardından "order earnings"  secin
        AdminPage.menuList(13).click();
        extentTest.pass("Menuden Reports tiklandi");
        ReusableMethods.wait(1);
        AdminPage.menuList(17).click();
        extentTest.pass("Reports alt basligi olan Order earnings tiklandi");

        // 7- acilan sayfanin "Order earnings report" oldugunu dogrulayin
        ReusableMethods.isDisplayed(adminPage.adminloginVerifyxLabel,"Order earnings report texti gorunur degil");
        extentTest.pass("Order earnings report textinin gorunur oldugu dogrulandi");

        // 8- sayfada "next" butonuna basarak 2. sayfaya gelin
        ReusableMethods.wait(2);
        JSUtilities.scrollToBottom(Driver.getDriver());
        extentTest.info("Sayfada asagi inildi");
        ReusableMethods.waitAndClick(adminPage.adminloginOrderNextxButton);
        extentTest.pass("Next butonuna tiklandi");
        ReusableMethods.wait(2);

        // 9- tum totalleri yazdirin
        ReusableMethods.printListText(Driver.getDriver(),"//tr");

        // 10- "date" den 19 ve 21 gunler arasini secip sonuclari yazdirin
        AdminPage.dateFilter(76).click();
        AdminPage.dateFilter(78).click();
        extentTest.pass("Tarih filtreden 19 ve 21 gun arasi secildi");
        ReusableMethods.wait(2);
        ReusableMethods.printListText(Driver.getDriver(),"//tr");

        // 11- "Order ID", "Subtotal", "Total", "Merchant Earnings", "Admin commission" tiklayin
        AdminPage.merchantEditTableFilter(1).click();
        extentTest.pass("Filtreden Order ID tiklanabilir oldugu dogurlandi");
        AdminPage.merchantEditTableFilter(2).click();
        extentTest.pass("Filtreden Subtotal tiklanabilir oldugu dogurlandi");
        AdminPage.merchantEditTableFilter(3).click();
        extentTest.pass("Filtreden Total tiklanabilir oldugu dogurlandi");
        AdminPage.merchantEditTableFilter(4).click();
        extentTest.pass("Filtreden Merchant Earnings tiklanabilir oldugu dogurlandi");
        AdminPage.merchantEditTableFilter(5).click();
        extentTest.pass("Filtreden Admin commission tiklanabilir oldugu dogurlandi");
        ReusableMethods.wait(1);

        // 12- "Search" boxa "10174" yazin sonuclarin "10174" icerdigini test edin
        ReusableMethods.waitAndSendText(adminPage.adminloginOrderSearchxBox,"10174",2);
        extentTest.pass("Search boxa 10174 yazip aratildi");
        ReusableMethods.verifyAssertTrue("10174",adminPage.adminloginSonucOrder.getText(),"Arama sonucu 10174 icermiyor");
        extentTest.fail("Arama sonucu 10174 icermiyor");
        ReusableMethods.wait(2);

        // 13- close browser
        Driver.closeDriver();
        extentTest.info("Browser kapandi");
    }
}
