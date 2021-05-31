package com.serenity.example.serenity;

import com.serenity.example.pageObjects.HomePage;
import com.serenity.example.pageObjects.LifeViewPage;
import com.serenity.example.pageObjects.TaxCalculatorPage;
import net.thucydides.core.annotations.Step;

import java.util.List;
import java.util.Map;

public class TaxCalcSteps {

    TaxCalculatorPage taxPage;

    @Step
    public void selectYear(String year) {
        taxPage.selectYear(year);
    }

    @Step
    public void enterAnnualIncome(String income) {
        taxPage.setAnnualIncome(income);
    }

    @Step
    public void chooseVisaType(String visaType) {
        taxPage.selectVisaType(visaType);
        if (visaType.contains("Part")) {
            taxPage.selecMonths("3");
        }
    }

    @Step
    public void submitDetails() {
        taxPage.clickSubmit();
    }

    @Step
    public void verifyResult(String amount) {
        taxPage.verifyResult(amount);
    }
}
