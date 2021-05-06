package com.answerDig.step_definitions;

import com.answerDig.utilities.BrowserUtils;
import com.answerDig.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

public static Scenario scenario;

    @Before
    public void setUp(){
      // Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       Driver.get().manage().window().maximize();

    }
    @After
    public void tearDown(Scenario scenario) {

        this.scenario= scenario;
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image.png", "screenshot");
        }
        Driver.closeDriver();
    }

    @Before("@db")
    public void OpenDb(){
        System.out.println("\tdatabase from BEFORE");
    }
    @After("@db")
    public void closeDb(){
        System.out.println("\tdatabase from AFTER");
    }


}
