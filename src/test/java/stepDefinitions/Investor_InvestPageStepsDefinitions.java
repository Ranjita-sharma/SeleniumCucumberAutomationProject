package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.Investor.Investor_InvestPage;
import pages.Investor.Investor_OverviewPage;
import pages.LoginPage;
import qaFactory.DriverFactory;

import java.util.List;
import java.util.Map;

public class Investor_InvestPageStepsDefinitions {
    private final LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private final Investor_OverviewPage investor_OverviewPage = new Investor_OverviewPage(DriverFactory.getDriver());
    private final Investor_InvestPage investor_investPage = new Investor_InvestPage(DriverFactory.getDriver());

  //  private Investor_InvestPage investor_investPage;
   // private Investor_OverviewPage investor_OverviewPage;

    @Given("user has already logged into application and verify Invest Link")
    public void userHasAlreadyLoggedIntoApplicationAndVerifyInvestLink(DataTable credTable) throws Exception {
        List<Map<String,String>> credList = credTable.asMaps();
        String email =  credList.get(0).get("email");
        String password =  credList.get(0).get("password");

        DriverFactory.getDriver().get("http://stg.consumerclient.newlendo.com/");
        loginPage.doLoginSuccessfully(email,password,1111);
    }
    //Scenario : Redirect to Invest page and Click on Invest setting button
    @When("^click on Invest menu link$")
    public void click_on_invest_menu_link()  {
        investor_investPage.userClickOnInvestMenuLink();
    }
    @And("user is on Invest page and verify that page heading text should be as {string}")
    public void userIsOnInvestPageAndVerifyThatPageHeadingTextShouldBeAs(String expectedHeadingText) throws InterruptedException {
        String getAutoInvestmentText=  Investor_InvestPage.getTheAutoInvestmentTextOnInvestPage();
        Assert.assertEquals(getAutoInvestmentText,expectedHeadingText);
    }
    @And("^user click on ViewSetting button$")
    public void user_click_on_viewsetting_button() throws InterruptedException {
        Investor_InvestPage.verifyAndClickOnViewSettingBtn();
        Thread.sleep(2000);

    }
    @And("user redirect on setting page and verify the page heading text should be as {string}")
    public void userRedirectOnSettingPageAndVerifyThePageHeadingTextShouldBeAs(String expectedHeadingText) {
        String getAutoInvestmentTextOnSettingPage=  Investor_InvestPage.getTheAutoInvestmentTextOnSettingPage();
        Assert.assertEquals(getAutoInvestmentTextOnSettingPage,expectedHeadingText);
    }
    @Then("verify the success fees percentage text should be displayed as {string}")
    public void verifyTheSuccessFeesPercentageTextShouldBeDisplayedAs(String expectedSuccessFeesText) {
        String getAutoInvestSuccessFeePercText=  Investor_InvestPage.getTheAutoInvestSuccessFeesPercText();
        Assert.assertEquals(getAutoInvestSuccessFeePercText,expectedSuccessFeesText);
    }
    //Scenario:Activate the Auto-invest toggle feature
   @Then("user click on toggle to activate the Auto invest feature")
    public void userClickOnToggleToActivateTheAutoInvestFeature() throws InterruptedException {
    Investor_InvestPage.verifyAndClickOnToggleButton();
    Thread.sleep(2000);
   }


    @Then("verify the alert popup text as {string} with {string} and {string} buttons")
    public void verifyTheAlertPopupTextAsWithAndButtons(String expectedPopupText, String yes, String cancel) {
         boolean isPopupAvailablewithYesBtn = Investor_InvestPage.VerifyYesBtnOnPoup(yes);
          System.out.println("Popup is available with Yes button : " + isPopupAvailablewithYesBtn);
      boolean isPopupAvailablewithCancelBtn = Investor_InvestPage.VerifyCancelBtnOnPoup(cancel);
        System.out.println("Popup is available with Cancel button : " + isPopupAvailablewithCancelBtn);
        String popup_txt = Investor_InvestPage.userGetThePopupTextAfterToggleAction();
        System.out.println("Popup text should be as : " + popup_txt );
        Assert.assertEquals(popup_txt,expectedPopupText);
       }

    @And("user click on Cancel button")
    public void userClickOnCancelButton() {
        Investor_InvestPage.userClickOnCancelButton();
    }

    @Then("user should be on same page without any changes")
    public void userShouldBeOnSamePageWithoutAnyChanges() {
       String txt_successFeePct =  Investor_InvestPage.getTheAutoInvestSuccessFeesPercText();
       Assert.assertNotNull(txt_successFeePct);
    }
    @And("user click again on toggle to activate the Auto invest feature")
    public void userClickAgainOnToggleToActivateTheAutoInvestFeature() throws InterruptedException {
        Investor_InvestPage.verifyAndClickOnToggleButton();
        Thread.sleep(2000);
    }
    @And("user click on Yes button")
    public void userClickOnYesButton() throws InterruptedException {
        Investor_InvestPage.userClickOnYesButton();
        Thread.sleep(2000);
    }

    @Then("verify the alert popup text as {string} with OK button")
    public void verifyTheAlertPopupTextAsWithOKButton(String expectedPopupText) throws InterruptedException {
      String actualTxt =   Investor_InvestPage.userGetThePopupText();
      Assert.assertEquals(actualTxt,expectedPopupText);
        Thread.sleep(2000);
    }

