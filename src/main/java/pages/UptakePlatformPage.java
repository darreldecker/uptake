package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.WebDriverBase;

public class UptakePlatformPage extends WebDriverBase{

    public UptakeNav nav = new UptakeNav();

    public WebElement lnkIntro(){
        return driver.findElement(By.xpath("//a[text()[contains(.,'Intro')]]"));
    }

    public WebElement lnkGeneration(){
        return driver.findElement(By.xpath("//a[text()[contains(.,'Generation')]]"));
    }

    public WebElement lnkNormalization(){
        return driver.findElement(By.xpath("//a[text()[contains(.,'Normalization')]]"));
    }

    public WebElement lnkStorage(){
        return driver.findElement(By.xpath("//a[text()[contains(.,'Storage')]]"));
    }

    public WebElement lnkAnalysis(){
        return driver.findElement(By.xpath("//a[text()[contains(.,'Analysis')]]"));
    }

    public WebElement lnkToolsAndServices(){
        return driver.findElement(By.xpath("//a[text()[contains(.,'Tools & Services')]]"));
    }

    public WebElement lnkSolutions(){
        return driver.findElement(By.xpath("//a[text()[contains(.,'Solutions')]]"));
    }

}
