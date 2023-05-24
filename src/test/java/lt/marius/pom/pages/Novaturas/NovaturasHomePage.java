package lt.marius.pom.pages.Novaturas;

import lt.marius.pom.pages.Common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class NovaturasHomePage {

    public static void open() {
        Common.setUpDriver();
        Common.openUrl("https://www.novaturas.lt/");
    }

    public static void clickOnCalendarInput() {
        Common.clickOnElement(Locators.Novaturas.NovaturasHome.calendarStartingDay);
    }

    public static void clickOnDayOfMonth(LocalDate startDate) {
        String tripStartDay = String.valueOf(startDate.getDayOfMonth());

        if (LocalDate.now().getMonth() == startDate.getMonth()) {
            Common.waitForElementToBeVisible(
                    Locators.Novaturas.NovaturasHome.getStartingDayCurrentMonth(tripStartDay)
            );
            Common.clickOnElement(Locators.Novaturas.NovaturasHome.getStartingDayCurrentMonth(tripStartDay)
            );
        } else {
            Common.waitForElementToBeVisible(
                    Locators.Novaturas.NovaturasHome.getStartingDayNextMonth(tripStartDay)
            );
            Common.clickOnElement(Locators.Novaturas.NovaturasHome.getStartingDayNextMonth(tripStartDay)
            );
        }
    }

    public static void clickOnButtonSearch() {
        Common.clickOnElement(Locators.Novaturas.NovaturasHome.divButtonSearch);
    }

    public static boolean checkStartingDateOfSearchResult(boolean isAvailable, LocalDate startDate) {

        List<String> searchPeriodResults = Common.getTextFromElements(
                Locators.Novaturas.NovaturasPaieska.paragraphTripPeriod
        );

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate endDateAsLocalDate;

        for (String searchPeriodResult : searchPeriodResults) {

            String endDate = searchPeriodResult.substring(searchPeriodResult.length() - 10).trim();
            endDateAsLocalDate = LocalDate.parse(endDate, formatter);

            if (startDate.isAfter(endDateAsLocalDate)) {
                return !isAvailable;
            }
        }
        return isAvailable;
    }
}

