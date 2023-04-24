package lt.marius.pom.tests.demoqa;

import lt.marius.pom.pages.demoqa.BrokenLinkPage;
import lt.marius.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinkTest extends TestBase {


    @BeforeMethod
    @Override
    public void setUp() {
        BrokenLinkPage.open();

    }

    @Test //testas skirtas patikrinti valid page https://demoqa.com/broken

    public void testValidLink() {
        String attributeName = "href"; //paduodame href atributa kuris nurodytas inspection skiltyje prie ieskomos reiksmes
        boolean expectedResult = true;
        boolean actualResult;

        actualResult = BrokenLinkPage.verifyLinkValidation(attributeName);

        Assert.assertEquals(actualResult,expectedResult);
    }

    @Test // testas skirtas patikrinti broken puslpai https://demoqa.com/broken

    public void testBrokenLink(){
        String attributeName = "href";
        boolean expectedResult = true;
        boolean actualResult;

        actualResult = BrokenLinkPage.verifyLinkValidationBroken(attributeName);
        Assert.assertEquals(actualResult,expectedResult);
    }


    @Test
    public void testIfAllLinksValid(){

        String attributeName = "href";
        boolean expectedResult = true;
        boolean actualResult;

        actualResult = BrokenLinkPage.verifyIfAllLinksAreValid(attributeName);

        Assert.assertEquals(actualResult,expectedResult);
    }

}
