package common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverUtil {
    public static WebDriver createDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anna new\\Documents\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        return driver;
    }
}
