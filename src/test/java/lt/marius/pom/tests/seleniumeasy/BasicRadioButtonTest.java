package lt.marius.pom.tests.seleniumeasy;

import lt.marius.pom.pages.seleniumeasy.BasicRadioButtonPage;
import lt.marius.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicRadioButtonTest extends TestBase {

    @BeforeMethod
    @Override
    public void setUp() {
        BasicRadioButtonPage.open();
    }

    @Test
    public void testRadioButtonMale() {
        String inputGender = "Male";
        String expectedResult = "Male";
        String actualResult;

        BasicRadioButtonPage.clickOnRadioButton(inputGender);
        BasicRadioButtonPage.clickOnButtonCheck();
        actualResult = BasicRadioButtonPage.readMessageRadioButtonChecked();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                String.format(
                        "Actual:%s, Expected: %s",
                        actualResult,
                        expectedResult
                )
        );

    }

    @Test
    public void testRadioButtonFemale() {
        String inputGender = "Female";
        String expectedResult = "Female";
        String actualResult;

        BasicRadioButtonPage.clickOnRadioButton(inputGender);
        BasicRadioButtonPage.clickOnButtonCheck();
        actualResult = BasicRadioButtonPage.readMessageRadioButtonChecked();

        Assert.assertTrue(
                actualResult.contains(expectedResult),
                String.format(
                        "Actual:%s, Expected: %s",
                        actualResult,
                        expectedResult
                )
        );
    }
}
