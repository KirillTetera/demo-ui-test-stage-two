package by.itacademy.kirilltetera.web;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OnlinerTest {
    WebDriver driver;
    @Before
    public void preporation(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(OnlinerPage.url);
    }
    @Test
    public void testOnlinerCopyright(){
        WebElement copyright = driver.findElement(By.xpath(OnlinerPage.copyright));
        Assert.assertEquals("© 2001—2023 Onlíner", copyright.getText());
    }
    @Test
    public void testOpenOnlinerLoginForm(){
        WebElement buttonEntrance = driver.findElement(By.xpath(OnlinerPage.buttonEntrance));
        buttonEntrance.click();
        WebElement textEntrance = driver.findElement(By.xpath(OnlinerPage.textEntrance));
        Assert.assertEquals("Вход", textEntrance.getText());
    }
    @Test
    public void testOnlinerLoginFormWithEmptyCredentials(){
        WebElement buttonEntrance = driver.findElement(By.xpath(OnlinerPage.buttonEntrance));
        buttonEntrance.click();
        WebElement buttonEnter = driver.findElement(By.xpath(OnlinerPage.buttonEnter));
        buttonEnter.click();
        List<WebElement> warningMessagesEmptyCredentials = driver.findElements(
                By.xpath(OnlinerPage.warningMessagesEmptyCredentials));
        Assert.assertEquals("Укажите ник или e-mail", warningMessagesEmptyCredentials.get(0)
                .getText());
        Assert.assertEquals("Укажите пароль", warningMessagesEmptyCredentials.get(1)
                .getText());
    }
    @Test
    public void testOnlinerLoginFormWithEmptyPassword() {
        WebElement buttonEntrance = driver.findElement
                (By.xpath(OnlinerPage.buttonEntrance));
        buttonEntrance.click();
        WebElement inputNickOrEmail = driver.findElement
                (By.xpath(OnlinerPage.inputNickOrEmail));
        inputNickOrEmail.sendKeys("test@gmail.com");
        WebElement buttonEnter = driver.findElement
                (By.xpath(OnlinerPage.buttonEnter));
        buttonEnter.click();
        WebElement warningMessagesEmptyCredentials = driver.
                findElement(By.xpath(OnlinerPage.warningMessagesEmptyCredentials));
        Assert.assertEquals("Укажите пароль", warningMessagesEmptyCredentials.getText());
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}

