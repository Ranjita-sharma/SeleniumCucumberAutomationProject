package pages.Investor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.PageBase;

public class Investor_InvestPage {
    private final WebDriver driver;

    //1. locators
    private final By link_Invest = By.xpath("//a[text() = 'Invest']");
    private final By text_financingOpportunity = By.xpath("//div[@class = 'd-flex justify-content-between align-items-center']//h2[text()='Financing Opportunities']");
    private static final By btn_InvestViewSetting = By.xpath("//a[text()='View Settings']");
    private static final By txt_InvestPageHeader = By.xpath("//h2[@class= 'mb-4 d-none d-md-block'][text() = 'Auto Investment'][1]");
    private static final By txt_InvestSettingPageHeader = By.xpath("//*[text()='Auto Invest']");
    private static final By txt_InvestSuccessFee =  By.xpath("//div[text()='Lendo charges 30% success fee on profits made through auto invest.']");
    //Activate and deactivate Auto Invest
    private static final By btn_AutoInvestToggle =  By.xpath("//span[text() = 'Deactivated']");
    private static final By btn_AutoInvestToggleDeactivated =  By.xpath("//button[@class='ant-switch custom-switchbtn']");
    private static final By txt_AutoInvestToggleActivated =  By.xpath("//span[text()='Activated']");
    //Strategy
    private static final By txt_SelectStrategy =  By.xpath("//h3[text()='Select a strategy']");
    private static final By txt_ModerateStrategy =  By.xpath("//h6[text()='Moderate']");
    private static final By txt_ModerateStrategyInfo =  By.xpath("//Strong[text()='Moderate']");
    private static final By txt_ModerateStrategyPara =  By.xpath("//p[text()='A portfolio with diversified risks and optimal expected return.']");
    private static final By txt_ConservativeStrategy =  By.xpath("//h6[text()='Conservative']");
    private static final By txt_ConservativeInfo =  By.xpath("//Strong[text()='Conservative']");
    private static final By txt_ConservativePara =  By.xpath("//p[text()='A portfolio with least risks and highest probability of repayment.']");
    private static final By txt_AggresiveStrategy =  By.xpath("//h6[text()='Aggressive']");
    private static final By txt_AggresiveInfo =  By.xpath("//Strong[text()='Aggressive']");
    private static final By txt_AggresivePara =  By.xpath("//p[text()='A portfolio with highest risks and  highest returns.']");
    private static final By txt_CustomStrategy =  By.xpath("//h6[text()='Custom']");
    private static final By txt_CustomInfo =  By.xpath("//Strong[text()='Custom']");
    private static final By txt_CustomPara =  By.xpath("//p[text()='For investors who want to create their own strategy.']");
    private static final By txt_ExpectedRiskScoreDiversification =  By.xpath("//h3[text() = 'Expected Risk Score ']");
    private static final By txt_Default_A_RiskScore_Moderate =  By.xpath("//html//div[@id='left-tabs-example-tabpane-1']/div/div[1]/div[@class='col-md-6']/div[@class='card card-list-third mt-4']//span[.='A - 25%']");
    private static final By txt_Default_B_RiskScore_Moderate =  By.xpath("/html//div[@id='left-tabs-example-tabpane-1']/div/div[1]/div[@class='col-md-6']/div[@class='card card-list-third mt-4']//span[.='B - 40%']");
    private static final By txt_Default_C_RiskScore_Moderate =  By.xpath("/html//div[@id='left-tabs-example-tabpane-1']/div/div[1]/div[@class='col-md-6']/div[@class='card card-list-third mt-4']//span[.='C - 20%']");
    private static final By txt_Default_D_RiskScore_Moderate =  By.xpath("/html//div[@id='left-tabs-example-tabpane-1']/div/div[1]/div[@class='col-md-6']/div[@class='card card-list-third mt-4']//span[.='D - 15%']");
    private static final By txt_Default_A_RiskScore_Conservative =  By.xpath("/html//div[@id='left-tabs-example-tabpane-2']/div/div[1]/div[@class='col-md-6']/div[@class='card card-list-third mt-4']//span[.='A - 60%']");
    private static final By txt_Default_B_RiskScore_Conservative =  By.xpath("/html//div[@id='left-tabs-example-tabpane-2']/div/div[1]/div[@class='col-md-6']/div[@class='card card-list-third mt-4']//span[.='B - 40%']");
    private static final By txt_Default_C_RiskScore_Conservative =  By.xpath("/html//div[@id='left-tabs-example-tabpane-2']/div/div[1]/div[@class='col-md-6']/div[@class='card card-list-third mt-4']//span[.='C - 0%']");
    private static final By txt_Default_D_RiskScore_Conservative =  By.xpath("/html//div[@id='left-tabs-example-tabpane-2']/div/div[1]/div[@class='col-md-6']/div[@class='card card-list-third mt-4']//span[.='D - 0%']");
    private static final By txt_Default_A_RiskScore_Aggresive =  By.xpath("/html//div[@id='left-tabs-example-tabpane-3']/div/div[1]/div[@class='col-md-6']/div[@class='card card-list-third mt-4']//span[.='A - 10%']");
    private static final By txt_Default_B_RiskScore_Aggresive =  By.xpath("/html//div[@id='left-tabs-example-tabpane-3']/div/div[1]/div[@class='col-md-6']/div[@class='card card-list-third mt-4']//span[.='B - 20%']");
    private static final By txt_Default_C_RiskScore_Aggresive =  By.xpath("/html//div[@id='left-tabs-example-tabpane-3']/div/div[1]/div[@class='col-md-6']/div[@class='card card-list-third mt-4']//span[.='C - 40%']");
    private static final By txt_Default_D_RiskScore_Aggresive =  By.xpath("/html//div[@id='left-tabs-example-tabpane-3']/div/div[1]/div[@class='col-md-6']/div[@class='card card-list-third mt-4']//span[.='D - 30%']");
    //Investment per loan
    private static final By txt_MaxInvestmentPerLoan =  By.xpath("//*[text() = 'Maximum Investment Per Loan']");
    private static final By input_MaxInvestmentPerLoan =  By.xpath("//input[@type = 'text']");
    private final By txt_SARForInvestmentLoan =  By.xpath("//span[text() = 'SAR']");
    private static final By txt_LoanDuration =  By.xpath("//*[text() = 'Loan Duration']");
    private static final By input_MinNumOfLoanDays =  By.xpath("//p[text()= 'Min']/following-sibling::input");
    private static final By input_MaxNumOfLoanDays =  By.xpath("//p[text()= 'Max']/following-sibling::input");
    private final By popupTxt_EntersMinAmountForInvestmentEqualsToZero =  By.xpath("//div[text()= 'Minimum Amount for investment should be more than 0']");
    private static final By btn_Onpopup_OK =  By.xpath("//button[text()= 'OK']");
    private static final By btn_Save =  By.xpath("//button[text()= 'Save']");
    private static final By btn_Close =  By.xpath("//div[@class ='cursor-pointer close-modal-icon']");
    private static final By popup_text_confirmation = By.xpath("//div[text()='Auto Invest Updated Successfully']");
    private static final By popup_text_AfterToggleClicked = By.xpath(" //div[text()='Are you sure you want to change auto-invest settings?']");
    private static final By popupTxt_EntersMaxAmountLessThanToMinAmount =  By.xpath("//p[text()= 'Max loan duration should be less than min loan duration']");
    private static final By popupTxt_EntersMinAmountEqualsToMaxAmount =  By.xpath("//div[text()= 'Min loan duration cannot be equal to Max loan duration']");
    private static final By popupTxt_BlankMaxMinfield =  By.xpath("//div[text() ='Min loan duration cannot be equal to Max loan duration']");
    private static final By popupTxt_MinFieldIsRequired =  By.xpath("//div[text() ='Min Loan Duration is Required']");
    private static final By popupTxt_MaxFieldIsRequired =  By.xpath("//div[text() ='Max Loan Duration is Required']");
    private static final By btn_OnPopup_Yes =  By.xpath("//button[text()= 'Yes']");
    private static final By btn_OnPopup_Cancel =  By.xpath("//button[text()= 'Cancel']");
    private static final By text_QuestionHeading = By.xpath("//h3[text() = 'You Might Want to Know']");

