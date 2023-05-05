package lt.marius.pom.tests.seleniumeasy;

import lt.marius.pom.pages.seleniumeasy.WindowPopupModalPage;
import lt.marius.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WindowPopupModalTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        WindowPopupModalPage.open();
    }

    @Test
    public void testSingleWindowPopup() {
        String expectedResult = "Selenium Easy";
        String actualResult;

        WindowPopupModalPage.clickOnButtonFollowOnTwitter();
        WindowPopupModalPage.switchToNewWindow();
        WindowPopupModalPage.clickOnLogInButtonNoThanks();
        WindowPopupModalPage.closePopupWindowLogin();
        WindowPopupModalPage.closePopupWindowNotification();
        actualResult = WindowPopupModalPage.readMessage();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
