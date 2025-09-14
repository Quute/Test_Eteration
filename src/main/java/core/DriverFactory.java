package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public final class DriverFactory {
    private static final ThreadLocal<WebDriver> TL = new ThreadLocal<>();
    private DriverFactory(){}

    public static WebDriver get() {
        if (TL.get() == null) {
            WebDriverManager.chromedriver().setup();
            WebDriver d = new ChromeDriver();
            d.manage().window().maximize();
            TL.set(d);
        }
        return TL.get();
    }

    public static void quit() {
        WebDriver d = TL.get();
        if (d != null) { d.quit(); TL.remove(); }
    }
}
