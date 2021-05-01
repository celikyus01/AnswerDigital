package com.answerDig.step_definitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;

public class DateStepDefs {

    @Then("the user verifies dates are set to {int} mount forward")
    public void theUserVerifiesDatesAreSetToMountForward(int arg0) {

        String actual_date_and_time = new StudentRegisterStepDefs().getActual_date_and_time();
        String expected_date_and_time = new StudentRegisterStepDefs().getExpected_date_and_time();

        String actual_select_date = new StudentRegisterStepDefs().getActual_select_date();
        String expected_select_date = new StudentRegisterStepDefs().getExpected_select_date();


        Assert.assertEquals(expected_select_date.toUpperCase(),actual_select_date.toUpperCase());
        Assert.assertEquals(expected_date_and_time.toUpperCase(),actual_date_and_time.toUpperCase());


    }

}
