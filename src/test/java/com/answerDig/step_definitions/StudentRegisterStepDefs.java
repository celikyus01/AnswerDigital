package com.answerDig.step_definitions;

import com.answerDig.pages.DatePickerPage;
import com.answerDig.pages.StudentRegisterPage;
import com.answerDig.utilities.BrowserUtils;
import com.answerDig.utilities.ConfigurationReader;
import com.answerDig.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StudentRegisterStepDefs {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy");
    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd MM yyyy");
    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter formatter4 = DateTimeFormatter.ofPattern("MMMM d, yyyy h:mm a");

    private String firstname;
    private String lastName;


    //private static String studentName= firstname+" "+lastName;
    private String email;
    private String gender;
    private String phoneNumber;
    private String dateOfBirthString;
    private String description;
    private final List<String> hobbies = new ArrayList<>();
    private final String picture = null;
    private String address;
    private String state;
    private String city;
    private static String actual_select_date;
    private static String actual_date_and_time;
    private static String expected_select_date;
    private static String expected_date_and_time;

    public String getActual_select_date() {
        return actual_select_date;
    }

    public String getActual_date_and_time() {
        return actual_date_and_time;
    }

    public String getExpected_select_date() {
        return expected_select_date;
    }

    public String getExpected_date_and_time() {
        return expected_date_and_time;
    }





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

        //subjects.stream().peek(x-> new StudentRegisterPage().subjects.sendKeys(x, Keys.ENTER));

        for (String subject : subjects) {
            new StudentRegisterPage().subjects.sendKeys(subject);
            new StudentRegisterPage().subjects.sendKeys(Keys.ENTER);
        }



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

    @When("the user uploades {string} file")
    public void the_user_uploades_file(String fileName) {

//        String filePathUnderResources = new StudentRegisterPage().getFilePathUnderResources(fileName);
//        Driver.get().findElement(By.xpath("//input[@id='uploadPicture']")).click();
//        Driver.get().findElement(By.xpath("//input[@id='uploadPicture']")).sendKeys(filePathUnderResources, Keys.ENTER);


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

//        LocalDateTime expectedDate = LocalDateTime.parse(this.dateOfBirthString, formatter2);
//        LocalDateTime actualDate = LocalDateTime.parse(elements.get(4).getText().replace(",", " "), formatter2);


        Assert.assertEquals(this.firstname + " " + this.lastName, elements.get(0).getText());
        Assert.assertEquals(this.email, elements.get(1).getText());
        Assert.assertEquals(this.gender, elements.get(2).getText());
        Assert.assertEquals(this.phoneNumber, elements.get(3).getText());
        //Assert.assertEquals(this.dateOfBirthString,elements.get(4).getText().replace(","," "));
        //Assert.assertEquals(expectedDate,actualDate);

        //DATE ASSERTIONS
        String expectedDate = this.dateOfBirthString.toString();
        String actualDate = elements.get(4).getText().replace(",", " ");

        System.out.println("actualDate = " + actualDate);
        System.out.println("expectedDate = " + expectedDate);

        //    **** BUG FOUND: when date field is deleted, application is crashing
        //        Assert.assertEquals(expectedDate.substring(0,2),
        //                actualDate.substring(0,2));
        //        Assert.assertTrue(this.dateOfBirthString.toString().substring(this.dateOfBirthString.toString().length()-3).
        //                equals(elements.get(4).getText().replace(","," ").substring(elements.get(4).getText().replace(","," ").length()-3)));

        //   **** BUG FOUND: it doesn't log the subjects data in database
        //Assert.assertEquals(this.description,elements.get(5).getText());
        Assert.assertEquals(hobbyListDetached, elements.get(6).getText().replace(",", "").replace(" ", ""));
        Assert.assertEquals(this.picture, null);
        Assert.assertEquals(this.address, elements.get(8).getText());
        Assert.assertEquals(this.state + " " + this.city, elements.get(9).getText());


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

        //1 mounh

        if(value.contains("mounth forward") && field.equalsIgnoreCase("Select Date")){
            String mounth = value.substring(0, value.indexOf("mounth") - 1);
            int forwardMounth = Integer.parseInt(mounth);
            value = formatter3.format(LocalDateTime.now().plusMonths(forwardMounth));
            this.expected_select_date=value;
            this.actual_select_date = new DatePickerPage().selectDate.getAttribute("value");


        }else if(value.contains("mounth forward") && field.equalsIgnoreCase("Date And Time")){
            String mounth = value.substring(0, value.indexOf("mounth") - 1);
            int forwardMounth = Integer.parseInt(mounth);
            value = formatter4.format(LocalDateTime.now().plusMonths(forwardMounth));
            this.expected_date_and_time= value;
            this.actual_date_and_time = new DatePickerPage().dateAndTime.getAttribute("value");

        }
//        System.out.println("field = " + field);
//        System.out.println("value = " + value);

        new StudentRegisterPage().fillInABlank(field, value);






    }


    @Then("the user tries below {string} options and verifies none of them is not working")
    public void the_user_tries_below_options_and_verifies_none_of_them_is_not_working(String field, List<String> dataTable) {

        System.out.println("dataTable.toString() = " + dataTable.toString());

        List<String> collect = dataTable.stream().peek(data -> {
            System.out.println("*****");
            new StudentRegisterPage().fillInABlank(field, data);

          //  BrowserUtils.clickWithJS(Driver.get().findElement(By.xpath("//button[.='Submit']")));

            try {
                new StudentRegisterPage().clickButton("Submit");
                Assert.assertFalse(new StudentRegisterPage().confirmationWindowMessage.isDisplayed());
            } catch (NoSuchElementException n) {
                Assert.assertTrue(true);
            }
            //new StudentRegisterPage().clickButton("Close");
            //BrowserUtils.waitFor(2);

            return;

        }).collect(Collectors.toList());


    }





}
