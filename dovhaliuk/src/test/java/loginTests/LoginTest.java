package loginTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.junit.Assert;
import org.junit.After;
import org.junit.Test;

public class LoginTest {

    //new object
    private WebDriver webdriver = driverInit(); //we will obtain excempiar of ChromeDriver

    private WebDriver driverInit(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    //annotation
    //test to log in system
    //obrashiaemsia to driver
    @Test
    public void validLogin() {
        //open browser and open page with this url
        webdriver.get("http://v3.test.itpmgroup.com");
        //find field for fill login and clear this field
        webdriver.findElement(By.name("_username")).clear();
        //input of login in login field
        webdriver.findElement(By.name("_username")).sendKeys("Student");
        //find field for fill password and clear this field
        webdriver.findElement(By.name("_password")).clear();
        //input of login in password field
        webdriver.findElement(By.name("_password")).sendKeys("909090");
        //click on button submit to log in after inputs
        webdriver.findElement(By.xpath(".//button[@type = 'submit']")).click();
        //we want to validate is this element visible
        Assert.assertTrue(webdriver.findElement(By.xpath(".//div[@class = 'pull-left info']")).isDisplayed());
    }

    @After
    public void tearDown(){
        webdriver.quit();
    }

}
