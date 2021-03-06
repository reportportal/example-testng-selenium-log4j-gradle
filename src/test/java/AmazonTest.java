import com.google.common.io.BaseEncoding;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

public class AmazonTest extends TestBase {

    private Logger logger = LoggerFactory.getLogger(AmazonTest.class);

    @Test(priority = 1)
    public void userOpenPage() {
        TestBase.getDriver().get("https://www.amazon.com/");
        logger.info("user is opening main page");

        delay();
    }

    @Test(priority = 2)
    public void userTypingSearchQuery() {

        logger.info("user typing a search query");
        TestBase
                .getDriver()
                .findElement(By.id("twotabsearchtextbox"))
                .sendKeys("apple");

        delay();
    }

    @Test(priority = 3)
    public void userClicksSearchButton() {

        logger.info("user clicks search button");

        TestBase
                .getDriver()
                .findElement(By.xpath("//*[@id=\"nav-search\"]/form/div[2]/div/input"))
                .click();

        takeScreenshot();

        delay();
    }

    private void takeScreenshot() {
        byte[] screenshot = ((TakesScreenshot) TestBase.getDriver()).getScreenshotAs(OutputType.BYTES);

        logger.info("RP_MESSAGE#BASE64#{}#{}",
                BaseEncoding.base64().encode(screenshot),
                "Some message");
    }

    private void delay() {

        try {
            Thread.sleep(5_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
