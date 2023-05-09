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

        public static class CheckBox {

            public static By buttonExpandAll = By.xpath("//button[@title='Expand all']");
            public static By inputHomeCheckBox = By.xpath("//div[@id='tree-node']// input[@type='checkbox']"); // div - reiskia direktorija/konteineri/ li - reiskia list


            public static By labelTreeNodeHome(String name) {
                return By.xpath(
                        "//label[@for='tree-node-%s']".formatted(name)
                );
                // Galimas variantas: public static By labelTreeNodeHome = By.xpath("//label[@for='tree-node-home']");}
            }

            public static By getGroupOfCheckBoxes(String name) {
                return By.xpath("//label[@for='tree-node-%s']/../..//input".formatted(name)); //%s - ides reiksme nurodyta String name
            }
        }

        public static class BrokenLink {
            public static By linkValid = By.xpath("//div[@class='col-12 mt-4 col-md-6']//a[contains(text(),'Valid')]"); // ieskom konteinerio ir atributo
            public static By linkBroken = By.xpath("//div[@class='col-12 mt-4 col-md-6']//a[contains(text(),'Broken')]");
            public static By linkGroup = By.xpath("//div[@class='col-12 mt-4 col-md-6']//a");
            public static By imageValid = By.xpath("//div[@class='col-12 mt-4 col-md-6']//img[1]");
            public static By imageBroken = By.xpath("//div[@class='col-12 mt-4 col-md-6']//img[2]");
            public static By imageGroup = By.xpath("//div[@class='col-12 mt-4 col-md-6']//img");
        }

        public static class DynamicProperties {
            public static By buttonEnableAfter = By.xpath("//button[@id='enableAfter']");
            public static By buttonColorChange = By.xpath("//button[@id='colorChange']");
            public static By buttonVisibleAfter = By.xpath("//button[@id='visibleAfter']");
        }

        public class ModalDialogs {

            public static By buttonShowSmallModal = By.xpath("//button[@id='showSmallModal']");
            public static By buttonCloseSmallModal = By.xpath("//button[@id='closeSmallModal']");
            public static By buttonShowLargeModal = By.xpath("//button[@id='showLargeModal']");
            public static By buttonCloseLargeModal = By.xpath("//button[@id='closeLargeModal']");
        }

        public static class BrowserWindows {

            public static By buttonNewTab = By.xpath("//button[@id='tabButton']");
            public static By buttonNewWindow = By.xpath("//button[@id='windowButton']");
            public static By headerSampleHeading = By.xpath("//h1[@id='sampleHeading']");
        }

        public class Alerts {

            public static By buttonAlert = By.xpath("//button[@id='alertButton']");
            public static By timerAlertButton = By.xpath("//button[@id='timerAlertButton']");
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
            public static By buttonCheckBoxGroup = By.xpath("//input[@id='check1']");

            public static By inputMultipleCheckBox = By.xpath("//input[@class='cb1-element']");
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

        public class BootstrapAlertMessage {

            public static By buttonAutocloseableSuccess = By.xpath(
                    "//button[@id='autoclosable-btn-success']");
            public static By divAlertAutocloseableSuccess = By.xpath(
                    "//div[contains(text(),'an autocloseable success')]");
        }

        public class WindowPopupModal {

            public static By buttonFollowOnTwitter = By.xpath("//a[contains(text(),'Follow On Twitter')]");
            public static By buttonNoThanks = By.xpath("//span[contains(text(),'No, thanks')]");
            public static By buttonCloseLogin = By.xpath("//div[@data-testid='app-bar-close']");
            public static By buttonCloseNotification = By.xpath("//div[@data-testid='app-bar-close']");
            public static By headerSeleniumEasy = By.xpath(
                    "(//h2[@role='heading']// span[contains(text(), 'Selenium Easy')])");
        }

        public class JavascriptAlertBox {

            public static By buttonToDisplayAlertBox = By.xpath("//button[@onclick='myAlertFunction()']");
            public static By buttonToConfirmAlertBox = By.xpath("//button[@onclick='myConfirmFunction()']");
            public static By paragraphAlertConfirmBox = By.xpath("//p[@id='confirm-demo']");
            public static By buttonForPromptBox = By.xpath("//button[@onclick='myPromptFunction()']");
            public static By paragraphAlertPromptBox = By.xpath("//p[@id='prompt-demo']");
        }
    }


    public class Mohito {

        public class Salikai {
            public static By linkGroup = By.xpath("//section[@id='categoryProducts']//a");
        }
    }

    public class TV3 {
        public class TV3home {
            public static By buttonCookiesSutinku = By.xpath("//div[@id='qc-cmp2-ui']//button[@mode='primary']");
        }
    }
}




