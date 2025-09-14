package ui;

import core.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public abstract class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp(){ driver = DriverFactory.get(); }

    @AfterMethod
    public void tearDown(){ DriverFactory.quit(); }
}
