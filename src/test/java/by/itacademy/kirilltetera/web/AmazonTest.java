package by.itacademy.kirilltetera.web;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AmazonTest {
    @Test
    public void testAmazonCopyright() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(AmazonPage.url);
        WebElement copyrightElement = driver.findElement(By.xpath(AmazonPage.copyright));
        Assert.assertEquals("© 1996-2023, Amazon.com, Inc. or its affiliates", copyrightElement.getText());
        driver.quit();

    }
}
