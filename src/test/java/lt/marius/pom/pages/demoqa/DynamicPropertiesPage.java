package lt.marius.pom.pages.demoqa;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.Locators;

public class DynamicPropertiesPage {

    public static void open() {
        Common.setUpDriver();
        Common.openUrl("https://demoqa.com/dynamic-properties");
    }

    public static void clickOnButtonEnableAfter() {
//        Common.waitForElementToBeClickable(Locators.Demoqa.DynamicProperties.buttonEnableAfter);
        boolean isEnabled =
                Common.waitForElementToBeClickableCustomised(Locators.Demoqa.DynamicProperties.buttonEnableAfter);
        System.out.println("IsEnabled: " + isEnabled);
        Common.clickOnElement(Locators.Demoqa.DynamicProperties.buttonEnableAfter);
    }

    public static void clickOnButtonColorChange(String attributeName, String attributeValue) {
//        String result = Common.getElementAttributeValue(Locators.Demoqa.DynamicProperties.buttonColorChange,
//                "class");
//        System.out.println(result);
//
//        Common.sleep(7000);
//        result = Common.getElementAttributeValue(Locators.Demoqa.DynamicProperties.buttonColorChange,
//                "class");
//        System.out.println(result);

        Common.waitForElementAttributeContains(
                attributeName,
                attributeValue,
                Locators.Demoqa.DynamicProperties.buttonColorChange
        );


        Common.clickOnElement(Locators.Demoqa.DynamicProperties.buttonColorChange);
    }
}
