package tests.US_04_13_22_28_40;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantPage;
import pages.UserPage;
import utilities.*;

import javax.swing.*;

public class US_22 extends TestBaseRapor {

    @Test
    public void TC_22_01() {
        extentTest=extentReports.createTest("Merchand kullanıcı Profil ");
        MerchantPage merchantPage=new MerchantPage();
        //1-https://qa.mealscenter.com/backoffice/auth/login adresine gider
        //2-Kullanıcı adı ve password girer
        //3-Sing in butonuna tıklar
        MerchantPage.merchantLogin(ConfigReader.getProperty("baiThongUsername"), ConfigReader.getProperty("partnerPassword"));
        extentTest.info("Mechant kullanıcı adı ve sifre ile login olundu");
        //4-Kullanıcı adı na tıklar ve profil seceneginin erişilebilir oldugunu test eder
       ReusableMethods.waitAndClick(merchantPage.kullaniciAdiField);
        ReusableMethods.wait(2);
        ReusableMethods.waitAndClick(merchantPage.profilField);

        Assert.assertTrue(merchantPage.profilFirstNameField.isDisplayed());
        extentTest.pass("Profil fonksiyonunu erişilebilir oldugu test edildi");

        //5-Driver kapatılır
    }

}
