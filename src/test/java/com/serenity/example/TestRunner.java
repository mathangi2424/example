package com.serenity.example;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber-report/cucumber.json"},
		features = {"src/test/resources/features"},
		junit="--step-notifications")
public class TestRunner {

}

