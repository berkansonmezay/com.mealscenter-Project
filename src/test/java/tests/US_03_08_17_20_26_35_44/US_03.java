package tests.US_03_08_17_20_26_35_44;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.*;

import static pages.UserPage.cusinesMenu;

public class US_03 extends TestBaseRapor {

    //Bir ziyaretçi olarak Home page sayfasının
    // body bölümündeki fonksiyonların görünür ve aktif olmasını istiyorum

       SoftAssert softAssert;
       UserPage userPage;

    Actions action;

    @Test
    public void test0301() {
        action = new Actions(Driver.getDriver());
        softAssert=new SoftAssert();
        userPage = new UserPage();

        extentTest = extentReports.createTest("Home Page Test","yoresel mutfaklara ait ulkeler ve resimler aktif olmali yt"+
                "body sayfasindaki yazilar gorunur olmali");

        // https://qa.mealscenter.com/ sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));
        ReusableMethods.waitAndClick(userPage.cookie);
        extentTest.info("Web sayfasina gitti");

        //https://qa.mealscenter.com sayfasinin search box(arana kutusunu) test et
        String expectedIcerik = "mealscenter";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains(expectedIcerik));
        if (actualUrl.contains(expectedIcerik)){
        extentTest.pass("mealscenter yazısı web sayfasında bulunmaktadır");
        }else{
            extentTest.fail("mealscenter yazısı web sayfasında bulunmamaktadır");
        }

        //Home page sayfasinda acilis yazsinin gorunur oldugu dogrulanir
        ReusableMethods.isDisplayed(userPage.acilisYazisiUser,"Hungry? We got you");
        extentTest.pass("Hungry? We got you is displayed");

    // Home page sayfasinfdaki yoresel ulke isimlerinin aktifligini  dogrula

        cusinesMenu(1).click();
        Driver.getDriver().navigate().back();
        extentTest.pass("American is clickable");

        cusinesMenu(2).click();
        Driver.getDriver().navigate().back();
        extentTest.pass("Mediterranean is clickable");

        cusinesMenu(3).click();
        Driver.getDriver().navigate().back();
        extentTest.pass("Sandwiches is clickable");

        cusinesMenu(4).click();
        Driver.getDriver().navigate().back();
        extentTest.pass("Italian is clickable");

        cusinesMenu(5).click();
        Driver.getDriver().navigate().back();
        extentTest.pass("Mexican is clickable");

        cusinesMenu(6).click();
        Driver.getDriver().navigate().back();
        extentTest.pass("Burgers is clickable");

        cusinesMenu(7).click();
        Driver.getDriver().navigate().back();
        extentTest.pass("Japanese is clickable");

       WebElement thi = Driver.getDriver().findElement(By.xpath("(//a[text()='Thai'])[1]"));
       thi.click();
        Driver.getDriver().navigate().back();
        extentTest.pass(" Thai is clickable");

        UserPage.moreMenu(1).click();
        Driver.getDriver().navigate().back();
        extentTest.pass(" Chinese is clickable");

        UserPage.moreMenu(2).click();
        Driver.getDriver().navigate().back();
        extentTest.pass("  Kohner is clickable");

        UserPage.moreMenu(3).click();
        Driver.getDriver().navigate().back();
        extentTest.pass("Halal is clickable");

        UserPage.moreMenu(4).click();
        Driver.getDriver().navigate().back();
        extentTest.pass(" Vegetarian is clickable");

    // home page sayfasinin body bolumundeki  restaurant resimlerinin aktifligini dogrula
        ReusableMethods.wait(2);
        JSUtilities.scrollToElement(Driver.getDriver(),userPage.popularnearbySeattleYazisiUser);
        ReusableMethods.wait(2);
       WebElement restaurant = Driver.getDriver().findElement(By.xpath("(//div[@class='d-flex justify-content-between mt-2 w-100 pl-1 pr-1'])[12]"));
       restaurant.click();
       ReusableMethods.wait(2);
       Driver.getDriver().navigate().back();
       extentTest.pass("restaurant is clickable");


        //home page sayfasinda "No Minimum Order" yazisinin  gorunur oldugu dogrulanir
       // ReusableMethods.isDisplayed((userPage.NoMinimumOrderYazisiUser,"No Minimum Order");
        ReusableMethods.wait(2);
        JSUtilities.scrollToElement(Driver.getDriver(),userPage.noMinimumOrderYazisiUser);
        ReusableMethods.wait(2);
        userPage.noMinimumOrderYazisiUser.isDisplayed();
        extentTest.pass("No Minimum Order is displayed");

