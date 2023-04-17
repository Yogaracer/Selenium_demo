package lt.marius.pom.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot();
    }

    private void takeScreenshot() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
        File screenshotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String dir = "./screenshots/";
//        String fileName = "new_screenshot" + UUID.randomUUID() + ".png";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HH_mm_SSS");
        String date = LocalDateTime.now().format(formatter);


        String fileName = "new_screenshot" + date + ".png";
        File copyToFile = new File("%s%s".formatted(dir, fileName)); // ./screenshots/new_screenshot.png //cia bus sausomi printscreenai

        try {
            FileUtils.copyFile(screenshotFile, copyToFile);
        } catch (IOException e) {
           e.printStackTrace();
        }


    }
}
