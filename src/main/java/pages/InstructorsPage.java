package pages;

import core.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class InstructorsPage extends BasePage {

    // Container ve item'ları net tanımlayalım
    private static final By CONTAINER = By.cssSelector("#__next > div.wrapper > div > div.container");
    private static final By ITEM      = By.cssSelector("#__next > div.wrapper > div > div.container > div > div:nth-child(1)");

    public InstructorsPage(WebDriver driver){ super(driver); }

    /** /instructors yüklenir ve konteyner içinde en az 1 kart görünür. */
    public InstructorsPage awaitLoaded() {
        waitUrlContains("/instructors"); // /tr/instructors'ı da kapsar
        wait.until(ExpectedConditions.presenceOfElementLocated(CONTAINER));
        wait.until(d -> d.findElement(CONTAINER).findElements(ITEM).size() > 0);
        return this;
    }

    /** Konteyner içindeki kart sayısı */
    public int countInstructors() {
        WebElement root = driver.findElement(CONTAINER);
        return root.findElements(ITEM).size();
    }

    /** (İstersen) JS ile sayım – bazen daha stabil olur */
    public int countInstructorsJs() {
        Long n = (Long)((JavascriptExecutor)driver)
                .executeScript("return document.querySelectorAll('.instructors .instructor-item').length;");
        return n.intValue();
    }

    private static final By TITLE = By.cssSelector(
            "#__next > div.wrapper > div > div.container > div > div:nth-child(1) > div.instructor-item-title");

    // İlk eğitmenin adı
    public String firstInstructorName() {
        WebElement root = driver.findElement(CONTAINER);
        WebElement first = root.findElements(ITEM).get(0);
        return first.findElement(TITLE).getText().trim();
    }

    // Tüm eğitmen adları
    public List<String> instructorNames() {
        WebElement root = driver.findElement(CONTAINER);
        return root.findElements(ITEM).stream()
                .map(card -> card.findElement(TITLE).getText().trim())
                .collect(Collectors.toList());
    }
}
