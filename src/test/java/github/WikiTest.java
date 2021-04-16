package github;

import common.DriverUtil;
import github.pages.CreateWikiPage;
import github.pages.GithubUser;
import github.pages.LoginPage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WebDriverCloseableAdapter;

import static org.junit.Assert.assertTrue;

public class WikiTest {
    @Test
    public void createNewWikiPage() throws Exception {

        try (WebDriverCloseableAdapter ca = new WebDriverCloseableAdapter(DriverUtil.createDriver(), 10)) {

            LoginPage login = new LoginPage(ca);
            login.autorize(GithubUser.DEFAULT_USER);

            ca.getDriver().get("https://github.com/annaek/web3200/wiki");

                WebElement newPage = ca.getWait()
                        .until(ExpectedConditions.elementToBeClickable(new By.ByLinkText("New Page")));

                newPage.click();

            CreateWikiPage createPage = new CreateWikiPage(ca);
            createPage.createWiki("Web3200 Test1", "Test: This is my web project");

            Boolean urlNewIssue = ca.getWait().until(ExpectedConditions.urlMatches("/wiki/Web3200-Test1"));
            assertTrue(urlNewIssue);



        }
    }
}
