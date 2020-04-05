package Features;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Features/",glue = "stepDefinitions",plugin = { "pretty","json:target/stepdefinition.json" })
public class runCucumberTest { }