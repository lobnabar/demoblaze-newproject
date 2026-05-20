
package tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.Helpers;

public class TestBase {

    public static WebDriver driver;
    private static final String BASE_URL = "https://www.demoblaze.com/";

    @Parameters({"browser"})
    @BeforeClass
    public void startDriver(@Optional("chrome") String browserName) {
        // Trim and ignore case to be safe
        String browser = browserName.trim().toLowerCase();

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (browser.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else {
            // Fallback or Exception if an unknown browser is passed
            throw new IllegalArgumentException("Browser " + browser + " not supported.");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(BASE_URL);
    }
    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            Helpers.takeScreenshot(driver, result.getName());
        }
       
    }


    @AfterClass
    public void stopDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
