package org.pageobjects;

import java.util.List;

import org.baseclass.UtilClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends UtilClass {
				
	public HomePage() {
		PageFactory.initElements(driver	,this);
	}
	
	@FindBy(xpath ="//img[@alt='Tendable Logo']")
	private WebElement homeElement;
	
	@FindBy(xpath = "(//nav[@id='main-navigation-new']//ul)[1]/li")
	private List<WebElement> topMenu;

	@FindBy(xpath = "(//a[contains(text(),'Request a Demo')])[2]")
	private WebElement demo;
	
	
	public WebElement getDemo() {
		return demo;
	}


	public WebElement getHomeElement() {
		return homeElement;
	}


	public List<WebElement> getTopMenu() {
		return topMenu;
	}

	
	
}
