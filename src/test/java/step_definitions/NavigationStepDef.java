package step_definitions;

import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;
import pages.*;

import java.util.*;

public class NavigationStepDef {

    public NavigationPage navigationPage = new NavigationPage();

    @Then("user should see below options")
    public void user_should_see_below_options(List<String> menuOptions) throws InterruptedException {
        List<String> actualOptions = new ArrayList<>();
        Thread.sleep(5000);
        for (WebElement option : navigationPage.menuOps) {
            actualOptions.add(option.getText());
        }

        Assert.assertEquals(menuOptions, actualOptions);
    }
}
