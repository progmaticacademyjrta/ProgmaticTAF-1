package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    By usernameInputField = By.id("txt-username");
    By passwordInputField = By.id("txt-password");
    By loginButton = By.id("btn-login");

    By loginErrorMessage = By.xpath("//*[@id=\"login\"]/div/div/div[1]/p[2]");

    public LoginPage(WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }
    public void goToLoginPageAndGetInvalidPswAndUsername(String url, String User, String Psw){
        driver.get(url);

        WebElement usernameInput = driver.findElement(usernameInputField);
        usernameInput.sendKeys(User);

        WebElement passwordInput = driver.findElement(passwordInputField);
        passwordInput.sendKeys(Psw);

        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        WebElement loginButtonClickable = driver.findElement(loginButton);
        loginButtonClickable.click();

        /*String error = driver.findElement(loginErrorMessage).getText();
        System.out.println(error);*/

        Assert.assertEquals(driver.findElement(loginErrorMessage).getText(), "Login failed! Please ensure the username and password are valid.");
        System.out.println("The login is give error message, the login is not happend.");

    }
    public void goToLoginPageAndGetCorrectPswAndUsername(String User, String Psw){
        driver.get("https://katalon-demo-cura.herokuapp.com/profile.php#login");

        WebElement usernameInput = driver.findElement(usernameInputField);
        usernameInput.sendKeys(User);

        WebElement passwordInput = driver.findElement(passwordInputField);
        passwordInput.sendKeys(Psw);

        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        WebElement loginButtonClickable = driver.findElement(loginButton);
        loginButtonClickable.click();


        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/#appointment");
        System.out.println("The login is complete.");

    }

}
