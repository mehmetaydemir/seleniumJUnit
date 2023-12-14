package tests.day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_AramaTesti {

    public static void main(String[] args) throws InterruptedException {
        // test otomasyonu sayfasına gidelim

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // arama kutusunu locate edelim
        WebElement searchBox = driver.findElement(By.xpath("//input[@class='search-input']"));

        // "phone" ile arama yapalım
        searchBox.sendKeys("phone"+ Keys.ENTER);
        // Bulunan sonuç sayısını yazdıralım
        WebElement result = driver.findElement(By.className("product-count-text"));
        System.out.println(result.getText());
        // ilk ürüne tıklayalım
        driver.findElement(By.xpath("(//div[@class='product-box my-2'])[1]")).click();
        // ürünün stokta olup olmadığını yazdıralım.

        WebElement urunStokElementi = driver.findElement(By.xpath("(//span[@class='heading-xs'])[1]"));

        String expectedStokDurumu = "Availibility: In Stock";
        String actualStokDurumu = urunStokElementi.getText();

        if (expectedStokDurumu.equals(actualStokDurumu)){
            System.out.println("test Passed");
        }else {
            System.out.println("Failed");
        }

        Thread.sleep(2000);
        driver.quit();
        
    }



}
