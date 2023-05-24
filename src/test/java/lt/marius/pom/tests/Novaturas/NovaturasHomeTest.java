package lt.marius.pom.tests.Novaturas;

import lt.marius.pom.pages.Novaturas.NovaturasHomePage;
import lt.marius.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class NovaturasHomeTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        NovaturasHomePage.open();
    }

    @Test
    public void testSelectDateFromDatePicker() {
        LocalDate startDate = LocalDate.now().plusDays(9);
        boolean isAvailable = true;
        boolean expectedResult = true;
        boolean actualResult;


        NovaturasHomePage.clickOnCalendarInput();
        NovaturasHomePage.clickOnDayOfMonth(startDate);
        NovaturasHomePage.clickOnButtonSearch();
        actualResult = NovaturasHomePage.checkStartingDateOfSearchResult(isAvailable, startDate);

        Assert.assertEquals(actualResult, expectedResult);





    }
}
