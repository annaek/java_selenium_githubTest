package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCloseableAdapter implements AutoCloseable {

    private final WebDriver driver;
    private final WebDriverWait wait;
    public WebDriverCloseableAdapter(WebDriver driver, int timeout){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, timeout);
    }

    @Override
    public void close() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
