package Pages;

import Utilities.Selenium_Utilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Create_Account_Page extends Selenium_Utilities {
    public Create_Account_Page() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(id = "email")
    public WebElement emailInput;
    @FindBy(id = "firstName")
    public WebElement firstNameInput;
    @FindBy(id = "lastName")
    public WebElement lastNameInput;
    @FindBy(id = "employmentStatus")
    public WebElement employmentStatusInput;
    @FindBy(id = "gender")
    public WebElement genderSelect;
    @FindBy(id = "title")
    public WebElement titleSelect;
    @FindBy(id = "maritalStatus")
    public WebElement maritalStatusSelect;
    @FindBy(id = "dateOfBirth")
    public WebElement dobSelect;
    @FindBy(xpath = "//button[text()='Create Account']")
    public WebElement createAccountButton;
    @FindBy(xpath = "//h2[contains(text(),'Sign up')]")
    public WebElement signupAccountLabel;
    @FindBy(xpath = "//div/h2[3]")
    public WebElement emailAddressLabel;
    @FindBy(xpath = "//div[contains(text(),'Account with email')]")
    public WebElement accountCreateErrorMsg;
    @FindBy(xpath = "//h2[contains(text(),'Create Primary Account Holder')]")
    public WebElement createAccountFormTitle;
}
