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

    public static boolean checkTitle(WebDriver drv, String URLtitle) {
        if (drv.getTitle().equals(URLtitle)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean checkTextPresence(WebDriver drv) {
        if (drv.getPageSource().contains("Шаг 2")) {
            System.out.println("Text is present!");
            return true;
        } else {
            System.out.println("Text is absent!");
            return false;
        }
    }

    public static void documentFirstStep(WebDriver drv, String URL, String value1, String value2) {
        drv.get(URL);
        drv.findElement(By.id("s-name_user_info")).sendKeys(value1);
        drv.findElement(By.id("b-name_user_info")).sendKeys(value2);
        drv.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        drv.findElement(By.className("btn-primary")).click();

    }

    public static void waitForWrapper(WebDriver wow, int howLong) {
        WebDriverWait wait = new WebDriverWait(wow, howLong);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("loader_wrapper")));
        System.out.println("$$$$$$$$$$$$$$Loader is begun his work!$$$$$$$$$$$$$$$$");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loader_wrapper")));
        System.out.println("$$$$$$$$$$$$$$Loader has end his work!$$$$$$$$$$$$$$$$");
    }

    public static void documentSecondStep(WebDriver drv) {

        drv.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        drv.findElement(By.name("file")).sendKeys("/home/paul/Desktop/2015-12-30-150350_1920x1080_scrot.pdf");
        drv.findElement(By.className("icon_save_big")).click();

        waitForWrapper(drv, 2);

        WebElement smth = drv.findElement(By.className("fa-envelope"));
        String smth1 = smth.getAttribute("Class");

        System.out.println("$$$$$$$$$$$$$$Element is visible!$$$$$$$$$$$$$$$$ And the class is:" + smth1);
        smth.click();

        //Confirmin' document in manager's section

        drv.get("invoicedev.php.attractgroup.com/public/accounting/manager");
        drv.findElement(By.className("icon_check")).click();
        drv.findElement(By.className("btn-success")).click();

        //Gettin' back to document's attaching

        drv.navigate().back();

        waitForWrapper(drv, 2);

        drv.findElement(By.className("icon_in_big")).click();

        waitForWrapper(drv, 2);


        List<WebElement> needed_but = drv.findElements(By.className("btn-primary"));
        System.out.println("Size of List: " + needed_but.size());
        for (int i = 0; i < needed_but.size(); i++) {

            System.out.println("Classes in List: " + needed_but.get(i).getText());
        }

        WebElement wow = needed_but.get(2);
        wow.click();

        //Addin' item

        waitForWrapper(drv, 2);
        drv.findElement(By.id("autocomplete_document_product")).sendKeys("n", Keys.ARROW_DOWN, Keys.ENTER);
        // WebDriverWait wait = new WebDriverWait(wow, howLong);
        if ((drv.findElement(By.className("autocomplete-suggestion")).isDisplayed())) {
            drv.findElement(By.id("autocomplete_document_product")).sendKeys(Keys.ARROW_DOWN);
        }


        drv.findElement(By.id("autocomplete_document_product")).sendKeys(Keys.ENTER);
        drv.findElement(By.className("glyphicon-plus")).click();


    }


}

