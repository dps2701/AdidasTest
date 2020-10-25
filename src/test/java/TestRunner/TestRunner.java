package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/Adidas.feature",
		glue="stepDefs",
		plugin = {"pretty", "html:target/Destination"},
		monochrome=true,
		strict=true
		)
public class TestRunner {

}
