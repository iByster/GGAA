package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.AdminPage;
import org.example.pages.LoginPage;

public class LogoutSteps {
    AdminPage adminPage;
    LoginPage loginPage;
    @Step
    public String logout() {
        adminPage.clickLogout();
        return loginPage.getFormHeader();
    }
}
