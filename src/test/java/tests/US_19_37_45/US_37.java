package tests.US_19_37_45;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.*;

import java.time.Duration;

public class US_37 extends TestBaseRapor {
    Actions actions;
    Faker faker;
    AdminPage adminPage;
    @Test
    public void TC_3701Test(){

        extentTest = extentReports.createTest("TC_3701 Testi");
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

        // 6- menuden "merchant" tiklayin ardından "list" secin
        AdminPage.menuList(2).click();
        extentTest.pass("Menuden Merchanta tiklandi");
        ReusableMethods.wait(1);
        AdminPage.menuList(3).click();
        extentTest.pass("Merchant alt basligi olan Liste tiklandi");

        // 7- acilan sayfanin "All Merchant" oldugunu dogrulayin
        ReusableMethods.isDisplayed(adminPage.adminloginVerifyxLabel,"All Merchant texti gorunur degil");
        extentTest.pass("All Merchant textinin gorunur oldugu dogrulandi");

        // 8- search boxa "burger king" yazip aratin sonuclarin "burger king" icerdigini dogrulayin
        ReusableMethods.wait(1);
        ReusableMethods.waitAndSendText(adminPage.adminloginSearchBox,"burger king");
        extentTest.pass("Search boxa burger king yazildi");
        ReusableMethods.waitAndClick(adminPage.adminloginBuyutecxIcon);
        extentTest.pass("Arama iconuna tiklandi");
        ReusableMethods.wait(2);
        ReusableMethods.verifyAssertTrue("Burger",adminPage.adminloginSearchResult.getText(),"Arama sonuclari Burger icermiyor");
        extentTest.pass("Arama sonuclarinin burger king oldugu dogrulandi");
        ReusableMethods.wait(1);

        // 9- "X" butonuna tiklayin
        ReusableMethods.waitAndClick(adminPage.adminloginXxIcon,1);
        extentTest.pass("X iconuna tiklandi");

        // 10- "Name" ,"Address", "Charge Type", "Actions" erisilebilir oldugunu test edin
        ReusableMethods.wait(1);
        AdminPage.tableFilter(2).click();
        extentTest.pass("Filtreden Name tiklandi, dogrulandi");
        AdminPage.tableFilter(3).click();
        extentTest.pass("Filtreden Address tiklandi, dogrulandi");
        AdminPage.tableFilter(4).click();
        extentTest.pass("Filtreden Charge Type tiklandi, dogrulandi");
        AdminPage.tableFilter(5).click();
        extentTest.pass("Filtreden Actions tiklandi, dogrulandi");

        // 11- close browser
        Driver.closeDriver();
        extentTest.info("Browser kapandi");
    }

    @Test
    public void TC_3702Test(){

        adminPage = new AdminPage();
        extentTest = extentReports.createTest("TC_3702 Testi");
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

        // 6- menuden "merchant" tiklayin ardından "list" secin
        AdminPage.menuList(2).click();
        extentTest.pass("Menuden Merchanta tiklandi");
        ReusableMethods.wait(1);
        AdminPage.menuList(3).click();
        ReusableMethods.wait(2);
        extentTest.pass("Merchant alt basligi olan Liste tiklandi");

        // 7- acilan sayfanin "All Merchant" oldugunu dogrulayin
        ReusableMethods.isDisplayed(adminPage.adminloginVerifyxLabel,"All Merchant texti gorunur degil");
        extentTest.pass("All Merchant textinin gorunur oldugu dogrulandi");

        // 8- Add new butonuna tiklayin ve dogrulayin
        ReusableMethods.waitAndClick(adminPage.adminloginAddnewxButton,1);
        extentTest.pass("Add new butonuna tiklandi");
        ReusableMethods.wait(2);
        ReusableMethods.isDisplayed(adminPage.adminloginAddnew403MessagexLabel,"Hata mesaji gorunur degil");
        extentTest.pass("Hata mesajinin gorunur oldugu dogrulandi");

        // 9- bir onceki sayfaya donun
        Driver.getDriver().navigate().back();
        extentTest.info("Bir onceki sayfaya geri donuldu");
        ReusableMethods.wait(1);

        // 10- sayfada "next" butonuna basin
        JSUtilities.scrollToBottom(Driver.getDriver());
        extentTest.info("Sayfada asagi inildi");
        ReusableMethods.waitAndClick(adminPage.adminloginNextxButton);
        extentTest.pass("Next butonuna basilarak bir sonraki listeye gecildi");
        ReusableMethods.wait(1);

        // 11- "Previous" butonuna basarak ilk sayfaya geri donun
        ReusableMethods.waitAndClick(adminPage.adminloginPreviousxButton);
        extentTest.pass("Previous butonuna basilarak bir onceki listeye gecildi");
        ReusableMethods.wait(1);
        JSUtilities.scrollToTop(Driver.getDriver());
        extentTest.info("Sayfada yukari cıkıldı");

        // 12- close browser
        Driver.closeDriver();
        extentTest.info("Browser kapandi");
    }

