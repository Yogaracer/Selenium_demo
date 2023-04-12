package lt.marius.pom.tests.seleniumeasy;

import lt.marius.pom.pages.seleniumeasy.SelectCityFromListPage;
import lt.marius.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectCityFromListTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        SelectCityFromListPage.open();
    }

    @Test
    public void testSelectCityListDemo() {
        String selectValue = "Ohio";
        String expectedResult = "Ohio";
        String actualResult;

        SelectCityFromListPage.selectCityFromDropdownList(selectValue);
        SelectCityFromListPage.clickButtonGetAllSelected();
        actualResult = SelectCityFromListPage.readNameOfSelectedValue();

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
