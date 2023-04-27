package lt.marius.pom.tests.seleniumeasy;

import lt.marius.pom.pages.seleniumeasy.BasicSelectDropdownListPage;
import lt.marius.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

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
                {"Tuesday", "aaaaaaaaaaa"},
                {"Wednesday", "Wednesday"},
                {"Thursday", "Thursday"},
                {"Friday", "Friday"},
                {"Friday", "rrrrrrrrr"},
                {"Saturday", "Saturday"}
        };
    }

    @Test(dataProvider = "dayFromDropdownList", threadPoolSize = 2)
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
                {"California", "vvvv"},
                {"Florida", "Florida"},
                {"New Jersey", "qwweqeweq"},
                {"New York", "New York"},
                {"Ohio", "Ohio"},
                {"Texas", "Texas"},
                {"Pennsylvania", "Pennsylvania"},
                {"Washington", "Washington"}
        };
    }

    @Test(dataProvider = "cityFromDropdownList", threadPoolSize = 2)
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

    @Test
    public void testSelectedCityGroupFromList() {
        List<String> selectValues = Arrays.asList("California", "New Jersey", "Ohio", "Pennsylvania");
        boolean selectedStatus = true;
        boolean expectedResult = true;
        boolean actualResult;
        BasicSelectDropdownListPage.selectCitiesFromList(selectValues);
        actualResult = BasicSelectDropdownListPage.checkSelectedStatusesOfCityList(selectValues, selectedStatus);
        Assert.assertEquals(actualResult, expectedResult);
    }

}
