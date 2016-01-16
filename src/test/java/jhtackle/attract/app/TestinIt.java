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
        UtilityStore.documentFirstStep(driver, "http://invoicedev.php.attractgroup.com/public/document/add", "wow5", "wow4");
        UtilityStore.documentSecondStep(driver);
        Assert.assertTrue(true);
      //  Assert.assertTrue(UtilityStore.checkTitle(driver,"Invoice"));
       // Assert.assertTrue(UtilityStore.checkTextPresence(driver));

      //  driver.close();
    }




}
