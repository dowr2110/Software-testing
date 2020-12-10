import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobject.KamilMarketBasketPage;
import pageobject.KamilMarketItemPage;

public class KamilMarketTest {

    private WebDriver driver;

    @BeforeTest
    public void init() {
        driver = new ChromeDriver();
    }

    @Test
    public void addMoreThanMaxValue() {
        Boolean moreThanMaxSelected = new KamilMarketItemPage(driver)
                .openPage()
                .searchElement("Airwick Howa Tamizleyiji Lawanda 250 Ml")
                .selectMoreThanMaxValue("100000")
                .addToBasket()
                .getErrorMessage();
         Assert.assertFalse(moreThanMaxSelected, "Added more than maximum size of element to basket");
    }

    @Test
    public void insertWrongCoupon() {
        Boolean wrongCoupon = new KamilMarketBasketPage(driver)
                .openPage()
                .inputWrongCoupon("dowran")
                .getErrorMessage();
       Assert.assertFalse(wrongCoupon, "Inserted wrong coupon");
    }

    @AfterTest
    public void closeDriver() {
    driver.quit();
    }
}
