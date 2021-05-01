package com.answerDig.pages;

import com.answerDig.utilities.Driver;
import org.openqa.selenium.By;

public class AlertPage extends BasePage{

    public void clickMeButton(String text, String clickMe){
        String dynamicLocator = "//span[.='"+text+" ']/../..//button[.='"+clickMe+"']";
        Driver.get().findElement(By.xpath(dynamicLocator)).click();
    }




}
