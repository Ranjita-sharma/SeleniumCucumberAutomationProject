package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtility {
    public static WebDriver LaunchBrowser(WebDriver driver,String browserName,String url)throws InterruptedException{
        if(browserName.equals("Chrome"))
        {
            System.setProperty("webdriver.chrome.driver","C:\\Users\\USER\\IdeaProjects\\SeleniumCucumberAutomationProject\\Selenium_Drivers");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(url);
            Thread.sleep(5000);
            return driver;
        }else
            if(browserName.equals("Edge")){
                System.setProperty("webdriver.edge.driver","C:\\Users\\USER\\IdeaProjects\\SeleniumCucumberAutomationProject\\Selenium_Drivers");
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.get(url);
                Thread.sleep(5000);
                return driver;
            }
            else if(browserName.equals("Firefox")){
                System.setProperty("webdriver.firefox.driver","C:\\Users\\USER\\IdeaProjects\\SeleniumCucumberAutomationProject\\Selenium_Drivers");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                driver.get(url);
                Thread.sleep(5000);
                return driver;
            }
            return null;
    }
}
