package github;

import common.DriverUtil;
import github.pages.GithubUser;
import github.pages.LoginPage;
import github.pages.NewIssuePage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WebDriverCloseableAdapter;

import static org.junit.Assert.assertTrue;

public class IssuesTest {
    @Test
    public void createNewIssue() throws Exception {
        try (WebDriverCloseableAdapter ca = new WebDriverCloseableAdapter(DriverUtil.createDriver(), 10)) {
            LoginPage login = new LoginPage(ca);
            login.autorize(GithubUser.DEFAULT_USER);

            ca.getDriver().get("https://github.com/annaek/web3200/issues");

            WebElement newIssue = ca.getWait().until(ExpectedConditions.elementToBeClickable(new By.ByLinkText("New issue")));
            newIssue.click();

            NewIssuePage newIssuePage = new NewIssuePage(ca);
            newIssuePage.createIssue("Test", "jsdcjcfbcj");


            Boolean urlNewIssue = ca.getWait().until(ExpectedConditions.urlMatches("/issues/([0-9]+)"));
            assertTrue(urlNewIssue);

        }

    }
}
//todo selenium https://www.selenium.dev/documentation/en/guidelines_and_recommendations/page_object_models/