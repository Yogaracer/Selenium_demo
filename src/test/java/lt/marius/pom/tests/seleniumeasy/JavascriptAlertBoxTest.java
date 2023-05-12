package lt.marius.pom.tests.seleniumeasy;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.seleniumeasy.JavascriptAlertBoxPage;
import lt.marius.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavascriptAlertBoxTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        JavascriptAlertBoxPage.open();

    }

    @Test
    public void testJavascriptAlertBox() {
        String expectedResult = "I am an alert box!";
        String actualResult;

        JavascriptAlertBoxPage.clickbuttonDisplayAlertBox();
        Common.sleep(2000);
        actualResult = JavascriptAlertBoxPage.getTextFromAlertBox();
        Common.sleep(2000);
        JavascriptAlertBoxPage.clickOnButtonOKOfAlertBox();
        Common.sleep(2000);

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test

    public void testJavascriptAlertConfirmBox() {
        String expectedResult = "You pressed OK!";
        String actualResult;

        JavascriptAlertBoxPage.clickOnButtonToConfirmAlertBox();
        JavascriptAlertBoxPage.clickOnButtonOKOfAlertBox();
        actualResult = JavascriptAlertBoxPage.readMessageOfAlertConfirmBox();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "Actual: %s, Expected: %s".formatted(actualResult, expectedResult)
        );
    }


    @Test
    public void testJavascriptAlertConfirmBoxClickCancel() {
        String expectedResult = "You pressed Cancel!";
        String actualResult;

        JavascriptAlertBoxPage.clickOnButtonToConfirmAlertBox();
        JavascriptAlertBoxPage.clickOnButtonCancelOfAlertBox();
        actualResult = JavascriptAlertBoxPage.readMessageOfAlertConfirmBox();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "Actual: %s, Expected: %s".
                        formatted(actualResult, expectedResult)
        );
    }


    @Test
    public void testJavascriptAlertBoxClickOk() {
        String message = "Marius";
        String expectedResult = "Marius";
        String actualResult;

        JavascriptAlertBoxPage.clickOnButtonToDisplayAlertPromptBox();
        JavascriptAlertBoxPage.enterMessageIntoAlertPromptBox(message);
        JavascriptAlertBoxPage.clickOnButtonOKOfAlertBox();
        actualResult = JavascriptAlertBoxPage.readMessageOfAlertPromptBox();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                "Actual: %s, Expected: %s".formatted(actualResult, expectedResult)
        );
    }


}

