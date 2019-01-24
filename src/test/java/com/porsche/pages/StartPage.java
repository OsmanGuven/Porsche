package com.porsche.pages;

import com.porsche.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StartPage {
    public StartPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (linkText = "718")
    public WebElement link718;


}
