package tests.day05_JUnitFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C03_webappTesti {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       // http://zero.webappsecurity.com sayfasına gidin
        driver.get("http://zero.webappsecurity.com");
       // signin butonuna tıklayın
        driver.findElement(By.id("signin_button")).click();
       // login alanına "username" yazdırın
        WebElement login = driver.findElement(By.id("user_login"));
        login.sendKeys("username");
       // password alanına "password" yazdırın
        WebElement password = driver.findElement(By.id("user_password"));
        password.sendKeys("password");
       // Sign in butonuna tıklayın
        driver.findElement(By.xpath("//input[@name='submit']")).click();
       // Back tuşu ile sayfaya dönün
        driver.navigate().back();
       // Online Banking menusunden Pay Bills sayfasına gidin
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link"));
       // amount kısmına yatırmak istediğiniz herhangi bir miktarı yazın
        WebElement amount = driver.findElement(By.id("sp_amount"));
        amount.sendKeys("50");
       // tarih kısmına "2023-09-10" yazdırın
        driver.findElement(By.id("sp_date")).sendKeys("2023-09-10");
       // Pay butonuna tıklayın
        driver.findElement(By.id("pay_saved_payees")).click();
       // "The payment was successfully submitted" mesajının çıktığını test edin
        WebElement mesaj = driver.findElement(By.id("alert_contect"));

        String expectedResult = "The payment was successfully submitted";
        String actualResult = mesaj.getText();

        if (expectedResult.equals(actualResult)){
            System.out.println("test PAssed");
        }else {
            System.out.println("test failed");
        }

        ReusableMethods.bekle(2000);
        driver.quit();

    }



}
