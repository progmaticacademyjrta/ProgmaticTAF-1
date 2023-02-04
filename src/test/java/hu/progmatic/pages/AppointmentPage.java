package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.LocalDate;
import java.util.Date;
import java.util.Random;

public class AppointmentPage {
    WebDriver driver;
    WebDriverWait wait;

    By selectFacility = By.id("combo_facility");
    By checkBoxToApply = By.cssSelector("label[class='checkbox-inline'][for='chk_hospotal_readmission']");

    By healthCareProgramNoneRadio = By.id("radio_program_none");
    By dateField = By.id("txt_visit_date");

    By commentField = By.cssSelector("textarea[class='form-control'][name='comment']");

    By bookAppointmentButton = By.id("btn-book-appointment");

    public AppointmentPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void goToAppointmentPAgeAndFiledWithCorrectInput(String date, String comment) {
        driver.get("https://katalon-demo-cura.herokuapp.com/#appointment");

        Random randomCityNumber = new Random();
        int randInt = randomCityNumber.nextInt(3);
        String city;
        switch (randInt) {
            case 0 -> city = "Tokyo";
            case 1 -> city = "Hongkong";
            default -> city = "Seoul";
        }

        Select facilityDropdown = new Select(driver.findElement(selectFacility));
        facilityDropdown.selectByVisibleText(city + " CURA Healthcare Center");

        WebElement applyCheckBox = driver.findElement(checkBoxToApply);
        applyCheckBox.click();

        WebElement radioButton = driver.findElement(healthCareProgramNoneRadio);
        radioButton.click(); //choosable by tester?

        WebElement dateInputField = driver.findElement(dateField);
        dateInputField.sendKeys(date);

        WebElement commentInputField = driver.findElement(commentField);
        commentInputField.sendKeys(comment);

        wait.until(ExpectedConditions.elementToBeClickable(bookAppointmentButton));
        WebElement bookAppointmentButtonIsClickable = driver.findElement(bookAppointmentButton);
        bookAppointmentButtonIsClickable.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/appointment.php#summary");

        System.out.println("An appointment made with valid inputs.");

    }
    public String goToAppointmentPAgeAndFiledWithCorrectInputAndGiveString(String date, String comment) {
        driver.get("https://katalon-demo-cura.herokuapp.com/#appointment");

        Random randomCityNumber = new Random();
        int randInt = randomCityNumber.nextInt(3);
        String city;
        switch (randInt) {
            case 0 -> city = "Tokyo";
            case 1 -> city = "Hongkong";
            default -> city = "Seoul";
        }

        Select facilityDropdown = new Select(driver.findElement(selectFacility));
        facilityDropdown.selectByVisibleText(city + " CURA Healthcare Center");

        WebElement applyCheckBox = driver.findElement(checkBoxToApply);
        applyCheckBox.click();

        WebElement radioButton = driver.findElement(healthCareProgramNoneRadio);
        radioButton.click(); //choosable by tester?

        WebElement dateInputField = driver.findElement(dateField);
        dateInputField.sendKeys(date);

        WebElement commentInputField = driver.findElement(commentField);
        commentInputField.sendKeys(comment);

        wait.until(ExpectedConditions.elementToBeClickable(bookAppointmentButton));
        WebElement bookAppointmentButtonIsClickable = driver.findElement(bookAppointmentButton);
        bookAppointmentButtonIsClickable.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/appointment.php#summary");

        System.out.println("An appointment made with valid inputs.");

        return comment;
    }
}
