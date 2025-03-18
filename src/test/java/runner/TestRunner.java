package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
//	    features = {"src/test/resources/features/home", "src/test/resources/features/search"},
		features = "src/test/resources/features",
//	    glue = { "stepDefinitions.home", "stepDefinitions.search" },
//		glue = "stepDefinitions.search",
		glue = {"stepDefinitions.common","stepDefinitions.home", "stepDefinitions.search", "stepDefinitions.details", "stepDefinitions.cart","stepDefinitions.registration", "stepDefinitions.login"},
//		glue = {"stepDefinitions.common","stepDefinitions.registration", "stepDefinitions.login"},
//				glue = "stepDefinitions.registration",
	    plugin = {"pretty", "html:target/cucumber-reports.html"}
//	    tags = "@HomePageTest or @SearchTest"
//	    tags = "@SearchTest"
	)

public class TestRunner extends AbstractTestNGCucumberTests{

}
