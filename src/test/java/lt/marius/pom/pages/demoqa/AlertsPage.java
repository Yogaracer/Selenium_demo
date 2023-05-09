package lt.marius.pom.pages.demoqa;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.Locators;

public class AlertsPage {
    public static void open() {
        Common.setUpDriver();
        Common.openUrl("https://demoqa.com/alerts");
    }

    public static void clickButtonDisplayAlertBox() {
        Common.clickOnElement(Locators.Demoqa.Alerts.buttonAlert);
    }

    public static String getTextFromAlertBox() {
        return Common.getTextFromAlertBox();
    }

    public static void clickOnButtonOkOfAlertBox() {
        Common.acceptAlert();
    }

    public static void clickButtonToDisplayDelayedAlertBox() {
        Common.clickOnElement(Locators.Demoqa.Alerts.timerAlertButton);
    }

       public static String getTextFromDelayedAlertBox() {
        Common.waitForAlertToBeVisible();
        return Common.getTextFromAlertBox();
    }

    public static void clickOnButtonOkOfDelayedAlertBox() {
        Common.acceptAlert();
    }

}
