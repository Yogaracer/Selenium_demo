package lt.marius.pom.tests.seleniumeasy;

import lt.marius.pom.pages.seleniumeasy.BasicCheckBoxPage;
import lt.marius.pom.pages.seleniumeasy.BasicFirstFormPage;
import lt.marius.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicCheckBoxTest extends TestBase {

    @BeforeMethod
    @Override
    public void setUp() {
        BasicCheckBoxPage.open();
    }

    @Test
    public void testSingleCheckBoxDemo() {
        String expectedResult = "Success - Check box is checked";
        String actualResult;

        BasicCheckBoxPage.clickOnSingleCheckBox();
        actualResult = BasicCheckBoxPage.readSingleCheckBoxMessage();

        Assert.assertEquals(actualResult, expectedResult);
        String.format("Actual: %s; Expected: %s", actualResult, expectedResult);
    }

    @Test
    public void testCheckedSingleCheckBoxDemo() { // tikriname ar pazymetas checkboxas Pagal default nustatyma turi buti pazymetas uzkrovus puslapi
        Boolean actualResult;

        actualResult = BasicCheckBoxPage.checkStatusOfCheckBox();

        Assert.assertTrue(actualResult); //ivertina ar pazymetas checkboxas
    }

    @Test
    public void testIfCheckBoxIsEnabled() {
        Boolean expectedResult = false;
        Boolean actualResult;

        actualResult = BasicCheckBoxPage.checkIfCheckBoxIsEnabled();

        Assert.assertEquals(actualResult, expectedResult);
    }
}
