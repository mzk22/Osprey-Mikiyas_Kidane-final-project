package Test;

import Base.Base_UI_Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UserProfileTest extends Base_UI_Test {

    @DataProvider(name="csrData")
    private String[][] csrData(){
        String[][] data = {
                {"Supervisor"}
        };
        return data;
    }
@Test(dataProvider = "csrData")
public void profileSideDrawerValidation(String uname){
//These are all compared to string values because there is only one CSR account
    clickElement(homePage.loginBtn);
    loginPage.validCSRLogin();
    clickElement(userProfilePage.profileButton);
    String proFNameCheck = getData(userProfilePage.profileFName);
    Assert.assertEquals(proFNameCheck,"Supervisor");
    String uNameCheck = getData(userProfilePage.profileFName);
    Assert.assertEquals(uNameCheck,uname);
    String uTypeCheck = getData(userProfilePage.userType);
    Assert.assertEquals(uTypeCheck,"CSR");
    String authorityCheck = getData(userProfilePage.authorities);
    Assert.assertEquals(authorityCheck,"admin");
}

@Test
public void logoutBtnTest(){
    clickElement(homePage.loginBtn);
    loginPage.validCSRLogin();
    clickElement(userProfilePage.profileButton);
    clickElement(userProfilePage.profileLogoutBtn);
    Assert.assertEquals(getTitle(),"Tek Insurance UI","Home page has not been loaded");
}
}
