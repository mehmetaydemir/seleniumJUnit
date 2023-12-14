package tests.day10_actions_faker_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FilesExistTesti extends TestBase {


    @Test
    public void dosyaIndirmeTesti(){

        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. logo.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='logo.png']")).click();
        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim

        String dosyaYolu = "C:/Users/Asus/Downloads/logo.png";

        ReusableMethods.bekle(5);

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        // dosya yolu : C:\Users\Asus\Downloads

        //




    }



}
