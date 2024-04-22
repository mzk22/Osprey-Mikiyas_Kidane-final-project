package Test;

import Base.Base_UI_Test;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends Base_UI_Test {

    @Test
    public void invalidCredentials(){
        clickElement(homePage.loginBtn);
        sendData(loginPage.usernameInput,"supervisor");
        sendData(loginPage.passwordInput,"11111111");
        clickElement(loginPage.signInButton);
        Boolean errMsgCheck = isElementDisplayed(loginPage.invalidCredentialsErrorMsg);
        Assert.assertTrue(errMsgCheck,"Error Message isn't displayed.");
        clickElement(loginPage.clearButton);
        sendData(loginPage.usernameInput,"1*1*1*1*");
        sendData(loginPage.passwordInput,"qweqwqeqwe");
        clickElement(loginPage.signInButton);
        Boolean errMsgCheck2 = isElementDisplayed(loginPage.invalidCredentialsErrorMsg);
        Assert.assertTrue(errMsgCheck2,"Error Message isn't displayed.");
    }

    @Test
    public void csrUserLogin(){
        clickElement(homePage.loginBtn);
        sendData(loginPage.usernameInput,"supervisor");
        sendData(loginPage.passwordInput,"tek_supervisor");
        clickElement(loginPage.signInButton);
        boolean cspCheck = waitForVisibility(loginPage.CSPLabel).isDisplayed();
        Assert.assertTrue(cspCheck,"Customer Service Portal page hasn't been loaded.");
    }
}
