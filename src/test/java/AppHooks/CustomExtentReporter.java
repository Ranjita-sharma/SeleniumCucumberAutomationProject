package AppHooks;


import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.Result;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

public class CustomExtentReporter {

    private final ExtentHtmlReporter extentHtmlReporter;
    private final ExtentReports extentReports;

    public CustomExtentReporter(String reportLocation) {
        extentHtmlReporter = new ExtentHtmlReporter(new File(reportLocation));
        extentReports = new ExtentReports();
        extentReports.setAnalysisStrategy(AnalysisStrategy.TEST);
        extentReports.attachReporter(extentHtmlReporter);
    }

    public void createTest(Scenario scenario, String screenshotFile) throws IOException {
        if (scenario != null) {
            String testName = getScenarioTitle(scenario);

            switch (scenario.getStatus()) {
                case PASSED:
                    extentReports.createTest(testName).pass("Passed");
                    break;
                case FAILED:
                    String errorMsg = getErrorMessage(scenario);
                    extentReports.createTest(testName).fail(errorMsg).addScreenCaptureFromPath(getScreenShotLocation(screenshotFile));
                    break;

                default:
                    extentReports.createTest(testName).skip("Skipped");
            }
        }
    }

    private String getErrorMessage(Scenario scenario) {
        List<Result> testResultList = null;
        List<Result> failedStepList = null;

        try {
            Field stepResults = scenario.getClass().getDeclaredField("stepResults");
            stepResults.setAccessible(true);
            testResultList = (List<Result>) stepResults.get(scenario);
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }

        if (testResultList != null && !testResultList.isEmpty()) {
            failedStepList = testResultList.stream().filter((x) -> {
                return x.getError().getMessage() != null;
            }).collect(Collectors.toList());
        }
        if(failedStepList != null && !failedStepList.isEmpty()){
            return failedStepList.get(0).getError().getMessage();
        }
        return "";
    }

        public void writeToReport () {
            if (extentReports != null) {
                extentReports.flush();
            }
        }
    private String getScreenShotLocation(String aLocation) {
        return "file:///" + aLocation.replace("\\", "//");

        }
        public String getScenarioTitle (Scenario scenario){
            return scenario.getName().replaceAll(" ", "");
        }
    }
