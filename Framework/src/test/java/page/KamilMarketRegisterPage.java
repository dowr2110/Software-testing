package page;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KamilMarketRegisterPage extends AbstractPage {

    private final String PAGE_URL = "https://kamilmarket.com/register?returnurl=%2fcart";

    private final String checkErrorMessageLabel="//span[@id='Email-error']";
    private final String checkErrorMessageLabel2="//span[@id='Password-error']";
    public KamilMarketRegisterPage(WebDriver driver) {
        super(driver);
    }

    public KamilMarketRegisterPage openPage() {
        driver.get(PAGE_URL);
        new WebDriverWait(driver, TIME_OUT_SECONDS)
                .until(PageLoaded());
        return this;
    }

    public KamilMarketRegisterPage register(User user) {
        sendKeysByXpath(By.xpath("//input[@id='FirstName']"), user.getFirstName());
        sendKeysByXpath(By.xpath("//input[@id='LastName']"), user.getLastName());
        sendKeysByXpath(By.xpath("//input[@id='Email']"), user.getEmail());
        sendKeysByXpath(By.xpath("//input[@id='Password']"), user.getPassword());
        sendKeysByXpath(By.xpath("//input[@id='ConfirmPassword']"), user.getPassword());
        sendKeysByXpath(By.xpath("//input[@id='Phone']"), user.getPhone());
        clickButtonByXpath(By.xpath("//button[@class='btn btn-primary btn-lg']"));

        new WebDriverWait(driver, TIME_OUT_SECONDS)
                .until(PageLoaded());

        return new KamilMarketRegisterPage(driver);
    }

    public String getErrorMessageInSendEmailPage(){
        return waitForElementLocatedBy(driver, By.xpath(checkErrorMessageLabel), TIME_OUT_SECONDS).getText();
    }

    public String getError2MessageInSendEmailPage(){
        return waitForElementLocatedBy(driver, By.xpath(checkErrorMessageLabel2), TIME_OUT_SECONDS).getText();
    }

}
