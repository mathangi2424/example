package com.serenity.example.services;

import io.restassured.response.Response;

public class CalculateAPI extends BaseService {

    public CalculateAPI() {
        super();
        BASE_URI = testProperties.getProperty("auPost") + testProperties.getProperty("calculateEP");
    }

    public CalculateAPIResponse calculate(String country, String weight, String serviceCode, boolean auth) {
        try {
            if (auth) addAuthKey();
            addQueryParam("country_code", country);
            addQueryParam("service_code", serviceCode);
            addQueryParam("weight", weight);
            retrieveResponseByGET(BASE_URI, requestSpecBuilder);
            return (CalculateAPIResponse) responseToObject(actualResponse.asString(), CalculateAPIResponse.class);
        } catch (Exception e) {
            LOG.error("Calculator request failed" + "\n" + e.getMessage());
            return null;
        }
    }


}
