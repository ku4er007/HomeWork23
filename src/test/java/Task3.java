import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public class Task3 extends BaseForTest {
    String url = "http://demo.guru99.com/Agile_Project/Agi_V1/index.php";

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(url);
    }

    @Test
    public void Task1() {
//        wait.until(visibilityOfElementLocated(By.cssSelector("primis_playerSekindoSPlayer")));
        wait.until(visibilityOfElementLocated((By.cssSelector("playBtn")))).click();

    }
}
