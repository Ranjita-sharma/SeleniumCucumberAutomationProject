//package listeners;
//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.markuputils.ExtentColor;
//import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import org.openqa.selenium.WebDriver;
//
//public class ExtentReportListener {
//
//    public static ExtentHtmlReporter report = null;
//    public  static ExtentReports extent = null;
//    public  static ExtentTest test = null;
//
//    public static ExtentReports setUp(){
//       String reportLocation = "./Reports/Extent_Report.html";
//       report = new ExtentHtmlReporter(reportLocation);
//       report.config().setDocumentTitle("Lendo");
//       report.config().setReportName("Cucumber BDD Automation Test Report");
//       report.config().setTheme(Theme.STANDARD);
//        System.out.println("Extent Report location initialized...");
//        report.start();
//        extent = new ExtentReports();
//        extent.attachReporter(report);
//        extent.setSystemInfo("Application","Lendo");
//        extent.setSystemInfo("Operating System",System.getProperty("os.name"));
//        extent.setSystemInfo("User Name",System.getProperty("user.name"));
//        System.out.println("System info. set in Extent Report");
//        return extent;
//    }
//    public static void testStepHandle(String teststatus, WebDriver driver,ExtentTest extentTest,Throwable throwable ){
//        switch (teststatus){
//            case "FAIL":
//                extentTest.fail(MarkupHelper.createLabel("Test case is failed :", ExtentColor.RED));
//                extentTest.error(throwable.fillInStackTrace());
//                if(driver!=null){
//                    driver.quit();
//                }
//                break;
//            case "PASS":
//                extentTest.pass(MarkupHelper.createLabel("Test case is passed :", ExtentColor.GREEN));
//                break;
//            default:
//                break;
//        }
//    }
//}
