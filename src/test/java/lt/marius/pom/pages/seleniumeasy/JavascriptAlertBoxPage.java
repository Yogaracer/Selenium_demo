package lt.marius.pom.pages.seleniumeasy;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.Locators;

public class JavascriptAlertBoxPage {

    public static void open() {
        Common.setUpDriver();
        Common.openUrl("https://demo.seleniumeasy.com/javascript-alert-box-demo.html");
    }


    public static void clickbuttonDisplayAlertBox() {
        Common.clickOnElement(Locators.SeleniumEasy.JavascriptAlertBox.buttonToDisplayAlertBox);

    }

    public static void clickOnButtonOKOfAlertBox() {
        Common.acceptAlert();
    }

    public static String getTextFromAlertBox() {
        return Common.getTextFromAlertBox();
    }


    public static void clickOnButtonToConfirmAlertBox() {
        Common.clickOnElement(Locators.SeleniumEasy.JavascriptAlertBox.buttonToConfirmAlertBox);
    }

    public static void clickOnButtonCancelOfAlertBox() {
        Common.dismissAlert();
    }

    public static String readMessageOfAlertConfirmBox() {
        return Common.getTextFromElement(Locators.SeleniumEasy.JavascriptAlertBox.paragraphAlertConfirmBox);
    }

    public static void clickOnButtonToDisplayAlertPromptBox() {
        Common.clickOnElement(Locators.SeleniumEasy.JavascriptAlertBox.buttonForPromptBox);
    }

    public static void enterMessageIntoAlertPromptBox(String message) {
        Common.sendKeysToAlertBox(message);
    }

    public static String readMessageOfAlertPromptBox() {
        return Common.getTextFromElement(Locators.SeleniumEasy.JavascriptAlertBox.paragraphAlertPromptBox);
    }

}



