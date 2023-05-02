package lt.marius.pom.utils;

import lt.marius.pom.pages.Common;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        if (!Common.brokenImages.isEmpty() && !Common.validLinks.isEmpty()) {
            takeScreenshot();
        }
        saveDataIntoFile();
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        saveDataIntoFile();
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


    private void saveDataIntoFile() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HH_mm_SSS");
        String date = LocalDateTime.now().format(formatter);


        String fileBrokenLinks = "fileBrokenLinks" + date + ".txt"; // susikuriame direktorijos pavadinima, kuriame bus saugomi broken links
        String fileValidLinks = "fileValidLinks" + date + ".txt"; // norint sukurti kitoki formata naudoti kita pletini pvz. xls, doc, pdf ir pan.
        String fileBrokenImages = "fileBrokenImages" + date + ".txt";
        String dir = "C:\\Users\\User\\Documents\\PI testavimas\\Vilniuscoding School\\MySQL\\Selenium_demo\\link_reports\\"; //vieta kurioje bus issaugomi failai. Prideti papildomai \\ gale kad issaugotu direktorijoje link_reports

        Path pathFileBrokenLinks = Paths.get(dir.concat(fileBrokenLinks)); //sujungiame direktorijos ir filo kuriame bus issaugotas linkas pavadinimai
        Path pathFileValidLinks = Paths.get(dir.concat(fileValidLinks));
        Path pathFileBrokenImages = Paths.get(dir.concat(fileBrokenImages));

        try {

            if (!Common.brokenLinks.isEmpty()) {
                Files.write(pathFileBrokenLinks, Common.brokenLinks);
            }
            if (!Common.validLinks.isEmpty()) {
                Files.write(pathFileValidLinks, Common.validLinks);
            }
            if (!Common.brokenImages.isEmpty()) {
                Files.write(pathFileBrokenImages, Common.brokenImages);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}