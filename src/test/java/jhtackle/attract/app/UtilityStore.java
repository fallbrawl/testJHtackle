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

    public static void login(WebDriver drv, String role) {

        if (role == "manager_buyer") {
            drv.get("http://invoicedev.php.attractgroup.com/public/login");
            drv.findElement(By.name("email")).sendKeys("pavel.a.manager.buyer@attractgroup.com");
            drv.findElement(By.name("password")).sendKeys("attract");
            drv.findElement(By.id("submit_form_button_login")).click();
        } else if (role == "manager_seller") {
            drv.get("http://invoicedev.php.attractgroup.com/public/login");
            drv.findElement(By.name("email")).sendKeys("pavel.a.manager_sales@attractgroup.com");
            drv.findElement(By.name("password")).sendKeys("attract");
            drv.findElement(By.id("submit_form_button_login")).click();
        } else if (role == "accounter") {
            drv.get("http://invoicedev.php.attractgroup.com/public/login");
            drv.findElement(By.name("email")).sendKeys("pavel.a.accounter@attractgroup.com");
            drv.findElement(By.name("password")).sendKeys("attract");
            drv.findElement(By.id("submit_form_button_login")).click();
        } else if (role == "admin") {
            drv.get("http://invoicedev.php.attractgroup.com/public/login");
            drv.findElement(By.name("email")).sendKeys("pavel.a@attractgroup.com");
            drv.findElement(By.name("password")).sendKeys("zombie");
            drv.findElement(By.id("submit_form_button_login")).click();
        } else {
            throw new IllegalArgumentException("No such role of user!");
        }

    }

    public static void logout(WebDriver drv) {
        drv.findElement(By.className("account-dropdown")).click();
        waitForElementsPresence(drv, 2, "dropdown-menu-right", 'c');
        drv.findElement(By.linkText("Выйти")).click();
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

    public static void waitForElementsPresence(WebDriver drv, int howLong, String elementToWaitFor, char typeOfIdentifier) {

        WebDriverWait wait = new WebDriverWait(drv, howLong);

        switch (typeOfIdentifier) {
            case 'i':
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id(elementToWaitFor)));
                break;
            case 'c':
                wait.until(ExpectedConditions.presenceOfElementLocated(By.className(elementToWaitFor)));
                break;
            default:
                throw new IllegalArgumentException("Invalid identifier: " + typeOfIdentifier);
        }

        System.out.println("\n$$$$$$$$$$$$$$ " + elementToWaitFor + " on the page " + drv.getCurrentUrl() + " is present!$$$$$$$$$$$$$$$$");

    }

}

