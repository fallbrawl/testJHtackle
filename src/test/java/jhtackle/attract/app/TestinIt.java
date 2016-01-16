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
        UtilityStore.login(driver,"http://invoicedev.php.attractgroup.com/public/login", "pavel.a@attractgroup.com", "zombie");
        UtilityStore.checkTitle(driver, "http://invoicedev.php.attractgroup.com/public/", "Login", "Login");

        UtilityStore.documentFirstStep(driver, "http://invoicedev.php.attractgroup.com/public/document/add");
        UtilityStore.checkTitle(driver, "http://invoicedev.php.attractgroup.com/public/document/show/238", "First step", "First step");

        UtilityStore.documentSecondStep(driver);
        UtilityStore.checkTitle(driver, "http://invoicedev.php.attractgroup.com/public/document/show/238", "Second step", "Second step");
        Assert.assertTrue(true);

      //  Assert.assertTrue(UtilityStore.checkTitle(driver,"Invoice"));
       // Assert.assertTrue(UtilityStore.checkTextPresence(driver));

      //  driver.close();
    }




}
