package org.execution;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.baseclass.UtilClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.pageobjects.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class StepDefinition extends UtilClass {
	
	public static HomePage h;
	
	@Given("To user launch a chrome browser and pass valid {string}")
	public void toUserLaunchAChromeBrowserAndPassValid(String string, io.cucumber.datatable.DataTable dataTable) {
		List<String> l = dataTable.asList();
	   String url = l.get(0);
	   launchChromeBrowser();
	   maxWindow();
	   launchUrl(url);
	}
	
	@When("To user verify the confirm accessibility of the toplevel menus home,our story,our solution, and why Tendable.")
	public void toUserVerifyTheConfirmAccessibilityOfTheToplevelMenusHomeOurStoryOurSolutionAndWhyTendable() {
	   applyWaitToAllElements();
	   h= new HomePage();
	   Assert.assertTrue("To check tendable is present", CheckElementPresent(h.getHomeElement()));
	   
	   List<String> expected=new LinkedList<String>();
	   expected.add("Our Story");
	   expected.add("Our Solution");
	   expected.add("Why Tendable?");
	   expected.add("About Us");
	   
	   List<String> actual=new LinkedList<String>();
	   
	   List<WebElement> topMenu = h.getTopMenu();
	   for (WebElement webElement : topMenu) {
		String text = webElement.getText();
		actual.add(text);
	}
	   Assert.assertTrue("To check all top menu", expected.equals(actual));
	   
	}
	
	@When("To user check  request a demo button  is present and click request a demo button")
	public void toUserCheckRequestADemoButtonIsPresentAndClickRequestADemoButton() {
		applyWaitToAllElements();
		h= new HomePage();
		 elementToClick(h.getDemo());
		 Assert.assertTrue("To check demo button", h.getDemo().isDisplayed());   
	}

	@When("To user check all top level menus are present")
	public void toUserCheckAllTopLevelMenusArePresent() {
		
		  List<String> expected=new LinkedList<String>();
		   expected.add("Our Story");
		   expected.add("Our Solution");
		   expected.add("Why Tendable?");
		   expected.add("About Us");
		   
		   List<String> actual=new LinkedList<String>();
		   
		   List<WebElement> topMenu = h.getTopMenu();
		   for (WebElement webElement : topMenu) {
			String text = webElement.getText();
			actual.add(text);
		}
		   Assert.assertTrue("To check all top menu", expected.equals(actual));
	   
	}
	
	
	
	
	
	


}
