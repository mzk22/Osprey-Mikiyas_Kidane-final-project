package Pages;

import Base.Base_UI_Test;
import Utilities.Selenium_Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Plans_Page extends Selenium_Utilities {
    public Plans_Page() {
        PageFactory.initElements(getDriver(), this);
    }
    @FindBy(xpath = "//div/table/tbody")
    public WebElement table;
    @FindBy(xpath = "//div/table/tbody/tr")
    public WebElement planRows;
    @FindBy(xpath="//div/table/tbody/tr/td[4]")
    public WebElement planDateCreated;
    @FindBy(xpath="//div/table/tbody/tr/td[5]")
    public WebElement planDateExpired;
}
