package page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;

    protected final  static  int  TIME_OUT_SECONDS =  35 ;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected void clickButtonByXpath(By by) {
        new WebDriverWait(driver, TIME_OUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(by))
                .click();
    }
    protected static WebElement waitForElementLocatedBy(WebDriver driver, By by, long time) {
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    protected ExpectedCondition<Boolean> PageLoaded() {
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            }
        };
    }

    protected void sendKeysByXpath(By by, String keys) {
        new WebDriverWait(driver, TIME_OUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(by))
                .sendKeys(keys);
    }

}
