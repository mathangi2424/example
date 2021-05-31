package com.serenity.example.pageObjects;

import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class LifeViewPage extends BasePage {

    static final String BREADCRUMBLINKNAME = "Home Partnering with us Superannuation funds LifeView";

    @FindBy(xpath = "//ul[@itemprop='breadcrumb']/li")
    List<WebElementFacade> breadcrumbLinks;

    @FindBy(xpath = "//span[text()='Request a demo']/parent::a")
    WebElementFacade requestDemo;

    @FindBy(xpath = "//h1[text()='Request a LifeView demo']")
    WebElementFacade requestDemoTitle;


    public LifeViewPage(WebDriver driver) {
        super(driver);
    }

    public void verifyBreadCrumbName() {
        Assert.assertTrue("Bread crumb name mismatch : " + getBreadCrumbLinkNames(),
                getBreadCrumbLinkNames().equals(BREADCRUMBLINKNAME));

    }

    private String getBreadCrumbLinkNames() {
        String linkName = breadcrumbLinks.stream().map(WebElementFacade::getText).collect(Collectors.joining(" "));
        return linkName;
    }

    public void clickRequestDemoButton() {
        requestDemo.click();
        requestDemoTitle.waitUntilVisible();
    }

    public void setTextOfFormElement(String field, String value) {
        WebElementFacade we = find(By.xpath("//label[text()='" + field + "']/following-sibling::input"));
        we.sendKeys(value);
    }

    public void setTextAreaOfFormElement(String field, String value) {
        WebElementFacade we = find(By.xpath("//label[text()='" + field + "']/following-sibling::textarea"));
        we.sendKeys(value);
    }

    public void setRadioOfFormElement(String field, String value) {
        WebElementFacade we = find(By.xpath("//label[text()='Preferred contact time']/following-sibling::div//td//input[@value='"+value+"']"));
        we.click();
    }
}
