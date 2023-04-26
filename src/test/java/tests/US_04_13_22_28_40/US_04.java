package tests.US_04_13_22_28_40;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserPage;
import utilities.*;

public class US_04 extends TestBaseRapor {
   static String actualUrl;
   static String expectedIcerik;
   static String actualTitle;

  static UserPage userPage=new UserPage();

   public static void homePageFooter (){
       userPage=new UserPage();
       Driver.getDriver().get(ConfigReader.getProperty("customerUrl"));
       userPage.cookie.click();
       Actions actions=new Actions(Driver.getDriver());
       actions.sendKeys(Keys.END);


   }

    @Test
    public void TC_01() {
        userPage=new UserPage();
       extentTest=extentReports.createTest("HomePage Footer Site Logo Testi","Logo gorunur olmalı ve tıklandıgında sayfa basa donmeli");
        //1-https://qa.mealscenter.com/ adresine gider
        //2-Sayfanın en altına iner
        homePageFooter();
        extentTest.info("Home Page Footer Bolumune ulasıldı");

        //3-Site logosu ve isminin gorunur oldugunu test eder ve tıklar
        ReusableMethods.isDisplayed(userPage.siteLogo, "element bulunamadı");
        ReusableMethods.isEnabled(userPage.siteLogo,"Logo erişilebilir değil");
        extentTest.pass("Site logosu gorunur ve erisilebilir");

        //4-Site logosu ve ismine tıkladıgında sayfanın basına dondugunu test eder
        JSUtilities.clickWithJS(Driver.getDriver(), userPage.siteLogo);
        ReusableMethods.isDisplayed(userPage.homePageField, "sayfa basa donemedi");
        extentTest.pass("Logo tıklandıgında sayfa basa doner");

       //5-driver ı kapatır

    }

        @Test
        public void TC_02(){
            userPage=new UserPage();
       extentTest=extentReports.createTest("Contact us Baslıgı altındakı Baglantılar Testi","Baglantılara tıklantıgında ilgili sayfaya gitmeli");
        //1-https://qa.mealscenter.com/ adresine gider
        // 2-Sayfanın en altına iiner
            homePageFooter();
            extentTest.info("Home Page Footer Bolumune ulasıldı");

        //3-"Contact us" baslıgının erisilebilir oldugunu ve ilgile sayfaya gittigini ters eder
            JSUtilities.clickWithJS(Driver.getDriver(), userPage.contactUsLink);
            actualUrl = Driver.getDriver().getCurrentUrl();
            expectedIcerik = "contactus";
            Assert.assertTrue(actualUrl.contains(expectedIcerik));
            extentTest.pass("Baglantı erisilebilir");

            Driver.getDriver().navigate().back();
            JSUtilities.scrollToBottom(Driver.getDriver());

        // 4-"Terms and conditions"  baslıgının erisilebilir oldugunu ve ilgili sayfaya gittigini ters eder
           ReusableMethods.waitAndClick(userPage.termCondLink);
            userPage.termCondLink.isEnabled();
            actualUrl = Driver.getDriver().getCurrentUrl();
            expectedIcerik = "terms";
            Assert.assertTrue(actualUrl.contains(expectedIcerik));
            extentTest.pass("Baglantı erisilebilir");

            Driver.getDriver().navigate().back();
            JSUtilities.scrollToBottom(Driver.getDriver());

        // 5-"Privacy policy" baslıgının erisilebilir oldugunu ve ilgili sayfaya gittigini ters eder
            ReusableMethods.waitAndClick(userPage.priPolLink);
            actualUrl = Driver.getDriver().getCurrentUrl();
            expectedIcerik = "privacy-policy";
            Assert.assertTrue(actualUrl.contains(expectedIcerik));
            extentTest.pass("Baglantı erisilebilir");

            Driver.getDriver().navigate().back();
            JSUtilities.scrollToBottom(Driver.getDriver());

        //6-Driver ı kapatır

        }

