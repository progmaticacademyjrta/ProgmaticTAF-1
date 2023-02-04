package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.AppointmentPage;
import hu.progmatic.pages.LoginPage;
import org.testng.annotations.Test;

public class AppointmentPageTest extends DriverBaseTest {
    AppointmentPage appointmentPage;
    LoginPage loginPage;

    @Test(groups = {"login", "appointment"},description = "TC04: Test the appointment booking page is work excellent. Type city (Tokyo, Seoul, Hongkong), type date 'dd/mm/yyyy' and type comment")
    public  void appointmentPageWithCorrectInputTest(){
        appointmentPage = new AppointmentPage(driver, wait);
        loginPage = new LoginPage(driver, wait);

        loginPage.goToLoginPageAndGetCorrectPswAndUsername();
        appointmentPage.goToAppointmentPAgeAndFiledWithCorrectInput("Tokyo", "23/02/2023", "everything gonna be alright");
    }

}
