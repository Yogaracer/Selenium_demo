package lt.marius.pom.pages;

import org.openqa.selenium.By;

public class Locators {

    public static class Demoqa {

        public class TextBox {

            public static By inputUserName = By.xpath("//input[@id='userName']");
            public static By buttonSubmit = By.xpath("//button[@id='submit']");
            public static By paragraphName = By.xpath("//p[@id='name']"); // p - reiskia paragraph
            public static By inputUserEmail = By.xpath("//input[@id='userEmail']");
            public static By paragraphEmail = By.xpath("//p[@id='email']"); // p - reiskia paragraph
        }
    }

    public class SeleniumEasy {


        public class BasicFirstForm {


            public static By inputUserMessage = By.xpath("//input[@id='user-message']");
            public static By buttonShowMessage = By.xpath("//button[contains(@onclick,'show')]");
            public static By spanDisplay = By.xpath("//*[@id='display']");
            public static By inputValueA = By.xpath("//input[@id='value1']");
            public static By inputValueB = By.xpath("//input[@id='value2']");
            public static By buttonGetTotal = By.xpath("//form[@id='gettotal']//button");
            public static By spanDisplayValue = By.xpath("//span[@id='displayvalue']");
        }

        public static class BasicCheckBox {
            public static By inputSingleCheckBox = By.xpath("//input[@id='isAgeSelected']");
            public static By divDislpaySingleCheckBoxMessage = By.xpath("//div[@id='txtAge']");
            public static By inputSelectedCheckedBox = By.xpath("//label[@class='checkbox-inline'][2]/input");
            public static By statusofCheckedBox = By.xpath("//label[@class='checkbox-inline'][3]/input");
        }


        public static class BasicSelectDropdownList {
            public static By selectDayOfWeek = By.xpath("//select[@id='select-demo']");
            public static By paragraphSelectedValue = By.xpath("//p[@class='selected-value']");
            public static By selectCity = By.xpath("//select[@id='multi-select']");
            public static By paragraphGetAllSelected = By.xpath("//p[@class='getall-selected']");
            public static By buttonGetAllSelected = By.xpath("//button[@id='printAll']");

        }

        public static class BasicRadioButton {
            public static By buttonCheck = By.xpath("//button[@id='buttoncheck']");
            public static By paragraphRadioButtonChecked =
                    By.xpath("//p[contains(text(),'Radio button')]");
            public static By buttonGetValues =
                    By.xpath("//button[@class='btn btn-default' and @onclick='getValues();']");
            public static By paragraphRadioButtonGetValuesChecked =
                    By.xpath("//p[@class='groupradiobutton']");

            public static By inputRadioByGender(String inputGender) {
                return By.xpath("//input[@name='optradio' and @value='" + inputGender + "']");
                //kitas sprendimas:
                // By.xpath(String.format("//input[@name='optradio' and @value='%s']", inputGender));
            }

            public static By inputRadioByAge(String inputAgeGroup) {
                return By.xpath("//input[@name='ageGroup' and @value='" + inputAgeGroup + "']");
            }

            public static By inputRadioBySex(String inputSex) {
                return By.xpath("//input[@name='gender' and @value='" + inputSex + "']");
            }
        }
    }

}
