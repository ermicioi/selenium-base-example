package ermicioi.example.selenium;

import ermicioi.example.selenium.cz.sauto.SeleniumUtil;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

abstract public class AbstractTestCase {

    private static final String PERSONALIZATION_MODAL_QUERY = ".szn-cmp-dialog-container";

    public static WebDriver driver;

    @BeforeAll
    static void tearUp() throws IOException {
        loadApplicationProperties();
        System.out.println(System.getProperty("webdriver.chrome.driver"));
        driver = new ChromeDriver();
    }

    @AfterAll
    static void tearDown() {
//        driver.close();
    }

    private static void loadApplicationProperties() throws IOException {
        try (final var input = new FileInputStream("application.properties")) {
            final Properties prop = new Properties();
            prop.load(input);
            prop.forEach((key, value) -> System.setProperty((String) key, (String) value));
        }
    }

    protected void handlePersonalizationModal() {
        final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(PERSONALIZATION_MODAL_QUERY)));

        SeleniumUtil.hideElement(driver, PERSONALIZATION_MODAL_QUERY);
    }

}
