package tests.US_19_37_45;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MerchantPage;
import utilities.*;


public class US_19 extends TestBaseRapor{

    MerchantPage merchantPage;
    @DataProvider
    public static Object[][] merchantLogin() {

        String[][] kullanicilar={{"bektasalakusBurger","123","Gecerli Username, Gecersiz Password "},
                {"bektasalakus","1234567","Gecersiz Username, Gecerli Password "},
                {"bektasalakus","12345","Gecersiz Username, Gecersiz Password "}};
        return kullanicilar;
    }

    @Test(groups = "smoke")
    public void TC_1901PozitifLogin(){

        extentTest = extentReports.createTest("Merchant Pozitif Login Test");
        merchantPage = new MerchantPage();
        // 1- launch browser
        extentTest.info("Browser acildi");
        // 2- https://qa.mealscenter.com/backoffice/auth/login sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));
        extentTest.info("Merchant login sayfasina gidildi");
        // 3- cookies cikiyorsa kabul edin
        // 4- "Remember me" erisilebilir oldugunu dogrulayin "Forgot password" linkine tiklayin
        ReusableMethods.isDisplayed(merchantPage.merchantRememberxLink,"Remember me butonu gorunur degil");
        extentTest.pass("Remember me butonunun gorunur oldugu dogurlandi");
        ReusableMethods.waitAndClick(merchantPage.merchantForgotxLink,1);

        // 5- email box erisilebilir olmali "Request E-mail" butonuna tiklayin ve hata mesajını dogrulayin
        ReusableMethods.isEnabled(merchantPage.merchantEmailxLink,"Email box erisilebilir degil");
        extentTest.pass("Email boxa erisilebilir oldugu dogurlandi");
        ReusableMethods.waitAndClick(merchantPage.merchantEmailButton,1);
        ReusableMethods.isDisplayed(merchantPage.merchantEmessagexLabel,"Hata mesajı gorunur degil");
        extentTest.pass("Hata mesajinin gorunur oldugu dogrulandi");

        // 6- Login here linkine tiklayin
        ReusableMethods.waitAndClick(merchantPage.merchantxLink,1);
        extentTest.pass("Login here linkine tiklandi");

        // 7- logonun, gorselin ve "Merchant Login" textinin gorunur oldugunu test edin
        ReusableMethods.isDisplayed(merchantPage.merchantxLabel,"Merchant Login texti gorunur degil");
        extentTest.pass("Merchant Login textinin gorunur oldugu dogurlandi");
        ReusableMethods.isDisplayed(merchantPage.merchantxImageProfile,"Login panel gorsel gorunur degil");
        extentTest.pass("Gorselin gorunur oldugu dogurlandi");
        ReusableMethods.isDisplayed(merchantPage.merchantxLogo,"Logo gorunur degil");
        extentTest.pass("Logo gorunur oldugu dogurlandi");

        // 8- "App store", "Google play" butonlarina tiklayin ve ilgili sayfaya gittigini dogrulayin
        ReusableMethods.waitAndClick(merchantPage.merchantAppxButton,1);
        ReusableMethods.verifyAssertTrue("store",Driver.getDriver().getCurrentUrl(),"Url store icermiyor");
        extentTest.fail("App Store sayfasina gidilemedi");
        ReusableMethods.waitAndClick(merchantPage.merchantGooglexButton,1);
        extentTest.fail("Google Play sayfasina gidilemedi");
        ReusableMethods.verifyAssertTrue("play",Driver.getDriver().getCurrentUrl(),"Url play icermiyor");

        // 9- gecerli kullanici adi ve password ile giris yapin
        MerchantPage.merchantLogin(ConfigReader.getProperty("burgerUsername"),ConfigReader.getProperty("partnerPassword"));
        extentTest.info("Dogru username ve password girildi");
        // 10- basarili bir sekilde giris yapildigini test edin
        ReusableMethods.verifyAssertTrue("dashboard",Driver.getDriver().getCurrentUrl(), "Url dashboard icermiyor");
        extentTest.pass("Basarili bir sekilde giris yapildi");

        // 11- close browser
        Driver.closeDriver();
        extentTest.info("Browser kapandi");
    }

    @Test(dataProvider = "merchantLogin",groups = "smoke")
    public void TC_1902NegatifLogin(String username, String password,String rapor){
        extentTest = extentReports.createTest("Merchant Negatif Login Test");
        merchantPage = new MerchantPage();
        // 1- launch browser
        extentTest.info("Browser acildi");
        // 2- https://qa.mealscenter.com/backoffice/auth/login sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));
        extentTest.info("Merchant login sayfasina gidildi");
        // 3- cookies cikiyorsa kabul edin

        // 4- Asagidaki durumlarda giris yapilamadigini test edin
        MerchantPage.merchantLogin(username,password);
        extentTest.pass(rapor+" ile giris yapilamadi");
        ReusableMethods.wait(1);

        //      - gecerli username, gecersiz password
        //      - gecersiz username, gecerli password
        //      - gecersiz username, gecersiz password

        // 5- login yapilamadi mesajinin gorunur oldugunu test edin
        ReusableMethods.isDisplayed(merchantPage.merchantEmessagexLabel,"Hata mesaji gorunur degil");
        extentTest.pass("Hata mesajinin gorunur oldugu dogrulandi");
        // 6- close browser
        Driver.closeDriver();
        extentTest.info("Browser kapandi");
    }
}
