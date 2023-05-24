package lt.marius.pom.tests.demoqa;

import lt.marius.pom.pages.demoqa.DatePickerPage;
import lt.marius.pom.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DatePickerTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        DatePickerPage.open();
    }

    @Test
    public void testDatePickerAsText() {
        String date = "05/19/2023";

        DatePickerPage.enterDate(date);
    }

    @Test
    public void testDatePickerWithJavascriptExecutor() {
        String date = "05/19/2023";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");
        String date1 = LocalDateTime.now().format(formatter);
        String date2 = LocalDateTime.now().plusDays(1).format(formatter);
        String attributeName = "value";

        DatePickerPage.enterDateWithJavascriptExecutor(attributeName, date);
    }

}
