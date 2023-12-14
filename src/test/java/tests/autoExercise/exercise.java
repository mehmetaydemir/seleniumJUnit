package tests.autoExercise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class exercise {

    @Test
    public void testCase08(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. 'http://automationexercise.com' URL'sine gidin
        driver.get("http://automationexercise.com");
        //3. Ana sayfanın başarıyla göründüğünü doğrulayın

        WebElement imgElementi = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(imgElementi.isDisplayed());
        //4. 'Ürünler' düğmesine tıklayın
        WebElement productsElementi = driver.findElement(By.xpath("//*[text()=' Products']"));
        productsElementi.click();
        //5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla yönlendirildiğini doğrulayın
        WebElement productsPageElementi = driver.findElement(By.xpath("//img[@src='/static/images/shop/sale.jpg']"));
        Assert.assertTrue(productsPageElementi.isDisplayed());
        //6. Ürün listesi görünür
        WebElement productsList = driver.findElement(By.xpath("//div[@class='features_items']"));
        Assert.assertTrue(productsList.isDisplayed());
        //7. İlk ürünün 'Ürünü Görüntüle' seçeneğine tıklayın
        WebElement firstProduct = driver.findElement(By.xpath("(//*[text()='View Product'])[1]"));
        firstProduct.click();
        //8. Kullanıcı ürün detay sayfasına yönlendirilir
        String expectedProductDetailPageTitle = "Automation Exercise - Product Details";
        String actualProductDetailPageTitle = driver.getTitle();
        Assert.assertEquals(expectedProductDetailPageTitle,actualProductDetailPageTitle);

        //9. Ayrıntı ayrıntılarının göründüğünü doğrulayın: ürün adı, kategori, fiyat, stok durumu, durum, marka
        String expectedproductName = "Blue Top";
        WebElement actualproductName = driver.findElement(By.xpath("//*[text()='Blue Top']"));
        Assert.assertEquals(expectedProductDetailPageTitle,actualproductName);

        String expectedproductCategory = "Category: Women > Tops";
        WebElement actualproductCategory = driver.findElement(By.xpath("//*[text()='Category: Women > Tops']"));
        Assert.assertEquals(expectedproductCategory,actualproductCategory);

        String expectedproductPrice = "Rs. 500";
        WebElement actualproductPrice = driver.findElement(By.xpath("//*[text()='Rs. 500']"));
        Assert.assertEquals(expectedproductPrice,actualproductPrice);

        String expectedproductAvailability = " In Stock";
        WebElement actualproductAvailability = driver.findElement(By.xpath("//*[text()=' In Stock']"));
        Assert.assertEquals(expectedproductAvailability,actualproductAvailability);

        String expectedproductCondition = " New";
        WebElement actualproductCondition = driver.findElement(By.xpath("//*[text()=' New']"));
        Assert.assertEquals(expectedproductCondition,actualproductCondition);

        String expectedproductBrand = " Polo";
        WebElement actualproductBrand = driver.findElement(By.xpath("//*[text()=' Polo']"));
        Assert.assertEquals(expectedproductBrand,actualproductBrand);

        ReusableMethods.bekle(5);





    }



}
