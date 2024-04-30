package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base_Setup {
    private static WebDriver driver;
    private final Properties properties;
    public WebDriver getDriver(){
        return driver;
    }
    public Base_Setup(){
        try{
            String FilePath = System.getProperty("user.dir")+"/src/test/java/Resources/Config/Application_Config.properties";
            File PropertyFile = new File(FilePath);
            FileInputStream fileInputStream = new FileInputStream(PropertyFile);
            properties = new Properties();
            properties.load(fileInputStream);
            // this initializes a Properties object with key-value pairs from a properties file located in the project's directory structure
        }
        catch(IOException ex){
            throw new RuntimeException("Config file is not accessible "+ ex.getMessage());
        }
    }
    public void OpenBrowser(){
        String insuranceUrl = this.properties.getProperty("ui.url");
        String browser = this.properties.getProperty("ui.browser");
        boolean isHeadless = Boolean.parseBoolean(this.properties.getProperty("ui.isHeadless"));

        if (browser.equalsIgnoreCase("chrome") ){
            ChromeOptions chromeOptions = new ChromeOptions();
            if(isHeadless) chromeOptions.addArguments("--headless");
            driver = new ChromeDriver(chromeOptions);
        }
        else if(browser.equalsIgnoreCase("edge")){
            EdgeOptions edgeOptions = new EdgeOptions();
            if(isHeadless) edgeOptions.addArguments("--headless");
            driver = new EdgeDriver(edgeOptions);
        }
        else if (browser.equalsIgnoreCase("firefox")){
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            if(isHeadless) firefoxOptions.addArguments("--headless");
            driver = new FirefoxDriver(firefoxOptions);
        }
        else{
            throw new RuntimeException("Browser not recognised");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(insuranceUrl);
        }
        public void QuitBrowser(){
        if(driver !=null){
            driver.quit();
        }
        }
    }

