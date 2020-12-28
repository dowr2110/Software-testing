package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KamilMarketItemPage extends Page {

    private final String PAGE_URL = "https://kamilmarket.com";

    @FindBy(xpath = "//input[@class=\"instasearch-term form-control\"]")
    private WebElement SearchInput;
    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-icon instasearch-button\"]")
    private WebElement SearchButton;
    @FindBy(xpath = "//a[@class=\"btn btn-primary btn-lg btn-block btn-add-to-cart ajax-cart-link\"]")
    private WebElement AddToBasketButton;
    @FindBy(xpath = "//input[@class='form-control form-control-lg']")
    private WebElement CountInput;
    @FindBy(xpath = "//input[@class=\"instasearch-term form-control\"]")
    private WebElement ErrorMessage;
    @FindBy(xpath = "//div[@class='art-picture-block']")
    private WebElement SelectButton;

    public KamilMarketItemPage(WebDriver driver) {
        super(driver);
    }

    public KamilMarketItemPage openPage() {
        driver.get(PAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(PageLoaded());
        driver.manage().window().maximize();
        return this;
    }

    public KamilMarketItemPage searchElement(String name) {
        SearchInput.sendKeys(name);
        SearchButton.click();
        SelectButton.click();
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(PageLoaded());
        return this;
    }

    public KamilMarketItemPage selectMoreThanMaxValue(String count) {
        CountInput.clear();
        CountInput.sendKeys(count);
        AddToBasketButton.click();
        return this;
    }

    public KamilMarketItemPage addToBasket() {
        AddToBasketButton.click();
        return this;
    }

    public Boolean getErrorMessage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(PageLoaded());
        return !(ErrorMessage.isDisplayed());
    }


}
