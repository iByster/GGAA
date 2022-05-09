package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.steps.serenity.LoginSteps;
import org.example.steps.serenity.RegisterSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/registerData.csv")
public class RegisterTest {

    @Managed
    private WebDriver webdriver;
    @Steps
    private RegisterSteps registerSteps;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username, password;

    @Test
    public void registerTest() {


        String firstname = RandomStringUtils.randomAlphabetic(12);
        String lastname  = RandomStringUtils.randomAlphabetic(12);
        String street = RandomStringUtils.randomAlphabetic(12);
        String city  = RandomStringUtils.randomAlphabetic(12);
        String state = RandomStringUtils.randomAlphabetic(12);
        String zipCode  = RandomStringUtils.randomAlphabetic(12);
        String numberPhone = RandomStringUtils.randomAlphabetic(12);
        String ssn  = RandomStringUtils.randomAlphabetic(12);
        String username  = RandomStringUtils.randomAlphabetic(12);
        String password  = RandomStringUtils.randomAlphabetic(12);
        String repPass  =  RandomStringUtils.randomAlphabetic(12);


        assert registerSteps.registerUnsuc(firstname,lastname ,street,city,state,zipCode,numberPhone,ssn,username,password,repPass).equals("Passwords did not match.");

        repPass = password;

        assert registerSteps.registerSucc(firstname,lastname ,street,city,state,zipCode,numberPhone,ssn,username,password,repPass);
    }




    public void setUsername(String username) {
        this.username = username;
    }
}
