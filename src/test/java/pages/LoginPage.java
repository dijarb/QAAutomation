package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utility.*;

import java.util.*;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginBtn;

    @FindBy(xpath = "//h2")
    public WebElement title;

}
