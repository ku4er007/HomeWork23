import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Task1 extends BaseForTest {
    String gmailUrl = "https://mail.google.com/";
    String emailInputField = "//input[@type='email']";
    String passwordInputField = "//input[@type='password']";
    String email = "bondtest00007@gmail.com";
    String password = "QwErTy1996";
    String newMessageButton = "//div[@class='T-I T-I-KE L3']";
    String newMessageTitle = "//div[contains(text(),'Новое сообщение')]";
    String messageBody = "//div[@aria-label='Тело письма']";
    String message = "Тестовое письмо - Тестовая, Тестовое письмо - Тестовая, Тестовое письмо - Тестовая";
    String sendButton = "//div[@class='T-I J-J5-Ji aoO v7 T-I-atl L3'][contains(text(),'Отправить')]";
    String toField = "textarea[name='to']";
    String messageBodyLocator = "//div[contains(text(), '" + message + "' )]";
    String attachment = "div[command='Files']";
    String messageTemeLocator = "//input[@name='subjectbox']";
    String messageTheme = "Тема письма - Тестовая";
    String deleteMessageLocator = "div[aria-label='Удалить прикрепленный файл']";
    String sendMessageLocator = "//span[contains(text(), 'Письмо отправлено.')]";
    String receiveMessageLocator = "//div[text()='Тестовое письмо - Тестовая, Тестовое письмо - Тестовая, Тестовое письмо - Тестовая']";



    @BeforeMethod
    public void navigateToUrl() {
        driver.get(gmailUrl);
    }

    @Test

    public void Task1() throws AWTException {
        wait.until(visibilityOfElementLocated(By.xpath(emailInputField))).sendKeys(email + Keys.ENTER);
        wait.until(visibilityOfElementLocated(By.xpath(passwordInputField))).sendKeys(password + Keys.ENTER);
        wait.until(visibilityOfElementLocated(By.xpath(newMessageButton))).click();
        wait.until(visibilityOfElementLocated(By.xpath(newMessageTitle)));
        driver.findElement(By.cssSelector(toField)).sendKeys(email);
        String message2 = messageTheme;
        driver.findElement(By.xpath(messageTemeLocator)).sendKeys(messageTheme);
        driver.findElement(By.xpath(messageBody)).sendKeys(message);
        driver.findElement(By.cssSelector(attachment)).click();
        StringSelection attach = new StringSelection("/Users/kostiantyndoroshenko/textfile.txt");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(attach, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        wait.until(visibilityOfElementLocated(By.cssSelector(deleteMessageLocator)));
        driver.findElement(By.xpath(sendButton)).click();
        wait.until(visibilityOfElementLocated(By.xpath(sendMessageLocator)));

        List<WebElement> sideMailMenu = driver.findElements(By.xpath("//span[contains(text(), '" + message2 + "')] [@data-legacy-last-non-draft-message-id]"));
        assertThat(sideMailMenu.get(1).getText(), equalTo(message2));
        sideMailMenu.get(1).click();

        wait.until(visibilityOfElementLocated(By.xpath("//h2[contains(text(), '" + message2 + "' )]")));
        wait.until(visibilityOfElementLocated(By.xpath(receiveMessageLocator)));
        assertThat(driver.findElement(By.xpath(messageBodyLocator)).getText(), equalTo(message));

    }

}
