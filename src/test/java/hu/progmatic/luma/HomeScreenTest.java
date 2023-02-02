package hu.progmatic.luma;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.luma.pages.HeaderComponent;
import hu.progmatic.luma.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeScreenTest extends DriverBaseTest {
    HomePage homePage;
    HeaderComponent header;

    @Test
    public void homepageLoadedTest() {
        homePage = new HomePage(driver);
        homePage.loadHomePage();
        /* pl ha visszaadna egy WebElementet a teszt lépés
        WebElement whatsnewMenuItem = homePage.loadHomePage();
        Assert.assertTrue(whatsnewMenuItem.isDisplayed());
        */
    }

    @Test
    public void checkHomeMainNavigation() {
        homePage = new HomePage(driver);
        homePage.loadHomePage();
        homePage.clickHomeMainImage();
        Assert.assertEquals(driver.getCurrentUrl(),
    "https://magento.softwaretestingboard.com/collections/yoga-new.html");
    }

    @Test
    public void checkJacketsMenuItem() throws InterruptedException {
        homePage = new HomePage(driver);
        header = new HeaderComponent(driver);
        homePage.loadHomePage();
        header.navigateToJacketsMenu();
        Assert.assertEquals(driver.getCurrentUrl(),
    "https://magento.softwaretestingboard.com/women/tops-women/jackets-women.html");
    }
}
