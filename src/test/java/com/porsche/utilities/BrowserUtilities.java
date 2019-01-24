package com.porsche.utilities;

import org.openqa.selenium.WebElement;

public class BrowserUtilities {


    public static void open() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    public static int priceStringToInt (WebElement element){
        int priceInt = Integer.valueOf( element.getText().substring(1).replace(",",""));
        return priceInt;
    }
}
