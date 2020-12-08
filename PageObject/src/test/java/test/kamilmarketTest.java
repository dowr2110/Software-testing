package test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page.AddToBasket;
import page.InsertWrongCouponToBasket;

public class kamilmarketTest {

    private WebDriver driver;
    private static final int TIME_OUT_SECONDS = 20;

    @BeforeTest
    public void start() {

        driver = new ChromeDriver();
    }

    @Test
    public void addToBasket() {
        AddToBasket cartPage = new AddToBasket(driver)
                .openPage()
                .addFiveBulka()
                .clickToButtonAdd();
        Assert.assertTrue(cartPage.getName().contains("Bulochka"));
        Assert.assertTrue(cartPage.getCost().contains("31,50m."));
    }

    @Test
    public void insertWrongCoupon(){
        InsertWrongCouponToBasket WrongCoupon =new InsertWrongCouponToBasket(driver)
                .openPage()
                .addToBasket()
                .openBasket()
                .toBasket()
                .clickToCoupon()
                .insertWrong();
        Assert.assertFalse(WrongCoupon.getErrorCoupon().contains("Код купона введен не мог быть применен к вашему заказу"));
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