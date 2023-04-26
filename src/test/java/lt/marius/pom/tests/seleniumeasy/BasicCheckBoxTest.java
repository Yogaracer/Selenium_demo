package lt.marius.pom.tests.seleniumeasy;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.seleniumeasy.BasicCheckBoxPage;
import lt.marius.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
    //http://demo.seleniumeasy.com/basic-checkbox-demo.html

    @DataProvider(name = "dataProviderForMultipleCheckBoxCheck")
    public Object[][] dataProviderCheckAllCheckBox() {
        return new Object[][]{
                {false, false},
                {true, true},
        };
    }

    @Test(dataProvider = "dataProviderForMultipleCheckBoxCheck")
    public void testMultipleCheckBox(boolean isChecked, boolean expectedStatus) {

        boolean actualStatus;

        BasicCheckBoxPage.clickOnButtonCheckAll();

        if (!isChecked) {
            BasicCheckBoxPage.clickOnButtonCheckAll();
        }
        actualStatus = BasicCheckBoxPage.checkStatusOfAllCheckBoxes(isChecked);

        Assert.assertEquals(actualStatus, expectedStatus);
    }

    //http://demo.seleniumeasy.com/basic-checkbox-demo.html

    @DataProvider(name = "dataProviderForTestButtonAttributeValueChange")
    public Object[][] dataProviderForTestButtonAttributeValueChange() {
        return new Object[][]{
                {"value", "Uncheck All"},
                {"value", "Check All"},
        };
    }


    @Test(dataProvider = "dataProviderForTestButtonAttributeValueChange")
    public void testButtonAttributeValueChange(String attributeName, String expectedAttributeValue) {
        String actualAttributeValue;

        BasicCheckBoxPage.clickOnButtonCheckAll();

        if (expectedAttributeValue.equals("Check All")) {
            BasicCheckBoxPage.clickOnButtonCheckAll();
        }

        actualAttributeValue = BasicCheckBoxPage.getMultiSelectButtonValue(attributeName);

        Common.sleep(2000);
        Assert.assertEquals(actualAttributeValue, expectedAttributeValue);
        String.format("Actual: %s; Expected: %s", actualAttributeValue, expectedAttributeValue);

        Common.sleep(2000);
    }

}


