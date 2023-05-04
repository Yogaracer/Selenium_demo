package lt.marius.pom.pages.demoqa;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.Locators;

public class ModalDialogsPage {
    public static void open() {
        Common.setUpDriver();
        Common.openUrl("https://demoqa.com/modal-dialogs");
    }

    public static void clickOnButtonSmallModal() {
        Common.clickOnElement(Locators.Demoqa.ModalDialogs.buttonShowSmallModal);
    }

    public static void closeSmallModal() {
        Common.clickOnElement(Locators.Demoqa.ModalDialogs.buttonCloseSmallModal);
    }

    public static void clickOnButtonLargeModal() {
        Common.clickOnElement(Locators.Demoqa.ModalDialogs.buttonShowLargeModal);
    }

    public static void closeLargeModal() {
        Common.clickOnElement(Locators.Demoqa.ModalDialogs.buttonCloseLargeModal);
    }
}
