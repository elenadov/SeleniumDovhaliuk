package parentTests;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class AbstractParentTest {

    WebDriver webDriver;
    protected LoginPage loginPage;
    protected HomePage homePage;


    @Before //annotation works before each test
    public void setUp() throws Exception {

        webDriver = driverInit();
        webDriver.manage().window().maximize(); //open big window
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); //neyavnoe ozhidanie
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
    }


    private WebDriver driverInit() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @After //annotation works after each test
    public void tearDown(){
        webDriver.quit();
    }

    protected void checkExpectedResult(String message, boolean actualResult){
        Assert.assertEquals(message, true, actualResult);
    }
}
