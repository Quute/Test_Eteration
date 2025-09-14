package services;

import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.InstructorsPage;

public class NavigationService {
    private final WebDriver driver;

    public NavigationService(WebDriver driver) {
        this.driver = driver;
    }

    public InstructorsPage openHomeAndGoInstructors() {
        return new HomePage(driver).open().clickInstructors().awaitLoaded();
    }

    public int openHomeAndCountInstructors() {
        return openHomeAndGoInstructors().countInstructorsJs(); // veya .countInstructorsJs()
    }

    public String openHomeAndGetFirstInstructorName() {
        return openHomeAndGoInstructors().firstInstructorName();
    }

    // Tüm adları döndür
    public java.util.List<String> openHomeAndGetInstructorNames() {
        return openHomeAndGoInstructors().instructorNames();
    }
}