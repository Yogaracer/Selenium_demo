package lt.marius.pom.tests.seleniumeasy;

import lt.marius.pom.pages.seleniumeasy.BasicSelectDropdownListPage;
import lt.marius.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class BasicSelectDropdownListTest extends TestBase {

    @BeforeMethod
    @Override
    public void setUp() {
        BasicSelectDropdownListPage.open();
    }


    @DataProvider(name = "dayFromDropdownList")
    public Object[][] dataProviderSelectDayDropdownList() {
        return new Object[][]{
                {"Sunday", "Sunday"},
                {"Monday", "Monday"},
                {"Tuesday", "Tuesday"},
                {"Wednesday", "Wednesday"},
                {"Thursday", "Thursday"},
                {"Friday", "Friday"},
                {"Saturday", "Saturday"}
        };
    }

    @Test(dataProvider = "dayFromDropdownList")
    public void testSelectListDemo(String selectValue, String expectedResult) {
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

    @DataProvider(name = "cityFromDropdownList")
    public Object[][] dataProviderSelectCityDropdownList() {
        return new Object[][]{
                {"California", "California"},
                {"Florida", "Florida"},
                {"New Jersey", "New Jersey"},
                {"New York", "New York"},
                {"Ohio", "Ohio"},
                {"Texas", "Texas"},
                {"Pennsylvania", "Pennsylvania"},
                {"Washington", "Washington"}
        };
    }

    @Test(dataProvider = "cityFromDropdownList")
    public void testSelectCityListDemo(String selectValue, String expectedResult) {
        String actualResult;

        BasicSelectDropdownListPage.selectCityFromDropdownList(selectValue);
        BasicSelectDropdownListPage.clickButtonGetAllSelected();
        actualResult = BasicSelectDropdownListPage.readNameOfSelectedValue();

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
