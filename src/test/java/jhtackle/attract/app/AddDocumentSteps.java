package jhtackle.attract.app;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by paul on 16.01.16.
 */

public class AddDocumentSteps {
    public static String documentName;
    final int timeToWaitForElement = 2;
    static String dateTime = UtilityStore.addDate();

    public static void documentFirstStep(WebDriver drv) {

        UtilityStore.login(drv, "admin");
        drv.get("http://invoicedev.php.attractgroup.com/public/document/add");

        drv.findElement(By.id("s-name_user_info")).sendKeys("addDocumentEntry " + dateTime);
        drv.findElement(By.id("b-name_user_info")).sendKeys("addDocumentEntry " + dateTime);

        drv.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        drv.findElement(By.className("btn-primary")).click();

    }

    public static void documentSecondStep(WebDriver drv) throws InterruptedException {

        drv.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        UtilityStore.waitForElementsAbsence(drv, 2, "loader_wrapper");

        String mydata = drv.findElement(By.cssSelector("li.active")).getText();

        System.out.println("Text is : " + mydata);

        Pattern pattern = Pattern.compile("S[\\d -]*");
        Matcher matcher = pattern.matcher(mydata);

        if (matcher.find()) {
            documentName = matcher.group(0);
            System.out.println("EXTRACTED regex expression " + documentName);
        }



        UtilityStore.uploadFile(drv, "file", "/home/paul/Desktop/2015-12-30-150350_1920x1080_scrot.pdf");

        drv.findElement(By.className("icon_save_big")).click();
        UtilityStore.waitForElementsAbsence(drv, 2, "loader_wrapper");

        drv.findElement(By.className("fa-envelope")).click();
        UtilityStore.waitForElementsAbsence(drv, 2, "loader_wrapper");

        //Confirmin' document in manager's section

        drv.get("invoicedev.php.attractgroup.com/public/accounting/manager");

        drv.findElement(By.className("icon_check")).click();
        drv.findElement(By.className("btn-success")).click();
        UtilityStore.waitForElementsAbsence(drv, 2, "loader_wrapper");

        //Gettin' back to document's attaching

        drv.navigate().back();
        UtilityStore.waitForElementsAbsence(drv, 2, "loader_wrapper");

        drv.findElement(By.className("icon_in_big")).click();
        UtilityStore.waitForElementsAbsence(drv, 2, "loader_wrapper");

        List<WebElement> neededBut = drv.findElements(By.className("btn-primary"));
        System.out.println("Size of List: " + neededBut.size());

        for (WebElement aNeededBut : neededBut) {

            System.out.println("Classes in List: " + aNeededBut.getText());
        }

        WebElement wow = neededBut.get(2);
        wow.click();

    }


    public static void documentThirdStep(WebDriver drv) {

        //Addin' an item

        UtilityStore.waitForElementsAbsence(drv, 2, "loader_wrapper");
        drv.findElement(By.id("autocomplete_document_product")).sendKeys("n");
        UtilityStore.waitForElementsPresence(drv, 2, "autocomplete-suggestion", 'c');
        drv.findElement(By.id("autocomplete_document_product")).sendKeys(Keys.ARROW_DOWN);
        drv.findElement(By.id("autocomplete_document_product")).sendKeys(Keys.ENTER);
        UtilityStore.waitForElementsPresence(drv, 2, "pull-right", 'c');
        drv.findElement(By.className("icon_plus")).click();

        UtilityStore.waitForElementsAbsence(drv, 2, "loader_wrapper");
        drv.findElement(By.cssSelector(".btn.btn-primary.btn-high.normal_document_step.normal_document_step_3")).click();
        UtilityStore.waitForElementsAbsence(drv, 3, "loader_wrapper");

        //
        //Loggin' out and in like on Accounter's role to continue
        //

        UtilityStore.logout(drv);
        UtilityStore.login(drv, "accounter");

        drv.get("http://invoicedev.php.attractgroup.com/public/dynamic_payments");
        drv.findElement(By.linkText(documentName)).click();

    }
}

