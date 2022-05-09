package org.example.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.apache.commons.lang3.RandomStringUtils;
import org.example.steps.serenity.ChangeInfoSteps;
import org.example.steps.serenity.LoginSteps;
import org.example.steps.serenity.LogoutSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/logoutData.csv")
public class LogoutTest {

    @Managed
    private WebDriver webdriver;
    @Steps
    private LogoutSteps logoutSteps;
    @Steps
    private LoginSteps loginSteps;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String username, password;

    @Test
    public void loginTest() {
        loginSteps.login(username, password);
        String header = logoutSteps.logout();
        assert header.equals("Customer Login");
    }

}
