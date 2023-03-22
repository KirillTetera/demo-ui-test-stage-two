package by.itacademy.kirilltetera.web;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonStep {
    WebDriver driver;
    AmazonStep (WebDriver driver) {
        this.driver=driver;
    }
    //public void testAmazonCopyright() {
      //  WebElement copyrightElement = driver.findElement(By.xpath(AmazonPage.copyright));
    //}
    public void testOpenAmazonCart() {
        WebElement cartButton = driver.findElement(By.xpath(AmazonPage.cartButton));
        cartButton.click();
    }
    public void testOpenAmazonLoginForm() {
        WebElement cartButton = driver.findElement(By.xpath(AmazonPage.cartButton));
        cartButton.click();
        WebElement signInButton = driver.findElement(By.xpath(AmazonPage.signInButton));
        signInButton.click();
    }
    public void testAmazonLoginFormWithEmptyCredentials() {
        WebElement cartButton = driver.findElement(By.xpath(AmazonPage.cartButton));
        cartButton.click();
        WebElement signInButton = driver.findElement(By.xpath(AmazonPage.signInButton));
        signInButton.click();
        WebElement continueButton = driver.findElement(By.xpath(AmazonPage.continueButton));
        continueButton.click();
    }
}

