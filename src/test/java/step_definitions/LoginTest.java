package step_definitions;

import io.cucumber.java.en.*;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;
import pages.*;
import utility.*;

import javax.swing.*;
import javax.swing.Action;

public class LoginTest {

    public LoginPage loginPage = new LoginPage();

    @Test
    public void test(){
        Actions actions = new Actions(Driver.get());



    }

    @Given("user go to the login page")
    public void user_go_to_the_login_page() {
        Driver.get().get(ConfigurationReader.get("login_url"));
    }

    @When("user enter correct credentials")
    public void user_enter_correct_credentials() {
        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");

        loginPage.usernameBox.sendKeys(username);
        loginPage.passwordBox.sendKeys(password);
        loginPage.loginBtn.click();
    }

    @When("user enters wrong credentials")
    public void user_enters_wrong_credentials() {
        loginPage.usernameBox.sendKeys("Asd");
        loginPage.passwordBox.sendKeys("asd");
        loginPage.loginBtn.click();

    }
    @Then("user should be in {string}")
    public void user_should_be_in(String string) {
        Assert.assertEquals(loginPage.title.getText(),string);
    }

    @Then("user should be at {string}")
    public void user_should_be_at(String string) {
        Assert.assertEquals(loginPage.title.getText(),string);
    }
}
