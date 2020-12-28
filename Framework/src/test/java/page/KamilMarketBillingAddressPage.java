package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class KamilMarketBillingAddressPage extends AbstractPage{
    private final String PAGE_URL = "https://kamilmarket.com/Checkout/BillingAddress";

    @FindBy(xpath = "//button[@class='btn btn-warning btn-lg new-address-next-step-button']")
    private WebElement toNextButton;
    private final String checkNameLabel="//span[@id='NewAddress_FirstName-error']";
    private final String checkLastNameLabel="//span[@id='NewAddress_LastName-error']";
    private final String checkAddressLabel="//span[@id='NewAddress_Address1-error']";

    public KamilMarketBillingAddressPage(WebDriver driver) {
        super(driver);
    }

    public KamilMarketBillingAddressPage openPage() {
        driver.get(PAGE_URL);
        // logger.info("Login page opened");
        return this;
    }

    public KamilMarketBillingAddressPage toNext() {
        toNextButton.click();
        return this;
    }

    public String getNameInBillingAddress() {
        return waitForElementLocatedBy(driver, By.xpath(checkNameLabel), TIME_OUT_SECONDS).getText();
    }

    public String getLastNameInBillingAddress() {
        return waitForElementLocatedBy(driver, By.xpath(checkLastNameLabel), TIME_OUT_SECONDS).getText();
    }

    public String getAddressInBillingAddress() {
        return waitForElementLocatedBy(driver, By.xpath(checkAddressLabel), TIME_OUT_SECONDS).getText();
    }



}
