package tests.day11_waits_cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class C02_ExplicitlyWait {


    //2. Bir metod olusturun : isEnabled()
    @Test
    public void isEnabledTesti(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement enableTextElementi = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(enableTextElementi.isEnabled());

        //5. Enable butonuna tıklayın ve
        WebElement enableButton = driver.findElement(By.xpath("//*[text()='Enable']"));
        enableButton.click();
        //textbox etkin oluncaya kadar bekleyin
        // 1. adım : wait objesi oluşturulur.
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        // 2. adım mümkünse kullanılacak web elementi locate et
        // biz textbox'ın kullanılabilir olmasını bekleyeceğiz textbox locate etmiştik enableTextElementi
        // 3. adım wait objesi ile istenen web element üzerinde expected conditions ile bkele

        wait.until(ExpectedConditions.elementToBeClickable(enableTextElementi));
        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnableElementi = driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]"));
        //7. Textbox’in etkin oldugunu(enabled) dogrulayın.
        Assert.assertTrue(enableTextElementi.isEnabled());
    }



}
