package lt.marius.pom.tests.seleniumeasy;

import lt.marius.pom.pages.seleniumeasy.BasicFirstFormPage;
import lt.marius.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicFirstFormTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        BasicFirstFormPage.open();
    }


    @Test
    public void testSingleInputField() {

        String inputMessage = "Kelinta siandien diena?";
        String expectedResult = "Kelinta siandien diena?";
        String actualResult;

        BasicFirstFormPage.enterMessage(inputMessage);
        BasicFirstFormPage.clickOnButtonShowMessage();
        actualResult = BasicFirstFormPage.readMessage();

        Assert.assertEquals(actualResult, expectedResult);
        String.format("Actual: %s; Expected: %s", actualResult, expectedResult);
    }

    @Test
    public void testTwoInputFieldsPositive() {
        String enterValueA = "5";
        String enterValueB = "8";
        String expectedResult = "13";
        String actualResult;

        BasicFirstFormPage.inputValueA(enterValueA);
        BasicFirstFormPage.inputValueB(enterValueB);
        BasicFirstFormPage.clickButtonGetTotal();
        actualResult = BasicFirstFormPage.readMessageTotal();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testTwoInputFieldsNegative() {
        String enterValueA = "5";
        String enterValueB = "aa";
        String expectedResult = "NaN";
        String actualResult;

        BasicFirstFormPage.inputValueA(enterValueA);
        BasicFirstFormPage.inputValueB(enterValueB);
        BasicFirstFormPage.clickButtonGetTotal();
        actualResult = BasicFirstFormPage.readMessageTotal();

        Assert.assertEquals(actualResult, expectedResult);
    }
}


