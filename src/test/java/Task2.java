import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.AssertJUnit.assertEquals;

public class Task2 extends BaseForTest {
    String url = "http://demo.guru99.com/Agile_Project/Agi_V1/index.php";
    String login = "1303";
    String password = "Guru99";
    String loginButton = "//input[@name='btnLogin']";
    String loggedInUser = "http://demo.guru99.com/Agile_Project/Agi_V1/customer/Customerhomepage.php";

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(url);
    }
    @Test
    public void Task1() {
        driver.findElement(By.name("uid")).sendKeys(login);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath(loginButton)).click();
        wait.until(presenceOfElementLocated(By.linkText("Log out")));

        Set<Cookie> cookies = driver.manage().getCookies();
        System.out.println(cookies);

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        assertEquals(driver.getCurrentUrl(), loggedInUser);



    }
}
