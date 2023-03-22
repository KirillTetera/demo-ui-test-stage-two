package by.itacademy.kirilltetera.web;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class AmazonTest {
    WebDriver driver;
   @Before
   public void warmUp() {
       ChromeOptions chromeOptions = new ChromeOptions();
       chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
       driver = new ChromeDriver(chromeOptions);
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.navigate().to(AmazonPage.url);
   }
    @Test
    public void testAmazonCopyright() {
       //AmazonStep amazonStep = new AmazonStep(driver);
       //amazonStep.testAmazonCopyright();
        Assert.assertEquals("© 1996-2023, Amazon.com, Inc. or its affiliates",
                driver.findElement(By.xpath(AmazonPage.copyright)).getText());
    }
    @Test
    public void testOpenAmazonCart() {
        AmazonStep amazonStep = new AmazonStep(driver);
        amazonStep.testOpenAmazonCart();
        Assert.assertEquals("Your Amazon Cart is empty",
                driver.findElement(By.xpath(AmazonPage.cartIsEmptyWarning)).getText());
    }
    @Test
    public void testOpenAmazonLoginForm() {
        AmazonStep amazonStep = new AmazonStep(driver);
        amazonStep.testOpenAmazonLoginForm();
        Assert.assertEquals("Sign in",
                driver.findElement(By.xpath(AmazonPage.signInText)).getText());
    }
    @Test
    public void testAmazonLoginFormWithEmptyCredentials() {
        AmazonStep amazonStep = new AmazonStep(driver);
        amazonStep.testAmazonLoginFormWithEmptyCredentials();
        Assert.assertEquals("Enter your email or mobile phone number",
                driver.findElement(By.xpath(AmazonPage.warningEmptyCredentials)).getText());
    }
    @After
    public void tearDown(){
       driver.quit();
    }
}
