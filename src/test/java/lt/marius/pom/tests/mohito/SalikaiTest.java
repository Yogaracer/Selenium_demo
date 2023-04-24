package lt.marius.pom.tests.mohito;

import lt.marius.pom.pages.mohito.BadLinkPage;
import lt.marius.pom.pages.mohito.SalikaiPage;
import lt.marius.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SalikaiTest extends TestBase {

    @BeforeMethod
    @Override
    public void setUp() {
        SalikaiPage.open();
    }

    @Test //testas skirtas patikrinti valid page https://demoqa.com/broken

    public void testValidLink() {
        String attributeName = "href";
        boolean expectedResult = true;
        boolean actualResult;

        actualResult = BadLinkPage.verifyLinkValidation(attributeName);

        Assert.assertEquals(actualResult,expectedResult);
}
