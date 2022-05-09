package org.example.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://parabank.parasoft.com/parabank/index.htm")
public class LoginPage extends PageObject {

    @FindBy(name = "username")
    private WebElement userInput;
    @FindBy(name = "password")
    private WebElement passwordInput;
    @FindBy(css = "input[type=submit]")
    private WebElement loginButton;
    @FindBy(css = "#leftPanel > h2")
    private WebElement formHeader;
    @FindBy(css = "#rightPanel > p")
    private WebElement errorLoginMessage;


    public void clickLoginButton() {
        loginButton.click();
    }

    public String getFormHeader() {
        return formHeader.getAttribute("innerHTML");
    }

    public String getErrorLoginMessage() {
        return errorLoginMessage.getAttribute("innerHTML");
    }


    public void inputPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void typeUser(String username) {
        userInput.clear();
        userInput.sendKeys(username);
    }
}
