package utilities.helper;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class ElementActions {

    public static void clickOnElement(WebDriver driver, By locator) {
        VerifyActions.isDisplayed(driver, locator);
        VerifyActions.isClickable(driver, locator);
        driver.findElement(locator).click();
    }

    public static void sendKeys(WebDriver driver, By locator, String keys) {

        VerifyActions.isClickable(driver, locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(keys);
    }

    public static void clickOnEnter(WebDriver driver) {
        ElementActions.waitElement(500);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();


    }

    public static void clickOnRight(WebDriver driver, By locator) {
        VerifyActions.isClickable(driver, locator);
        driver.findElement(locator).sendKeys(Keys.ARROW_RIGHT);
    }

    public static String getElementText(WebDriver driver, By locator) {
        VerifyActions.isDisplayed(driver, locator);
        return driver.findElement(locator).getText();
    }

    public static void clear(WebDriver driver, By locator) {
        driver.findElement(locator).clear();
    }

    public static WebElement getElement(WebDriver driver, By locator) {
        return driver.findElement(locator);
    }

    public static void waitElement(int mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public static void closePopUp(WebDriver driver){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public static void selectByIndex(WebDriver driver,int index,By locator){
        WebElement dropList = driver.findElement(locator);
        Select dropDown = new Select(dropList);
        dropDown.selectByIndex(index);
    }
    public static void selectByValue(WebDriver driver,String value,By locator){
        WebElement dropList = driver.findElement(locator);
        Select dropDown = new Select(dropList);
        dropDown.selectByValue(value);
    }
    public static String getPopSuccessText(WebDriver driver) {

        try {
            Thread.sleep(100);
            return  driver.switchTo().alert().getText();

        } catch (Exception e) {
            System.out.println("No Alert displayed");
        }
        return null;

    }
}
