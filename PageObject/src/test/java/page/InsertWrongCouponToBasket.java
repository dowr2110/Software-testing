package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InsertWrongCouponToBasket {

    private WebDriver driver;
    private static final int TIME_OUT_SECONDS = 20;
    private static final String PRODUCT_URL="https://kamilmarket.com/ak-gamburger";

    public InsertWrongCouponToBasket (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public  InsertWrongCouponToBasket openPage(){
        driver.get(PRODUCT_URL);
        //driver.manage().window().maximize();
        return  this;
    }

    public InsertWrongCouponToBasket addToBasket(){
        WebElement searchInput= driver.findElement(By.xpath("//input[@class=\"form-control form-control-lg\"]"));
        searchInput.clear();
        searchInput.sendKeys("5");
        return this;
    }

    public InsertWrongCouponToBasket openBasket(){
        clickButtonByXpath(By.xpath("//a[@class=\"btn btn-primary btn-lg btn-block btn-add-to-cart ajax-cart-link\"]"));
        return this;
    }

    public InsertWrongCouponToBasket toBasket(){
        clickButtonByXpath(By.xpath("//a[@class=\"btn btn-success btn-flat btn-flat-light btn-block btn-action\"]"));
        return this;
    }

    public InsertWrongCouponToBasket clickToCoupon(){
        clickButtonByXpath(By.xpath("//h5[@class=\"cart-action-title collapsed\"]"));
        return this;
    }

    public InsertWrongCouponToBasket insertWrong(){
        WebElement searchInput= driver.findElement(By.xpath("//input[@name=\"discountcouponcode\"]"));
        searchInput.sendKeys("dowran");
        clickButtonByXpath(By.xpath("//button[@class=\"btn btn-primary apply-discount-coupon-code-button\"]"));
        return this;
    }

    public String getErrorCoupon() {
        return waitForElementLocatedBy(driver, By.xpath("//div[@class=\"alert alert-danger fade show\"]"), TIME_OUT_SECONDS).getText();
    }

    public static WebElement waitForElementLocatedBy(WebDriver driver, By by, long time) {
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    private void clickButtonByXpath(By by) {
        new WebDriverWait(driver, TIME_OUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(by))
                .click();
    }
}
