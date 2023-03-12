package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import pages.SignUpPage_Investor;
import qaFactory.DriverFactory;

import java.sql.SQLException;

public class SignUp_Investor_PageStepsDefinitions {
    private final LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private final SignUpPage_Investor signupPage = new SignUpPage_Investor(DriverFactory.getDriver());

    @Given("user is on login page and do the registration")
    public void userIsOnLoginPageAndDoTheRegistration() {
        DriverFactory.getDriver().get("http://stg.consumerclient.newlendo.com/");
    }
    @When("user get the link Don't have an account?")
    public void userGetTheLinkDontHaveAnAccount() {
      boolean isAccountCreationLinkExist = SignUpPage_Investor.isDontHaveAnAccountLinkExist();
        System.out.println("Account creation link is exist : " + isAccountCreationLinkExist );
        Assert.assertTrue(isAccountCreationLinkExist);
    }
    @Then("Click on Don't have an account? link")
    public void clickOnDonTHaveAnAccountLink() {
        signupPage.userClickOnDontHaveAnAccountLink();
    }
    @And("verify all the Elements visible on Registration Page")
    public void verifyAllTheElementsVisibleOnRegistrationPage() {
        signupPage.verifyAlltheElementsPresentOnStep1();
    }
    @And("verify when user click on link {string}")
    public void verifyWhenUserClickOnLink(String expectedAccountLinkText) throws InterruptedException {
        signupPage.verifyAndClickOnAlreadyHaveAnAccount(expectedAccountLinkText);
    }
    @Then("user click on Investor icon")
    public void userClickOnInvestorIcon() throws InterruptedException {
        signupPage.verifyAndClickOnInvestorIcon();
    }
    @And("click on Sign up button")
    public void clickOnSignUpButton() {
        signupPage.clickOnSignUpbutton();
    }
    @And("user enter an email")
    public void userEnterAnEmail() {
      signupPage.userEnterTheEmail();
    }
    @And("user enter a password")
    public void userEnterAPassword() {
      signupPage.userEnterThePassword();
    }
    @And("user enter a repeatPassword")
    public void userEnterARepeatPassword() {
        signupPage.userEnterTheRepeatPassword();
    }
    @And("user get the RegistrationStepSecondOfFourthText")
    public void userGetTheRegistrationStepSecondOfFourthText() {
       signupPage.userGetThetextOnStep2();
    }
    @Then("user click on Next button on second step of Registration")
    public void userClickOnNextButtonOnSecondStepOfRegistration() throws InterruptedException {
        signupPage.userClickOnNextButtonOnRegistration();
    }
    @And("user get the RegistrationStepThirdOfFourthText")
    public void userGetTheRegistrationStepThirdOfFourthText() throws InterruptedException {
        signupPage.userGetThetextOnStep3();
    }
    @And("user get the Saudi and Residents icons with links")
    public void userGetTheSaudiAndResidentsIconsWithLinks() {
        signupPage.userGetTheSaudiAndResidentLinkIconsOnStep3();
       }
    @Then("user click on Resident icon")
    public void userClickOnResidentIcon() {
        signupPage.userClickOnTheResidentLinkOnStep3();
    }
    @Then("user select the Nationality as India")
    public void userSelectTheNationalityAsIndia() {
        signupPage.userSelectTheNationalityOnStep3();
    }
    @Then("user enter the IqamaId")
    public void userEnterTheIqamaId() {
       signupPage.userEntertheIqamaIdOnStep3();
    }
    @And("user enter the mobile number")
    public void userEnterTheMobileNumber() {
      signupPage.userEnterThePhoneNumberOnStep3();
    }
    @And("user get the entered mobile number text as {string}")
    public void userGetTheEnteredMobileNumberTextAs(String expectedMobileNumberText) {
        signupPage.userGetTheEnteredMobileNumber(expectedMobileNumberText);
    }
    @And("user get the terms and condition text as {string}")
    public void userGetTheTermsAndConditionTextAs(String expectedTermsAndConditiontext) {
        signupPage.userGetTheTermAndConditionText(expectedTermsAndConditiontext);
    }
    @And("user get the link of terms and condition text as {string}")
    public void userGetTheLinkTermsAndConditionTextAs(String expectedTermsAndConditiontext) {
        signupPage.userGetTheTermAndConditionText(expectedTermsAndConditiontext);
    }
    @And("user click on Terms and Condition link {string}")
    public void userClickOnTermsAndConditionLink(String expectedTermsAndConditionLinkText) throws InterruptedException {
        signupPage.userGetTheLinkTextTermAndCondition(expectedTermsAndConditionLinkText);
        signupPage.userClickOnTheTermAndConditionLink();
    }
    @And("user click on Continue button")
    public void userClickOnContinueButton() throws InterruptedException {
        signupPage.userClickOnContinueButton();
    }
    @Then("user click on Submit button")
    public void userClickOnSubmitButton() throws InterruptedException {
        signupPage.userClickOnSubmitButton();
    }
    @Then("user click on Sign up button")
    public void userClickOnSignUpButton() throws InterruptedException {
      signupPage.userClickOnNextButton();
    }
    @Then("user get the text as {string}")
    public void userGetTheTextAs(String expectedtext) throws InterruptedException {
       signupPage.userGetTheNumberUnderRegisteredIDtextOnStep3(expectedtext);
    }
    @Then("user get the mobile number text as {string}")
    public void userGetTheMobileNumberTextAs(String expectedMobileNum) {
        signupPage.userGetThePhoneNumbertextOnStep3(expectedMobileNum);
    }
    @And("user get the Edit and Confirm buttons on popup")
    public void userGetTheEditAndConfirmButtonsOnPopup() {
        signupPage.userGetTheEditAndConfirmButtons();
    }
    @Then("user click on Confirm button")
    public void userClickOnConfirmButton() throws InterruptedException {
        signupPage.userClickOnConfirmBtn();
    }
    @And("user get the RegistrationStepFourthOfFourthText")
    public void userGetTheRegistrationStepFourthOfFourthText() throws InterruptedException {
        signupPage.userGetThetextOnStep4();
    }
    @And("user get the SMScode text as {string} and enter the OTP")
    public void userGetTheSMScodeTextAsAndEnterTheOTP(String expectedSMSText) {
        signupPage.userEnterTheOTP();
    }
    @Then("user click on Next button on Step fourth")
    public void userClickOnNextButtonOnStepFourth() throws SQLException, InterruptedException {
        signupPage.userClickOnNextButtonOnRegistration();
    }
    @And("user verify the email")
    public void userVerifyTheEmail() throws InterruptedException {
        signupPage.userEmailVerification();
        Thread.sleep(2000);
    }
    @Then("user get the page title as {string}")
    public void userGetThePageTitleAs(String expectedTitleName) throws InterruptedException, SQLException {
//       String getTitle = signupPage.userGetThePageTitle();
//        Assert.assertTrue(getTitle.contains(expectedTitleName));
        signupPage.CleanDataFromDatabase();
    }
    @Then("user get the verification text on dashboard as {string}")
    public void userGetTheVerificationTextOnDashboardAs(String expectedIdentifyText) {
        signupPage.userGetTheVerificationTextOnDashboard(expectedIdentifyText);
    }
    @And("user verify the start button and click on it")
    public void userVerifyTheStartButtonAndClickOnIt() throws InterruptedException {
        signupPage.userVerifyAndClickOnStartBtn();
    }
    @And("user select the DOB as {string}")
    public void userSelectTheDOBAs(String expectedDOB) throws InterruptedException {
        signupPage.userClickandSelectTheDOBDate(expectedDOB);
    }
    @Then("user click on Next button on Verification first step")
    public void userClickOnNextButtonOnVerificationFirstStep() throws InterruptedException {
       signupPage.userClickOnNextButton();
    }
    @And("user get the Verification StepSecondOfSix")
    public void userGetTheVerificationStepSecondOfSix() {
        signupPage.userGetTheVerificationStep2Text();
    }
    @Then("user enter the Absher OTP as {int}")
    public void userEnterTheAbsherOTPAs(int expectedAbsherOTP) {
        signupPage.userEnterTheAbsherOTP(expectedAbsherOTP);
    }
    @Then("user click on Next button on Verification second step")
    public void userClickOnNextButtonOnVerificationSecondStep() throws InterruptedException {
        signupPage.userClickOnNextButton();
    }
    @And("user get the Verification StepThirdOfSix")
    public void userGetTheVerificationStepThirdOfSix() throws InterruptedException {
        signupPage.userGetTheVerificationStep3Text();
    }
     @And("user get the Primary National Address heading text as {string}")
    public void userGetThePrimaryNationalAddressHeadingTextAs(String expectedAddressHeadingText) {
        signupPage.userGetTheNationalAddressHeadingText(expectedAddressHeadingText);
    }
    @Then("user click on Next button on Verification third step")
    public void userClickOnNextButtonOnVerificationThirdStep() throws InterruptedException {
        signupPage.userClickOnNextButton();
    }
    @And("user get the Verification StepFourthOfSix")
    public void userGetTheVerificationStepFourthOfSix() {
        signupPage.userGetTheVerificationStep4Text();
    }
    @And("user select the AnnualIncome")
    public void userSelectTheAnnualIncome() throws InterruptedException {
        signupPage.userSelectTheAnnualIncomeDrodpownValue();
        Thread.sleep(6000);
    }
    @And("user select the Source of Income")
    public void userSelectTheSourceOfIncome() throws InterruptedException {
        signupPage.userSelectTheSourceOfIncomeDrodpownValue();
    }
    @And("user get the tooltip text when mouse hover on Estimated Annual Deposit")
    public void userGetTheTooltipTextWhenMouseHoverOnEstimatedAnnualDeposit() {
        signupPage.getTheToolTipTextOfEstimatedAnnualDeposit();
    }
    @And("user select the Estimated Annual Deposit")
    public void userSelectTheEstimatedAnnualDeposit() {
        signupPage.userSelectTheAnnualDepositDrodpownValue();
    }
    @And("user mouse hover on tooltip of Estimated Annual Investment")
    public void userMouseHoverOnTooltipOfEstimatedAnnualInvestment() {
        signupPage.getTheToolTipTextOfEstimatedAnnualDeposit();
    }
    @And("user select the Estimated Annual Investment")
    public void userSelectTheEstimatedAnnualInvestment() {
        signupPage.userSelectTheAnnualInvestmentDropdownValue();
    }
    @Then("user click on Next button on Verification fourth step")
    public void userClickOnNextButtonOnVerificationFourthStep() throws InterruptedException {
        Thread.sleep(5000);
        signupPage.userClickOnNextButton();
    }
    @And("user select the Job title")
    public void userSelectTheJobTitle() {
        signupPage.userSelectTheJobTitleDrodpownValue();
    }
    @And("user select the Employment Status")
    public void userSelectTheEmploymentStatus() {
        signupPage.userSelectTheEmploymentStatusDrodpownValue();
    }
    @And("user enter the Company Name")
    public void userEnterTheCompanyName() {
        signupPage.userEnterTheCompanyName();
     }
    @And("user select the Nature of Business")
    public void userSelectTheNatureOfBusiness() {
        signupPage.userSelectTheNatureOfBusinessDrodpownValue();
    }
    @And("user click on Next button on fifth step of Verification")
    public void userClickOnNextButtonOnFifthStepOfVerification() throws InterruptedException {
        signupPage.userClickOnNextButton();
    }
    @And("user get the Verification StepSixOfSix")
    public void userGetTheVerificationStepSixOfSix() {
        signupPage.userGetTheVerificationStep6Text();
    }
    @And("user select the question first as No")
    public void userSelectTheQuestionFirstAsNo() {
        signupPage.userSelectTheQ1AsNo();
    }
    @And("user select the question second as No")
    public void userSelectTheQuestionSecondAsNo() {
        signupPage.userSelectTheQ2AsNo();
    }
    @And("user select the question third as No")
    public void userSelectTheQuestionThirdAsNo() {
        signupPage.userSelectTheQ3AsNo();
    }
    @And("user select the question fourth as No")
    public void userSelectTheQuestionFourthAsNo() {
        signupPage.userSelectTheQ4AsNo();
    }
    @Then("user click on Finish button")
    public void userClickOnFinishButton() throws InterruptedException {
        signupPage.userClickOnFinishBtn();
        Thread.sleep(2000);
    }
    @Then("user get the successful verification message on dashboard")
    public void userGetTheSuccessfulVerificationMessageOnDashboard() {
        signupPage.userGetTheSuccessfulVerificationMsg();
    }
    @And("user click on Continue button after successful verification")
    public void userClickOnContinueButtonAfterSuccessfulVerification() throws InterruptedException {
        signupPage.userClickOnContinueButton();
    }
    @And("user get the contract accept banner on dashboard")
    public void userGetTheContractAcceptBannerOnDashboard() throws InterruptedException {
       // PageBase.doPageRefresh();
        Thread.sleep(5000);
        signupPage.userGetTheContractBanner();
    }
    @Then("user click on Read and accept link")
    public void userClickOnReadAndAcceptLink() throws InterruptedException {
        signupPage.userClickOnReadAndAcceptLink();
    }
    @And("user accept the contract")
    public void userAcceptTheContract() throws InterruptedException {
        signupPage.userClickOnAcceptContractBtn();
    }
    @And("user get the under review banner text as {string}")
    public void userGetTheUnderReviewBannerTextAs(String expectedUnderReviewText) {
       signupPage.userGetTheUnderReviewBannerText(expectedUnderReviewText);
    }

}
