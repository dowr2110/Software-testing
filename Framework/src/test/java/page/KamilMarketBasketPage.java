package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KamilMarketBasketPage extends AbstractPage {
    private final String PAGE_URL = "https://kamilmarket.com/cart";

    @FindBy(xpath = "//a[@class=\"cart-item-link\"]")
    private WebElement nameLabel;
    @FindBy(xpath = "//span[@class=\"price\"]")
    private WebElement costLabel;
    @FindBy(xpath = "//div[@class=\"col-9\"]")
    private WebElement IDLabel;
    @FindBy(xpath = "//h5[@class='cart-action-title collapsed']")
    private WebElement findPromoButton;
    @FindBy(xpath = "//input[@name='discountcouponcode']")
    private WebElement inputCoupon;
    @FindBy(xpath = "//button[@class='btn btn-primary apply-discount-coupon-code-button']")
    private WebElement selectCouponButton;
    @FindBy(xpath = "//button[@class='btn btn-danger btn-lg btn-block btn-checkout']")
    private WebElement toFormButton;
    @FindBy(xpath = "//a[@class='btn btn-secondary btn-sm btn-icon ajax-action-link']")
    private WebElement toWishListButton;
    @FindBy(xpath = "//button[@class='btn btn-warning btn-lg new-address-next-step-button']")
    private WebElement toNextButton;
    private final String checkErrorMessage="//div[@class='alert alert-danger fade show']";


    public KamilMarketBasketPage (WebDriver driver){
        super(driver);
    }

    public KamilMarketBasketPage openPage() {
        driver.get(PAGE_URL);
        return this;
    }

    public String getNameInBasket() {
        return nameLabel.getText();
    }

    public String getIDInBasket() {
        return IDLabel.getText();
    }

    public String getCostInBasket() {
        return costLabel.getText();
    }

    public KamilMarketBasketPage inputWrongPromocode(String promocode) {
        findPromoButton.click();
        inputCoupon.sendKeys(promocode);
        return this;
    }

    public KamilMarketBasketPage addPromocode() {
        selectCouponButton.click();
        return this;
    }

    public String getErrorMessageInBasket() {
        return waitForElementLocatedBy(driver, By.xpath(checkErrorMessage), TIME_OUT_SECONDS).getText();
    }

    public String getCostAfterInserPromoInBasket() {
        return costLabel.getText();
    }

    public KamilMarketBillingAddressPage toFormalization() {
        toFormButton.click();
        return new KamilMarketBillingAddressPage(driver);
    }

    public KamilMarketWishListPage toWishList() {
        toWishListButton.click();
        return new KamilMarketWishListPage(driver);
    }
}


