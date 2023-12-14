package tests.day07_testBaseClass_Dropdown;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_JsAlerts extends TestBase {

    @Test
    public void jsBasicAlert(){
        //1. Test
        //- https://testotomasyonu/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu/javascriptAlert");
        //- 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        //- Alert'deki yazinin "I am a JS Alert" oldugunu test edin

        String expectedAlertYazisi = "I am a JS Alert";
        String actualAlertYazisi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);

        //- OK tusuna basip alert'i kapatin
        ReusableMethods.bekle(5);
        driver.switchTo().alert().accept();


    }

    @Test
    public void jsBasicAlert2(){
        //2.Test
        //- https://testotomasyonu/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu/javascriptAlert");

        //- 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[@onclick='jsConfirm()']")).click();

        ReusableMethods.bekle(2);
        driver.switchTo().alert().dismiss();

        //- Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin

        WebElement resultYaziElementi = driver.findElement(By.xpath("//p[@id='result']"));
        String expectedResultYazisi = "You clicked: Cancel";
        String actualResultYazisi = resultYaziElementi.getText();
        Assert.assertEquals(expectedResultYazisi,actualResultYazisi);
    }

    @Test
    public void jsBasicAlert3(){
        //3.Test
        //- https://testotomasyonu/javascriptAlert adresine gidin
        driver.get("https://testotomasyonu/javascriptAlert");
        //- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        //- Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo().alert().sendKeys("Mehmet");
        //- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().dismiss();
        //- Cikan sonuc yazisinin MEhmet icerdigini test edelim

        WebElement actualResultElementi = driver.findElement(By.xpath("//p[@id='result']"));
        String expectedResult = "Mehmet";
        String actualResult = actualResultElementi.getText();
        Assert.assertEquals(expectedResult,actualResult);


    }





}
