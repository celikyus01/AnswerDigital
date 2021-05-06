package com.answerDig.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudentRegisterPage extends BasePage {

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

    @FindBy(xpath = "//input[@id='userEmail']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='userNumber']")
    public WebElement mobileNumber;

    @FindBy(id = "dateOfBirthInput")
    public WebElement dateOfBirthInput;

    @FindBy(css = "#subjectsInput")
    public WebElement subjects;

    @FindBy(xpath = "//input[@id='uploadPicture']")
    public WebElement picture;

    @FindBy(xpath = "//textarea[@id='currentAddress']")
    public WebElement currentAddress;

    @FindBy(css = ".btn.btn-primary")
    public WebElement submit;

    @FindBy(css = "#example-modal-sizes-title-lg")
    public WebElement confirmationWindowMessage;


    public void fillInAForm(String firstNameStr, String lastNameStr, String emailStr, String mobileStr, String currentAddressStr, String dateOfBirth) {
        firstName.sendKeys(firstNameStr);
        lastName.sendKeys(lastNameStr);
        email.sendKeys(emailStr);
        mobileNumber.sendKeys(mobileStr);
        currentAddress.sendKeys(currentAddressStr);


//        new Actions(Driver.get()).moveToElement(dateOfBirthInput).doubleClick().click().sendKeys(Keys.DELETE).perform();
//        dateOfBirthInput.clear();
//        dateOfBirthInput.sendKeys(dateOfBirth);


    }






}
