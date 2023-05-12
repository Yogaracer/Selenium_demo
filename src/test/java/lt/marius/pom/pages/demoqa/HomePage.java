package lt.marius.pom.pages.demoqa;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.Locators;

public class HomePage {

    public static void open() {

        Common.setUpDriver();
        Common.openUrl("https://demoqa.com/");
    }

    public static void clickOnMenuItemElements() {
        Common.clickOnElementByAction(
                Locators.Demoqa.Home.menuItemElements
        );
    }
}
