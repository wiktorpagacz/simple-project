package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import utils.EventReporter;

import java.io.File;
import java.io.IOException;

public class BaseTests extends commonAssertions {
    private EventFiringWebDriver driver;

    @BeforeTest
    public void setUp() {
        Reporter.log("==== Browser session stared. ====", true);
        System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new EventReporter());
        driver.get("...");
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if(ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot) driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources\\screenshots\\" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown() {
        Reporter.log("==== Browser session end. ====", true);
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
