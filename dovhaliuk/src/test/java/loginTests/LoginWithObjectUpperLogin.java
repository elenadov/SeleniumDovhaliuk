package loginTests;

import org.junit.Test;
import parentPage.ParentPage;
import parentTests.AbstractParentTest;

public class LoginWithObjectUpperLogin extends AbstractParentTest {

    @Test
    public void upperCaseLogin(){
        loginPage.openPage();
        loginPage.inputLogin("STUDENT");
        loginPage.inputPassword("909090");
        loginPage.clickSubmitButton();
        checkExpectedResult("Avatar is not present", homePage.isAvatarDisplayed());
    }

}
