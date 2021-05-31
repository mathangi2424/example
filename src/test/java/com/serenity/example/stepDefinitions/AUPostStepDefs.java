package com.serenity.example.stepDefinitions;

import com.serenity.example.serenity.AUPostSteps;
import com.serenity.example.serenity.TaxCalcSteps;
import com.serenity.example.services.CalculateAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Steps;

public class AUPostStepDefs {


    @Steps
    AUPostSteps aupostSteps;
    @Given("invoke calculate api with parcel ([^\"]*), ([^\"]*) and destination ([^\"]*)")
    public void calculate_api(String weight, String serviceCode, String country) {
        aupostSteps.postCalculator(country, weight, serviceCode);
    }

    @Given("invoke calculate api with invalid auth key, parcel ([^\"]*), ([^\"]*) and destination ([^\"]*)")
    public void calculate_api_invalid_auth_key(String weight, String serviceCode, String country) {
        aupostSteps.postCalculatorWithoutKey(country, weight, serviceCode);
    }

    @Then("verify package ([^\"]*) is returned")
    public void package_cost(String cost) {
        aupostSteps.verifyCost(cost);
    }


    @Then("verify status code is ([^\"]*)")
    public void package_cost(Integer code) {
        aupostSteps.verifyErrorCode(code);
    }


}
