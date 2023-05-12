package lt.marius.pom.pages.demoqa;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.Locators;

public class BrowserWindowsPage {

    private static String mainWindowName;
    private static String childWindowName;


    public static void open() {
        Common.setUpDriver();
        Common.openUrl("https://demoqa.com/browser-windows");
    }

    public static String getMainWindowHandle() {
        return Common.getWindowHandleName();
    }

    public static void clickOnButtonNewTab() {
        Common.clickOnElement(Locators.Demoqa.BrowserWindows.buttonNewTab);

    }

    public static String getChildWindowHandle(String windowHandleName) { //jei butu daugiau langu reiktu issitrukati langu sarasa
        return Common.getWindowHandleNames(windowHandleName);
    }

    public static void switchToWindow(String name) {
        Common.switchToWindow(name);

    }

    public static void sleep(int millis) {
        Common.sleep(millis);
    }

    public static void closeWindow(String name) {
        Common.switchToWindow(name);
        Common.closeWindow();
    }

    public static void clickOnButtonNewWindow() {
        mainWindowName = Common.getWindowHandleName(); //nuskaitome pagrindinio lango pavadinima
        Common.clickOnElement(Locators.Demoqa.BrowserWindows.buttonNewWindow);
    }

    public static void switchToNewWindow() {
        childWindowName = Common.getWindowHandleNames(mainWindowName); // tikrina ar childwindow lango pavadinimas nesutampa su main lango
        Common.switchToWindow(childWindowName);

    }

    public static String readMessageFromHeader() {
        return Common.getTextFromElement(Locators.Demoqa.BrowserWindows.headerSampleHeading);
    }
}
