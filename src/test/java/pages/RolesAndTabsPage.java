package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import utility.*;

public class RolesAndTabsPage {

    public RolesAndTabsPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    public WebElement getTab(String tabName){
        return Driver.get().findElement(By.xpath("//span[contains(text(),\"" + tabName + "\")]"));
    }

    public WebElement getModule(String moduleName){
        return Driver.get().findElement(By.xpath("//span[text()=\"" + moduleName + "\"]"));
    }
}