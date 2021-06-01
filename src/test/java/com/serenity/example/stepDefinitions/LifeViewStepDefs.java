package com.serenity.example.stepDefinitions;

import com.serenity.example.serenity.LifeViewSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;

import java.util.List;
import java.util.Map;

public class LifeViewStepDefs {
    @Steps
    LifeViewSteps lifeView_steps;

    @Given("^user is on home page$")
    public void open_home_page() {
        lifeView_steps.openHomePage();
    }

    @Given("^search \"([^\"]*)\" on home page$")
    public void search_any_string(String searchString) {
        lifeView_steps.searchString(searchString);
    }


    @Given("^click \"([^\"]*)\" link from search result$")
    public void click_link_from_result(String searchString) {
        lifeView_steps.clickLink(searchString);
    }

    @And("^user clicks on Request a demo button$")
    public void request_lifeview_demo() {
        lifeView_steps.clickRequestDemo();
    }

    @Then("fill the form with below details")
    public void fillFormData(DataTable dataTable) {
        List<Map<String, String>> formData = dataTable.asMaps(String.class, String.class);
        lifeView_steps.fillData(formData);
    }

}
