package tests.day13_getScreenShot;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_ScreenshotileArama extends TestBase {

    @Test
    public void screenshorIleAramaTesti(){
        // test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        // dress için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("dress"+ Keys.ENTER);

        // Arama Sonucunda urun bulunamadığını test edin

        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        String unExpectedAramaSonucu = "0 Product Found";
        String actualAramaSonucu = aramaSonucElementi.getText();
        Assert.assertNotEquals(unExpectedAramaSonucu,actualAramaSonucu);

        ReusableMethods.tumSayfaTakeScreenshot(driver);
    }

}
