package com.serenity.example.hooks;

import com.serenity.example.pageObjects.BasePage;
import com.serenity.example.utilities.Config;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Hooks {

	@Managed(uniqueSession = true, driver = "chrome")
	public WebDriver driver;

	public Hooks() {
		System.out.println("--------------------INITIALIZE HOOKS----------------------");
	}

	@Before
	public void BeforeScenario(Scenario scenario) {
		System.out.println("--------------------BEFORE SCENARIO----------------------");
		driver.manage().timeouts().implicitlyWait(240, TimeUnit.SECONDS);
		System.out.println("--------------------Setting timeouts to 4 min--------------------");
	}

	@After
	public void AfterScenario(Scenario scenario) {
		System.out.println("--------------------AFTER SCENARIO----------------------");
		driver.quit();
		System.out.println("--------------------Completed execution: " + scenario.getName()+ "----------------------");
	}

}
