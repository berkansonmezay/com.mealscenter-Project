
package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
public class Driver {
    static WebDriver driver;
    private  Driver(){
    }
    public static WebDriver getDriver() {

        ChromeOptions ops = new ChromeOptions();

        String browser = ConfigReader.getProperty("browser");
        if (driver == null) {
            switch (browser) {
                case "chrome":
                    ops.addArguments("--remote-allow-origins=*");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(ops);
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver= new FirefoxDriver();
                    break;
                default:
                    ops.addArguments("--remote-allow-origins=*");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(ops);
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driver.manage().window().maximize();
        }
        return driver;
    }
    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}