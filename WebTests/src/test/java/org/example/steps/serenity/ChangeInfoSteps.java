package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.example.pages.AdminPage;

public class ChangeInfoSteps {
	AdminPage adminPage;

	@Step
	public String changeCityAndState(String city,String state) {
		adminPage.goToInfoPage();
		adminPage.setCityAndState(city,state);
		adminPage.clickSave();
		return adminPage.getSuccessMessage();
	}

	@Step
	public String changeCityAndStateError(String city,String state){
		adminPage.goToInfoPage();
		adminPage.setCityAndState(city,state);
		return adminPage.getmissingField();
	}
}
