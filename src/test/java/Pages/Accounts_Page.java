package Pages;

import Utilities.Selenium_Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Accounts_Page extends Selenium_Utilities {
    public Accounts_Page() {
        PageFactory.initElements(getDriver(), this);
    }
    //is used to initialize the web elements defined in the current page class using the WebDriver instance obtained from getDriver().
    @FindBy(css="a[href='/csr/accounts']")
    public WebElement accountsBtn;
    @FindBy(css = "tbody.css-0")
    public WebElement table;
    @FindBy(css = "tbody>tr.css-0")
    public WebElement accountRows;
    @FindBy(css="div.chakra-select__wrapper")
    public WebElement recordsPerPage;
}
