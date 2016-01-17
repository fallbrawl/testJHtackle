package jhtackle.attract.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by paul on 16.01.16.
 */
public class AddDocumentSteps {
    public static void documentFirstStep(WebDriver drv) {

        drv.get("http://invoicedev.php.attractgroup.com/public/document/add");
        drv.findElement(By.id("s-name_user_info")).sendKeys("lllooool");
        drv.findElement(By.id("b-name_user_info")).sendKeys("lllooool");
        drv.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        drv.findElement(By.className("btn-primary")).click();

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

        //drv.findElement(By.className("icon_in_big")).click();

        waitForWrapper(drv, 2);


        List<WebElement> neededBut = drv.findElements(By.className("btn-primary"));
        System.out.println("Size of List: " + neededBut.size());
        for (WebElement aNeeded_but : neededBut) {

            System.out.println("Classes in List: " + aNeeded_but.getText());
        }

        WebElement wow = neededBut.get(2);
        wow.click();

        //Addin' item

        waitForWrapper(drv, 2);
        drv.findElement(By.id("autocomplete_document_product")).sendKeys("n", Keys.ARROW_DOWN, Keys.ENTER);
        if ((drv.findElement(By.className("autocomplete-suggestion")).isDisplayed())) {
            drv.findElement(By.id("autocomplete_document_product")).sendKeys(Keys.ARROW_DOWN);
        }


        drv.findElement(By.id("autocomplete_document_product")).sendKeys(Keys.ENTER);
        drv.findElement(By.className("glyphicon-plus")).click();


    }
}
}
