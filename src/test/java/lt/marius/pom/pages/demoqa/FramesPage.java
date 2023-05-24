package lt.marius.pom.pages.demoqa;

import lt.marius.pom.pages.Common;
import lt.marius.pom.pages.Locators;

public class FramesPage {
    public static void open() {
        Common.setUpDriver();
        Common.openUrl("https://demoqa.com/frames");
    }

    public static void switchToFrame() {
        Common.switchToFrame(
                Locators.Demoqa.Frames.iFrameSingle
        );
    }

    public static String getMessageFromFrame() {
        return Common.getTextFromElement(
                Locators.Demoqa.Frames.headerFirstMessage
        );
    }
}
