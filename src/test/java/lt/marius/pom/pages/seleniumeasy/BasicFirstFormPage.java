package lt.marius.pom.pages.seleniumeasy;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.Locators;

public class BasicFirstFormPage {

    public static void open() {
        Common.setUpDriver();
        Common.openUrl("http://demo.seleniumeasy.com/basic-first-form-demo.html");
    }

    public static void enterMessage(String inputMessage) {
        Common.sendKeysToElement(
                Locators.SeleniumEasy.BasicFirstForm.inputUserMessage,
                inputMessage);
    }

    public static void clickOnButtonShowMessage() {
        Common.clickOnElement(Locators.SeleniumEasy.BasicFirstForm.buttonShowMessage);
    }

    public static String readMessage() {

        return Common.getTextFromElement(Locators.SeleniumEasy.BasicFirstForm.spanDisplay);
    }

    public static void inputValueA(String value) {
        Common.sendKeysToElement(Locators.SeleniumEasy.BasicFirstForm.inputValueA,
                value);
    }

    public static void inputValueB(String value) {
        Common.sendKeysToElement(Locators.SeleniumEasy.BasicFirstForm.inputValueB,
                value);
    }

    public static void clickButtonGetTotal() {
        Common.clickOnElement(Locators.SeleniumEasy.BasicFirstForm.buttonGetTotal);
    }

    public static String readMessageTotal() {
        return Common.getTextFromElement(Locators.SeleniumEasy.BasicFirstForm.spanDisplayValue);
    }
}
