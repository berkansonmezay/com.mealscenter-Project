package tests.US_02_05_14_23_32;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.UserPage;
import utilities.*;

public class US_05 extends TestBaseRapor{

    UserPage userPage;
    @DataProvider
    public static Object[][] UserLogin() {

        String[][] kullanicilar={{"bektasalakus@gmail.com","123","Gecerli Username, Gecersiz Password "},
                {"bektasalakus","1234567","Gecersiz Username, Gecerli Password "},
                {"bektasalakus","12345","Gecersiz Username, Gecersiz Password "}};
        return kullanicilar;
    }

    @Test(groups = "smoke")
    public void TC_0501PozitifLogin(){

        extentTest = extentReports.createTest("User Pozitif Login Testi");
        userPage = new UserPage();
        // 1- launch browser
        extentTest.info("Browser acildi");
        // 2- https://qa.mealscenter.com/account/login sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));
        extentTest.info("User login sayfasina gidildi");
        userPage.cookie.click();
        userPage.signInButton.click();
        ReusableMethods.wait(1);
        // 4- "Remember me" erisilebilir oldugunu dogrulayin "Forgot password" linkine tiklayin
        ReusableMethods.isDisplayed(userPage.remberme,"Remember me butonu gorunur degil");
        extentTest.pass("Remember me butonunun gorunur oldugu dogurlandi");
        ReusableMethods.waitAndClick(userPage.forgotPassword,1);
        ReusableMethods.wait(2);
        // 5- email box erisilebilir olmali
        ReusableMethods.isEnabled(userPage.emailReset,"Email box erisilebilir degil");
        extentTest.pass("Email boxa erisilebilir oldugu dogurlandi");

        // 6- Login here linkine tiklayin
        ReusableMethods.waitAndClick(userPage.siginForgot,1);
        extentTest.pass("Sign in linkine tiklandi");

        // 9- gecerli kullanici adi ve password ile giris yapin
        userPage.emailBox.sendKeys(ConfigReader.getProperty("customerEmail"));
        userPage.passwordBox.sendKeys(ConfigReader.getProperty("customerPassword"));
        userPage.loginSignInButton.click();
        extentTest.info("Dogru username ve password girildi");
        ReusableMethods.wait(2);
        ReusableMethods.isDisplayed(userPage.loginKullanciadi,"Kullanici adi gorunur degil");
        extentTest.pass("Basarili bir sekilde giris yapildi");

        // 11- close browser
        Driver.closeDriver();
        extentTest.info("Browser kapandi");
    }

    @Test(dataProvider = "UserLogin",groups = "smoke")
    public void TC_0502NegatifLogin(String username, String password,String rapor){
        extentTest = extentReports.createTest("User Negatif Login Testi");
        userPage = new UserPage();
        // 1- launch browser
        extentTest.info("Browser acildi");
        // 2- https://qa.mealscenter.com/account/login sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));
        extentTest.info("User login sayfasina gidildi");

        // 4- Asagidaki durumlarda giris yapilamadigini test edin
        UserPage.userLogin(username,password);
        extentTest.pass(rapor+" ile giris yapilamadi");
        ReusableMethods.wait(1);

        //      - gecerli username, gecersiz password
        //      - gecersiz username, gecerli password
        //      - gecersiz username, gecersiz password

        // 5- login yapilamadi mesajinin gorunur oldugunu test edin
        ReusableMethods.isDisplayed(userPage.userloginalert,"Hata mesaji gorunur degil");
        extentTest.pass("Hata mesajinin gorunur oldugu dogrulandi");
        // 6- close browser
        Driver.closeDriver();
        extentTest.info("Browser kapandi");
    }
}
