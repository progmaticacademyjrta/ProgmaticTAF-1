package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.HomePage;
import hu.progmatic.pages.LoginPage;
import org.testng.annotations.Test;

public class HomePageTests extends DriverBaseTest {
    HomePage homePage;
    LoginPage loginPage;

    @Test(description = "TC01: Homepage loaded test that loads the page and validates whether the header is displayed or not.")
    public void homepageLoadedTest() {
        homePage = new HomePage(driver, wait);
        homePage.loadHomePage();
    }
    @Test(description = "TC02: The pages loaded and the 'Make Appointment' button is clickable.")
    public void makeAppointmentButtonIsClickableTest(){
        homePage = new HomePage(driver, wait);
        homePage.loadHomePageWithClickableButton("https://katalon-demo-cura.herokuapp.com/");
    }

    @Test(description = "TC03: Login page testing with invalid username and password.Type any kind of letters, or not, it doesn't mather.")
    public void invalidPswAndUserNameLoginTest(){
       loginPage = new LoginPage(driver, wait);
       loginPage.goToLoginPageAndGetInvalidPswAndUsername("https://katalon-demo-cura.herokuapp.com/profile.php#login", "invalid", "wrong");
    }

    

}
