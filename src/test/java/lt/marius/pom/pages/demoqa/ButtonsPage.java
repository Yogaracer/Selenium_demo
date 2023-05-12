package lt.marius.pom.pages.demoqa;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.Locators;

public class ButtonsPage {
    public static void doubleClickOnButtonPushTwice() {
        Common.clickDoubleOnElementWithAction(
                Locators.Demoqa.Buttons.buttonDoubleClick
        );
}

    public static String readMessageOfDoubleClick() {
        return Common.getTextFromElement(
                Locators.Demoqa.Buttons.paragraphDoubleClick
        );
    }

    public static void rightClickOnButton() {
        Common.clickRightOnElementWithAction(
                Locators.Demoqa.Buttons.buttonRightClick
        );
    }

    public static String readMessageOfRightClick() {
        return Common.getTextFromElement(
                Locators.Demoqa.Buttons.paragraphRightClick
        );
    }
}

