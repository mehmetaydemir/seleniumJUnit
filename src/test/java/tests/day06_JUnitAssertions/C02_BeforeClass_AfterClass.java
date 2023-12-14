package tests.day06_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeClass_AfterClass {

    // 3 farklı testmethodu oluşturarak
    // aşağıda verilen görevi tamamlayın
    // 1- testotomasyonu.com sayfasına gidin
    //  url'in testotomasyonu içerdiğini test edin
    // 2- phone için arama yapın
    //  ve arama sonucunda ürün bulunabildiğini test edin
    // 3- ilk ürüne tıklayın
    //  ve ürün açıklamasında case sensitive olmadan phone geçtiğini test edin

    /*
        Bu görevlerin sağlıklı yapılabilmesi için
        test method'ların doğru sırada çalışması gereki
        driver objesi tüm methdlardan önce oluşturulmalı
        ve tüm method'lar çalıştıktan sonra kapatılmalıdır

         Bunu saglayabilmek icin @BeforeClass ve @AfterClass notasyonlari kullaniriz
          ANCAK dikkat etmemiz gereken konu
          bu notosyonlari kullanan method'lar static OLMAK ZORUNDADIR
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void teardown() {
        driver.quit();
    }

    @Test
    public void test01() {
        // 1- testotomasyonu.com sayfasına gidin
        //  url'in testotomasyonu içerdiğini test edin
        driver.get("https://testotomasyonu.com");
        String exceptedUrlIcerik = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(exceptedUrlIcerik)) {
            System.out.println("Url Testi PASSED");
        } else {
            System.out.println("Url Testi FAILED");
            throw new AssertionFailedError();
        }

    }

    @Test
    public void test02() {
        // 2- phone için arama yapın
        //  ve arama sonucunda ürün bulunabildiğini test edin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        WebElement aramaSonuc = driver.findElement(By.className("product-count-text"));

        String aramaSonucuStr = aramaSonuc.getText().replaceAll("\\D", "");

        int aramaSonucuInt = Integer.parseInt(aramaSonucuStr);

        if (aramaSonucuInt > 0) {
            System.out.println("Phone testi PASSED");
        } else {
            System.out.println("Phone testi FAILED");
            throw new AssertionFailedError();

        }


    }

    @Test
    public void test03() {
        // 3- ilk ürüne tıklayın
        //  ve ürün açıklamasında case sensitive olmadan phone geçtiğini test edin

        driver.findElement(By.xpath("(//*[@class='product-box my-2  py-1'])[1]")).click();
        WebElement urunAciklamaElementi = driver.findElement(By.xpath("//*[@*='product-short-desc  my-2']"));


        String expectedUrunIcerik = "phone";
        String urunAciklama = urunAciklamaElementi.getText().toLowerCase();

        if (urunAciklama.contains(expectedUrunIcerik)) {
            System.out.println("urun açıklama testi PASSED");
        } else {
            System.out.println("urun açıklama testi FAILED");
            throw new AssertionFailedError();

        }

    }


}
