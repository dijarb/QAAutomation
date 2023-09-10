package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utility.*;

public class VyTrackLoginPage {

    public VyTrackLoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//input[@name='_username']")
    public WebElement usernameBox;

    @FindBy(id = "prependedInput2")
    public WebElement passwordBox;

    @FindBy(id = "_submit")
    public WebElement loginBtn;

    public void login(String username, String password){
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginBtn.click();
    }
}
