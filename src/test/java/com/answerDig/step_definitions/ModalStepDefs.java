package com.answerDig.step_definitions;

import com.answerDig.pages.ModalDialogsPage;
import com.answerDig.utilities.BrowserUtils;
import com.answerDig.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModalStepDefs {

    @Then("the user verifies the modal title as {string}")
    public void the_user_verifies_the_modal_title_as(String expectedTitle) {
        new WebDriverWait(Driver.get(),10).until(ExpectedConditions.visibilityOf(new ModalDialogsPage().titleOfPopUp));
        String actualTitle = new ModalDialogsPage().titleOfPopUp.getText();
        Assert.assertEquals(expectedTitle,actualTitle);



    }

    @Then("the user verifies the modal text as {string}")
    public void the_user_verifies_the_modal_text_as(String expectedText) {
        String actualText = new ModalDialogsPage().textOfPopUp.getText();
        Assert.assertEquals(expectedText,actualText);

    }

    @Then("the user verifies the modal window is disappeared")
    public void the_user_verifies_the_modal_window_is_disappeared() {


        try {
            //new WebDriverWait(Driver.get(),10).until(ExpectedConditions.invisibilityOf(new ModalDialogsPage().titleOfPopUp));
            BrowserUtils.waitFor(1);
            Assert.assertFalse("modal window expected to be dissappeared, but found displayed",new ModalDialogsPage().titleOfPopUp.isDisplayed());
        }catch (NoSuchElementException n){

        }


    }
}
