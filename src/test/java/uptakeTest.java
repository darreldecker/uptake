import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.UptakeHomePage;
import pages.UptakePlatformPage;
import utils.WebDriverBase;

public class uptakeTest {

    private WebDriver driver = new WebDriverBase().createDriver();

    @Test
    public void uptakeTest(){
        driver.get("http://www.uptake.com");
        UptakeHomePage home = new UptakeHomePage();

        // Do some validation on the home page
        Assert.assertTrue("Verify the page url", home.getCurrentUrl().contains("uptake.com"));
        Assert.assertTrue("Verify the 'Learn more about our approach' link displays", home.lnkLearnMoreAboutOurApproach().isDisplayed());
        Assert.assertTrue("Verify the 'Learn more about our platform' link displays", home.lnkLearnMoreAboutOurPlatform().isDisplayed());
        Assert.assertTrue("Verify the 'Learn more about our solutions' link displays", home.lnkLearnMoreAboutOurSolutions().isDisplayed());


        // link over to the platform page and verify some stuff
        UptakePlatformPage platform = new UptakePlatformPage();
        home.nav.gotoPlatform();
        Assert.assertTrue("Verify the page url", home.getCurrentUrl().contains("uptake.com/platform"));
        Assert.assertTrue("Verify the Intro link displays", platform.lnkIntro().isDisplayed());
        Assert.assertTrue("Verify the Generation link displays", platform.lnkGeneration().isDisplayed());
        Assert.assertTrue("Verify the Normalization link displays", platform.lnkNormalization().isDisplayed());
        Assert.assertTrue("Verify the Storage link displays", platform.lnkStorage().isDisplayed());
        Assert.assertTrue("Verify the Analysis link displays", platform.lnkAnalysis().isDisplayed());
        Assert.assertTrue("Verify the Tools & Services link displays", platform.lnkToolsAndServices().isDisplayed());
        Assert.assertTrue("Verify the Solutions link displays", platform.lnkSolutions().isEnabled());

        driver.close();
    }
}
