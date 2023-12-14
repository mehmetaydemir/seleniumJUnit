package tests.day09_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class c03Actions extends TestBase {

    @Test
    public void sagClickTesti() {

        //1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");
        ReusableMethods.bekle(1);

        //2- “DGI Drones” uzerinde sag click yapin

        Actions action = new Actions(driver);

        WebElement dgiDrones = driver.findElement(By.id("pic2_thumb"));
        action.contextClick(dgiDrones).perform();

        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.

        String alertYazisi = driver.switchTo().alert().getText();
        System.out.println(alertYazisi);
        //4- Tamam diyerek alert’i kapatalim

        driver.switchTo().alert().accept();

        ReusableMethods.bekle(5);


    }


}
