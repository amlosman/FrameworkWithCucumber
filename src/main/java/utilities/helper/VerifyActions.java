package utilities.helper;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VerifyActions {


    public static boolean isDisplayed(WebDriver driver, By locator) {
        return new WebDriverWait(driver, 500).until(ExpectedConditions.presenceOfElementLocated(locator)).isDisplayed();
    }

    public static boolean isClickable(WebDriver driver, By locator) {
        return new WebDriverWait(driver, 500).
                until(ExpectedConditions.elementToBeClickable(locator)).isEnabled();
    }


}
