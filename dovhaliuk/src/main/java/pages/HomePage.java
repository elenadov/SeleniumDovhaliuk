package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPage.ParentPage;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//li[@id='dictionary']//ul[@class='treeview-menu menu-open']//li[@id='prov_cus']")
    private WebElement submenuProviders;

    @FindBy(xpath=".//*[@class='pull-left image]")
            private WebElement avatar;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isAvatarDisplayed(){
        return actionWithWebElements.isElemenDisplayed(avatar);
    }

    public void checkIsAvatarPresent(){
        Assert.assertTrue("Avatar is not displayed",isAvatarDisplayed());
    }

    public void clickOnSubmenuProviders(){
        actionWithWebElements.clickButton(submenuProviders);
    }
}
