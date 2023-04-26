package tests.US_09_10_18_27_30_36;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantPage;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_30 {

    @Test
    public void TC3001() {

        UserPage userPage = new UserPage();
        MerchantPage merchantPage=new MerchantPage();
        Select select;

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Actions actions = new Actions(Driver.getDriver());


        // 1. Kullanici https://qa.mealscenter.com/ sayfasına gider
        Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));

        //2. Signin butonuna tıklanır
       // 3.Mobil number or email alanına gecerli email adresi girilir
       // 4. Passwor alanına gecerli password girilir
        userPage.userLogin(ConfigReader.getProperty("customerEmail"), ConfigReader.getProperty("customerPassword"));

       // 5. Sign butonuna tıklanır
        userPage.signInButton.click();
        ReusableMethods.wait(2);

       // 6. Kullanıcı McDonads resmine tıklar
        js.executeScript("arguments[0].scrollIntoView(true);", userPage.mcDonalds);
        ReusableMethods.wait(2);
        userPage.mcDonalds.click();

       // 7. Acılan sayfada Big Mec Meal menusunu secip "Add To Card" butonuna tıklar.
        ReusableMethods.wait(2);

        userPage.addToCartButton1.click();
        userPage.addressForDelivery.sendKeys("Ankara");
        ReusableMethods.wait(3);
        actions.sendKeys(Keys.TAB, Keys.ENTER).perform();

        ReusableMethods.wait(3);
        actions.moveToElement(userPage.addToCartButton1).perform();
        ReusableMethods.wait(3);
        userPage.addToCartButton1.click();

       // 8.Fiyatin gorundugu "Checkout" butonuna tıklar
        userPage.checkoutButton.click();
        ReusableMethods.wait(5);

       // 9. Acılan sayfda "Delivery" butonuna tıklar.
        userPage.deliveryButton.click();
        ReusableMethods.wait(5);

       // 10. "Schedule for later" yazısını secer.
        userPage.scheduleForLater.click();

       // 11. Tarih kısmına ileri bir tarih ve saat girisi yapar.
        select=new Select(userPage.scheduleSelect);
        select.selectByIndex(3);
        select=new Select(userPage.scheduleTimeSelect);
        select.selectByIndex(3);

       // 12. Save butonuna tıklar.
        userPage.saveButton.click();

       // 13. Place Order butonuna tıklar.
        userPage.placeOrderText.click();
        ReusableMethods.wait(3);

       // 14.https://qa.mealscenter.com/backoffice/merchant/dashboard sayfasina gidilir
        Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));

       // 15. Username alanına gecerli username girilir
        // 16. Password alanına gecerli pasword girilir
        // 17.  Sign in butonuna tıklanır
        MerchantPage.merchantLogin(ConfigReader.getProperty("mcDonaldsUsername"),ConfigReader.getProperty("mcDonaldsPassword"));

       // 18. Orders menusu altındaki "Scheduled" butonuna tıklanır.
        merchantPage.ordersDDM.click();
        merchantPage.orderScheduledDdm.click();

       // 19. Acılan sayfada ileri tarihli verilen siparisin oldugu dogrulanır.
        String expectedUser="esra turker";
        String actualUser=merchantPage.newOrdersUser.getText();
        Assert.assertEquals(expectedUser,actualUser);
        merchantPage.newOrdersUser.click();
        merchantPage.reject.click();
        merchantPage.other.click();
        merchantPage.rejectOrder.click();
        ReusableMethods.wait(5);

        Driver.closeDriver();





    }
}