        @Test
        public void TC_03(){
            userPage=new UserPage();
       extentTest=extentReports.createTest("Business Baslıgı altındakı Baglantılar Testi","Baglantılara tıklantıgında ilgili sayfaya gitmeli");
            //1-https://qa.mealscenter.com/ adresine gider
            //2-Sayfanın en altına iiner
            homePageFooter();
            extentTest.info("Home Page Footer Bolumune ulasıldı");

            //3-"Business" baslıgı altındaki linkin erişilebilir oldugunu ve ilgili sayfaya gittigini test eder
            JSUtilities.clickWithJS(Driver.getDriver(), userPage.priPolLink);
            actualUrl = Driver.getDriver().getCurrentUrl();
            expectedIcerik = "privacy-policy";
            Assert.assertTrue(actualUrl.contains(expectedIcerik));
            extentTest.pass("Baglantı erisilebilir");

            Driver.getDriver().navigate().back();
            JSUtilities.scrollToBottom(Driver.getDriver());

            //4-Driver ı kapatır

        }
        @Test
        public void TC_04(){
            userPage=new UserPage();
       extentTest=extentReports.createTest("Blog Baslıgı altındakı Baglantılar Testi","Baglantılara tıklantıgında ilgili sayfaya gitmeli");
       //1-https://qa.mealscenter.com/ adresine gider
        //2-Sayfanın en altına iiner
            homePageFooter();
            extentTest.info("Home Page Footer Bolumune ulasıldı");

        //3-"Blog" baslıgının gorunur oldugunu test eder
        //4-Altındakı blog baslklarının erisilebilir oldugunu test eder
            JSUtilities.clickWithJS(Driver.getDriver(), userPage.blog1);
            actualUrl = Driver.getDriver().getCurrentUrl();
            expectedIcerik = "discover";
            Assert.assertTrue(actualUrl.contains(expectedIcerik));
            extentTest.pass("Baglantı erisilebilir");

            Driver.getDriver().navigate().back();
            JSUtilities.scrollToBottom(Driver.getDriver());

            JSUtilities.clickWithJS(Driver.getDriver(), userPage.blog2);
            actualUrl = Driver.getDriver().getCurrentUrl();
            expectedIcerik = "eat";
            Assert.assertTrue(actualUrl.contains(expectedIcerik));
            extentTest.pass("Baglantı erisilebilir");

            Driver.getDriver().navigate().back();
            JSUtilities.scrollToBottom(Driver.getDriver());

            JSUtilities.clickWithJS(Driver.getDriver(), userPage.blog3);
            actualUrl = Driver.getDriver().getCurrentUrl();
            expectedIcerik = "benefits";
            Assert.assertTrue(actualUrl.contains(expectedIcerik));
            extentTest.pass("Baglantı erisilebilir");

            Driver.getDriver().navigate().back();
            JSUtilities.scrollToBottom(Driver.getDriver());

            JSUtilities.clickWithJS(Driver.getDriver(), userPage.blog4);
            actualUrl = Driver.getDriver().getCurrentUrl();
            expectedIcerik = "healthy";
            Assert.assertTrue(actualUrl.contains(expectedIcerik));
            extentTest.pass("Baglantı erisilebilir");

            Driver.getDriver().navigate().back();
            JSUtilities.scrollToBottom(Driver.getDriver());

            //5-Driver ı kapatır


        }
        @Test
        public void TC_05(){
            userPage=new UserPage();
       extentTest=extentReports.createTest("Sosyal Medya Erişim Testi","Sosyal medya logoları tıklandıgında ilgili sayfaya gitmeli");
            //1-https://qa.mealscenter.com/ adresine gider
            //2-Sayfanın en altına iiner
            homePageFooter();
            extentTest.info("Home Page Footer Bolumune ulasıldı");

            //3-"Facebook" Logosunun gorunurlugunu ve tıkladıgında ilgili sayfaya gittigini test eder
            String anasayfa= Driver.getDriver().getWindowHandle();

            SoftAssert softAssert=new SoftAssert();

            JSUtilities.scrollToBottom(Driver.getDriver());
             JSUtilities.clickWithJS(Driver.getDriver(), userPage.faceBook);
            actualTitle = Driver.getDriver().getTitle();
            expectedIcerik = "Facebook";
            softAssert.assertTrue(actualTitle.contains(expectedIcerik),"Title facebook içermiyor");
            extentTest.pass("Facebook butonu Facebook anasayfaya gider");

            ReusableMethods.switchToWindow(anasayfa);
            JSUtilities.scrollToBottom(Driver.getDriver());

            //4-"Instagram" Logosunun gorunurlugunu ve tıkladıgında ilgili sayfaya gittigini test eder
            JSUtilities.clickWithJS(Driver.getDriver(), userPage.instagram);
            actualTitle = Driver.getDriver().getTitle();
            expectedIcerik = "instagram";
            softAssert.assertTrue(actualTitle.contains(expectedIcerik),"Title instagram içermiyor");
            extentTest.pass("Instagram butonu Instagram anasayfaya gider");

            ReusableMethods.switchToWindow(anasayfa);
            JSUtilities.scrollToBottom(Driver.getDriver());

            //5-"Linkedin" Logosunun gorunurlugunu ve tıkladıgında ilgili sayfaya gittigini test eder
            JSUtilities.clickWithJS(Driver.getDriver(), userPage.linkedin);
            actualTitle = Driver.getDriver().getTitle();
            expectedIcerik = "linkedin";
            softAssert.assertTrue(actualTitle.contains(expectedIcerik),"Title linkedin içermiyor");
            extentTest.pass("Linkedin butonu Linkedin anasayfaya gider");

            ReusableMethods.switchToWindow(anasayfa);
            JSUtilities.scrollToBottom(Driver.getDriver());

            //6-"Twiter" Logosunun gorunurlugunu ve tıkladıgında ilgili sayfaya gittigini test eder
            JSUtilities.clickWithJS(Driver.getDriver(), userPage.twitter);
            actualTitle = Driver.getDriver().getTitle();
            expectedIcerik = "twitter";
            softAssert.assertTrue(actualTitle.contains(expectedIcerik),"Title twitter içermiyor");
            extentTest.pass("Twitter butonu Twitter anasayfaya gider");

            ReusableMethods.switchToWindow(anasayfa);
            JSUtilities.scrollToBottom(Driver.getDriver());

            //7-"Youtube" Logosunun gorunurlugunu ve tıkladıgında ilgili sayfaya gittigini test eder
            JSUtilities.clickWithJS(Driver.getDriver(), userPage.youtube);
            actualTitle = Driver.getDriver().getTitle();
            expectedIcerik = "youtube";
            softAssert.assertTrue(actualTitle.contains(expectedIcerik),"Title youtube içermiyor");
            extentTest.pass("Youtube butonu Youtube anasayfaya gider");
            softAssert.assertAll();

           //8-Driver kapatılır

        }

