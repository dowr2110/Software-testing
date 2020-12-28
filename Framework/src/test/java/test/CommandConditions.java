package test;

import driver.DriverSingleton;
import org.testng.annotations.*;
import util.TestListener;
import org.openqa.selenium.WebDriver;

@Listeners({TestListener.class})
class CommonConditions {

    protected WebDriver driver;

    @BeforeTest()
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterTest(alwaysRun = true)
    public void stopBrowser(){
        DriverSingleton.closeDriver();
    }
}