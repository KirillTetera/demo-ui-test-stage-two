package by.itacademy.kirilltetera.web;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class OnlinerStep {
    WebDriver driver;
    OnlinerStep (WebDriver driver) {
        this.driver=driver;
    }

    public void testOnlinerCopyright() {
        WebElement copyright = driver.findElement(By.xpath(OnlinerPage.copyright));

    }

    public void testOpenOnlinerLoginForm() {
        WebElement buttonEntrance = driver.findElement(By.xpath(OnlinerPage.buttonEntrance));
        buttonEntrance.click();
        WebElement textEntrance = driver.findElement(By.xpath(OnlinerPage.textEntrance));
    }

    public void testOnlinerLoginFormWithEmptyCredentials(){
        WebElement buttonEntrance = driver.findElement(By.xpath(OnlinerPage.buttonEntrance));
        buttonEntrance.click();
        WebElement buttonEnter = driver.findElement(By.xpath(OnlinerPage.buttonEnter));
        buttonEnter.click();
        List<WebElement> warningMessagesEmptyCredentials = driver.findElements(
                By.xpath(OnlinerPage.warningMessagesEmptyCredentials));
    }

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
    }
}
