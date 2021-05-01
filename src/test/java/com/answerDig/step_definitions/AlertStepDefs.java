package com.answerDig.step_definitions;

import com.answerDig.pages.AlertPage;
import com.answerDig.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertStepDefs {

    @Then("the student clicks on {string} {string} button")
    public void theStudentClicksOnButton(String text, String ClickMeButton) {

        new AlertPage().clickMeButton(text,ClickMeButton);


    }

    @When("the user waits for the alert to be popped up")
    public void the_user_waits_for_the_alert_to_be_popped_up() {
        WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        wait.until(ExpectedConditions.alertIsPresent());


    }

    @When("the user accepts alert")
    public void the_user_accepts_alert() {
        Driver.get().switchTo().alert().accept();
    }

    @Then("the user verifies alert is disappeared")
    public void the_user_verifies_alert_is_disappeared() {
        //verify no alert is present
        try {
            Driver.get().switchTo().alert(); // try to switch an unpresent alert and get error
            Assert.assertTrue("alert is present unexpectedly",false); // to fail the test case, if any alert is present unexpectedly

        }catch (NoAlertPresentException c){ // since this error is expected, this exception is handled

        }

    }




}
