package jhtackle.attract.app;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by paul on 14.01.16.
 */

public class UtilityStore {
    public static void login(WebDriver drv, String URL, String email, String password) {
        drv.get(URL);
        drv.findElement(By.name("email")).sendKeys(email);
        drv.findElement(By.name("password")).sendKeys(password);
        drv.findElement(By.id("submit_form_button_login")).click();
    }

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

    public static void waitForWrapper(WebDriver wow, int howLong) {
        WebDriverWait wait = new WebDriverWait(wow, howLong);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("loader_wrapper")));
        System.out.println("/n$$$$$$$$$$$$$$Loader is begun his work!$$$$$$$$$$$$$$$$");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader_wrapper")));
        System.out.println("/n$$$$$$$$$$$$$$Loader has end his work!$$$$$$$$$$$$$$$$");
    }




}

