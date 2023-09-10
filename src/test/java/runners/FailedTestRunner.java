package runners;

import io.cucumber.junit.*;
import org.junit.runner.*;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/failed-html-report"},
        features = "@target/rerun.txt",
        glue = "step_definitions"
)
public class FailedTestRunner {
}
