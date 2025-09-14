package ui;

import ui.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import services.NavigationService;
import pages.InstructorsPage;

public class NavigationTest extends BaseTest {

    @Test
    public void should_count_instructor_cards() {
        int count = new NavigationService(driver).openHomeAndCountInstructors();
        System.out.println("Instructor cards = " + count);
        Assert.assertTrue(count > 0, "Instructor list is empty!");


    }
    @Test
    public void instructorsCount() {
        int count = new NavigationService(driver).openHomeAndCountInstructors();
        System.out.println("Instructor cards = " + count);
        Assert.assertTrue(count == 8, "Instructor list value is 8!");
    }

}
