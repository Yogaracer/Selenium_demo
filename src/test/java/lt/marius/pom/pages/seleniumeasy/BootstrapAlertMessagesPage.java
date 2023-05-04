package lt.marius.pom.pages.seleniumeasy;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.Locators;

public class BootstrapAlertMessagesPage {

    public static void open() {
        Common.setUpDriver();
        Common.openUrl("http://demo.seleniumeasy.com/bootstrap-alert-messages-demo.html");
    }


    public static void clickOnButtonAutocloseableSuccess() {
        Common.clickOnElement(Locators.SeleniumEasy.BootstrapAlertMessage.buttonAutocloseableSuccess
        );
    }

    public static void waitForAlertMessageVisibility(String attributeName, String attributeValue) {
        Common.waitForElementAttributeContains(
                attributeName,
                attributeValue,
                Locators.SeleniumEasy.BootstrapAlertMessage.divAlertAutocloseableSuccess
        );
    }
}

