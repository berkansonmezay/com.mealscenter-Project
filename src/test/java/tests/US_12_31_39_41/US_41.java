package tests.US_12_31_39_41;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_41 extends TestBaseRapor {


    AdminPage adminPage;
    Actions actions;
    SoftAssert softAssert;

    @Test
    public void Test_4101() {
        adminPage = new AdminPage();
        actions = new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("Reviews Page Test", "As an admin, there should be a page where Buyers Reviews can see");

        // https://qa.mealscenter.com/backoffice/login sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Go to mealscenter admin login page");

        // Gecerli username ve password girisi yapilir
        AdminPage.adminLogin(ConfigReader.getProperty("adminUsername"), ConfigReader.getProperty("adminPassword"));
        extentTest.info("Valid username and password entered");

        // Buyers menusunun aktif oldugu dogrulanir
        adminPage.buyersMenu.click();
        ReusableMethods.wait(2);
        ReusableMethods.isDisplayed(adminPage.buyersMenu, "Buyers menu is displayed");
        extentTest.pass("Buyers menu is displayed");
        extentTest.pass("Buyers menu is clickable");

        // Buyers/Reviews menusunun aktif oldugu dogrulanir
        ReusableMethods.wait(2);
        adminPage.reviewsMenu.click();
        ReusableMethods.isDisplayed(adminPage.reviewsMenu, "Reviews menu is displayed");
        extentTest.pass("Reviews menu is displayed");
        extentTest.pass("Reviews menu is clickable");

    }


    @Test
    public void Test_4102() {
        adminPage = new AdminPage();
        actions = new Actions(Driver.getDriver());

        extentTest = extentReports.createTest("Reviews Page Test", "As an Admin, you should be able to sort customer comments,\n" +
                "be able to update and delete");

        // https://qa.mealscenter.com/backoffice/login sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Go to mealscenter admin login page");

        // Gecerli username ve password girisi yapilir
        AdminPage.adminLogin(ConfigReader.getProperty("adminUsername"), ConfigReader.getProperty("adminPassword"));
        extentTest.info("Valid username and password entered");

        adminPage.buyersMenu.click();
        ReusableMethods.wait(2);
        adminPage.reviewsMenu.click();
        ReusableMethods.isDisplayed(adminPage.reviewsMenu, "Reviews menu is displayed");

        // Buyers/Reviews > Reviews/Merchant menusunun gorunur oldugu dogrulanir
        ReusableMethods.wait(2);
        ReusableMethods.isDisplayed(adminPage.merchantKolonu, "Merchant menu is displayed");
        extentTest.pass("Merchant  is displayed");

        // Buyers/Reviews > Reviews/Reviews menusunun gorunur oldugu dogrulanir
        ReusableMethods.wait(2);
        ReusableMethods.isDisplayed(adminPage.reviewsKolonu, "Reviews menu is displayed");
        extentTest.pass("Reviews  is displayed");

        // Buyers/Reviews > Reviews/Actions menusunun gorunur oldugu dogrulanir
        ReusableMethods.wait(2);

        ReusableMethods.isDisplayed(adminPage.actionsKolonu, "Actions menu is displayed");
        extentTest.pass("Actions  is displayed");

        // search boxa "Vegan Season" yazip aratin sonuclarin "Vegan Season" icerdigini dogrulayin
        ReusableMethods.wait(1);
        ReusableMethods.waitAndSendText(adminPage.adminloginSearchBox,"Vegan Season");
        extentTest.pass("Search boxa Vegan Season yazildi");
        ReusableMethods.waitAndClick(adminPage.adminloginBuyutecxIcon);
        extentTest.pass("Arama iconuna tiklandi");
        ReusableMethods.wait(2);
        ReusableMethods.verifyAssertTrue("Vegan Season",adminPage.adminloginSearchResult.getText(),"Arama sonuclari Vegan Season icermiyor");
        extentTest.pass("Search results confirmed to be Vegan Season");
        ReusableMethods.wait(1);


    }
}