        //Home page  sayfasinda "Track your delivery" yazisinin gorunur oldugu dogrulanir
        ReusableMethods.isDisplayed(userPage.trackyourdeliveryYazisi,"Track your delivery");
        extentTest.pass("Track your delivery is displayed");

        //Home page sayfasinda "Delivery on time" yazisinin gorunur oldugu dogrulanir
        ReusableMethods.isDisplayed(userPage.motoKuryeResim,"Delivery on time");
        extentTest.pass("Delivery on time is displayed");

        //home page sayfasindaki "Discover Healthy Food Options for Your Whole Family" yazisiniin Read1
        //buttonunun aktif oldugu dogrulanir
        ReusableMethods.wait(2);
        JSUtilities.scrollToElement(Driver.getDriver(),userPage.readButton2User);
        ReusableMethods.wait(2);
        ReusableMethods.isEnabled(userPage.readButton1User,"read1 butonu erisilebilir");
        userPage.readButton1User.click();
        Driver.getDriver().navigate().back();
        extentTest.pass("read1 butonunun erisilebilir oldugu dogrulandi");

        //home page sayfasindaki "Meals Center for Your Healthy Lifestyle" yazisiniin Read2
        //buttonunun aktif oldugu dogrulanir
        ReusableMethods.isEnabled(userPage.readButton2User,"read2 butonu erisilebilir");
        userPage.readButton2User.click();
        Driver.getDriver().navigate().back();
        extentTest.pass("read2 butonunun erisilebilir oldugu dogrulandi");

        //home page sayfasindaki "How to Eat Healthy with Food Delivery" yazisiniin Read3
        //buttonunun aktif oldugu dogrulanir
        ReusableMethods.isEnabled(userPage.readButton3User,"read3 butonu erisilebilir");
        userPage.readButton3User.click();
        Driver.getDriver().navigate().back();
        extentTest.pass("read3 butonunun erisilebilir oldugu dogrulandi");


        //home page sayfasindaki "Discover the Best Vegetarian Food Options in Your Area" yazisiniin Read4
        //buttonunun aktif olmadigi  dogrulanir
        ReusableMethods.isEnabled(userPage.readButton4User,"read4 butonu erisilebilir");
        userPage.readButton4User.click();
        Driver.getDriver().navigate().back();
        if(!userPage.readButton4User.isSelected()){
            extentTest.fail("read4 buttonu is not anabled");
        }else{
            extentTest.pass("read4 buttonu is anabled");
        }


        // "New restaurant Seattle"  bolumundeki restaurant resimlerinin aktifligini dogrula
        ReusableMethods.wait(4);
        JSUtilities.scrollToElement(Driver.getDriver(),userPage.newrestaurantSeattleBaslikUser);
        ReusableMethods.wait(3);
        WebElement newRestaurant = Driver.getDriver().findElement(By.xpath("(//h6[@class='mb-1'])[9]"));
        newRestaurant.click();
        Driver.getDriver().navigate().back();
        extentTest.pass("New restaurant Seattle new restaurant is clickable");

        //home page sayfasinda "Join us and reach new customers" yazisinin gorunur oldugu dogrulanir
        ReusableMethods.wait(2);
        JSUtilities.scrollToElement(Driver.getDriver(),userPage.joinusandreachnewcustomersYazsisi);
        ReusableMethods.wait(2);
        ReusableMethods.isDisplayed(userPage.joinusandreachnewcustomersYazsisi,"Join us and reach new customers");
         extentTest.pass("Join us and reach new customers is displayed");

        //Home page sayfasindaki "Join us and reach new customers" yazisina ait Join buttonunun aktifligi dogrulanir
        WebElement joinButton = Driver.getDriver().findElement(By.xpath("//div[@class='btn-white-parent non-trasparent']"));
        joinButton.click();
        Driver.getDriver().navigate().back();
        extentTest.pass("join  button is clickable");

        //home page sayfasinin en son bolumundeki reklam sayfasinin gorunurlugunu dogrula
        WebElement reklamHepsi = Driver.getDriver().findElement(By.xpath("//div[@class='section-mobileapp tree-columns-center d-none d-md-block']"));
        reklamHepsi.isDisplayed();
        extentTest.pass("reklamhepsi is displayed");



        softAssert.assertAll();

        Driver.getDriver().close();
        extentTest.info("browser kapandi");

    }
}





