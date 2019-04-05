import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    private static WebDriver driver;

    private static final String CHROME_KEY = "webdriver.chrome.driver";
    private static final String CHROME_VALUE = "./drivers/chromedriver.exe";

    public static WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void before() {

        System.setProperty(CHROME_KEY, CHROME_VALUE);
        driver = new ChromeDriver();
    }

    @AfterClass
    public void after() {

        driver.quit();
    }

}
