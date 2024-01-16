package org.execution;


import org.baseclass.UtilClass;
import org.junit.Assert;
import org.pageobjects.ContactUsPage;

import io.cucumber.java.en.When;

public class ContactUs extends UtilClass {

	public static ContactUsPage c;

	@When("To user click contact us button and click marketing button")
	public void toUserClickContactUsButtonAndClickMarketingButton() {
		applyWaitToAllElements();
		c = new ContactUsPage();
		elementToClick(c.getContactUs());
		elementToClick(c.getMarketingContactUs());
	}

	@When("To user fill all field and click submit button")
	public void toUserFillAllFieldAndClickSubmitButton() {
		applyWaitToAllElements();
		c = new ContactUsPage();

		passValueToElement(c.getFullName(), readData("sheet", 2, 0));
		passValueToElement(c.getOrganisationName(), readData("sheet", 2, 1));
		passValueToElement(c.getPhoneNumber(), readData("sheet", 2, 2));
		passValueToElement(c.getEmail(), readData("sheet", 2, 3));
		selectValueFromDropdown(c.getJobrole(), 5);
		elementToClick(c.getAgree());
		elementToClick(c.getSubmit());

		String actual = textFromElement(c.getError());
		String expected = "Sorry, there was an error submitting the form. Please try again.";
		Assert.assertEquals("To check Fail message is appear", expected, actual);

	}

}
