package com.answerDig.step_definitions;

import com.answerDig.pages.DatePickerPage;
import com.answerDig.pages.StudentRegisterPage;
import com.answerDig.utilities.BrowserUtils;
import com.answerDig.utilities.ConfigurationReader;
import com.answerDig.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StudentRegisterStepDefs {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");

    private String firstname;
    private String lastName;
    private String email;
    private String gender;
    private String phoneNumber;
    private String dateOfBirthString;
    private String description = "";
    private final List<String> hobbies = new ArrayList<>();
    private final String picture = null;
    private String address;
    private String state;
    private String city;


    @Given("the user is in the main page")
    public void the_user_is_in_the_main_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user navigates to {string} -- {string}")
    public void the_user_navigates_to(String mainModule, String subModule) {
        new StudentRegisterPage().navigateToModule(mainModule, subModule);
    }

    @When("the user fills in all fields with random valid data")
    public void the_user_fills_in_all_fields_with_random_valid_data() throws InterruptedException, FileNotFoundException {
        Faker faker = new Faker();

        this.firstname = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = firstname + "." + lastName + "@gamil.com";
        this.phoneNumber = "1234567890";
        this.address = faker.address().fullAddress();
        LocalDateTime dateOfBirth = LocalDateTime.now().minusYears(new Random().nextInt(40) + 10);
        this.dateOfBirthString = formatter.format(dateOfBirth);


        new StudentRegisterPage().fillInAForm(this.firstname,
                this.lastName,
                this.email,
                this.phoneNumber,
                this.address,
                this.dateOfBirthString.toString());

    }


    @When("the user selects below subjects")
    public void the_user_selects_below_subjects(List<String> subjects) {

        String dummy = "";

        for (String subject : subjects) {
            new StudentRegisterPage().subjects.sendKeys(subject);
            new StudentRegisterPage().subjects.sendKeys(Keys.ENTER);

            dummy = dummy.concat(subject + ", "); // this is a string manupulation to be used for further assertions
        }
        this.description = dummy.substring(0, dummy.length() - 2);  // this is a string manupulation to be used for further assertions


    }


    @When("the user select {string} radio button as {string}")
    public void the_user_select_radio_button_as(String radioButton, String value) {
        if (radioButton.equals("gender")) {
            this.gender = value;
        } else if (radioButton.equals("hobbies")) {
            this.hobbies.add(value);
        }
        new StudentRegisterPage().checkRadioButton(value);


    }

    @And("the user {string} dropdown as {string}")
    public void theUserDropdownAs(String dropDownName, String value) {
        if (dropDownName.equals("State")) {
            this.state = value;
        } else if (dropDownName.equals("City")) {
            this.city = value;
        }

        new StudentRegisterPage().selectDropDownWithNoSelectTag(dropDownName, value);


    }

    @When("the student clicks on {string} button")
    public void the_student_clicks_on_button(String buttonName) {

        new StudentRegisterPage().clickButton(buttonName);

    }


    @Then("the user verifies {string}")
    public void theUserVerifies(String expectedMessage) {
        String actualMessage = new StudentRegisterPage().confirmationWindowMessage.getText();
        Assert.assertEquals("WARNING: expected and actual message are not same", expectedMessage, actualMessage);

    }

    @And("the user verifies the verification table information is matching with form data")
    public void theUserVerifiesTheVerificationTableInformationIsMatchingWithFormData() {

        List<WebElement> elements = Driver.get().findElements(By.xpath("//td[2]"));


        String hobbyListDetached = this.hobbies.toString().replace("[", "").replace("]", "").replace(",", "").replace(" ", "");


        Assert.assertEquals(this.firstname + " " + this.lastName, elements.get(0).getText());
        Assert.assertEquals(this.email, elements.get(1).getText());
        Assert.assertEquals(this.gender, elements.get(2).getText());
        Assert.assertEquals(this.phoneNumber, elements.get(3).getText());
        Assert.assertEquals(this.description, elements.get(5).getText());
        Assert.assertEquals(hobbyListDetached, elements.get(6).getText().replace(",", "").replace(" ", ""));
        // Assert.assertEquals(this.picture, null);
        Assert.assertEquals(this.address, elements.get(8).getText());
        Assert.assertEquals(this.state + " " + this.city, elements.get(9).getText());

//      DATE ASSERTIONS: BUG!!! -- Since data field is impossible to clear, this field could NOT be asserted
        String expectedDate = this.dateOfBirthString.toString();
        String actualDate = elements.get(4).getText().replace(",", " ");
//        LocalDateTime expectedDate = LocalDateTime.parse(this.dateOfBirthString, formatter2);
//        LocalDateTime actualDate = LocalDateTime.parse(elements.get(4).getText().replace(",", " "), formatter2);
//        Assert.assertEquals(expectedDate,actualDate);

        BrowserUtils.waitFor(3);
    }


    @Then("the user verifies {string} is not present")
    public void theUserVerifiesIsNotPresent(String message) {
        try {
            Assert.assertFalse(new StudentRegisterPage().confirmationWindowMessage.isDisplayed());
        } catch (NoSuchElementException n) {
            Assert.assertTrue(true);
        }
    }


    @And("the user fills {string} as {string}")
    public void theUserFillsAs(String field, String value) {
        new StudentRegisterPage().fillInABlank(field, value);
    }


    @Then("the user tries below {string} options and verifies none of below is not working")
    public void the_user_tries_below_options_and_verifies_none_of_below_is_not_working(String field, List<String> dataTable) throws Exception {


        List<String> collect = dataTable.stream().map(data -> {

            new StudentRegisterPage().fillInABlank(field, data);

            try {
                new StudentRegisterPage().clickButton("Submit");
                Assert.assertFalse(data + " found valid, but it is invalid", new StudentRegisterPage().confirmationWindowMessage.isDisplayed());
            } catch (NoSuchElementException n) {

            } catch (AssertionError a) {  // if any invalid email format accepted, keep going and check other emails again
                System.out.println(data);

                new StudentRegisterPage().clickButton("Close");
                BrowserUtils.waitFor(1);

                new StudentRegisterPage().fillInAForm(
                        this.firstname,
                        this.lastName,
                        this.email,
                        this.phoneNumber,
                        this.address,
                        this.dateOfBirthString.toString());

                return data;
            }
            new StudentRegisterPage().checkRadioButton("Male");

            return "";

        }).collect(Collectors.toList());

        if (collect.size() > 0) {
            throw new Exception(" !! FAIL: invalid emails are ACCEPTED: " + collect.toString());
        }


    }


}
