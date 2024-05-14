package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"utility","StepDefinition"},
        plugin = {"pretty", "html:target/cucumber-html-reports","json:cucumber.json"}
)
public class TestRunner {

}