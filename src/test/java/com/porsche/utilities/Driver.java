package com.porsche.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
    private static WebDriver driver ;
    private Driver(){}
    public static WebDriver getDriver(){

        if (driver==null){

            String browser = ConfigurationReader.getProperty("browser");
            switch (browser){
                case "chrome" : WebDriverManager.chromedriver().setup();
                                driver = new ChromeDriver();
                                break;
                case "opera" : WebDriverManager.operadriver();
                    driver = new SafariDriver();
                    break;
                case "firefox" : WebDriverManager.firefoxdriver().setup();
                                driver = new FirefoxDriver();
                                break;
                case "edge" : WebDriverManager.edgedriver().setup();

                             driver = new EdgeDriver();
                             break;
                default:
                    throw new WebDriverException("Browser not found: " + browser);
            }
        }
        return driver;
    }

    public static void closeDriver(){

        if (driver!=null){

            driver.quit();
            driver=null;
        }

    }

}
