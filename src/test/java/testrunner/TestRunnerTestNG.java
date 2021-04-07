package testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features/LoginFeature.feature", glue = "step_definitions")
public class TestRunnerTestNG extends AbstractTestNGCucumberTests {

}
