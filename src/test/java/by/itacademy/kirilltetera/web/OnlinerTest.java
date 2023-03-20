package by.itacademy.kirilltetera.web;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
import java.util.List;

public class OnlinerTest {
    WebDriver driver;
    @Before
    public void preporation() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to(OnlinerPage.url);
    }
    @Test
    public void testOnlinerCopyright() {
        OnlinerStep onlinerStep = new OnlinerStep(driver);
        onlinerStep.testOnlinerCopyright();
        Assert.assertEquals("© 2001—2023 Onlíner",
                driver.findElement(By.xpath(OnlinerPage.copyright)).getText());
    }
    @Test
    public void testOpenOnlinerLoginForm() {
        OnlinerStep onlinerStep = new OnlinerStep(driver);
        onlinerStep.testOpenOnlinerLoginForm();
        Assert.assertEquals("Вход",
                driver.findElement(By.xpath(OnlinerPage.textEntrance)).getText());
    }
    @Test
    public void testOnlinerLoginFormWithEmptyCredentials() {
        OnlinerStep onlinerStep = new OnlinerStep(driver);
        onlinerStep.testOnlinerLoginFormWithEmptyCredentials();
        List<WebElement> warningMessagesEmptyCredentials =
                driver.findElements(By.xpath(OnlinerPage.warningMessagesEmptyCredentials));
        Assert.assertEquals("Укажите ник или e-mail", warningMessagesEmptyCredentials.get(0)
                .getText());
        Assert.assertEquals("Укажите пароль", warningMessagesEmptyCredentials.get(1)
                .getText());
    }
    @Test
    public void testOnlinerLoginFormWithEmptyPassword() {
        OnlinerStep onlinerStep = new OnlinerStep(driver);
        onlinerStep.testOnlinerLoginFormWithEmptyPassword();
        Assert.assertEquals("Укажите пароль",
                driver.findElement(By.xpath(OnlinerPage.warningMessagesEmptyCredentials)).getText());
    }
    @After
    public void tearDo() {
        driver.quit();
    }
}
