package jhtackle.attract.app;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.ArrayList;


public class TestinIt {

    @Test

    public void AddDocument() throws InterruptedException

    {
        WebDriver driver = new FirefoxDriver();

        UtilityStore.login(driver, "http://invoicedev.php.attractgroup.com/public/login", "pavel.a@attractgroup.com", "zombie");

        AddDocumentSteps.documentFirstStep(driver);
        AddDocumentSteps.documentSecondStep(driver);
        AddDocumentSteps.documentThirdStep(driver);

        Assert.assertTrue(true);

    }


}
