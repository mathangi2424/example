package com.serenity.example.pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//h1[text()='Life Insurance']")
    WebElementFacade title;

    @FindBy(xpath = "//span[text()='Toggle search']//parent::button")
    WebElementFacade search;

    @FindBy(xpath = "//input[@type='search']")
    WebElementFacade txtSearch;

        @FindBy(xpath = "//button[@type='submit']")
    WebElementFacade btnSearch;

    @FindBy(xpath = "//h1[contains(text(),'Search results')]")
    WebElementFacade searchTitle;

    @FindBy(xpath = "//input[@type='search']/parent::div[contains(@class,'is-loading')]")
    WebElementFacade searchLoading;

    @FindBy(xpath = "//span[text()='Request a demo']/parent::a")
    WebElementFacade requestDemo;

    public void openMLC() {
        try {
            getDriver().navigate().to(testProperties.getProperty("mclURL"));
            waitForElementToBeVisible(title);
        } catch (Exception e) {
            Assert.fail("Unable to load the home page : " + e.getMessage());
        }
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickSearch() {
        search.click();
        waitForElementToBeVisible(txtSearch);
    }

    public void search(String searchString) {
        txtSearch.sendKeys(searchString);
        btnSearch.waitUntilEnabled();
        btnSearch.click();
        waitForElementToBeVisible(searchTitle);
    }

    public void clickSearchResult(String searchString) {
        WebElementFacade resultLink = find(By.xpath("//h2[text()='" + searchString + "']"));
        if (resultLink.isDisplayed()) {
            resultLink.click();
        } else {
            Assert.fail("Unable to find the search string in result");
        }
    }

}
