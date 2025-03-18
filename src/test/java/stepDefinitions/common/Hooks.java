package stepDefinitions.common;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;
import pages.BasePage;

public class Hooks {

    @BeforeAll
    public static void setUp() {
        // Initialize the browser only once before all scenarios
        if (BasePage.getDriver() == null) {
            BasePage.initializeBrowser("chrome");  // Change browser if needed
        }
    }

    @AfterAll
    public static void tearDown() {
        // Close the browser only once after all scenarios are executed
        BasePage.tearDown();
    }
}
