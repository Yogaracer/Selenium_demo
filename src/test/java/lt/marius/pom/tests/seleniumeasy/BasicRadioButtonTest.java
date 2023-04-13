package lt.marius.pom.tests.seleniumeasy;

import lt.marius.pom.pages.seleniumeasy.BasicRadioButtonPage;
import lt.marius.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BasicRadioButtonTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        BasicRadioButtonPage.open();
    }


    @Test(dataProvider = "radioButtonGender")
    public void testRadioButton(String inputGender, String expectedResult) {
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

    @DataProvider(name = "radioButtonsSexAndAgeGroup")
    public Object[][] dataProviderGroupRadioButtons() {
        return new Object[][]{
                {"Male", "Male", "0 - 5", "0 - 5"},
                {"Male", "Male", "5 - 15", "5 - 15"},
                {"Male", "Male", "15 - 50", "15 - 50"},
                {"Female", "Female",, "0 - 5", "0 - 5"},
                {"Female", "Female",, "5 - 15", "5 - 15"},
                {"Female", "Female",, "15 - 50", "15 - 50"},
        };
    }


    @Test (dataProvider = "radioButtonsSexAndAgeGroup")
    public void testGroupRadioButtonsDemo(String inputSex, String expectedSexResult,
                                          String inputAgeGroup, String expectedAgeGroupResult);
    String actualResult;

        BasicRadioButtonPage.clickOnRadioButton1(inputSex);
        BasicRadioButtonPage.clickOnRadioButton2(inputAgeGroup);
        BasicRadioButtonPage.clickOnButtonGetValues();
    actualResult =BasicRadioButtonPage.readMessageRadioButtonGetValuesChecked();

        Assert.assertTrue(
                actualResult.contains(expectedSexResult),
            String.format(
            "Actual:%s, Expected: %s",
    actualResult,
    expectedSexResult
                )
                        );
        Assert.assertTrue(
                actualResult.contains(expectedAgeGroupResult),
            String.format(
            "Actual:%s, Expected: %s",
    actualResult,
    expectedAgeGroupResult
                )
                        );
}
}
