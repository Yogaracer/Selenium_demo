package lt.marius.pom.pages.demoqa;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.Locators;

public class TextBoxPage {
    public static void open() {
        Common.setUpDriver();
        Common.openUrl("https://demoqa.com/text-box");
    }

    public static void enterFullName(String messageFullName) {

        Common.sendKeysToElement(
                Locators.Demoqa.TextBox.inputUserName,
                messageFullName
        );
    }

    public static void clickOnButtonSubmit() {

        Common.clickOnElement(Locators.Demoqa.TextBox.buttonSubmit); // uzvadiname pagal xpath: button[@id='submit']"
    }

    public static String readFullNameMessage() {

        return Common.getTextFromElement(Locators.Demoqa.TextBox.paragraphName); // paragraphName pagal elemento xpath id inspection'e
    }

    public static void enterEmailAdress(String messageEmail) {
        Common.sendKeysToElement(Locators.Demoqa.TextBox.inputUserEmail,
                messageEmail
        );
    }

    public static String readEmailMessage() {
        return Common.getTextFromElement(Locators.Demoqa.TextBox.paragraphEmail);
    }
}
