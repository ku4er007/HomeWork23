import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Task3 extends BaseForTest {
    String url = "http://demo.guru99.com/Agile_Project/Agi_V1/index.php";
    String playButton = "//div[@class='primisslate']/div/div/div";
    String visibleIframe = "//div[@style='width: 100%; bottom: 0px; left: 0px; position: absolute; opacity: 1; visibility: visible; user-select: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); pointer-events: auto; display: block;']";
    String notVisibleIframe = "//div[@style='width: 100%; bottom: 0px; left: 0px; position: absolute; opacity: 0; visibility: visible; user-select: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0); pointer-events: auto; display: none;']";
    String loginButtonXpath = "//input[@value='LOGIN']";

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(url);
    }

    @Test
    public void Task1() {
        Actions actions = new Actions(driver);
        WebElement play = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(playButton)));
        play.click();
        actions.moveToElement(play).build().perform();
        WebElement isShow = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(visibleIframe)));
        assertTrue(isShow.isDisplayed());
        actions.moveToElement(driver.findElement(By.xpath(loginButtonXpath)));
        WebElement isntShow = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(notVisibleIframe)));
        assertFalse(isntShow.isDisplayed());
    }
}
