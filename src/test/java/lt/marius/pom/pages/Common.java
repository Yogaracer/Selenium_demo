package lt.marius.pom.pages;

import lt.marius.pom.utils.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


public class Common {

    public static List<String> brokenLinks = new ArrayList<>();

    public static List<String> validLinks = new ArrayList<>();

    public static List<String> brokenImages = new ArrayList<>(); // static reiskia pasieksime is bet kurios vietos


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
        getSelectElement(locator).selectByValue(value);

    }

    public static void selectOptionGroupByValue(By locator, List<String> selectValues) {
        Select selectElement = getSelectElement(locator);

        for (String value : selectValues) {
            selectElement.selectByValue(value);
        }
    }

    private static Select getSelectElement(By locator) {
        WebElement element = getElement(locator);
        Select selectElement = new Select(element);
        return selectElement;
    }


    public static List<Boolean> getStatusesOfSelectedOptionsGroup(By locator, List<String> selectValues) {
        List<Boolean> selectedStatusList = new ArrayList<>();
        List<WebElement> elements = getSelectElement(locator).getAllSelectedOptions();

//        for (String value : selectValues) {
////            for (WebElement element: elements) {
////                if(element.getAttribute("value").equals(value)){
////                    selectedStatusList.add(element.isSelected());
//            break;

        for (WebElement element : elements) {
            selectedStatusList.add(element.isSelected());
        }
        return selectedStatusList;
    }

    public static String getElementAttributeValue(By locator, String attributeName) {
        return getElement(locator).getAttribute(attributeName);
    }

    public static boolean verifyLink(By locator, String attributeName) { //sukurus metoda reikia pakeisti parametrus i  locator ir attribute name
        WebElement element = getElement(locator);
        String link = element.getAttribute(attributeName);
        return checkHttpResponseCode(link, element);
    }

    public static boolean verifyAllLinks(By locator, String attributeName) { //tikrina visu linku statusa

        List<WebElement> elements = getElements(locator);
        boolean testStatus = true; //default reiksme true

        for (WebElement element : elements) { // kiekviena elementa pasiimame
            String link = element.getAttribute(attributeName); // pasiimame elemento linka
            if (!checkHttpResponseCode(link, element)) { //ciklas suksis kol testuojamas linkas bus Broken - false
                testStatus = false;
            }
        }
        return testStatus;
    }

    private static boolean checkHttpResponseCode(String link, WebElement element) {
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

        if (element.getTagName().equals("img")) { // pagal tag pavadinima galime atpazinti ar vykdyti si metoda
            boolean isImageVisible = checkImageDisplayValidation(element); // skirta neveikianciu image failu ataskaitai generuoti

            if (!isImageVisible) {
                brokenImages.add(
                        "Broken image, url: %s".formatted(
                                link
                        )
                );
            }
            return isImageVisible;
        }
        return true;
    }

    private static boolean checkImageDisplayValidation(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) Driver.getDriver(); // vienas is budu apsirasyti, nuskaityti, paklikinti

        return (Boolean) javascriptExecutor.executeScript(
                "return (typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0);",
                element);
    }

    public static void waitForElementToBeClickable(By locator) {
        System.out.println( // testo rezultate spausdina kada koki statusa igyja mygtukas
                "IsEnabled: " + Common.getElement(locator).isEnabled() +
                        "\n\t starting time: " + LocalTime.now().getSecond()
        );
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForElementAttributeContains(String attributeName, String attributeValue, By locator) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.attributeContains(locator, attributeName, attributeValue));
    }

    public static void waitForElementToBeVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static boolean waitForElementToBeClickableCustomised(By locator) {

        int waitingSeconds = 5; // ciklas kuris tikrina ar elementas yra isEnabled kas 0.5 sekundes naudojant wait statusa

        for (int i = 0; i < (waitingSeconds * 2); i++) {
            if (getElement(locator).isEnabled()) {
                return true;
            }
            sleep(500); // tikrina kas 0.5 sekundes
        }
        return false;
    }


    public static boolean waitForElementToBeVisibleCustomised(By locator) { //naudojamas su reklaminiais skydeliais kai
        // jie pasirodo arba nepasirodo
        int waitingSeconds = 7;

        for (int i = 0; i < (waitingSeconds * 2); i++) {
            try {
                getElement(locator);
                return true;
            } catch (NoSuchElementException e) {
                sleep(500);
            }
        }
        return false;
    }

    public static String getWindowHandleName() {
        return Driver.getDriver().getWindowHandle();
    }

    public static String getWindowHandleNames(String windowHandleName) {
        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles(); // grazina set tipo stringus , set
        // neleidzia pavadinimams dubliuotis
        for (String childWindowName : allWindowHandles) { // lyginame main ir child langu pavadinimus
            if (!childWindowName.equals(windowHandleName)) { // jei langu pavadinimai nesutaps, grazinti childWindowName
                return childWindowName;
            }
        }
        return windowHandleName;
    }

    public static void switchToWindow(String name) {
        Driver.getDriver().switchTo().window(name);
    }

    public static void closeWindow() {
        Driver.getDriver().close();
    }

    public static void maximizeWindow() {
        Driver.getDriver().manage().window().maximize();
    }

    public static void acceptAlert() {
        Driver.getDriver().switchTo().alert().accept();
    }

    public static void dismissAlert() {
        Driver.getDriver().switchTo().alert().dismiss();
    }

    public static String getTextFromAlertBox() {
        return Driver.getDriver().switchTo().alert().getText();
    }

    public static boolean waitForAlertToBeVisible() {
        int waitingSeconds = 7;

        for (int i = 0; i < (waitingSeconds * 2); i++) {
            try {
                Driver.getDriver().switchTo().alert();
                return true;
            } catch (NoAlertPresentException e) {
                sleep(500);
            }
        }
        return false;
    }

    public static void sendKeysToAlertBox(String message) {
        Driver.getDriver().switchTo().alert().sendKeys(message);
    }

    public static void clickOnElementByAction(By locator) {

        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(getElement(locator)).
                click().
                build().
                perform();
    }

    public static void clickDoubleOnElementWithAction(By locator) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(getElement(locator)).
                doubleClick().
                build().
                perform();
    }

    public static void clickRightOnElementWithAction(By locator) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(getElement(locator)).
                contextClick().
                build().
                perform();

    }
}



