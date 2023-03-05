package by.itacademy.kirilltetera.web;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AmazonTest {

    WebDriver driver;
   @Before
   public void warmUp() {
       driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.navigate().to(AmazonPage.url);
   }
    @Test
    public void testAmazonCopyright() {
        WebElement copyrightElement = driver.findElement(By.xpath(AmazonPage.copyright));
        Assert.assertEquals("© 1996-2023, Amazon.com, Inc. or its affiliates", copyrightElement.getText());
    }
    @Test
    public void testOpenAmazonCart() {
        WebElement cartButton = driver.findElement(By.xpath(AmazonPage.cartButton));
        cartButton.click();
        WebElement cartIsEmptyWarning = driver.findElement(By.xpath(AmazonPage.cartIsEmptyWarning));
        Assert.assertEquals("Your Amazon Cart is empty", cartIsEmptyWarning.getText());
    }
    @Test
    public void testOpenAmazonLoginForm() {
        WebElement cartButton = driver.findElement(By.xpath(AmazonPage.cartButton));
        cartButton.click();
        WebElement signInButton = driver.findElement(By.xpath(AmazonPage.signInButton));
        signInButton.click();
        WebElement signInText = driver.findElement(By.xpath(AmazonPage.signInText));
        Assert.assertEquals("Sign in", signInText.getText());
    }
    @Test
    public void testAmazonLoginFormWithEmptyCredentials() {
        WebElement cartButton = driver.findElement(By.xpath(AmazonPage.cartButton));
        cartButton.click();
        WebElement signInButton = driver.findElement(By.xpath(AmazonPage.signInButton));
        signInButton.click();
        WebElement continueButton = driver.findElement(By.xpath(AmazonPage.continueButton));
        continueButton.click();
        WebElement warningEmptyCredentials = driver.findElement(By.xpath(AmazonPage.warningEmptyCredentials));
        Assert.assertEquals("Enter your email or mobile phone number", warningEmptyCredentials.getText());
    }

    public void tearDown (){
        driver.quit();
    }
}