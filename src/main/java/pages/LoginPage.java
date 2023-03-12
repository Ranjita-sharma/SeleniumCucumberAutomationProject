package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {
    private final WebDriver driver;

  //1. page Locators using By
private final By emailId = By.id("login_email");
private final By password = By.id("login_password");
private final By continueButton = By.xpath("//input[@type = 'submit']");
private final By forgotPwdLink = By.linkText("I forgot my password");
private final By dontHaveAnAccountLink = By.linkText("Don't have an account?");
private final By depositButton = By.xpath("//button[text() = 'Deposit']");
private final By enterOTP = By.xpath("//input[@type = 'number']");
private final By concurrentLoginPopupBtn = By.xpath("//button[@type= 'button']/span");
private final By verifyOTPBtn = By.xpath("//input[@type= 'button']");

//2. Constructor of the page class:
public LoginPage(WebDriver driver){
    super(driver);
    // super(driver);
    this.driver=driver;
  //  PageFactory.initElements(driver,this);
}
//3. page actions: features(behavior) of the page the form of methods:
    public String getLoginPageTitle(){
    return driver.getTitle();
    }
    public boolean isForgotPwdLinkExist(){
    return driver.findElement(forgotPwdLink).isDisplayed();
    }
    public boolean isDontHaveAnAccountLinkExist(){
        return driver.findElement(dontHaveAnAccountLink).isDisplayed();
    }
    public void enterEmailId(String email){
    driver.findElement(emailId).sendKeys(email);
    }
    public void enterPassword(String pwd){
        driver.findElement(password).sendKeys(pwd);
    }
    public void clickOnContinue(){
        driver.findElement(continueButton).click();
    }
    public boolean isButtonDisplayed(){
    driver.findElement(depositButton).isDisplayed();
        return true;
    }
    public boolean isButtonEnabled(){
        driver.findElement(depositButton).isEnabled();
        return true;
    }
    public void concurrentLoginPopup(){
       if(driver.findElement(concurrentLoginPopupBtn).isDisplayed()){
           driver.findElement(concurrentLoginPopupBtn).click();
       }
       else {
           System.out.println("Concurrent login popup not present");
       }
    }
    public void enterOTP(int otp){
    driver.findElement(enterOTP).sendKeys(String.valueOf (otp));
    }
    public void verifyOTP(){
    driver.findElement(verifyOTPBtn).click();
    }
    public void doLoginSuccessfully(String email, String pwd, int OTP) throws Exception {
        System.out.println("Login with:  " + email + " and " + pwd);
       driver.findElement(emailId).sendKeys(email);
        //doSendKeys(emailId,email);
       driver.findElement(password).sendKeys(pwd);
       // doSendKeys(password,pwd);
        driver.findElement(continueButton).click();
        Thread.sleep(2000);
        if(driver.findElement(concurrentLoginPopupBtn).isDisplayed()){
            driver.findElement(concurrentLoginPopupBtn).click();
            driver.findElement(enterOTP).sendKeys(String.valueOf (OTP));
        }
        else {
            System.out.println("Concurrent login popup not present");
            driver.findElement(enterOTP).sendKeys(String.valueOf (OTP));
        }
        PageBase.doClick(verifyOTPBtn);
        driver.findElement(verifyOTPBtn).click();
        Thread.sleep(5000);
       // takeSnapShot("AfterLoginPage");
        //return new Investor_OverviewPage(driver);




    }











/* Page factory is inbuilt mechanism which will use to identify and locating the webElement
Use @Findby annotation with WebElement
Use PageFactory.initElement()to initialize the web Element
*/
//    @FindBy(how = How.ID,using = "textEmail")
//    public WebElement textEmail;
//    @FindBy(how = How.ID,using = "textPassword")
//    public WebElement textPassword;
//    @FindBy(how = How.XPATH,using = "btnContinue")
//    public WebElement btnContinue;

    // create methods for the action to be performed on these webelements
//    public void login(String username,String password){
//        textEmail.sendKeys(username);
//        textPassword.sendKeys(password);
//        btnContinue.click();
//    }
}
