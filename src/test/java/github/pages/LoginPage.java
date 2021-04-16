package github.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WebDriverCloseableAdapter;

public class LoginPage {
    private static final By LOGIN_SELECTOR = By.id("login_field");
    private static final By PASSWORD_SELECTOR = By.id("password");
    private static final By SUBMIT_BUTTON = By.cssSelector("input[type='submit']");

    private final WebDriverCloseableAdapter ca;


    public LoginPage(WebDriverCloseableAdapter ca){
        this.ca = ca;
    }

    public void autorize(GithubUser user){

        ca.getDriver().get("https://github.com/login");


        ca.getWait().until((ExpectedConditions.elementToBeClickable(LOGIN_SELECTOR)));


        WebElement usernameElement = ca.getDriver().findElement(LOGIN_SELECTOR);
        usernameElement.sendKeys(user.getLogin());

        WebElement passwordElement = ca.getDriver().findElement(PASSWORD_SELECTOR);
        passwordElement.sendKeys(user.getPassword());

        WebElement signIn = ca.getDriver().findElement(SUBMIT_BUTTON);

        signIn.click();

    }
}
