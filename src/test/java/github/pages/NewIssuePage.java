package github.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WebDriverCloseableAdapter;

public class NewIssuePage {
    private static final By TITLE = By.id("issue_title");
    private static final By COMMENT = By.id("issue_body");
    private static final By SUBMIT_BUTTON = By.cssSelector("#new_issue button[type=submit]");
    private final WebDriverCloseableAdapter ca;

    public NewIssuePage(WebDriverCloseableAdapter ca){
        this.ca = ca;
    }
    public void createIssue(String title, String comment) throws Exception {

        checkUrl();

        WebElement titleElem= ca.getWait().until(ExpectedConditions.elementToBeClickable(TITLE));

        titleElem.sendKeys(title);

        WebElement textComment = ca.getDriver().findElement(COMMENT);

        textComment.sendKeys(comment);

        WebElement submitNewIssue = ca.getWait()
                .until(ExpectedConditions.elementToBeClickable(SUBMIT_BUTTON));
        submitNewIssue.click();

    }

    private void checkUrl() throws Exception {
        String expectedUrl = "/issues/new";
        String currentUrl = ca.getDriver().getCurrentUrl();

        if(!currentUrl.endsWith(expectedUrl)){
            throw new Exception("The " + currentUrl + " is not valid");
        }
    }
}
