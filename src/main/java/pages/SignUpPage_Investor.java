package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import qaFactory.DBConnections;

import java.sql.SQLException;

public class SignUpPage_Investor extends PageBase {
     private final WebDriver driver;
     DBConnections dbcon = new DBConnections();

        //1. page Locators using By
    private static final By link_dontHaveAnAccount = By.linkText("Don't have an account?");
    private static final By txt_Registration = By.xpath("//h3[text()='Registration']");
    private static final By txt_Registration_Step1 = By.xpath("//div[text()='Step 1 of 4']");
    private static final By link_Investor = By.xpath("//span[text()='Investor']");
    private static final By link_Company = By.xpath("//span[text()='Company']");
    private static final By icon_Investor = By.xpath("//div[@class= 'icon-container-center false col'][1]");
    private static final By icon_Company = By.xpath("//div[@class= 'icon-container-center active col']");
    private static final By txt_TC = By.xpath("//span[text()='I have read and agree to ']");
    private static final By link_TC = By.xpath("//span[text()='Terms and Conditions']");
    private static final By btn_SignUp = By.xpath("//button[@type='submit']");
    private static final By txt_whoCanInvest = By.xpath("//div[text()='Only Saudis and Saudi Arabia residents can register on Lendo.']");
    private static final By link_AlreadyHaveAnAccount = By.xpath("//a[text()='Already have an account?']");
    private static final By txt_SignIn = By.xpath("//h3[text()='Sign In']");
    private static final By checkbox_TermsAndConditions = By.xpath("//input[@id='registeration_agreement']");
    private static final By txt_Registration_Step2 = By.xpath("//div[text() ='Step 2 of 4']");
    private static final By txt_Email = By.id("registeration_email");
    private static final By txt_password = By.id("registeration_password");
    private static final By txt_RepeatPassword = By.id("registeration_repeatPassword");
    private static final By btn_Next_Registration =  By.xpath("//button[@value= 'Next']");
    private static final By btn_Next =  By.xpath("//input[@value= 'Next']");
    private static final By btn_Submit =  By.xpath("//button[@value = 'Submit']");
    private static final By txt_MobileNumUnderRegisteredId = By.xpath("//p[text()=\"Enter the mobile number that's registered under Your national / Iqama number\"]");
    private static final By txt_termsAndCondition = By.xpath("//p[text()=\"By clicking “Submit” below, you agree to Lendo \"]");
    private static final By link_termsAndCondition = By.xpath("//span[text()=\"Terms and Conditions\"]");
    private static final By btn_Continue = By.xpath("//button[text() = 'Continue']");
    private static final By txt_Registration_Step3 = By.xpath("//div[text() ='Step 3 of 4']");
    private static final By link_Saudi = By.xpath("//span[text() ='Saudi']");
    private static final By link_Resident = By.xpath("//span[text() ='Resident']");
    private static final By dropdown_nationality = By.id("registeration_nationality");
    private static final By dropdown_nationality_India = By.xpath("//div[@class ='ant-select-item-option-content' and text() = 'India']");
    private static final By txt_registration_Id = By.id("registeration_id");
    private static final By txt_mobilePhoneNumber = By.id("registeration_mobileNumber");
    private static final By txt_NumberUnderRegisteredId = By.xpath("//h6[text()= 'Please confirm the below entered mobile number belongs to your National/Iqama number']");
    private static final By txt_Number = By.xpath("//h6[text()= '+966534221248']");
    private static final By btn_EditPhoneNumber = By.xpath("//button[text() = 'Edit']");
    private static final By btn_ConfirmPhoneNum = By.xpath("//button[text() = 'Confirm']");
    private static final By txt_Registration_Step4 = By.xpath("//div[text() ='Step 4 of 4']");
    private static final By txt_EnterTheSmsCode = By.xpath("//div[text()= 'Enter SMS code in the field below']");
    private static final By btn_enterOTP = By.xpath("//input[@type = 'number']");
    //VERIFICATION STEPS
    private static final By txt_verifyIdentity = By.xpath("//p[text() = 'You need to verify your account before investing in the opportunities offered']");
    private static final By btn_Start = By.xpath("//button[text() ='Start']");
    private static final By txt_VerificationHeading = By.xpath("//h3[text() ='Verification']");
    private static final By txt_VerificationStep1 = By.xpath("//div[text() ='Step 1 of 6']");
    private static final By datePicker_dob = By.id("registeration_residentDOB");
    private static final By datePicker_dateSelection = By.xpath("//div[text()=\"4\"][1]");
    private static final By txt_VerificationStep2 = By.xpath("//div[text() ='Step 2 of 6']");
    private static final By datePicker_previousMonthIcon = By.xpath("//span[@class = 'ant-picker-prev-icon']");
    private static final By txt_datePicker_month = By.xpath("//button[text()=\"Apr\"]");
    private static final By txt_enterAbsherOTP = By.xpath("//input[@type = 'number']");
    private static final By txt_VerificationStep3 = By.xpath("//div[text() ='Step 3 of 6']");
    private static final By txt_PrimaryNationalAddress = By.xpath("//strong[text()=\"Primary National Address\"]");
    private static final By txt_VerificationStep4 = By.xpath("//div[text() ='Step 4 of 6']");
    private static final By drpdwn_AnnualIncome = By.xpath("/html//form[@id='registeration']/div[2]//div[@class='justify-content-center mt-4']/div[1]/div//span[@class='ant-select-selection-search']");
    private static final By drpdwn_AnnualIncome_Value =By.xpath("//div[contains(@class,'ant-select-item-option-content') and text() = '1-50K']");
    private static final By drpdwn_SourceOfIncome = By.xpath("/html//form[@id='registeration']/div[2]//div[@class='justify-content-center mt-4']/div[2]/div//span[@class='ant-select-selection-search']");
    private static final By drpdwn_SourceOfIncome_Value = By.xpath("//div[contains(@class,'ant-select-item-option-content') and text() = 'Income from salary']");
    private static final By icon_EstimatedAnnualDeposits = By.xpath("//h5[text() =\"Estimated Annual Deposit\"]/span");
    private static final By tooltipText_EstimatedAnnualDeposits = By.xpath("//div[@class ='ant-tooltip-inner' and text() =\"How much money do you think you will deposit into your Lendo's wallet per year?\"]");
    private static final By icon_EstimatedAnnualInvestment = By.xpath("//h5[text() =\"Estimated Annual Investment\"]/span");
    private static final By tooltipText_EstimatedAnnualInvestment = By.xpath("//div[@class ='ant-tooltip-inner' and text() =\"How much money do you think you will invest at Lendo's opportunities per year?\"]");
    private static final By drpdwn_EstimatedAnnualDeposits = By.xpath("/html//form[@id='registeration']/div[2]//div[@class='justify-content-center mt-4']/div[3]/div//span[@class='ant-select-selection-search']");
    private static final By drpdwn_EstimatedAnnualDeposits_Value = By.xpath("//body[@class='lang-en']/div[4]/div/div//div[@class='rc-virtual-list']/div[@class='rc-virtual-list-holder']//div[@title='SAR 5,000 or less']/div[@class='ant-select-item-option-content']");
    private static final By drpdwn_EstimatedAnnualInvestments = By.xpath("/html//form[@id='registeration']/div[2]//div[@class='justify-content-center mt-4']/div[4]/div//span[@class='ant-select-selection-search']");
    private static final By drpdwn_EstimatedAnnualInvestments_Value = By.xpath("//body[@class='lang-en']/div[5]/div/div//div[@class='rc-virtual-list']/div[@class='rc-virtual-list-holder']//div[@title='SAR 5,000 or less']/div[@class='ant-select-item-option-content']");
    private static final By txt_VerificationStep5 = By.xpath("//div[text() ='Step 5 of 6']");
    private static final By drpdwn_JobTitle = By.xpath("/html//form[@id='registeration']/div[2]//div[@class='width-465']/div/div[1]//span[@class='ant-select-selection-search']");
    private static final By drpdwn_JobTitle_Value = By.xpath("//div[contains(@class,'ant-select-item-option-content') and text() = 'Self-Employed/Owner']");
    private static final By drpdwn_EmploymentStatus = By.xpath("/html//form[@id='registeration']/div[2]//div[@class='width-465']/div/div[2]//span[@class='ant-select-selection-search']");
    private static final By drpdwn_EmploymentStatus_Value = By.xpath("//div[contains(@class,'ant-select-item-option-content') and text() = 'Employed']");
    private static final By txt_CompanyName = By.id("registeration_companyName");
    private static final By drpdwn_NatureOfBusiness = By.xpath("/html//form[@id='registeration']/div[2]//div[@class='width-465']/div/div[4]//span[@class='ant-select-selection-search']");
    private static final By drpdwn_NatureOfBusiness_Value = By.xpath("//div[contains(@class,'ant-select-item-option-content') and text() = 'Car Dealers']");
    private static final By radioBtn_q1_no = By.xpath("/html//form[@id='registeration']/div[3]/div[1]/ol/li[1]/div//div[@class='ant-radio-group ant-radio-group-outline']//input[@value='7']");
    private static final By radioBtn_q2_no = By.xpath("/html//form[@id='registeration']/div[3]/div[1]/ol/li[2]/div[@class='row']//div[@class='ant-radio-group ant-radio-group-outline']//input[@value='2']");
    private static final By radioBtn_q3_no = By.xpath("/html//form[@id='registeration']/div[3]/div[1]/ol/li[3]/div[@class='row']//div[@class='ant-radio-group ant-radio-group-outline']//input[@value='2']");
    private static final By radioBtn_q4_no = By.xpath("/html//form[@id='registeration']/div[3]/div[1]/ol/li[4]/div[@class='row']//div[@class='ant-radio-group ant-radio-group-outline']//input[@value='2']");
    private static final By btn_finish = By.xpath("/html//form[@id='registeration']//button[@type='submit']");
    private static final By txt_VerificationStep6 = By.xpath("//div[text() ='Step 6 of 6']");
    //Onboarding steps
    private static final By txt_SuccessfulVerification = By.xpath("/html/body[@class='lang-en']//div[@class='ant-message']/div");
    private static final By txt_ContractBanner = By.xpath("//div[text() ='Please accept the lender contract to complete the verification']");
    private static final By link_ReadAndAcceptContract = By.linkText("Read and accept");
    private static final By scrolldownPage  = By.xpath("//body/div[@role='dialog']");
    private static final By btn_ContractAccept = By.xpath("//button[text() ='Accept']");
    private static final By txt_UnderReviewBanner = By.xpath("//div[text() ='Your account is under review. No transactions can be made currently. Please check again in a few days.']");
    private final By depositButton = By.xpath("//button[text() = 'Deposit']");

