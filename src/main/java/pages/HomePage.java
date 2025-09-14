package pages;

import core.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private static final String BASE_URL = "https://academy.eteration.com/";
    private static final By INSTRUCTORS_LINK = By.cssSelector("#nav > ul > li:nth-child(2) > a");

    public HomePage(WebDriver driver){ super(driver); }

    public HomePage open(){ go(BASE_URL); return this; }

    public InstructorsPage clickInstructors(){
        click(INSTRUCTORS_LINK);
        return new InstructorsPage(driver);
    }

    public boolean isAt(){ return driver.getCurrentUrl().startsWith(BASE_URL); }
}
