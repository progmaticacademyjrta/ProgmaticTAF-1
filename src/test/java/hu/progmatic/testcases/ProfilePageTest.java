package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.LoginPage;
import hu.progmatic.pages.ProfilePage;
import org.testng.annotations.Test;

public class ProfilePageTest extends DriverBaseTest {
    ProfilePage profilePage;
    LoginPage loginPage;

    @Test(description = "")
    public void profilePageIsLoadedTest(){
        profilePage = new ProfilePage(driver, wait);
        loginPage = new LoginPage(driver, wait);

        loginPage.goToLoginPageAndGetCorrectPswAndUsername();
        profilePage.profilePageIsLoadedCorrect();

    }
}
