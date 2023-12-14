package tests.day09_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_Actions extends TestBase {

    @Test
    public void test01(){

        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        ReusableMethods.bekle(2);

        //3- Cizili alan uzerinde sag click yapin
        Actions actions = new Actions(driver);
        WebElement ciziliAlan = driver.findElement(By.id("hot-spot"));
        actions.contextClick(ciziliAlan).perform();
        ReusableMethods.bekle(2);

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String actualalertYazisi = driver.switchTo().alert().getText();
        String exceptedAlertYazisi = "You selected a context menu";
        Assert.assertEquals(exceptedAlertYazisi,actualalertYazisi);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        ReusableMethods.bekle(2);

        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        //driver.findElement(By.linkText("Elemental Selenium")).click();
        ReusableMethods.bekle(2);

        //7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim
        ReusableMethods.bekle(2);

        driver = ReusableMethods.titleIleSayfaDegistir(driver,"Elemental Selenium | Elemental Selenium");

        WebElement h1TagName = driver.findElement(By.tagName("h1"));

        String exceptedTagName = "Make sure your code lands";
        String actualTagName = h1TagName.getText();

        Assert.assertEquals(exceptedAlertYazisi,actualalertYazisi);






    }




}
