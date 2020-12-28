package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KamilMarketProductPage extends AbstractPage{

    @FindBy(xpath = "//input[@class=\"instasearch-term form-control\"]")
    private WebElement searchInput;
    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-icon instasearch-button\"]")
    private WebElement searchButton;
    @FindBy(xpath = "//a[@class=\"btn btn-primary btn-lg btn-block btn-add-to-cart ajax-cart-link\"]")
    private WebElement addToBasketButton;
    @FindBy(xpath = "//input[@class='form-control form-control-lg']")
    private WebElement countInput;
    @FindBy(xpath = "//input[@class=\"instasearch-term form-control\"]")
    private WebElement errorMessage;
    @FindBy(xpath = "//div[@class='art-picture-block']")
    private WebElement selectButton;
    @FindBy(xpath = "//a[@class=\"btn btn-success btn-flat btn-flat-light btn-block btn-action\"]")
    private WebElement goToBasket;
    @FindBy(xpath = "//a[@class='menubar-link']")
    private WebElement changeLanguageButton;
    @FindBy(xpath = "//a[@title=\"English (United Kingdom)\"]")
    private WebElement toEnglishButton;
    private final String checkErrorMessage="//div[@class='ui-pnotify-text']";

    private final String PAGE_URL = "https://kamilmarket.com/acma-bulka";
    public KamilMarketProductPage (WebDriver driver){
        super(driver);
    }

    public KamilMarketProductPage openPage() {
        driver.get(PAGE_URL);
        changeLanguageButton.click();
        toEnglishButton.click();
        return this;
    }

    public KamilMarketProductPage addToBasket(){
        addToBasketButton.click();
        return this;
    }

    public KamilMarketBasketPage openBasket(){
        clickButtonByXpath(By.xpath("//a[@class=\"btn btn-success btn-flat btn-flat-light btn-block btn-action\"]"));
        return new KamilMarketBasketPage(driver);
    }

    public String getErrorMessageInProductPage() {
        return waitForElementLocatedBy(driver, By.xpath(checkErrorMessage), TIME_OUT_SECONDS).getText();
    }

    public KamilMarketProductPage selectMoreThanMaxValue(String count) {
        countInput.clear();
        countInput.sendKeys(count);
        return this;
    }
}
