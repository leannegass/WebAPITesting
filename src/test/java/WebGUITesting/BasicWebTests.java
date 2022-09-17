package WebGUITesting;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicWebTests {
    @Test
    void checkThatTheWebDriverWorks(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bbc.co.uk");
        Assertions.assertEquals("BBC - Homepage", driver.getTitle());
    }
    @Test
    @DisplayName("check")
}
