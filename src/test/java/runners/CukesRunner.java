package runners;

import io.cucumber.junit.*;
import org.junit.runner.*;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports.html",
                "rerun:target/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",},
        features = "src/test/resources/features",
        glue = "step_definitions",
        dryRun = false,
        tags = "@vytrack"
)
public class CukesRunner {
}