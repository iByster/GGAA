package org.example.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://parabank.parasoft.com/parabank/register.htm")
public class RegisterPage extends PageObject {

    @FindBy(id = "customer.firstName")
    private WebElement firstName;

    @FindBy(id = "customer.lastName")
    private WebElement lastName;

    @FindBy(id = "customer.address.street")
    private WebElement street;

    @FindBy(id = "customer.address.city")
    private WebElement city;


    @FindBy(id = "customer.address.state")
    private WebElement state;

    @FindBy(id = "customer.address.zipCode")
    private WebElement zipCode;


    @FindBy(id = "customer.phoneNumber")
    private WebElement phoneNumber;

    @FindBy(id = "customer.ssn")
    private WebElement ssn;

    @FindBy(id = "customer.username")
    private WebElement username;

    @FindBy(id = "customer.password")
    private WebElement password;

    @FindBy(id = "repeatedPassword")
    private WebElement repeatedPassword;



    @FindBy(css = "#customerForm > table > tbody > tr:nth-child(13) > td:nth-child(2) > input")
    private WebElement registerButton;

    @FindBy(id = "repeatedPassword.errors")
    private WebElement registerErrorLabel;


    public String getregisterErrorLabel(){
        return registerErrorLabel.getAttribute("innerHTML");
    }


    public void clickRegisterButton() {
        registerButton.click();
        waitABit(3000);
    }



    public void inputfirstName(String firstNameS) {
        firstName.clear();
        firstName.sendKeys(firstNameS);
    }

    public void inputlastName(String lastNameS) {
        lastName.clear();
        lastName.sendKeys(lastNameS);
    }

    public void inputstreet(String streetS) {
        street.clear();
        street.sendKeys(streetS);
    }

    public void inputcity(String cityS) {
        city.clear();
        city.sendKeys(cityS);
    }

    public void inputstate(String stateS) {
        state.clear();
        state.sendKeys(stateS);
    }

    public void inputzipCode(String zipCodeS) {
        zipCode.clear();
        zipCode.sendKeys(zipCodeS);
    }

    public void inputphoneNumber(String phoneNumberS) {
        phoneNumber.clear();
        phoneNumber.sendKeys(phoneNumberS);
    }

    public void inputssn(String ssnS) {
        ssn.clear();
        ssn.sendKeys(ssnS);
    }

    public void inputusername(String usernameS) {
        username.clear();
        username.sendKeys(usernameS);
    }

    public void inputpassword(String passwordS) {
        password.clear();
        password.sendKeys(passwordS);
    }
    public void inputrepeatedPassword(String repeatedPasswordS) {
        repeatedPassword.clear();
        repeatedPassword.sendKeys(repeatedPasswordS);
    }

}
