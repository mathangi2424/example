@AllTests @AUPost
Feature: AU Post API Tests

  Scenario Outline: Verify international courier cost
    When invoke calculate api with parcel <Weight>, <ServiceCode> and destination <Country>
    Then verify status code is 200
    And verify package <Cost> is returned

    Examples:
      | Country Name | Country | Weight | ServiceCode                  | Cost   |
      | New Zealand  | NZ      | 1.0    | INT_PARCEL_AIR_OWN_PACKAGING | 20.00  |
      | Angola       | AO      | 5.0    | INT_PARCEL_STD_OWN_PACKAGING | 135.45 |
      | ALGERIA      | DZ      | 10.0   | INT_PARCEL_EXP_OWN_PACKAGING | 235.45 |

  Scenario Outline: Verify international courier cost
    When invoke calculate api with invalid auth key, parcel <Weight>, <ServiceCode> and destination <Country>
    Then verify status code is <statuscode>

    Examples:
      | Scenario     | Country Name | Country | Weight | ServiceCode                  | Cost  | statuscode |
      | Auth Missing | New Zealand  | NZ      | 1.0    | INT_PARCEL_AIR_OWN_PACKAGING | 20.00 | 403        |

  Scenario Outline: Verify international courier cost
    When invoke calculate api with parcel <Weight>, <ServiceCode> and destination <Country>
    Then verify status code is <statuscode>

    Examples:
      | Scenario             | Country Name | Country | Weight | ServiceCode                  | Cost  | statuscode |
      | Country missing      | New Zealand  |         | 1.0    | INT_PARCEL_AIR_OWN_PACKAGING | 20.00 | 404        |
      | Weight Missing       | New Zealand  | NZ      |        | INT_PARCEL_AIR_OWN_PACKAGING | 20.00 | 404        |
      | Service code Missing | New Zealand  | NZ      | 1.0    |                              | 20.00 | 404        |
      | invalid country      | New Zealand  | USA     | 1.0    | INT_PARCEL_AIR_OWN_PACKAGING | 20.00 | 404        |
      | invalid service cod  | New Zealand  | NZ      | 1.0    | TEST                         | 20.00 | 404        |