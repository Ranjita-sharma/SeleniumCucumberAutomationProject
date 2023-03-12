package AppHooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import qaFactory.DriverFactory;
import util.ConfigReader;

import java.io.IOException;
import java.util.Properties;

public class GeneralHooks {
    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;

    //private static CustomExtentReporter customExtentReporter;
    //private static ExtentReportListener customExtentReporter;
    private static boolean isReporterRunning;
    //1.Create a public method
    //2. Use Before and After annotations with the methods
    //3.Specify the package in the runner
    //4.Inject the scenario object in the hook method

    @Before (order = 0)
    public void getProperty(){
       configReader = new ConfigReader();
       prop = configReader.init_prop();
    }
    @Before (order = 1)
    public void LaunchBrowser(){
        String browserName = prop.getProperty("browser");
        driverFactory = new DriverFactory();
        driver = driverFactory.init_driver(browserName);
    }
    @Before
    public void beforeScenario(Scenario scenario){
//        if(!isReporterRunning){
//            customExtentReporter = new CustomExtentReporter("C:\\Ranjita\\log\\TestReport.html");
//            isReporterRunning = true;
//        }
    }
    @After (order = 0)
    public void quiteBrowser(){
        driver.quit();
    }

    @After (order = 1)
    public void tearDown(Scenario scenario) throws IOException {
        String screenshotName = "C:\\Ranjita\\log\\" + scenario.getName().replaceAll(" ", "_");
        if(scenario.isFailed()) {
            //take screenshot:
          byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(sourcePath, "image/png", screenshotName);
        }
      //  customExtentReporter.createTest(scenario,screenshotName);
        //customExtentReporter.writeToReport();

    }
}
