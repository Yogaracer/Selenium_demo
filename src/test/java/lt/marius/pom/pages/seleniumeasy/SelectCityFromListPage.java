package lt.marius.pom.pages.seleniumeasy;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.Locators;

public class SelectCityFromListPage {

    public static void open() {
        Common.setUpDriver();
        Common.openUrl("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
    }

    public static void selectCityFromDropdownList(String selectValue) {
        Common.selectOptionByValue(
                Locators.SeleniumEasy.SelectCityFromList.selectCity,
                selectValue
        );
    }

    public static String readNameOfSelectedValue() {
        return Common.getTextFromElement(Locators.SeleniumEasy.SelectCityFromList.paragraphGetAllSelected);
    }

    public static void clickButtonGetAllSelected() {
        Common.clickOnElement(Locators.SeleniumEasy.SelectCityFromList.buttonGetAllSelected);
    }

}
