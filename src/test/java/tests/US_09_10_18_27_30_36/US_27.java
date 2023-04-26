package tests.US_09_10_18_27_30_36;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MerchantPage;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US_27 {


    @Test
    public void TC2701() {
        UserPage userPage = new UserPage();
        MerchantPage merchantPage=new MerchantPage();

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        Actions actions = new Actions(Driver.getDriver());

        // 1. Kullanici https://qa.mealscenter.com/ sayfasına gider
        Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));
        // 2. Signin butonuna tıklanır
        //3.Mobil number or email alanına gecerli email adresi girilir
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
        // js.executeScript("arguments[0].scrollIntoView(true);", userPage.addToCartButton5);
        ReusableMethods.wait(2);

        userPage.addToCartButton1.click();
        userPage.addressForDelivery.sendKeys("Ankara");
        ReusableMethods.wait(2);
        actions.sendKeys(Keys.TAB, Keys.ENTER).perform();
        // js.executeScript("arguments[0].scrollIntoView(true);", userPage.addToCartButton5);
        ReusableMethods.wait(3);
        actions.moveToElement(userPage.addToCartButton1).perform();
        ReusableMethods.wait(3);
        userPage.addToCartButton1.click();

        // 8.Fiyatin gorundugu "Checkout" butonuna tıklar
        userPage.checkoutButton.click();
        ReusableMethods.wait(5);

        // 9. Acılan sayfada "Place Order" butonuna tıklayır
        userPage.placeOrderText.click();

        // 10. "Confirming your order" yazısının goruldugunu dogrular
        ReusableMethods.wait(3);
       String expectedIcerik = "Confirming your order";
       String actualSonuc=userPage.confirmingyourorderText.getText();
       Assert.assertEquals(expectedIcerik,actualSonuc);


        // 11. https://qa.mealscenter.com/backoffice/auth/login url'e gidilir
       Driver.getDriver().get(ConfigReader.getProperty("merchantUrl"));

        //12.Username alanına gecerli username girilir
        // 13. Password alanına gecerli password bilgisi girilir.
        //14. Sign in butonuna tıklanır
        MerchantPage.merchantLogin(ConfigReader.getProperty("mcDonaldsUsername"),ConfigReader.getProperty("mcDonaldsPassword"));

        //15. Sol menuden Orders butonuna tıklanır
        merchantPage.ordersDDM.click();

        // 16. Acilan seceneklerden New Orders butonuna tıklanır.
        merchantPage.newOrders.click();

        //17. Siparis alanından esra turker olana tıklanır
        js.executeScript("arguments[0].scrollIntoView(true);", merchantPage.newOrdersUser);
        ReusableMethods.wait(2);
        merchantPage.newOrdersUser.click();


        // 18. Accepted butonuna tıklanır
        merchantPage.acceptedButton.click();

        //19. Orders Processing butonuna tıklanır
        merchantPage.ordersProcessingDdm.click();

        //20. Orders Processing sayfasının acıldıgı dogrulanır.
        String expectedText="Orders Processing";
        String actualText=merchantPage.ordersProcessingPage.getText();
        Assert.assertEquals(expectedText,actualText);

        // 21.Orders Processing sayfasında "esra turker" siparisi oldugu dogrulanır.
        String expectedUser="esra turker";
        String actualUser=merchantPage.newOrdersUser.getText();
        Assert.assertEquals(expectedUser,actualUser);

        // 22. Ready For Pickup butonuna tıklanır.
        merchantPage.readiyForPickupButton.click();

        Driver.closeDriver();


    }

}
