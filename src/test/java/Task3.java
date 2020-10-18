import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task3 extends BaseForTest {
    String url = "http://demo.guru99.com/Agile_Project/Agi_V1/index.php";

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(url);
    }

    @Test
    public void Task1() {
    }
}
