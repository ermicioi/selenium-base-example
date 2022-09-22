package ermicioi.example.selenium.cz.sauto;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class SeleniumUtil {

    public static void hideElement(final WebDriver driver, final String query) {
        ((JavascriptExecutor) driver)
                .executeScript("document.querySelector('" + query + "').setAttribute('hidden', 'true')");
    }
}
