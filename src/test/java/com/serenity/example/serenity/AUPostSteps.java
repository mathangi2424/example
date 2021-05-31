package com.serenity.example.serenity;

import com.serenity.example.services.CalculateAPI;
import com.serenity.example.services.CalculateAPIResponse;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

public class AUPostSteps {

    CalculateAPIResponse apiResponse;
    Response response;

    @Step
    public void postCalculator(String country, String weight, String serviceCode) {
        CalculateAPI postCalculator = new CalculateAPI();
        apiResponse = postCalculator.calculate(country, weight, serviceCode, true);
        response = postCalculator.actualResponse;
    }

    @Step
    public void postCalculatorWithoutKey(String country, String weight, String serviceCode) {
        CalculateAPI postCalculator = new CalculateAPI();
        apiResponse = postCalculator.calculate(country, weight, serviceCode, false);
        response = postCalculator.actualResponse;
    }

    @Step
    public void verifyErrorCode(Integer status) {
        Assert.assertTrue("Status code dint match: ", response.getStatusCode() == status);

    }

    @Step
    public void verifyCost(String cost) {
        Assert.assertTrue("Cost dint matches : " + apiResponse.getTitle().getTotalCost() + ":" + cost,
                apiResponse.getTitle().getTotalCost().equals(cost));
    }
}
