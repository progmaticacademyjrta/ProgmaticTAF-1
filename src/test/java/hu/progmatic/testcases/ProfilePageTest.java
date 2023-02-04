package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.LoginPage;
import hu.progmatic.pages.ProfilePage;
import org.testng.annotations.Test;

public class ProfilePageTest extends DriverBaseTest {
    ProfilePage profilePage;
    LoginPage loginPage;

    @Test(groups = {"login", "profile"}, description = "TC05: Go to the profile page, and check it is correctly loaded.")
    public void profilePageIsLoadedTest(){
        profilePage = new ProfilePage(driver, wait);
        loginPage = new LoginPage(driver, wait);

        loginPage.goToLoginPageAndGetCorrectPswAndUsername();
        profilePage.profilePageIsLoadedCorrect();

    }
}
