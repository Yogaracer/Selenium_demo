package lt.marius.pom.tests.demoqa;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.demoqa.ModalDialogsPage;
import lt.marius.pom.tests.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


//https://demoqa.com/modal-dialogs

public class ModalDialogsTest extends TestBase {
    @BeforeMethod
    @Override

    public void setUp() {
        ModalDialogsPage.open();
    }

    @Test
    public void testButtonSmallAndLargeModal() {
        ModalDialogsPage.clickOnButtonSmallModal();
        Common.sleep(1000);
        ModalDialogsPage.closeSmallModal();
        Common.sleep(1000);
        ModalDialogsPage.clickOnButtonLargeModal();
        Common.sleep(1000);
        ModalDialogsPage.closeLargeModal();
        Common.sleep(1000);
    }
}
