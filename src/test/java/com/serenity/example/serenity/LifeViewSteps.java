package com.serenity.example.serenity;

import com.serenity.example.pageObjects.HomePage;
import com.serenity.example.pageObjects.LifeViewPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

public class LifeViewSteps {

	HomePage homePage;
	LifeViewPage lifeViewPage;

	@Step
	public void openHomePage(){
		homePage.openMLC();
			}


	@Step
	public void searchString(String searchString) {
		homePage.clickSearch();
		homePage.search(searchString);
	}

	@Step
	public void clickLink(String searchString) {
		homePage.clickSearchResult(searchString);
		lifeViewPage.verifyBreadCrumbName();
	}


	@Step
	public void clickRequestDemo() {
		lifeViewPage.clickRequestDemoButton();
	}

	@Step
	public void fillData(List<Map<String, String>> formData)
	{
		lifeViewPage.setTextOfFormElement("Name", formData.get(0).get("Name"));
		lifeViewPage.setTextOfFormElement("Company", formData.get(0).get("Company"));
		lifeViewPage.setTextOfFormElement("Email", formData.get(0).get("Email"));
		lifeViewPage.setTextOfFormElement("Phone", formData.get(0).get("Phone"));
		lifeViewPage.setTextOfFormElement("Preferred contact date", formData.get(0).get("Date"));
		lifeViewPage.setRadioOfFormElement("Preferred contact time", formData.get(0).get("Time"));
		lifeViewPage.setTextAreaOfFormElement("Request details", formData.get(0).get("Details"));

	}
}
