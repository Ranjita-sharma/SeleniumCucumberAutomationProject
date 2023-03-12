package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import qaFactory.DriverFactory;

public class  LoginPageStepsDefinitions {
    private static String title;
    private WebDriver driver;
    private final LoginPage loginPage = new LoginPage(DriverFactory.getDriver());

    @Given("user is on login page")
    public void user_is_on_login_page() {
        DriverFactory.getDriver().get("http://stg.consumerclient.newlendo.com/");
    }

    @When("user gets the title of the page")
    public void user_gets_the_title_of_the_page() throws Exception {
        // ExtentTest logInfo = null;
//        try {
//            logInfo = test.createNode(new GherkinKeyword("When"), "user_gets_the_title_of_the_page");
          title = loginPage.getLoginPageTitle();
        System.out.println("Login page title is : " + title);
        Helper.CommonHelper.println("Login page title is with helper class : " + title);
        //  logInfo.pass("user_gets_the_title_of_the_page");
        // takeSnapShot("user_gets_the_title_of_the_page");
//        }catch (AssertionError |Exception e){
//            testStepHandle("FAIL",driver,logInfo, e);
 //   }

}
    @Then("login page title should be {string}")
    public void login_page_title_should_be(String expectedTitleName) throws Exception {
//        ExtentTest logInfo = null;
//        try {
//            logInfo = test.createNode(new GherkinKeyword("Then"), "login page title should be as");
            Assert.assertTrue(title.contains(expectedTitleName));
          //  logInfo.pass("Validated page title");
//        }catch (AssertionError |Exception e){
//            testStepHandle("FAIL",driver,logInfo, e);
//        }
       // takeSnapShot("login_page_title_should_be");
    }
    @Then("I forgot my password link should be displayed")
    public void i_forgot_my_password_link_should_be_displayed() throws Exception {
        boolean isForgotPasswordLinkExist =  loginPage.isForgotPwdLinkExist();
       Assert.assertTrue(isForgotPasswordLinkExist);
        System.out.println("I forgot my password link is available : "+ isForgotPasswordLinkExist);
        //takeSnapShot("i_forgot_my_password_link_should_be_displayed");
    }
    @Then("Don't have an account? link should be displayed")
    public void dont_have_an_account_link_should_be_displayed() throws Exception {
    boolean isDontHaveAnAccountLinkExist = loginPage.isDontHaveAnAccountLinkExist();
    Assert.assertTrue(isDontHaveAnAccountLinkExist);
        System.out.println("Donot have an account link is available : "+ isDontHaveAnAccountLinkExist);
       // takeSnapShot("dont_have_an_account_link_should_be_displayed");
    }
    @When("user enters email {string}")
    public void user_enters_email(String username) throws Exception {
        loginPage.enterEmailId(username);
       // takeSnapShot("user_enters_email");
    }
    @When("user enters password {string}")
    public void user_enters_password(String password) throws Exception {
        loginPage.enterPassword(password);
      //  takeSnapShot("user_enters_password");
    }

    @When("user clicks on Continue button")
    public void user_clicks_on_continue_button() throws InterruptedException {
        loginPage.clickOnContinue();
        Thread.sleep(2000);
    }
    @Then("enter the OTP as {int}")
    public void enter_the_otp_as(Integer int1) throws InterruptedException {
        Thread.sleep(2000);
        loginPage.concurrentLoginPopup();
        loginPage.enterOTP(int1);
        System.out.println("Entered otp is : " + int1);
    }
    @And ("user click on Verify button")
    public void user_clicks_on_Verify_button(){
        loginPage.verifyOTP();
    }
    @When("deposit button label should be displayed as {string}")
    public void deposit_button_label_should_be_displayed_as(String Depositbutton) throws Exception {
        Thread.sleep(5000);
        boolean deposit_btnStatus = loginPage.isButtonDisplayed();
        boolean isBtnEnabled = loginPage.isButtonEnabled();
        System.out.println("Deposit button status is displayed : " + deposit_btnStatus);
        System.out.println("Deposit button status is Enabled : " + isBtnEnabled);
        Assert.assertTrue(deposit_btnStatus);
        Assert.assertTrue(isBtnEnabled);
        Assert.assertSame("Deposit",Depositbutton);
       // takeSnapShot("deposit_button_label_should_be_displayed_as");
    }
   }

