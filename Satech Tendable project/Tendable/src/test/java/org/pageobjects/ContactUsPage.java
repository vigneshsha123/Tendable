package org.pageobjects;

import org.baseclass.UtilClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage extends UtilClass{
	
	public ContactUsPage() {
	
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Contact Us']")
     private WebElement contactUs;
	
	@FindBy(xpath = "//div[contains(text(),'Marketing')]//parent::div[@class='text-center']//button")
	private WebElement marketingContactUs;
	
	@FindBy(xpath = "//div[@class='toggle-form toggle-163701']//child::input[@placeholder='Full Name']")
	private WebElement fullName;
	
	@FindBy(xpath = "//div[@class='toggle-form toggle-163701']//child::input[@name='organisationName']")
	private WebElement organisationName ;

	@FindBy(xpath = "//div[@class='toggle-form toggle-163701']//child::input[@placeholder='Phone Number']")
	private WebElement phoneNumber ;
	
	@FindBy(xpath = "//div[@class='toggle-form toggle-163701']//child::input[@placeholder='Email']")
	private WebElement email;
	
	
	@FindBy(xpath = "//div[@class='toggle-form toggle-163701']//child::select[@name='jobRole']")
	private WebElement jobrole;

	@FindBy(xpath = "//div[@class='toggle-form toggle-163701']//child::textarea")
	private WebElement message;
	

	@FindBy(xpath = "(//input[@type='radio'])[1]")
	private WebElement agree;
	

	@FindBy(xpath = "(//button[@data-freeform-action='submit'])[1]")
	private WebElement submit;

	
	@FindBy(xpath = "(//div[@class='mb-4']//child::h3[text()='Form has been submitted successfully!'])[1]")
	private WebElement outputMessage;
	
	
	@FindBy(xpath = "//p[contains(text(),'Sorry, th')]")
private WebElement error;
	
	
	
	public WebElement getError() {
		return error;
	}

	public WebElement getOutputMessage() {
		return outputMessage;
	}

	public WebElement getSubmit() {
		return submit;
	}

	public WebElement getAgree() {
		return agree;
	}

	public WebElement getMessage() {
		return message;
	}

	public WebElement getFullName() {
		return fullName;
	}

	public WebElement getOrganisationName() {
		return organisationName;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getJobrole() {
		return jobrole;
	}

	public WebElement getContactUs() {
		return contactUs;
	}

	public WebElement getMarketingContactUs() {
		return marketingContactUs;
	}
	
	
	

}
