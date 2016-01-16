package jhtackle.attract.app;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestinIt {
    @Test
    public void loginAndAddDocument()

    {
        WebDriver driver = new FirefoxDriver();
        UtilityStore.login(driver, "http://invoicedev.php.attractgroup.com/public/login", "pavel.a@attractgroup.com", "zombie");
        Assert.assertTrue("Login is failed!", UtilityStore.checkTextPresence(driver, "Заказы на продажу"));

        AddDocumentSteps.documentFirstStep(driver);


        UtilityStore.documentSecondStep(driver);

        Assert.assertTrue(true);

        //  Assert.assertTrue(UtilityStore.checkTitle(driver,"Invoice"));
        // Assert.assertTrue(UtilityStore.checkTextPresence(driver));

        //  driver.close();
    }


}
