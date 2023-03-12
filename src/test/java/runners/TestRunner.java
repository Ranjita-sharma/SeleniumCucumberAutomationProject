package runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/AppFeatures/Investor_InvestPage.feature"},
        glue = {"stepDefinitions","AppHooks"},
              // monochrome = true,
        plugin = {"pretty",
                "html:target/HTMLReport","json:target/JsonReport/JsonReport.json","junit:target/junitReport/junitReport.xml"},
        tags = "@UATTesting",
        monochrome = true)

public class TestRunner extends AbstractTestNGCucumberTests {
}


