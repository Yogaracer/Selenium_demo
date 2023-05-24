package lt.marius.pom.tests.demoqa;

import lt.marius.pom.pages.demoqa.FramesPage;
import lt.marius.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        FramesPage.open();
    }

    @Test
    public void testIframe() {
        String expectedResult = "This is a sample page";
        String actualResult;

        FramesPage.switchToFrame();
        actualResult = FramesPage.getMessageFromFrame();

        Assert.assertEquals(actualResult, expectedResult);

    }
}
