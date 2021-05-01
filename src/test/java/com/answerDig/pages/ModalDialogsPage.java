package com.answerDig.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ModalDialogsPage extends BasePage{


    @FindBy(css = ".modal-body")
    public WebElement textOfPopUp;

    @FindBy(css = ".modal-title.h4")
    public WebElement titleOfPopUp;



}
