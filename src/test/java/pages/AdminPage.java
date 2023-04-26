package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class AdminPage extends TestBaseRapor {


    public AdminPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    //_______________________________________________ ADMİN SADECE LOGİN OLMADAN LOCATLER ____________________________________________________________

    // Admin Panel / Kisi Gorsel
    @FindBy(xpath = "//div[@class='col-md-6 m-0 p-0 left-container']")
    public WebElement adminxImageProfile;

    // Admin Panel / Logo
    @FindBy(xpath = "//div[@class='logok-wrapper']")
    public WebElement adminxLogo;

    // Admin Panel / Admin Login text
    @FindBy(xpath = "//h6[@class='mb-4']")
    public WebElement adminxLabel;

    // Admin Panel/ App store button
    @FindBy(xpath = "(//div[@class='p-2'])[1]")
    public WebElement adminAppxButton;

    // Admin Panel / Google play button
    @FindBy(xpath = "(//div[@class='p-2'])[2]")
    public WebElement adminGooglexButton;

    @FindBy(xpath = "//div[@class='errorMessage']")
    public WebElement adminEmessagexLabel;


//___________________________________________________________________________________________________________________________________________


    //__________________________________________________ ADMİN LOGİN YAPİLDİ TUM LOCATELER ________________________________________________________________

    // Admin Login > Dashboard/Kullanici adi
    @FindBy(xpath = "(//a[@id='dropdownMenuLink'])[1]")
    public WebElement adminloginKullaniciAdixLink;

    // Admin Login > Dashboard/ menulere gittigini dogrulama
    @FindBy(xpath = "//a[@class='navbar-brand']")
    public WebElement adminloginVerifyxLabel;

    @FindBy(xpath = "//button[text()='Apply Filters']")
    public WebElement applyFiltersButton;


    // Admin Login > Ortak search box
    @FindBy(xpath = "//input[@type='search']")
    public WebElement adminloginSearchBox;

    // Admin Login > Ortak arama buyutec icon
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement adminloginBuyutecxIcon;

    // Admin Login > Ortak arama sonuclari
    @FindBy(xpath = "//tr[@class='odd']")
    public WebElement adminloginSearchResult;

    // Admin Login > Ortak aramadan vazgec "x" icon
    @FindBy(xpath = "(//button[@type='button'])[2]")
    public WebElement adminloginXxIcon;

    // Admin Login > Merchant/List > merchant delete icon
    @FindBy(xpath = "(//a[@data-toggle='tooltip'])[2]")
    public WebElement adminloginTableDeletexIcon;

    // Admin Login > Merchant/List > merchant edit icon
    @FindBy(xpath = "(//a[@data-toggle='tooltip'])[1]")
    public WebElement adminloginTableEditxIcon;

    // Admin Login > Merchant/List > Add new button
    @FindBy(xpath = "(//div[@class='p-2'])[1]")
    public WebElement adminloginAddnewxButton;

    // Admin Login > Merchant/List > Add new > 403 hata mesaji
    @FindBy(xpath = "//div[@class='container']")
    public WebElement adminloginAddnew403MessagexLabel;

    // Admin Login > Merchant/List > en alt "Next" button
    @FindBy(id = "merchantListActions_next")
    public WebElement adminloginNextxButton;

    // Admin Login > Reports/Order earnings > en alt "Next" button
    @FindBy(id = "DataTables_Table_0_next")
    public WebElement adminloginOrderNextxButton;

    // Admin Login > Reports/Order earnings > SearchBox
    @FindBy(xpath = "(//input[@type='search'])[2]")
    public WebElement adminloginOrderSearchxBox;

    // Admin Login > Merchant/List > en alt "Previous" button
    @FindBy(id = "merchantListActions_previous")
    public WebElement adminloginPreviousxButton;

    // Admin Login > Merchant/List > Edit / logo
    @FindBy(xpath = "//div[@class='col-lg-7']")
    public WebElement adminloginEditxLogo;

    // Admin Login > Merchant/List > Edit / Restaurant name box
    @FindBy(xpath = "(//div[@class='form-label-group'])[1]")
    public WebElement adminloginEditNamexField;

    // Admin Login > Reports/Order earnings > Arama sonuc
    @FindBy(xpath = "(//tr/td)[1]")
    public WebElement adminloginSonucOrder;

    @FindBy(xpath = "(//button[@type='button'])[3]")
    public WebElement adminloginBrowsexButton;

    @FindBy(xpath = "(//button[@type='button'])[7]")
    public WebElement adminloginHeaderxButton;

    @FindBy(xpath = "(//li[@class='nav-item'])[2]")
    public WebElement adminloginUploadxButton;

    @FindBy(xpath = "(//li[@class='nav-item'])[4]")
    public WebElement adminloginUpHeadxButton;

    @FindBy(xpath = "(//button[@aria-label='Close'])[1]")
    public WebElement adminloginUploadCloseİcon;

    // Admin Login > Buyers
    @FindBy(xpath = "//*[text()='Buyers']")
    public WebElement buyersMenu;

    // Admin Login > Buyers/Reviews
    @FindBy(xpath = "//a[text()='Reviews']")
    public WebElement reviewsMenu;

    // Admin Login > Buyers/Reviews > Reviews/Merchant
    @FindBy(xpath = "(//*[text()='Merchant'])[2]")
    public WebElement merchantKolonu;

    // Admin Login > Buyers/Reviews > Reviews/Reviews
    @FindBy(xpath = "(//*[text()='Reviews'])[4]")
    public WebElement reviewsKolonu;

    //Admin Login > Dashbioard / Promo
    @FindBy(xpath = "//li[@class='promo']")
    public WebElement promoField;

    //Admin Login > Dashbioard > Promo /Coupon
    @FindBy(xpath = "//a[text()='Coupon']")
    public WebElement couponField;

    //Admin Login > Dashbioard > Promo > Coupon/ add new
    @FindBy(xpath = "//a[@type='button']")
    public WebElement addNewButton;

    @FindBy(xpath = "//label[text()='Coupon name ']")
    public WebElement couponNameField;

    @FindBy(xpath = "(//select[@class='form-control custom-select form-control-select'])[1]")
    public WebElement couponTypeField;

    @FindBy(xpath = "//label[text()='Amount ']")
    public WebElement amountField;

    @FindBy(xpath = "//label[text()='Min Order']")
    public WebElement minOrderField;

    @FindBy(xpath = "(//span[@role='combobox'])[1]")
    public WebElement daysAvailableField;

    @FindBy(xpath = "(//div[@class='form-label-group'])[6]")
    public WebElement searchMearchantField;

    @FindBy(xpath = "//li[text()='Bai Tong Thai Street Cafe']")
    public WebElement taiRestaurant;

    @FindBy(id = "AR_voucher_expiration")
    public WebElement expirationField;

    @FindBy(xpath = "(//td[@class='available'])[1]")
    public WebElement tarihField;

    @FindBy(xpath = "AR_voucher_used_once")
    public WebElement couponOptions;

    @FindBy(xpath = "(//select[@class='form-control custom-select form-control-select'])[2]")
    public WebElement statusField;

    @FindBy(xpath = "//input[@class='btn btn-green btn-full mt-3']")
    public WebElement coponSaveButton;

    @FindBy(xpath = "//i[@class='zmdi zmdi-border-color']")
    public WebElement updateButton;

    @FindBy(linkText= "All Coupon")
    public WebElement allCouponField;

    @FindBy(xpath = "//h5[text()='Coupon list']")
    public WebElement couponList;

    @FindBy(xpath = "//div[@class='alert alert-success']")
    public WebElement succesUpdateField;


    @FindBy(xpath = "//h6[text()='Commission this week']")
    public WebElement commissionThisWeek;

    @FindBy(xpath = "//h6[text()='Commission this month']")
    public WebElement commissionThisMonth;

    @FindBy(xpath = "//h6[text()='Subscriptions this month']")
    public WebElement subscriptionsThisMonth;

    // Admin Login > Buyers/Reviews > Reviews/Actions
    @FindBy(xpath = "(//th[@aria-controls='DataTables_Table_0'])[4]")
    public WebElement actionsKolonu;

    @FindBy(xpath = "(//button[@aria-label='Close'])[2]")
    public WebElement adminloginHeadCloseİcon;

    @FindBy(xpath = "(//h6[@class='mb-4 mt-4'])[1]")
    public WebElement adminloginAboutxLabel;

    @FindBy(xpath = "(//h6[@class='mb-4 mt-4'])[3]")
    public WebElement adminloginCuisinexLabel;

    @FindBy(xpath = "(//h6[@class='mb-4'])[4]")
    public WebElement adminloginStatusxLabel;

    @FindBy(id = "AR_merchant_distance_unit")
    public WebElement adminloginEditKMDropDown;

    @FindBy(id = "AR_merchant_status")
    public WebElement adminloginEditStatusDropDown;


    @FindBy(xpath = "//label[@class='custom-control-label']")
    public WebElement adminloginActivexIcon;

    @FindBy(id = "AR_merchant_commision_type")
    public WebElement adminloginMerchantCommissionxDropbox;

    @FindBy(xpath = "//select[@id='AR_merchant_invoice_terms']")
    public WebElement adminloginMerchantInvoicexDropbox;


    @FindBy(xpath = "(//div[@class='p-2'])[1]")
    public WebElement adminloginCheckallxIcon;


    //Admin > Homepage > Orders
    @FindBy(linkText = "Orders")
    public WebElement ordersLink;

    //Admin > Homepage > Orders > All order
    @FindBy(linkText = "All order")
    public WebElement allOrderLink;

    //Admin > Homepage > Orders > All order / orders text
    @FindBy(xpath = "(//*[@class='bg-light p-3 mb-3 rounded'])[1]")
    public WebElement ordersText;

    //Admin > Homepage > Orders > All order / cancel text
    @FindBy(xpath = "(//*[@class='bg-light p-3 mb-3 rounded'])[2]")
    public WebElement cancelText;

    //Admin > Homepage > Orders > All order / total refund text
    @FindBy(xpath = "(//*[@class='bg-light p-3 mb-3 rounded'])[3]")
    public WebElement totalRefundText;

    //Admin > Homepage > Orders > All order / total orders text
    @FindBy(xpath = "(//*[@class='bg-light p-3 mb-3 rounded'])[1]")
    public WebElement totalOrdersText;

    //Admin > Homepage > Orders > All order / total entries text
    @FindBy(id = "DataTables_Table_0_info")
    public WebElement totalEntriesText;

    //Admin > Orders > All order > list
    @FindBy(xpath = "//input[@class='form-control py-2 border-right-0 border']")
    public WebElement timeFilterBox;

    //Admin > Orders > All order > list
    @FindBy(xpath = "//i[@class='zmdi zmdi-filter-list']")
    public WebElement filtersButton;

    //Admin > Orders > All order > list
    @FindBy(xpath = "//li[@data-range-key='Today']")
    public WebElement todayFilter;

    //Admin > Orders > All order > list
    @FindBy(xpath = "//li[@data-range-key='Yesterday']")
    public WebElement yesterdayFilter;

    //Admin > Orders > All order > list
    @FindBy(xpath = "//li[@data-range-key='Last 7 Days']")
    public WebElement last7DaysFilter;

    //Admin > Orders > All order > list
    @FindBy(xpath = "//li[@data-range-key='Last 30 Days']")
    public WebElement last30DaysFilter;

    //Admin > Orders > All order > list
    @FindBy(xpath = "//li[@data-range-key='This Month']")
    public WebElement thisMonthFilter;

    //Admin > Orders > All order > list
    @FindBy(xpath = "//li[@data-range-key='Last Month']")
    public WebElement lastMonthFilter;

    //Admin > Orders > All order > list
    @FindBy(xpath = "//li[@data-range-key='Custom Range']")
    public WebElement customRangeFilter;


    //Admin > Orders > All order > list
    @FindBy(xpath = "(//p[@class='dim m-0'])[4]")
    public WebElement dateInformation;

    //Admin > Orders > All order > list
    @FindBy(xpath = "(//span[@class='select2-selection select2-selection--single'])[1]")
    public WebElement merchantFilter;

    //Admin > Orders > All order > list
    @FindBy(xpath = "(//td)[4]")
    public WebElement filteredMerchantName;

    //Admin > Orders > All order > list
    @FindBy(xpath = "(//div[@class='form-label-group mb-4'])[2]")
    public WebElement customerFilter;

    //Admin > Orders > All order > list
    @FindBy(xpath = "(//td)[5]")
    public WebElement filteredCustomer;

    //Admin > Orders > All order > list
    @FindBy(className = "select2-search__field")
    public WebElement nameSearchBox;

    //Admin > Orders > All order > list
    @FindBy(xpath = "(//div[@class='form-label-group mb-4'])[3]")
    public WebElement statusFilter;

    //Admin > Orders > All order > list
    @FindBy(xpath = "(//span[@class='ml-2 badge order_status complete'])[1]")
    public WebElement filteredStatus;

    //Admin > Orders > All order > list
    @FindBy(xpath = " (//div[@class='form-label-group mb-4'])[4]")
    public WebElement orderTypeFilter;

    //Admin > Orders > All order > list
    @FindBy(xpath = "(//span[@class='ml-2 services badge pickup'])[1]")
    public WebElement filteredOrderType;

    //Admin > Earnings/Merchant Earnings > Merchant Earnings/Total Commission
    @FindBy(xpath = "//*[text()='Total Commission']")
    public WebElement totalCommission;

    //Admin > Earnings/Merchant Earnings > Merchant Earnings/Total Balance
    @FindBy(xpath = "//*[text()='Total Balance']")
    public WebElement totalBalance;

    @FindBy(xpath = "//h6[@class='font13 m-0 badge']")
    public WebElement orderStatusLabel;

    @FindBy(xpath = "//li[@class='paginate_button page-item previous disabled']")
    public WebElement previousFirstButton;


    //Admin > Earnings/Merchant Earnings > Merchant Earnings/ Create a Transaction Button
    @FindBy(id = "dropdownMenuButton")
    public WebElement  createATransaction ;

    //Admin > Earnings/Merchant Earnings > Merchant Earnings/ Create a Transaction Button/Adjustment
    @FindBy(xpath = "//*[text()='Adjustment']")
    public WebElement  adjustment ;

    //Admin > Earnings/Merchant Earnings > Merchant Earnings/ Create a Transaction Button/Adjustment/Create adjustment
    @FindBy(xpath = "(//*[text()='×'])[2]")
    public WebElement  createAdjustmentXButton ;

    //Admin > Orders > All order > list
    @FindBy(xpath = "//div[@class='input-group-text bg-transparent']")
    public WebElement calendarIcon;

    // Admin Login > Ortak save button
    @FindBy(xpath = "//input[@value='Save']")
    public WebElement adminloginSavexButton;

    //Admin > Orders > All order > list
    @FindBy(xpath = "//button[text()='Clear Filters']")
    public WebElement clearFiltersButton;

    //Admin > Orders > All order > list
    @FindBy(xpath = "//th[@aria-controls='DataTables_Table_0']")
    public WebElement orderIDSort;

    //Admin > Orders > All order > list
    @FindBy(xpath = "(//a[@class='ref_view_order normal btn btn-light tool_tips'])[1]")
    public WebElement eyeIconButton;

    //Admin > Orders > All order > list
    @FindBy(xpath = "//a[@class='rounded-pill rounded-button-icon d-inline-block']")
    public WebElement threePointButton;

    @FindBy(xpath = "//a[text()='Contact customer']")
    public WebElement contactCustomerLink;

    @FindBy(xpath = "//div[@class='bootbox-body']")
    public WebElement customerNumberElement;

    @FindBy(xpath = "//button[@class='btn btn-green small pl-4 pr-4 bootbox-accept']")
    public WebElement okayButton;

    @FindBy(xpath = "//a[text()='Timeline']")
    public WebElement timelineLink;

    @FindBy(xpath = "//h5[text()='Timeline']")
    public WebElement timelineBox;

    @FindBy(xpath = "(//span[@aria-hidden='true'])[8]")
    public WebElement xCloseButton;

    @FindBy(xpath = "//a[text()='Download PDF (A4)']")
    public WebElement downloadA4Link;

    @FindBy(xpath = "//button[text()='Print']")
    public WebElement printButton;

    @FindBy(xpath = "(//th[@class='sorting_disabled'])[3]")
    public WebElement merchantSort;

    @FindBy(xpath = "(//th[@class='sorting_disabled'])[4]")
    public WebElement customerSort;

    @FindBy(xpath = "(//i[@class='zmdi zmdi-download'])[1]")
    public WebElement downloadButton;

    @FindBy(className = "dataTables_info")
    public WebElement totalEntryInfoLabel;

    @FindBy(xpath = "//li[@class='paginate_button page-item next']")
    public WebElement nextButton;

    @FindBy(xpath = "//li[@class='paginate_button page-item previous']")
    public WebElement previousButton;

    //Administrator Login > dashboard> reports/merchant sales
    @FindBy(linkText = "Merchant Sales")
    public WebElement merchantSalesAdmin;

    // Administrator Login > dashboard> reports/merchant sales>merchant sales reports
    @FindBy(xpath = "(//*[text()='Merchant Sales Report'])[2]")
    public WebElement merchantsalesreportsYazisiAdmin;

    // Administrator Login > dashboard> reports/merchant sales> date tablosu
    @FindBy(xpath = "//input[@class='form-control py-2 border-right-0 border']")
    public WebElement reportsDateAdmin;

    //Administrator Login > dashboard> reports/merchant sales> Filters
    @FindBy(xpath = "//i[@class='zmdi zmdi-filter-list']")
    public WebElement reportsFiltersAdmin;

    //filters >apply filters
    @FindBy(xpath = "//button[@class='btn btn-green w-100']")
    public WebElement applyFiltersAdmin;

    // filter > icon
    @FindBy(xpath = "//button[@class='close']")
    public WebElement FiltersXAdmin;

    @FindBy(linkText = "Next")
    public WebElement nextReports;

    @FindBy(xpath = "//label[@class='dim custom-control-label']")
    public WebElement remberme;

    @FindBy(xpath = "//a[@class='dim underline']")
    public WebElement forgot;

    @FindBy(xpath = "//label[@for='AR_AdminUser_email_address']")
    public WebElement forgotemail;

    @FindBy(xpath = "//input[@class='btn btn-green btn-full']")
    public WebElement emailboxcl;

    @FindBy(xpath = "//div[@class='errorMessage']")
    public WebElement errorMessage;

    @FindBy(xpath = "//a[@class='dim underline']")
    public WebElement loginhere;

    @FindBy(xpath = "//span[text()='Accepted']")
    public WebElement acceptedButton;
    @FindBy(xpath = "//span[text()='Reject']")
    public WebElement rejectButton;
    @FindBy(xpath = "//button[text()='Assign Driver']")
    public WebElement assignDriverButton;
    @FindBy(xpath = "//span[text()='Ready for pickup']")
    public WebElement readyForPickupButton;
    @FindBy(xpath = "//span[text()='Delivery on its way']")
    public WebElement deliveryOnItsWaysButton;
    @FindBy(xpath = "//span[text()='Delivered']")
    public WebElement deliveredButton;
    @FindBy(xpath = "//span[text()='Delivery Failed']")
    public WebElement deliveryFailedButton;


//___________________________________________________________________________________________________________________________________________


    public static void adminLogin(String username, String password) {

        //Homepage > login/username textbox
        WebElement usernameLocate = Driver.getDriver().findElement(By.id("LoginForm_username"));
        usernameLocate.sendKeys(username);

        //Homepage > login/password textbox
        WebElement passwordLocate = Driver.getDriver().findElement(By.id("LoginForm_password"));
        passwordLocate.sendKeys(password);

        //Homepage > login/signin Button
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//input[@type='submit']"));
        loginButton.click();
    }


    // Admin login > Merchant/List > name,action Baslıklar
    public static WebElement tableFilter(int index) {
        String xpath = "(//th[@aria-controls='merchantListActions'])[" + index + "]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }


    // Admin login > Merchant/List > Edit icon > menuler arası gezinme
    public static WebElement merchantMenuList(int index) {
        String xpath = "(//div[@class='attributes-menu-wrap']//ul//li)[" + index + "]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    // Admin login > Merchant/List > Edit icon > Merchant Information
    public static WebElement merchantDropdwonList(int index) {
        String xpath = "(//span[@class='selection'])[" + index + "]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    // Admin login > Merchant/List > Edit icon/ > Merchant Information
    public static WebElement merchantEditDropdown(int index) {
        String xpath = "(//li[@class='select2-results__option select2-results__option--selectable'])[" + index + "]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    // Admin login > Merchant/List > Edit icon/ > Payment History
    public static WebElement merchantEditTableFilter(int index) {
        String xpath = "(//tr//th)[" + index + "]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }


    // Admin Login > Tum Date filter
    public static WebElement dateFilter(int index) {
        WebElement ilkClick = Driver.getDriver().findElement(By.xpath("(//input[@type='search'])[1]"));
        ilkClick.click();
        ReusableMethods.wait(1);
        String xpath = "(//tr//td)[" + index + "]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    // TUM MENULERİ GEZİNME
    public static WebElement menuList(int index) {
        String xpath = "(//li)[" + index + "]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }


    public static WebElement reviewsChek(int index) {
        String xpath = "(//h5)[" + index + "]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }
    public static WebElement reviewsBaslikChek(int index) {
        String xpath = "(//th[@colspan='1'])[" + index + "]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    public static WebElement reviewsUpdateDeleteIcon(int index) {
        String xpath = "(//a[@data-placement='top'])[" + index + "]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    public static void buttonTestByOrderStatus(String orderStatus){
        extentTest = extentReports.createTest("Button Test according to product status");
        SoftAssert softAssert=new SoftAssert();
        AdminPage adminPage=new AdminPage();
        switch (orderStatus) {
            case "accepted":
                extentTest.info("For >"+orderStatus+" product, there should be Print, Assign Driver and Ready for Pickup buttons on the page.");
                ReusableMethods.isDisplayed(adminPage.printButton,"Print button not displayed");
                ReusableMethods.isEnabled(adminPage.printButton,"Print button not functional");
                extentTest.pass("Print button is on the page");
                softAssert.assertTrue(adminPage.assignDriverButton.isDisplayed(),"Functional button is missing.!");
                extentTest.pass("Assign Driver is on the page");
                softAssert.assertTrue(adminPage.readyForPickupButton.isDisplayed(),"Functional button is missing.!");
                extentTest.pass("Ready for Pickup is on the page");
                break;
            case "cancelled":
            case "complete":
            case "delivered":
            case "delayed":
            case "delivery failed":
            case "rejected":
                extentTest.info("For >"+orderStatus+" there should only be a Print button on the page.");
                ReusableMethods.isDisplayed(adminPage.printButton,"Print button not displayed");
                ReusableMethods.isEnabled(adminPage.printButton,"Print button not functional");
                extentTest.pass("Print button is on the page");
                break;
            case "delivery on its ways":
            case "ready for pickup":
                extentTest.info("For >"+orderStatus+" product, there should be Print, Assign Driver, " +
                        "Delivery On Its Ways, Delivered ve Deliverey Failed in the page.");
                ReusableMethods.isDisplayed(adminPage.printButton,"Print button not displayed");
                ReusableMethods.isEnabled(adminPage.printButton,"Print button not functional");
                extentTest.pass("Print button is on the page");
                softAssert.assertTrue(adminPage.assignDriverButton.isDisplayed(),"Functional button is missing.!");
                extentTest.pass("assignDriverButton is on the page");
                softAssert.assertTrue(adminPage.deliveryOnItsWaysButton.isDisplayed(),"Functional button is missing.!");
                extentTest.pass("deliveryOnItsWaysButton is on the page");
                softAssert.assertTrue(adminPage.deliveredButton.isDisplayed(),"Functional button is missing.!");
                extentTest.pass("deliveredButton is on the page");
                softAssert.assertTrue(adminPage.deliveryFailedButton.isDisplayed(),"Functional button is missing.!");
                extentTest.pass("deliveryFailedButton is on the page");
                break;
            case "new":
                extentTest.info("For >"+orderStatus+" product, there should be Print, Accepted, Reject, Assign Driver buttons");
                ReusableMethods.isDisplayed(adminPage.printButton,"Print button not displayed");
                ReusableMethods.isEnabled(adminPage.printButton,"Print button not functional");
                extentTest.pass("Print button is on the page");
                softAssert.assertTrue(adminPage.acceptedButton.isDisplayed(),"Functional button is missing.!");
                extentTest.pass("acceptedButton is on the page");
                softAssert.assertTrue(adminPage.rejectButton.isDisplayed(),"Functional button is missing.!");
                extentTest.pass("rejectButton is on the page");
                softAssert.assertTrue(adminPage.assignDriverButton.isDisplayed(),"Functional button is missing.!");
                extentTest.pass("assignDriverButton is on the page");
                break;
            default:
                System.out.println(orderStatus+" labelled order not found");
        }
        softAssert.assertAll();
    }

}







