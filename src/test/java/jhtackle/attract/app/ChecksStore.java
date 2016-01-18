package jhtackle.attract.app;

import org.openqa.selenium.WebDriver;

/**
 * Created by NEXUS on 18.01.2016.
 */
public class ChecksStore {
    public static boolean checkTitle(WebDriver drv, String URLtitle, String whatWasTested, String errorMsg) {
        if (drv.getTitle().equals(URLtitle)) {
            System.out.println(whatWasTested + " is ok!");
            return true;
        } else {
            System.out.println(errorMsg + " is failed!");
            return false;
        }
    }

    public static boolean checkTextPresence(WebDriver drv,String textPresence) {
        if (drv.getPageSource().contains(textPresence)) {
            System.out.println("Text is present!");
            return true;
        } else {
            System.out.println("Text is absent!");
            return false;
        }
    }
}
