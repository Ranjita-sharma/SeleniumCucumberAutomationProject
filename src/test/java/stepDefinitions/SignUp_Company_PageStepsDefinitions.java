package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import pages.SignUpPage_Company;
import qaFactory.DriverFactory;

import java.sql.SQLException;

public class SignUp_Company_PageStepsDefinitions {
    private final LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private final SignUpPage_Company signUpPage_Company = new SignUpPage_Company(DriverFactory.getDriver());

    @Given("user is on login page and do the registration")
    public void userIsOnLoginPageAndDoTheRegistration() {
        DriverFactory.getDriver().get("http://stg.consumerclient.newlendo.com/");
    }
    @When("user get the link Don't have an account?")
    public void userGetTheLinkDontHaveAnAccount() {
      boolean isAccountCreationLinkExist = SignUpPage_Company.isDontHaveAnAccountLinkExist();
        System.out.println("Account creation link is exist : " + isAccountCreationLinkExist );
        Assert.assertTrue(isAccountCreationLinkExist);
    }
    @Then("Click on Don't have an account? link")
    public void clickOnDonTHaveAnAccountLink() {
        signUpPage_Company.userClickOnDontHaveAnAccountLink();
    }
    @And("verify all the Elements visible on Registration Page")
    public void verifyAllTheElementsVisibleOnRegistrationPage() {
        signUpPage_Company.verifyAlltheElementsPresentOnStep1();
    }
    @And("verify when user click on link {string}")
    public void verifyWhenUserClickOnLink(String expectedAccountLinkText) throws InterruptedException {
        signUpPage_Company.verifyAndClickOnAlreadyHaveAnAccount(expectedAccountLinkText);
    }
    @Then("user click on Company icon")
    public void userClickOnCompanyIcon() throws InterruptedException {
        signUpPage_Company.verifyAndClickOnCompanyIcon();
    }
    @And("click on Sign up button")
    public void clickOnSignUpButton() {
        signUpPage_Company.clickOnSignUpbutton();
    }
    @And("user get the first question text {string} on second step of Registration")
    public void userGetTheFirstQuestionTextOnSecondStepOfRegistration(String expectedQ1Text) throws InterruptedException {
        signUpPage_Company.userGetTheFirstQuestionOnSecondStepOfRegistration(expectedQ1Text);
   }
    @Then("user click on Yes button of first question")
    public void userClickOnYesButtonOfFirstQuestion() throws InterruptedException {
        signUpPage_Company.userClickOnYesButtonForQ1();
    }
    @And("user get the Second question text {string} on second step of Registration")
    public void userGetTheSecondQuestionTextOnSecondStepOfRegistration(String expectedQ2Text) throws InterruptedException {
        signUpPage_Company.userGetTheSecondQuestionOnSecondStepOfRegistration(expectedQ2Text);
    }
    @Then("user click on Yes button of Second question")
    public void userClickOnYesButtonOfSecondQuestion() throws InterruptedException {
        signUpPage_Company.userClickOnYesButtonForQ2();
    }
    @And("user get the Third question text {string} on second step of Registration")
    public void userGetTheThirdQuestionTextOnSecondStepOfRegistration(String expectedQ3Text) throws InterruptedException {
        signUpPage_Company.userGetTheThirdQuestionOnSecondStepOfRegistration(expectedQ3Text);
    }
    @Then("user click on Yes button of Third question")
    public void userClickOnYesButtonOfThirdQuestion() throws InterruptedException {
        signUpPage_Company.userClickOnYesButtonForQ3();
    }
    @And("user enter an email")
    public void userEnterAnEmail() {
        signUpPage_Company.userEnterTheEmail();
    }
    @And("user enter a password")
    public void userEnterAPassword() {
        signUpPage_Company.userEnterThePassword();
    }
    @And("user enter a repeatPassword")
    public void userEnterARepeatPassword() {
        signUpPage_Company.userEnterTheRepeatPassword();
    }
    @Then("user click on Next button on third step of Registration")
    public void userClickOnNextButtonOnThirdStepOfRegistration() throws InterruptedException {
        signUpPage_Company.userClickOnNextButtonOnRegistration();
    }
    @And("user get the RegistrationStepSecondOfFourthText")
    public void userGetTheRegistrationStepSecondOfFourthText() {
        signUpPage_Company.userGetThetextOnStep2();
    }
    @Then("user click on Next button on second step of Registration")
    public void userClickOnNextButtonOnSecondStepOfRegistration() throws InterruptedException {
        signUpPage_Company.userClickOnNextButtonOnRegistration();
    }
    @And("user get the RegistrationStepThirdOfFourthText")
    public void userGetTheRegistrationStepThirdOfFourthText() throws InterruptedException {
        signUpPage_Company.userGetThetextOnStep3();
    }
    @And("user get the Saudi and Residents icons with links")
    public void userGetTheSaudiAndResidentsIconsWithLinks() {
        signUpPage_Company.userGetTheSaudiAndResidentLinkIconsOnStep3();
       }
    @Then("user click on Resident icon")
    public void userClickOnResidentIcon() {
        signUpPage_Company.userClickOnTheResidentLinkOnStep3();
    }
    @Then("user select the Nationality as India")
    public void userSelectTheNationalityAsIndia() {
        signUpPage_Company.userSelectTheNationalityOnStep3();
    }
    @Then("user enter the IqamaId")
    public void userEnterTheIqamaId() {
        signUpPage_Company.userEntertheIqamaIdOnStep3();
    }
    @And("user enter the mobile number")
    public void userEnterTheMobileNumber() {
        signUpPage_Company.userEnterThePhoneNumberOnStep3();
    }
    @And("user get the entered mobile number text as {string}")
    public void userGetTheEnteredMobileNumberTextAs(String expectedMobileNumberText) {
        signUpPage_Company.userGetTheEnteredMobileNumber(expectedMobileNumberText);
    }
    @And("user get the terms and condition text as {string}")
    public void userGetTheTermsAndConditionTextAs(String expectedTermsAndConditiontext) {
        signUpPage_Company.userGetTheTermAndConditionText(expectedTermsAndConditiontext);
    }
    @And("user get the link of terms and condition text as {string}")
    public void userGetTheLinkTermsAndConditionTextAs(String expectedTermsAndConditiontext) {
        signUpPage_Company.userGetTheTermAndConditionText(expectedTermsAndConditiontext);
    }
    @And("user click on Terms and Condition link {string}")
    public void userClickOnTermsAndConditionLink(String expectedTermsAndConditionLinkText) throws InterruptedException {
        signUpPage_Company.userGetTheLinkTextTermAndCondition(expectedTermsAndConditionLinkText);
        signUpPage_Company.userClickOnTheTermAndConditionLink();
    }
    @And("user click on Continue button")
    public void userClickOnContinueButton() throws InterruptedException {
        signUpPage_Company.userClickOnContinueButton();
    }
    @Then("user click on Submit button")
    public void userClickOnSubmitButton() throws InterruptedException {
        signUpPage_Company.userClickOnSubmitButton();
    }
    @Then("user click on Sign up button")
    public void userClickOnSignUpButton() throws InterruptedException {
        signUpPage_Company.userClickOnNextButton();
    }
    @Then("user get the text as {string}")
    public void userGetTheTextAs(String expectedtext) throws InterruptedException {
        signUpPage_Company.userGetTheNumberUnderRegisteredIDtextOnStep3(expectedtext);
    }
    @Then("user get the mobile number text as {string}")
    public void userGetTheMobileNumberTextAs(String expectedMobileNum) {
        signUpPage_Company.userGetThePhoneNumbertextOnStep3(expectedMobileNum);
    }
    @And("user get the Edit and Confirm buttons on popup")
    public void userGetTheEditAndConfirmButtonsOnPopup() {
        signUpPage_Company.userGetTheEditAndConfirmButtons();
    }
    @Then("user click on Confirm button")
    public void userClickOnConfirmButton() throws InterruptedException {
        signUpPage_Company.userClickOnConfirmBtn();
    }
    @And("user get the RegistrationStepFourthOfFourthText")
    public void userGetTheRegistrationStepFourthOfFourthText() throws InterruptedException {
        signUpPage_Company.userGetThetextOnStep4();
    }
    @And("user get the SMScode text as {string} and enter the OTP")
    public void userGetTheSMScodeTextAsAndEnterTheOTP(String expectedSMSText) {
        signUpPage_Company.userEnterTheOTP();
    }
    @Then("user click on Next button on Step fourth")
    public void userClickOnNextButtonOnStepFourth() throws SQLException, InterruptedException {
        signUpPage_Company.userClickOnNextButtonOnRegistration();
    }
    @And("user verify the email")
    public void userVerifyTheEmail() throws InterruptedException {
        signUpPage_Company.userEmailVerification();
        Thread.sleep(2000);
    }
    @Then("user get the page title as {string}")
    public void userGetThePageTitleAs(String expectedTitleName) throws InterruptedException, SQLException {
//       String getTitle = signupPage.userGetThePageTitle();
//        Assert.assertTrue(getTitle.contains(expectedTitleName));
        signUpPage_Company.CleanDataFromDatabase();
    }
    @Then("user get the verification text on dashboard as {string}")
    public void userGetTheVerificationTextOnDashboardAs(String expectedIdentifyText) {
        signUpPage_Company.userGetTheVerificationTextOnDashboard(expectedIdentifyText);
    }
    @And("user verify the start button and click on it")
    public void userVerifyTheStartButtonAndClickOnIt() throws InterruptedException {
        signUpPage_Company.userVerifyAndClickOnStartBtn();
    }
    @And("user select the DOB as {string}")
    public void userSelectTheDOBAs(String expectedDOB) throws InterruptedException {
        signUpPage_Company.userClickandSelectTheDOBDate(expectedDOB);
    }
    @Then("user click on Next button on Verification first step")
    public void userClickOnNextButtonOnVerificationFirstStep() throws InterruptedException {
        signUpPage_Company.userClickOnNextButton();
    }
    @And("user get the Verification StepSecondOfSix")
    public void userGetTheVerificationStepSecondOfSix() {
        signUpPage_Company.userGetTheVerificationStep2Text();
    }
    @Then("user enter the Absher OTP as {int}")
    public void userEnterTheAbsherOTPAs(int expectedAbsherOTP) {
        signUpPage_Company.userEnterTheAbsherOTP(expectedAbsherOTP);
    }
    @Then("user click on Next button on Verification second step")
    public void userClickOnNextButtonOnVerificationSecondStep() throws InterruptedException {
        signUpPage_Company.userClickOnNextButton();
    }
    @And("user get the Verification StepThirdOfSix")
    public void userGetTheVerificationStepThirdOfSix() throws InterruptedException {
        signUpPage_Company.userGetTheVerificationStep3Text();
    }
     @And("user get the Primary National Address heading text as {string}")
    public void userGetThePrimaryNationalAddressHeadingTextAs(String expectedAddressHeadingText) {
         signUpPage_Company.userGetTheNationalAddressHeadingText(expectedAddressHeadingText);
    }
    @Then("user click on Next button on Verification third step")
    public void userClickOnNextButtonOnVerificationThirdStep() throws InterruptedException {
        signUpPage_Company.userClickOnNextButton();
    }
    @And("user get the Verification StepFourthOfSix")
    public void userGetTheVerificationStepFourthOfSix() {
        signUpPage_Company.userGetTheVerificationStep4Text();
    }
    @And("user select the AnnualIncome")
    public void userSelectTheAnnualIncome() throws InterruptedException {
        signUpPage_Company.userSelectTheAnnualIncomeDrodpownValue();
        Thread.sleep(6000);
    }
    @And("user select the Source of Income")
    public void userSelectTheSourceOfIncome() throws InterruptedException {
        signUpPage_Company.userSelectTheSourceOfIncomeDrodpownValue();
    }
    @And("user get the tooltip text when mouse hover on Estimated Annual Deposit")
    public void userGetTheTooltipTextWhenMouseHoverOnEstimatedAnnualDeposit() {
        signUpPage_Company.getTheToolTipTextOfEstimatedAnnualDeposit();
    }
    @And("user select the Estimated Annual Deposit")
    public void userSelectTheEstimatedAnnualDeposit() {
        signUpPage_Company.userSelectTheAnnualDepositDrodpownValue();
    }
    @And("user mouse hover on tooltip of Estimated Annual Investment")
    public void userMouseHoverOnTooltipOfEstimatedAnnualInvestment() {
        signUpPage_Company.getTheToolTipTextOfEstimatedAnnualDeposit();
    }
    @And("user select the Estimated Annual Investment")
    public void userSelectTheEstimatedAnnualInvestment() {
        signUpPage_Company.userSelectTheAnnualInvestmentDropdownValue();
    }
    @Then("user click on Next button on Verification fourth step")
    public void userClickOnNextButtonOnVerificationFourthStep() throws InterruptedException {
        Thread.sleep(5000);
        signUpPage_Company.userClickOnNextButton();
    }
    @And("user select the Job title")
    public void userSelectTheJobTitle() {
        signUpPage_Company.userSelectTheJobTitleDrodpownValue();
    }
    @And("user select the Employment Status")
    public void userSelectTheEmploymentStatus() {
        signUpPage_Company.userSelectTheEmploymentStatusDrodpownValue();
    }
    @And("user enter the Company Name")
    public void userEnterTheCompanyName() {
        signUpPage_Company.userEnterTheCompanyName();
     }
    @And("user select the Nature of Business")
    public void userSelectTheNatureOfBusiness() {
        signUpPage_Company.userSelectTheNatureOfBusinessDrodpownValue();
    }
    @And("user click on Next button on fifth step of Verification")
    public void userClickOnNextButtonOnFifthStepOfVerification() throws InterruptedException {
        signUpPage_Company.userClickOnNextButton();
    }
    @And("user get the Verification StepSixOfSix")
    public void userGetTheVerificationStepSixOfSix() {
        signUpPage_Company.userGetTheVerificationStep6Text();
    }
    @And("user select the question first as No")
    public void userSelectTheQuestionFirstAsNo() {
        signUpPage_Company.userSelectTheQ1AsNo();
    }
    @And("user select the question second as No")
    public void userSelectTheQuestionSecondAsNo() {
        signUpPage_Company.userSelectTheQ2AsNo();
    }
    @And("user select the question third as No")
    public void userSelectTheQuestionThirdAsNo() {
        signUpPage_Company.userSelectTheQ3AsNo();
    }
    @And("user select the question fourth as No")
    public void userSelectTheQuestionFourthAsNo() {
        signUpPage_Company.userSelectTheQ4AsNo();
    }
    @Then("user click on Finish button")
    public void userClickOnFinishButton() throws InterruptedException {
        signUpPage_Company.userClickOnFinishBtn();
        Thread.sleep(2000);
    }
    @Then("user get the successful verification message on dashboard")
    public void userGetTheSuccessfulVerificationMessageOnDashboard() {
        signUpPage_Company.userGetTheSuccessfulVerificationMsg();
    }
    @And("user click on Continue button after successful verification")
    public void userClickOnContinueButtonAfterSuccessfulVerification() throws InterruptedException {
        signUpPage_Company.userClickOnContinueButton();
    }
    @And("user get the contract accept banner on dashboard")
    public void userGetTheContractAcceptBannerOnDashboard() throws InterruptedException {
       // PageBase.doPageRefresh();
        Thread.sleep(5000);
        signUpPage_Company.userGetTheContractBanner();
    }
    @Then("user click on Read and accept link")
    public void userClickOnReadAndAcceptLink() throws InterruptedException {
        signUpPage_Company.userClickOnReadAndAcceptLink();
    }
    @And("user accept the contract")
    public void userAcceptTheContract() throws InterruptedException {
        signUpPage_Company.userClickOnAcceptContractBtn();
    }
    @And("user get the under review banner text as {string}")
    public void userGetTheUnderReviewBannerTextAs(String expectedUnderReviewText) {
        signUpPage_Company.userGetTheUnderReviewBannerText(expectedUnderReviewText);
    }

}
