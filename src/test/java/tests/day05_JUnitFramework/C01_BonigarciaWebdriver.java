package tests.day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BonigarciaWebdriver {

    public static void main(String[] args) throws InterruptedException {

        // bir class'ta test işlemlerine başlamadan önce
        // ilk olarak Webdriver objemizi oluşturmalı
        // ve gerekli ayarlamaları yapmaliyiz


        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.testotomasyonu.com");

        Thread.sleep(2000);
        driver.quit();





    }


}
