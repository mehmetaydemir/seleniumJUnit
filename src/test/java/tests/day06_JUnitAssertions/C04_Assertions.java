package tests.day06_JUnitAssertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {

    /*
        //   https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak
        //   asagidaki testleri yapin
        //       ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        //       ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        //       ○ logoTest => BestBuy logosunun görüntülendigini test edin
        //       ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
     */

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.bestbuy.com/");

    }
    @AfterClass
    public static void teardown() {
        driver.quit();
    }

    @Test
    public void urlTesti(){
        // ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin


        String exceptedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(exceptedUrl,actualUrl);


    }
    @Test
    public void titleTesti(){
        // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

        String exceptedTitle = "Rest";
        String actualTitle = driver.getTitle();

        Assert.assertFalse(exceptedTitle.contains(actualTitle));


    }
    @Test
    public void logoTesti(){
        // ○ logoTest => BestBuy logosunun görüntülendigini test edin

        WebElement logoElementi = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));

        Assert.assertTrue(logoElementi.isDisplayed());


    }
    @Test
    public void francaisLinkTesti(){
        // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    WebElement francaIsLinkElementi = driver.findElement(By.xpath("//*[text()='Français']"));
    Assert.assertTrue(francaIsLinkElementi.isDisplayed());



    }


}