        @Test
        public void TC_06(){
            userPage=new UserPage();
       extentTest=extentReports.createTest("Mobil Magaza Erisim Testi","Butonlar tıklandıgında ilgilisayfaya gitmeli");
            //1-https://qa.mealscenter.com/ adresine gider
            //2-Sayfanın en altına iner
            homePageFooter();
            extentTest.info("Home Page Footer Bolumune ulasıldı");

            //3-"App Srore" logosunun erisilebilirligini ve tıklandıgında ilgili sayfaya gittigini test eder
            SoftAssert softAssert=new SoftAssert();
            JSUtilities.clickWithJS(Driver.getDriver(), userPage.appStoreButton);
            actualUrl = Driver.getDriver().getCurrentUrl();
            expectedIcerik= "appStore";
           softAssert.assertTrue(actualUrl.contains(expectedIcerik));
            extentTest.pass("App Store butonu App Store anasayfaya gider");

            JSUtilities.scrollToBottom(Driver.getDriver());

            //4-"Google Play" logosunun erisilebilirligini ve tıklandıgında ilgili sayfaya gittigini test eder
            JSUtilities.clickWithJS(Driver.getDriver(), userPage.playStoreBotton);
            actualUrl = Driver.getDriver().getCurrentUrl();
            expectedIcerik= "playstore";
            softAssert.assertTrue(actualUrl.contains(expectedIcerik));
            extentTest.pass("Play Store butonu Play Store anasayfaya gider");

            softAssert.assertAll();

            //5-Driver kapatılır

        }

        @Test
        public void TC_07(){
            userPage=new UserPage();
       extentTest=extentReports.createTest("Footer Sayfa Baglantı Testi","Baglantıya tıklandıgında sayfa basa donmeli");
             //1-https://qa.mealscenter.com/ adresine gider
            //2-Sayfanın en altına iner
            homePageFooter();
            extentTest.info("Home Page Footer Bolumune ulasıldı");

            //3-"mealscenter.com" baglantısının erişilebilir oldugunu ve tıklandıgımda sayfanın basına dondugunu test eder
            JSUtilities.scrollToBottom(Driver.getDriver());
            JSUtilities.clickWithJS(Driver.getDriver(), userPage.pageLink);
            ReusableMethods.isDisplayed(userPage.homePageField, "sayfa basa donemedi");

            //4_Driver kapatılır

        }
}
