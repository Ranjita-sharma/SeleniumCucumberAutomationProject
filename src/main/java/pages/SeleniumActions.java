//package pages;
//
//import com.aventstack.extentreports.ExtentTest;
//import freemarker.core.Environment;
//import gherkin.ast.DataTable;
//import lombok.experimental.Helper;
//import org.joda.time.DateTime;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.ie.InternetExplorerOptions;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.util.List;
//import java.util.Random;
//
//public class SeleniumActions  {
//    private WebDriver driver;
//
//    public SeleniumActions(WebDriver driver){
//      //  super(driver);
//        this.driver=driver;
//
//        //This Class will call all Selenium Core Actions:
//            private static WebDriverWait wait;
//            internal const string dtlValidLocators = "Valid locators are id ,name ,content and attribute";
//            public static String elemdesc = String.Empty;
//            public static String loglevel = String.Empty;
//            public static int sectimeout = 0;
//
//            public static void InitializeWebDriver()
//            {
//
//                String starturl = ConfigurationManager.AppSettings.Get("BrowserURL");
//                String timeout = ConfigurationManager.AppSettings.Get("GlobalTimeout");
//                String browser = ConfigurationManager.AppSettings.Get("Browser");
//
//                loglevel = ConfigurationManager.AppSettings.Get("LogLevel");
//                sectimeout = int.class.Parse(timeout);
//
//                switch (browser.ToLower())
//                {
//                    case "chrome":
//                    {
//                        driver = new ChromeDriver();
//                        Capabilities capabilities = ((OpenQA.Selenium.Remote.RemoteWebDriver)driver).Capabilities;
//                        Console.WriteLine("==========================================");
//                        Console.WriteLine("Browser Version=> " + capabilities.GetCapability("version"));
//                        Console.WriteLine("==========================================");
//                        ngDriver = new NgWebDriver(driver);
//                        ngDriver.IgnoreSynchronization = true;
//                        ngDriver.Navigate().GoToUrl(starturl);
//                        ngDriver.Manage().Window.Maximize();
//                        CommonHelper.TraceLine("Launched browser with url: " + starturl);
//                        wait = new WebDriverWait(ngDriver, TimeSpan.FromSeconds(sectimeout));
//                        WaitforPageloadComplete();
//                        break;
//                    }
//                    case "ie":
//
//                    {
//                        var options = new InternetExplorerOptions();
//                        options.IgnoreZoomLevel = true;
//                        options.IntroduceInstabilityByIgnoringProtectedModeSettings = true;
//                        driver = new InternetExplorerDriver(options);
//                        ngDriver = new NgWebDriver(driver);
//                        ngDriver.IgnoreSynchronization = true;
//                        ngDriver.Navigate().GoToUrl(starturl);
//                        ngDriver.Manage().Window.Maximize();
//                        CommonHelper.TraceLine("Launched browser with url: " + starturl);
//                        wait = new WebDriverWait(ngDriver, TimeSpan.FromSeconds(sectimeout));
//                        break;
//                    }
//                    case "edge":
//                    {
//
//
//                        var options = new Microsoft.Edge.SeleniumTools.EdgeOptions();
//                        options.UseChromium = true;
//                        driver = new Microsoft.Edge.SeleniumTools.EdgeDriver(options);
//                        ngDriver = new NgWebDriver(driver);
//                        ngDriver.Navigate().GoToUrl(starturl);
//                        ngDriver.Manage().Window.Maximize();
//                        CommonHelper.TraceLine("Launched browser with url: " + starturl);
//                        wait = new WebDriverWait(ngDriver, TimeSpan.FromSeconds(sectimeout));
//                        break;
//                    }
//                    default:
//                    {
//                        break;
//                    }
//                }
//
//
//            }
//             public String getPageTitle(){
//             return driver.getTitle();
//             }
//
//            public  void RefreshBrowser()
//            {
//                driver.navigate().refresh();
//            }
//
//            public static void WaitforPageloadComplete()
//            {
//                wait.Until(driver => ((string)((IJavaScriptExecutor)driver).ExecuteScript("return document.readyState") == "complete"));
//            }
//            public static void WaitClick(IWebElement elem)
//            {
//                wait.Until(ExpectedConditions.ElementToBeClickable(elem));
//                //   elem.Click();
//                Actions actions = new Actions(driver);
//                actions.MoveToElement(elem).Click().Perform();
//                CommonHelper.TraceLine("Clicked Element " + elemdesc);
//            }
//
//            public static void WaitClick(By elem)
//            {
//                try
//                {
//                    wait.Until(ExpectedConditions.ElementIsVisible(elem));
//                    wait.Until(ExpectedConditions.ElementToBeClickable(elem));
//                    IWebElement el = driver.FindElement(elem);
//                    Actions actions = new Actions(driver);
//                    actions.MoveToElement(el).Click().Perform();
//                    CommonHelper.TraceLine("Clicked Element " + elemdesc);
//                }
//                catch (ElementClickInterceptedException eci)
//                {
//                    // If we get ElementClickInterceptedException
//                    CommonHelper.TraceLine("Is not clickable at point ???? " + eci);
//                    CommonHelper.TraceLine(" Ok ....Wait for 2 secs and Pretend as if nothing happened and Click again");
//                    WaitForLoad();
//                    Thread.Sleep(2000);
//                    IWebElement el = driver.FindElement(elem);
//                    Actions actions = new Actions(driver);
//                    actions.MoveToElement(el).Click().Perform();
//                    CommonHelper.TraceLine("Clicked Element " + elemdesc);
//                }
//                catch (Exception ex)
//                {
//                    CommonHelper.TraceLine("Other Error on Click " + ex);
//                }
//            }
//
//            public static bool mousehover(By elem)
//            {
//                try
//                {
//                    WebDriverWait wait = new WebDriverWait(ngDriver, TimeSpan.FromSeconds(3));
//                    wait.Until(ExpectedConditions.ElementIsVisible(elem));
//                    wait.Until(ExpectedConditions.ElementToBeClickable(elem));
//                    IWebElement el = driver.FindElement(elem);
//                    Actions actions = new Actions(driver);
//                    actions.MoveToElement(el).Perform();
//                    CommonHelper.TraceLine("Mouse hover on Element " + elemdesc); return true;
//                }
//                catch (Exception)
//                {
//                    return false;
//                }
//            }
//
//            public static void WaitforWellcountNonZero()
//            {
//
//                string wellcount = GetInnerText(PageObjects.DashboardPage.lblWelCount);
//
//                while (wellcount.Equals("0"))
//                {
//                    Thread.Sleep(1000);
//                    wellcount = GetInnerText(PageObjects.DashboardPage.lblWelCount);
//                    CommonHelper.TraceLine("Well count :" + wellcount);
//                }
//            }
//
//            public static void WaitforWellcountToBeNonZero()
//            {
//
//                string wellcount = GetInnerText(PageObjects.DashboardPage.lblWelCount);
//                int count = 0;
//                while (wellcount.Equals("0"))
//                {
//                    Thread.Sleep(1000);
//                    wellcount = GetInnerText(PageObjects.DashboardPage.lblWelCount);
//                    CommonHelper.TraceLine("Well count :" + wellcount);
//                    SeleniumActions.RefreshBrowser();
//                    SeleniumActions.WaitForLoad();
//                    count++;
//                    if (count > sectimeout)
//                    {
//                        CommonHelper.TraceLine("Well did not appear within specified timeout");
//                        break;
//                    }
//                }
//            }
//            public static void waitClickNG(IWebElement elem)
//            {
//                wait.Until(ExpectedConditions.ElementToBeClickable(elem));
//                //   elem.Click();
//                Actions actions = new Actions(driver);
//                actions.MoveToElement(elem).ClickAndHold().Perform();
//                CommonHelper.TraceLine("Clicked Element " + elemdesc);
//            }
//            public static void waittoSelect(By elem)
//            {
//                wait.Until(ExpectedConditions.ElementSelectionStateToBe(elem, true));
//                CommonHelper.TraceLine("Waited for Element to be Selected: " + elemdesc);
//            }
//
//            public static void WaitClickJS(By elem)
//            {
//                wait.Until(ExpectedConditions.ElementToBeClickable(elem));
//                ((IJavaScriptExecutor)driver).ExecuteScript("arguments[0].click();", driver.FindElement(elem));
//                CommonHelper.TraceLine("Clicked Element using JS:" + elemdesc);
//            }
//            public static void WaitClickDelay(IWebElement elem, int sec)
//            {
//                wait.Until(ExpectedConditions.ElementToBeClickable(elem));
//                //   elem.Click();
//                Actions actions = new Actions(driver);
//                Thread.Sleep(sec * 1000);
//                actions.MoveToElement(elem).Click().Perform();
//                CommonHelper.TraceLine("Clicked Element " + elemdesc);
//            }
//            public static void WaitClickDelay(By elem, int sec)
//            {
//                wait.Until(ExpectedConditions.ElementToBeClickable(elem));
//                //   elem.Click();
//                Actions actions = new Actions(driver);
//                Thread.Sleep(sec * 1000);
//                actions.MoveToElement(driver.FindElement(elem)).Click().Perform();
//                CommonHelper.TraceLine("Clicked Element " + elemdesc);
//            }
//
//            public static bool WaitforDispalyed(By elem)
//
//            {
//                wait.Until(ExpectedConditions.ElementToBeClickable(elem));
//                return driver.FindElement(elem).Displayed;
//            }
//
//            public static void WaitFirElemToInvisible(By elem)
//            {
//                wait.Until(ExpectedConditions.InvisibilityOfElementLocated(elem));
//
//
//            }
//
//            public static void SwitchToFrame(By elem)
//            {
//
//                wait.Until(ExpectedConditions.FrameToBeAvailableAndSwitchToIt(elem));
//                CommonHelper.TraceLine("Switched to Frame " + elemdesc);
//            }
//
//            public static void SwitchToDefaultFrame()
//            {
//
//                driver.SwitchTo().DefaultContent();
//                CommonHelper.TraceLine("Switched to default Content");
//            }
//
//
//            public static bool IsElementDisplayedOnUI(By elem)
//            {
//                return driver.FindElement(elem).Displayed;
//            }
//            public static bool Elementselected(By elem)
//            {
//                if (driver.FindElement(elem).Selected)
//                {
//                    return true;
//
//                }
//                else
//                    return false;
//            }
//            public static void SendText(By elem, string text, bool special = false)
//            {
//                wait.Until(ExpectedConditions.ElementToBeClickable(elem));
//                driver.FindElement(elem).Click();
//                driver.FindElement(elem).Clear();
//                Sendspecialkey(elem, "home");
//                if (special)
//                {
//                    Sendspecialkey(elem, "selectall");
//                    Sendspecialkey(elem, "delete");
//                    text = text.Replace("/", "");
//                    //sendspecialkey(elem, "home");
//                }
//                driver.FindElement(elem).SendKeys(text);
//                CommonHelper.TraceLine(string.Format("Entered Text {0} on Element: {1}", text, elemdesc));
//            }
//
//            public static void Send_Text(By elem, string text)
//            {
//
//                driver.FindElement(elem).SendKeys(text);
//                CommonHelper.TraceLine(string.Format("Entered Text {0} on Element: {1}", text, elemdesc));
//            }
//
//            public static void KendoTypeNSelect(By elem, string text, bool special = false)
//            {
//                WaitClick(elem);
//                driver.FindElement(elem).Clear();
//                driver.FindElement(elem).SendKeys(text);
//                CommonHelper.TraceLine(string.Format("Entered Text {0} on Element: {1}", text, elemdesc));
//                WaitForLoad();
//                wait.Until(ExpectedConditions.ElementIsVisible(By.XPath("//li[text()='" + text + "']")));
//                IWebElement kitem = GetElement("Xpath", "//li[text()='" + text + "']", text + "Item ");
//                wait.Until(ExpectedConditions.ElementToBeClickable(kitem));
//                //    wait.Until(ExpectedConditions.TextToBePresentInElement(kitem, text));
//                kitem.Click();
//                CommonHelper.TraceLine(string.Format("Selected Text {0} on dropdown: {1}", text, elemdesc));
//
//            }
//
//
//            public static void WellNavigatorSelect(By elem, string text, bool special = false)
//            {
//                WaitClick(elem);
//                driver.FindElement(elem).Clear();
//                driver.FindElement(elem).SendKeys(text);
//                CommonHelper.TraceLine(string.Format("Entered Text {0} on Element: {1}", text, elemdesc));
//                WaitForLoad();
//                wait.Until(ExpectedConditions.ElementIsVisible(By.XPath("//span[text()='" + text + "']")));
//                IWebElement kitem = GetElement("Xpath", "//span[text()='" + text + "']", text + "Item ");
//                wait.Until(ExpectedConditions.ElementToBeClickable(kitem));
//                //    wait.Until(ExpectedConditions.TextToBePresentInElement(kitem, text));
//                kitem.Click();
//                CommonHelper.TraceLine(string.Format("Selected Text {0} on dropdown: {1}", text, elemdesc));
//
//            }
//
//            public static void ScrollpageHorizontal()
//            {
//                //IJavascriptExecutor js = (JavascriptExecutor)driver;
//
//                IWebElement Element = driver.FindElement(By.XPath("//div[@col-id='Well.WellDepthDatumId']"));
//
//                //This will scroll the page Horizontally till the element is found
//                ((IJavaScriptExecutor)driver).ExecuteScript("arguments[0].scrollIntoView();", Element);
//            }
//
//
//
//            public static void Scrollpage(int pixel, bool scrollVertical = true)
//            {
//                if (scrollVertical)
//                {
//                    ((IJavaScriptExecutor)driver).ExecuteScript("window.scrollBy(0," + pixel + ")");
//                }
//                else
//                {
//                    ((IJavaScriptExecutor)driver).ExecuteScript("window.scrollBy(" + pixel + ",0)");
//                }
//            }
//
//            public static void Scrollscrollbar(int x, int y, By elem)
//            {
//                IWebElement el = driver.FindElement(elem);
//                Actions actions = new Actions(driver);
//                actions.MoveToElement(el).ClickAndHold().MoveByOffset(x, y).Release().Build().Perform();
//
//            }
//            public static void FileUploadDialog(string filename)
//            {
//                var AutoIT = new AutoItX3Lib.AutoItX3();
//                Thread.Sleep(2000);
//                if (AutoIT.WinExists("Open") == 1)
//                {
//                    AutoIT.WinWait("Open");
//                    AutoIT.WinActivate("Open");
//                    Thread.Sleep(1000);
//                    // AutoIT.Send(filename);
//                    AutoIT.ControlSetText("Open", "", "Edit1", filename);
//                    string rettxt = AutoIT.ControlGetText("Open", "", "Edit1");
//                    Assert.AreEqual(filename, rettxt, "AutoIT unable to enter Text in File Dialog text");
//                    AutoIT.Send("{Enter}");
//
//                }
//            }
//
//
//            public static System.Collections.ObjectModel.ReadOnlyCollection<IWebElement> CollectionOfControls(string searchBy, string searchValue, string desc)
//            {
//                //public static List<HtmlControl> documentManager_Categories { get { return TelerikObject.CollectionOfControls("htmldiv", "classname", "folderNames", "Document Manager Categories"); } }
//
//
//                System.Collections.ObjectModel.ReadOnlyCollection<IWebElement> elems = null;
//                elemdesc = desc;
//                CommonHelper.TraceLine(string.Format("For Control Control using searchby as {0} and searchvalue as {1}", searchBy, searchValue));
//            #region SearchCrieria
//                try
//                {
//
//                    switch (searchBy.ToLower())
//                    {
//                        case "id":
//                        {
//                            CommonHelper.TraceLine("Looking for Element: " + desc);
//                            elems = driver.FindElements(By.Id(searchValue));
//                            CommonHelper.TraceLine("Found Element: " + desc);
//                            break;
//                        }
//
//                        case "name":
//                        {
//                            elems = driver.FindElements(By.Name(searchValue));
//                            break;
//                        }
//                        case "xpath":
//                        {
//                            CommonHelper.TraceLine("Looking for Element: " + desc);
//                            wait.Until(ExpectedConditions.ElementIsVisible(By.XPath(searchValue)));
//                            elems = driver.FindElements(By.XPath(searchValue));
//                            CommonHelper.TraceLine("Found Element: " + desc);
//                            break;
//                        }
//                        case "tagname":
//                        {
//                            elems = driver.FindElements(By.TagName(searchValue));
//                            break;
//                        }
//                        default:
//                        {
//                            CommonHelper.TraceLine("Not Valid Locator: " + dtlValidLocators);
//                            break;
//                        }
//
//
//                    }
//                }
//                catch (Exception e)
//                {
//
//                    CommonHelper.TraceLine(string.Format("Unable to Find HTMLinputContril Type using {0},{1}", searchBy, searchValue));
//                    throw e;
//                }
//
//                return elems;
//            #endregion
//
//            }
//
//
//
//            public static string GetText(By elem, bool disabled = false)
//            {
//                if (!disabled)
//                {
//                    wait.Until(ExpectedConditions.ElementToBeClickable(elem));
//                }
//                return driver.FindElement(elem).GetAttribute("value");
//
//            }
//
//            public static string GetInnerText(IWebElement elem)
//            {
//                wait.Until(ExpectedConditions.ElementToBeClickable(elem));
//                return elem.Text;
//
//            }
//
//            public static string GetInnerText(By elem, bool stalecheck = true)
//            {
//                if (stalecheck)
//                {
//                    WaitForElement(elem);
//                }
//                return driver.FindElement(elem).Text;
//
//            }
//
//            public static string GetInnerTextForVisibleElement(By elem, bool stalecheck = true)
//            {
//                IWebElement welem = driver.FindElements(elem).FirstOrDefault(x => x.Displayed);
//                string text = welem.Text;
//                return text;
//
//            }
//            public static bool GetEnabledState(By elem)
//            {
//                WaitForElement(elem);
//                return driver.FindElement(elem).Enabled;
//
//            }
//
//            public static void SelectDropdownValue(By elem, string ddvalue)
//            {
//                wait.Until(ExpectedConditions.ElementToBeClickable(elem));
//                SelectElement sel = new SelectElement(driver.FindElement(elem));
//                sel.SelectByText(ddvalue);
//                CommonHelper.TraceLine(string.Format("Selected Text {0} on dropdown: {1}", ddvalue, elemdesc));
//
//
//            }
//
//            public static void SelectKendoDropdownValue(By elem, string ddvalue, bool ScrolltoView = false, bool useContains = false)
//            {
//
//                wait.Until(ExpectedConditions.ElementToBeClickable(elem));
//                // driver.FindElement(elem).Click();  ATS intermittent failures on click repalced with Action Class Click
//                WaitClick(elem);
//                WaitForLoad();
//                try
//                {
//                    if (useContains)
//                        wait.Until(ExpectedConditions.ElementIsVisible(By.XPath("//li[contains(text(),'" + ddvalue + "')]")));
//                    else
//                        wait.Until(ExpectedConditions.ElementIsVisible(By.XPath("//li[text()='" + ddvalue + "']")));
//                }
//                catch
//                {
//                    CommonHelper.TraceLine($"List Item timed out What Next ?");
//                    // Dont Throw but Proceeed/
//                }
//                IWebElement kitem = null;
//                try
//                {
//                    if (useContains)
//                        kitem = GetElement("Xpath", "//li[contains(text(),'" + ddvalue + "')]", elemdesc);
//                    else
//                        kitem = GetElement("Xpath", "//li[text()='" + ddvalue + "']", elemdesc);
//                }
//                catch
//                {
//                    // Dont Throw but Proceeed/
//                }
//                for (int i = 0; i < 5; i++) //max 5 attempts only; Handle ATS UPG VM Failure
//                {
//                    if (kitem != null)
//                    {
//                        break;
//                    }
//                    WaitForLoad();
//                    CommonHelper.TraceLine($"Seems like first click did not workor DOM did not render it propelry Try Re clcik attemtp {i + 1}");
//                    WaitClick(elem);//Previous action was Probblably not done
//                    try
//                    {
//                        kitem = GetElement("Xpath", "//li[text()='" + ddvalue + "']", elemdesc);
//                    }
//                    catch
//                    {
//                        // Dont get it still ?
//                    }
//                }
//                if (kitem == null)
//                {
//                    CommonHelper.TraceLine($"Did not get Element loaded on whatever I did ");
//                    throw new NoSuchElementException("Requied List Item not found despite 5 Retries");
//                }
//                wait.Until(ExpectedConditions.ElementToBeClickable(kitem));
//                wait.Until(ExpectedConditions.TextToBePresentInElement(kitem, ddvalue.TrimStart(' ').TrimEnd(' ')));
//                if (ScrolltoView)
//                {
//                    ((IJavaScriptExecutor)driver).ExecuteScript("arguments[0].scrollIntoView();", driver.FindElement(By.XPath("//li[text()='" + ddvalue + "']")));
//                    //  ((IJavaScriptExecutor)driver).ExecuteScript("arguments[0].scrollIntoView();", driver.FindElement(elem));
//                    CommonHelper.TraceLine(string.Format("Scrolled for Text {0} on dropdown: {1}", ddvalue, elemdesc));
//
//                }
//                //  kitem.Click();
//                WaitClick(kitem);
//                CommonHelper.TraceLine(string.Format("Selected Text {0} on dropdown: {1}", ddvalue, elemdesc));
//
//
//            }
//            public static void SelectKendoDropdownValuelist(By elem, string ddvalue)
//            {
//
//                ((IJavaScriptExecutor)driver).ExecuteScript("arguments[0].scrollIntoView();", driver.FindElement(elem));
//                CommonHelper.TraceLine(string.Format("Scrolled for Text {0} on dropdown: {1}", ddvalue, elemdesc));
//                WaitClick(elem);
//
//            }
//
//            public static void WaitForLoad()
//            {
//                bool check = true;
//                IWebElement loader = null;
//                try
//                {
//                    loader = driver.FindElement(By.XPath("//div[@class='loader']"));
//                    CommonHelper.TraceLine("Loader Appeared on UI");
//                }
//                catch (NoSuchElementException e)
//                {
//                    CommonHelper.TraceLine("Elem not found immeditaltey: " + e.InnerException);
//                }
//                catch (StaleElementReferenceException ste)
//                {
//                    CommonHelper.TraceLine("Stalte elem was found Handled !! " + ste.InnerException);
//                    Thread.Sleep(1000);
//                    loader = driver.FindElement(By.XPath("//div[@class='loader']"));
//                }
//                if (check)
//                {
//                    for (int i = 0; i < sectimeout; i++)
//                    {
//                        Thread.Sleep(1000);
//
//                        try
//                        {
//                            bool chk = loader.Displayed;
//                        }
//                        catch (StaleElementReferenceException ste)
//                        {
//                            CommonHelper.TraceLine("Stale elem was found Handled !! " + ste.InnerException);
//                            Thread.Sleep(2000);
//                            loader = driver.FindElement(By.XPath("//div[@class='loader']"));
//                        }
//                        catch (Exception exany)
//                        {
//                            CommonHelper.TraceLine("Other Expcetion while waiting for Loader !!!: " + exany.InnerException);
//                        }
//                        if (loader != null)
//                        {
//                            if (loader.Size == System.Drawing.Size.Empty)
//                            {
//                                CommonHelper.TraceLine("Loader Size Empty");
//                                break;
//                            }
//                            else
//                            {
//                                CommonHelper.TraceLine("Loader Size Not Empty");
//                            }
//                        }
//
//                    }
//                    CommonHelper.TraceLine("Loader has Disapapered from UI ");
//                }
//
//
//            }
//
//            public static void WaitForLoad(string spinnertext)
//            {
//                bool check = true;
//                IWebElement loader = null;
//                try
//                {
//                    // loader = driver.FindElement(By.XPath("//div[@class='loader']/following-sibling::div[text()='" + spinnertext + "']")); // old expression
//                    //Exact match may fail if HTML has extra  leading and Traling Spaces in text UI Inconsistency to talk about.
//                    loader = driver.FindElement(By.XPath("//div[@class='loader']/following-sibling::div[contains(text(),'" + spinnertext + "')]"));
//                    CommonHelper.TraceLine("Loader Appeared on UI");
//                }
//                catch (NoSuchElementException e)
//                {
//                    CommonHelper.TraceLine($"Elem not found immediately:  for {spinnertext} " + e.InnerException);
//                }
//                catch (StaleElementReferenceException ste)
//                {
//                    CommonHelper.TraceLine("Stalte elem was found Handled !! " + ste.InnerException);
//                    Thread.Sleep(1000);
//                    loader = driver.FindElement(By.XPath("//div[@class='loader']/following-sibling::div[text()='" + spinnertext + "']"));
//                }
//                if (check)
//                {
//                    if (loader != null)
//                    {
//                        CommonHelper.TraceLine($"Elem was found for spinner having text {spinnertext}");
//                    }
//                    for (int i = 0; i < sectimeout; i++)
//                    {
//                        Thread.Sleep(1000);
//                        try
//                        {
//                            bool chk = loader.Displayed;
//                        }
//                        catch (StaleElementReferenceException ste)
//                        {
//                            CommonHelper.TraceLine("Stale elem was found Handled !! " + ste.InnerException);
//                            Thread.Sleep(2000);
//                            loader = driver.FindElement(By.XPath("//div[@class='loader']/following-sibling::div[text()='" + spinnertext + "']"));
//                        }
//                        catch (Exception exany)
//                        {
//                            CommonHelper.TraceLine("Other Expcetion while waiting for Loader !!!: " + exany.InnerException);
//                        }
//                        if (loader != null)
//                        {
//                            if (loader.Size == System.Drawing.Size.Empty)
//                            {
//                                CommonHelper.TraceLine("Loader Size Empty");
//                                break;
//                            }
//                            else
//                            {
//                                CommonHelper.TraceLine("Loader Size Not Empty");
//                            }
//                        }
//                        else
//                        {
//                            //loade is null exit
//                            break;
//                        }
//
//
//                    }
//                    CommonHelper.TraceLine($"Loader having text {spinnertext} has Disapapered from UI ");
//                }
//
//
//            }
//
//            /// <summary>
//            /// New dynamic wait method created to handle multiple spinners that appeer
//            /// in Screens  like Well Status and RRL Well Analysis
//            /// </summary>
//            public static void WaitForLoaders()
//            {
//                bool check = true;
//                ReadOnlyCollection<IWebElement> loaders = null;
//                try
//                {
//                    loaders = driver.FindElements(By.XPath("//div[@class='loader']"));
//                    CommonHelper.TraceLine($" {loaders.Count}  - Loader(/s) Appeared on DOM (It may or may not have a physical size or visiblity in UI");
//                }
//                catch (NoSuchElementException e)
//                {
//                    CommonHelper.TraceLine("Elem not found immeditaltey: " + e.InnerException);
//                }
//                catch (StaleElementReferenceException ste)
//                {
//                    CommonHelper.TraceLine("Stalte elem was found Handled !! " + ste.InnerException);
//                    Thread.Sleep(1000);
//                    loaders = driver.FindElements(By.XPath("//div[@class='loader']"));
//                }
//                check = loaders.Count > 0;
//                if (check)
//                {
//                    int spinnerscount = 1;
//                    foreach (var item in loaders)
//                    {
//                        CommonHelper.TraceLine($"Waitng for First Loader/Spinner number {spinnerscount} ");
//                        for (int i = 0; i < sectimeout; i++)
//                        {
//                            Thread.Sleep(1000);
//                            if (item != null)
//                            {
//                                if (item.Size == System.Drawing.Size.Empty)
//                                {
//                                    CommonHelper.TraceLine($"Loader {spinnerscount} Size Empty");
//                                    break;
//                                }
//                                else
//                                {
//                                    CommonHelper.TraceLine("Dynamically waiting as Loader Size Not Empty");
//                                }
//                            }
//
//                        }
//                        CommonHelper.TraceLine($"Loader { spinnerscount} has Disapapered from UI ");
//                        spinnerscount++;
//                    }
//
//                }
//
//
//            }
//
//            public static void VerifyPlotTitleAxisTextVisibleLegends(string[] plottitle, string[] expectedaxistext, string[] expectedlegends)
//            {
//                //Verify Legends text is found on UI or Not
//                WaitForLoad();
//                List<string> elementsnotfound = new List<string>();
//                foreach (var text in expectedlegends)
//                {
//                    try
//                    {
//                        IWebElement legendtext = driver.FindElements(By.XPath("//*[text()='" + text + "']")).FirstOrDefault(x => x.Displayed);
//                    }
//                    catch (NoSuchElementException nse)
//                    {
//                        Helper.CommonHelper.TraceLine($"Errror finding Elemnt with text {text} Fault Error {nse.ToString()} ");
//                        elementsnotfound.Add(text);
//                    }
//
//                }
//                foreach (var text in expectedaxistext)
//                {
//                    try
//                    {
//                        IWebElement legendtext = driver.FindElements(By.XPath("//*[text()='" + text + "']")).FirstOrDefault(x => x.Displayed);
//                    }
//                    catch (NoSuchElementException nse)
//                    {
//                        Helper.CommonHelper.TraceLine($"Errror finding Elemnt with text {text} Fault Error {nse.ToString()} ");
//                        elementsnotfound.Add(text);
//                    }
//
//                }
//                foreach (var text in plottitle)
//                {
//                    try
//                    {
//                        IWebElement legendtext = driver.FindElements(By.XPath("//*[text()='" + text + "']")).FirstOrDefault(x => x.Displayed);
//                    }
//                    catch (NoSuchElementException nse)
//                    {
//                        Helper.CommonHelper.TraceLine($"Errror finding Elemnt with text {text} Fault Error {nse.ToString()} ");
//                        elementsnotfound.Add(text);
//                    }
//
//                }
//                if (elementsnotfound.Count > 0)
//                {
//                    Assert.Fail($"The Expected Chart text(s) were not found they are: ==>  { string.Join(";", elementsnotfound.ToArray())} ");
//                }
//            }
//
//            public static void VerifyItemsInKendoDropdown(By elem, string[] expectelistitemtext)
//            {
//                WaitClick(elem);
//                WaitForLoad();
//                IWebElement[] listitems = new IWebElement[] { };
//                List<string> elemtextlist = new List<string>();
//                try
//                {
//                    listitems = driver.FindElements(By.XPath("//li[@role='option']")).ToArray();
//                    foreach (var item in listitems)
//                    {
//                        elemtextlist.Add(item.Text);
//                    }
//                }
//                catch (StaleElementReferenceException)
//                {
//                    WaitForLoad();
//                    listitems = driver.FindElements(By.XPath("//li[@role='option']")).ToArray();
//                    foreach (var item in listitems)
//                    {
//                        elemtextlist.Add(item.Text);
//                    }
//                }
//                int i = 0;
//                Assert.AreEqual(expectelistitemtext.Length, elemtextlist.Count, "Dropdown List Elements count mismatch");
//                foreach (var item in elemtextlist)
//                {
//                    Assert.AreEqual(expectelistitemtext[i], item, $"mismatch for Item {expectelistitemtext[i]} != {elemtextlist}");
//                    i++;
//                }
//            }
//
//            public static void AddScreenshotInfo(ExtentTest test, string chartname)
//            {
//                string uniqimagename = chartname + DateTime.Now.ToString("MMddyyyymmhhss");
//                TakeScreenshot(uniqimagename);
//                test.Info(chartname, MediaEntityBuilder.CreateScreenCaptureFromPath((Path.Combine("Screenshots", uniqimagename + ".png"))).Build());
//            }
//
//            public static void AddErrorScreenshotInfo(ExtentTest test, string screenshotname)
//            {
//                string uniqimagename = screenshotname + DateTime.Now.ToString("MMddyyyymmhhss");
//                TakeScreenshot(uniqimagename);
//                test.Fail(screenshotname, MediaEntityBuilder.CreateScreenCaptureFromPath((Path.Combine("Screenshots", uniqimagename + ".png"))).Build());
//            }
//            public static string GetDropdowntext(IWebElement elem)
//            {
//                wait.Until(ExpectedConditions.ElementToBeClickable(elem));
//                SelectElement sel = new SelectElement(elem);
//                return sel.SelectedOption.Text;
//            }
//            public static string GetKendoDDSelectedText(By elem)
//            {
//                string txt = driver.FindElement(elem).Text;
//                string[] charactersToReplace = new string[] { Environment.NewLine, @"\t", @"\r\n", @"\n", @"\r" };
//                foreach (string s in charactersToReplace)
//                {
//                    txt = txt.Replace(s, "");
//                }
//                return txt;
//            }
//
//            public static void TakeScreenshot(string desc)
//            {
//
//                Screenshot ss = ((ITakesScreenshot)driver).GetScreenshot();
//                string screenshot = ss.AsBase64EncodedString;
//                byte[] screenshotAsByteArray = ss.AsByteArray;
//                string stamp = System.DateTime.Now.ToString("dd-MM-yyyy hh:mm:ss");
//                stamp = stamp.Replace("-", "");
//                stamp = stamp.Replace(":", "");
//                stamp = stamp.Replace(" ", "");
//                string strtimestamp = desc + ".png";
//                string imgpath = Path.Combine(ExtentFactory.screenshotdir, strtimestamp);
//                ss.SaveAsFile(imgpath, ScreenshotImageFormat.Jpeg);
//
//            }
//
//            public static void WaitForElement(By elem)
//            {
//
//                wait.Until(ExpectedConditions.ElementExists(elem));
//                if (driver.FindElement(elem).Enabled)
//                {
//                    PerformStalenessCheck(elem);
//                    wait.Until(ExpectedConditions.ElementToBeClickable(elem));
//                }
//                CommonHelper.TraceLine("Dynamicallay waited for Element " + elemdesc);
//            }
//            public static void StaticwaitForElement(int sec)
//            {
//                Thread.Sleep(sec * 1000);
//                CommonHelper.TraceLine("Dynamicallay waited for Element " + elemdesc);
//            }
//            public static bool IsElemPresent(By elem)
//            {
//                try
//                {
//                    wait.Until(ExpectedConditions.ElementIsVisible(elem));
//                    ngDriver.FindElement(elem);
//                    return true;
//                }
//                catch (NoSuchElementException noel)
//                {
//                    CommonHelper.TraceLine("Caught No Such Eleemnt Exception: ");
//                    if (loglevel.Equals("2"))
//                    {
//                        CommonHelper.TraceLine("error " + noel);
//                    }
//                    return false;
//                }
//                catch (StaleElementReferenceException stl)
//                {
//                    CommonHelper.TraceLine("Caught Stale Elemnt Ref Exception: ");
//                    if (loglevel.Equals("2"))
//                    {
//                        CommonHelper.TraceLine("error " + stl);
//                        Thread.Sleep(1000);
//                    }
//                    return false;
//                }
//                catch (Exception otherex)
//                {
//
//                    if (loglevel.Equals("2"))
//                    {
//                        CommonHelper.TraceLine("error " + otherex);
//                    }
//                    return false;
//                }
//
//            }
//
//            public static bool IsElemPresentWithoutWait(By elem)
//            {
//                try
//                {
//                    ngDriver.FindElement(elem);
//                    return true;
//                }
//                catch
//                {
//                    return false;
//                }
//            }
//
//            public static bool IsStale(By elem)
//            {
//                try
//                {
//                    ngDriver.FindElement(elem);
//                    return false;
//                }
//                catch (StaleElementReferenceException stl)
//                {
//                    CommonHelper.TraceLine("Caught Stale Elemnt Ref Exception: " + stl);
//                    Thread.Sleep(1000);
//                    return true;
//                }
//
//
//
//            }
//
//            public static String Getmonthname()
//            {
//                String dt = DateTime.Now.ToString("MMMM").Substring(0, 3);
//
//                return dt;
//            }
//            public static String Getday(int d)
//            {
//                String dt = DateTime.Now.AddDays(d).ToString("dd");
//
//                return dt;
//            }
//
//            public static void PerformStalenessCheck(By elem)
//            {
//                for (int i = 0; i < 5; i++)
//                {
//                    CommonHelper.TraceLine("Performing Staleness check");
//                    StaticwaitForElement(1);
//                    if (!IsStale(elem))
//                    {
//                        break;
//                    }
//                }
//            }
//
//            public static bool IsStale(IWebElement elem)
//            {
//                try
//                {
//                    bool chck = elem.Displayed;
//                    CommonHelper.TraceLine("Stale check Elem disaplyed ");
//                    return false;
//                }
//                catch (StaleElementReferenceException stl)
//                {
//                    CommonHelper.TraceLine("Caught Stale Elemnt Ref Exception: " + stl);
//                    Thread.Sleep(1000);
//                    return true;
//                }
//
//
//
//            }
//
//            public static IWebElement GetElement(string searchBy, string searchValue, string desc)
//            {
//                IWebElement ctl = null;
//                elemdesc = desc;
//                CommonHelper.TraceLine(string.Format("For Control Control using searchby as {0} and searchvalue as {1}", searchBy, searchValue));
//            #region SearchCrieria
//                try
//                {
//
//                    switch (searchBy.ToLower())
//                    {
//                        case "id":
//                        {
//                            CommonHelper.TraceLine("Looking for Element: " + desc);
//                            ctl = ngDriver.FindElement(By.Id(searchValue));
//                            CommonHelper.TraceLine("Found Element: " + desc);
//                            break;
//                        }
//
//                        case "name":
//                        {
//                            ctl = ngDriver.FindElement(By.Name(searchValue));
//                            break;
//                        }
//                        case "xpath":
//                        {
//                            CommonHelper.TraceLine("Looking for Element: " + desc);
//                            wait.Until(ExpectedConditions.ElementIsVisible(By.XPath(searchValue)));
//                            ctl = ngDriver.FindElement(By.XPath(searchValue));
//                            CommonHelper.TraceLine("Found Element: " + desc);
//                            break;
//                        }
//                        case "tagname":
//                        {
//                            ctl = ngDriver.FindElement(By.TagName(searchValue));
//                            break;
//                        }
//                        default:
//                        {
//                            CommonHelper.TraceLine("Not Valid Locator: " + dtlValidLocators);
//                            break;
//                        }
//
//
//                    }
//                }
//                catch (Exception e)
//                {
//
//                    CommonHelper.TraceLine(string.Format("Unable to Find HTMLinputContril Type using {0},{1}", searchBy, searchValue));
//                    throw e;
//                }
//            #endregion
//                return ctl;
//            }
//
//            public static By GetElementByIndexXpath(string searchBy, string searchValue, int index, string desc)
//            {
//                By ctl = null;
//                elemdesc = desc;
//
//            #region SearchCrieria
//                try
//                {
//
//                    switch (searchBy.ToLower())
//                    {
//
//                        case "xpath":
//                        {
//                            CommonHelper.TraceLine("Looking for Element: " + desc);
//                            string indexedxpath = "(" + searchValue + ")[" + index + "]";
//                            CommonHelper.TraceLine(string.Format("For Control Control using searchby as {0} and searchvalue as {1}", searchBy, indexedxpath));
//                            try
//                            {
//                                wait.Until(ExpectedConditions.ElementExists(By.XPath(indexedxpath)));
//                            }
//                            catch
//                            {
//
//                            }
//                            ctl = By.XPath(indexedxpath);
//                            CommonHelper.TraceLine("Found Element: " + desc);
//                            break;
//                        }
//
//                        default:
//                        {
//                            CommonHelper.TraceLine("Not Valid Locator: " + dtlValidLocators);
//                            break;
//                        }
//
//
//                    }
//                }
//                catch (Exception e)
//                {
//
//                    CommonHelper.TraceLine(string.Format("Unable to Find HTMLinputContril Type using {0},{1}", searchBy, searchValue));
//                    throw e;
//                }
//            #endregion
//                return ctl;
//            }
//
//            public static ReadOnlyCollection<IWebElement> GetElementsCollection(By elem)
//            {
//                ReadOnlyCollection<IWebElement> elems = null;
//                try
//                {
//                    wait.Until(ExpectedConditions.PresenceOfAllElementsLocatedBy(elem));
//                    elems = driver.FindElements(elem);
//                    return elems;
//                }
//                catch (Exception)
//                {
//                    return elems;
//                    throw;
//                }
//            }
//
//            public static ReadOnlyCollection<IWebElement> GetElementsCollection(IWebElement elem , By byloc)
//            {
//                ReadOnlyCollection<IWebElement> elems = null;
//                try
//                {
//                    elems = elem.FindElements(byloc);
//                    return elems;
//                }
//                catch (Exception)
//                {
//                    return elems;
//                    throw;
//                }
//            }
//
//            public static By GetElementByIndexXpathNextSibling(string searchBy, string searchValue, int index, string desc)
//            {
//                By ctl = null;
//                elemdesc = desc;
//
//            #region SearchCrieria
//                try
//                {
//
//                    switch (searchBy.ToLower())
//                    {
//
//                        case "xpath":
//                        {
//                            CommonHelper.TraceLine("Looking for Element: " + desc);
//                            string indexedxpath = "(" + searchValue + ")[" + index + "]";
//                            indexedxpath = indexedxpath + "/following-sibling::*[1]";
//                            CommonHelper.TraceLine(string.Format("For Control Control using searchby as {0} and searchvalue as {1}", searchBy, indexedxpath));
//                            try
//                            {
//                                wait.Until(ExpectedConditions.ElementIsVisible(By.XPath(indexedxpath)));
//                            }
//                            catch
//                            {
//
//                            }
//                            ctl = By.XPath(indexedxpath);
//                            CommonHelper.TraceLine("Found Element: " + desc);
//                            break;
//                        }
//
//                        default:
//                        {
//                            CommonHelper.TraceLine("Not Valid Locator: " + dtlValidLocators);
//                            break;
//                        }
//
//
//                    }
//                }
//                catch (Exception e)
//                {
//
//                    CommonHelper.TraceLine(string.Format("Unable to Find HTMLinputContril Type using {0},{1}", searchBy, searchValue));
//                    throw e;
//                }
//            #endregion
//                return ctl;
//            }
//
//            public static void Sendspecialkey(By elem, string data)
//            {
//                switch (data)
//                {
//
//                    case "selectall":
//                        driver.FindElement(elem).SendKeys(Keys.Control + "a");
//                        break;
//                    case "delete":
//                        driver.FindElement(elem).SendKeys(Keys.Delete);
//                        break;
//                    case "tab":
//                        driver.FindElement(elem).SendKeys(Keys.Tab);
//                        break;
//                    case "home":
//                        driver.FindElement(elem).SendKeys(Keys.Home);
//                        break;
//
//                    default:
//                        CommonHelper.TraceLine("Key values could not be found under sendspecialkey method");
//                        break;
//                }
//            }
//
//
//            public static void VerifyAnalysisReportTables(DataTable dt)
//            {
//                var table = GetTableByColumnName(dt.Rows[0]["FieldName"].ToString());
//                DataTable dact = new DataTable();
//                int rowcount = 0;
//                foreach (var rows in table.FindElements(By.TagName("tr")))
//                {
//                    DataRow dr = dact.NewRow();
//                    int colcnt = 0;
//                    var cells = rows.FindElements(By.TagName("td"));
//                    List<string> lstactstring = new List<string>();
//                    foreach (var item in cells)
//                    {
//                        string actcelltext = String.Empty;
//                        var spans = GetElementsCollection(item, By.TagName("span"));
//                        if (spans.Count == 0)
//                        {
//                            actcelltext = GetInnerText(item);
//                            lstactstring.Add(actcelltext);
//                        }
//                        else if (spans.Count == 2)
//                        {
//                            lstactstring.Add(GetInnerText(spans[0]));
//                            lstactstring.Add(GetInnerText(spans[1]));
//                        }
//                        else if (spans.Count == 1)
//                        {
//                            lstactstring.Add(GetInnerText(spans[0]));
//                            lstactstring.Add(String.Empty);
//                        }
//                    }
//                    for (int dtcolcount=0; dtcolcount <dt.Columns.Count; dtcolcount++)
//                    {
//
//                        if (rowcount == 0)
//                        {
//                            dact.Columns.Add(dt.Columns[colcnt].ToString());
//                            if (colcnt < lstactstring.Count)
//                            {
//                                dr[dt.Columns[colcnt].ToString()] = lstactstring[colcnt];
//                            }
//                            else
//                            {
//                                dr[dt.Columns[colcnt].ToString()] = String.Empty;
//                            }
//                        }
//                        else
//                        {
//
//                            if (colcnt < lstactstring.Count)
//                            {
//                                dr[dt.Columns[colcnt].ToString()] = lstactstring[colcnt];
//                            }
//                            else
//                            {
//                                dr[dt.Columns[colcnt].ToString()] = String.Empty;
//                            }
//                        }
//                        colcnt++;
//                    }
//                    dact.Rows.Add(dr);
//                    rowcount++;
//                }
//                Helper.CommonHelper.CompareDataTables(dt, dact);
//            }
//
//            public static void CustomAssertEqual(string exp, string act, string failMessage, string fieldname, ExtentTest test, double prsn = 0.1)
//            {
//                try
//                {
//                    CommonHelper.TraceLine(string.Format("Got Actual value for {0} as {1}", fieldname, act));
//                    double val;
//                    if (double.TryParse(exp, out val))
//                    {
//                        Assert.AreEqual(val, Convert.ToDouble(act), prsn, failMessage);
//                    }
//                    else
//                    {
//                        Assert.AreEqual(exp, act, failMessage);
//                    }
//                    test.Pass(string.Format("FieldName : {0} Expected Value : {1} and Actual value : {2} ", fieldname, exp, act));
//                }
//                catch (Exception e)
//                {
//                    test.Fail(string.Format("FieldName : {0} Expected Value : {1} and Actual value : {2} ", fieldname, exp, act));
//                    Assert.Fail($"Assertion falied FieldName : {fieldname} Expected Value : {exp} and Actual value : {act} {e}");
//                }
//
//            }
//
//
//            public static void CustomCollectionAssertEqual(List<string> exp, List<string> act, string failMessage, string fieldname, ExtentTest test, double prsn = 0.1)
//            {
//                try
//                {
//                    foreach (var item in exp)
//                    {
//                        CollectionAssert.Contains(act, item, $"Given item {item} was not found in the actual collection: {String.Join(";", act.ToArray())}");
//                    }
//                    test.Pass($"{fieldname}   :  Each item in the Expected Colection [[ {String.Join(";", exp.ToArray())}]] was present in Actual collection [[{String.Join(";", act.ToArray())}]]");
//                }
//                catch (Exception e)
//                {
//                    test.Fail($" Few item(s) in Expected Colection [[{String.Join(";", exp.ToArray())} ]] was present in Actual collection [[{String.Join(";", act.ToArray())}]]");
//                    Assert.Fail($" Few item(s) in Expected Colection [[{String.Join(";", exp.ToArray())}]] was present in Actual collection [[{String.Join(";", act.ToArray())}]] {e}");
//                }
//
//            }
//
//            public static void CustomCollectionAssertEqual(string exp, List<string> act, string failMessage, string fieldname, ExtentTest test, double prsn = 0.1)
//            {
//                try
//                {
//                    CollectionAssert.Contains(act, exp, $"Given item {exp} was not found in the actual collection: {String.Join(";", act.ToArray())}");
//                    test.Pass($"Each item in the Expected Colection -> {exp} was present in Actual collection [[{String.Join(";", act.ToArray())}]]");
//                }
//                catch (Exception e)
//                {
//                    test.Fail($" Few item(s) in Expected Colection [[{String.Join(";", exp.ToArray())} ]] was present in Actual collection [[{String.Join(";", act.ToArray())}]]");
//                    Assert.Fail($" Few item(s) in Expected Colection [[{String.Join(";", exp.ToArray())}]] was present in Actual collection [[{String.Join(";", act.ToArray())}]] {e}");
//                }
//
//            }
//
//            public static void CustomAssertEqualPercent(string exp, string act, string failMessage, string fieldname, ExtentTest test, double prsn = 0.1)
//            {
//                CommonHelper.TraceLine(string.Format("Got Actual value for {0} as {1}", fieldname, act));
//                double val;
//                if (double.TryParse(exp, out val))
//                {
//                    if (val > 100)
//                    {
//                        if ((Math.Abs((val - Convert.ToDouble(act)) / (val) * 100) > prsn))
//                        {
//                            Assert.Fail($"The Percentace Toleracne Compare failed Expected {exp} , Actuals {act}  Observed % delta {Math.Abs((val - Convert.ToDouble(act)) / (val) * 100)} Allowed Detla {prsn}");
//                        }
//                    }
//                    else
//                    {
//                        Assert.AreEqual(val, Convert.ToDouble(act), prsn, failMessage);
//                    }
//                }
//                else
//                {
//                    Assert.AreEqual(exp, act, failMessage);
//                }
//                test.Pass(string.Format("FieldName : {0} Expected Value : {1} and Actual value : {2} ", fieldname, exp, act));
//
//            }
//
//            public static void CustomAssertEqual(string exp, string act, string failMessage, string fieldname, double prsn = 0.1)
//            {
//                CommonHelper.TraceLine(string.Format("Got Actual value for {0} as {1}", fieldname, act));
//                double val;
//                if (double.TryParse(exp, out val))
//                {
//                    Assert.AreEqual(val, Convert.ToDouble(act), prsn, failMessage);
//                }
//                else
//                {
//                    Assert.AreEqual(exp, act, failMessage);
//                }
//            }
//            public static By GetByLocator(string searchBy, string searchValue, string desc)
//            {
//                By ctl = null;
//                elemdesc = desc;
//                if (loglevel.Equals("2"))
//                {
//                    CommonHelper.TraceLine(string.Format("For Control Control using searchby as {0} and searchvalue as {1}", searchBy, searchValue));
//                }
//            #region SearchCrieria
//                try
//                {
//
//                    switch (searchBy.ToLower())
//                    {
//                        case "id":
//                        {
//                            CommonHelper.TraceLine("Looking for Element: " + desc);
//                            ctl = By.Id(searchValue);
//                            break;
//                        }
//
//                        case "name":
//                        {
//                            ctl = By.Name(searchValue);
//                            break;
//                        }
//                        case "xpath":
//                        {
//                            CommonHelper.TraceLine("Looking for Element: By Xpath : for " + desc);
//                            ctl = By.XPath(searchValue);
//                            break;
//                        }
//                        case "tagname":
//                        {
//                            ctl = By.Id(searchValue);
//                            break;
//                        }
//                        case "linktext":
//                        {
//                            ctl = By.LinkText(searchValue);
//                            break;
//                        }
//                        default:
//                        {
//                            CommonHelper.TraceLine("Not Valid Locator: " + dtlValidLocators);
//                            break;
//                        }
//
//
//                    }
//                }
//                catch (Exception e)
//                {
//
//                    CommonHelper.TraceLine(string.Format("Unable to Find HTMLinputContril Type using {0},{1}", searchBy, searchValue));
//                    throw e;
//                }
//            #endregion
//                return ctl;
//            }
//
//            public static By GetByLocatorNextSibling(string searchBy, string searchValue, string desc)
//            {
//                By ctl = null;
//                elemdesc = desc;
//                if (loglevel.Equals("2"))
//                {
//                    CommonHelper.TraceLine(string.Format("For Control Control using searchby as {0} and searchvalue as {1}", searchBy, searchValue));
//                }
//            #region SearchCrieria
//                try
//                {
//
//                    switch (searchBy.ToLower())
//                    {
//
//                        case "xpath":
//                        {
//                            CommonHelper.TraceLine("Looking for Element: By Xpath : for " + desc);
//                            string nextsibling = searchValue + "/following-sibling::*[1]";
//                            ctl = By.XPath(nextsibling);
//                            break;
//                        }
//
//                        default:
//                        {
//                            CommonHelper.TraceLine("Not Valid Locator: " + dtlValidLocators);
//                            break;
//                        }
//
//
//                    }
//                }
//                catch (Exception e)
//                {
//
//                    CommonHelper.TraceLine(string.Format("Unable to Find HTMLinputContril Type using {0},{1}", searchBy, searchValue));
//                    throw e;
//                }
//            #endregion
//                return ctl;
//            }
//
//
//            public static void DisposeDriver()
//            {
//                //driver.Close();
//                ngDriver.Quit();
//                driver.Quit();
//
//            }
//
//            public static void Toastercheck(string scenario, string exptext, ExtentTest testm)
//            {
//                string toasttext = SeleniumActions.GetInnerText(PageObjects.WellConfigurationPage.Toaseter);
//                CommonHelper.TraceLine(toasttext);
//                SeleniumActions.TakeScreenshot(scenario);
//                Assert.AreEqual(exptext, toasttext, scenario + " Toast did not appear");
//                testm.Pass("Scenario: " + scenario, MediaEntityBuilder.CreateScreenCaptureFromPath((Path.Combine("Screenshots", scenario + ".png"))).Build());
//            }
//
//
//            public static void SelectWellfromWellList(string wellname)
//            {
//                if (!IsElementDisplayedOnUI(PageObjects.WellConfigurationPage.lblWellListHeader))
//                {//If already Well list is not open then only select click Well count lable to show up Well List
//                    SeleniumActions.WaitClick(PageObjects.DashboardPage.lblWelCount);
//                    SeleniumActions.WaitForLoad();
//                    PageObjects.DashboardPage.Dynatext = wellname;
//                    SeleniumActions.WaitClick(PageObjects.DashboardPage.lstWellName);
//                    SeleniumActions.WaitForLoad();
//                }
//            }
//            public static string GetAttribute(By elem, string attributename)
//            {
//                string attval = String.Empty;
//                try
//                {
//                    wait.Until(ExpectedConditions.ElementToBeClickable(elem));
//                    attval = driver.FindElement(elem).GetAttribute(attributename);
//                }
//                catch (Exception ex)
//                {
//
//                    Trace.WriteLine($"Error in GEting Attribute vlaue by Atibute {attributename} Error mesage{ex.Message.ToString()}");
//                }
//                return attval;
//            }
//
//            public static string Get_Attribute_withreplace(By elem, string attributename, int no = 0)
//            {
//                string final = string.Empty;
//                IWebElement list = driver.FindElement(elem);
//                string[] stringSeparators = new string[] { "\r\n" };
//                string[] splitchar = new string[] { };
//                IWebElement list2 = null;
//                IWebElement list3 = null;
//
//                if (list.Text.ToString().Contains("\r\n") && attributename == "value")
//                {
//                    splitchar = list.Text.Split(stringSeparators, StringSplitOptions.None);
//                    if (splitchar[0].ToString().Contains("Darcy Flow Coefficient"))
//                    {
//                        list2 = driver.FindElement(By.XPath("//*[contains(text(),'Darcy Flow Coefficient ')]//parent::div//parent::div//div//kendo-numerictextbox/span/input"));
//                        list3 = driver.FindElement(By.XPath("//*[contains(text(),'Darcy Flow Coefficient ')]//parent::div//following-sibling::div[3]/div"));
//                    }
//                    else
//                    {
//                        list2 = driver.FindElement(By.XPath("//*[text()='" + splitchar[0].ToString() + "']//parent::div//parent::div//div//kendo-numerictextbox/span/input"));
//                        list3 = driver.FindElement(By.XPath("//*[text()='" + splitchar[0].ToString() + "']//parent::div//following-sibling::div[3]/div"));
//                    }
//
//
//                }
//                else if (attributename == "value")
//                {
//                    list2 = driver.FindElement(By.XPath("//*[text()='" + list.Text.Replace("\r\n", string.Empty) + "']//parent::div//parent::div//div//kendo-numerictextbox/span/input"));
//                    list3 = driver.FindElement(By.XPath("//*[text()='" + list.Text + "']//parent::div//following-sibling::div[3]/div"));
//                }
//                else if (list.Text.ToString().Contains("\r\n") && attributename == "Text")
//                {
//                    splitchar = list.Text.Split(stringSeparators, StringSplitOptions.None);
//                    for (int i = 0; i < splitchar.Count(); i++)
//                    {
//                        //final = splitchar[0].ToString() + splitchar[1].ToString() + splitchar[2].ToString();
//                        final += splitchar[i].ToString();
//                    }
//                    return final;
//                }
//
//
//                // this else if is added for fetching the value
//                if (attributename == "value" && Convert.ToInt32(splitchar.Count()) > 1)
//                {
//                    final = splitchar[0].ToString() + list2.GetAttribute("value").Replace("\r\n", string.Empty) + list3.Text;
//                }
//                else if (attributename == "Text" && Convert.ToInt32(splitchar.Count()) == 0)
//                {
//                    //final = list.Text + list2.Text.Replace("\r\n", string.Empty) + list3.Text;
//                    final = list.Text.Replace("\r\n", string.Empty);
//                }
//                else if (attributename == "value" && Convert.ToInt32(splitchar.Count()) == 0)
//                {
//                    final = list.Text + list2.GetAttribute("value").Replace("\r\n", string.Empty) + list3.Text;
//                }
//                return final;
//
//            }
//            public static string GetAttributeJS(By elem, string attributename)
//            {
//                try
//                {
//                    IJavaScriptExecutor js = (IJavaScriptExecutor)driver;
//                    //return js.ExecuteScript("document.getElementByXpath('//div[@ref='eLabel']//span[text()='Job Id']').getAttribute('class')").ToString();
//                    return (string)js.ExecuteScript("return arguments[0].getAttribute('" + attributename + "')", driver.FindElement(elem));
//                }
//
//                catch (Exception)
//                {
//                    return null;
//                }
//
//            }
//            //Getattribute if element is not clickable
//            public static string Get_Attribute(By elem, string attributename)
//            {
//                if (attributename.Equals("value"))
//                {
//
//                    return driver.FindElement(elem).GetAttribute("value");
//                }
//                else if (attributename.Equals("aria-valuenow"))
//                {
//
//                    return driver.FindElement(elem).GetAttribute("aria-valuenow");
//                }
//                else if (attributename.Equals("Text"))
//                {
//                    return driver.FindElement(elem).Text;
//                }
//                else if (attributename.Equals("ng-reflect-value"))
//                {
//                    return driver.FindElement(elem).GetAttribute("ng-reflect-value");
//                }
//                else if (attributename.Equals("InnerText"))
//                {
//                    return driver.FindElement(elem).GetAttribute("InnerText");
//                }
//                else if (attributename.Equals("class", StringComparison.OrdinalIgnoreCase))
//                {
//                    return driver.FindElement(elem).GetAttribute("class");
//                }
//                else return null;
//            }
//            public static void Sendkeystroke(By elem, string key)
//            {
//                switch (key.ToLower())
//                {
//                    case "tab":
//                        wait.Until(ExpectedConditions.ElementToBeClickable(elem));
//                        driver.FindElement(elem).SendKeys(Keys.Tab);
//                        // new Actions(driver).SendKeys(Keys.Tab);
//                        break;
//                    case "enter":
//                        wait.Until(ExpectedConditions.ElementToBeClickable(elem));
//                        driver.FindElement(elem).SendKeys(Keys.Enter);
//                        // new case for Component Part Type dropdown selection
//                        break;
//                    case "left":
//                        wait.Until(ExpectedConditions.ElementToBeClickable(elem));
//                        driver.FindElement(elem).SendKeys(Keys.ArrowLeft);
//                        // new Actions(driver).SendKeys(Keys.Tab);
//                        break;
//                    default:
//                        CommonHelper.TraceLine("Invalid key requested");
//                        break;
//
//                }
//            }
//
//            public static void Sendkeystroke(string key)
//            {
//                Actions actions = new Actions(driver);
//                switch (key.ToLower().ToString())
//                {
//                    case "end":
//                        actions.SendKeys(OpenQA.Selenium.Keys.End).Build().Perform();
//                        break;
//                    case "pagedown":
//                        actions.SendKeys(OpenQA.Selenium.Keys.PageDown).Build().Perform();
//                        break;
//                    case "tab":
//                        actions.SendKeys(OpenQA.Selenium.Keys.Tab).Build().Perform();
//                        break;
//                    case "enter":
//                        actions.SendKeys(OpenQA.Selenium.Keys.Enter).Build().Perform();
//                        break;
//                    case "left":
//                        actions.SendKeys(OpenQA.Selenium.Keys.ArrowLeft).Build().Perform();
//                        break;
//                    default:
//                        CommonHelper.TraceLine("Invalid keystroke requested in the arguement");
//                        break;
//                }
//            }
//            public static int Gettotalrecords(string searchby, string elem)
//            {
//                int k = 0;
//                if (searchby.Equals("xpath"))
//                {
//                    k = driver.FindElements(By.XPath(elem + "/tr")).Count();
//                }
//                return k;
//
//            }
//            public static int Gettotalrecords(By elem)
//            {
//                int k = 0;
//
//                k = driver.FindElements(elem).Count();
//
//                return k;
//
//            }
//            public static IList<IWebElement> Gettotalrecordsinlist(string searchby, string elem)
//            {
//                try
//
//                {
//                    // WebDriverWait wait = new WebDriverWait(ngDriver, TimeSpan.FromSeconds(5));
//                    wait.Until(ExpectedConditions.ElementToBeClickable(By.XPath(elem)));
//                    // Thread.Sleep(4000);
//                    IList<IWebElement> elems;
//                    if (searchby.ToLower().Trim().Equals("xpath"))
//                    {
//                        elems = driver.FindElements(By.XPath(elem));
//                    }
//                    else
//                    {
//                        elems = null;
//                    }
//                    return elems;
//                }
//                catch (Exception)
//                {
//                    return null;
//                }
//
//            }
//
//            public static List<IWebElement> Gettotalrecordsinlist_type2(string searchby, string elem)
//            {
//
//                List<IWebElement> elems;
//
//                if (searchby.ToLower().Trim().Equals("xpath"))
//                {
//                    elems = driver.FindElements(By.XPath(elem)).ToList();
//                    var nullvalue = elems.FirstOrDefault();
//
//
//                    if (nullvalue.Text.Equals(""))
//                    {
//                        elems.Remove(nullvalue);
//                    }
//                }
//                else
//                {
//                    elems = null;
//                }
//                return elems;
//
//            }
//
//            public static List<string> Gettotalrecordsinlistelemnevisisble(string searchby, string elem)
//            {
//                try
//
//                {
//                    List<string> textsinelement = new List<string>();
//                    WebDriverWait wait = new WebDriverWait(ngDriver, TimeSpan.FromSeconds(5));
//                    wait.Until(ExpectedConditions.ElementExists(By.XPath(elem)));
//                    // Thread.Sleep(4000);
//                    IList<IWebElement> elems;
//                    if (searchby.ToLower().Trim().Equals("xpath"))
//                    {
//                        elems = driver.FindElements(By.XPath(elem));
//                        foreach (var el in elems)
//                        {
//                            textsinelement.Add(el.Text);
//                        }
//                    }
//                    else
//                    {
//                        elems = null;
//                    }
//                    return textsinelement;
//                }
//                catch (Exception)
//                {
//                    CommonHelper.TraceLine($"The Element defintion for {elem}  was not found: Probably the Column header definition was updated ");
//                    return null;
//                }
//            }
//
//            public static List<string> Gettotalrecordsinlistelemnevisisble(By elem)
//            {
//                try
//
//                {
//                    List<string> textsinelement = new List<string>();
//                    WebDriverWait wait = new WebDriverWait(ngDriver, TimeSpan.FromSeconds(5));
//                    wait.Until(ExpectedConditions.ElementExists(elem));
//                    // Thread.Sleep(4000);
//                    IList<IWebElement> elems;
//                    elems = driver.FindElements(elem);
//                    if (elems.Count > 0)
//                    {
//                        foreach (var el in elems)
//                        {
//                            textsinelement.Add(el.Text);
//                        }
//                    }
//
//                    else
//                    {
//                        CommonHelper.TraceLine($"The Element defintion for {elem}  was not found: Probably the Column header definition was updated ");
//                        elems = null;
//                    }
//                    return textsinelement;
//                }
//                catch (Exception e)
//                {
//                    CommonHelper.TraceLine($"Error finding colunn header {e.ToString()}");
//                    return null;
//                }
//            }
//            public static string RandomString(int length)
//            {
//                Random random = new Random();
//            const string chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//                return new string(Enumerable.Repeat(chars, length)
//                        .Select(s => s[random.Next(s.Length)]).ToArray());
//            }
//        #endregion
//
//        #region GridEntryVerificationmethods
//            public static void VerifyGridCellValues(string colnames, string colvals, ExtentTest test, int rowindex = 0, string tblid = "none", bool clickrow = false)
//            {
//                try
//                {
//                    string[] colnamearray = colnames.Split(new char[] { ';' });
//                    string[] colvalarray = colvals.Split(new char[] { ';' });
//                    string[] fixcolnameval = tblid.Split(new char[] { ';' });
//                    int colpos = -1;
//                    IWebElement colNameTable = null;
//                    //get required column header table group
//                    if (tblid.Equals("none"))
//                    {
//                        colNameTable = GetTableByColumnName(colnamearray[0]);
//                    }
//                    else
//                    {
//                        colNameTable = GetTableByColumnName(fixcolnameval[0]);
//                    }
//                    IWebElement colValTable = null;
//                    for (int i = 0; i < colvalarray.Length; i++)
//                    {
//                        if (colvalarray[i].ToLower() == "ignorevalue")
//                        {
//                            continue;
//                        }
//                        if (tblid.Equals("none"))
//                        {
//                            colValTable = GetTableByColumnName(colvalarray[i]);
//                        }
//                        else
//                        {
//                            colValTable = GetTableByColumnName(fixcolnameval[1]);
//                        }
//                        if (colValTable != null)
//                        {
//                            break;
//                        }
//                    }
//                    // get all column indexes for passed column names
//                    StringBuilder indexstring = new StringBuilder();
//                    foreach (string colname in colnamearray)
//                    {
//                        indexstring.Append(GetIndexofColumnName(colNameTable, colname) + ";");
//                    }
//                    string strcolHeaderIndex = indexstring.ToString();
//                    strcolHeaderIndex = GetStringLastCharRemoved(strcolHeaderIndex, ';');
//                    string[] colHeaderIndex = strcolHeaderIndex.Split(new char[] { ';' });
//                    //get value table using exp val text
//                    foreach (string indx in colHeaderIndex)
//                    {
//                        int.TryParse(indx, out colpos);
//
//                        if (colvalarray[colpos].ToLower() != "ignorevalue")
//                        {
//                            string colnametoget = "";
//                            if (colnamearray.Length != colvalarray.Length)
//                            {
//                                colnametoget = colnamearray[colpos - 1];
//                                //Determine if something was extra for example Table one has one column , table 2 has 2 columns
//                            }
//                            else
//                            {
//                                colnametoget = colnamearray[colpos];
//                            }
//                            Helper.CommonHelper.TraceLine("********Table Column Name to be verified:******** " + colnametoget);
//                            string actualcellvalue = GetTextAtIndex(colValTable, colpos, rowindex, clickrow);
//                            Helper.CommonHelper.TraceLine(string.Format("******Table Cell Value Expected: {0} and Actual value {1} ,at Row Position: {2} ***********", colvalarray[colpos], actualcellvalue, rowindex));
//                            //Check for Blank String values
//                            if (actualcellvalue.Trim().Length == 0)
//                            {
//                                if (colvalarray[colpos].Trim().Length == 0)
//                                {
//                                    Assert.AreEqual(colvalarray[colpos], actualcellvalue, "Table Cell Value did not match for " + colnametoget);
//                                }
//                                else
//                                {
//                                    Assert.IsFalse(actualcellvalue.Trim().Length > 0, "Actaul value of Cell is Blank when Expected Value is Not Blank");
//                                }
//                            }
//                            double dout = 0.0;
//                            bool IsNumber = double.TryParse(actualcellvalue, out dout);
//                            if (IsNumber)
//                            {
//                                double expresult = Convert.ToDouble(colvalarray[colpos]);
//                                //this 'precision' can be configurable ??
//                                double precision = 0.001;
//                                int actuuldecimalprecision = CountDigitsAfterDecimal(dout);
//                                expresult = Math.Round(expresult, actuuldecimalprecision);
//
//
//                                if (IsDecimalTruncate(expresult, dout))
//                                {
//                                    Helper.CommonHelper.TraceLine("Truncated Actual Value");
//                                    //Make them same as this is due to wrong deimal Truncation instead of rounding
//                                    expresult = Math.Truncate(dout * Math.Pow(10, actuuldecimalprecision)) / Math.Pow(10, actuuldecimalprecision);
//                                }
//
//                                Assert.AreEqual(expresult, dout, precision, " Precision Check Falied for Numeric Value " + colnametoget);
//                            }
//                            else
//                            {
//                                if (actualcellvalue != null)
//                                {
//                                    if (actualcellvalue == "null")
//                                    {
//                                        actualcellvalue = "";
//                                    }
//                                    Assert.AreEqual(colvalarray[colpos].Trim(), actualcellvalue.Trim(), "Table Cell Value did not match for " + colnametoget);
//
//                                }
//                                else
//                                {
//                                    actualcellvalue = "Blank";
//                                    colvalarray[colpos] = "Blank";
//                                    Assert.AreEqual(colvalarray[colpos], actualcellvalue, "Table Cell Value did not match for " + colnametoget);
//                                }
//                            }
//                        }
//                        else
//                        {
//                            Helper.CommonHelper.TraceLine("Column Name: " + colnamearray[colpos] + " -- ignored for Comparison");
//                        }
//                    }
//                    test.Pass(string.Format("Table Verification is Pased for given Expected Colnames  : {0} Expected Column values: {1}  ", colnames, colvals));
//                }
//                catch (Exception e)
//                {
//
//                    Helper.CommonHelper.PrintScreen("HtmlTableVerification");
//                    Helper.CommonHelper.TraceLine("*******Verify Cell Values Failed********");
//                    Assert.Fail("Expcetion from VerifyGridCellValues: --->" + e.ToString());
//                }
//
//            }
//            public static IWebElement Getelementbyrow(string searchby, string elem, int row)
//            {
//                IWebElement el;
//                el = driver.FindElement(By.XPath(elem + "[" + row + "]"));
//                return el;
//            }
//            public static IWebElement GetTableByColumnName(string colname)
//            {
//                IWebElement tbl = null;
//                try
//                {
//                    wait.Until(ExpectedConditions.PresenceOfAllElementsLocatedBy(By.TagName("table")));
//                    ReadOnlyCollection<IWebElement> allHtmlTables = driver.FindElements(By.TagName("table"));
//                    int index = allHtmlTables.IndexOf(allHtmlTables.FirstOrDefault(x => x.Text.Contains(colname)));
//                    if (index != -1)
//                    {
//                        tbl = allHtmlTables[index];
//                    }
//                    return tbl;
//                }
//                catch (Exception e)
//                {
//
//                    Helper.CommonHelper.TraceLine("Not Able to find the Table by ColumnName: ==>" + colname);
//                    Assert.Fail("getTableByColumnName Failed" + e.ToString());
//                    return tbl;
//                }
//            }
//
//            public static int GetIndexofColumnName(IWebElement tbl, string colname)
//            {
//                int index = -1;
//                ReadOnlyCollection<IWebElement> AllRows = tbl.FindElements(By.TagName("tr"));
//                ReadOnlyCollection<IWebElement> Allcells = AllRows[0].FindElements(By.TagName("th"));
//                if (colname.Contains("|"))
//                {
//                    string[] arrcolvals = colname.Split(new char[] { '|' });
//                    index = 0;
//
//                    foreach (IWebElement indcell in Allcells)
//                    {
//                        if (indcell.Text.Contains(arrcolvals[0]) && indcell.Text.Contains(arrcolvals[1]))
//                        {
//                            break;
//                        }
//                        index++;
//                    }
//                }
//                else
//                {
//
//                    index = Allcells.IndexOf(Allcells.FirstOrDefault(x => x.Text.Contains(colname)));
//                }
//                return index;
//            }
//
//            private static string GetStringLastCharRemoved(string instr, char c)
//            {
//                int lastind = instr.LastIndexOf(",");
//                int lenstr = instr.Length;
//                string ostr = instr.Substring(0, (instr.LastIndexOf(c)));
//                return ostr;
//            }
//
//            public static string GetTextAtIndex(IWebElement tbl, int index, int rowPos = 0, bool clickrow = false)
//            {
//
//                // ReadOnlyCollection<HtmlTableCell> allHtmlTableCells = tbl.Find.AllByExpression<HtmlTableCell>("tagname=td");
//                ReadOnlyCollection<IWebElement> AllRows = tbl.FindElements(By.TagName("tr"));
//                ReadOnlyCollection<IWebElement> Allcells = AllRows[rowPos].FindElements(By.TagName("td"));
//                if (clickrow)
//                {
//                    Allcells[index].Click();
//                    // Allcells[index].MouseClick();
//                }
//                return Allcells[index].Text;
//
//            }
//            public static string Gettextfromwebtable(string tbl, int rows, int columns)
//            {
//                CommonHelper.TraceLine("Getting text  for row " + rows);
//
//
//                string text = driver.FindElement(By.XPath(tbl + "/" + "/tr[" + rows + "]" + "/" + "/td[" + columns + "]")).Text;
//
//                return text;
//
//            }
//            private static int CountDigitsAfterDecimal(double value)
//            {
//                bool start = false;
//                int count = 0;
//                foreach (var s in value.ToString())
//                {
//                    if (s == '.')
//                    {
//                        start = true;
//                    }
//                    else if (start)
//                    {
//                        count++;
//                    }
//                }
//
//                return count;
//            }
//
//            public static bool IsDecimalTruncate(double exp, double act)
//            {
//                bool IsDecimalTruncate = false;
//                if (Math.Abs(exp - act) > 0 && CountDigitsAfterDecimal(act) > 2)
//                {
//                    //If There is decimal precision deviation and it is due to roudning inconsistency
//                    // for example 89.05455 and 89.05454
//                    if ((Math.Abs(exp - act) * (Math.Pow(10, CountDigitsAfterDecimal(act))) < 2))
//                    {
//                        //Handling Tolerance
//                        Helper.CommonHelper.TraceLine("*****Tolernce of decimal Values Case due to Rounding Inconsistency Case / Factor ***** ");
//                        Helper.CommonHelper.TraceLine("Expected " + exp);
//                        Helper.CommonHelper.TraceLine("Actual  " + act);
//                        Helper.CommonHelper.TraceLine("their Absolute Differnce " + Math.Abs(exp - act));
//                        Helper.CommonHelper.TraceLine("Factor with decimal point " + Math.Pow(10, CountDigitsAfterDecimal(act)));
//                        IsDecimalTruncate = true;
//
//                    }
//                }
//
//                return IsDecimalTruncate;
//            }
//
//            public static void VerifytablelabelsNtoWorking(string colnames, string locator, string searchby, string unit)
//            {
//                try
//                {
//                    Helper.CommonHelper.TraceLine("Validating column headers in unit system" + unit);
//                    string[] colnamearray = colnames.Split(new char[] { ';' });
//                    IWebElement colNameTable = null;
//                    if (searchby.Equals("xpath"))
//                        colNameTable = driver.FindElement(By.XPath(locator));
//                    int columns = driver.FindElements(By.XPath(locator + "/thead//th")).Count;
//                    int j = 1; int headercount;
//                    for (int i = 0; i < colnamearray.Length; i++)
//                    {
//
//                        string headervaluetext = "";
//                        string headervalue = "";
//                        headervalue = driver.FindElement(By.XPath(locator + "/thead//th[" + j + "]")).Text;
//                        if (headervalue == "")
//                        {
//                            j++;
//                            headercount = driver.FindElements(By.XPath(locator + "/thead//th[" + j + "]/div")).Count;
//                        }
//                        else
//                        {
//                            headercount = driver.FindElements(By.XPath(locator + "/thead//th[" + j + "]/div")).Count;
//                        }
//                        if (headercount == 0)
//                        {
//                            headervaluetext = driver.FindElement(By.XPath(locator + "/thead//th[" + j + "]")).Text;
//                        }
//                        if (headercount == 1)
//                        {
//                            headervaluetext = driver.FindElement(By.XPath(locator + "/thead//th[" + j + "]/div")).Text;
//                        }
//                        if (headercount > 1)
//                        {
//                            for (int k = 1; k <= headercount; k++)
//                            {
//                                string x = locator + "/thead//th[" + j + "]/div[" + k + "]";
//                                headervaluetext = headervaluetext + driver.FindElement(By.XPath(locator + "/thead//th[" + j + "]/div[" + k + "]")).Text;
//                            }
//
//                        }
//
//                        if (headervaluetext.Trim().Equals((colnamearray[i].ToString())))
//                        {
//                            Helper.CommonHelper.TraceLine(string.Format("Column label {0} is   equalto {1}", headervaluetext.Trim(), colnamearray[i].ToString()));
//                        }
//                        else
//                        {
//                            Helper.CommonHelper.TraceLine(string.Format("Column label {0} is  not equalto {1}", headervaluetext.Trim(), colnamearray[i].ToString()));
//                        }
//
//                        j++;
//                    }
//                }
//                catch (Exception e)
//                {
//                    Console.WriteLine(e.Message);
//                    Helper.CommonHelper.PrintScreen("ModelDataVerification");
//                    Helper.CommonHelper.TraceLine("*******Verify Cell Values Failed********");
//                }
//
//            }
//
//            public static void Verifytablelabels(string colnames, string locator, string searchby, string unit)
//            {
//                Helper.CommonHelper.TraceLine("Validating column headers in unit system" + unit);
//                string[] colnamearray = colnames.Split(new char[] { ';' });
//                IWebElement colNameTable = null;
//                if (searchby.Equals("xpath"))
//                    colNameTable = driver.FindElement(By.XPath(locator));
//                List<string> actcolnamecol = new List<string>();
//                ReadOnlyCollection<IWebElement> allcols = driver.FindElements(By.XPath(locator + "/thead//th"));
//                List<string> colheaderstext = new List<string>();
//                List<string> colheadersuomtext = new List<string>();
//                if (allcols.Count >= 2 * colnamearray.Length) //We have Table with Headers and UOM headers
//                {
//                    int heardercount = 0; int headeruomcount = 0;
//                    for (int i = 0; i < allcols.Count / 2; i++)
//                    {
//                        colheaderstext.Add(allcols[i].Text.Trim());
//                        heardercount++;
//                    }
//                    for (int j = allcols.Count / 2; j < allcols.Count; j++)
//                    {
//                        colheadersuomtext.Add(allcols[j].Text.Trim());
//                        headeruomcount++;
//                    }
//                    if (heardercount != headeruomcount)
//                    {
//                        Assert.Fail("HTML Table Strucutre with UOM headers does not match");
//                    }
//                    for (int i = 0; i < allcols.Count / 2; i++)
//                    {
//                        actcolnamecol.Add(colheaderstext[i] + colheadersuomtext[i]); //Column name with Unit text(No spacebetween them)
//                    }
//                }
//                else
//                {
//                    foreach (var item in allcols)
//                    {
//                        actcolnamecol.Add(item.Text.Trim());// Column name only no unit text
//                    }
//                }
//
//                foreach (string expcolname in colnamearray)
//                {
//                    CollectionAssert.Contains(actcolnamecol, expcolname, $"Expected Column Name {expcolname} was not Presemt in ACtual Column Name List {String.Join(";", actcolnamecol)}");
//
//                }
//            }
//
//            public static void Verifytabledata(string colvals, int rows)
//            {
//                //  int rows = driver.FindElements((By.XPath(PageObjects.WellAnalysisPage.patternmatchingrows))).Count();
//                string[] colvalarray = colvals.Split(new char[] { ';' });
//
//                CommonHelper.TraceLine("Verifying data for row " + rows);
//                int columns = driver.FindElements(By.XPath("(" + PageObjects.WellAnalysisPage.patternmatchingrows + ")[" + rows + "]/td")).Count();
//                for (int j = 1; j <= columns; j++)
//                {
//                    string colvals1 = driver.FindElement(By.XPath("(" + PageObjects.WellAnalysisPage.patternmatchingrows + ")[" + rows + "]/td[" + j + "]")).Text;
//
//                    Assert.AreEqual(colvalarray[j - 1], colvals1, "{0} is not equal to {1}", colvalarray[j - 1], colvals1);
//                    CommonHelper.TraceLine(colvalarray[j - 1] + "is equal to" + colvals1);
//
//                }
//
//
//
//            }
//            public static void Verifymodelgriddata(string e, string searchBy, string colvals, string searchValue, int k, string unit, ExtentTest test)
//            {
//                string[] colvalarray = colvals.Split(new char[] { ';' });
//                var list = new List<string>(colvalarray);
//
//                for (int i = 0; i < list.Count; i++)
//                {
//                    if (list[i].Contains("ignorevalue"))
//                    {
//                        list.RemoveAt(i);
//                    }
//                }
//                List<List<IWebElement>> elementlist = new List<List<IWebElement>>();
//                IWebElement ele = null;
//            #region SearchCrieria
//
//                try
//                {
//                    CommonHelper.TraceLine("Verifying grid values " + "in unit system " + unit + " for row " + k);
//                    switch (searchBy.ToLower())
//                    {
//                        case "xpath":
//                            int rows = driver.FindElements(By.XPath(e + "/tr")).Count;
//                            if (rows == 1)
//                            {
//                                elementlist.Add(new List<IWebElement>());
//                                int columns = driver.FindElements(By.XPath(e + "/tr/td")).Count;
//                                List<IWebElement> elmntlst = new List<IWebElement>();
//                                elementlist.Add(elmntlst);
//                                for (int j = 1; j <= columns; j++)
//                                {
//                                    ele = driver.FindElement(By.XPath(e + "/tr/td[" + j + "]"));
//                                    if (ele.Text != " No records available. ")
//                                        elmntlst.Add(ele);
//                                }
//                                for (int l = 0; l < list.Count; l++)
//                                {
//                                    decimal number;
//                                    if (decimal.TryParse(list[l], out number) || decimal.TryParse(elmntlst[l].Text, out number))
//                                    {
//                                        Assert.AreEqual(decimal.Round(Convert.ToDecimal(list[l]), 2), decimal.Round(Convert.ToDecimal(elmntlst[l].Text), 2), string.Format(" {0} is not equal to {1}", list[l], elmntlst[l].Text, test));
//                                    }
//                                    else
//                                    {
//                                        Assert.AreEqual(list[l], elmntlst[l].Text, string.Format(" {0} is not equal to {1}", list[l], elmntlst[l].Text, test));
//                                    }
//                                }
//                            }
//                            else if (rows > 1)
//                            {
//                                elementlist.Add(new List<IWebElement>());
//                                int columns = driver.FindElements(By.XPath(e + "/tr[" + k + "]/td")).Count;
//                                List<IWebElement> elmntlst = new List<IWebElement>();
//                                elementlist.Add(elmntlst);
//                                for (int j = 1; j <= columns; j++)
//                                {
//                                    ele = driver.FindElement(By.XPath(e + "/tr[" + k + "]/td[" + j + "]"));
//                                    elmntlst.Add(ele);
//                                }
//                                for (int l = 0; l < list.Count; l++)
//                                {
//                                    decimal number;
//                                    if (decimal.TryParse(list[l], out number) || decimal.TryParse(elmntlst[l].Text, out number))
//                                    {
//                                        Assert.AreEqual(decimal.Round(Convert.ToDecimal(list[l]), 2), decimal.Round(Convert.ToDecimal(elmntlst[l].Text), 2), string.Format(" {0} is not equal to {1}", list[l], elmntlst[l].Text, test));
//                                    }
//                                    else
//                                    {
//                                        Assert.AreEqual(list[l], elmntlst[l].Text, string.Format(" {0} is not equal to {1}", list[l], elmntlst[l].Text, test));
//                                    }
//                                }
//                            }
//                            break;
//                        default:
//                            CommonHelper.TraceLine("element can not be identified");
//                            break;
//                    }
//                }
//            #endregion
//            catch (Exception e1)
//                {
//                    Trace.WriteLine(e1.Message);
//                    CommonHelper.PrintScreen("ModelDataVerification");
//                    CommonHelper.TraceLine(string.Format("Unable to Find HTMLinputControl Type using {0},{1}", searchBy, searchValue));
//                    throw e1;
//                }
//            }
//
//            public static List<IWebElement> GetWebelementNextSibling(string searchBy, string searchValue, string desc)
//            {
//                List<IWebElement> elementlist = new List<IWebElement>();
//                IWebElement ele = null;
//                IWebElement elenext = null;
//
//                elemdesc = desc;
//                if (loglevel.Equals("2"))
//                {
//                    CommonHelper.TraceLine(string.Format("For Control Control using searchby as {0} and searchvalue as {1}", searchBy, searchValue));
//                }
//            #region SearchCrieria
//                try
//                {
//
//                    switch (searchBy.ToLower())
//                    {
//
//                        case "xpath":
//                        {
//                            CommonHelper.TraceLine("Looking for Element: By Xpath : for " + desc);
//                            string nextsibling = "(" + searchValue + "/following::*)[1]";
//                            ele = driver.FindElement(By.XPath(searchValue));
//                            elenext = driver.FindElement(By.XPath(nextsibling));
//                            SeleniumActions.WaitForElement(By.XPath(nextsibling));
//                            elementlist.Add(ele);
//                            elementlist.Add(elenext);
//                            break;
//                        }
//
//                        default:
//                        {
//                            CommonHelper.TraceLine("Not Valid Locator: " + dtlValidLocators);
//                            break;
//                        }
//
//
//                    }
//                }
//                catch (Exception e)
//                {
//
//                    CommonHelper.TraceLine(string.Format("Unable to Find HTMLinputContril Type using {0},{1}", searchBy, searchValue));
//                    throw e;
//                }
//            #endregion
//                return elementlist;
//            }
//            public static void Scrolldown(int pixel)
//            {
//                IJavaScriptExecutor js = (IJavaScriptExecutor)driver;
//                js.ExecuteScript("window.scrollBy(0," + pixel + ")");
//            }
//
//            public static void Scrollintoview(By elem)
//            {
//
//                ((IJavaScriptExecutor)driver).ExecuteScript("arguments[0].scrollIntoView();", driver.FindElement(elem));
//
//            }
//            public static void Drawhighlight(IWebElement el)
//            {
//
//                for (int i = 0; i < 3; i++)
//                {
//                    IJavaScriptExecutor js = (IJavaScriptExecutor)driver;
//                    js.ExecuteScript("arguments[0].setAttribute('style', arguments[1]);", el, "color: red; border: 2px solid red;");
//                }
//            }
//            public static void Scrollbyel(By el, string hor, string ver)
//            {
//                wait.Until(ExpectedConditions.ElementToBeClickable(el));
//                IWebElement ely = driver.FindElement(el);
//                IJavaScriptExecutor js = (IJavaScriptExecutor)driver;
//                js.ExecuteScript("arguments[0].scrollBy(arguments[1], arguments[2]);", ely, hor, ver);
//            /*
//            IJavaScriptExecutor js = (IJavaScriptExecutor)driver;
//            js.ExecuteScript("document.body.style.zoom = arguments[0]; ", zoomperc);
//            */
//
//            }
//            public static void Verifygridmultvalues(string colvals, string searchBy, string searchvalue, string desc)
//            {
//
//                string[] colvalarray = colvals.Split(new char[] { ';' });
//
//                var list = new List<string>(colvalarray);
//
//
//
//
//                elemdesc = desc;
//
//            #region SearchCrieria
//                try
//                {
//
//                    if (searchBy.ToLower().Equals("xpath"))
//                    {
//
//                        for (int i = 0; i < colvalarray.Length; i++)
//                        {
//                            Thread.Sleep(1000);
//
//                            string s = driver.FindElement(By.XPath("(" + searchvalue + ")[" + (i + 1) + "]")).GetAttribute("innerText");
//
//                            Assert.AreEqual(s, colvalarray[i].ToString(), "{0} in grid does not match with given data {1}", s, colvalarray[i].ToString());
//                            CommonHelper.TraceLine(String.Format("{0} in grid matches with given data {1}", s, colvalarray[i].ToString()));
//
//
//
//                        }
//                        Thread.Sleep(2000);
//                    }
//
//                    else
//                    {
//                        CommonHelper.TraceLine("Not Valid Locator: " + dtlValidLocators);
//
//                    }
//
//
//
//                }
//                catch (Exception e)
//                {
//
//                    CommonHelper.TraceLine(string.Format("Unable to Find HTMLinputContril Type using {0}", searchBy));
//                    throw e;
//                }
//            #endregion
//
//            }
//            public static void Kendotextboxentervalues(string searchBy, string searchValue, string val1, string val2, string desc)
//            {
//
//                IWebElement ele = null;
//                IWebElement elenext = null;
//
//                elemdesc = desc;
//                if (loglevel.Equals("2"))
//                {
//                    CommonHelper.TraceLine(string.Format("For Control Control using searchby as {0} and searchvalue as {1}", searchBy, searchValue));
//                }
//            #region SearchCrieria
//                try
//                {
//
//                    switch (searchBy.ToLower())
//                    {
//
//                        case "xpath":
//                        {
//                            CommonHelper.TraceLine("Looking for Element: By Xpath : for " + desc);
//                            string nextsibling = searchValue + "/following::*[1]//kendo-numerictextbox//input";
//                            ele = driver.FindElement(By.XPath(searchValue));
//                            elenext = driver.FindElement(By.XPath(nextsibling));
//                            ele.Click();
//                            ele.Clear();
//                            ele.SendKeys(Keys.Home);
//                            ele.SendKeys(val1);
//                            if (elenext.Displayed)
//                            {
//                                elenext.Click();
//                                elenext.Clear();
//                                elenext.SendKeys(Keys.Home);
//                                elenext.SendKeys(val2);
//                            }
//
//                            break;
//                        }
//
//                        default:
//                        {
//                            CommonHelper.TraceLine("Not Valid Locator: " + dtlValidLocators);
//                            break;
//                        }
//
//
//                    }
//                }
//                catch (Exception e)
//                {
//
//                    CommonHelper.TraceLine(string.Format("Unable to Find HTMLinputContril Type using {0},{1}", searchBy, searchValue));
//                    throw e;
//                }
//            #endregion
//
//            }
//
//            //Function to enter textbox having same xpath
//            public static void Kendotextboxentermultiplevalues(string searchBy, string searchvalue, string vals, string desc)
//            {
//                string[] colvalarray = vals.Split(new char[] { ';' });
//                var list = new List<string>(colvalarray);
//                elemdesc = desc;
//
//                try
//                {
//                    switch (searchBy.ToLower())
//                    {
//                        case "xpath":
//                        {
//                            for (int i = 0; i < colvalarray.Length; i++)
//                            {
//                                driver.FindElement(By.XPath("(" + searchvalue + ")[" + (i + 1) + "]")).SendKeys(list[i].ToString());
//
//                            }
//                            break;
//                        }
//
//                        default:
//                        {
//                            CommonHelper.TraceLine("Not Valid Locator: " + dtlValidLocators);
//                            break;
//                        }
//                    }
//                }
//                catch (Exception e)
//                {
//                    CommonHelper.TraceLine($"Unable to Find HTMLinputContril Type using {searchBy}");
//                    throw e;
//                }
//            }
//
//
//            public static void VerifyGridvalue(string columnname, List<IWebElement> columnlist, string xpath, string expvalue)
//            {
//                bool flag1 = false;
//                try
//                {
//                    columnlist = SeleniumActions.Gettotalrecordsinlist_type2("xpath", xpath);
//
//                    foreach (var column in columnlist)
//                    {
//                        if (column.Text != "")
//                        {
//                            string columnvalue = SeleniumActions.GetInnerText(column);
//                            CommonHelper.TraceLine(columnname + " value found: " + columnvalue);
//
//                            if (columnvalue.ToLower().Trim() == expvalue.ToLower().Trim())
//                            {
//                                flag1 = true;
//                                CommonHelper.TraceLine("The value is present in the grid for column" + columnname);
//                                break;
//                            }
//                            else
//                            {
//                                CommonHelper.TraceLine("The value- " + columnvalue + ", is not found in the grid for column " + columnname);
//                            }
//                        }
//                    }
//                }
//                catch (Exception ex)
//                {
//                    CommonHelper.TraceLine("The value is not present in the grid for column" + columnname + ". Exception:" + ex);
//                    Assert.IsTrue(flag1, "The value is not found in the grid for column " + columnname);
//                }
//
//            }
//
//            public static void VerifyAgGridfromDataTable(DataTable dt, List<By> bylist, By ScrollbarObj, ExtentTest test)
//            {
//                double height = SystemParameters.PrimaryScreenHeight;
//                double width = SystemParameters.PrimaryScreenWidth;
//                Console.Write("Screen size found width:-" + width);
//                double half = width / 2;
//                string scrollp = half.ToString();
//                string style = GetAttribute(ScrollbarObj, "style");
//                string[] splitstyle = style.Split(':');
//                string[] splitstyle2 = splitstyle[1].Split(';');
//                Console.WriteLine("style1->" + splitstyle[1]);
//                Console.WriteLine("style->" + splitstyle2[0]);
//                int scrollsize = int.Parse(splitstyle2[0].Substring(0, splitstyle2[0].Length - 2));
//                Console.WriteLine("size->" + scrollsize);
//                int k = 0;
//                foreach (DataColumn col in dt.Columns)
//                {
//                    By uiobj = bylist[k];
//                    List<string> columnvalueslist = GetAllValuesUnderColumn(uiobj, scrollp, scrollsize);
//                    string fieldname = col.ColumnName;
//                    int rowcnt = 2;
//                    foreach (DataRow dr in dt.Rows)
//                    {
//                        CustomAssertEqual(dr[fieldname].ToString(), columnvalueslist[rowcnt], $"Mismatch with {fieldname} ", $"Filed Name {fieldname} ", test);
//                        rowcnt++;
//                    }
//                    k++; //Next UI Page Object in List Please;
//                }
//                ScrollToBegining(ScrollbarObj, scrollp, scrollsize);
//            }
//
//            public static void VerifyAgGridfromDataTable(DataTable dt, List<By> bylist, By ScrollbarObj, ExtentTest test, string DynamicColNames, string DynamicColVals)
//            {
//                double height = SystemParameters.PrimaryScreenHeight;
//                double width = SystemParameters.PrimaryScreenWidth;
//                Console.Write("Screen size found width:-" + width);
//                double half = width / 2;
//                string scrollp = half.ToString();
//                string style = GetAttribute(ScrollbarObj, "style");
//                string[] splitstyle = style.Split(':');
//                string[] splitstyle2 = splitstyle[1].Split(';');
//                Console.WriteLine("style1->" + splitstyle[1]);
//                Console.WriteLine("style->" + splitstyle2[0]);
//                int scrollsize = int.Parse(splitstyle2[0].Substring(0, splitstyle2[0].Length - 2));
//                Console.WriteLine("size->" + scrollsize);
//                int k = 0;
//                string[] arrdyncolname = DynamicColNames.Split(new char[] { ';' });
//                string[] arrdyncolval = DynamicColVals.Split(new char[] { ';' });
//
//                foreach (DataColumn col in dt.Columns)
//                {
//                    By uiobj = bylist[k];
//                    List<string> columnvalueslist = GetAllValuesUnderColumn(uiobj, scrollp, scrollsize);
//                    int rowcnt = columnvalueslist.Count;
//                    string fieldname = col.ColumnName;
//                    foreach (DataRow dr in dt.Rows)
//                    {
//                        string fieldvalue = dr[fieldname].ToString();
//                        int dyncnt = 0;
//                        foreach (string dyncol in arrdyncolname)
//                        {
//                            if (fieldname == dyncol)
//                            {
//                                fieldvalue = arrdyncolval[dyncnt];
//                            }
//                            dyncnt++;
//                        }
//                        if (fieldvalue.ToUpper() != "SKIP")
//                        {
//                            CustomAssertEqual(fieldvalue, columnvalueslist[rowcnt - 1], $"Mismatch with {fieldname} ", $"Field Name {fieldname} ", test);
//                        }
//                        else
//                        {
//                            Trace.WriteLine($"Field Name {fieldname}  with  actual value {columnvalueslist[rowcnt - 1]}  is skipped for Comparison");
//                        }
//                        rowcnt++;
//                    }
//                    k++; //Next UI Page Object in List Please;
//                }
//                ScrollToBegining(ScrollbarObj, scrollp, scrollsize);
//            }
//
//            public static void VerifyDynamicValueAgGridfromDataTable(DataTable dt, List<By> bylist, ExtentTest test, string DynamicColNames, string DynamicColVals)
//            {
//                double height = SystemParameters.PrimaryScreenHeight;
//                double width = SystemParameters.PrimaryScreenWidth;
//                Console.Write("Screen size found width:-" + width);
//                double half = width / 2;
//                string scrollp = half.ToString();
//                int scrollsize = 0;
//                Console.WriteLine("size->" + scrollsize);
//                int k = 0;
//                string[] arrdyncolname = DynamicColNames.Split(new char[] { ';' });
//                string[] arrdyncolval = DynamicColVals.Split(new char[] { ';' });
//
//                foreach (DataColumn col in dt.Columns)
//                {
//                    By uiobj = bylist[k];
//                    List<string> columnvalueslist = GetAllValuesUnderColumn(uiobj, scrollp, scrollsize);
//                    int rowcnt = 0;
//                    string fieldname = col.ColumnName;
//                    foreach (DataRow dr in dt.Rows)
//                    {
//                        string fieldvalue = dr[fieldname].ToString();
//                        int dyncnt = 0;
//                        foreach (string dyncol in arrdyncolname)
//                        {
//                            if (fieldname == dyncol)
//                            {
//                                fieldvalue = arrdyncolval[dyncnt];
//                            }
//                            dyncnt++;
//                        }
//                        if (fieldvalue.ToUpper() != "SKIP")
//                        {
//                            if (arrdyncolname.Contains(fieldname)) //If we know we want to Check for specicf Column Value to be Same in all rows for that column
//                            {
//                                CustomAssertEqual(fieldvalue, columnvalueslist[rowcnt], "Mismatch", $"Ag Grid  Column name: {fieldname}", test);
//                            }
//                            else
//                            {
//                                CustomCollectionAssertEqual(fieldvalue, columnvalueslist, $"Mismatch with {fieldvalue} ", $"Field Value {fieldvalue} Not Present in any grid cells ", test);
//                            }
//                        }
//                        else
//                        {
//                            Trace.WriteLine($"Field Name {fieldname} Not Present in any grid cells ");
//                        }
//                        rowcnt++;
//                    }
//                    k++; //Next UI Page Object in List Please;
//                }
//            }
//            private static List<string> GetAllValuesUnderColumn(By columndefby, string scrollp, int scrollsize)
//            {
//                List<string> lststringvaluesforcolumn = SeleniumActions.Gettotalrecordsinlistelemnevisisble(columndefby);
//                double i = Convert.ToDouble(scrollp);
//                while (lststringvaluesforcolumn == null)
//                {
//                    SeleniumActions.Scrollbyel(PageObjects.TrackingItemPage.scrollHorizontalContainerTrackingItemMasterGird, scrollp, "0");
//                    lststringvaluesforcolumn = SeleniumActions.Gettotalrecordsinlistelemnevisisble(columndefby);
//                    i = i + Convert.ToDouble(scrollp);
//                    if (i > scrollsize)
//                    {
//                        Trace.WriteLine($"Maximum scrolling point reached Column {columndefby.ToString()} ");
//                        break;
//
//                    }
//                }
//                if (lststringvaluesforcolumn.Count == 0)
//                {
//                    lststringvaluesforcolumn.Add("NA");
//                    Trace.WriteLine($"Maximum scrolling point reached Column {columndefby.ToString()} and No values could be fetched even after max scroll ");
//                }
//                return lststringvaluesforcolumn;
//            }
//
//            public static void ScrollToBegining(By ScrollbarObj, string scrollp, int scrollsize)
//            {
//                double i = Convert.ToDouble(scrollp);
//                while (i > scrollsize)
//                {
//                    Scrollbyel(ScrollbarObj, "-" + scrollp, "0");
//                    Scrollbyel(ScrollbarObj, "-" + scrollp, "0");
//                    i = i - Convert.ToDouble(scrollsize);
//                }
//            }
//
//            private static List<string> GetAllValuesUnderColumnScrollVertical(By columndefby, string scrollp, int scrollsize, By HScroll, By Vscroll)
//            {
//                //get Total Records in grid
//                By rowcountinfo = GetByLocator("Xpath", "//span[text()='Total Rows']/following-sibling::span", "Records count in UI");
//                string rowount = GetInnerTextForVisibleElement(rowcountinfo);
//                List<string> lststringvaluesforcolumn = SeleniumActions.Gettotalrecordsinlistelemnevisisble(columndefby, int.Parse(rowount), Vscroll);
//                double i = Convert.ToDouble(scrollp);
//                while (lststringvaluesforcolumn == null || lststringvaluesforcolumn.Count == 0)
//                {
//                    SeleniumActions.Scrollbyel(HScroll, scrollp, "0");
//                    lststringvaluesforcolumn = SeleniumActions.Gettotalrecordsinlistelemnevisisble(columndefby, int.Parse(rowount), Vscroll);
//                    i = i + Convert.ToDouble(scrollp);
//                    if (i > scrollsize)
//                    {
//                        Trace.WriteLine($"Maximum scrolling point reached Column {columndefby.ToString()} ");
//                        break;
//
//                    }
//                }
//                if (lststringvaluesforcolumn.Count == 0)
//                {
//                    lststringvaluesforcolumn.Add("NA");
//                    Trace.WriteLine($"Maximum scrolling point reached Column {columndefby.ToString()} and No values could be fetched even after max scroll ");
//                }
//                return lststringvaluesforcolumn;
//            }
//
//
//
//
//
//
//
//
//
//            public static void VerifyAgGridfromDataTable(DataTable dt, List<By> bylist, By HScrollbarObj, By VScrollbarObj, ExtentTest test, string DynamicColNames, string DynamicColVals, double prec = 0.1)
//            {
//                double height = SystemParameters.PrimaryScreenHeight;
//                double width = SystemParameters.PrimaryScreenWidth;
//                Console.Write("Screen size found width:-" + width);
//                double half = width / 2;
//                string scrollp = half.ToString();
//                string style = GetAttribute(HScrollbarObj, "style");
//                string[] splitstyle = style.Split(':');
//                string[] splitstyle2 = splitstyle[1].Split(';');
//                Console.WriteLine("style1->" + splitstyle[1]);
//                Console.WriteLine("style->" + splitstyle2[0]);
//                int scrollsize = int.Parse(splitstyle2[0].Substring(0, splitstyle2[0].Length - 2));
//                Console.WriteLine("size->" + scrollsize);
//                int k = 0;
//                string[] arrdyncolname = DynamicColNames.Split(new char[] { ';' });
//                string[] arrdyncolval = DynamicColVals.Split(new char[] { ';' });
//
//                foreach (DataColumn col in dt.Columns)
//                {
//                    By uiobj = bylist[k];
//                    List<string> columnvalueslist = GetAllValuesUnderColumnScrollVertical(uiobj, scrollp, scrollsize, HScrollbarObj, VScrollbarObj);
//                    int rowcnt = columnvalueslist.Count;
//                    string fieldname = col.ColumnName;
//                    int cnt = 0;
//                    foreach (DataRow dr in dt.Rows)
//                    {
//                        string fieldvalue = dr[fieldname].ToString();
//                        int dyncnt = 0;
//                        foreach (string dyncol in arrdyncolname)
//                        {
//                            if (fieldname == dyncol)
//                            {
//                                fieldvalue = arrdyncolval[dyncnt];
//                            }
//                            dyncnt++;
//                        }
//                        if (fieldvalue.ToUpper() != "SKIP")
//                        {
//                            CustomAssertEqualPercent(fieldvalue, columnvalueslist[cnt], $"Mismatch with {fieldname} ", $"Field Name {fieldname} ", test, prec);
//                        }
//                        else
//                        {
//                            Trace.WriteLine($"Field Name {fieldname}  with  actual value {columnvalueslist[rowcnt - 1]}  is skipped for Comparison");
//                        }
//                        rowcnt++;
//                        cnt++;
//                    }
//                    k++; //Next UI Page Object in List Please;
//                }
//                ScrollToBegining(HScrollbarObj, scrollp, scrollsize);
//            }
//
//            public static List<string> Gettotalrecordsinlistelemnevisisble(By elem, int maxlength, By vscroll)
//            {
//                try
//                {
//                    List<string> textsinelement = new List<string>();
//                    IList<IWebElement> elems;
//                    WebDriverWait wait = new WebDriverWait(ngDriver, TimeSpan.FromSeconds(5));
//                    while (textsinelement.Count < maxlength)
//                    {
//                        elems = null;
//                        elems = driver.FindElements(elem).Where(x => x.Displayed).ToArray();
//                        int cellhieght = -1;
//                        if (elems.Count > 0)
//                        {
//                            foreach (var el in elems)
//                            {
//                                cellhieght = el.Size.Height;
//                                if (el.Size != System.Drawing.Size.Empty)
//                                {
//                                    textsinelement.Add(el.Text);
//                                }
//                            }
//                            string vpos1 = (cellhieght * elems.Count).ToString();
//                            Scrollbyel(vscroll, "0", vpos1);
//                        }
//                        else
//                        {
//                            CommonHelper.TraceLine($"The Element defintion for {elem}  was not found: Probably the Column header definition was updated ");
//                            elems = null;
//                            Thread.Sleep(1000);
//                            // re attempt for refreshed DOM
//                            elems = driver.FindElements(elem).Where(x => x.Displayed).ToArray();
//                            cellhieght = -1;
//                            if (elems.Count > 0)
//                            {
//                                foreach (var el in elems)
//                                {
//                                    cellhieght = el.Size.Height;
//                                    if (el.Size != System.Drawing.Size.Empty)
//                                    {
//                                        textsinelement.Add(el.Text);
//                                    }
//                                }
//                                string vpos1 = (cellhieght * elems.Count).ToString();
//                                Scrollbyel(vscroll, "0", vpos1);
//                            }
//                            else
//                            {
//                                CommonHelper.TraceLine($"The Element defintion not found after 2 attempts...");
//                                break;
//                            }
//                        }
//
//                    }
//                    return textsinelement;
//                }
//                catch (Exception e)
//                {
//                    CommonHelper.TraceLine($"Error finding colunn header {e.ToString()}");
//                    return null;
//                }
//            }
//        #endregion
//
//        #region GetDataFromExcelSpreadSheet
//
//            public static DataTable dtFromExcelFile(string filepath, string sheetname, string filtercolumnName, string filtervalue)
//            {
//                try
//                {
//                    DataTable dtble = new DataTable();
//                    OdbcConnection oconn = new OdbcConnection();
//                    oconn.ConnectionString = ConfigurationManager.AppSettings.Get("excelDSN").ToString() + filepath;
//                    string odbccmdtext = "Select * from [" + sheetname + "$]  where " + filtercolumnName + "='" + filtervalue + "'";
//                    OdbcCommand ocmd = new OdbcCommand(odbccmdtext, oconn);
//                    oconn.Open();
//                    OdbcDataAdapter da = new OdbcDataAdapter(ocmd);
//                    da.Fill(dtble);
//                    oconn.Close();
//                    return dtble;
//                }
//                catch (Exception ex)
//                {
//                    Trace.WriteLine("Got Error " + ex.Message);
//                    Assert.Fail(ex.Message.ToString());
//                    return null;
//                }
//
//            }
//            public static void VerifyDataFromExcel(string filepath, string sheetname, string testcaseid, ExtentTest test)
//            {
//                //  DataTable dt = dtFromExcelFile(filepath, sheetname, "TCName", testcaseid);
//                DataSet ds = CommonHelper.DataSetfromExcel(filepath, new string[] { sheetname });
//                DataTable dtall = ds.Tables[sheetname];
//                DataTable dt = CommonHelper.FilteredDT(dtall, "TCName", testcaseid);
//                foreach (DataRow drow in dt.Rows)
//                {
//                    string elemDesc = drow["ElemDesc"].ToString();
//                    string searchBy = drow["SearchBy"].ToString();
//                    string searchValue = drow["SearchValue"].ToString();
//                    string action = drow["Action"].ToString();
//                    string expValue = drow["ExpValue"].ToString();
//                    switch (action.ToLower())
//                    {
//                        case "verifyvalues":
//                        {
//                            org.openqa.selenium.By byelem = GetByLocator(searchBy, searchValue, elemDesc);
//                            SeleniumActions.CustomAssertEqual(expValue, SeleniumActions.GetText(byelem), $"mismatch for {elemdesc}", elemdesc, test);
//                            break;
//                        }
//                        case "click":
//                        {
//                            By byelem = GetByLocator(searchBy, searchValue, elemDesc);
//                            SeleniumActions.WaitClick(byelem);
//                            break;
//                        }
//                        default:
//                            break;
//                    }
//
//                }
//            }
//        #endregion
//
//
//        }
//    }
//}
