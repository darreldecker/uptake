package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WebDriverBase;

public class UptakeNav extends WebDriverBase {
    private static WebElement element = null;
    private Boolean _isMobile = null;

    public static WebElement lnkHamburger(){
        element = driver.findElement(By.xpath("//a[@class='hamburger js-hamburger']"));
        return element;
    }

    //TODO: refactor link with a control class like we do at GrubHub so we don't have to
    //TODO: have separate elements for each control

    public static WebElement lnkPlatformHeader() {
        element = driver.findElements(By.xpath("//li/a[text()[contains(.,'Platform')]]")).get(0);
        return element;
    }

    public static WebElement lnkPlatformMobile() {
        element = driver.findElements(By.xpath("//li/a[text()[contains(.,'Platform')]]")).get(1);
        return element;
    }

    public static WebElement lnkPlatformFooter() {
        element = driver.findElements(By.xpath("//li/a[text()[contains(.,'Platform')]]")).get(2);
        return element;
    }

    //TODO: Add elements for the other page objects

    public boolean isMobile(){
        // Check to see if we're in mobile mode by looking for the hamburger button
        if(this._isMobile != null){
            return this._isMobile;
        }
        if(lnkHamburger().isDisplayed()){
            this._isMobile = true;
            return true;
        }
        this._isMobile = false;
        return false;
    }

    public void gotoPlatform(){
        if(isMobile()){
            if(lnkHamburger().isDisplayed()){
                lnkHamburger().click();
            }
            lnkPlatformMobile().click();
        }
        else{
            scrollToElement(lnkPlatformHeader());
            lnkPlatformHeader().click();
        }
    }

    public void gotoPlatformFooter(){
        lnkPlatformFooter().click();
    }


}
