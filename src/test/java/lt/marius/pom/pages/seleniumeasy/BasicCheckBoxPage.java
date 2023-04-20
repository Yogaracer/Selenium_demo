package lt.marius.pom.pages.seleniumeasy;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.Locators;

import java.util.List;

public class BasicCheckBoxPage {
    private static boolean isChecked;

    public static void open() {
        Common.setUpDriver();
        Common.openUrl("http://demo.seleniumeasy.com/basic-checkbox-demo.html");
    }

    public static void clickOnSingleCheckBox() {
        Common.clickOnElement(Locators.SeleniumEasy.BasicCheckBox.inputSingleCheckBox);
    }

    public static String readSingleCheckBoxMessage() {
        return Common.getTextFromElement(Locators.SeleniumEasy.BasicCheckBox.divDislpaySingleCheckBoxMessage);
    }

    public static Boolean checkStatusOfCheckBox() {
        return  Common.getStatusOfCheckBox(Locators.SeleniumEasy.BasicCheckBox.inputSelectedCheckedBox);
    }

    public static Boolean checkIfCheckBoxIsEnabled() {
        return  Common.getStatusOfCheckBox(Locators.SeleniumEasy.BasicCheckBox.statusofCheckedBox);
    }

    public static void clickOnButtonCheckAll() {
        Common.clickOnElement(Locators.SeleniumEasy.BasicCheckBox.buttonCheckBoxGroup);
    }

    public static boolean checkStatusOfAllCheckBoxes (boolean isChecked) {
        List<Boolean> statusList = Common.getStatusesOfCheckBoxGroup(
                Locators.SeleniumEasy.BasicCheckBox.inputMultipleCheckBox
        );

        for (Boolean status : statusList) {
            if (status != isChecked) return !isChecked;
        }
        return isChecked;
    }
}
