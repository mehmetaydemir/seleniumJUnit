package tests.day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_GoogleAramaTesti {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // google adresine gidin
        driver.get("https://www.google.com/");
        // sayfa başlığının google ifadesi içeriğini test edin
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();

        if (expectedTitle.equals(actualTitle)){
            System.out.println("testPAssed");
        }else {
            System.out.println("Test Failed");
        }
        // Arama çubuğuna "Nutella" yazıp aratın
        WebElement aramaKutusu = driver.findElement(By.name("q"));
        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);
        // bulunan sonuç sayısını yazdırın
        WebElement sonucYazi = driver.findElement(By.id("result-stats"));
        String sonucYazisiStr = sonucYazi.getText();
        System.out.println(sonucYazisiStr);
        // sonuç sayısının 10 milyondan fazla olduğunu test edin
        String[] sonucYazisiArr = sonucYazisiStr.split(" ");
        String sonucSayisiStr = sonucYazisiArr[1];
        sonucSayisiStr = sonucSayisiStr.replaceAll("\\D","");

        int sonucSayisiInt = Integer.parseInt(sonucSayisiStr);

        if (sonucSayisiInt>10000000){
            System.out.println("test PAssed");
        } else {
            System.out.println("test failed");
        }
        // sayfayı kapatın

        ReusableMethods.bekle(2000);
        driver.quit();












    }




}
