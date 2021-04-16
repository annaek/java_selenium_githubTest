package github.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WebDriverCloseableAdapter;

public class CreateWikiPage {

    private static final By TITLE = By.id("gollum-editor-page-title");
    private static final By TEXT = By.id("gollum-editor-body");
    private static final By SUBMIT_BUTTON = By.id("gollum-editor-submit");
    private final WebDriverCloseableAdapter ca;

    public CreateWikiPage(WebDriverCloseableAdapter ca){
        this.ca = ca;
    }


    public void createWiki(String title, String text) throws Exception {
        checkUrl();

        WebElement titleElem = ca.getWait().until(ExpectedConditions.elementToBeClickable(TITLE));
        titleElem.clear();
        titleElem.sendKeys(title);

        WebElement textBody = ca.getDriver().findElement(TEXT);
        textBody.clear();
        textBody.sendKeys(text);

        WebElement savePage = ca.getWait()
                .until(ExpectedConditions.elementToBeClickable(SUBMIT_BUTTON));
        savePage.click();


    }



    private void checkUrl() throws Exception {
        String expectedUrl = "/wiki/_new";
        String currentUrl = ca.getDriver().getCurrentUrl();

        if(!currentUrl.endsWith(expectedUrl)){
            throw new Exception("The " + currentUrl + " is not valid");
        }
    }

}
