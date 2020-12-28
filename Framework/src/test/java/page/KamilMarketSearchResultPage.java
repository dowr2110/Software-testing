package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KamilMarketSearchResultPage extends AbstractPage{

    private final String checkResult="//div[@class='alert alert-warning']";

    public KamilMarketSearchResultPage(WebDriver driver) {
        super(driver);
    }

    public  String  getCheckResultSeacrh(){
        return waitForElementLocatedBy(driver, By.xpath(checkResult), TIME_OUT_SECONDS).getText();
    }

}
