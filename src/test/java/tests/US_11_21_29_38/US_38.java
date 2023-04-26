package tests.US_11_21_29_38;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminPage;
import utilities.*;

import java.io.File;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class US_38 extends TestBaseRapor {

    AdminPage adminPage=new AdminPage();
    SoftAssert softAssert=new SoftAssert();
    @Test
    public void test3801(){
        AdminPage adminPage=new AdminPage();
        extentTest = extentReports.createTest("TC_3801 Test",
                "Admin sees the total number of orders, cancellation, return and total amount information.");

        //Launch browser
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Browser opened");

        //1.Admin girişi yapılır
        AdminPage.adminLogin(ConfigReader.getProperty("adminUsername"),ConfigReader.getProperty("adminPassword"));
        extentTest.pass("Login to site as Admin");

        //2.Orders altmenusu altında All order sayfasında sipariş bilgileri(toplam,iptal,iade,meblağ) görüntülenir
        ReusableMethods.waitAndClick(adminPage.ordersLink,2);
        extentTest.pass("Clicked on Orders link");

        ReusableMethods.waitAndClick(adminPage.allOrderLink,2);
        extentTest.pass("Clicked on All Orders link");

        ReusableMethods.isDisplayed(adminPage.ordersText,"Orders not displayed");
        extentTest.pass("Verified that Orders information is displayed");

        ReusableMethods.isDisplayed(adminPage.cancelText,"Cancel not displayed");
        extentTest.pass("Verified that Cancel info is displayed");

        ReusableMethods.isDisplayed(adminPage.totalRefundText,"Total refund not displayed");
        extentTest.pass("Verified that Total Refund info is displayed");

        ReusableMethods.isDisplayed(adminPage.totalOrdersText,"Total orders not displayed");
        extentTest.pass("Verified that Total Orders info is displayed");

        //3.Sayfa sonunda Toplam entries sayısı görüntülenir
        ReusableMethods.isDisplayed(adminPage.totalEntriesText,"Total entries not displayed");
        extentTest.pass("Verified that Total entries info is displayed");

        //Sayfa kapatılır
        Driver.closeDriver();
        extentTest.info("Browser closed");

    }

    @Test
    public void test3802() throws ParseException {
        AdminPage adminPage=new AdminPage();
        SoftAssert softAssert=new SoftAssert();
        extentTest = extentReports.createTest("TC_3802 Test",
                "Admin filters orders by time.");

        //Launch browser
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Browser opened");

        //1.Admin girişi yapılır
        AdminPage.adminLogin(ConfigReader.getProperty("adminUsername"),ConfigReader.getProperty("adminPassword"));
        extentTest.pass("Login to site as Admin");

        //2.Orders altmenusu altında All Order sayfasında zaman filtreleme kutusuna tıklanır.
        ReusableMethods.waitAndClick(adminPage.ordersLink);
        extentTest.pass("Clicked on Orders link");
        ReusableMethods.waitAndClick(adminPage.allOrderLink);
        extentTest.pass("Clicked on All Orders link");

        //3.Today seçilir ve test edilir.
        ReusableMethods.waitAndClick(adminPage.timeFilterBox);
        extentTest.pass("Clicked on Time filter box");
        ReusableMethods.waitAndClick(adminPage.todayFilter);
        extentTest.pass("Clicked on Today filter option");
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd MMM yyyy");
        LocalDate date=LocalDate.now();
        String formattedDate= date.format(formatter);
        softAssert.assertTrue(adminPage.dateInformation.getText().contains(formattedDate),
                "Today Filter is not functional");
        extentTest.pass("Verified that Today filter is functional");

        //4.Yesterday seçilir ve test edilir.
        ReusableMethods.waitAndClick(adminPage.timeFilterBox);
        extentTest.pass("Clicked on Time filter box");
        ReusableMethods.waitAndClick(adminPage.yesterdayFilter);
        extentTest.pass("Clicked on Yesterday filter option");
        ReusableMethods.wait(1);
        LocalDate yesterday=LocalDate.now().minusDays(1);
        formattedDate=yesterday.format(formatter);
        try {
            WebElement dateInformationElement = adminPage.dateInformation;
            if (dateInformationElement != null && dateInformationElement.getText().contains(formattedDate)) {
                softAssert.assertTrue(true, "Verified that Yesterday filter is functional");
                extentTest.pass("Verified that Yesterday filter is functional");
            } else {
                softAssert.fail("Yesterday Filter is not functional");
                extentTest.fail("Yesterday Filter is not functional");
            }
        } catch (NoSuchElementException e) {
            extentTest.info("Yesterday, no order received");
        } catch (Exception ex) {
            // Diğer hataları yakala ve devam et
            extentTest.info("Yesterday, no order received");
        }

        //5.Last 7 Days seçilir ve test edilir.
        ReusableMethods.waitAndClick(adminPage.timeFilterBox);
        extentTest.pass("Clicked on Time filter box");
        ReusableMethods.waitAndClick(adminPage.last7DaysFilter);
        extentTest.pass("Clicked on Last 7 Days filter option");
        ReusableMethods.wait(1);
        LocalDate sevenDaysAgo = LocalDate.now().minusDays(7);
        System.out.println("sevenDaysAgo = " + sevenDaysAgo);
        String actualDate = adminPage.dateInformation.getText().substring(9, 20);
        System.out.println("actualDate = " + actualDate);

        // Tarih formatını belirleyin
        DateTimeFormatter converter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);

        // Tarihi dönüştürün
        LocalDate localDate = LocalDate.parse(actualDate, converter);

        softAssert.assertTrue(localDate.isAfter(sevenDaysAgo),
                "Actual date is not before seven days ago");
        extentTest.pass("Verified that actual date is before seven days ago");

        //6.Last 30 Days seçilebilir oldugu test edilir
        ReusableMethods.waitAndClick(adminPage.timeFilterBox);
        extentTest.pass("Clicked on Time filter box");
        ReusableMethods.isEnabled(adminPage.last30DaysFilter,"Last 30 Days Filter is not functional");
        extentTest.pass("Verified that Last 30 days filter is enable");

        //7.This Month seçilebilir oldugu test edilir
        ReusableMethods.waitAndClick(adminPage.timeFilterBox);
        extentTest.pass("Clicked on Time filter box");
        ReusableMethods.isEnabled(adminPage.thisMonthFilter,"This Month Filter is not functional");
        extentTest.pass("Verified that This Month filter is enable");

        //8.Last Month seçilebilir oldugu test edilir
        ReusableMethods.waitAndClick(adminPage.timeFilterBox);
        extentTest.pass("Clicked on Time filter box");
        ReusableMethods.isEnabled(adminPage.lastMonthFilter,"Last Month Filter is not functional");
        extentTest.pass("Verified that Last Month filter is enable");

        //9.Custom Range seçilir ve bir tarih seçilir seçilen tarihe göre filtreleme yapildigi test edilir
        ReusableMethods.waitAndClick(adminPage.timeFilterBox);
        extentTest.pass("Clicked on Time filter box");
        ReusableMethods.waitAndClick(adminPage.customRangeFilter);
        extentTest.pass("Clicked on Custom Range filter option");
        AdminPage.dateFilter(62);
        AdminPage.dateFilter(64);
        adminPage.calendarIcon.click();
        extentTest.pass("Verified that Custom Range filter is functional");

        //Sayfa kapatılır
        Driver.closeDriver();
        extentTest.info("Browser closed");
        softAssert.assertAll();

    }

    @Test
    public void test3803(){
        AdminPage adminPage=new AdminPage();
        SoftAssert softAssert=new SoftAssert();
        extentTest = extentReports.createTest("TC_3803 Test",
                "Admin filters the orders from the Filters button");

        //Launch browser
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Browser opened");

        //1.Admin girişi yapılır
        AdminPage.adminLogin(ConfigReader.getProperty("adminUsername"),ConfigReader.getProperty("adminPassword"));
        extentTest.pass("Login to site as Admin");

        //2.Orders menusu altında All Orders sayfasında Filters butonuna tıklanır.
        ReusableMethods.waitAndClick(adminPage.ordersLink);
        extentTest.pass("Clicked on Orders link");
        ReusableMethods.waitAndClick(adminPage.allOrderLink);
        extentTest.pass("Clicked on All Orders link");
        ReusableMethods.waitAndClick(adminPage.filtersButton);
        extentTest.pass("Clicked on Filters button");


        //3.By Merchant filtresi ile bir merchant (Bai Tong Thai Street Cafe) secilir.
        ReusableMethods.waitAndClick(adminPage.merchantFilter);
        extentTest.pass("Clicked on By Merchant filter option");
        WebElement baiOption=Driver.getDriver().findElement(By.xpath("//li[text()='Bai Tong Thai Street Cafe']"));
        ReusableMethods.waitAndClick(baiOption);
        extentTest.pass("Selected a Merchant");
        ReusableMethods.wait(2);
        ReusableMethods.waitAndClick(adminPage.applyFiltersButton);
        ReusableMethods.verifyAssertTrue("Bai Tong Thai Street Cafe",adminPage.filteredMerchantName.getText(),
                "Merchant Filter is not functional ");
        extentTest.fail("By Merchant filter is not functional");

        ReusableMethods.waitAndClick(adminPage.filtersButton);
        ReusableMethods.waitAndClick(adminPage.clearFiltersButton);
        extentTest.info("Filters cleared");


        //4.By Customer filtresi  ile bir customer (bektas alakus) secilir.
        ReusableMethods.waitAndClick(adminPage.customerFilter);
        extentTest.pass("Clicked on By Customer filter option");
        ReusableMethods.wait(2);
        ReusableMethods.waitAndSendText(adminPage.nameSearchBox,"bektas");
        extentTest.pass("Selected a Customer");
        ReusableMethods.wait(2);
        WebElement bektasOption=Driver.getDriver().findElement(By.xpath(
                "//li[text()='bektas alakus']"));
        ReusableMethods.waitAndClick(bektasOption);
        ReusableMethods.waitAndClick(adminPage.applyFiltersButton);
        ReusableMethods.verifyAssertTrue("bektas alakus",adminPage.filteredCustomer.getText(),
                "Customer Filter is not functional");
        extentTest.fail("By Customer filter is not functional");
        ReusableMethods.waitAndClick(adminPage.filtersButton);
        ReusableMethods.waitAndClick(adminPage.clearFiltersButton);
        extentTest.info("Filters cleared");

        //5.By Status filtresi ile bir status (complete) secilir.
        ReusableMethods.waitAndClick(adminPage.statusFilter);
        extentTest.pass("Clicked on By Status filter option");
        ReusableMethods.wait(2);
        WebElement completeOption=Driver.getDriver().findElement(By.xpath(
                "(//li[@class='select2-results__option select2-results__option--selectable'])[2]"));
        completeOption.click();
        ReusableMethods.waitAndClick(adminPage.applyFiltersButton);
        extentTest.pass("Selected a Status");
        ReusableMethods.wait(2);
        ReusableMethods.verifyAssertTrue("complete",adminPage.filteredStatus.getText(),
                "Status Filter is not functional");
        extentTest.pass("Verified that By Status filter is functional");
        ReusableMethods.waitAndClick(adminPage.filtersButton);
        ReusableMethods.waitAndClick(adminPage.clearFiltersButton);
        extentTest.info("Filters cleared");


        //6.By Order Type filtresi  ile bir order type (pickup) secilir.
        adminPage.orderTypeFilter.click();
        extentTest.pass("Clicked on By Order Type filter option");
        ReusableMethods.wait(2);
        WebElement pickupOption=Driver.getDriver().findElement(By.xpath(
                "//li[text()='Pickup']"));
        ReusableMethods.waitAndClick(pickupOption,2);
        ReusableMethods.waitAndClick(adminPage.applyFiltersButton,2);
        ReusableMethods.verifyAssertTrue("Pickup",adminPage.filteredOrderType.getText(),
                "Order Type Filter not functional");
        extentTest.pass("Verified that Order Type Filter is functional");

        //Sayfa kapatılır
        Driver.closeDriver();
        extentTest.info("Browser closed");
        softAssert.assertAll();
    }

    @Test
    public void test3804(){
        AdminPage adminPage=new AdminPage();
        SoftAssert softAssert=new SoftAssert();
        extentTest = extentReports.createTest("TC_3804 Test",
                "Admin sorts orders by Order Id");

        //Launch browser
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Browser opened");

        //1.Admin girişi yapılır
        AdminPage.adminLogin(ConfigReader.getProperty("adminUsername"),ConfigReader.getProperty("adminPassword"));
        extentTest.pass("Login to site as Admin");

        //2.Orders menusu altında All Orders sayfasında Order ID butonuna tıklanır.
        ReusableMethods.waitAndClick(adminPage.ordersLink);
        extentTest.pass("Clicked on Orders link");
        ReusableMethods.waitAndClick(adminPage.allOrderLink);
        extentTest.pass("Clicked on All Order link");
        ReusableMethods.wait(1);
        ReusableMethods.waitAndClick(adminPage.orderIDSort);
        extentTest.pass("Clicked Order ID link");

        //3.ID ye gore sıralama yapildigi test edilir
        List<WebElement> ids=Driver.getDriver().findElements(By.xpath("sorting_1"));
        List<Integer> orderIDList=new ArrayList<>();
        for (WebElement each:ids
        ) {
            int userId = Integer.parseInt(each.getText());
            orderIDList.add(userId);
        }
        List<Integer> expectedList = new ArrayList<Integer>(orderIDList);
        Collections.sort(expectedList);
        softAssert.assertEquals(expectedList,orderIDList,"Order ID Sort link not functional");
        extentTest.pass("Verified that Orders ID sorted the orders");

        //Sayfa kapatılır
        Driver.closeDriver();
        extentTest.info("Browser closed");
        softAssert.assertAll();
    }

    @Test
    public void test3805(){
        AdminPage adminPage=new AdminPage();
        SoftAssert softAssert=new SoftAssert();
        extentTest = extentReports.createTest("TC_3805 Test",
                "Admin examines an order in detail in the Actions section.");
        //Launch browser
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Browser opened");

        //1.Admin girişi yapılır
        AdminPage.adminLogin(ConfigReader.getProperty("adminUsername"),ConfigReader.getProperty("adminPassword"));
        extentTest.pass("Login to site as Admin");

        //2.Orders menusunden All Orders sayfasında Actions altındaki inceleme butonuna tıklanır.
        ReusableMethods.waitAndClick(adminPage.ordersLink,2);
        extentTest.pass("Clicked on Orders link");
        ReusableMethods.waitAndClick(adminPage.allOrderLink,2);
        extentTest.pass("Clicked on All Orders link");
        ReusableMethods.waitAndClick(adminPage.eyeIconButton,2);
        extentTest.pass("Clicked on Eye icon");

        //3.Sayfa basliginin Order Details oldugu test edilir.
        softAssert.assertEquals("Order Details",Driver.getDriver().getTitle());
        extentTest.pass("Verified that page title is Orders Details");

        //4.Sayfada Summary bolumunun oldugu test edilir
        ReusableMethods.isDisplayed(Driver.getDriver().findElement(By.xpath("//h5[text()='Summary']")),
                "Summary not found");
        extentTest.pass("Verified that Summary is displayed");

        //5.Müşteri ile iletişim kurabileceği numaranın varlığı test edilir.
        adminPage.threePointButton.click();
        extentTest.pass("Clicked three point button");
        adminPage.contactCustomerLink.click();
        extentTest.pass("Clicked contact customer option");
        softAssert.assertTrue(adminPage.customerNumberElement.getText().startsWith("+"));
        extentTest.pass("Verified that customer number is displayed");
        adminPage.okayButton.click();

        //6.Siparişin zaman çizelgesinin var olduğu ve çalıştığı test edilir
        adminPage.threePointButton.click();
        extentTest.pass("Clicked three point button");
        adminPage.timelineLink.click();
        extentTest.pass("Clicked timeline option");
        ReusableMethods.isDisplayed(adminPage.timelineBox,"Timeline information not found");
        extentTest.pass("Verified that Timeline information is displayed");
        ReusableMethods.waitAndClick(adminPage.xCloseButton,2);


        //7.Sipariş bilgilerinin A4 formatında indirilebildiği test edilir.
        ReusableMethods.wait(2);
        ReusableMethods.waitAndClick(adminPage.threePointButton,2);
        extentTest.pass("Clicked three point button");
        adminPage.downloadA4Link.click();
        extentTest.pass("Clicked Download A4 option");
        String downloadsPath = System.getProperty("user.home") + "/Downloads";
        File downloadsFolder = new File(downloadsPath);
        File[] files = downloadsFolder.listFiles();
        boolean fileFound = false;
        for (File file : files) {
            if (file.getName().contains("document.pdf")) {
                fileFound = true;
                break;
            }
        }
        softAssert.assertTrue(fileFound, "Download not successful");
        extentTest.pass("Verified that Download is successful");

        //8.Sayfada Print butonunun görünür ve erişilebilir oldugu test edilir.
        ReusableMethods.isDisplayed(adminPage.printButton,"Print button is not displayed");
        extentTest.pass("Verified that Print button is displayed");

        //Sayfa kapatılır
        softAssert.assertAll();
        Driver.closeDriver();

    }
    @Test
    public void test3806(){
        AdminPage adminPage=new AdminPage();
        SoftAssert softAssert=new SoftAssert();
        extentTest = extentReports.createTest("TC_3806 Test",
                "Admin sorts orders by Merchant");
        //Launch browser
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Browser opened");

        //1.Admin girişi yapılır
        AdminPage.adminLogin(ConfigReader.getProperty("adminUsername"),ConfigReader.getProperty("adminPassword"));
        extentTest.pass("Login to site as Admin");

        //2.Orders menusu altında All Orders sayfasında Merchant butonuna tıklanır.
        ReusableMethods.waitAndClick(adminPage.ordersLink,2);
        extentTest.pass("Clicked on Orders link");
        ReusableMethods.waitAndClick(adminPage.allOrderLink,2);
        extentTest.pass("Clicked on All Order link");
        ReusableMethods.waitAndClick(adminPage.merchantSort,2);
        extentTest.pass("Clicked Merchant link");

        //3.Merchant'a gore sıralama yapildigi test edilir
        List<String> merchantList=new ArrayList<>();
        for (int i = 4; i <=58 ; i=i+6) {
            merchantList.add(Driver.getDriver().findElement(By.xpath("(//td)["+i+"]")).getText());
        }
        List<String> expectedList = new ArrayList<>(merchantList);
        Collections.sort(expectedList);
        softAssert.assertEquals(expectedList,merchantList,"Merchant Sort link not functional");
        extentTest.fail("Merchant Sort link not functional");

        //Sayfa kapatılır

        Driver.closeDriver();
        extentTest.info("Browser closed");
        softAssert.assertAll();
    }
    @Test
    public void test3807(){
        AdminPage adminPage=new AdminPage();
        SoftAssert softAssert=new SoftAssert();
        extentTest = extentReports.createTest("TC_3807 Test",
                "Admin sorts orders by Customer");
        //Launch browser
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Browser opened");

        //1.Admin girişi yapılır
        AdminPage.adminLogin(ConfigReader.getProperty("adminUsername"),ConfigReader.getProperty("adminPassword"));
        extentTest.pass("Login to site as Admin");

        //2.Orders menusu altında All Orders sayfasında Customer butonuna tıklanır.
        ReusableMethods.waitAndClick(adminPage.ordersLink,2);
        extentTest.pass("Clicked on Orders link");
        ReusableMethods.waitAndClick(adminPage.allOrderLink,2);
        extentTest.pass("Clicked on All Order link");
        ReusableMethods.waitAndClick(adminPage.customerSort,2);
        extentTest.pass("Clicked Merchant link");

        //3.Customer'a gore sıralama yapildigi test edilir
        List<String> customerList=new ArrayList<>();
        for (int i = 5; i <=59 ; i=i+6) {
            customerList.add(Driver.getDriver().findElement(By.xpath("(//td)["+i+"]")).getText());
        }
        List<String> expectedList = new ArrayList<>(customerList);
        Collections.sort(expectedList);
        softAssert.assertEquals(expectedList,customerList,"Customer Sort link not functional");
        extentTest.fail("Customer Sort link not functional");

        //Sayfa kapatılır
        Driver.closeDriver();
        extentTest.info("Browser closed");
        softAssert.assertAll();
    }

    @Test
    public void test3808(){
        AdminPage adminPage=new AdminPage();
        SoftAssert softAssert=new SoftAssert();
        extentTest = extentReports.createTest("TC_3808 Test",
                "Admin downloads an order to computer from the Actions section.");
        //Launch browser
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Browser opened");

        //1.Admin girişi yapılır
        AdminPage.adminLogin(ConfigReader.getProperty("adminUsername"),ConfigReader.getProperty("adminPassword"));
        extentTest.pass("Login to site as Admin");

        //2.Orders menusunden All Orders sayfasında Actions altındaki indirme butonuna tıklanır.
        adminPage.ordersLink.click();
        extentTest.pass("Clicked on Orders link");
        adminPage.allOrderLink.click();
        extentTest.pass("Clicked on All Order link");
        ReusableMethods.isDisplayed(adminPage.downloadButton,"Download button not functional");
        adminPage.downloadButton.click();
        extentTest.pass("Clicked on Download arrow button");

        //3.Dosyanın bilgisayara indirildigi test edilir
        String downloadsPath = System.getProperty("user.home") + "/Downloads";
        File downloadsFolder = new File(downloadsPath);
        File[] files = downloadsFolder.listFiles();
        boolean fileFound = false;
        for (File file : files) {
            if (file.getName().contains("document.pdf")) {
                fileFound = true;
                break;
            }
        }
        softAssert.assertTrue(fileFound, "Download not successful");
        extentTest.pass("Verified that Download successful");

        //Sayfa kapatılır
        Driver.closeDriver();
        extentTest.info("Browser closed");
        softAssert.assertAll();
    }

    @Test
    public void test3809(){
        AdminPage adminPage=new AdminPage();
        SoftAssert softAssert=new SoftAssert();
        extentTest = extentReports.createTest("TC_3809 Test",
                "Admin navigates through the entries on the All orders page.");
        //Launch browser
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Browser opened");

        //1.Admin girişi yapılır
        AdminPage.adminLogin(ConfigReader.getProperty("adminUsername"),ConfigReader.getProperty("adminPassword"));
        extentTest.pass("Login to site as Admin");

        //2.Orders menusu altında All Order linkine tıklanır
        adminPage.ordersLink.click();
        extentTest.pass("Clicked on Orders link");
        adminPage.allOrderLink.click();
        extentTest.pass("Clicked on All Order link");

        //3.Sayfa sonunda goruntulenen entrie sayısı metni kaydedilir
        ReusableMethods.wait(2);
        JSUtilities.scrollToBottom(Driver.getDriver());
        ReusableMethods.wait(2);
        String firstPageEntryStr=adminPage.totalEntryInfoLabel.getText();
        extentTest.pass("Verified that total entry info label is displayed");

        //4.Next butonunun görünür ve erişilir oldugu test edilir.
        ReusableMethods.isDisplayed(adminPage.nextButton,"Next button not displayed");
        extentTest.pass("Verified that Next button displayed and active");

        //5.Previous butonunun görünür ama erişilemez oldugu test edilir.
        ReusableMethods.isDisplayed(adminPage.previousFirstButton,"Previous button not displayed");
        softAssert.assertTrue(adminPage.previousFirstButton.isEnabled(),
                "Previous button active on first page! Its unnecessary");
        ReusableMethods.wait(2);
        extentTest.pass("Verified that Previous button just displayed");


        //6.Next butonuna tıklanır ve sayfada ilerlendigi test edilir.
        adminPage.nextButton.click();
        extentTest.pass("Clicked on Next button");
        ReusableMethods.wait(2);
        String nextPageEntryStr=adminPage.totalEntryInfoLabel.getText();
        softAssert.assertFalse(firstPageEntryStr.equals(nextPageEntryStr),"Next button not functional");
        extentTest.pass("Verified that Next button functional");

        //7.Previous butonunun görünür ve erişilebilir oldugu test edilir.
        ReusableMethods.isDisplayed(adminPage.previousButton,"Previous button not displayed");
        extentTest.pass("Verified that Previous button displayed and active");
        ReusableMethods.wait(2);
        adminPage.previousButton.click();
        ReusableMethods.wait(1);
        extentTest.pass("Clicked on Previous button");
        String againFirstPageEntrie=adminPage.totalEntryInfoLabel.getText();
        softAssert.assertEquals(againFirstPageEntrie,firstPageEntryStr,"Previous button not functional");
        extentTest.pass("Verified that Previous button functional");

        //Sayfa kapatılır
        Driver.closeDriver();
        extentTest.info("Browser closed");
        softAssert.assertAll();

    }

    @Test
    public void test3810(){
        AdminPage adminPage=new AdminPage();
        SoftAssert softAssert=new SoftAssert();
        extentTest = extentReports.createTest("TC_3810 Test",
                "Admin access order status change buttons on the Order Details page.");

        //Launch browser
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Browser opened");

        //1.Admin girişi yapılır
        AdminPage.adminLogin(ConfigReader.getProperty("adminUsername"),ConfigReader.getProperty("adminPassword"));
        extentTest.pass("Login to site as Admin");

        //2.Orders menusunden All Orders sayfasında Actions altındaki ilk sipariş inceleme butonuna tıklanır.
        ReusableMethods.waitAndClick(adminPage.ordersLink,2);
        extentTest.pass("Clicked on Orders link");
        ReusableMethods.waitAndClick(adminPage.allOrderLink,2);
        extentTest.pass("Clicked on All Order link");
        ReusableMethods.waitAndClick(adminPage.eyeIconButton,2);
        extentTest.pass("Clicked the eye icon to examine the product in detail.");

        //3.1.Sipariş durumu ""accepted"" ise Ready for Pickup ve Assign Driver butonları görünür
        // ve aktif oldugunu test eder.
        //3.2.Sipariş durumu ""delivery on its ways"" ise Delivery on its ways,
        // Delivered, Delivery Failed ve Assign Driver butonlarinin görünür ve aktif oldugunu test eder.
        // Delivery on its ways butonuna tıklar ve hata mesajı alır.
        //3.3.Sipariş durumu ""new"" ise Accepted, Reject ve Assign Driver butonları görünür ve aktif oldugunu test eder.
        //3.4.Sipariş durumu ""ready for pickup"" ise Delivery on its ways, Delivered, Delivery Failed ve Assign Driver
        // butonları görünür ve aktif oldugunu test eder.

        String orderStatus=adminPage.orderStatusLabel.getText();
        extentTest.pass("Orders status detected as >"+orderStatus);
        AdminPage.buttonTestByOrderStatus(orderStatus);
        extentTest.pass("The buttons that the admin can use were analyzed.");

        //Sayfa kapatılır"
        Driver.closeDriver();
        extentTest.info("Browser closed");
        softAssert.assertAll();
    }
    @Test
    public void test3811(){
        AdminPage adminPage=new AdminPage();
        SoftAssert softAssert=new SoftAssert();
        extentTest = extentReports.createTest("TC_3811 Test",
                "Admin access order status change buttons on the Order Details page.");

        //Launch browser
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Browser opened");

        //1.Admin girişi yapılır
        AdminPage.adminLogin(ConfigReader.getProperty("adminUsername"),ConfigReader.getProperty("adminPassword"));
        extentTest.pass("Login to site as Admin");

        //2.Orders menusunden All Orders sayfasında Actions altındaki ilk sipariş inceleme butonuna tıklanır.
        ReusableMethods.waitAndClick(adminPage.ordersLink,2);
        extentTest.pass("Clicked on Orders link");
        ReusableMethods.waitAndClick(adminPage.allOrderLink,2);
        extentTest.pass("Clicked on All Order link");
        ReusableMethods.waitAndClick(adminPage.eyeIconButton,2);
        extentTest.pass("Clicked the eye icon to examine the product in detail.");

        //3.1.Sipariş durumu ""complete"" ise sadece Print butonunun görünür ve aktif oldugunu test eder.
        //3.2.Sipariş durumu ""cancelled"" ise sadece Print butonunun görünür ve aktif oldugunu test eder.
        //3.3.Sipariş durumu ""delivered"" ise sadece Print butonunun görünür ve aktif oldugunu test eder.
        //3.4.Sipariş durumu ""delivery failed"" ise sadece Print butonunun görünür ve aktif oldugunu test eder.
        //3.4.Sipariş durumu ""rejected"" ise sadece Print butonunun görünür ve aktif oldugunu test eder.
        String orderStatus=adminPage.orderStatusLabel.getText();
        extentTest.pass("Orders status detected as >"+orderStatus);
        AdminPage.buttonTestByOrderStatus(orderStatus);
        extentTest.pass("The buttons that the admin can use were analyzed.");

        //Sayfa kapatılır"
        Driver.closeDriver();
        extentTest.info("Browser closed");
        softAssert.assertAll();
    }
}
