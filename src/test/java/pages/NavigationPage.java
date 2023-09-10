package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utility.*;

import java.util.*;

public class NavigationPage {

    public NavigationPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "span.title-level-1")
    public List<WebElement> menuOps;
}
