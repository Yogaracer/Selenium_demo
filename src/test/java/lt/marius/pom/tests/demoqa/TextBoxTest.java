package lt.marius.pom.tests.demoqa;

import lt.marius.pom.pages.demoqa.TextBoxPage;
import lt.marius.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextBoxTest extends TestBase {

    @BeforeMethod
    @Override
    public void setUp() {
        TextBoxPage.open();
    }

    @Test
    public void testFullNameInputValidFullName() {
        String messageFullName = "MariusTalalas";
        String expectedResult = "MariusTalalas";
        String actualResult;

        TextBoxPage.enterFullName(messageFullName);
        TextBoxPage.clickOnButtonSubmit();
        actualResult = TextBoxPage.readFullNameMessage();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                String.format("Actual: %s; Expected: %s", actualResult, expectedResult)
        );
    }

    @Test
    public void testEmailInput_WithValidEmail() {
        String messageEmail = "talalasmarius@gmail.com";
        String expectedResult = "talalasmarius@gmail.com";
        String actualResult;

        TextBoxPage.enterEmailAdress(messageEmail);
        TextBoxPage.clickOnButtonSubmit();
        actualResult = TextBoxPage.readEmailMessage();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                String.format("Actual:%s; Expected: %s", actualResult, expectedResult)
        );
    }
}
