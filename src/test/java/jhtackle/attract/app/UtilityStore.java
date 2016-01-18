package jhtackle.attract.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public static String addDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //get current date time with Date()
        Date date = new Date();
        String dateAndTimeAttachment = dateFormat.format(date);
        return dateAndTimeAttachment;
    }


    public static void uploadFile(WebDriver inputDriver, String nameOfFileForm, String pathToFile) {

        //File input for Lubuntu /home/paul/Desktop/2015-12-30-150350_1920x1080_scrot.pdf
        //File input for Windows C:\Users\NEXUS\Pictures\wow.pdf

        inputDriver.findElement(By.name(nameOfFileForm)).sendKeys(pathToFile);
    }


    public static void waitForElementsAbsence(WebDriver drv, int howLong, String classOfelementToWaitFor) {
        WebDriverWait wait = new WebDriverWait(drv, howLong);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className(classOfelementToWaitFor)));
        System.out.println("\n$$$$$$$$$$$$$$ " + classOfelementToWaitFor + " on the page " + drv.getCurrentUrl() + " has begun his work!$$$$$$$$$$$$$$$$");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className(classOfelementToWaitFor)));
        System.out.println("\n$$$$$$$$$$$$$$ " + classOfelementToWaitFor + " on the page " + drv.getCurrentUrl() + " has ended his work!$$$$$$$$$$$$$$$$");
    }

    public static void waitForElementsPresence(WebDriver drv, int howLong, String classOfElementToWaitFor) {
        WebDriverWait wait = new WebDriverWait(drv, howLong);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className(classOfElementToWaitFor)));
        System.out.println("\n$$$$$$$$$$$$$$ " + classOfElementToWaitFor + " on the page " + drv.getCurrentUrl() + " is present!$$$$$$$$$$$$$$$$");

    }

}

