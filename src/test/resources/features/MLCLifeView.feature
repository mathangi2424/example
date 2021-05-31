@AllTests
Feature: MLCLifeView

  @Lifeview
  Scenario Outline: User is able to request a demo in Life View Page
    Given user is on home page
    When search "LifeView" on home page
    And click "LifeView" link from search result
    And user clicks on Request a demo button
    Then fill the form with below details
      | Name   | Company   | Email   | Phone   | Date   | Time   | Details   |
      | <Name> | <Company> | <Email> | <Phone> | <Date> | <Time> | <Details> |


    Examples:
      | Name      | Company | Email          | Phone      | Date       | Time | Details              |
      | FirstName | MLC     | first@test.com | 0411111111 | 16/10/2018 | PM   | test details entered |
      | FirstName | MLC     | first@test.com | 0411111111 | 16/10/2018 | AM   | test details entered |