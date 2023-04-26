package tests.US_09_10_18_27_30_36;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.MerchantPage;
import pages.UserPage;
import utilities.ConfigReader;
import utilities.Driver;

public class US_36 {

    @Test
    public void TC2701() {
        UserPage userPage = new UserPage();
        AdminPage adminPage=new AdminPage();

       // 1. https://qa.mealscenter.com/backoffice/login sayfasına gidilir
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));

       // 2. Username alanına gecerli username girilir
       // 3. Password alanına gecerli password girilir
        // 4. Sign in butonuna tıklanır
        AdminPage.adminLogin(ConfigReader.getProperty("adminUsernameEsra"),ConfigReader.getProperty("adminPasswordEsra"));

       // 5. Dashboard sayfasının acıldıgı dogrulanır

       // 6. Dashboard sayfasında bulunan ozet bilgilerin oldugu dogrulanır.
        String expectedWeek="Commission this week";
        String expectedMonth="Commission this month";
        String expectedSubscriptions="Subscriptions this month";
        String actualWeek=adminPage.commissionThisWeek.getText();
        String actualMonth=adminPage.commissionThisMonth.getText();
        String actualSubscriptions=adminPage.subscriptionsThisMonth.getText();

        Assert.assertEquals(expectedWeek,actualWeek);
        Assert.assertEquals(expectedMonth,actualMonth);
        Assert.assertEquals(expectedSubscriptions,actualSubscriptions);


    }
}