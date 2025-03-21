package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features",
		glue = {"stepDefinitions.home", "stepDefinitions.search", "stepDefinitions.details", "stepDefinitions.cart","stepDefinitions.registration", "stepDefinitions.login"},
//	    plugin = {"pretty", "html:target/cucumber-reports.html"}
		plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json"}
	)

public class TestRunner extends AbstractTestNGCucumberTests{

}
