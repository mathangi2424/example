@AllTests
Feature: Ato Tax Calculator

  @taxCalculator
  Scenario Outline: User is able to calculate tax based on anual income, year and visa type
    Given a user in tax calculator page selects <Year>
    When enters annual <Income> and <visaType>
    And clicks submit
    Then calculator displays the estimated <taxableIncome>

    Examples:
      | Year    | Income | visaType                   | taxableIncome |
      | 2019-20 | 200000 | Resident for full year     | $63,097.00    |
      | 2018-19 | 200000 | Non-resident for full year | $71,550.00    |
      | 2017-18 | 200000 | Part-year resident         | $63,906.88    |