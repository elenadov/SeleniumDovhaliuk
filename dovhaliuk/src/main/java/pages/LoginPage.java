package pages;


import libs.ActionWithWebElements;
import libs.ConfigClass;
import libs.ConfigClass1;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;
import org.junit.Assert;


public class LoginPage extends ParentPage {
    //universal parts for every test, so we will turn it to the Parent Page
//    protected WebDriver webDriver;
//    protected Logger logger = Logger.getLogger(getClass());
//    protected ActionWithWebElements actionWithWebElements;

    //peremennie pisali doma
//    By inputLoginName = By.name("_username");
    //make it as webElement type, not By type
    @FindBy(name = "_username") //find element by this locator
        private WebElement inputLoginName;

//    By inputPasswordName = By.name("_password");
    @FindBy(name = "_password")
        private WebElement inputPasswordName;

//    By inputButtonXpath = By.xpath(".//button[@type = 'submit']");
    @FindBy(xpath = ".//button[@type = 'submit']")
        private WebElement inputButtonXpath;

//    String url = "http://v3.test.itpmgroup.com";

//    By loginBox = By.xpath(".//div[@class = 'login-box-body'");

    @FindBy(xpath = ".//div[@class = 'login-box-body']")
        private WebElement loginBox;


    public LoginPage(WebDriver webDriver){
//        this.webDriver = webDriver;
//        actionWithWebElements = new ActionWithWebElements(webDriver);

        super(webDriver); //that's all, cause we don't want to add something
        //if we something add, we should write it down lower, after super...
    }

    //method po rabote s elementami web interface
    //open web page
    public void openPage() {
        try {
            webDriver.get(ConfigClass1.getCfgValue("base_url" + "/login"));
            logger.info("Page login was opened");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Can't open URL");
            Assert.fail("Can't open URL");
        }
    }

    public void inputLogin(String text){
        actionWithWebElements.enterTextToTextField(inputLoginName,text);
    }

    public void inputPassword(String text){
        actionWithWebElements.enterTextToTextField(inputPasswordName, text);
    }

    public void clickSubmitButton(){
        actionWithWebElements.clickButton(inputButtonXpath);
    }

    public boolean isLoginBoxRefresh(){
        return actionWithWebElements.isElemenDisplayed(loginBox);
    }

    public void loginToPage(String login, String password){
        inputLogin(login);
        inputPassword(password);
        clickSubmitButton();

    }

    public void openPage1() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com/login");
            logger.info("Page login was opened");

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Can't open URL");
            Assert.fail("Can't open URL");
        }
    }

}
