package lt.marius.pom.tests.demoqa;

import lt.marius.pom.pages.demoqa.ButtonsPage;
import lt.marius.pom.pages.demoqa.ElementsPage;
import lt.marius.pom.pages.demoqa.HomePage;
import lt.marius.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ButtonsTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        HomePage.open();
        HomePage.clickOnMenuItemElements();
        ElementsPage.clickOnMenuItemButtons();

    }

    @Test
    public void testButtonDoubleClickWithAction() {
        String expectedResult = "";
        String actualResult;

        ButtonsPage.doubleClickOnButtonPushTwice();
        actualResult = ButtonsPage.readMessageOfDoubleClick();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                """ 
                        Actual: %s"
                        Expected: %s
                        """.formatted(actualResult, expectedResult)
        );
    }

    @Test
    public void testButtonRightClickWithAction() {
        String expectedResult = "right click";
        String actualResult;

        ButtonsPage.rightClickOnButton();
        actualResult = ButtonsPage.readMessageOfRightClick();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                """ 
                        Actual: %s"
                        Expected: %s
                        """.formatted(actualResult, expectedResult)
        );
    }
}
