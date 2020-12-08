package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddToBasket {

    private WebDriver driver;
    private static final int TIME_OUT_SECONDS = 20;
    private static final String PRODUCT_URL="https://kamilmarket.com/acma-bulka";

    public AddToBasket (WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public  AddToBasket openPage(){
        driver.get(PRODUCT_URL);
        driver.manage().window().maximize();
        return  this;
    }

    public AddToBasket addFiveBulka(){
        WebElement searchInput= driver.findElement(By.xpath("//input[@class=\"form-control form-control-lg\"]"));
        searchInput.clear();
        searchInput.sendKeys("5");
        return this;
    }

    public AddToBasket clickToButtonAdd(){
        clickButtonByXpath(By.xpath("//a[@class=\"btn btn-primary btn-lg btn-block btn-add-to-cart ajax-cart-link\"]"));
          return this;
    }

    public String getName() {
        return waitForElementLocatedBy(driver, By.xpath("//a[@class=\"name font-weight-medium\"]"), TIME_OUT_SECONDS).getText();
    }

    public String getCost() {
        return waitForElementLocatedBy(driver, By.xpath("//div[@class=\"sub-total price\"]"), TIME_OUT_SECONDS).getText();
    }

    private void clickButtonByXpath(By by) {
        new WebDriverWait(driver, TIME_OUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(by))
                .click();
    }

    public static WebElement waitForElementLocatedBy(WebDriver driver, By by, long time) {
        return new WebDriverWait(driver, time)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }
}

