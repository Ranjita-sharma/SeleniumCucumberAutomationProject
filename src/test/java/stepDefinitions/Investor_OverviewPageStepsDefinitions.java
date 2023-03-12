package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Investor.Investor_OverviewPage;
import pages.LoginPage;
import qaFactory.DriverFactory;

import java.util.List;
import java.util.Map;

public class Investor_OverviewPageStepsDefinitions {
   //private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private final LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
  // private Investor_OverviewPage investorOverviewPage;
  private final Investor_OverviewPage investorOverviewPage = new Investor_OverviewPage(DriverFactory.getDriver());

    @Given("user has already logged into application")
    public void user_has_already_logged_into_application(DataTable credTable) throws Exception {
        List<Map<String,String>>credList = credTable.asMaps();
      String email =  credList.get(0).get("email");
      String password =  credList.get(0).get("password");

        DriverFactory.getDriver().get("http://stg.consumerclient.newlendo.com/");
       loginPage.doLoginSuccessfully(email,password,1111);
    // takeSnapShot("AfterLoginPageOnDashboard");

    }
    @Given("user is on dashboard page")
    public void userIsOnDashboardPage() {
      String title =  investorOverviewPage.getInvestorDashboardPageTitle();
        System.out.println("Investor dashboard page title is : " + title);
    }
    @Then("user gets Investor dashboard section")
    public void user_gets_investor_dashboard_section(DataTable visibleElementsTable) {
        List<String> expInvestorDashboardElementsList = visibleElementsTable.asList();
//        System.out.println("Expected Investors dashboard elements list:  " + expInvestorDashboardElementsList);
//        List<String> actualInvestorDashboardElementsList = investorOverviewPage.getInvestorDashboardVisibleElementsList();
//        System.out.println("Actual Investors dashboard elements list : " + actualInvestorDashboardElementsList);
//        Assert.assertTrue(expInvestorDashboardElementsList.containsAll(actualInvestorDashboardElementsList));
        List<WebElement> actualInvestorDashboardLinks = investorOverviewPage.getInvestorDashboardVisibleElementsList();
        System.out.println("Actual Investors dashboard elements list : " + actualInvestorDashboardLinks.toString());
        Assert.assertTrue(expInvestorDashboardElementsList.containsAll(actualInvestorDashboardLinks));
    }
    @And("Investor dashboard count should be {int}")
    public void investor_dashboard_count_should_be(Integer expectedElementsCount) {

        Assert.assertTrue( investorOverviewPage.getInvestorDashboardVisibleElementsCount()==expectedElementsCount);
    }


    @Then("user gets the all features are available")
    public void userGetsTheAllFeaturesAreAvailable() {
      boolean isOverviewLinkDisplayed = investorOverviewPage.isOverviewMenuLinkDisplayed();
        System.out.println("Overview menu link is displayed" + isOverviewLinkDisplayed);
      boolean isInvestBtnDisplayed=   investorOverviewPage.isInvestButtonDisplayed();
        System.out.println("Invest link is available" + isInvestBtnDisplayed);
       boolean isAccountStatmentLinkDisplayed = investorOverviewPage.isAccountStatmentMenuLinkDisplayed();
        System.out.println("Account Statement link is displayed" + isAccountStatmentLinkDisplayed);
      boolean isMyPortfolioLinkDisplayed = investorOverviewPage.isMyPortfolioMenuLinkDisplayed();
        System.out.println("My Portfolio link is displayed" + isMyPortfolioLinkDisplayed);
      boolean isDepositBtnDisplayed = investorOverviewPage.isDepositButtonDisplayed();
        System.out.println("Deposit button is displayed" + isDepositBtnDisplayed);
      boolean isWithdrawBtnDisplayed = investorOverviewPage.isWithdrawButtonDisplayed();
        System.out.println("Withdraw button is displayed" + isWithdrawBtnDisplayed);
      boolean isLanguageChangeLinkDisplayed = investorOverviewPage.isChangeLanguageLinkDisplayed();
        System.out.println("Language change link is displayed" + isLanguageChangeLinkDisplayed);
      boolean isShariahCompliContentDisplayed = investorOverviewPage.isShariahComplianceContentDisplayed();
        System.out.println("Shari’ah Compliance content is displayed" + isShariahCompliContentDisplayed);
      boolean isAvgROITextDisplayed = investorOverviewPage.isAvgROITextDisplayed();
        System.out.println("Avg ROI Text is displayed" + isAvgROITextDisplayed);
      boolean isExpectedTotalRepaymntTextDisplayed = investorOverviewPage.isExpectedTotalRepaymentTextDisplayed();
        System.out.println("Expected Total Repayment Text Displayed"+ isExpectedTotalRepaymntTextDisplayed);
      boolean isTotalEarnedTextDisplayed = investorOverviewPage.isTotalEarnedTextDisplayed();
        System.out.println("Total earned text is displayed" + isTotalEarnedTextDisplayed);
      boolean isTotalInvestmentSectionInvestTextDisplayed = investorOverviewPage.isTotalInvestmentSectionInvestTextDisplayed();
        System.out.println("Total Investment Section Invest Text is Displayed" + isTotalInvestmentSectionInvestTextDisplayed);
      boolean isWalletLinkDisplayed = investorOverviewPage.isWalletBalanceLinkDisplayed();
        System.out.println("Wallet link is displayed" + isWalletLinkDisplayed);
      boolean isInvestNowBtnDisplayed = investorOverviewPage.isInvestButtonDisplayed();
        System.out.println("Invest Now button is displayed" + isInvestNowBtnDisplayed);
      boolean isViewPortfolioDisplayed = investorOverviewPage.isViewPortfolioButtonDisplayed();
        System.out.println("View portfolio button is displayed" + isViewPortfolioDisplayed);

    }
    @And("user click on Invest Now button")
    public void userClickOnInvestNowButton() {
        investorOverviewPage.ClickOnInvestButton();
    }
//    @Then("user gets the AVG ROI details")
//    public void userGetsTheAVGROIDetails() {
//      String avgROI_text =   investorOverviewPage.isAvgROISectionDisplayed();
//        System.out.println("avg ROI text is : " + avgROI_text);
//    }
    @And("user click on Invest menu link")
    public void userClickOnInvestMenuLink() {
      investorOverviewPage.userClickOnInvestMenuLink();
    }
    @Then("navigate to Invest page")
    public void navigateToInvestPage() throws InterruptedException {
      investorOverviewPage.verifyUserIsOnInvestPage();
    }

}
