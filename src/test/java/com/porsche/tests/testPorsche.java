package com.porsche.tests;

import com.porsche.pages.Model718;
import com.porsche.pages.Model718CaymanS;
import com.porsche.pages.StartPage;
import com.porsche.utilities.Driver;
import com.porsche.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static com.porsche.utilities.BrowserUtilities.open;
import static com.porsche.utilities.BrowserUtilities.priceStringToInt;

public class testPorsche extends TestBase {
    StartPage start = new StartPage();
    Model718 m718 = new Model718();
    Model718CaymanS m718CS = new Model718CaymanS();


    @Test
    public void test1() {
        open();
        start.link718.click();
//       step 4  price of Cayman S 718
        String basePriceCaymanS = m718.priceBoxCaymanS.getText();
//        System.out.println(basePriceCaymanS);
//        we have to get rid of $ and * and text
        basePriceCaymanS = basePriceCaymanS.substring(basePriceCaymanS.indexOf('$')+2,basePriceCaymanS.indexOf("*")).trim().replace(".","");
        String priceBase = basePriceCaymanS.substring(0,basePriceCaymanS.length()-2);
//        System.out.println(priceBase);
//        Click on 718 Cayman S
        m718.link718CaymanS.click();
//        Verify that Base price displayed on the page is same as the price from step 4
        Object[] windows = Driver.getDriver().getWindowHandles().toArray();
        String windowsID1= windows [0].toString();// main window
        String windowsID2= windows [1].toString();// pop up window
//        since there is a new window opened
        Driver.getDriver().switchTo().window(windowsID2);
        String basePriceCaymanS2 = m718CS.basePriceBox.getText().substring(1); // $ sign removed
//        System.out.println(basePriceCaymanS);
        softAssert.assertTrue(priceBase.equals(basePriceCaymanS2),"prices are not same");
//        7. Verify that Price for Equipment is 0
        String actualEqPrice = m718CS.equipmentPriceBox.getText().substring(1);
        String expectedEqPrice = "0";
        softAssert.assertTrue(actualEqPrice.equals(expectedEqPrice),"equipment price is wrong");
//        8. Verify that total price is the sum of base price + Delivery, Processing and Handling Fee
        int deliveryPrice = priceStringToInt(m718CS.deliveryPriceBox);
//        int deliveryPrice = Integer.valueOf(m718CS.deliveryPriceBox.getText().substring(1).replace(",",""));
//        int equipmentPrice = Integer.valueOf(actualEqPrice);
        int equipmentPrice =priceStringToInt(m718CS.equipmentPriceBox);
//        int actualBasePrice = Integer.valueOf(basePriceCaymanS2.replace(",",""));
        int actualBasePrice =priceStringToInt(m718CS.basePriceBox);
        int totalPrice = priceStringToInt(m718CS.totalPriceBox);
        softAssert.assertTrue(totalPrice==actualBasePrice+equipmentPrice+deliveryPrice,"total price is wrong");
        System.out.println(totalPrice);
//        9. Select color “Miami Blue”
        m718CS.colorMiami.click();
//      10. verify that  price for equipment for Miami Blue" is equal to "price for equipment for standard color"
//        the value will change from 0 to 2580  be careful
        wait.until(ExpectedConditions.textToBe(By.xpath("(//div[@class='ccaPrice'])[6]"),"$2,580"));
//        int equipmentPriceMiami = Integer.valueOf(m718CS.equipmentPriceBox.getText().substring(1).replace(",",""));
        int equipmentPriceMiami =priceStringToInt(m718CS.equipmentPriceBox); // price on the web table
        System.out.println(equipmentPriceMiami);
        System.out.println(m718CS.priceBoxMiamiColor.getAttribute("data-price").replace(",","").substring(1));
        softAssert.assertTrue(Integer.valueOf(m718CS.priceBoxMiamiColor.getAttribute("data-price").replace(",","").substring(1))==equipmentPriceMiami,"equipment price of Miami Blue is not same as standard colors");
//        11.Verify that total price is the sum of base price + Price for Equipment + Delivery,Processing and Handling Fee
        int deliveryPriceMiami = priceStringToInt(m718CS.deliveryPriceBox);
        int actualBasePriceMiami =priceStringToInt(m718CS.basePriceBox);
        int totalPriceMiami = priceStringToInt(m718CS.totalPriceBox);
        softAssert.assertTrue(totalPriceMiami==actualBasePriceMiami+equipmentPriceMiami+deliveryPriceMiami,"total price of Miami is wrong");
        System.out.println(totalPriceMiami);
//        12.Select 20" Carrera Sport Wheels
        m718CS.carreraWheel.click();
//        price of wheels
        System.out.println(priceStringToInt(m718CS.selectedWheelPrice));
//        13.Verify that Price for Equipment is the sum of Miami Blue price + 20" Carrera Sport Wheels
        int equipmentPriceMiamiWithCarrera =priceStringToInt(m718CS.equipmentPriceBox);
        int priceOfCarreraWheels = priceStringToInt(m718CS.selectedWheelPrice);
        softAssert.assertTrue(equipmentPriceMiamiWithCarrera==equipmentPriceMiami+priceOfCarreraWheels);
//        14.Verify that total price is the sum of base price + Price for Equipment + Delivery, Processing and Handling Fee
        int deliveryPriceMiamiCar = priceStringToInt(m718CS.deliveryPriceBox);
        int actualBasePriceMiamiCar =priceStringToInt(m718CS.basePriceBox);
        int totalPriceMiamiCar = priceStringToInt(m718CS.totalPriceBox);
        int equipmentPriceMiamiCar = priceStringToInt(m718CS.equipmentPriceBox);
        softAssert.assertTrue(totalPriceMiamiCar==deliveryPriceMiamiCar+actualBasePriceMiamiCar+equipmentPriceMiamiCar);
//        15.Select seats ‘Power Sport Seats (14 way) with Memory Package’
//        scroll down on the page
        actions.moveToElement(m718CS.options).perform();
        wait.until(ExpectedConditions.elementToBeClickable(m718CS.powerSSeat));
        m718CS.powerSSeat.click();
//        16.Verify that Price for Equipment is the sum of Miami Blue price + 20" Carrera Sport Wheels+ Power Sport Seats (14way) with Memory Package
        int pricePowerSeat =priceStringToInt(m718CS.pricePowerSeatBox);
        System.out.println(pricePowerSeat);
        int equipmentPriceMiamiCarPSeat = priceStringToInt(m718CS.equipmentPriceBox); // equipment price with wheels+power seats
        System.out.println(equipmentPriceMiamiCar+pricePowerSeat); // price of Miami Blue price + 20" Carrera Sport Wheels+ Power Sport Seats (14way) with Memory Package
        softAssert.assertTrue( equipmentPriceMiamiCarPSeat==equipmentPriceMiamiCar+pricePowerSeat);
//        17.Verify that total price is the sum of base price + Price for Equipment + Delivery, Processing and Handling Fee
        int deliveryPriceMiamiCarPS = priceStringToInt(m718CS.deliveryPriceBox);
        int actualBasePriceMiamiCarPS =priceStringToInt(m718CS.basePriceBox);
        int totalPriceMiamiCarPS = priceStringToInt(m718CS.totalPriceBox);
        softAssert.assertTrue(totalPriceMiamiCarPS==deliveryPriceMiamiCarPS+actualBasePriceMiamiCarPS+equipmentPriceMiamiCarPSeat);
//        18.Click on Interior Carbon Fiber
        actions.moveToElement(m718CS.delExperience).perform();
        m718CS.linkICF.click();
//        19.Select Interior Trim in Carbon Fiber i.c.w. Standard Interio
        m718CS.interiorTrimStandardCheckBox.click();
//        20.Verify that Price for Equipment is the sum of Miami Blue price + 20Carrera SportWheels+ Power Sport Seats (14way) with Memory Package + Interior Trim inCarbon Fiber i.c.w.Standard Interior
        int priceIntTrStandard = priceStringToInt(m718CS.priceInteriorTrimstandard);
        int equipmentPriceMiamiCarPSeatInterior = priceStringToInt(m718CS.equipmentPriceBox); // equipment price with wheels+power seats+interiorTrim
        System.out.println(equipmentPriceMiami+priceOfCarreraWheels+pricePowerSeat+priceIntTrStandard);
        System.out.println(equipmentPriceMiamiCarPSeatInterior);

        softAssert.assertTrue(equipmentPriceMiamiCarPSeatInterior==equipmentPriceMiami+priceOfCarreraWheels+pricePowerSeat+priceIntTrStandard);
//       21.  Verify that total price is the sum of base price + Price for Equipment + Delivery, Processing and Handling Fee
        int deliveryPriceMiamiCarPSInt = priceStringToInt(m718CS.deliveryPriceBox);
        int actualBasePriceMiamiCarPSInt =priceStringToInt(m718CS.basePriceBox);
        int totalPriceMiamiCarPSInt = priceStringToInt(m718CS.totalPriceBox);

        softAssert.assertTrue(totalPriceMiamiCarPSInt==deliveryPriceMiamiCarPSInt+actualBasePriceMiamiCarPSInt+equipmentPriceMiamiCarPSeatInterior);
//        22.Click on Performance
        m718CS.linkPerformance.click();
//        23.Select 7 speed Porsche Doppelkupplung (PDK)
        m718CS.speed7RadioButton.click();
//        24.Select Porsche Ceramic Composite Brakes (PCCB
        m718CS.PCCB.click();
//        25. Verify that Price for Equipment is the sum of Miami Blue price + 20" Carrera SportWheels+ Power Sport Seats
//        (14way) with Memory Package +Interior Trim in Carbon Fiber i.c.w.Standard Interior + 7speed Porsche Doppelkupplung (PDK) + Porsche Ceramic Composite Brakes (PCCB)
        int priceOf7Speed = priceStringToInt(m718CS.price7Speed);
        int priceOfPCCB = priceStringToInt(m718CS.pricePCCB);
        int equipmentPriceMiamiCarPSeatInterior7SpeedPCCB = priceStringToInt(m718CS.equipmentPriceBox); // equipment price with wheels+power seats+interiorTrim++ 7speed Porsche Doppelkupplung (PDK) + Porsche Ceramic Composite Brakes (PCCB)
        softAssert.assertTrue(equipmentPriceMiamiCarPSeatInterior7SpeedPCCB==equipmentPriceMiami+priceOfCarreraWheels+pricePowerSeat+priceIntTrStandard+priceOf7Speed+priceOfPCCB);
//        26.Verify that total price is the sum of base price + Price for Equipment + Delivery, Processing and Handling Fee
        int deliveryFinal = priceStringToInt(m718CS.deliveryPriceBox);
        int actualBasePriceFinal =priceStringToInt(m718CS.basePriceBox);
        int totalPriceFinal = priceStringToInt(m718CS.totalPriceBox);
        int equipmentPriceFinal = priceStringToInt(m718CS.equipmentPriceBox);

        softAssert.assertTrue(totalPriceFinal==deliveryFinal+actualBasePriceFinal+equipmentPriceFinal);
















    }
}
