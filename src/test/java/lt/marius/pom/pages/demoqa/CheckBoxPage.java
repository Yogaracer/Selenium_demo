package lt.marius.pom.pages.demoqa;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.Locators;

import java.util.List;

public class CheckBoxPage {

    public static void open() {
        Common.setUpDriver();
        Common.openUrl("https://demoqa.com/checkbox");
    }

    public static void clickOnButtonExpandAll() {
        Common.clickOnElement(Locators.Demoqa.CheckBox.buttonExpandAll);
    }

    public static void clickOnCheckBox(String name) {
        Common.clickOnElement(Locators.Demoqa.CheckBox.labelTreeNodeHome(name));
    }

    public static boolean checkStatusOfAllCheckBoxes(boolean isChecked, String name) {
        List<Boolean> statusList = Common.getStatusesOfCheckBoxGroup(
                Locators.Demoqa.CheckBox.getGroupOfCheckBoxes(name)
        );

        for (Boolean status : statusList) {
            if (status != isChecked) return !isChecked;
        }
        return isChecked;

    }
}
