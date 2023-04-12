package lt.marius.pom.tests.seleniumeasy;

import lt.marius.pom.pages.seleniumeasy.BasicFirstFormPage;
import lt.marius.pom.pages.seleniumeasy.BasicSelectDropdownListPage;
import lt.marius.pom.pages.seleniumeasy.SelectCityFromListPage;
import lt.marius.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BasicSelectDropdownListTest extends TestBase {

    @BeforeMethod
    @Override
    public void setUp()
    {
        BasicSelectDropdownListPage.open();
    }

    @Test
    public void testSelectListDemo(){
        String selectValue = "Wednesday";
        String expectedResult = "Wednesday";
        String actualResult;

        BasicSelectDropdownListPage.selectDayFromDropdownList(selectValue);

        actualResult = BasicSelectDropdownListPage.readMessageOfSelectedValue();

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
