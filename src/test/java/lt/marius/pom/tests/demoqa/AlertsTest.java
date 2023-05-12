package lt.marius.pom.tests.demoqa;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.demoqa.AlertsPage;
import lt.marius.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertsTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        AlertsPage.open();
    }

    @Test
    public void testAlertBox(){
        String expectedResult = "You clicked a button";
        String actualResult;

        AlertsPage.clickButtonDisplayAlertBox();
        Common.sleep(2000);
        actualResult = AlertsPage.getTextFromAlertBox();
        Common.sleep(2000);
        AlertsPage.clickOnButtonOkOfAlertBox();
        Common.sleep(2000);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testAlertBoxWithDelay(){
        String expectedResult = "This alert appeared after 5 seconds";
        String actualResult;

        AlertsPage.clickButtonToDisplayDelayedAlertBox();
        actualResult = AlertsPage.getTextFromDelayedAlertBox();
        AlertsPage.clickOnButtonOkOfDelayedAlertBox();
        Assert.assertEquals(actualResult, expectedResult);
    }
}

