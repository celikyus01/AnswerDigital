package com.answerDig.pages;

import com.answerDig.utilities.BrowserUtils;
import com.answerDig.utilities.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public abstract class BasePage {
    WebDriverWait wait = new WebDriverWait(Driver.get(), 10);
    Actions actions = new Actions(Driver.get());

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }

    public void navigateToModule(String mainModuleName, String subModuleName) {

        String mainModule_xpath = "//h5[.='" + mainModuleName + "']/../..";
        String subModule_xpath = "//span[.='" + subModuleName + "']/..";

        WebElement mainModule = Driver.get().findElement(By.xpath(mainModule_xpath));
        wait.until(ExpectedConditions.elementToBeClickable(mainModule));
        mainModule.click();


        WebElement subModule = Driver.get().findElement(By.xpath(subModule_xpath)); //submodule
        wait.until(ExpectedConditions.elementToBeClickable(subModule));
        BrowserUtils.clickWithJS(subModule);

    }


    public void checkRadioButton(String value) {

        try {
            Driver.get().findElement(By.xpath("//label[.='" + value + "']")).click();
        } catch (NoSuchElementException n) {
            Driver.get().findElement(By.xpath("//label[normalize-space()=" + value + "]")).click();
        }

    }

    public void selectDropDownWithNoSelectTag(String ddName, Object value) {

        WebElement dd = Driver.get().findElement(By.xpath("//div[@id='" + ddName.toLowerCase() + "']//input"));
        BrowserUtils.scrollToElement(dd);
        dd.sendKeys(value.toString(), Keys.ENTER);

    }

    public String getFilePathUnderResources(String fileName) {
        String projectPath = System.getProperty("user.dir");
        String relativePath = "src/test/resources/" + fileName;
        return projectPath + "/" + relativePath;

    }

    public void clickButton(String buttonName) {
        try {
            Driver.get().findElement(By.xpath("//button[.='" + buttonName + "']")).click();
        } catch (ElementClickInterceptedException e) {
            BrowserUtils.clickWithJS(Driver.get().findElement(By.xpath("//button[.='" + buttonName + "']")));
        }

    }


    public void fillInABlank(String field, String value) {
        try {
            Driver.get().findElement(By.xpath("//label[.='" + field + "']/../..//input")).clear();
            Driver.get().findElement(By.xpath("//label[.='" + field + "']/../..//input")).sendKeys(value);
        } catch (org.openqa.selenium.NoSuchElementException n) {
            if (field.equalsIgnoreCase("Select Date")) {
                WebElement input1 = Driver.get().findElement(By.xpath("(//div[.='Select Date']/..//input)[1]"));
                input1.click();
                JavascriptExecutor js = (JavascriptExecutor) Driver.get();
                js.executeScript("arguments[0].value = '';", input1); //to delete keys
                input1.sendKeys(value + Keys.ENTER);

            } else if (field.equalsIgnoreCase("Date And Time")) {

                WebElement input2 = Driver.get().findElement(By.xpath("(//div[.='Date And Time']/..//input)[2]"));
                input2.click();
                JavascriptExecutor js = (JavascriptExecutor) Driver.get();
                js.executeScript("arguments[0].value = '';", input2);
                input2.sendKeys(value);
                input2.sendKeys(Keys.ENTER);
            }
        }
    }

}
