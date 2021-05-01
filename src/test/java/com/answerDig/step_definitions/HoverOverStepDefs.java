package com.answerDig.step_definitions;

import com.answerDig.pages.ToolTipsPage;
import com.answerDig.utilities.BrowserUtils;
import com.answerDig.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HoverOverStepDefs extends Thread {


    private String message;

    @When("the student hover over on {string} button")
    public void the_student_hover_over_on_button(String webElement) {

       // Execution is left to next step due to Thread usage -- line-29/ 33

    }

    @Then("the user verifies {string} message")
    public void the_user_verifies_message(String message) {
        this.message = message;
        if (message.contains("button")) {
            BrowserUtils.hoverOverWithJS(new ToolTipsPage().button); //to keep message displayed, I created another thread and get attribute with that one
            new HoverOverStepDefs().start();

        } else if (message.contains("text")) {
            BrowserUtils.hoverOverWithJS(new ToolTipsPage().inputBox); //to keep message displayed, I created another thread and get attribute with that one
            new HoverOverStepDefs().start();
        }
    }

    public void run() {

        if (message.contains("button")) {
            String actualMessage = Driver.get().findElement(By.xpath("(//button)[2]")).getAttribute("aria-describedby");
            Assert.assertEquals("buttonToolTip", actualMessage);

        } else if (message.contains("text")) {
            String actualMessage = Driver.get().findElement(By.xpath("(//input")).getAttribute("aria-describedby");
            Assert.assertEquals("textFieldToolTip", actualMessage);
        }

    }

    @When("the student hover over on {string} input box")
    public void the_student_hover_over_on_input_box(String webElement) {
        BrowserUtils.hoverOverWithJS(new ToolTipsPage().inputBox);
    }



}
