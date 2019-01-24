package com.porsche.pages;

import com.porsche.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Model718 {
    public Model718() { PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='m-14-model-price'])[2]")
    public WebElement priceBoxCaymanS;

    @FindBy(xpath = "//img[@alt='Porsche 718 Cayman S']")
    public WebElement link718CaymanS;
}
