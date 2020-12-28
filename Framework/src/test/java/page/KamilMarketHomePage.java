package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KamilMarketHomePage extends AbstractPage {
    @FindBy(xpath = "//input[@class=\"instasearch-term form-control\"]")
    private WebElement inputSearch;
    @FindBy(xpath = "//button[@class=\"btn btn-primary btn-icon instasearch-button\"]")
    private WebElement searchButton;
    @FindBy(xpath = "//span[@title=\"Dowr\"]")
    private WebElement nameLabel;
    @FindBy(xpath = "//a[@class='menubar-link']")
    private WebElement changeLanguageButton;
    @FindBy(xpath = "//a[@title=\"English (United Kingdom)\"]")
    private WebElement toEnglishButton;
    private final String checkNameConcreteLabel="//h3[@class='art-name']";
    private final String checkIdConcreteLabel="//small[@class='search-term']";
    private final String checkCostConcreteLabel="//div[@class='art-price-block']";

    private final String PAGE_URL = "https://kamilmarket.com/";

    @FindBy(name = "q")
    private WebElement searchInput;

    public KamilMarketHomePage(WebDriver driver) {
        super(driver);
    }

    public KamilMarketHomePage openPage() {
        driver.get(PAGE_URL);
        changeLanguageButton.click();
        toEnglishButton.click();
       // logger.info("Login page opened");
        return this;
    }

    public KamilMarketHomePage inputTerm(String term) {

        inputSearch.sendKeys(term);
        searchButton.click();
       // logger.info("input term");
        return this;
    }

    public KamilMarketSearchResultPage searchTerm(){
        searchInput.sendKeys(Keys.ENTER);
        //logger.info("search fail term");
        return new KamilMarketSearchResultPage(driver);
    }

    public String getNameInHomePage(){
            return nameLabel.getText();
    }

    public String getIdConcreteInHomePage() {
        return waitForElementLocatedBy(driver, By.xpath(checkIdConcreteLabel), TIME_OUT_SECONDS).getText();
    }
    public String getNameConcreteInHomePage() {
        return waitForElementLocatedBy(driver, By.xpath(checkNameConcreteLabel), TIME_OUT_SECONDS).getText();
    }
    public String getCostConcreteInHomePage() {
        return waitForElementLocatedBy(driver, By.xpath(checkCostConcreteLabel), TIME_OUT_SECONDS).getText();
    }


}
