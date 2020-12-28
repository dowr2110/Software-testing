package page;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KamilMarketLoginPage extends AbstractPage{
    private final String PAGE_URL = "https://kamilmarket.com/login?ReturnUrl=%2F";

    public KamilMarketLoginPage(WebDriver driver) {
        super(driver);
    }

    public KamilMarketLoginPage openPage() {
        driver.get(PAGE_URL);
        new WebDriverWait(driver, TIME_OUT_SECONDS)
                .until(PageLoaded());
        return this;
    }

    public KamilMarketHomePage login(User user) {
        sendKeysByXpath(By.xpath("//input[@class='username form-control']"), user.getFirstName());
        sendKeysByXpath(By.xpath("//input[@class='password form-control']"), user.getPassword());
        clickButtonByXpath(By.xpath("//button[@class='btn btn-primary btn-lg btn-block btn-login']"));

        new WebDriverWait(driver, TIME_OUT_SECONDS)
                .until(PageLoaded());

        return new KamilMarketHomePage(driver);
    }
}
