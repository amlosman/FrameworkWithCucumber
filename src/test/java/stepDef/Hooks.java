package stepDef;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import org.openqa.selenium.WebDriver;
import utilities.helper.WebBrowsers;
import utilities.readers.PropertiesReader;

public class Hooks {
    public static WebDriver driver;
    @BeforeAll
    public static void Before_all() {
        driver = WebBrowsers.chooseBrowserDriver("Chrome", PropertiesReader.getValue("headless").equals("no"));
        WebBrowsers.staticmaximizeWindow(driver);
        driver.navigate().to(PropertiesReader.getValue("PracticeAutomation"));
    }
    @AfterAll
    public static void After_all() {

        WebBrowsers.quitWindow(driver);
    }
}
