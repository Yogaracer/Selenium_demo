package lt.marius.pom.pages.seleniumeasy;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.Locators;

import java.util.List;

public class BasicSelectDropdownListPage {

    public static void open() {
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

    public static void selectCityFromDropdownList(String selectValue) {
        Common.selectOptionByValue(
                Locators.SeleniumEasy.BasicSelectDropdownList.selectCity,
                selectValue);
    }

    public static String readNameOfSelectedValue() {
        return Common.getTextFromElement(Locators.SeleniumEasy.BasicSelectDropdownList.paragraphGetAllSelected);
    }

    public static void clickButtonGetAllSelected() {
        Common.clickOnElement(Locators.SeleniumEasy.BasicSelectDropdownList.buttonGetAllSelected);
    }

    public static void selectCitiesFromList(List<String> selectValues) {
        Common.selectOptionGroupByValue(
                Locators.SeleniumEasy.BasicSelectDropdownList.selectCity,
                selectValues);
    }

    public static boolean checkSelectedStatusesOfCityList(List<String> selectValues, boolean isSelected) {
        List<Boolean> selectedStatusList = Common.getStatusesOfSelectedOptionsGroup(
                Locators.SeleniumEasy.BasicSelectDropdownList.selectCity,
                selectValues
        );
        for (Boolean status : selectedStatusList) {
            if (status != isSelected) return !isSelected;
        }
        return isSelected;

    }

    public static void selectCitiesFromListWithActions(List<String> selectValues) {
        Common.selectOptionGroupByValueWithActions(
                Locators.SeleniumEasy.BasicSelectDropdownList.selectCity,
                selectValues);
    }

    public static boolean checkNamesOfSelectedCities(List<String> selectValues, boolean isSelected) {
        String textResult = Common.getTextFromElement(
                Locators.SeleniumEasy.BasicSelectDropdownList.paragraphGetAllSelected
        );
        for (String value : selectValues) {
            if (!textResult.contains(value)) {
                return !isSelected;
            }
        }

        return isSelected;
    }
}

