package lt.marius.pom.pages;

import lt.marius.pom.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Common {

    public static void setUpDriver() {
        Driver.setDriver();
    }

    public static void openUrl(String url) {
        Driver.getDriver().get(url);
    }

    public static void closeDriver() {
        Driver.closeDriver();
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    private static WebElement getElement(By locator) {
        return Driver.getDriver().findElement(locator);
    }

    private static List<WebElement> getElements(By locator) {
        return Driver.getDriver().findElements(locator);
    }

    public static void sendKeysToElement(By locator, String sendKeys) {
        getElement(locator).sendKeys(sendKeys);
    }

    public static void clickOnElement(By locator) {
        getElement(locator).click();
    }

    public static String getTextFromElement(By locator) {
        return getElement(locator).getText();
    }

    public static Boolean getStatusOfCheckBox(By locator) {

        return getElement(locator).isEnabled();
    }

    public static List<Boolean> getStatusesOfCheckBoxGroup(By locator) {
        List<WebElement> elements = getElements(locator);
        List<Boolean> statusList = new ArrayList<>();

        for (WebElement element : elements) {
            statusList.add(element.isSelected()); // is selected - reiskia pazymetas salygoje pvz radio buttonas
        }
        return statusList;
    }

    public static void selectOptionByValue(By locator, String value) {
        WebElement element = getElement(locator);
        Select selectElement = new Select(element);
        selectElement.selectByValue(value);

    }

}
