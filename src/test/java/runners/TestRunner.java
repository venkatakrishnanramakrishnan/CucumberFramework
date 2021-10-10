package runners;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/resources/features",
        glue= {"stepDefinitions"}
)
public class TestRunner {

}
