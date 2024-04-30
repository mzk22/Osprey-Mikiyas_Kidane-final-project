package Test;

import Base.Base_UI_Test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AccountsTest extends Base_UI_Test {

    @Test
    public void validatingDefaultRows(){
        clickElement(homePage.loginBtn);
        loginPage.validCSRLogin();
        clickElement(accountsPage.accountsBtn);
        Assert.assertEquals(countPlanRows
                (),5,"The number of default rows is incorrect, it should be 5");
    }

    @Test
    public void changingRowCount(){
        clickElement(homePage.loginBtn);
        loginPage.validCSRLogin();
        waitForClickable(accountsPage.accountsBtn).click();
        dropdownSelect(accountsPage.recordsPerPage, "Show 10");
        Assert.assertEquals(countAccountRows()
                ,10,"The number of rows is incorrect, it should be 10");
        dropdownSelect(accountsPage.recordsPerPage, "Show 25");
        Assert.assertEquals(countAccountRows()
                ,25,"The number of rows is incorrect, it should be 25");
        dropdownSelect(accountsPage.recordsPerPage, "Show 50");
        Assert.assertEquals(countAccountRows()
                ,50,"The number of rows is incorrect, it should be 50");
    }
}
