package test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class kamilmarketTest {

    private WebDriver driver;
    private static final int TIME_OUT_SECONDS = 10;

    @BeforeTest
    public void start() {
        driver = new ChromeDriver();
    }
    @Test
    public void searchWithParameter() {

        driver.get("https://kamilmarket.com/");
        WebElement searchInput = driver.findElement(By.id("instasearch"));
        searchInput.sendKeys("bulka");
        clickButtonByXpath(By.xpath("//button[@class=\"btn btn-primary btn-icon instasearch-button\"]"));

        List<WebElement> searchResultForBulka = (List<WebElement>) driver.findElement(By.xpath("//div[@class=\"artlist artlist-grid artlist-5-cols\"]"));
        Assert.assertTrue("searchReasult are empty", searchResultForBulka.size() > 0);


    }

    @AfterTest(alwaysRun = true)
    public void finish() {
        driver.quit();
    }

    private void clickButtonByXpath(By by) {
        new WebDriverWait(driver, TIME_OUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(by))
                .click();
    }
}