package tests.autoExercise;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class exercise01 extends TestBase {

    @Test
    public void exercise08() {


        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully

        WebElement imgElementi = driver.findElement(By.xpath("//img[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(imgElementi.isDisplayed());

        //4. Click on 'Products' button
        WebElement productsElementi = driver.findElement(By.xpath("//*[text()=' Products']"));
        productsElementi.click();


        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement productsPageElementi = driver.findElement(By.xpath("//*[text()='All Products']"));
        Assert.assertTrue(productsPageElementi.isDisplayed());
        //6. The products list is visible
        WebElement productsListElementi = driver.findElement(By.xpath("//div[@class='col-sm-9 padding-right']"));
        Assert.assertTrue(productsListElementi.isDisplayed());


        //7. Click on 'View Product' of first product

        ReusableMethods.bekle(10);
        WebElement firstProduct = driver.findElement(By.xpath("(//*[text()='View Product'])[1]"));
        //productsElementi.sendKeys(Keys.PAGE_DOWN);
        //(//i[@class='fa fa-plus-square'])[1]
        firstProduct.click();

        //8. User is landed to product detail page

        String expectedproductPageDetailElementi = "Automation Exercise - Product Details";
        String actualproductPageDetailElementi = driver.getTitle();

        Assert.assertEquals(expectedproductPageDetailElementi, actualproductPageDetailElementi);

        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand

        String expectedproductName = "Blue Top";
        WebElement productName = driver.findElement(By.xpath("//*[text()='Blue Top']"));
        String actualproductName = productName.getText();
        Assert.assertEquals(expectedproductName, actualproductName);

        String expectedproductCategory = "Category: Women > Tops";
        WebElement productCategory = driver.findElement(By.xpath("//*[text()='Category: Women > Tops']"));
        String actualproductCategory = productCategory.getText();
        Assert.assertEquals(expectedproductCategory, actualproductCategory);

        String expectedproductPrice = "Rs. 500";
        WebElement productPrice = driver.findElement(By.xpath("//*[text()='Rs. 500']"));
        String actualproductPrice = productPrice.getText();
        Assert.assertEquals(expectedproductPrice, actualproductPrice);

        String expectedproductAvailability = " In Stock";
        WebElement productAvailability = driver.findElement(By.xpath("//*[text()=' In Stock']"));
        String actualproductAvailability = productAvailability.getText();

        Assert.assertTrue(actualproductAvailability.contains(expectedproductAvailability));

        String expectedproductCondition = " New";
        WebElement productCondition = driver.findElement(By.xpath("//*[text()=' New']"));
        String actualproductCondition = productCondition.getText();
        Assert.assertTrue(actualproductCondition.contains(expectedproductCondition));

        String expectedproductBrand = " Polo";
        WebElement productBrand = driver.findElement(By.xpath("//*[text()=' Polo']"));
        String actualproductBrand = productBrand.getText();
        Assert.assertTrue(actualproductBrand.contains(expectedproductBrand));

        ReusableMethods.bekle(3);


    }


}
