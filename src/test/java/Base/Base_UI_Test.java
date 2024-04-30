package Base;

import Pages.*;
import Utilities.Selenium_Utilities;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerAdapter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({ExtentITestListenerAdapter.class})
public class Base_UI_Test extends Selenium_Utilities {
    public Home_Page homePage;
    public Login_Page loginPage;
    public Create_Account_Page createAccountPage;
    public User_Profile_Page userProfilePage;
    public Plans_Page plansPage;
    public Accounts_Page accountsPage;

    @BeforeMethod
    public void beginTestMethod(){
        //super allows you to use methods from the parent class
        super.OpenBrowser();
        //instantiates objects of the page classes and assigns them to variables
        homePage = new Home_Page();
        loginPage = new Login_Page();
        createAccountPage = new Create_Account_Page();
        userProfilePage = new User_Profile_Page();
        plansPage = new Plans_Page();
        accountsPage = new Accounts_Page();
    }
    @AfterMethod
    public void endTestMethod(ITestResult result){
        if(result.getStatus()==ITestResult.FAILURE){
            TakesScreenshot screenShot = (TakesScreenshot) getDriver();
            String screenshot = screenShot.getScreenshotAs(OutputType.BASE64);
            ExtentTestManager.getTest().fail("Screenshot Failed",
                    MediaEntityBuilder.createScreenCaptureFromBase64String
                            (screenshot).build());
        }
        super.QuitBrowser();
    }
}
