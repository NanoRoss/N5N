package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions( tags = "@Test",
        features = "src/test/resources/features",
        glue = "stepDefinitions",
        monochrome = false,
        plugin = { "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class RunTest {
    
}
