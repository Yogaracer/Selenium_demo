package lt.marius.pom.pages.Novaturas;

import org.openqa.selenium.By;

public class Locators {

    public class Novaturas {
        public static class NovaturasHome {
            public static By calendarStartingDay =
                    By.xpath("//h1[contains(text(),'Kelionių paieška')]/../div[1]/div[3]");
            public static By divButtonSearch =
                    By.xpath("//div[@class='trip-search-form']//a[contains(@class,'btn')]");

            public static By getStartingDayCurrentMonth(String tripStartDay) {

                return By.xpath(
                        ("(//div[@class='date-slider']//div[contains(@class,'swiper-wrapper')]//header)[1]/.." +
                                "//span[text()='%s']").formatted(tripStartDay));
            }

            public static By getStartingDayNextMonth(String tripStartDay) {
                return By.xpath(
                        ("(//div[@class='date-slider']//div[contains(@class,'swiper-wrapper')]//header)[4]/.." +
                                "//span[text()='%s']").formatted(tripStartDay));
            }
        }

        public static class NovaturasPaieska {

            public static By paragraphTripPeriod =
                    By.xpath(" //div[contains(@class,'search-result-offer-list')]//"
                            + "div[contains(@class,'departures-block')]//p[2]");
        }
    }
}
