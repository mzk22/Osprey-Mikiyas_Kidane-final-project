package Test;

import Base.Base_UI_Test;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends Base_UI_Test {
    @Test
    public void checkPageTitle() {
        getTitle();
        Assert.assertEquals(getTitle(),"Tek Insurance UI","Error, home page hasn't been loaded.");
    }
    @Test
    public void checkCreateAccountButton(){
        boolean checkButton = isElementEnabled(homePage.createPrimaryAccountBtn);
        Assert.assertTrue(checkButton,"Error, create account button is not enabled.");
    }
}
