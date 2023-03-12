package pages.Investor;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.PageBase;

import java.util.List;

public class Investor_OverviewPage {
    private final WebDriver driver;
    //1. By locators
    private final By overviewLink = By.xpath("//a[text() = 'Overview']");
    private final By link_Invest = By.xpath("//a[text() = 'Invest']");
    private final By link_AccountStatment = By.xpath("//a[text() = 'Account Statement']");
    private final By link_MyPortfolio = By.xpath("//a[text() = 'My Portfolio']");
    private final By link_ChangeLanguage = By.xpath("//span[@title= 'Change language']");
    private final By link_walletBalance = By.xpath("//span[text() = 'Wallet Balance']");
    private final By btn_Deposit = By.xpath("//button[text() = 'Deposit']");
    private final By btn_Withdraw = By.xpath("//button[text() = 'Withdraw']");
    private final By p_shariahCompliance = By.xpath("//p[text() = 'How does Lendo ensure Shari’ah compliance?']");
    private final By btn_Invest = By.xpath("//a[text() = 'Invest Now']");
    private final By txt_AvgROI = By.xpath("//p[text() = 'Avg. ROI']");
    private final By txt_TotalInvestmentSection = By.xpath("//p[text() = 'Total Investment']");
    private final By txt_TotalEarned = By.xpath("//p[text() = 'Total Earned']");
    private final By txt_ExpectedTotalRepayment = By.xpath("//span[text() = 'Expected Total Repayment']");
    private final By btn_ViewPortfolio = By.xpath("//a[text() = 'View Portfolio']");
    private final By text_financingOpportunity = By.xpath("//div[@class = 'd-flex justify-content-between align-items-center']//h2[text()='Financing Opportunities']");

    //2. Constructor
    public Investor_OverviewPage(WebDriver driver) {
        this.driver = driver;
    }

    //3. page actions: features(behavior) of the page the form of methods:
    public int getInvestorDashboardVisibleElementsCount() {
        return driver.findElements(overviewLink).size() - 1;
    }

    public String getInvestorDashboardPageTitle() {
         return driver.getTitle();
    }

    public boolean isOverviewMenuLinkDisplayed() {
        driver.findElement(overviewLink).isDisplayed();
        return true;
    }

    public boolean isInvestMenuLinkDisplayed() {
        driver.findElement(link_Invest).isDisplayed();
        return true;
    }

    public boolean isAccountStatmentMenuLinkDisplayed() {
        driver.findElement(link_AccountStatment).isDisplayed();
        return true;
    }

    public boolean isMyPortfolioMenuLinkDisplayed() {
        driver.findElement(link_MyPortfolio).isDisplayed();
        return true;
    }

    public boolean isChangeLanguageLinkDisplayed() {
        driver.findElement(link_ChangeLanguage).isDisplayed();
        return true;
    }

    public boolean isWalletBalanceLinkDisplayed() {
        driver.findElement(link_walletBalance).isDisplayed();
        return true;
    }

    public boolean isDepositButtonDisplayed() {
        driver.findElement(btn_Deposit).isDisplayed();
        return true;
    }

    public boolean isWithdrawButtonDisplayed() {
        driver.findElement(btn_Withdraw).isDisplayed();
        return true;
    }

    public boolean isShariahComplianceContentDisplayed() {
        driver.findElement(p_shariahCompliance).isDisplayed();
        return true;
    }

    public boolean isInvestButtonDisplayed() {
        driver.findElement(btn_Invest).isDisplayed();
        return true;
    }

    public boolean isAvgROITextDisplayed() {
        driver.findElement(txt_AvgROI).isDisplayed();
        return true;
    }

    public boolean isTotalInvestmentSectionInvestTextDisplayed() {
        driver.findElement(txt_TotalInvestmentSection).isDisplayed();
        return true;
    }

    public boolean isTotalEarnedTextDisplayed() {
        driver.findElement(txt_TotalEarned).isDisplayed();
        return true;
    }

    public boolean isExpectedTotalRepaymentTextDisplayed() {
        driver.findElement(txt_ExpectedTotalRepayment).isDisplayed();
        return true;
    }

    public void ClickOnInvestButton() {
        PageBase.doClick(btn_Invest);
//       //PageBase.doClickOnWebElement(btn_Invest,15);
//        driver.findElement(btn_Invest).click();
        System.out.println("element is clicked");
    }

//    public String isAvgROISectionDisplayed() {
////        String avgText = driver.findElement(section_AvgROI).getText();
////        System.out.println("AvgROI section should be displayed" + avgText);
//        return driver.findElement(section_AvgROI).getText();
//    }


//     public List <String> getInvestorDashboardVisibleElementsList(){
//        List<String>investorDashboardList = new ArrayList<>();
//        List<WebElement> list_InvestorDashboardVisibleElements = driver.findElements(overviewLink);
//        for(WebElement e : list_InvestorDashboardVisibleElements){
//           String text = e.getText();
//            System.out.println(text);
//            investorDashboardList.add(text);
//        }
//        return investorDashboardList;
//    }
    public boolean isViewPortfolioButtonDisplayed() {
    driver.findElement(btn_ViewPortfolio).isDisplayed();
    return true;
    }
    public List<WebElement> getInvestorDashboardVisibleElementsList() {
        //  List<String>investorDashboardList = new ArrayList<>();
        List<WebElement> list_InvestorDashboardVisibleElements = driver.findElements(By.tagName("a"));

        for (WebElement e : list_InvestorDashboardVisibleElements) {
            String text = e.getAttribute("href");
            System.out.println(text);
            //investorDashboardList.add(text);
        }
        return list_InvestorDashboardVisibleElements;
    }
    public void userClickOnInvestMenuLink(){
        PageBase.doClickOnWebElement(link_Invest,20);
        System.out.println("Navigated to the Invest page");
    }
    public void verifyUserIsOnInvestPage() throws InterruptedException {
        Thread.sleep(5000);
       boolean isFinancingOpportunityTxtDisplayed = PageBase.IsElementDisplayedOnUI(text_financingOpportunity);
        System.out.println("Financing Opportunity text is displayed :"+ isFinancingOpportunityTxtDisplayed);
    }
}