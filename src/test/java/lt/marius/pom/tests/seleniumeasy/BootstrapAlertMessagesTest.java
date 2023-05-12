package lt.marius.pom.tests.seleniumeasy;

import lt.marius.pom.pages.seleniumeasy.BootstrapAlertMessagesPage;
import lt.marius.pom.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BootstrapAlertMessagesTest extends TestBase {

    @BeforeMethod
    @Override

    public void setUp() {
        BootstrapAlertMessagesPage.open();
    }

//    http://demo.seleniumeasy.com/bootstrap-alert-messages-demo.html

    @Test
    public static void testAutocloseableSuccessMessage() {
        String attributeName = "style";
        String attributeValueToDisplay = "block";
        String attributeValueToHide = "none";

        BootstrapAlertMessagesPage.clickOnButtonAutocloseableSuccess();
        BootstrapAlertMessagesPage.waitForAlertMessageVisibility(attributeName, attributeValueToDisplay);
        BootstrapAlertMessagesPage.waitForAlertMessageVisibility(attributeName, attributeValueToHide);
    }
}
