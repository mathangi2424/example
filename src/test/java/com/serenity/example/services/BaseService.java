package com.serenity.example.services;

import com.google.gson.Gson;
import com.serenity.example.utilities.Config;
import io.cucumber.core.api.Scenario;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import static io.restassured.RestAssured.given;

public class BaseService {

    final static Logger LOG = LoggerFactory.getLogger(BaseService.class);
    Properties testProperties;
    public String BASE_URI = "";
    public String AUTH_KEY = "";
    public RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();

    public BaseService() {
        Config config = new Config();
        testProperties = config.initializeConfig();
        AUTH_KEY = testProperties.getProperty("auth_key");
    }

    public static Scenario scenario;
    public Response actualResponse = null;


    public void addHeader(String attribute, String value) {
        Map<String, String> header = new LinkedHashMap<String, String>();
        header.put(attribute, value);
        requestSpecBuilder.addHeaders(header);
    }

    public void addAuthKey(){
        addHeader("AUTH-KEY", AUTH_KEY);
    };

    public void addQueryParam(String attribute, String value) {
        requestSpecBuilder.addQueryParam(attribute, value);
    }

    protected void printLog(String message) {
        scenario.write(message);
        LOG.info(message);
    }

    public Object responseToObject(String resp, Class mapperClass) {
        Gson g = new Gson();
        return g.fromJson(resp, mapperClass);
    }

    private void resetReqSpecification() {
        requestSpecBuilder = new RequestSpecBuilder();
    }

    public Response retrieveResponseByGET(String URLrequest, RequestSpecBuilder requestSpecBuilder) {
        actualResponse = SerenityRest.
                given()
                .relaxedHTTPSValidation().
                        spec(requestSpecBuilder.build()).
                        when().
                        log().
                        all().
                        contentType("text/xml; charset=UTF-8;").
                        get(URLrequest).
                        then().
                        log().
                        all().
                        extract().
                        response();

        return actualResponse;
    }

}
