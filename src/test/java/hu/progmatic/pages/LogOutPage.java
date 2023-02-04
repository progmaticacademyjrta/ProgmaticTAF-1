package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LogOutPage {

    WebDriver driver;
    WebDriverWait wait;

    By goToHome = By.xpath("//*[@id=\"summary\"]/div/div/div[7]/p/a");
    public LogOutPage(WebDriver driver, WebDriverWait wait){
        this.driver= driver;
        this.wait = wait;
    }

    public void findTheGoHomeButtonAndClick(){
        WebElement goHomeButton = driver.findElement(goToHome);
        goHomeButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");
    }

}