        private final By concurrentLoginPopupBtn = By.xpath("//button[@type= 'button']/span");
        private final By verifyOTPBtn = By.xpath("//input[@type= 'button']");

        //2. Constructor of the page class:
        public SignUpPage_Investor(WebDriver driver){
            super(driver);
            // super(driver);
            this.driver=driver;
            //  PageFactory.initElements(driver,this);
        }
        //3. page actions: features(behavior) of the page the form of methods:
         public static boolean isDontHaveAnAccountLinkExist(){
            return PageBase.IsElementDisplayedOnUI(link_dontHaveAnAccount);
        }
         public void userClickOnDontHaveAnAccountLink(){
         PageBase.doClick(link_dontHaveAnAccount);
        }
        public void verifyAlltheElementsPresentOnStep1(){
            PageBase.doPageRefresh();
        boolean isRegistrationtxtVisible = PageBase.IsElementDisplayedOnUI(txt_Registration);
            System.out.println("Registration heading text is visible : " + isRegistrationtxtVisible);
            Assert.assertTrue(isRegistrationtxtVisible);

        boolean isInvestorTextVisible = PageBase.IsElementDisplayedOnUI(link_Investor);
            System.out.println("Investor icon is visible : " + isInvestorTextVisible);
            Assert.assertTrue(isInvestorTextVisible);

        boolean isCompanyTextVisible = PageBase.IsElementDisplayedOnUI(link_Company);
            System.out.println("Company icon is visible : " + isCompanyTextVisible);
            Assert.assertTrue(isCompanyTextVisible);

        boolean isSaudiInvestTextVisible = PageBase.IsElementDisplayedOnUI(txt_whoCanInvest);
            System.out.println("Only Saudis and Saudi Arabia residents can register on Lendo text is visible : " + isSaudiInvestTextVisible);
            Assert.assertTrue(isSaudiInvestTextVisible);

//        boolean isSignUpBtnEnabled = PageBase.isElementEnabled(btn_SignUp);
//            System.out.println(" Sign up button is disabled : " + isSignUpBtnEnabled);
//            Assert.assertEquals(false,isSignUpBtnEnabled);

        }
    public  void verifyAndClickOnAlreadyHaveAnAccount(String expectedAccountlinkTxt) throws InterruptedException {
            String alreadyHaveAnAccount = PageBase.doGetText(link_AlreadyHaveAnAccount);
            System.out.println("Already have an account link text is visible as :" +alreadyHaveAnAccount);
            Assert.assertEquals(alreadyHaveAnAccount,expectedAccountlinkTxt);
            PageBase.doClickOnWebElement(link_AlreadyHaveAnAccount,20);
           String actual_signTxt =   PageBase.doGetText(txt_SignIn);
           System.out.println("Sign In is available as " +actual_signTxt);
           Assert.assertEquals(actual_signTxt,"Sign In");
         //   PageBase.navigateForwardToBrowser();
           PageBase.doClickOnWebElement(link_dontHaveAnAccount,50);
           // Thread.sleep(2000);
    }

