package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.RegisterPage;

public class RegisterSteps {
    RegisterPage registerPage;

    @Step
    public boolean registerSucc(String firstname,String lastname,String street,String city,String state,String zipCode,String numberPhone,String ssn,String username,String password,String repPass) {
        registerPage.open();
        registerPage.inputcity(city);
        registerPage.inputusername(username);
        registerPage.inputfirstName(firstname);
        registerPage.inputlastName(lastname);
        registerPage.inputpassword(password);
        registerPage.inputphoneNumber(numberPhone);
        registerPage.inputrepeatedPassword(repPass);
        registerPage.inputssn(ssn);
        registerPage.inputstreet(street);
        registerPage.inputzipCode(zipCode);
        registerPage.inputstate(state);
        registerPage.clickRegisterButton();
        return true;
    }

    @Step
    public String registerUnsuc(String firstname,String lastname,String street,String city,String state,String zipCode,String numberPhone,String ssn,String username,String password,String repPass) {
        registerPage.open();
        registerPage.inputcity(city);
        registerPage.inputusername(username);
        registerPage.inputfirstName(firstname);
        registerPage.inputlastName(lastname);
        registerPage.inputpassword(password);
        registerPage.inputphoneNumber(numberPhone);
        registerPage.inputrepeatedPassword(repPass);
        registerPage.inputssn(ssn);
        registerPage.inputstreet(street);
        registerPage.inputzipCode(zipCode);
        registerPage.inputstate(state);
        registerPage.clickRegisterButton();
        return registerPage.getregisterErrorLabel();
    }
}