    private static final By txt_AutoInvetQ1 = By.xpath("//div[text()= 'What is Auto-Invest?']");
    private static final By txt_AutoInvetQ2 = By.xpath("//div[text()= 'Can I use different ways of investing at the same time?']");
    private static final By txt_AutoInvetQ3 = By.xpath("//div[text()= 'Can I turn off auto-invest feature ?']");
    private static final By txt_AutoInvetAns1 = By.xpath("//p[starts-with(text(), 'Automatically')]");
    private static final By txt_AutoInvetAns2 = By.xpath("//p[text() = 'You can use auto-invest and invest manually at the same time.']");
    private static final By txt_AutoInvetAns3 = By.xpath("//p[text() = 'You can pause or cancel Auto Invest at any time.']");
    private static final By btn_AutoInvetCollapse1 =By.xpath("//div[@class='ant-collapse-header']");
    private static final By btn_AutoInvetCollapse2 = By.xpath("//div[@class= 'ant-collapse-item'][2]");
    private static final By btn_AutoInvetCollapse3 = By.xpath("//div[@class= 'ant-collapse-item'][3]");
    private static final By btn_AutoInvetExpand = By.xpath("//div[@class='ant-collapse-item ant-collapse-item-active']");

    //2. Constructor
    public Investor_InvestPage(WebDriver driver){
        this.driver = driver;
    }

