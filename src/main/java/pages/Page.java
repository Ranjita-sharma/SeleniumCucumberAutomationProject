package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    public WebDriver driver;
    public WebDriverWait wait;

    //page class Constructor and passing the webdriver
    public Page(WebDriver driver) {
        this.driver = driver;
    //    this.wait = wait;
        // PageFactory.initElements(driver,this);
    }

    //This method with Java Generics and will return a new page
//    public <Tpage extends PageBase> Tpage getInstance(Class<Tpage> pageClass) {
//        try {
//            return pageClass.getDeclaredConstructor(WebDriver.class, WebDriverWait.class).newInstance(this.driver, this.wait);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//
//        }
    }
