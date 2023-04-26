package tests.US_02_05_14_23_32;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.MerchantPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class US_32 extends TestBaseRapor {



    @Test
    public void test_3201() {
        extentTest = extentReports.createTest("Size Attribute Test","Restaurant Managers should able to create, update or delete Size attribute for food items");
        MerchantPage merchantPage = new MerchantPage();
        pickAttribute(merchantPage.sizeButton);
        extentTest.pass("All Size attribute functions work properly");
    }
    @Test
    public void test_3202(){
        extentTest = extentReports.createTest("Ingredients Attribute Test","Restaurant Managers should able to create, update or delete Ingredients attribute for food items");
        MerchantPage merchantPage = new MerchantPage();
        pickAttribute(merchantPage.ingredientsButton);
        extentTest.pass(" All Ingredients attribute functions work properly");
    }
    @Test
    public void test_3203(){
        extentTest = extentReports.createTest("CookingReference Attribute test","Restaurant Managers should able to create, update or delete CookingReference attribute for food items");
        MerchantPage merchantPage = new MerchantPage();
        pickAttribute(merchantPage.cookingReferenceButton);
        extentTest.pass("All CookingReference attribute functions work properly");
    }
    public void pickAttribute(WebElement button){
        Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));
        extentTest.info("Gone to Merchant Login Page");
        MerchantPage.merchantLogin(ConfigReader.getProperty("baiThongUsername"), ConfigReader.getProperty("partnerPassword"));
        extentTest.info("Logged in website as a Merchant User");
        MerchantPage merchantPage = new MerchantPage();
        merchantPage.attributesButton.click();
        extentTest.info("Clicked Attribute button");
        button.click();
        String currentElement=button.getText();
        extentTest.info("Clicked " + currentElement + " button");
        attributeFunctions();
        Driver.closeDriver();
    }
    public void attributeFunctions() {
        MerchantPage merchantPage = new MerchantPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(merchantPage.attributeListText.isDisplayed());
        extentTest.pass("Confirmed that attribute list is displayed");
        //sort the attribute list by number
        String firstRow = merchantPage.listFirstColumn.getText();
        merchantPage.inAttributeNumberButton.click();
        ReusableMethods.wait(1);
        sortNumberTest();
        extentTest.pass("Confirmed that attributes sorted in numerical order when pressed hash button");
        //sort the attribute list by name
        //firstRow = merchantPage.listSecondColumn.getText();
        merchantPage.inAttributeNameButton.click();
        ReusableMethods.wait(1);
        sortNameTest();
        extentTest.pass("Confirmed that attributes sorted in alphabetical order when pressed name button");
        //sort the attribute list by actions
        softAssert.assertTrue(merchantPage.inAttributeActionsButton.isDisplayed());
        extentTest.pass("Confirmed that action button is displayed");
        ReusableMethods.wait(1);
        // search box test
        //firstRow = merchantPage.listFirstColumn.getText();
        merchantPage.inAttributeSearchBoxButton.sendKeys(firstRow);
        merchantPage.inAttributesearchIcon.click();
        ReusableMethods.wait(1);
        softAssert.assertEquals(merchantPage.listFirstColumn.getText(), firstRow);
        extentTest.pass("Confirmed that search Attribute box is displayed and works properly");
        //add new button test
        merchantPage.inAttributeAddNewButton.click();
        extentTest.info("Clicked add new attribute button");
        Faker faker = new Faker();
        String name = faker.name().firstName();
        merchantPage.addAttributeNameBox.sendKeys(name);
        Select select = new Select(merchantPage.statusBox);
        select.selectByValue("draft");
        select.selectByValue("pending");
        select.selectByValue("publish");
        merchantPage.plusIcon.click();
        ReusableMethods.wait(1);
        merchantPage.japaneseBox.sendKeys(faker.name().name());
        merchantPage.arabicBox.sendKeys(faker.name().name());
        ReusableMethods.wait(1);
        merchantPage.plusIcon.click();
        ReusableMethods.wait(1);
        merchantPage.saveButton.click();
        extentTest.info("Sending new attribute features and clicking save button");
        ReusableMethods.wait(1);
        softAssert.assertTrue((merchantPage.listSecondColumn.getText()).contains(name));
        extentTest.pass("Confirmed that add new attribute button works properly, new attribute will appear on the list");
        //update test
        merchantPage.inAttributePencilIcon.click();
        extentTest.info("Clicked update attribute button");
        for (int i = 0; i < 40; i++) {
            merchantPage.addAttributeNameBox.sendKeys(Keys.BACK_SPACE);
        }
        merchantPage.addAttributeNameBox.sendKeys(faker.name().firstName());
        extentTest.info("Sending updated attribute features and clicking save button");
        merchantPage.saveButton.click();
        softAssert.assertTrue(merchantPage.updateAlert.isDisplayed());
        extentTest.pass("Confirmed that update attribute icon works properly, updated attribute features appear on the list");
        //delete test
        merchantPage.allAttributeListButton.click();
        merchantPage.inAttributeTrashIcon.click();
        extentTest.info("Clicked delete attribute icon");
        String firstname = merchantPage.listSecondColumn.getText();
        JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
        ReusableMethods.wait(1);
        jse.executeScript("arguments[0].click();", merchantPage.deleteConfirmButton);
        softAssert.assertNotEquals(firstname, merchantPage.listSecondColumn.getText());
        extentTest.pass("Confirmed that delete attribute icon works properly, before delete asks pop-up question for security");
        firstname = merchantPage.listSecondColumn.getText();
        merchantPage.inAttributeTrashIcon.click();
        ReusableMethods.wait(2);
        merchantPage.cancelButton.click();
        softAssert.assertEquals(firstname, merchantPage.listSecondColumn.getText());
        extentTest.pass("Confirmed that when deleting attribute, picking cancel button on pop-up options cancels process");
        //attribute list page test
        List<WebElement> pagination = Driver.getDriver().findElements(By.xpath("//*[@id='DataTables_Table_0_paginate']/ul/li"));
        if (pagination.size()>3) {
            extentTest.info("Confirmed that attribute list more than 1 page");
            checkListPages(merchantPage.inAttributeNextButton);
            extentTest.pass("Confirmed that on attribute list Next page button works properly");
            checkListPages(merchantPage.inAttributePreviousButton);
            extentTest.pass("Confirmed that on attribute list Previous page button works properly");
            checkListPages(merchantPage.inAttributeNumber2Button);
            extentTest.pass("Confirmed that on attribute list Page 2 button works properly");
            checkListPages(merchantPage.inAttributeNumber1Button);
            extentTest.pass("Confirmed that on attribute list Page 1 button works properly");
        } else {
            System.out.println("There is only 1 page on attribute list");
            extentTest.info("Confirmed that attribute list has only 1 page");
        }
        softAssert.assertAll();
    }
    public void checkListPages(WebElement button){
        SoftAssert softAssert = new SoftAssert();
        MerchantPage merchantPage = new MerchantPage();
        JavascriptExecutor jse=(JavascriptExecutor)Driver.getDriver();
        String firstname = merchantPage.listFirstColumn.getText();
        jse.executeScript("arguments[0].click();", button);
        ReusableMethods.wait(2);
        softAssert.assertNotEquals(firstname, merchantPage.listFirstColumn.getText());
    }
    public void sortNumberTest(){
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> attributeLength = Driver.getDriver().findElements(By.xpath("//tbody/tr"));
        List<Integer> firstColumns = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        for (int i = 1; i <= attributeLength.size() ; i++) {
            String numberLocates = "//tbody/tr[" + i + "]/td[1]";
            // System.out.println(Driver.getDriver().findElement(By.xpath(numberLocates)).getText());
            firstColumns.add(Integer.parseInt(Driver.getDriver().findElement(By.xpath(numberLocates)).getText()));
        }
        // tempList = firstColumns; -> POINTER PROBLEM ÇIKARIYOR FOR LOOP ŞART
        for (Integer each:
                firstColumns) {
            tempList.add(each);
        }
        Collections.sort(firstColumns);
        System.out.println(firstColumns);
        System.out.println(tempList);
        softAssert.assertEquals(firstColumns, tempList);
        softAssert.assertAll();
    }
    public void sortNameTest(){
        // NOT: TÜRKÇE KARAKTERLERİN ASCII DEĞERİ FARKLI OLDUĞU İÇİN İLK HARFİ TC KARAKTER İÇEREN TESTİ DOĞRULAMAZ..
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> attributeLength = Driver.getDriver().findElements(By.xpath("//tbody/tr"));
        List<String> secondColumns = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        for (int i = 1; i <= attributeLength.size() ; i++) {
            String numberLocates = "//tbody/tr[" + i + "]/td[2]";
            // System.out.println(Driver.getDriver().findElement(By.xpath(numberLocates)).getText());
            secondColumns.add(Driver.getDriver().findElement(By.xpath(numberLocates)).getText().toUpperCase());
        }
        //tempList = secondColumns; -> POINTER PROBLEM ÇIKARIYOR FOR LOOP ŞART
        for (String each:
                secondColumns) {
            tempList.add(each);
        }
        Collections.sort(secondColumns);
        System.out.println(secondColumns);
        System.out.println(tempList);
        softAssert.assertEquals(secondColumns, tempList);
        softAssert.assertAll();
    }


}
