package Utilities;

import Base.Base_Setup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.time.Duration;
import java.util.List;

public class Selenium_Utilities extends Base_Setup {

    private static final Logger LOGGER = LogManager.getLogger(Selenium_Utilities.class);

    public WebDriverWait getWait(){
        return new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    }
    public WebElement waitForVisibility(WebElement element){
        LOGGER.info("Waiting for {} element to be visible",element);
        return getWait().until(ExpectedConditions.visibilityOf(element));
    }
    public WebElement waitForClickable(WebElement element){
        LOGGER.info("Waiting for {} element to be clickable",element);
        return getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public void clickElement(WebElement element){
        LOGGER.info("Clicked on {}",element);
        waitForClickable(element).click();
    }
    public void sendData(WebElement element, String data){
        LOGGER.info("Sent data to {} with value {}",element,data);
        waitForVisibility(element).sendKeys(data);
    }
    public String getData(WebElement element){
        LOGGER.info("Getting data from {} element",element);
        return waitForVisibility(element).getText();
    }
    public boolean isElementDisplayed(WebElement element){
        LOGGER.info("Checking if {} element is displayed",element);
        return waitForVisibility(element).isDisplayed();
    }
    public boolean isElementEnabled(WebElement element){
        LOGGER.info("Checking if {} element is enabled",element);
        return waitForVisibility(element).isEnabled();
    }
    public String getTitle(){
        return getDriver().getTitle();
    }
    public void dropdownSelect(WebElement element, String element2){
        LOGGER.info("Clicking on {} dropdown and selecting {}",element,element2);
        WebElement select = waitForClickable(element);
        List<WebElement> options = select.findElements(By.tagName("option"));
        for (WebElement option : options) {
            if(element2.equals(option.getText()))
                option.click();
        }
    }
    public int countPlanRows(){
        LOGGER.info("Counting the number of rows");
        int count = 0;
        WebElement table = getDriver().findElement(By.xpath("//div/table/tbody"));
        List<WebElement> list = table.findElements(By.xpath("//div/table/tbody/tr"));
        for (WebElement li : list) {
            count = count+1;
        }
        return count;
    }
    public int countAccountRows(){
        LOGGER.info("Counting the number of rows");
        int count = 0;
        WebElement table = getDriver().findElement(By.cssSelector("tbody.css-0"));
        List<WebElement> list = table.findElements(By.cssSelector("tbody>tr.css-0"));
        for (WebElement li : list) {
            count = count+1;
        }
        return count;
    }

    @DataProvider(name = "CsrAccountCredentials")
    public String[][] csrCredentials() {
        String[][] data = {
                {"supervisor", "tek_supervisor"},
        };
        return data;
    }
}
