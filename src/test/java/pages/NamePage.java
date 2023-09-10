package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;
import utility.*;

import java.time.*;
import java.util.*;

public class NamePage {

    public NamePage(){
        PageFactory.initElements(Driver.get(), this);
    }

    public List<String> name(){
        WebDriverWait wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#user-menu a")));
        String names = Driver.get().findElement(By.cssSelector("#user-menu a")).getText();
        names.trim();
        List<String> nameList = List.of(names.split(" "));
        return nameList;
    }
}