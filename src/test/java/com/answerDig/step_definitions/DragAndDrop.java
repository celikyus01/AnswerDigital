package com.answerDig.step_definitions;

import com.answerDig.pages.Draggable;
import com.answerDig.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Point;


public class DragAndDrop {

    private Point location1;

    @When("the user drags {string} and drops into the special section")
    public void theUserDragsAndDropsIntoTheSpecialSection(String webElementText) {
        this.location1 = new Draggable().draggable.getLocation();
        BrowserUtils.dragAndDrop(new Draggable().draggable,new Draggable().targetSection);


    }

    @Then("the {string} relocated correctly")
    public void theRelocatedCorrectly(String webElement) {

        Point location2 = new Draggable().draggable.getLocation();

        Assert.assertEquals("(662, 569)",location2.toString());





    }


}
