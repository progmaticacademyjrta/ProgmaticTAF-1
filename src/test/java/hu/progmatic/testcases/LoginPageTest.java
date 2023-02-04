package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginPageTest extends DriverBaseTest {
    LoginPage loginPage;

    @Test(groups = {"login"},description = "TC03: Login page testing with invalid username and password.Type any kind of letters, or not, it doesn't mather.")
    public void invalidPswAndUserNameLoginTest(){
        loginPage = new LoginPage(driver, wait);
        loginPage.goToLoginPageAndGetInvalidPswAndUsername("https://katalon-demo-cura.herokuapp.com/profile.php#login", "invalid", "wrong");
    }
}
