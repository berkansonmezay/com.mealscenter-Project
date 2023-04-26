package tests.US_03_08_17_20_26_35_44;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.*;

public class US_35 extends TestBaseRapor{

    AdminPage adminPage;
    @DataProvider
    public static Object[][] adminLogin() {

        String[][] kullanicilar={{"bektas.alakus","123","Gecerli Username, Gecersiz Password "},
                {"bektasalakus","123456","Gecersiz Username, Gecerli Password "},
                {"bektasalakus","12345","Gecersiz Username, Gecersiz Password "}};
        return kullanicilar;
    }

    @Test(groups = "smoke")
    public void TC_3501PozitifLogin(){

        extentTest = extentReports.createTest("Admin Pozitif Login Test");
        adminPage = new AdminPage();
        // 1- launch browser
        extentTest.info("browser acildi");

        // 2- https://qa.mealscenter.com/backoffice/login sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Admin login sayfasina gidildi");

        // 3- cookies cikiyorsa kabul edin
        // 4- "Remember me" erisilebilir oldugunu dogrulayin "Forgot password" linkine tiklayin
        ReusableMethods.isDisplayed(adminPage.remberme,"Remember me butonu gorunur degil");
        extentTest.pass("Remember me butonunun gorunur oldugu dogurlandi");
        ReusableMethods.waitAndClick(adminPage.forgot,1);

        ReusableMethods.wait(2);
        // 5- email box erisilebilir olmali "Request E-mail" butonuna tiklayin ve hata mesajını dogrulayin
        ReusableMethods.isEnabled(adminPage.forgotemail,"Email box erisilebilir degil");
        extentTest.pass("Email boxa erisilebilir oldugu dogurlandi");
        ReusableMethods.waitAndClick(adminPage.emailboxcl,1);
        ReusableMethods.isDisplayed(adminPage.errorMessage,"Hata mesajı gorunur degil");
        extentTest.pass("Hata mesajinin gorunur oldugu dogrulandi");

        // 6- Login here linkine tiklayin
        ReusableMethods.waitAndClick(adminPage.loginhere,2);
        extentTest.pass("Login here linkine tiklandi");

        // 7- logonun, gorselin ve "Admin Login" textinin gorunur oldugunu test edin
        ReusableMethods.isDisplayed(adminPage.adminxLabel,"Admin Login texti gorunur degil");
        extentTest.pass("Admin Login textinin gorunur oldugu dogurlandi");
        ReusableMethods.isDisplayed(adminPage.adminxImageProfile,"Login panel gorsel gorunur degil");
        extentTest.pass("gorselin gorunur oldugu dogurlandi");
        ReusableMethods.isDisplayed(adminPage.adminxLogo,"Logo gorunur degil");
        extentTest.pass("Logo gorunur oldugu dogurlandi");

        // 8- "App store", "Google play" butonlarina tiklayin ve ilgili sayfaya gittigini dogrulayin
        ReusableMethods.waitAndClick(adminPage.adminAppxButton,1);
        ReusableMethods.verifyAssertTrue("store",Driver.getDriver().getCurrentUrl(),"Url store icermiyor");
        extentTest.fail("App Store sayfasina gidilemedi");
        ReusableMethods.waitAndClick(adminPage.adminGooglexButton,1);
        extentTest.fail("Google Play sayfasina gidilemedi");
        ReusableMethods.verifyAssertTrue("play",Driver.getDriver().getCurrentUrl(),"Url play icermiyor");

        // 9- gecerli kullanici adi ve password ile giris yapin
        AdminPage.adminLogin(ConfigReader.getProperty("adminUsername"),ConfigReader.getProperty("adminPassword"));
        extentTest.info("Dogru username ve password girildi");
        // 10- basarili bir sekilde giris yapildigini test edin
        ReusableMethods.verifyAssertTrue("dashboard",Driver.getDriver().getCurrentUrl(), "Url dashboard icermiyor");
        extentTest.pass("Basarili bir sekilde giris yapildi");

        // 11- close browser
        Driver.closeDriver();
        extentTest.info("browser kapandi");
    }

    @Test(dataProvider = "adminLogin",groups = "smoke")
    public void TC_3502NegatifLogin(String username, String password,String rapor){
        extentTest = extentReports.createTest("Admin Negatif Login Test");
        adminPage = new AdminPage();
        // 1- launch browser
        extentTest.info("browser acildi");

        // 2- https://qa.mealscenter.com/backoffice/auth/login sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Admin login sayfasina gidildi");
        // 3- cookies cikiyorsa kabul edin

        // 4- Asagidaki durumlarda giris yapilamadigini test edin
        AdminPage.adminLogin(username,password);
        extentTest.pass(rapor+" ile giris yapilamadi");
        ReusableMethods.wait(1);

        //      - gecerli username, gecersiz password
        //      - gecersiz username, gecerli password
        //      - gecersiz username, gecersiz password

        // 5- login yapilamadi mesajinin gorunur oldugunu test edin
        ReusableMethods.isDisplayed(adminPage.adminEmessagexLabel,"Hata mesaji gorunur degil");
        extentTest.pass("Hata mesajinin gorunur oldugu dogrulandi");

        // 6- close browser
        Driver.closeDriver();
        extentTest.info("browser kapandi");
    }
}
