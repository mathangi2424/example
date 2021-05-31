package com.serenity.example.pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class TaxCalculatorPage extends BasePage {

    @FindBy(xpath = "//h1[text()='Simple tax calculator']")
    WebElementFacade title;

    @FindBy(name = "texttaxIncomeAmt")
    WebElementFacade txtIncome;


    @FindBy(xpath = "//button[text()='Submit']")
    WebElementFacade btnSubmit;

    @FindBy(xpath = "//p[text()='The estimated tax on your taxable income is ']/span")
    WebElementFacade lblTaxableIncome;



    public TaxCalculatorPage(WebDriver driver) {
        super(driver);
        try {
            getDriver().navigate().to(testProperties.getProperty("atoURL"));
            waitForTitleToAppear("Questions | Simple tax calculator");
        } catch (Exception e) {
            Assert.fail("Unable to load the ato calculator page : " + e.getMessage());
        }
    }

    public void selectYear(String year) {
        WebElementFacade we = find(By.id("ddl-financialYear"));
        selectDropDownByVisibleText(we, year);
    }

    public void setAnnualIncome(String income) {
        txtIncome.sendKeys(income);
    }

    public void selectVisaType(String visaType) {
        String xpath = "//span[text()='" + visaType + "']/parent::label/preceding-sibling::input";
        WebElementFacade we = find(By.xpath(xpath));
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", we);
    }


    public void clickSubmit(){
        btnSubmit.click();
        waitForTitleToAppear("Report | Simple tax calculator");
    }

    public void verifyResult(String taxableIncome){
        String actualtaxableIncome = lblTaxableIncome.getText();
        Assert.assertTrue("Taxable income calculation is incorrect " , taxableIncome.equals(actualtaxableIncome));

    }

    public void selecMonths(String s) {
        WebElementFacade we = find(By.id("ddl-residentPartYearMonths"));
        selectDropDownByVisibleText(we, s);
    }
}
