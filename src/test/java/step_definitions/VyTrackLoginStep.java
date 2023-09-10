package step_definitions;

import io.cucumber.java.en.*;
import org.junit.*;
import pages.*;
import utility.*;

import java.awt.dnd.*;

public class VyTrackLoginStep {

    VyTrackLoginPage vylogin = new VyTrackLoginPage();

    @Given("user at login page")
    public void user_at_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @When("user provides {string} information")
    public void user_provides_information(String string) {
        String username = null;
        String password = null;

        switch (string){
            case ("driver"):
                username = ConfigurationReader.get("driver_username");
                password = ConfigurationReader.get("driver_password");
                break;
            case("sales manager"):
                username = ConfigurationReader.get("sales_manager_username");
                password = ConfigurationReader.get("sales_manager_password");
                break;
            case("store manager"):
                username = ConfigurationReader.get("store_manager_username");
                password = ConfigurationReader.get("store_manager_password");
                break;
        }

        vylogin.login(username,password);
    }
    @Then("user should be able to login")
    public void user_should_be_able_to_login() {
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Dashboard",actualTitle);
    }
}
