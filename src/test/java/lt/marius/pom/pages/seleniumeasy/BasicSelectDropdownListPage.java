package lt.marius.pom.pages.seleniumeasy;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.Locators;

public class BasicSelectDropdownListPage {

    public static void open(){
        Common.setUpDriver();
        Common.openUrl("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
    }

    public static void selectDayFromDropdownList(String selectValue) {
        Common.selectOptionByValue(
        Locators.SeleniumEasy.BasicSelectDropdownList.selectDayOfWeek,
                selectValue
        );
    }

    public static String readMessageOfSelectedValue() {
        return Common.getTextFromElement(Locators.SeleniumEasy.BasicSelectDropdownList.paragraphSelectedValue);
    }
}
