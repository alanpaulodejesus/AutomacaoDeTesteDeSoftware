package BDDexecute;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = {"src/test/java/BDDfeaturesCenarioEmailTest"},
        glue = {"Test"},
        plugin = {"pretty" }
)
public class ExecuteCenarios {
}
