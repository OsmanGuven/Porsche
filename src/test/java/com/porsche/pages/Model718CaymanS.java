package com.porsche.pages;

import com.porsche.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Model718CaymanS {

    public Model718CaymanS () { PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//div[@class='ccaPrice'])[5]")
    public WebElement basePriceBox;

    @FindBy(xpath = "(//div[@class='ccaPrice'])[6]")
    public WebElement equipmentPriceBox;

    @FindBy(xpath = "(//div[@class='ccaPrice'])[7]")
    public WebElement deliveryPriceBox;

    @FindBy(xpath = "(//div[@class='ccaPrice'])[8]")
    public WebElement totalPriceBox;

    @FindBy (xpath = "//span[@style='background-color: rgb(0, 120, 138);']")
    public WebElement colorMiami;

    @FindBy(id = "s_exterieur_x_FJ5")
    public WebElement priceBoxMiamiColor;

    @FindBy(xpath = "(//span[@class='img-element'])[11]")
    public WebElement carreraWheel;

    @FindBy(xpath = "(//div[@class='tt_price tt_cell'])[2]")
    public WebElement selectedWheelPrice;

    @FindBy (xpath = "//span[@id='s_interieur_x_PP06']")
    public WebElement powerSSeat;

    @FindBy (xpath = "//div [@id='individual_sHeadline']")
    public WebElement options;

    @FindBy (xpath = "(//div[@class='pBox'])[8]")
    public WebElement pricePowerSeatBox;

    @FindBy (id= "IIC_subHdl")
    public WebElement linkICF;

    @FindBy (id = "IWA_subHdl")
    public WebElement delExperience;

    @FindBy (id = "vs_table_IIC_x_PEKH_x_c01_PEKH")
    public WebElement interiorTrimStandardCheckBox;

    @FindBy (xpath = "(//div[@class='pBox'])[117]")
    public WebElement priceInteriorTrimstandard;

    @FindBy(id = "IMG_subHdl")
    public WebElement linkPerformance;

    @FindBy (xpath = "//span[@id='vs_table_IMG_x_M250_x_c11_M250']")
    public WebElement speed7RadioButton;

    @FindBy (id = "vs_table_IMG_x_M450_x_c81_M450")
    public WebElement PCCB;

    @FindBy (xpath = "(//div[@class='pBox'])[41]")
    public WebElement price7Speed;

    @FindBy (xpath = "(//div[@class='pBox'])[48]/div")
    public WebElement pricePCCB;

}
