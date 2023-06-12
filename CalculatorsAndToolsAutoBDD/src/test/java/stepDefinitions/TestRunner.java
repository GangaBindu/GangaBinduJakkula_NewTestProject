package stepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

		@RunWith(Cucumber.class)
		@CucumberOptions(
		features={"src/test/resources/features/borrowingCalculator.feature"},
		glue= {"stepDefinitions"},
		plugin = {"pretty","html:target/cucumber-reports.html","json:target/Json_Output/cucumber-reports.json"},
		monochrome= true,
		dryRun= false
		)
public class TestRunner {

}
