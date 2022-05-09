package org.example.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminPage extends PageObject {
	@FindBy(css = "#leftPanel > ul > li:nth-child(6) > a")
	private WebElement infoLink;
	@FindBy(css = "#leftPanel > ul > li:nth-child(8) > a")
	private WebElement logoutLink;
	@FindBy(id = "customer.address.state")
	private WebElement stateInput;
	@FindBy(id = "customer.address.city")
	private WebElement cityInput;
	@FindBy(css = "input[type=submit]")
	private WebElement saveButton;
	@FindBy(css = "#rightPanel > div > div > p")
	private WebElement successMessageParagraph;
	@FindBy(css = "#rightPanel > div > div > form > table > tbody > tr:nth-child(5) > td:nth-child(3) > span")
	private WebElement missingField;

	public void goToInfoPage() {
		waitFor(infoLink);
		infoLink.click();
		waitABit(2000);
	}




	public void setCityAndState(String city,String state) {
		//waitABit(1000);
		//waitFor(city);
		//waitFor(state);
		cityInput.clear();
		stateInput.clear();
		cityInput.sendKeys(city);
		stateInput.sendKeys(state);
	}

	public void clickSave() {
		saveButton.click();
		waitABit(5000);
	}

	public void clickLogout() {
		logoutLink.click();
		waitABit(5000);
	}

	public String getSuccessMessage() {
		return successMessageParagraph.getAttribute("innerHTML");
	}
	public String getmissingField() {
		return missingField.getAttribute("innerHTML");
	}

}
