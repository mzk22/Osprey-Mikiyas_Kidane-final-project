package Pages;

import Base.Base_UI_Test;
import Utilities.Selenium_Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class User_Profile_Page extends Selenium_Utilities {
    public User_Profile_Page() {
        PageFactory.initElements(getDriver(), this);
    }
    @FindBy(xpath="//div/button[@aria-label='profile']")
    public WebElement profileButton;
    @FindBy(xpath="//p[text()='Supervisor']")
    public WebElement profileFName;
    @FindBy(xpath="//p[text()='supervisor']")
    public WebElement profileUName;
    @FindBy(xpath="//p[text()='CSR']")
    public WebElement userType;
    @FindBy(xpath="//li[text()='admin']")
    public WebElement authorities;
    @FindBy(xpath="//button[text()='Logout']")
    public WebElement profileLogoutBtn;
    @FindBy(xpath="//div/a[text()='Plans']")
    public WebElement plansBtn;
}
