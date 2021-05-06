package com.answerDig.step_definitions;

import com.answerDig.pages.DatePickerPage;
import com.answerDig.pages.StudentRegisterPage;
import com.answerDig.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateStepDefs {

    DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("MMMM d, yyyy h:mm a");

    String expected_select_date;
    String expected_date_and_time;


    @Then("the user verifies dates are set to {int} mount forward")
    public void theUserVerifiesDatesAreSetToMountForward(int arg0) {

        BrowserUtils.waitFor(2);
        Assert.assertEquals(expected_select_date.toUpperCase(),new DatePickerPage().selectDate.getAttribute("value"));
        Assert.assertEquals(expected_date_and_time.toUpperCase(),new DatePickerPage().dateAndTime.getAttribute("value").toUpperCase());


    }

    @And("the user fills date {string} as {string}")
    public void theUserFillsDateAs(String field, String value) {

        if (value.contains("mounth forward") && field.equalsIgnoreCase("Select Date")) {
            String mounth = value.substring(0, value.indexOf("mounth") - 1);
            int forwardMounth = Integer.parseInt(mounth);
            value = formatter3.format(LocalDateTime.now().plusMonths(forwardMounth));
            this.expected_select_date = value;


        } else if (value.contains("mounth forward") && field.equalsIgnoreCase("Date And Time")) {
            String mounth = value.substring(0, value.indexOf("mounth") - 1);
            int forwardMounth = Integer.parseInt(mounth);
            value = formatter4.format(LocalDateTime.now().plusMonths(forwardMounth));
            this.expected_date_and_time = value;

        }

        new StudentRegisterPage().fillInABlank(field, value);
    }

}
