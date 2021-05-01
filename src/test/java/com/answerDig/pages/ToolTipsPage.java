package com.answerDig.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ToolTipsPage extends BasePage {

    @FindBy(xpath = "//input[@placeholder='Hover me to see']")
    public WebElement inputBox;

    @FindBy(xpath = "//button[.='Hover me to see']")
    public WebElement button;









}
