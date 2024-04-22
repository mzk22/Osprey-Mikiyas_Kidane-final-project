package Pages;

import Utilities.Selenium_Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page extends Selenium_Utilities {

    public Home_Page(){
        PageFactory.initElements(getDriver(),this);
    }

    @FindBy(xpath = "/html/head/title")
    public WebElement homeTitle;
    @FindBy(xpath = "//a[@href='/add-primary-account']")
    public WebElement createPrimaryAccountBtn;
    @FindBy(xpath="//a[contains(@href,'/login')]")
    public WebElement loginBtn;
    @FindBy(css = "a[aria-label='home']")
    public  WebElement homePageLink;
}
