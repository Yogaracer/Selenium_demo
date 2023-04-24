package lt.marius.pom.pages;

import lt.marius.pom.utils.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Common {

    public static List<String> brokenLinks = new ArrayList<>();

    public static List<String> validLinks = new ArrayList<>();

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

    public static String getElementAttributeValue(By locator, String attributeName) {
        return getElement(locator).getAttribute(attributeName);
    }

    public static boolean verifyLink(By locator, String attributeName) { //sukurus metoda reikia pakeisti parametrus i  locator ir attribute name
        String link = getElement(locator).getAttribute(attributeName);
        return checkHttpResponseCode(link);
    }

    public static boolean verifyAllLinks(By locator, String attributeName) { //tikrina visu linku statusa
        List<WebElement> elements = getElements(locator);
        boolean testStatus = true; //default reiksme true

        for (WebElement element : elements) {
            String link = element.getAttribute(attributeName);
            if (!checkHttpResponseCode(link)) { //ciklas suksis kol testuojamas linkas bus Broken - false
                testStatus = false;
            }
        }

        return testStatus;
    }

    private static boolean checkHttpResponseCode(String link) {
        try {
            URL url = new URL(link); //raudonas pabraukimas reiskia exeption, ji reikia irengti i TRY CATCH bloka
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(8000);
            httpURLConnection.connect();

            if (httpURLConnection.getResponseCode() >= 400) { // jei kodas > 400 sugeneruojama zinute
                brokenLinks.add(
                        "Resp.Code: %s, Resp.Message: %s, Broken link: %s".formatted(
                                httpURLConnection.getResponseCode(),
                                httpURLConnection.getResponseMessage(),
                                link
                        )
                );

                return false;
            } else {
                validLinks.add(
                        "Resp.Code: %s, Resp.Message: %s, Valid Link: %s".formatted(
                                httpURLConnection.getResponseCode(),
                                httpURLConnection.getResponseMessage(),
                                link
                        )
                );

            }

        } catch (MalformedURLException e) {
            e.printStackTrace(); //pakeiciame default eilute i e.printStackTrace()
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
}


