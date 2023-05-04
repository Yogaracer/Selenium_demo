package lt.marius.pom.tests.demoqa;

import lt.marius.pom.pages.demoqa.BrowserWindowsPage;
import lt.marius.pom.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrowserWindowsTest extends TestBase {
    @BeforeMethod
    @Override
    public void setUp() {
        BrowserWindowsPage.open();
    }


    // https://demoqa.com/browser-windows

    @Test
    public void testSwitchBetweenWindowTabs() {

        String mainWindow;
        String childWindow;

        mainWindow = BrowserWindowsPage.getMainWindowHandle(); //sukuriame metoda main lango pavadinimui suzinoti
        BrowserWindowsPage.clickOnButtonNewTab();
        childWindow = BrowserWindowsPage.getChildWindowHandle(mainWindow);
//        System.out.println(mainWindow + " | " + childWindow); // parodo langu pavadinimus, kurie keiciais po kiekvieno uzkrovimo

        BrowserWindowsPage.switchToWindow(childWindow);
        BrowserWindowsPage.sleep(2000);
        BrowserWindowsPage.switchToWindow(mainWindow);
        BrowserWindowsPage.sleep(2000);
        BrowserWindowsPage.switchToWindow(childWindow);
        BrowserWindowsPage.sleep(2000);
        BrowserWindowsPage.switchToWindow(mainWindow);
        BrowserWindowsPage.sleep(2000);
        BrowserWindowsPage.switchToWindow(childWindow);
        BrowserWindowsPage.sleep(2000);

        BrowserWindowsPage.closeWindow(childWindow);
        BrowserWindowsPage.sleep(2000);
    }

    @Test
    public void testGetTextFromNewWindow() {
        String expectedResult = "This is a sample page";
        String actualResult;

        BrowserWindowsPage.clickOnButtonNewWindow();
        BrowserWindowsPage.switchToNewWindow();
        actualResult = BrowserWindowsPage.readMessageFromHeader();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
