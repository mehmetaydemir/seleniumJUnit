package tests.day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_Odev extends TestBase {

    @Test
    public void test01(){
        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/ ");
        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        WebElement addText = driver.findElement(By.tagName("h2"));
        String exceptedTextYazisi = "Add/Remove Elements";
        String actualTextYazisi = addText.getText();
        Assert.assertEquals(exceptedTextYazisi,actualTextYazisi);
        //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
        String title = "Test Otomasyonu";
        Assert.assertEquals(title, driver.getTitle());
        //● ‘Please click for Electronics Products’ linkine tiklayin.
        driver.findElement(By.linkText("Electronics Products")).click();
        //● Electronics sayfasinin acildigini test edin
        //● Bulunan urun sayisinin 16 olduğunu test edin
        //● Ilk actiginiz addremove sayfasina donun
        //● Url’in addremove icerdigini test edin





    }



}
