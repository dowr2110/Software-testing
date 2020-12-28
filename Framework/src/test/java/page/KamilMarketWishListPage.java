package page;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KamilMarketWishListPage extends AbstractPage {
    private final String PAGE_URL = "https://kamilmarket.com/wishlist";

    @FindBy(xpath = "//a[@class='btn btn-secondary email-a-friend-wishlist-button']")
    private WebElement toSendEmailButton;

    public KamilMarketWishListPage(WebDriver driver) {
        super(driver);
    }

    public KamilMarketWishListPage openPage() {
        driver.get(PAGE_URL);
        new WebDriverWait(driver, TIME_OUT_SECONDS)
                .until(PageLoaded());
        return this;
    }

    public KamilMarketSendEmailPage sendToFriend() {
        toSendEmailButton.click();
        new WebDriverWait(driver, TIME_OUT_SECONDS)
                .until(PageLoaded());
        return new KamilMarketSendEmailPage(driver);
    }


}
