package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.function.Function;

public class CustomExpectedConditions {
    public static Function<WebDriver, List<WebElement>> waitForElements(By selector){
        return driver -> {
            List<WebElement> elements = driver.findElements(selector);
            if (elements.size() == 0) {
                return null;
            }
            return elements;
        };
    }
}
