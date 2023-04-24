package lt.marius.pom.pages.demoqa;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.Locators;

public class BrokenLinkPage {

    public static void open() {
        Common.setUpDriver();
        Common.openUrl("https://demoqa.com/broken");
    }

    public static boolean verifyLinkValidation(String attributeName) {
        return Common.verifyLink(Locators.Demoqa.BrokenLink.linkValid,attributeName ); //linkValid paimtas is inspection skilties eilutes "ValidLink"
    }

    public static boolean verifyLinkValidationBroken(String attributeName) {
        return Common.verifyLink(Locators.Demoqa.BrokenLink.linkBroken,attributeName);
    }

    public static boolean verifyIfAllLinksAreValid(String attributeName) {
        return Common.verifyAllLinks(Locators.Demoqa.BrokenLink.linkGroup,attributeName);
    }
}
