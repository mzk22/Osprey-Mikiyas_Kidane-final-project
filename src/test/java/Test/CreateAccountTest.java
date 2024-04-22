package Test;

import Base.Base_UI_Test;
import Utilities.Random_Data_Utilities;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateAccountTest extends Base_UI_Test {

    @DataProvider(name="existingData")
    private String[][] existingData(){
        String[][] data = {
                {"apptest@gmail.com","John","Smith","Mr.","Male","Single","Employed","01012001"}
        };
        return data;
    }
    public void accountCreationForm
    (String email, String fName, String lName, String title,String gender, String marStat, String empStat, String dob){
        sendData(createAccountPage.emailInput, email);
        sendData(createAccountPage.firstNameInput, fName);
        sendData(createAccountPage.lastNameInput, lName);
        dropdownSelect(createAccountPage.titleSelect,title );
        dropdownSelect(createAccountPage.genderSelect,gender);
        dropdownSelect(createAccountPage.maritalStatusSelect,marStat);
        sendData(createAccountPage.employmentStatusInput, empStat);
        sendData(createAccountPage.dobSelect,dob);
        clickElement(createAccountPage.createAccountButton);
    }

    @Test
    public void goToCreateAccountPage(){

        clickElement(homePage.createPrimaryAccountBtn);
    }


    @Test
    public void validateCreateAccountPage(){
        clickElement(homePage.createPrimaryAccountBtn);
        String title = getData(createAccountPage.createAccountFormTitle);
        Assert.assertEquals(title,"Create Primary Account Holder","Error, create account page hasn't been loaded.");
    }


    @Test(dataProvider="existingData")
    public void validateSignupSuccess(
            String email, String fName, String lName, String title,String gender, String marStat, String empStat, String dob){
        clickElement(homePage.createPrimaryAccountBtn);
        accountCreationForm
                (Random_Data_Utilities.randomEmail(email),fName,lName,title,gender,
                        marStat,empStat,dob );
        clickElement(createAccountPage.createAccountButton);
        boolean check = isElementDisplayed(createAccountPage.signupAccountLabel);
        Assert.assertTrue(check,"The label does not show up");
        boolean emailCheck =  isElementDisplayed(createAccountPage.emailAddressLabel);
        Assert.assertTrue(emailCheck,"Email address isn't visible");
    }

    @Test(dataProvider = "existingData")
    public void existingAccountCreationForm(
            String email, String fName, String lName, String title, String gender, String marStat, String empStat, String dob){
            clickElement(homePage.createPrimaryAccountBtn);
            accountCreationForm
                    (email,fName,lName,title,gender,
                            marStat,empStat,dob );
            clickElement(createAccountPage.createAccountButton);
        boolean error = isElementDisplayed(createAccountPage.accountCreateErrorMsg);
        Assert.assertTrue(error,"Error message should be displayed");
    }
}
