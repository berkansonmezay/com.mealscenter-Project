package tests.US_06_15_24_33_42;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_15 extends TestBaseRapor {

    UserPage userPage;

    @Test(groups = "endtoend")
    public void TC_1501Test(){

        extentTest = extentReports.createTest("My Orders Test","Bir kullanıcının verdigi siparisi kontol eder");
        extentTest.info("Browser acildi");
        userPage=new UserPage();
        Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));
        extentTest.info("User login sayfasina gidildi");
        UserPage.userLogin(ConfigReader.getProperty("customerEmail"),ConfigReader.getProperty("customerPassword"));
        extentTest.info("Dogru username ve password ile giris yapildi");
        ReusableMethods.wait(1);
        userPage.profilDDM.click();
        extentTest.pass("Profile tiklandi");
        ReusableMethods.wait(1);
        userPage.myOrdersDDM.click();
        extentTest.pass("My orders tiklandi");
        ReusableMethods.verifyAssertTrue("Delivered",Driver.getDriver().findElement(By.xpath("(//span[@class='badge'])[2]")).getText(),"icermiyor");
        extentTest.pass("Verilen siparis dogrulandi");
        ReusableMethods.wait(3);
        Driver.closeDriver();
        extentTest.info("Browser kapandi");

    }
}
