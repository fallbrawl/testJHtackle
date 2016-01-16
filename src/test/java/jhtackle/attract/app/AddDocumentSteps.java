package jhtackle.attract.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by paul on 16.01.16.
 */
public class AddDocumentSteps {
    public static void documentFirstStep(WebDriver drv, String URL) {
        drv.get(URL);
        drv.findElement(By.id("s-name_user_info")).sendKeys("lllooool");
        drv.findElement(By.id("b-name_user_info")).sendKeys("lllooool");
        drv.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        drv.findElement(By.className("btn-primary")).click();

    }
}
