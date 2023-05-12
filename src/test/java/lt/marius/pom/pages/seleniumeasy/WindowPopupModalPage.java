package lt.marius.pom.pages.seleniumeasy;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.Locators;

public class WindowPopupModalPage {

    private static String mainWindowName;
    private static String childWindowName;

    public static void open() {
        Common.setUpDriver();
        Common.openUrl("http://demo.seleniumeasy.com/window-popup-modal-demo.html");
    }

    public static void clickOnButtonFollowOnTwitter() {
        mainWindowName = Common.getWindowHandleName();
        Common.clickOnElement(Locators.SeleniumEasy.WindowPopupModal.buttonFollowOnTwitter);
    }

    public static void switchToNewWindow() {
        childWindowName = Common.getWindowHandleNames(mainWindowName);
        Common.switchToWindow(childWindowName);
        Common.maximizeWindow();

    }

    public static void clickOnLogInButtonNoThanks() {
        Common.clickOnElement(Locators.SeleniumEasy.WindowPopupModal.buttonNoThanks);
    }

    public static void closePopupWindowLogin() {
        boolean isVisible = Common.waitForElementToBeVisibleCustomised(
                Locators.SeleniumEasy.WindowPopupModal.buttonCloseLogin
        );

        if (isVisible) ;
        Common.clickOnElement(Locators.SeleniumEasy.WindowPopupModal.buttonCloseLogin);
    }

    public static void closePopupWindowNotification() {
        boolean isVisible = Common.waitForElementToBeVisibleCustomised(
                Locators.SeleniumEasy.WindowPopupModal.buttonCloseNotification
        );

        if (isVisible) ;
        Common.clickOnElement(Locators.SeleniumEasy.WindowPopupModal.buttonCloseNotification);
    }

    public static String readMessage() {
        return Common.getTextFromElement(Locators.SeleniumEasy.WindowPopupModal.headerSeleniumEasy);
    }
}


