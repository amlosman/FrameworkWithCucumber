package runner;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/feature",
        glue = {"stepDef","pages","utilities"},
        plugin = {"pretty", "html:target/cucumber-reports"},
        publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}