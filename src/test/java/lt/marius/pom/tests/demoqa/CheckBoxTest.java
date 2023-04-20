package lt.marius.pom.tests.demoqa;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.demoqa.CheckBoxPage;
import lt.marius.pom.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckBoxTest extends TestBase {

    @BeforeMethod
    @Override
    public void setUp() {
        CheckBoxPage.open();
    }


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

        Common.sleep(5000);

    }

    @DataProvider(name = "dataProviderForCheckBox")
    public Object[][] providerDataForTestCheckBox() {
        return new Object[][]{
                {"home"},
                {"desktop"},
                {"documents"},
                {"downloads"}
        };
    }


    @Test(dataProvider = "dataProviderForCheckBox")
    public void testCheckBox(String checkBoxName) {
        boolean isChecked = true;
        boolean expectedStatus = true;
        boolean actualStatus;

        CheckBoxPage.clickOnButtonExpandAll();
        CheckBoxPage.clickOnCheckBox(checkBoxName);

        Common.sleep(5000);
    }
}
