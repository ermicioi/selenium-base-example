package ermicioi.example.selenium.cz.sauto;

import ermicioi.example.selenium.AbstractTestCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SuvAutoTransmissionSearchTestCase extends AbstractTestCase {

    @Test
    @DisplayName("should search for SUVs with auto transmission")
    void testHomePageFordSelection() {
        driver.get("https://sauto.cz");
        this.handlePersonalizationModal();

        final WebElement brandRoot = driver.findElement(By.cssSelector("#cf-opener-manufacturer_cb"));
        brandRoot.findElement(By.cssSelector("label.sds-radiocheck[value='24']")).click();
        brandRoot.findElement(By.cssSelector("label.sds-radiocheck[value='78']")).click();
    }

}
