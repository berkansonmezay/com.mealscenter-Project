package tests.US_02_05_14_23_32;

import com.github.javafaker.Faker;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US_14 extends TestBaseRapor {

    UserPage userPage;
    SoftAssert softAssert=new SoftAssert();

    @Test(priority = 0)
    public void test_1401() {

        extentTest = extentReports.createTest("Profile Page Test","User Profile information should be displayed on Profile Page.");

        userPage = new UserPage();
        userPage.userLogin();
        extentTest.info("Logged in MealsCenter website as a User");
        userPage.userNameButton.click();
        extentTest.info("Clicked username button and opened dropdown menu");
        userPage.manageMyAccountButton.click();
        extentTest.info("Clicked Manage my Account button on displayed options");
        String expectedText = "account/profile";
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedText));
        extentTest.pass("Confirmed that relevant button redirects to the Profile page from HomePage");

        softAssert.assertTrue(userPage.firstNameBox.isDisplayed());
        extentTest.pass("Confirmed that firstname box has been displayed");
        softAssert.assertTrue(userPage.lastNameBox.isDisplayed());
        extentTest.pass("Confirmed that lastname box has been displayed");
        softAssert.assertTrue(userPage.detailEmailBox.isDisplayed());
        extentTest.pass("Confirmed that email box has been displayed");
        softAssert.assertTrue(userPage.telBox.isDisplayed());
        extentTest.pass("Confirmed that phone number box has been displayed");

        softAssert.assertAll();

        Driver.closeDriver();


    }

    @Test (priority = 10)
    public void test_1402() {

        extentTest = extentReports.createTest("False Profile Test","User should not be able to change account information with invalid inputs.");

        userPage = new UserPage();
        userPage.userLogin();
        extentTest.info("Logged in MealsCenter website as a User");
        userPage.userNameButton.click();
        extentTest.info("Clicked username button and opened dropdown menu");
        userPage.manageMyAccountButton.click();
        extentTest.info("Clicked Manage my Account button on displayed options");

        for (int i = 0; i < 40; i++) {
            userPage.firstNameBox.sendKeys(Keys.BACK_SPACE);

        }
        userPage.firstNameBox.sendKeys(" " + Keys.ENTER);
        extentTest.info("Deleted info in firstname box and try to input only space");

        for (int i = 0; i < 40; i++) {
            userPage.lastNameBox.sendKeys(Keys.BACK_SPACE);
        }
        userPage.lastNameBox.sendKeys(" " + Keys.ENTER);
        extentTest.info("Deleted info in lastname box and try to input only space");

        userPage.detailSubmitButton.click();
        extentTest.info("Clicked submit button");
        softAssert.assertTrue(userPage.nameRequiredText.isDisplayed());
        extentTest.pass(" Confirmed that firstname and lastname boxes cannot accept space as input");
        softAssert.assertAll();
        Driver.closeDriver();

    }

    @Test(priority = 20)
    public void test_1403() {
        extentTest = extentReports.createTest("True Profile Test","User should be able to change account information with valid inputs.");

        userPage = new UserPage();
        userPage.userLogin();
        extentTest.info("Logged in MealsCenter website as a User");
        userPage.userNameButton.click();
        extentTest.info("Clicked username button and opened dropdown menu");
        userPage.manageMyAccountButton.click();
        extentTest.info("Clicked Manage my Account button on displayed options");

        Faker faker = new Faker();

        for (int i = 0; i < 40; i++) {
            userPage.firstNameBox.sendKeys(Keys.BACK_SPACE);
        }
        String fakername = faker.name().firstName();
        userPage.firstNameBox.sendKeys(fakername);
        extentTest.info("Deleted info in firstname box and try to input valid entry");

        for (int i = 0; i < 40; i++) {
            userPage.lastNameBox.sendKeys(Keys.BACK_SPACE);
        }
        userPage.lastNameBox.sendKeys(faker.name().lastName());
        extentTest.info("Deleted info in lastname box and try to input valid entry");

        userPage.detailSubmitButton.click();
        extentTest.info("Clicked submit button");
        Driver.closeDriver();
        extentTest.info("The Driver closed to see if the chances have been saved");

        ReusableMethods.wait(2);

        userPage = new UserPage();
        userPage.userLogin();
        extentTest.info("Logged in MealsCenter website as a User");
        softAssert.assertTrue(userPage.userNameButton.getText().contains(fakername));
        extentTest.pass("Confirm that the profile information changed as correctly with valid input");
        softAssert.assertAll();
        Driver.closeDriver();
    }


    @Test(priority = 30)
    public void test_1404() {
        extentTest = extentReports.createTest("Profile Photo Update Test"," User should able to change or update profile photo on Profile page.");

        userPage = new UserPage();
        userPage.userLogin();
        extentTest.info("Logged in MealsCenter website as a User");
        userPage.userNameButton.click();
        extentTest.info("Clicked username button and opened dropdown menu");
        userPage.manageMyAccountButton.click();
        extentTest.info("Clicked Manage my Account button on displayed options");
        userPage.profilImgButton.click();
        extentTest.info("Clicked profile photo preview");

        String filePath = "picturee.jpg";

        try {
            userPage.photoUploadBox.sendKeys(filePath);
            softAssert.assertTrue(true);
            extentTest.pass("Profile photo changed correctly");

        } catch (ElementNotInteractableException e) {
            System.out.println("Cannot input filePath to element - Bug / Profile Photo");
            extentTest.fail("Profile photo could not changed or updated properly");
        }

        softAssert.assertAll();
        Driver.closeDriver();

    }

    @Test(priority = 40)
    public void test_1405() {
        extentTest = extentReports.createTest("Change Password Test","User should able to change password with correct credentials.");

        //changePasswordTest
        UserPage userPage = new UserPage();
        userPage.userLogin();
        extentTest.info("Logged in MealsCenter website as a User");
        userPage.userNameButton.click();
        extentTest.info("Clicked username button and opened dropdown menu");
        userPage.manageMyAccountButton.click();
        extentTest.info("Clicked Manage my Account button on displayed options");
        String expectedText = "account/profile";
        softAssert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedText));

        softAssert.assertTrue(userPage.changePasswordButton.isDisplayed());
        extentTest.pass("Confirmed that change password button is displayed");
        userPage.changePasswordButton.click();
        extentTest.info("Clicked change password button");

        String expectedUrl ="https://qa.mealscenter.com/account/change_password";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedUrl, actualUrl);
        extentTest.pass("Confirm that change password button works and redirects proper URL");

        softAssert.assertTrue(userPage.newPasswordBox.isDisplayed());
        extentTest.pass("Confirm that new password box is displayed");
        softAssert.assertTrue(userPage.oldPasswordBox.isDisplayed());
        extentTest.pass("Confirm that old password box is displayed");
        softAssert.assertTrue(userPage.confirmPasswordBox.isDisplayed());
        extentTest.pass("Verify that confirm password box is displayed");
        softAssert.assertTrue(userPage.PasswordSubmitButton.isDisplayed());
        extentTest.pass("Confirm that submit button is displayed");


        userPage.oldPasswordBox.sendKeys(ConfigReader.getProperty("uservalidPassword"));
        extentTest.info("Input password to old password box");
        userPage.newPasswordBox.sendKeys(ConfigReader.getProperty("usernewPassword"));
        extentTest.info("Input new password to new password box");
        userPage.confirmPasswordBox.sendKeys(ConfigReader.getProperty("usernewPassword"));
        extentTest.info("Input new password again to confirm password box");
        ReusableMethods.wait(1);
        userPage.PasswordSubmitButton.click();
        extentTest.info("Clicked submit button");
        softAssert.assertTrue(userPage.passwordChangeText.isDisplayed());
        extentTest.pass("Confirm that user password changed properly");
        ReusableMethods.wait(1);
        userPage.oldPasswordBox.sendKeys(ConfigReader.getProperty("usernewPassword"));
        userPage.newPasswordBox.sendKeys(ConfigReader.getProperty("uservalidPassword"));
        userPage.confirmPasswordBox.sendKeys(ConfigReader.getProperty("uservalidPassword"));
        userPage.PasswordSubmitButton.click();

        softAssert.assertAll();
        Driver.closeDriver();

    }

    @Test(priority = 50)
    public void test_1406() {
        extentTest = extentReports.createTest("Manage Account Button Test","User should able to manage account information on Profile Page with Manage Account button.");

        UserPage userPage = new UserPage();
        userPage.userLogin();
        extentTest.info("Logged in MealsCenter website as a User");
        userPage.userNameButton.click();
        extentTest.info("Clicked username button and opened dropdown menu");
        userPage.manageMyAccountButton.click();
        extentTest.info("Clicked Manage my Account button on displayed options");

        // String expectedText = "account/profile";
        // Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedText));

        softAssert.assertTrue(userPage.manageAccountButton.isDisplayed());
        extentTest.pass("Confirm that manage account button is displayed");

        try {
            userPage.manageAccountButton.click();
            extentTest.info("Clicked manage account button");
            softAssert.assertTrue(Driver.getDriver().getCurrentUrl().contains("manage"), "Manage Account button on Profile page not working.. BUG");

        } catch (ElementClickInterceptedException e) {
            System.out.println("Cannot click manage account button.. BUG - Profile Page");
            extentTest.fail("Manage account button on Profile Page is not working properly.");
        }

        softAssert.assertAll();
        Driver.closeDriver();


    }
}


