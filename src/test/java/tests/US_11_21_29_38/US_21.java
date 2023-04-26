package tests.US_11_21_29_38;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_21 extends TestBaseRapor {
    MerchantPage merchantPage=new MerchantPage();
    @Test
    public void test2101(){
        extentTest = extentReports.createTest("TC_2101 Test","Restaurant owner examines Dashboard menu");

        // launch browser
        extentTest.info("Browser opened");

        // 1- Go to https://qa.mealscenter.com/backoffice/auth/login page
        Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));
        extentTest.pass("Go to restaurant Admin login page");

        // 2- accept cookies if popping up
        //cookies not popping

        // 3- Enter the correct information in the username and password boxes and press the “sign in” button.
        MerchantPage.merchantLogin(ConfigReader.getProperty("baiThongUsername"),ConfigReader.getProperty("baiThongPassword"));
        extentTest.pass("Correct merchant name and password entered");

        // 4- Verify successful login
        ReusableMethods.isDisplayed(Driver.getDriver().findElement(By.xpath("//a[text()='Dashboard']")),
                "Login is not successful");
        extentTest.pass("Successfully logged in");


        // 5- driver close
        Driver.closeDriver();
        extentTest.info("Browser closed");

    }
}
