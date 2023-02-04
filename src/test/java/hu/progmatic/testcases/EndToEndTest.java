package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.AppointmentPage;
import hu.progmatic.pages.HomePage;
import hu.progmatic.pages.LogOutPage;
import hu.progmatic.pages.LoginPage;
import org.testng.annotations.Test;

public class EndToEndTest extends DriverBaseTest {
    AppointmentPage appointmentPage;
    LoginPage loginPage;

    HomePage homePage;
    LogOutPage logOutPage;

    @Test(description = "TC06: End to End test, go to the home page, and the login page, login with correct data, than make appointment, and log out.Type city (Tokyo, Seoul, Hongkong), type date 'dd/mm/yyyy' and type comment\"")
    public void endToEndTest(){
        homePage = new HomePage(driver, wait);
        appointmentPage = new AppointmentPage(driver, wait);
        loginPage = new LoginPage(driver, wait);
        logOutPage = new LogOutPage(driver, wait);

        homePage.loadHomePageWithClickableButton("https://katalon-demo-cura.herokuapp.com/");
        loginPage.goToLoginPageAndGetCorrectPswAndUsername();
        appointmentPage.goToAppointmentPAgeAndFiledWithCorrectInput("Seoul","15/03/2023","I would like to talk about my cancer.");
        logOutPage.findTheGoHomeButtonAndClick();

        System.out.println("The appointment made fully.");

    }
}
