package tests.day13_getScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_TumSayfaScreenshot extends TestBase {

    @Test
    public void aramaTesti() throws IOException {
        // test otomasyonu anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");
        // Nutella için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        // Arama Sonucunda urun bulunamadığını test edin

        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));

        String expectedAramaSonucu = "0 Product Found";
        String actualAramaSonucu = aramaSonucElementi.getText();
        Assert.assertEquals(expectedAramaSonucu,actualAramaSonucu);

        //1.adım tss objesini oluştur
        TakesScreenshot tss = (TakesScreenshot) driver;
        //2.adim fotoğrafı kaydedeceğimiz dosya yolu ile bir file oluşturalım

        File tumSayfaScreenshot = new File("target/screenshots/tumSayfaScreenshot.jpg");

        //3.adim tss objesini kullanarak fotografı çekip geçici bir doyaya kaydedelim

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        //4.adım geçici dosyayı asıl dosyaya kopyalayalım

        FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);


        // tum sayfanın foğrafını çekip kaydedin



    }







}
