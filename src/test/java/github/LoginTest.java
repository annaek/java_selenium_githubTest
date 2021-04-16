package github;

import common.DriverUtil;
import github.pages.GithubUser;
import github.pages.LoginPage;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.CustomExpectedConditions;
import utils.WebDriverCloseableAdapter;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LoginTest {
    @Test

    public void successfulLogin() throws Exception {

        try (WebDriverCloseableAdapter ca = new WebDriverCloseableAdapter(DriverUtil.createDriver(), 5)) {
            LoginPage login = new LoginPage(ca);
            login.autorize(GithubUser.DEFAULT_USER);

            //Thread.sleep(5000);
            Boolean expectedUrl = ca.getWait()
                    .until(ExpectedConditions.urlContains("github.com"));
            assertTrue(expectedUrl);

            //String expectedUrl = "https://github.com/";
            //String currentUrl = ca.getDriver().getCurrentUrl();

            //assertEquals(expectedUrl, currentUrl);

            /*
                       Boolean isValidURL = ca.getWait()
                    .until(ExpectedConditions.urlContains("/issues"));

            assertTrue(isValidURL);
             */

        }
    }


    @Test
    @Ignore
    public void invalidEmailTest() throws Exception {

        try (WebDriverCloseableAdapter ca = new WebDriverCloseableAdapter(DriverUtil.createDriver(), 5)) {
            LoginPage login = new LoginPage(ca);
            login.autorize(new GithubUser("anna85ek21.gmail.com", "34r23r"));

            boolean elemExist = true;

            try {
                WebElement error = ca.getDriver().findElement(By.xpath("//div[contains(@class, 'flash-error')]"));
            } catch (NoSuchElementException e) {
                elemExist = false;
            }
            assertTrue("Error message not found", elemExist);

        }
    }

    @Test
    public void findRepositories() throws Exception {
        //throw new InterruptedException();
        try (WebDriverCloseableAdapter ca = new WebDriverCloseableAdapter(DriverUtil.createDriver(), 10)) {

            LoginPage login = new LoginPage(ca);
            login.autorize(GithubUser.DEFAULT_USER);

            List<WebElement> repository = ca.getWait()
                    .until(CustomExpectedConditions.waitForElements(By.cssSelector("#repos-container ul li a")));


            if (repository.size() == 0) {
                assertTrue(false);
                return;
            }

            WebElement firstElement = repository.get(0);
            firstElement.click();


            WebElement issue = ca.getWait()
                    .until(ExpectedConditions.elementToBeClickable(By.linkText("Issues")));

            issue.click();

            Boolean isValidURL = ca.getWait()
                    .until(ExpectedConditions.urlContains("/issues"));

            assertTrue(isValidURL);

        }

    }


}
//todo create class for creating Wiki page,
// make method with 3 arguments. if one argument null then delete text.

