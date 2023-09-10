package step_definitions;

import io.cucumber.java.*;
import org.openqa.selenium.*;
import utility.*;

public class Hooks {

    @Before
    public void setUp(){
        Driver.get().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            // Take a screenshot if the scenario fails
            byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Failed Scenario Screenshot");
        }
        Driver.closeDriver();
    }


}