package pageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KamilMarketBasketPage extends Page {

    private final String PAGE_URL = "https://kamilmarket.com/cart";

    @FindBy(xpath = "//a[@class=\"btn btn-primary btn-lg btn-block btn-add-to-cart ajax-cart-link\"]")
    private WebElement AddToBasketButton;
    @FindBy(xpath = "//input[@class='form-control form-control-lg']")
    private WebElement CountInput;
    @FindBy(xpath = "//h1[@class='h3']")
    private WebElement ErrorMessage;
    @FindBy(xpath = "//div[@class='art-picture-block']")
    private WebElement SelectButton;
    @FindBy(xpath = "//a[@class='btn btn-success btn-flat btn-flat-light btn-block btn-action']")
    private WebElement GotToBasketButton2;
    @FindBy(xpath = "//h5[@class='cart-action-title collapsed']")
    private WebElement FindPromoButton;
    @FindBy(xpath = "//input[@name='discountcouponcode']")
    private WebElement InputCoupon;
    @FindBy(xpath = "//button[@class='btn btn-primary apply-discount-coupon-code-button']")
    private WebElement SelectCouponButton;
    @FindBy(xpath = "//a[@href='/cart']")
    private WebElement GotToBasketButton;



    public KamilMarketBasketPage(WebDriver driver){

        super(driver);
    }

    public KamilMarketBasketPage openPage(){
        driver.get(PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(PageLoaded());
        driver.manage().window().maximize();
        return this;
    }


    public KamilMarketBasketPage inputWrongCoupon(String coupon){
        FindPromoButton.click();
        InputCoupon.sendKeys(coupon);
        SelectCouponButton.click();
        return this;
    }

    public Boolean getErrorMessage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(PageLoaded());
        return !(ErrorMessage.isDisplayed());
    }

}
