package hu.progmatic.testcases;

import hu.progmatic.driverfactory.DriverBaseTest;
import hu.progmatic.pages.HomePage;
import hu.progmatic.pages.LoginPage;
import org.testng.annotations.Test;

public class HomePageTests extends DriverBaseTest {
    HomePage homePage;


    @Test(groups = {"home"},description = "TC01: Homepage loaded test that loads the page and validates whether the header is displayed or not.")
    public void homepageLoadedTest() {
        homePage = new HomePage(driver, wait);
        homePage.loadHomePage();
    }
    @Test(groups = {"home"},description = "TC02: The pages loaded and the 'Make Appointment' button is clickable.")
    public void makeAppointmentButtonIsClickableTest(){
        homePage = new HomePage(driver, wait);
        homePage.loadHomePageWithClickableButton("https://katalon-demo-cura.herokuapp.com/");
    }



}
