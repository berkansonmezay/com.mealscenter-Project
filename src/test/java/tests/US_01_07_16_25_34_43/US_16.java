package tests.US_01_07_16_25_34_43;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class US_16 {
    SoftAssert softAssert = new SoftAssert();
    UserPage userPage = new UserPage();
    @Test
    public void accessAddressesPage(){
        Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));
        UserPage.userLogin("bektasalakus@gmail.com","1234567");
        ReusableMethods.wait(2);
        userPage.loginKullanciadi.click();
        userPage.addressesButtonOnProfil.click();
        String expectedContent ="Addresses";
        String actualContent=userPage.addressPageAddressesText.getText();
        softAssert.assertTrue(actualContent.contains(expectedContent));
        softAssert.assertAll();
        Driver.closeDriver();

    }

    @Test
    public void addNewAddress(){
        Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));
        UserPage.userLogin("bektasalakus@gmail.com","1234567");
        ReusableMethods.wait(2);
        userPage.loginKullanciadi.click();
        userPage.addressesButtonOnProfil.click();

        userPage.addNewAddressButton.click();
        userPage.changeAddressTextBox.sendKeys("Texas Tech University"+ Keys.ENTER);
        userPage.selectedAddressText.click();
        ReusableMethods.wait(2);
        userPage.saveAddressButton.click();
        ReusableMethods.wait(3);
        String expectedContent ="2500 Broadway, Lubbock, TX 79409, USA";
        List<WebElement> webElements=userPage.allSavedAddresses;
        String actualContent="";
        for (WebElement web:webElements) {
            String Content=web.getText();
            System.out.println(actualContent);
            if (Content.contains(expectedContent)){
                actualContent=Content;
                System.out.println("Actual Content: "+actualContent);
                break;
            }

        }
        softAssert.assertTrue(actualContent.contains(expectedContent));
        softAssert.assertAll();
        Driver.closeDriver();


    }

}