    @And("user click on Ok button")
    public void userClickOnOkButton() {
        Investor_InvestPage.userClickOnOkButton();
    }
    @Then("popup should be gone and Auto invest feature should be activated")
    public void popupShouldBeGoneAndAutoInvestFeatureShouldBeActivated() throws InterruptedException {
      boolean activatedToggleTxt =   Investor_InvestPage.verifyActivatedToggle();
      Assert.assertTrue(activatedToggleTxt);
        System.out.println("Auto invest is activated : " + activatedToggleTxt);
    }
    @And("user gets the Strategy text {string}")
    public void userGetsTheText(String expectedStrategyText) {
      String actualStrategytxt =   Investor_InvestPage.userGetTheSelectStrategyText();
      Assert.assertEquals(actualStrategytxt,expectedStrategyText);
    }
    @And("verify each strategy text and their information")
    public void verifyEachStrategyTextAndTheirInformation() throws InterruptedException {
     Investor_InvestPage.verifyAndSelectAnyStrategy();
     }
    @And("user gets the Max Invest text as {string}")
    public void userGetsTheTextAs(String expectedMaxText) {
       String actualMaxText = Investor_InvestPage.userGetTheMaxInvestLoanText();
       System.out.println("Get the Actual Max Invest Loan text is : " + actualMaxText);
       Assert.assertEquals(actualMaxText,expectedMaxText,"Maximum Investment Per Loan text is not matching");
    }
    @And("user gets the Loan duration text as {string}")
    public void userGetsTheLoanDurationTextAs(String expectedLoanDurationText) {
        String actualLoanDuraText = Investor_InvestPage.userGetTheLoanDuraText();
        System.out.println("Get the loan duration `text is : " + actualLoanDuraText);
        Assert.assertEquals(actualLoanDuraText,expectedLoanDurationText,"Loan Duration text is not matching");
    }
    @And("verify the functionality of Min & Max Investment per loan field")
    public void verifyTheFunctionalityOfMinInvestmentPerLoanField() throws InterruptedException {
        Investor_InvestPage.validateMinMaxLoanDurationField();
    }
    @Then("user gets the questions heading text as {string}")
    public void userGetsTheQuestionsHeadingTextAs(String expectedHeadingText) throws InterruptedException {
      String actualHeadingText =  Investor_InvestPage.userGetTheHeadingText();
        System.out.println("Questions heading text display as : " + actualHeadingText);
        Assert.assertEquals(actualHeadingText,expectedHeadingText);
    }
    @And("verify the first Auto Invest questions as {string}")
    public void verifyTheFirstAutoInvestQuestionsAs(String expectedFirstQuestionTxt) throws InterruptedException {
        String actualFirstQuestionText =  Investor_InvestPage.verifyTheFirstAutoInvestQuestion();
        System.out.println("first Auto Invest question display as : " + actualFirstQuestionText);
        Assert.assertEquals(actualFirstQuestionText,expectedFirstQuestionTxt);
      }
    @Then("click on arrow to expand the view and verify the first answer")
    public void clickOnArrowToExpandTheViewAndVerifyTheFirstAnswer() throws InterruptedException {
        String actualFirstAnsText = Investor_InvestPage.verifyTheFirstAutoInvestAnswer();
        System.out.println("First Question Answer text display as : " + actualFirstAnsText);
        Assert.assertNotNull(actualFirstAnsText, "First Auto invest answer is null");
    }
    @And("verify the second Auto Invest questions as {string}")
    public void verifyTheSecondAutoInvestQuestionsAs(String expectedFirstQuestionTxt) throws InterruptedException {
        String actualFirstQuestionText =  Investor_InvestPage.verifyTheSecondAutoInvestQuestion();
        System.out.println("Questions heading text display as : " + actualFirstQuestionText);
        Assert.assertEquals(actualFirstQuestionText,expectedFirstQuestionTxt);
    }
    @Then("click on arrow to expand the view and verify the second answer")
    public void clickOnArrowToExpandTheViewAndVerifyTheSecondAnswer() throws InterruptedException {
        String actualSecondAnsText = Investor_InvestPage.verifyTheSecondAutoInvestAnswer();
        System.out.println("Second Question Answer text display as : " + actualSecondAnsText);
        Assert.assertNotNull(actualSecondAnsText, "Second Auto invest answer is null");
    }
    @And("verify the third Auto Invest questions as {string}")
    public void verifyTheThirdAutoInvestQuestionsAs(String expectedFirstQuestionTxt) throws InterruptedException {
        String actualFirstQuestionText =  Investor_InvestPage.verifyTheThirdAutoInvestQuestion();
        System.out.println("Questions heading text display as : " + actualFirstQuestionText);
        Assert.assertEquals(actualFirstQuestionText,expectedFirstQuestionTxt);
    }
    @Then("click on arrow to expand the view and verify the third answer")
    public void clickOnArrowToExpandTheViewAndVerifyTheThirdAnswer() throws InterruptedException {
        String actualThirdAnsText = Investor_InvestPage.verifyTheThirdAutoInvestAnswer();
        System.out.println("Third Question Answer text display as : " + actualThirdAnsText);
        Assert.assertNotNull(actualThirdAnsText, "Third Auto invest answer is null");
    }
}

