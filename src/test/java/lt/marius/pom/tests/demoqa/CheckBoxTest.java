package lt.marius.pom.tests.demoqa;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.demoqa.CheckBoxPage;
import lt.marius.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckBoxTest extends TestBase {

    @BeforeMethod
    @Override
    public void setUp() {
        CheckBoxPage.open();
    }

//https://demoqa.com/checkbox


    @Test
    public void testCheckAllBox() {
        String checkBoxName = "notes";
        boolean isChecked = true;
        boolean expectedStatus = true;
        boolean actualStatus;

        CheckBoxPage.clickOnButtonExpandAll();
        CheckBoxPage.clickOnCheckBox(checkBoxName);

        Common.sleep(500);

    }

    @Test
    public void testCheckBox() {
        String checkBoxName = "desktop";
        boolean isChecked = true;
        boolean expectedStatus = true;
        boolean actualStatus;

        CheckBoxPage.clickOnButtonExpandAll();
        CheckBoxPage.clickOnCheckBox(checkBoxName);

        Common.sleep(2000);

    }

    // https://demoqa.com/checkbox

    @DataProvider(name = "dataProviderForCheckBox")
    public Object[][] providerDataForTestCheckBox() {
        return new Object[][]{
                {"home", true, true},
                {"desktop", true, true},
                {"documents", true, true},
                {"downloads", true, true},
                {"workspace", true, true},
                {"office", true, true},

                {"home", false, false},
                {"desktop", false, false},
                {"documents", false, false},
                {"downloads", false, false},
                {"workspace", false, false},
                {"office", false, false}
        };
    }

    @Test(dataProvider = "dataProviderForCheckBox")
    public void testAllCheckBox(String checkBoxName, boolean isChecked, boolean expectedStatus) {
        boolean actualStatus;

        CheckBoxPage.clickOnButtonExpandAll();
        CheckBoxPage.clickOnCheckBox(checkBoxName);
        if (!isChecked) {
            CheckBoxPage.clickOnCheckBox(checkBoxName);
        }
        actualStatus = CheckBoxPage.checkStatusOfAllCheckBoxes(isChecked, checkBoxName);

        Common.sleep(1000);
        Assert.assertEquals(actualStatus, expectedStatus);

        Common.sleep(1000);
    }

}
