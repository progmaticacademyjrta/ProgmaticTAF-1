package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LogOutPage {

    WebDriver driver;
    WebDriverWait wait;
    By menuButton = By.xpath("//*[@id=\"menu-toggle\"]/i");
    By historyButton = By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[3]/a");

    By goToHome = By.xpath("//*[@id=\"summary\"]/div/div/div[7]/p/a");

    By historyComment = By.id("comment");
    public LogOutPage(WebDriver driver, WebDriverWait wait){
        this.driver= driver;
        this.wait = wait;
    }

    public void findTheGoHomeButtonAndClick(){
        WebElement goHomeButton = driver.findElement(goToHome);
        goHomeButton.click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://katalon-demo-cura.herokuapp.com/");
    }
    public void checkTheHistoryAfterTheAppointment(String comment){
        WebElement menuButtonClick = driver.findElement(menuButton);
        menuButtonClick.click();

        WebElement historyButtonClick = driver.findElement(historyButton);
        historyButtonClick.click();

        Assert.assertEquals(driver.findElement(historyComment).getText(), comment);

    }

}