    @Test(groups = "endtoend")
    public void TC_3703Test(){
        extentTest = extentReports.createTest("Merchant Edit,Delete Test","Yonetici restaurant bilgilerini gorebilir silebilir degistirebilir");
        faker = new Faker();
        actions = new Actions(Driver.getDriver());

        adminPage = new AdminPage();
        // 1- launch browser
        extentTest.info("Browser acildi");
        // 2- https://qa.mealscenter.com/backoffice/login sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Admin login sayfasina gidildi");

        // 3- cookies cikiyorsa kabul edin

        // 4- username ve password kutusuna dogru bilgiler girilerek “sign in” butonuna basin.
        AdminPage.adminLogin(ConfigReader.getProperty("adminUsername"),ConfigReader.getProperty("adminPassword"));
        extentTest.info("Dogru username ve password ile giris yapildi");

        // 5- Basarili giris yapildigini dogrulayın
        ReusableMethods.isDisplayed(adminPage.adminloginKullaniciAdixLink,"Kullanici adi gorunur degil");
        extentTest.pass("Kullanici adinin gorunur oldugu dogrulandi");

        // 6- menuden "merchant" tiklayin ardından "list" secin
        AdminPage.menuList(2).click();
        extentTest.pass("Menuden Merchanta tiklandi");
        ReusableMethods.wait(1);
        AdminPage.menuList(3).click();
        extentTest.pass("Merchant alt basligi olan Liste tiklandi");

        // 7- acilan sayfanin "All Merchant" oldugunu dogrulayin
        ReusableMethods.isDisplayed(adminPage.adminloginVerifyxLabel,"All Merchant texti gorunur degil");
        extentTest.pass("All Merchant textinin gorunur oldugu dogrulandi");

        // 8- "edit" ikonuna tiklayin
        ReusableMethods.waitAndClick(adminPage.adminloginTableEditxIcon,2);
        extentTest.pass("Edit iconuna tiklandi");

        // 9- logonun gorunur oldugunu test edin
        ReusableMethods.isDisplayed(adminPage.adminloginEditxLogo,"Logo gorunur degil");
        extentTest.pass("Logunun gorunur oldugu dogrulandi");

        // 10- menuden Merchant information tiklayin restauranta ait tum bilgileri doldurun save butonu erisilebilir olmali
        ReusableMethods.wait(1);
        adminPage.adminloginBrowsexButton.click();
        ReusableMethods.wait(2);
        adminPage.adminloginUploadxButton.click();
        ReusableMethods.wait(1);
        adminPage.adminloginUploadCloseİcon.click();
        extentTest.fail("Logo yuklenemiyor");
        adminPage.adminloginHeaderxButton.click();
        ReusableMethods.wait(2);
        adminPage.adminloginUpHeadxButton.click();
        ReusableMethods.wait(1);
        adminPage.adminloginHeadCloseİcon.click();
        extentTest.fail("Header yuklenemiyor");
        ReusableMethods.waitAndClick(adminPage.adminloginEditNamexField,2);
        actions.sendKeys(faker.name().fullName()).perform();
        extentTest.pass("Restaurant name boxının erisilebilir oldugu dogurlandi");
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(faker.name().lastName()).perform();
        extentTest.pass("Restaurant Slug boxının erisilebilir oldugu dogurlandi");
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(faker.name().firstName()).perform();
        extentTest.pass("Contact Name boxının erisilebilir oldugu dogurlandi");
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(faker.phoneNumber().cellPhone()).perform();
        extentTest.pass("Contact Phone boxının erisilebilir oldugu dogurlandi");
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(faker.internet().emailAddress()).perform();
        extentTest.pass("Contact email boxının erisilebilir oldugu dogurlandi");
        actions.sendKeys(Keys.TAB)
       .sendKeys(Keys.TAB)
       .sendKeys(Keys.TAB).perform();
        ReusableMethods.wait(1);
        JSUtilities.scrollToElement(Driver.getDriver(),adminPage.adminloginAboutxLabel);
        extentTest.info("Sayfada asagi inildi");
        ReusableMethods.wait(1);
        actions.sendKeys(faker.name().nameWithMiddle()).perform();
        extentTest.pass("About boxının erisilebilir oldugu dogurlandi");
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(faker.name().nameWithMiddle()).perform();
        extentTest.pass("Short About boxının erisilebilir oldugu dogurlandi");

        ReusableMethods.wait(1);
        JSUtilities.scrollToElement(Driver.getDriver(),adminPage.adminloginCuisinexLabel);
        extentTest.info("Sayfada asagi inildi");
        ReusableMethods.wait(1);
        AdminPage.merchantDropdwonList(1).click();
        AdminPage.merchantEditDropdown(3).click();
        extentTest.pass("Cuisine boxının erisilebilir oldugu dogurlandi");
        AdminPage.merchantDropdwonList(2).click();
        AdminPage.merchantEditDropdown(1).click();
        extentTest.pass("Services boxının erisilebilir oldugu dogurlandi");
        AdminPage.merchantDropdwonList(4).click();
        AdminPage.merchantEditDropdown(1).click();
        extentTest.pass("Featured boxının erisilebilir oldugu dogurlandi");
        ReusableMethods.wait(1);
        JSUtilities.scrollToElement(Driver.getDriver(),adminPage.adminloginStatusxLabel);
        extentTest.info("Sayfada asagi inildi");
        ReusableMethods.wait(1);
        ReusableMethods.selectByVisibleText(adminPage.adminloginEditKMDropDown,"Kilometers");
        extentTest.pass("Dropdown menunun erisilebilir oldugu dogurlandi");
        ReusableMethods.waitAndClick(adminPage.adminloginActivexIcon,1);
        ReusableMethods.selectByVisibleText(adminPage.adminloginEditStatusDropDown,"active");
        extentTest.pass("Dropdown menunun erisilebilir oldugu dogurlandi");
        ReusableMethods.isEnabled(adminPage.adminloginSavexButton,"Save butonu erisilebilir degil");
        extentTest.pass("Save butonunun erisilebilir oldugu dogurlandi");
        ReusableMethods.wait(2);

        // 11- menuden Login information tiklayin restauranta ait tum bilgileri doldurun save butonu erisilebilir olmali
        JSUtilities.scrollToTop(Driver.getDriver());
        extentTest.info("Sayfada yukari cikildi");
        ReusableMethods.wait(1);
        AdminPage.merchantMenuList(2).click();
        extentTest.pass("Menuden Login information secildi");
        ReusableMethods.wait(2);
        ReusableMethods.waitAndClick(adminPage.adminloginEditNamexField,3);
        actions.sendKeys(faker.name().firstName()).perform();
        extentTest.pass("First Name boxının erisilebilir oldugu dogurlandi");
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(faker.name().lastName()).perform();
        extentTest.pass("Last Name boxının erisilebilir oldugu dogurlandi");
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(faker.internet().emailAddress()).perform();
        extentTest.pass("Email address boxının erisilebilir oldugu dogurlandi");
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(faker.phoneNumber().cellPhone()).perform();
        extentTest.pass("Contact number boxının erisilebilir oldugu dogurlandi");
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(faker.name().name()).perform();
        extentTest.pass("Username boxının erisilebilir oldugu dogurlandi");
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(faker.internet().password()).perform();
        extentTest.pass("New Password boxının erisilebilir oldugu dogurlandi");
        actions.sendKeys(Keys.TAB).perform();
        actions.sendKeys(faker.internet().password()).perform();
        extentTest.pass("Confirm Password boxının erisilebilir oldugu dogurlandi");
        ReusableMethods.isEnabled(adminPage.adminloginSavexButton,"Save butonu erisilebilir degil");
        extentTest.pass("Save butonunun erisilebilir oldugu dogurlandi");

        // 12- menuden Address tiklayin restauranta ait tum bilgileri doldurun save butonu erisilebilir olmali
        AdminPage.merchantMenuList(3).click();
        extentTest.pass("Menuden Address tiklandi");
        ReusableMethods.wait(2);
        ReusableMethods.waitAndClick(adminPage.adminloginEditNamexField,2);
        actions.sendKeys(faker.address().fullAddress()).perform();
        ReusableMethods.selectByVisibleText(adminPage.adminloginEditKMDropDown,"Kilometers");
        ReusableMethods.isEnabled(adminPage.adminloginSavexButton,"Save butonu erisilebilir degil");
        extentTest.pass("Save butonunun erisilebilir oldugu dogurlandi");

        // 13- menuden Zone tiklayin "Second Distinct" secin save butonu erisilebilir olmali
        AdminPage.merchantMenuList(4).click();
        extentTest.pass("Menuden Zone tiklandi");
        ReusableMethods.wait(2);
        AdminPage.merchantDropdwonList(1).click();
        AdminPage.merchantEditDropdown(1).click();
        ReusableMethods.isEnabled(adminPage.adminloginSavexButton,"Save butonu erisilebilir degil");
        extentTest.pass("Save butonunun erisilebilir oldugu dogurlandi");

        // 14- "Merchant type" click yapin
        AdminPage.merchantMenuList(5).click();
        extentTest.pass("Menuden Merchant type tiklandi");

        // 15- "commission on orders" basligi altinda dropdown menuden "fixed"i secin
        //        -"Invoice terms for offline payment" basligi altinda dropdown menuden "daily" secin
        //        -"Allow to accept offline payment" ikonuna tiklayin
        //        -"save" butonu erisilebilir olmali
        ReusableMethods.selectByVisibleText(adminPage.adminloginMerchantCommissionxDropbox,"Fixed");
        extentTest.pass("Type Dropdown menunun erisilebilir oldugu dogurlandi");
        ReusableMethods.waitAndClick(adminPage.adminloginActivexIcon,1);
        ReusableMethods.selectByVisibleText(adminPage.adminloginMerchantInvoicexDropbox,"Daily");
        extentTest.pass("Commission on orders Dropdown menunun erisilebilir oldugu dogurlandi");
        ReusableMethods.isEnabled(adminPage.adminloginSavexButton,"Save butonu erisilebilir degil");
        extentTest.pass("Save butonunun erisilebilir oldugu dogurlandi");
        ReusableMethods.wait(2);

        // 16-"Featured" click yapin. Featured ikonuna tiklayin, save butonun erisilebilir oldugunu test edin
        AdminPage.merchantMenuList(6).click();
        extentTest.pass("Menuden Featured tiklandi");
        ReusableMethods.waitAndClick(adminPage.adminloginActivexIcon,1);
        extentTest.pass("Featured iconun erisilebilir oldugu dogurlandi");
        ReusableMethods.isEnabled(adminPage.adminloginSavexButton,"Save butonu erisilebilir degil");
        extentTest.pass("Save butonunun erisilebilir oldugu dogurlandi");
        ReusableMethods.wait(2);

        // 17- "Payment history" click yapin
        // "Created", "Payment", "Invoice#",  "Plan" textlerin aktif oldugunu dogrulayin
        AdminPage.merchantMenuList(7).click();
        extentTest.pass("Menuden Payment history tiklandi");
        AdminPage.merchantEditTableFilter(1).click();
        extentTest.pass("Filtreden Created tiklanabilir oldugu dogurlandi");
        AdminPage.merchantEditTableFilter(2).click();
        extentTest.pass("Filtreden Payment tiklanabilir oldugu dogurlandi");
        AdminPage.merchantEditTableFilter(3).click();
        extentTest.pass("Filtreden Invoice# tiklanabilir oldugu dogurlandi");
        AdminPage.merchantEditTableFilter(4).click();
        extentTest.fail("Filtreden Plan tiklanabilir degil");
        ReusableMethods.wait(2);

        // 18- "Payment settings" click yapin "check all" ikonuna tiklayin
        // save butonunun erisilebilir oldugunu dogrulayin
        AdminPage.merchantMenuList(8).click();
        extentTest.pass("Menuden Payment settings tiklandi");
        ReusableMethods.waitAndClick(adminPage.adminloginCheckallxIcon,1);
        extentTest.pass("Check all iconunun tiklanabilir oldugu dogurlandi");
        ReusableMethods.waitAndClick(adminPage.adminloginCheckallxIcon,1);
        ReusableMethods.isEnabled(adminPage.adminloginSavexButton,"Save butonu erisilebilir degil");
        extentTest.pass("Save butonunun erisilebilir oldugu dogurlandi");
        ReusableMethods.wait(2);

        // 19- "others" click yapin "Close this store" ikonuna tiklayin
        // save butonunun erisilebilir oldugunu test edin.
        AdminPage.merchantMenuList(9).click();
        extentTest.pass("Menuden Others tiklandi");
        ReusableMethods.waitAndClick(adminPage.adminloginActivexIcon,1);
        extentTest.pass("Close this store iconunun tiklanabilir oldugu dogurlandi");
        ReusableMethods.isEnabled(adminPage.adminloginSavexButton,"Save butonu erisilebilir degil");
        extentTest.pass("Save butonunun erisilebilir oldugu dogurlandi");
        ReusableMethods.wait(2);

        AdminPage.menuList(3).click();
        ReusableMethods.waitAndClick(adminPage.adminloginTableDeletexIcon);
        extentTest.fail("Delete iconu tiklanabilir degil");
        ReusableMethods.verifyAssertTrue("delete",Driver.getDriver().getCurrentUrl(), "Url delete icermiyor");

        // 20- close browser
        Driver.closeDriver();
        extentTest.info("Browser kapandi");
    }
}
