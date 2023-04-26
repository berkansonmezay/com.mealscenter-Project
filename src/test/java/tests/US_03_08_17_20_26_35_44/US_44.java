package tests.US_03_08_17_20_26_35_44;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.AdminPage;
import utilities.*;

import java.awt.geom.RectangularShape;
import java.util.List;

public class US_44  extends TestBaseRapor {

    //Admin olarak, Merchant satışlarına erişebilmeliyim.
    // Liste olarak görebilmeli,
    // tarihe göre filtreleyebilmeli
    // ve Order ID'ye göre sıralayabilmeliyim

    AdminPage adminPage;

   Actions actions=new Actions(Driver.getDriver());
    @Test
    public  void  test44(){

         adminPage=new AdminPage();

         extentTest=extentReports.createTest("Admin reports testi","Admin olarak merchant" +
                 "satislarinin raporlarina ualasabimeli");

        //1-https://qa.mealscenter.com/backoffice/login sayfasina gider
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("ilgili web sayfasina erisildi");

        //2-Admin sayfasina gittikten sonra gecerli username ve passwordu girer
        AdminPage.adminLogin(ConfigReader.getProperty("adminUsername"),ConfigReader.getProperty("adminPassword"));
         extentTest.pass("gecerli username ve password girildi");

        //3-backoffice/admin/dashboard sayfasinda  "reports" butonuna basar
        AdminPage.menuList(13).click();
        ReusableMethods.wait(1);
        AdminPage.menuList(17).click();

       //4- adminPage.reportsButtonAdmin.click();
        extentTest.pass("reports is clickable");

        //5-reports bolumunden "merchant sales"butonuna basar
        adminPage.merchantSalesAdmin.click();
        extentTest.pass("merchant sales is clickable");

        //6-Merchant sales sayfasinda "Merchant Sales Report"yazisinin gorunurlugunu test eder
       ReusableMethods.isDisplayed(adminPage.merchantsalesreportsYazisiAdmin,"Merchant Sales Report");
        extentTest.pass("Merchant Sales Report is displayed");

        //7-Merchant Sales Report "Start date end date" butonuna tiklar
       adminPage.reportsDateAdmin.click();
       actions.sendKeys("2023-03-22 -- 2023-03-29"+ Keys.ENTER).perform();
        ReusableMethods.wait(2);
        extentTest.pass("Start date end date is clickable");

        //8-"Order Infornation", "orderId", "Merchant", "Customer" tiklayin
        AdminPage.merchantEditTableFilter(1).click();
        extentTest.fail("order infornation iconu tiklanabilir degil");

        AdminPage.merchantEditTableFilter(2).click();
        extentTest.pass("orderID is clickable");

        AdminPage.merchantEditTableFilter(3).click();
        extentTest.fail("merchant iconu tiklanabilir degil");

        AdminPage.merchantEditTableFilter(4).click();
        extentTest.fail("Customer iconu tiklanabilir degil");
        ReusableMethods.wait(1);


        //Merchant Sales Report  sayfasinda "Filters"butonuna basar
        adminPage.reportsFiltersAdmin.click();
        ReusableMethods.wait(4);
        extentTest.pass("Filters is clickable");

        //"Filters" drop down indaki gerekli bilgileri doldurur

        adminPage.merchantFilter.click();
        WebElement baiOption=Driver.getDriver().findElement(By.xpath("//li[text()='Bai Tong Thai Street Cafe']"));
        ReusableMethods.waitAndClick(baiOption);
        adminPage.applyFiltersButton.click();
        ReusableMethods.verifyAssertTrue("Bai Tong Thai Street Cafe",adminPage.filteredMerchantName.getText(),
                "Merchant Filter is not functional ");
        adminPage.filtersButton.click();
        adminPage.clearFiltersButton.click();


        //4.By Customer filtresi  ile bir customer (Elif F) secilir.
        adminPage.customerFilter.click();
        ReusableMethods.wait(2);
        adminPage.nameSearchBox.sendKeys("Elif F");
        ReusableMethods.wait(2);
        WebElement bektasOption=Driver.getDriver().findElement(By.xpath(
                "//li[text()='']"));
        ReusableMethods.waitAndClick(bektasOption);
        adminPage.applyFiltersButton.click();
        ReusableMethods.verifyAssertTrue("bektas alakus",adminPage.filteredCustomer.getText(),
                "Customer Filter is not functional");
        adminPage.filtersButton.click();
        adminPage.clearFiltersButton.click();

        //5.By Status filtresi ile bir status (complete) secilir.
        adminPage.statusFilter.click();
        ReusableMethods.wait(2);
        WebElement completeOption=Driver.getDriver().findElement(By.xpath(
                "(//li[@class='select2-results__option select2-results__option--selectable'])[2]"));
        completeOption.click();
        adminPage.applyFiltersButton.click();
        ReusableMethods.wait(2);
        ReusableMethods.verifyAssertTrue("complete",adminPage.filteredStatus.getText(),
                "Status Filter is not functional");
        adminPage.filtersButton.click();
        adminPage.clearFiltersButton.click();

        WebElement denee = Driver.getDriver().findElement(By.xpath("//button[text()='Apply Filters']"));
        ReusableMethods.wait(2);
        denee.click();






        //6.By Order Type filtresi  ile bir order type (pickup) secilir.
        adminPage.orderTypeFilter.click();
        ReusableMethods.wait(2);
        WebElement pickupOption=Driver.getDriver().findElement(By.xpath(
                "//li[text()='Pickup']"));
        pickupOption.click();
        adminPage.applyFiltersButton.click();
        ReusableMethods.wait(2);
        ReusableMethods.verifyAssertTrue("Pickup",adminPage.filteredOrderType.getText(),
                "Order Type Filter not functional");


       // adminPage.filtersByMerchantAdmin.click();
      //  extentTest.pass("By merchant is clickable");

        //adminPage.filtersCustomerAdmin.click();
       // extentTest.pass("customer");
      //  adminPage.filtersbyStatusAdmin.click();
      //  extentTest.pass("by status is clickable");
      //  adminPage.filtersbyOrderTypeAdmin.click();
       // extentTest.pass("by order type is clickable");


        //filters  drop down sayfasini doldurduktan sonra "Apply Filters"butonuna basilir
        adminPage.applyFiltersAdmin.click();
        ReusableMethods.wait(2);
        extentTest.pass("Apply Filters is clickable");

        // Select sınıfını kullanarak dropdown menüsüne eriş
        WebElement dropdownMenu = Driver.getDriver().findElement(By.xpath("//i[@class='zmdi zmdi-filter-list']"));


        // tum secenekleri sec
        Select dropdown = new Select(dropdownMenu);

        List<WebElement> options = dropdown.getOptions();
        for (int i = 0; i < options.size(); i++) {
            dropdown.selectByIndex(i);
        }
         //Merchant Sales Report  sayfasinda istedigi sayfadaki siparisler icin  sayfanin altindaki "next" butonuna
        ReusableMethods.wait(2);
        JSUtilities.scrollToBottom(Driver.getDriver());
        JSUtilities.clickWithJS(Driver.getDriver(),adminPage.nextReports);
        extentTest.pass("next is clicable");

        //Merchant Sales Report  sayfasindaki bilgilerin gorundugunu test eder
        ReusableMethods.wait(2);
        JSUtilities.scrollToTop(Driver.getDriver());
        JSUtilities.clickWithJS(Driver.getDriver(),adminPage.FiltersXAdmin);
        extentTest.pass("Merchant Sales Report  is displayed");




        //sayfayi kapatir
        Driver.getDriver().close();
        extentTest.info("browser kapandi");


    }
}




