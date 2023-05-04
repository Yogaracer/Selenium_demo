package lt.marius.pom.tests.demoqa;

import lt.marius.pom.pages.demoqa.DynamicPropertiesPage;
import lt.marius.pom.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DynamicPropertiesTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {

        DynamicPropertiesPage.open();
    }

    @Test
    public void testButtonEnableAfter() {
        DynamicPropertiesPage.clickOnButtonEnableAfter(); //enableAfter mygtuko pavadinimas Inspection skilty
    }

    @Test
    public void testButtonColorChange() {
        String attributeName = "class";
        String attributeValue = "text-danger";
        DynamicPropertiesPage.clickOnButtonColorChange(attributeName, attributeValue);
    }

    @Test
    public void testButtonVisibleAfter() {
        DynamicPropertiesPage.clickOnButtonVisibleAfter();

    }
}
