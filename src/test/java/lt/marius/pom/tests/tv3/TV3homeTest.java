package lt.marius.pom.tests.tv3;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.tv3.TV3homePage;
import lt.marius.pom.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TV3homeTest extends TestBase {
    @BeforeMethod
    @Override

    public void setUp() {
        TV3homePage.open();
        TV3homePage.clickOnButtonCookiesAcceptance();
    }

    @Test
    public void testTV3() {
        Common.sleep(5000);

    }


}
