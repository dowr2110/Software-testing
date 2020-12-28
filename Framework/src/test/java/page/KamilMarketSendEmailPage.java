package page;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KamilMarketSendEmailPage extends AbstractPage {

    private final String PAGE_URL = "https://kamilmarket.com/ShoppingCart/EmailWishlist";


    private final String checkMessageLabel="//div[@class='result']";

    public KamilMarketSendEmailPage(WebDriver driver) {
        super(driver);
    }

    public KamilMarketSendEmailPage openPage() {
        driver.get(PAGE_URL);
        new WebDriverWait(driver, TIME_OUT_SECONDS)
                .until(PageLoaded());
        return this;
    }

    public KamilMarketSendEmailPage send(User user) {
        sendKeysByXpath(By.xpath("//input[@class='friend-email form-control']"), user.getEmail());
        clickButtonByXpath(By.xpath("//button[@class='btn btn-primary send-email-a-friend-button']"));

        new WebDriverWait(driver, TIME_OUT_SECONDS)
                .until(PageLoaded());
        return this;
    }

    public String getMessageInSendEmailPage(){
        return waitForElementLocatedBy(driver, By.xpath(checkMessageLabel), TIME_OUT_SECONDS).getText();
    }



}
