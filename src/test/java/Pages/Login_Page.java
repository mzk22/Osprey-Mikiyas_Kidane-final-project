package Pages;

import Base.Base_UI_Test;
import Utilities.Selenium_Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_Page extends Selenium_Utilities {
    public Login_Page() {
        PageFactory.initElements(getDriver(), this);
    }
    @FindBy(xpath="//h2[text()='Customer Service Portal']")
    public WebElement CSPLabel;
    @FindBy(xpath="//button[text()='Sign In']")
    public WebElement signInButton;
    @FindBy(name="username")
    public WebElement usernameInput;
    @FindBy(name="password")
    public WebElement passwordInput;
    @FindBy(xpath="//button[text()='Clear Form']")
    public WebElement clearButton;
    @FindBy(xpath="//div[text()='ERROR']")
    public WebElement invalidCredentialsErrorMsg;

    public void validCSRLogin(){
        sendData(usernameInput,"supervisor");
        sendData(passwordInput,"tek_supervisor");
        clickElement(signInButton);
    }
}
