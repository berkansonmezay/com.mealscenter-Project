package tests.US_09_10_18_27_30_36;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_18 {


    @Test
    public void TC1801(){

        UserPage userPage=new UserPage();
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();

        // 1. Kullanici https://qa.mealscenter.com/ sayfasına gider
        Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));
        // 2. Signin butonuna tıklanır
        //3.Mobil number or email alanına gecerli email adresi girilir
        // 4. Passwor alanına gecerli password girilir
        userPage.userLogin(ConfigReader.getProperty("customerEmail"),ConfigReader.getProperty("customerPassword"));
        // 5. Sign butonuna tıklanır
        userPage.signInButton.click();

       // 6. Kullanıcı girisi yapıldıgı dogrulanır
      //String expectedTitle=" esra ";
       //tring actualTittle=userPage.loginElementi.getText();
      //Assert.assertTrue(actualTittle.contains(expectedTitle));


       // 7. Popular near by alanında ilk restorana tıklanır
        ReusableMethods.wait(5);
        js.executeScript("arguments[0].scrollIntoView(true);", userPage.mcDonalds);
        ReusableMethods.wait(1);
        String expectedProduct=userPage.mcDonalds.getText();


        userPage.mcDonalds.click();

      //  8. Restoran sayfasının acıldıgı dogrulanir
        String expectedTitle="McDonalds";
        String actualTitle=userPage.McDonaldsText.getText();
        Assert.assertEquals(expectedTitle,actualTitle);


       // 9. Save store yazısı uzerinde bulunan favori simgesine tıklanır
        userPage.saveStoreFavori.click();

       // 10. Kullanici alanı bolumunden "Saved stores" butonuna tıklanır.
        userPage.loginElementi.click();
        ReusableMethods.wait(1);
        userPage.saveStoreButton.click();
       // 11. Saved Stores sayfasinin acıldıgı dogrulanır
        String expectedSave="Saved Stores";
        String actualSave=userPage.saveStoreText.getText();
        Assert.assertEquals(expectedSave,actualSave);
        //12. Favoriye eklenen restoranın Saved Store sayfasında oldugu dogrulanır.
        String actualProduct=userPage.saveStoreProduct.getText();
        Assert.assertEquals(expectedProduct,actualProduct);
        userPage.saveStoreFavori2.click();





    }
}
