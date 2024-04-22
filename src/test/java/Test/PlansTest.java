package Test;

import Base.Base_UI_Test;
import Pages.Home_Page;
import Pages.Plans_Page;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class PlansTest extends Base_UI_Test {

    LocalDate date= LocalDate.now();
    DateTimeFormatter format =  DateTimeFormatter.ofPattern("MMMM d, yyyy");
    String currentDate = date.format(format);
    String futureDate = LocalDate.from(date).plusDays(1).format(format);


    @Test
    public void rowValidation(){
        clickElement(homePage.loginBtn);
        loginPage.validCSRLogin();
        clickElement(userProfilePage.plansBtn);
        Assert.assertEquals(countPlanRows
                (),4,"The number of rows is incorrect, there should be 4 rows");
    }


    @Test
    public void dateValidation(){
        clickElement(homePage.loginBtn);
        loginPage.validCSRLogin();
        clickElement(userProfilePage.plansBtn);
        String dateCreated = getData(plansPage.planDateCreated);
        Assert.assertEquals(dateCreated,currentDate,"Incorrect date of creation");
        String dateExpired = getData(plansPage.planDateExpired);
        Assert.assertEquals(dateExpired,futureDate,"Incorrect date of expiration");
    }
}
