package lt.marius.pom.pages.demoqa;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.Locators;

public class DatePickerPage {

    public static void open() {
        Common.setUpDriver();
        Common.openUrl("https://demoqa.com/date-picker");
    }


    public static void enterDate(String date) {
        Common.executeCtrlADeleteSendKeysWithActions(Locators.Demoqa.DatePicker.inputDatePicker, date);
    }

    public static void enterDateWithJavascriptExecutor(String attributeName, String date) {
        Common.setAttributeValueWithJavascriptExecutor(
                Locators.Demoqa.DatePicker.inputDatePicker,
                attributeName,
                date
        );
    }
}
