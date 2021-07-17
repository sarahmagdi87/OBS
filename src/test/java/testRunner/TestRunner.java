package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features/",
		glue="stepDefinations",
		plugin = {"pretty", "html:target/cucumber-reports" , "json:target/cucumber-reports/Cucumber.json"},
	    monochrome=true   
)

public class TestRunner extends AbstractTestNGCucumberTests{
}