    //3. Action methods on this page
    public void userClickOnInvestMenuLink(){
        PageBase.doClickOnWebElement(link_Invest,20);
        System.out.println("Navigated to the Invest page");
    }
    public void verifyUserIsOnInvestPage() throws InterruptedException {
        Thread.sleep(5000);
        boolean isFinancingOpportunityTxtDisplayed = PageBase.IsElementDisplayedOnUI(text_financingOpportunity);
        System.out.println("Financing Opportunity text is displayed :"+ isFinancingOpportunityTxtDisplayed);
    }
    public static String getTheAutoInvestmentTextOnInvestPage() throws InterruptedException {
        Thread.sleep(1000);
     return   PageBase.doGetText(txt_InvestPageHeader);
    }
    public static String getTheAutoInvestmentTextOnSettingPage(){
        return   PageBase.doGetText(txt_InvestSettingPageHeader);
    }
    public static void verifyAndClickOnViewSettingBtn() throws InterruptedException {
       Thread.sleep(2000);
    //    PageBase.IsElementDisplayedOnUI(btn_InvestViewSetting);
        PageBase.doClickOnWebElement(btn_InvestViewSetting,2000);
    }
    public static String getTheAutoInvestSuccessFeesPercText(){
        return   PageBase.doGetText(txt_InvestSuccessFee);
    }
    public static void verifyAndClickOnToggleButton() throws InterruptedException {
        Thread.sleep(2000);
        //    PageBase.IsElementDisplayedOnUI(btn_InvestViewSetting);
        PageBase.doClickOnWebElement(btn_AutoInvestToggleDeactivated,20);
      //  PageBase.acceptAlert(driver);
    }
    public static boolean VerifyYesBtnOnPoup(String yes){
       return PageBase.IsElementDisplayedOnUI(btn_OnPopup_Yes);
        }
    public static boolean VerifyCancelBtnOnPoup(String cancel){
        return PageBase.IsElementDisplayedOnUI(btn_OnPopup_Cancel);
    }
    public static void userClickOnCancelButton(){
        PageBase.doClick(btn_OnPopup_Cancel);
    }
    public static void userClickOnYesButton(){
        PageBase.doClick(btn_OnPopup_Yes);
    }
    public static void userClickOnOkButton(){
        PageBase.doClick(btn_Onpopup_OK);
    }
    public static String userGetThePopupText(){
       return PageBase.doGetText(popup_text_confirmation);
    }
    public static String userGetThePopupTextAfterToggleAction(){
        return PageBase.doGetText(popup_text_AfterToggleClicked);
    }
    public static boolean verifyActivatedToggle() throws InterruptedException {
        Thread.sleep(2000);
      return  PageBase.IsElementDisplayedOnUI(txt_AutoInvestToggleActivated);
    }
    public static String userGetTheSelectStrategyText(){
        return PageBase.doGetText(txt_SelectStrategy);
    }
    public static void verifyAndSelectAnyStrategy() throws InterruptedException {
        //Moderate strategy test
        PageBase.doClickOnWebElement(txt_ModerateStrategy,20);
        String getModerateStrategyInfo = PageBase.doGetText(txt_ModerateStrategyInfo);
        System.out.println("Get the strategy Info as : " +getModerateStrategyInfo);
        Thread.sleep(2000);
        String getModerateStrategyPara =  PageBase.doGetText(txt_ModerateStrategyPara);
        System.out.println("Get the strategy Para as : " +getModerateStrategyPara);
        String getModerateStrategytxt = PageBase.doGetText(txt_ModerateStrategy);
        System.out.println("Get the strategy text as : " +getModerateStrategytxt);
        String getModerateStrategy_A_Score = PageBase.doGetText(txt_Default_A_RiskScore_Moderate);
        System.out.println("Default A score for Moderate strategy is : " + getModerateStrategy_A_Score );
        String getModerateStrategy_B_Score = PageBase.doGetText(txt_Default_B_RiskScore_Moderate);
        System.out.println("Default B score for Moderate strategy is : " + getModerateStrategy_B_Score );
        String getModerateStrategy_C_Score = PageBase.doGetText(txt_Default_C_RiskScore_Moderate);
        System.out.println("Default C score for Moderate strategy is : " + getModerateStrategy_C_Score );
        String getModerateStrategy_D_Score = PageBase.doGetText(txt_Default_D_RiskScore_Moderate);
        System.out.println("Default D score for Moderate strategy is : " + getModerateStrategy_D_Score );
        //Conservative strategy test
        PageBase.doClickOnWebElement(txt_ConservativeStrategy,20);
        String getConservativeStrategyText = PageBase.doGetText(txt_ConservativeStrategy);
        System.out.println("Get the strategy text as  : " + getConservativeStrategyText );
        String getConservativeStrategyInfo = PageBase.doGetText(txt_ConservativeInfo);
        System.out.println("Get the strategy Info as  : " + getConservativeStrategyInfo );
        String getConservativeStrategyPara = PageBase.doGetText(txt_ConservativePara);
        System.out.println("Get the strategy Info as  : " + getConservativeStrategyPara );
        String getConservativeStrategy_A_Score = PageBase.doGetText(txt_Default_A_RiskScore_Conservative);
        System.out.println("Default A score for Conservative strategy is : " + getConservativeStrategy_A_Score );
        String getConservativeStrategy_B_Score = PageBase.doGetText(txt_Default_B_RiskScore_Conservative);
        System.out.println("Default B score for Conservative strategy is : " + getConservativeStrategy_B_Score );
        String getConservativeStrategy_C_Score = PageBase.doGetText(txt_Default_C_RiskScore_Conservative);
        System.out.println("Default C score for Conservative strategy is : " + getConservativeStrategy_C_Score );
        String getConservativeStrategy_D_Score = PageBase.doGetText(txt_Default_D_RiskScore_Conservative);
        System.out.println("Default D score for Conservative strategy is : " + getConservativeStrategy_D_Score );
        //Custom strategy test
        PageBase.doClickOnWebElement(txt_CustomStrategy,20);
        String getCustomStrategyText = PageBase.doGetText(txt_CustomStrategy);
        System.out.println("Get the custom strategy text as : " + getCustomStrategyText);
        String getCustomInfo = PageBase.doGetText(txt_CustomInfo);
        System.out.println("Get the custom info as : " + getCustomInfo);
        String getCustomPara = PageBase.doGetText(txt_CustomPara);
        System.out.println("Get the Custom para as : " + getCustomPara);
        //Aggresive strategy test
        PageBase.doClickOnWebElement(txt_AggresiveStrategy,20);
        String getAggresiveStrategyText = PageBase.doGetText(txt_AggresiveStrategy);
        System.out.println("Get the strategy text as  : " + getAggresiveStrategyText );
        String getAggresiveStrategyTextInfo = PageBase.doGetText(txt_AggresiveInfo);
        System.out.println("Get the aggresive strategy Info as  : " + getAggresiveStrategyTextInfo );
        String getAggresiveStrategyTextPara = PageBase.doGetText(txt_AggresivePara);
        String getAggresiveStrategy_A_Score = PageBase.doGetText(txt_Default_A_RiskScore_Aggresive);
        System.out.println("Default A score for Aggresive strategy is : " + getAggresiveStrategy_A_Score );
        String getAggresiveStrategy_B_Score = PageBase.doGetText(txt_Default_B_RiskScore_Aggresive);
        System.out.println("Default B score for Aggresive strategy is : " + getAggresiveStrategy_B_Score );
        String getAggresiveStrategy_C_Score = PageBase.doGetText(txt_Default_C_RiskScore_Aggresive);
        System.out.println("Default C score for Aggresive strategy is : " + getAggresiveStrategy_C_Score );
        String getAggresiveStrategy_D_Score = PageBase.doGetText(txt_Default_D_RiskScore_Aggresive);
        System.out.println("Default D score for Aggresive strategy is : " + getAggresiveStrategy_D_Score );

    }
    public static String userGetTheMaxInvestLoanText(){
        return PageBase.doGetText(txt_MaxInvestmentPerLoan);
    }
    public static String userGetTheLoanDuraText(){
        return PageBase.doGetText(txt_LoanDuration);
    }
    public static void validateMinMaxLoanDurationField() throws InterruptedException {
       // PageBase.ScrollpageVertical();
        //Validate when user enters the Min value which is equal to Max value
         PageBase.doClickOnWebElement(input_MinNumOfLoanDays,20);
        PageBase.doClearText(input_MinNumOfLoanDays);
        String inputMinLoan = PageBase.doSendKeys(input_MinNumOfLoanDays, String.valueOf(1));
        System.out.println("Entered input Min loan duration as : " + inputMinLoan);
        Assert.assertNotNull(inputMinLoan,"Entered min loan duration input value is null");
        PageBase.doClickOnWebElement(input_MaxNumOfLoanDays,20);
        PageBase.doClearText(input_MaxNumOfLoanDays);
        String inputMaxLoan = PageBase.doSendKeys(input_MaxNumOfLoanDays, String.valueOf(1));
        System.out.println("Entered input Max loan duration as : " + inputMaxLoan);
        Assert.assertNotNull(inputMaxLoan,"Entered max loan duration input value is null");
        PageBase.doClickOnWebElement(btn_Save, 1000);
        String popupForEqualLoanDurValues = PageBase.doGetText(popupTxt_EntersMinAmountEqualsToMaxAmount);
        System.out.println("Get the Popup message when entered equal Min Max loan duration value is : " + popupForEqualLoanDurValues);
        Assert.assertEquals(popupForEqualLoanDurValues,"Min loan duration cannot be equal to Max loan duration","Popup message is mismatched");
        PageBase.doClickOnWebElement( btn_Onpopup_OK,20);

        //Validate when user enters the Min value which is less than Max value
        PageBase.doClickOnWebElement(input_MinNumOfLoanDays,20);
        PageBase.doClearText(input_MinNumOfLoanDays);
        String input_GreaterMinLoan = PageBase.doSendKeys(input_MinNumOfLoanDays, String.valueOf(50));
        System.out.println("Entered input Min loan duration as : " + input_GreaterMinLoan);
        Assert.assertNotNull(input_GreaterMinLoan,"Entered min loan duration input value is null");
        PageBase.doClickOnWebElement(input_MaxNumOfLoanDays,20);
        PageBase.doClearText(input_MaxNumOfLoanDays);
        String input_LessMaxLoan = PageBase.doSendKeys(input_MaxNumOfLoanDays, String.valueOf(30));
        System.out.println("Entered input Max loan duration as : " + input_LessMaxLoan);
        Assert.assertNotNull(input_LessMaxLoan,"Entered max loan duration input value is null");
        PageBase.doClickOnWebElement(btn_Save, 500);
        String popup_MaxAmountLessThanToMin = PageBase.doGetText(popupTxt_EntersMaxAmountLessThanToMinAmount);
        System.out.println("Get the Popup message when entered Max loan duration which is less than Min value : " + popup_MaxAmountLessThanToMin);
        Assert.assertEquals(popup_MaxAmountLessThanToMin,"Max loan duration should be less than min loan duration","Popup message is mismatched");
        PageBase.doClickOnWebElement(btn_Close,20);

        //Validate when user leaves Min and Max input field as blank and click on save button
//        PageBase.doClickOnWebElement(input_MinNumOfLoanDays, 20);
//        PageBase.doClearText(input_MinNumOfLoanDays);
//        PageBase.doClickOnWebElement(input_MaxNumOfLoanDays, 500);
//        PageBase.doClearText(input_MaxNumOfLoanDays);
//        Thread.sleep(2000);
//        PageBase.doClickOnWebElement(btn_Save, 20);
//        String popup_emptyMinMaxValues = PageBase.doGetText(popupTxt_BlankMaxMinfield);
//        System.out.println("Get the Popup message when leave the Min & Max loan duration  field as blank  : " + popup_emptyMinMaxValues);
//     //   Assert.assertEquals(popup_emptyMinMaxValues,"Min loan duration cannot be equal to Max loan duration","Popup message is mismatched");
//        PageBase.doClick( btn_Close);

        //Validate when user leave Min loan duration field as blank
//        PageBase.doClickOnWebElement(input_MaxNumOfLoanDays, 500);
//        PageBase.doClearText(input_MaxNumOfLoanDays);
//        PageBase.doClickOnWebElement(input_MaxNumOfLoanDays, 500);
//        String input_MaxLoan = PageBase.doSendKeys(input_MaxNumOfLoanDays, String.valueOf(10));
//        Thread.sleep(2000);
//        System.out.println("Entered input Max loan duration as : " + input_MaxLoan);
//        Assert.assertNotNull(inputMaxLoan,"Entered max loan duration input value is null");
//        PageBase.doClickOnWebElement(input_MinNumOfLoanDays, 20);
//        PageBase.doClearText(input_MinNumOfLoanDays);
//        Thread.sleep(2000);
//        PageBase.doClick(btn_Save);
//        String popup_emptyMinValue = PageBase.doGetText(popupTxt_MinFieldIsRequired);
//        System.out.println("Get the Popup message when leave the Min loan duration field as blank  : " + popup_emptyMinValue);
//        Assert.assertEquals(popup_emptyMinValue,"Min Loan Duration is Required","Popup message is mismatched");
//        PageBase.doClick( btn_Onpopup_OK);

        //Validate when user leave Max loan duration field as blank
//        Thread.sleep(5000);
//        PageBase.doClickOnWebElement(input_MaxNumOfLoanDays, 20);
//        PageBase.doClearText(input_MaxNumOfLoanDays);
//        String input_MinLoan = PageBase.doSendKeys(input_MinNumOfLoanDays, String.valueOf(10));
//        PageBase.doClearText(input_MaxNumOfLoanDays);
//        System.out.println("Entered input Min loan duration as : " + input_MinLoan);
//        Assert.assertNotNull(input_MinLoan,"Entered min loan duration input value is null");
//        PageBase.doClickOnWebElement(btn_Save, 5000);
//        String popup_emptyMaxValue = PageBase.doGetText(popupTxt_MaxFieldIsRequired);
//        System.out.println("Get the Popup message when leave the Max loan duration field as blank  : " + popup_emptyMaxValue);
//        Assert.assertEquals(popup_emptyMaxValue,"Max Loan Duration is Required","Popup message is mismatched");
//        PageBase.doClick( btn_Onpopup_OK);
//        Thread.sleep(5000);
    }
    public static String userGetTheHeadingText() throws InterruptedException {
        return PageBase.doGetText(text_QuestionHeading);
    }
    public static String verifyTheFirstAutoInvestQuestion() throws InterruptedException {
        return PageBase.doGetText(txt_AutoInvetQ1);
    }
    public static String verifyTheFirstAutoInvestAnswer() throws InterruptedException {
        PageBase.doClick(btn_AutoInvetCollapse1);
        return PageBase.doGetText(txt_AutoInvetAns1);
    }
    public static String verifyTheSecondAutoInvestQuestion() throws InterruptedException {
        PageBase.doClick(btn_AutoInvetExpand);
        PageBase.ScrollpageHorizontal(txt_AutoInvetQ3);
        return PageBase.doGetText(txt_AutoInvetQ2);
    }
    public static String verifyTheSecondAutoInvestAnswer() throws InterruptedException {
        PageBase.doClickOnWebElement(btn_AutoInvetCollapse2,500);
        //PageBase.WaitforDispalyed(txt_AutoInvetAns2);
        Thread.sleep(5000);
           return PageBase.doGetText(txt_AutoInvetAns2);
    }
    public static String verifyTheThirdAutoInvestQuestion() throws InterruptedException {
        PageBase.doClick(btn_AutoInvetExpand);
        return PageBase.doGetText(txt_AutoInvetQ3);
    }
    public static String verifyTheThirdAutoInvestAnswer() throws InterruptedException {
        PageBase.doClickOnWebElement(btn_AutoInvetCollapse2,500);
        return PageBase.doGetText(txt_AutoInvetAns3);
    }

    }
