package factory;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.PageBase;

public class CustomFactory {
    /*
    *Factory design pattern is used when we have a super class with multiple sub-classes and based on input,
    * we need to return one of the sub-class instance
    * Super class - PageBase -> LoginPage,InvestorOverviewPage so on
    * Navigation -: Based on input we need to have an instance of correct page class
    */

    public static PageBase getInstance(PageName name, WebDriver driver){
        switch(name){
            case LoginPage :
                return new LoginPage(driver);
//            case Investor_OverviewPage:
//                return new InvestorOverviewPageClass(driver);
//            case Investor_InvestPage:
//                return new InvestorInvestPageClass(driver);
//                break;

            default:
                throw new RuntimeException("Invalid Page Name");
        }

    }
}
