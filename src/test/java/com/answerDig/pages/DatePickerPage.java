package com.answerDig.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DatePickerPage extends BasePage{

    @FindBy(css = "#datePickerMonthYearInput")
    public WebElement selectDate;

    @FindBy(css = "#dateAndTimePickerInput")
    public WebElement dateAndTime;




}
