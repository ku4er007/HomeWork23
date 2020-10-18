import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Task1 extends BaseForTest {
    String gmailUrl = "https://mail.google.com/";
    String emailInputField = "//input[@type='email']";
    String passwordInputField = "//input[@type='password']";
    String email = "bondtest00007@gmail.com";
    String password = "QwErTy1996";
    String newMessageButton = "//div[@class='T-I T-I-KE L3']";
    String newMessageTitle = "//div[@class='aYF'][contains(text(),'Новое сообщение')]";


    @BeforeMethod
    public void navigateToUrl() {
        driver.get(gmailUrl);
    }

    @Test

    public void Task1() {
        wait.until(visibilityOfElementLocated(By.xpath(emailInputField))).sendKeys(email + Keys.ENTER);
        wait.until(visibilityOfElementLocated(By.xpath(passwordInputField))).sendKeys(password + Keys.ENTER);
        wait.until(visibilityOfElementLocated(By.xpath(newMessageButton))).click();
        wait.until(visibilityOfElementLocated(By.xpath(newMessageTitle)));
        driver.findElement(By.xpath("//div[@class='oL aDm']")).sendKeys(email + Keys.ENTER);
        driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Тема письма - Тестовая");
        //доделать ввод письма и отправку


    }

}