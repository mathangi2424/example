package com.serenity.example.pageObjects;

import com.serenity.example.utilities.Config;
import io.cucumber.core.api.Scenario;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.*;

public class BasePage extends PageObject {

    final static Logger LOG = LoggerFactory.getLogger(BasePage.class);
    Properties testProperties;

    public BasePage() {
    }

    public BasePage(WebDriver driver) {
        super(driver);
        Config config = new Config();
        testProperties = config.initializeConfig();
    }

    public static Scenario scenario;
    private final int TIMEOUT_WAIT_FOR_ELEMENT = 30;


    public void waitForElementToBeVisible(WebElementFacade element) {
        element.withTimeoutOf(Duration.ofSeconds(TIMEOUT_WAIT_FOR_ELEMENT)).waitUntilVisible();
    }

    protected void selectDropDownByVisibleText(WebElementFacade webElement, String value) {
        Select select = new Select(webElement);
        select.selectByVisibleText(value);
    }

    protected void printLog(String message) {
        scenario.write(message);
        LOG.info(message);
    }

}
