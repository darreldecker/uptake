package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WebDriverBase;

public class UptakeHomePage extends WebDriverBase{

    public UptakeNav nav = new UptakeNav();

    public WebElement lnkLearnMoreAboutOurSolutions (){
        return driver.findElement(By.xpath("//a[text()[contains(.,'Learn more about our solutions ')]]"));
    }

    public WebElement lnkLearnMoreAboutOurPlatform (){
        return driver.findElement(By.xpath("//a[text()[contains(.,'Learn more about our platform ')]]"));
    }

    public WebElement lnkLearnMoreAboutOurApproach (){
        return driver.findElement(By.xpath("//a[text()[contains(.,'Learn more about our approach ')]]"));
    }

    //TODO: Add elements for the other page objects
}
