package lt.marius.pom.pages.tv3;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.Locators;

public class TV3homePage {
    public static void open() {
        Common.setUpDriver();
        Common.openUrl("https://www.tv3.lt/");
    }

    public static void clickOnButtonCookiesAcceptance() {

        if (Common.waitForElementToBeVisibleCustomised(Locators.TV3.TV3home.buttonCookiesAcceptance)) {
        }
        Common.clickOnElement(Locators.TV3.TV3home.buttonCookiesAcceptance);
    }
}
