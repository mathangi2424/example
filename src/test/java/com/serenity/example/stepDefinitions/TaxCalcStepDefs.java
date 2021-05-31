package com.serenity.example.stepDefinitions;

import com.serenity.example.serenity.TaxCalcSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class TaxCalcStepDefs {

    @Steps
    TaxCalcSteps taxSteps;

    @Given("a user in tax calculator page selects ([^\"]*)")
    public void a_user_in_tax_calculator_page_selects(String year) {
        taxSteps.selectYear(year);
    }

    @When("enters annual ([^\"]*) and ([^\"]*)")
    public void enters_annual_and_Resident_for_full_year(String income, String visaType) {
        taxSteps.enterAnnualIncome(income);
        taxSteps.chooseVisaType(visaType);
    }

    @When("clicks submit")
    public void clicks_submit() {
        taxSteps.submitDetails();
    }

    @Then("calculator displays the estimated ([^\"]*)")
    public void calculator_displays_the_estimated(String amount) {
        taxSteps.verifyResult(amount);
    }

}
