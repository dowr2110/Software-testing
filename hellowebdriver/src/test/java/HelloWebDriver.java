import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class HelloWebDriver {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        driver.get("https://kamilmarket.com/");
        WebElement searchInput= driver.findElement(By.id("instasearch"));
        searchInput.sendKeys("bulka");
        WebElement searchBtn =driver.findElement(By.xpath("//*[@id=\'header\']/div[2]/div/div/div[1]/div[2]/form/button/i"));
        searchBtn.click();
        searchInput= driver.findElement(By.id("instasearch"));
        searchInput.clear();
        searchInput.sendKeys("011941");//Поиск конкретного товара
        searchBtn =driver.findElement(By.xpath("//*[@id=\'header\']/div[2]/div/div/div[1]/div[2]/form/button/i"));
        searchBtn.click();
        Thread.sleep(2000);
        driver.quit();
    }
}
