package lt.marius.pom.pages.mohito;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.Locators;

public class SalikaiPage {
    private static String attributeName;

    public static void open() {
            Common.setUpDriver();
            Common.openUrl("https://www.mohito.com/lt/lt/priedai/salikai");
        }

        public static boolean verifyIfAllLinksAreValid(String attributeName) {
            SalikaiPage.attributeName = attributeName;
            return Common.verifyAllLinks(Locators.Mohito.Salikai.linkGroup,attributeName);
        }
    }


