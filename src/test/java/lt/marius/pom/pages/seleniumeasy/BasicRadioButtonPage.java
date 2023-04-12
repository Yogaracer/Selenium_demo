package lt.marius.pom.pages.seleniumeasy;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.Locators;
import net.bytebuddy.asm.Advice;

public class BasicRadioButtonPage {
    public static void open() {
        Common.setUpDriver();
        Common.openUrl("http://demo.seleniumeasy.com/basic-radiobutton-demo.html");
    }

    public static void clickOnRadioButton(String inputGender) {
        Common.clickOnElement(Locators.SeleniumEasy.BasicRadioButton.inputRadioByGender(inputGender));
    }

    public static void clickOnButtonCheck() {
        Common.clickOnElement(Locators.SeleniumEasy.BasicRadioButton.buttonCheck);
    }

    public static String readMessageRadioButtonChecked() {
        return Common.getTextFromElement(Locators.SeleniumEasy.BasicRadioButton.paragraphRadioButtonChecked);
    }
}
