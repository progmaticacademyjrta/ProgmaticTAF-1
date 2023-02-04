package hu.progmatic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProfilePage {
    WebDriver driver;
    WebDriverWait wait;
    By menuButton = By.xpath("//*[@id=\"menu-toggle\"]/i");

    By profileButton = By.xpath("//*[@id=\"sidebar-wrapper\"]/ul/li[4]/a");

    By profileText = By.xpath("//*[@id=\"profile\"]/div/div/div/p[1]");

    public ProfilePage(WebDriver driver, WebDriverWait wait){
        this.driver= driver;
        this.wait = wait;
    }

    public void profilePageIsLoadedCorrect(){
       WebElement menuButtonClick = driver.findElement(menuButton);
        menuButtonClick.click();

        WebElement profileButtonClick = driver.findElement(profileButton);
        profileButtonClick.click();

        Assert.assertEquals(driver.findElement(profileText).getText(), "Under construction.");
        System.out.println("The profile page is loaded correct, but it is under construction.");

    }
}
