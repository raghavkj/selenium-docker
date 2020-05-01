package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstNameTxt;

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastNameTxt;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement userNameTxt;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordTxt;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    private WebElement confirmPasswordTxt;

    @FindBy(xpath = "//input[@name='register']")
    private WebElement submitBtn;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void goTo() {
        this.driver.get("http://newtours.demoaut.com/mercuryregister.php");
        this.wait.until(ExpectedConditions.visibilityOf(firstNameTxt));
    }

    public void enterUserDetails(String firstName,String lastName) {
        this.firstNameTxt.sendKeys(firstName);
        this.lastNameTxt.sendKeys(lastName);
    }

    public void enterUserCredentials(String userName,String password) {
        this.userNameTxt.sendKeys(userName);
        this.passwordTxt.sendKeys(password);
        this.confirmPasswordTxt.sendKeys(password);
    }

    public void submit() {
        this.submitBtn.click();
    }

}
