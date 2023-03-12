package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

public class PageBase {
    private static WebDriver driver;
    private static WebDriverWait wait;

    //page class Constructor and passing the webdriver
    public PageBase(WebDriver driver) {
        //super(driver);
        this.driver = driver;
    }

    //generics util wrappers:
    public static void doClick(By locator) {
        driver.findElement(locator).click();
    }

    public static String getPageTitle() {
        driver.getTitle();
        return null;
    }

    //send value
    public static String doSendKeys(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
        return text;
    }

    //clear value
    public static void doClearText(By locator) {
        driver.findElement(locator).clear();
    }

    public static void doPageRefresh() {
        driver.navigate().refresh();
    }

    //element Disabled/Enabled
    public static boolean isElementEnabled(By locator) {
        return driver.findElement(locator).isEnabled();
    }

    //element selected
    public static boolean isElementSelected(By locator) {
        return driver.findElement(locator).isSelected();
    }
    public static boolean isElementPresent(By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertTrue(element.isDisplayed());
        return true;
        }
    //Navigate back to browser
    public static void navigateBackToBrowser() {
        driver.navigate().back();
    }

    //Navigate forward
    public static void navigateForwardToBrowser() {
        driver.navigate().forward();
    }

    //get text
    public static String doGetText(By locator) {
        return driver.findElement(locator).getText();
    }

    //get element
    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    //handle dropdown elements
    public static void doSelectByVisibleText(By locator, String value) {
        Select select = new Select(getElement(locator));
        select.selectByVisibleText(value);
    }

    public void doSlectDropdownByIndex(By locator, int index) {
        Select select = new Select(getElement(locator));
        select.selectByIndex(index);
    }

    public void doSlectDropdownByValue(By locator, String value) {
        Select select = new Select(getElement(locator));
        select.selectByValue(value);
    }

    //above 3 select methods converts into one method ex - doSlectDropdownElement(enterOTP, Dropdown.VISIBLETEXT.toString(),"Test");
    public void doSlectDropdownElement(By locator, String type, String value) {
        Select select = new Select(getElement(locator));

        switch (type) {
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            case "visibleText":
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            default:
                System.out.println("please pass the correct selection criteria....");
                break;
        }
    }

    //explicit condition for click Action
    public static void doClickOnWebElement(By locator, long waitTimeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
        WebElement elements = null;
        elements = wait.until(ExpectedConditions.elementToBeClickable(locator));
        elements.click();
    }

    //accepting an alert from UI
    public static void acceptAlert(WebDriver driver) {
        driver.switchTo().alert().accept();
    }

    public void dismissAlert(WebDriver driver) {
        driver.switchTo().alert().dismiss();
    }

    //this method is for mouse hovering from one element to other element
    public void mouseHoverAndClickElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).click().build().perform();
    }

    //get window handle
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    public static boolean mousehover(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            wait.until(ExpectedConditions.elementToBeClickable(locator));
            WebElement el = driver.findElement(locator);
            Actions actions = new Actions(driver);
            actions.moveToElement(el).perform();
            System.out.println("Mouse hover on Element " + el);
            return true;

        } catch (Exception e) {
            return false;
        }
    }
    public static String tooltipText(By locator) {
        String tooltip = driver.findElement(locator).getAttribute("title");
        return tooltip;
    }
    public static String tooltipTextUsingActionClass(By locator, By locatorToolTipText, String value) {
        //Instantiate Action Class
        Actions actions = new Actions(driver);
        //Retrieve WebElement
        WebElement element = driver.findElement(locator);
        // Use action class to mouse hover
        actions.moveToElement(element).perform();

        WebElement toolTip = driver.findElement(locatorToolTipText);
        // To get the tool tip text and assert
        String toolTipText = toolTip.getText();
        System.out.println("toolTipText-->" + toolTipText);

        //Verification if tooltip text is matching expected value
        if (toolTipText.equalsIgnoreCase(value)) {
            System.out.println("Pass* : Tooltip matching expected value");
        } else {
            System.out.println("Fail : Tooltip NOT matching expected value");
        }
        return toolTipText;
    }
    public static void selectRadioButton(By locator, String value) {
        List<WebElement> select = driver.findElements(locator);
       // for(WebElement ele: option){
        for(WebElement element: select) {
            if (element.getAttribute("value").equalsIgnoreCase(value)) {
                element.click();
            }
        }
    }
    public static void uploadFile(By locator, String path){
        driver.findElement(locator).sendKeys(path);
    }
    public static void downloadFile(String href, String fileName) throws Exception{
        URL url = null;
        URLConnection con = null;
        int i;
        url = new URL(href);
        con = url.openConnection();
// Here we are specifying the location where we really want to save the file.
        File file = new File(".//OutputData//" + fileName);

        BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
        BufferedOutputStream bos = new BufferedOutputStream(
                new FileOutputStream(file));
        while ((i = bis.read()) != -1) {
            bos.write(i);
        }
        bos.flush();
        bis.close();
    }

    public static boolean WaitforDispalyed(By locator)

    {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return driver.findElement(locator).isDisplayed();
    }

    public static void WaitForElementToInvisible(By locator)
    {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
    public static void SwitchToFrame(By locator)
    {
       wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

    public static void SwitchToDefaultFrame()
    {
        driver.switchTo().defaultContent();
        System.out.println("Switched to default Content");
    }
    public static boolean IsElementDisplayedOnUI(By locator)
    {
        return driver.findElement(locator).isDisplayed();
    }
    public static boolean Elementselected(By locator)
    {
        return driver.findElement(locator).isSelected();
    }
    public static void ScrollpageHorizontal(By locator)
    {
        WebElement element = driver.findElement(locator);

        //This will scroll the page Horizontally till the element is found
        JavascriptExecutor javaScriptExecutor = ((JavascriptExecutor) driver);
        javaScriptExecutor.executeScript("arguments[0].scrollIntoView();", element);
    }
    public static void ScrollDownpageVertical(By locator)
    {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView();", locator);
    }
    public static void ScrollDownPageUsingKeys()
    {
        Actions a = new Actions(driver);
        //scroll down a page
        a.sendKeys(Keys.PAGE_DOWN).build().perform();
        //scroll up a page
       // a.sendKeys(Keys.PAGE_UP).build().perform();
    }
    public static void SelectDropdownWithoutSelectClass(By locator)
    {
        //find the dropdown using xpath
        WebElement dropdownElement = driver.findElement(locator);

//cast driver object to JavaScriptExecutor
        JavascriptExecutor jse = (JavascriptExecutor) driver;

//set the dropdown vaue t0 say 'Monday' using javascript
        jse.executeScript("arguments[0].value='India'", dropdownElement);

    }


//    public static void takeSnapShot(String fileWithPath) throws IOException{
//
//        //1. take screenshot and store it as a file format
//
//        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//
//        //2. copy the screenshot to desired location using copyfile method:
//
//        FileUtils.copyFile(srcFile, new File("/Users/USER/IdeaProjects/SeleniumCucumberAutomationProject/src/main/java/Screenshots/"+fileWithPath+".jpg"));
//




  //  }

}