    public  void verifyAndClickOnInvestorIcon() throws InterruptedException {
      //  PageBase.ScrollDownpageVertical(btn_SignUp);
        PageBase.doClickOnWebElement(icon_Investor,20);
        Thread.sleep(2000);
    }
//    public void clickOnTermsAndConditionsCheckbox(){
//       JavascriptExecutor js = (JavascriptExecutor)driver;
//        js.executeScript("window.scrollBy(0,1000)");
//        PageBase.doClick(checkbox_TermsAndConditions);
//        PageBase.isElementSelected(checkbox_TermsAndConditions);
//    }
    public void clickOnSignUpbutton(){
        PageBase.doClickOnWebElement(btn_SignUp,20);
    }
    public void userGetThetextOnStep2(){
        PageBase.doGetText(txt_Registration_Step2);
    }
    public void userEnterTheEmail(){
        PageBase.doClickOnWebElement(txt_Email,20);
        PageBase.doSendKeys(txt_Email,"ranjeeta@lendo.sa");
    }
    public void userEnterThePassword(){
        PageBase.doClickOnWebElement(txt_password,20);
        PageBase.doSendKeys(txt_password,"Test@123");
    }
    public void userEnterTheRepeatPassword(){
        PageBase.doClickOnWebElement(txt_RepeatPassword,20);
        PageBase.doSendKeys(txt_RepeatPassword,"Test@123");
    }
    public void userClickOnNextButtonOnRegistration() throws InterruptedException {
        PageBase.doClickOnWebElement(btn_Next_Registration,60);
    }
    public void userClickOnNextButton() throws InterruptedException {
        PageBase.doClickOnWebElement(btn_Next,60);
    }
    public void userClickOnSubmitButton() throws InterruptedException {
        PageBase.doClickOnWebElement(btn_Submit,20);
        Thread.sleep(3000);
    }
    public void userGetThetextOnStep3() throws InterruptedException {
         Thread.sleep(2000);
        PageBase.doGetText(txt_Registration_Step3);
    }
    public void userGetTheSaudiAndResidentLinkIconsOnStep3(){
        PageBase.IsElementDisplayedOnUI(link_Saudi);
        PageBase.IsElementDisplayedOnUI(link_Resident);
    }
     public void userClickOnTheResidentLinkOnStep3(){
        PageBase.doClickOnWebElement(link_Resident,20);
    }
    public void userSelectTheNationalityOnStep3() {
        PageBase.doClick(dropdown_nationality);
        PageBase.doSendKeys(dropdown_nationality, "India");
        PageBase.doClickOnWebElement(dropdown_nationality_India, 20);
    }
    public void userEntertheIqamaIdOnStep3(){
        PageBase.doClickOnWebElement(txt_registration_Id,20);
        PageBase.doSendKeys(txt_registration_Id,"2508820178");
    }
    public void userGetTheEnteredMobileNumber(String expectedMobileNumText){
         String actualMobileText = PageBase.doGetText(txt_MobileNumUnderRegisteredId);
         Assert.assertEquals(actualMobileText,expectedMobileNumText,"Enter the mobile number that's registered under Your national / Iqama number text is mismatched");
    }
    public void userGetTheTermAndConditionText(String expectedTermsAndConditionText){
        String actual_TermsAndConditionText = PageBase.doGetText(txt_termsAndCondition);
        Assert.assertEquals(actual_TermsAndConditionText,expectedTermsAndConditionText,"By clicking “Submit” below, you agree to Lendo text is mismatched");
    }
    public void userGetTheLinkTextTermAndCondition(String expectedTermsAndConditionLinkText){
        String actual_TermsAndConditionLinkText = PageBase.doGetText(link_termsAndCondition);
        Assert.assertEquals(actual_TermsAndConditionLinkText,expectedTermsAndConditionLinkText,"By clicking “Submit” below, you agree to Lendo text is mismatched");
    }
    public void userClickOnTheTermAndConditionLink() throws InterruptedException {
        PageBase.doClick(link_termsAndCondition);
        Thread.sleep(2000);
    }
    public void userClickOnContinueButton() throws InterruptedException {
        PageBase.doClickOnWebElement(btn_Continue,20);
        Thread.sleep(2000);
          }
    public void userEnterThePhoneNumberOnStep3(){
        PageBase.doClickOnWebElement(txt_mobilePhoneNumber,20);
        PageBase.doSendKeys(txt_mobilePhoneNumber,"534221248");
    }
    public void userGetTheNumberUnderRegisteredIDtextOnStep3(String expectedText) throws InterruptedException {
            Thread.sleep(3000);
       String numUnderRegisteredId = PageBase.doGetText(txt_NumberUnderRegisteredId);
        System.out.println("User get the number under registered ID text as"+ numUnderRegisteredId);
        Assert.assertEquals(numUnderRegisteredId,expectedText,"NumberUnder Registered ID text is mismatched");
    }
    public void userGetThePhoneNumbertextOnStep3(String expectedText){
        String mobileNum =  PageBase.doGetText(txt_Number);
        System.out.println("User get the entered mobile number on popup as :" + mobileNum);
    }
    public void userGetTheEditAndConfirmButtons(){
        boolean editPhoneNumbBtn = PageBase.IsElementDisplayedOnUI(btn_EditPhoneNumber);
        Assert.assertTrue(editPhoneNumbBtn);
        boolean confirmPhoneNumbBtn = PageBase.IsElementDisplayedOnUI(btn_ConfirmPhoneNum);
        Assert.assertTrue(confirmPhoneNumbBtn);
    }
    public void userClickOnConfirmBtn() throws InterruptedException {
        PageBase.doClickOnWebElement(btn_ConfirmPhoneNum,5);
    }
    public void userEnterTheOTP(){
     String getSMSText = PageBase.doGetText(txt_EnterTheSmsCode);
     System.out.println("Get the SMS code text as :" +getSMSText);
     String db_getOTP = dbcon.get_otp();
        System.out.println("get the OTP as :" + db_getOTP);
       PageBase.doSendKeys(btn_enterOTP,db_getOTP);
     }
    public void userGetThetextOnStep4() throws InterruptedException {
        Thread.sleep(2000);
        PageBase.doGetText(txt_Registration_Step4);
    }
     public void CleanDataFromDatabase() throws SQLException {
         dbcon.DB();
     }
     public void userEmailVerification() throws InterruptedException {
            dbcon.update_email_verification();
            Thread.sleep(3000);
          //  PageBase.doPageRefresh();
     }
     public String userGetThePageTitle() throws InterruptedException {
         Thread.sleep(3000);
           return PageBase.getPageTitle();
     }
     public void userGetTheVerificationTextOnDashboard(String expectedIdentifyText){
           String identityText = PageBase.doGetText(txt_verifyIdentity);
         System.out.println("user get the verify identity text as : " + identityText);
         Assert.assertEquals(identityText,expectedIdentifyText, "Verify your identity text is mismatched");
     }
     public void userVerifyAndClickOnStartBtn() throws InterruptedException {
         PageBase.doPageRefresh();
         Thread.sleep(5000);
       //  PageBase.IsElementDisplayedOnUI(btn_Start);
         PageBase.doClickOnWebElement(btn_Start,30);
     }
     public void userGetTheVerificationHeadingText(String expectedVerificationHeadText){
         PageBase.doGetText(txt_VerificationHeading);
    }
    public void userGetTheVerificationStep1Text(String expectedVerificationStep1Text){
        PageBase.doGetText(txt_VerificationStep1);
    }
    public void userClickandSelectTheDOBDate(String expectedDOBText) throws InterruptedException {
        Thread.sleep(2000);
         //button to open calendar
         PageBase.doClickOnWebElement(datePicker_dob,50);

        //button to move previous month in calendar
        String dob =  PageBase.doSendKeys(datePicker_dob,expectedDOBText);
        System.out.println("Entered dob is : " + dob);

        // PageBase.SwitchToFrame(datePicker_dateSelection);
         //PageBase.doClick(datePicker_previousMonthIcon);
       //  PageBase.doGetText(txt_datePicker_month);
         PageBase.doClickOnWebElement(datePicker_dateSelection,100);
     }
    public void userGetTheVerificationStep2Text(){
        PageBase.doGetText(txt_VerificationStep2);
    }
    public void userEnterTheAbsherOTP(int expectedAbsherOTP){
            PageBase.doSendKeys(txt_enterAbsherOTP,String.valueOf (expectedAbsherOTP));
            PageBase.doClick(btn_Next);
    }
    public void userGetTheVerificationStep3Text() throws InterruptedException {
         Thread.sleep(2000);
        String step3text = PageBase.doGetText(txt_VerificationStep3);
        System.out.println("Verification second step text is : " + step3text);
    }
    public void userGetTheNationalAddressHeadingText(String expectedAddressHeadingText){
        String actualAddressText =  PageBase.doGetText(txt_PrimaryNationalAddress);
       Assert.assertEquals(actualAddressText,expectedAddressHeadingText);
    }
    public void userGetTheVerificationStep4Text(){
        String step4text = PageBase.doGetText(txt_VerificationStep4);
        System.out.println("Verification second step text is : " + step4text);
    }
   public void userSelectTheAnnualIncomeDrodpownValue() throws InterruptedException {
       PageBase.doClickOnWebElement(drpdwn_AnnualIncome,5);
       PageBase.doClickOnWebElement(drpdwn_AnnualIncome_Value,5);
   }
    public void userSelectTheSourceOfIncomeDrodpownValue() throws InterruptedException {
        PageBase.doClickOnWebElement(drpdwn_SourceOfIncome,5);
        PageBase.doClickOnWebElement(drpdwn_SourceOfIncome_Value,5);
    }
    public void getTheToolTipTextOfEstimatedAnnualDeposit(){
            String getToolTipText_Deposit = "How much money do you think you will deposit into your Lendo's wallet per year?";
            PageBase.tooltipTextUsingActionClass(icon_EstimatedAnnualDeposits,tooltipText_EstimatedAnnualDeposits,getToolTipText_Deposit);
          //  PageBase.tooltipText(icon_EstimatedAnnualDeposits);
    }
    public void getTheToolTipTextOfEstimatedAnnualInvest(){
        String getToolTipText_invest = "How much money do you think you will invest into your Lendo's wallet per year?";
        PageBase.tooltipTextUsingActionClass(icon_EstimatedAnnualInvestment,tooltipText_EstimatedAnnualInvestment,getToolTipText_invest);
        //  PageBase.tooltipText(icon_EstimatedAnnualDeposits);
    }
    public void userSelectTheAnnualDepositDrodpownValue(){
        PageBase.doClickOnWebElement(drpdwn_EstimatedAnnualDeposits,5);
        PageBase.doClickOnWebElement(drpdwn_EstimatedAnnualDeposits_Value,5);
    }
    public void userSelectTheAnnualInvestmentDropdownValue(){
        PageBase.doClickOnWebElement(drpdwn_EstimatedAnnualInvestments,5);
        PageBase.doClickOnWebElement(drpdwn_EstimatedAnnualInvestments_Value,5);
    }
    public void userSelectTheJobTitleDrodpownValue() {
        PageBase.doClickOnWebElement(drpdwn_JobTitle,5);
        PageBase.doClickOnWebElement(drpdwn_JobTitle_Value,5);
    }
    public void userSelectTheEmploymentStatusDrodpownValue(){
        PageBase.doClickOnWebElement(drpdwn_EmploymentStatus,5);
        PageBase.doClickOnWebElement(drpdwn_EmploymentStatus_Value,5);
    }
    public void userEnterTheCompanyName(){
        PageBase.doClickOnWebElement(txt_CompanyName,5);
        PageBase.doSendKeys(txt_CompanyName,"Lendo");
    }
    public void userSelectTheNatureOfBusinessDrodpownValue() {
        PageBase.doClickOnWebElement(drpdwn_NatureOfBusiness,5);
        PageBase.doClickOnWebElement(drpdwn_NatureOfBusiness_Value,5);
    }
    public void userGetTheVerificationStep6Text(){
        String step6text = PageBase.doGetText(txt_VerificationStep6);
        System.out.println("Verification sixth step text is : " + step6text);
    }
    public void userSelectTheQ1AsNo() {
        PageBase.doClick(radioBtn_q1_no);
     }
    public void userSelectTheQ2AsNo() {
        PageBase.doClick(radioBtn_q2_no);
    }
    public void userSelectTheQ3AsNo() {
        PageBase.doClick(radioBtn_q3_no);
    }
    public void userSelectTheQ4AsNo() {
        PageBase.doClick(radioBtn_q4_no);
    }
    public void userClickOnFinishBtn() {
        PageBase.doClickOnWebElement(btn_finish,5);
    }
    public void userGetTheSuccessfulVerificationMsg(){
        String getSuccessMsg = PageBase.doGetText(txt_SuccessfulVerification);
        System.out.println("Successful verification message is + " + getSuccessMsg);
        Assert.assertNotNull(getSuccessMsg);
    }
    public void userGetTheContractBanner(){
      String getContractBannerTxt =   PageBase.doGetText(txt_ContractBanner);
      System.out.println("Get the contract banner text as :" + getContractBannerTxt);
      Assert.assertNotNull(getContractBannerTxt);
    }
    public void userClickOnReadAndAcceptLink() throws InterruptedException {
        PageBase.doClick(link_ReadAndAcceptContract);
        Thread.sleep(8000);
    }
    public void userClickOnAcceptContractBtn() throws InterruptedException {
        PageBase.ScrollDownPageUsingKeys();
        Thread.sleep(5000);
        PageBase.doClick(btn_ContractAccept);
        PageBase.isElementPresent(txt_ContractBanner);
    }
    public void userGetTheUnderReviewBannerText(String expectedUnderReviewBannerText){
        String getUnderReviewBannerTxt =   PageBase.doGetText(txt_UnderReviewBanner);
        System.out.println("Get the under review banner text as :" + getUnderReviewBannerTxt);
        Assert.assertEquals(getUnderReviewBannerTxt,expectedUnderReviewBannerText,"Under Review banner text is mismatched");
    }



//        public void enterEmailId(String email){
//            driver.findElement(emailId).sendKeys(email);
//        }
//        public void enterPassword(String pwd){
//            driver.findElement(password).sendKeys(pwd);
//        }
//        public void clickOnContinue(){
//            driver.findElement(continueButton).click();
//        }
//        public boolean isButtonDisplayed(){
//            driver.findElement(depositButton).isDisplayed();
//            return true;
//        }
//        public boolean isButtonEnabled(){
//            driver.findElement(depositButton).isEnabled();
//            return true;
//        }
//        public void concurrentLoginPopup(){
//            if(driver.findElement(concurrentLoginPopupBtn).isDisplayed()){
//                driver.findElement(concurrentLoginPopupBtn).click();
//            }
//            else {
//                System.out.println("Concurrent login popup not present");
//            }
//        }
}
