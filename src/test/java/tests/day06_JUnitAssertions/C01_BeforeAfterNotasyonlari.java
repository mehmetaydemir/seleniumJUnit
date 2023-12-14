package tests.day06_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeAfterNotasyonlari {

    // 3 farklı test method'u oluşturarak
    // aşağıdaki testleri yapın
    // 1- test otomasyonu.com sitesine gidin
    // 2- phonei shoues ve dress için arama yapın
    // 3- arama sonucunda urun bulunabildiğini test edin
    // 4- sayfayı kapatın

    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public  void phoneTest(){
        // 1- test otomasyonu.com sitesine gidin
        driver.get("https://www.testotomasyonu.com");
        // 2- phone  için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone"+ Keys.ENTER);
        // 3- arama sonucunda urun bulunabildiğini test edin
        WebElement sonucText = driver.findElement(By.xpath("//*[@*='product-count-text']"));
        String aramaSonucSayisiStr = sonucText.getText().replaceAll("\\D","");
        int aramaSonucSayisi = Integer.parseInt(aramaSonucSayisiStr);

        if (aramaSonucSayisi>0){
            System.out.println("phone testi PASSED");
        }else {
            System.out.println("phone Testi Failed");
            throw new AssertionFailedError();
        }
    }
    @Test
    public  void shoesTest(){
        // 1- test otomasyonu.com sitesine gidin
        driver.get("https://testotomasyonu.com");
        // 2- shoues  için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("shoes"+Keys.ENTER);
        // 3- arama sonucunda urun bulunabildiğini test edin
        WebElement aramaSonucuStr = driver.findElement(By.className("product-count-text"));
        String aramaSonucSayisiStr = aramaSonucuStr.getText().replaceAll("\\D","");
        int aramaSonucSayisi = Integer.parseInt(aramaSonucSayisiStr);

        if (aramaSonucSayisi>0){
            System.out.println("Shoes testi PASSED");
        }else {
            System.out.println("Shoes testi FAILED");
            throw new AssertionFailedError();
        }

    }
    @Test
    public  void dressTest(){
        // 1- test otomasyonu.com sitesine gidin
        driver.get("https://testotomasyonu.com");
        // 2- dress için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("dress"+Keys.ENTER);
        // 3- arama sonucunda urun bulunabildiğini test edin
        WebElement aramaSonucuStr = driver.findElement(By.xpath("//span[@class='product-count-text']"));
        String aramaSonucu = aramaSonucuStr.getText().replaceAll("\\D","");
        int aramaSonucSayisi = Integer.parseInt(aramaSonucu);

        if (aramaSonucSayisi>0){
            System.out.println("dress testi PASSED");
        }else {
            System.out.println("dress test FAILED");
            throw new AssertionFailedError();
        }

    }






}
