Feature: Debugging together


  Scenario: Click on the dropdown
    Given User Launch Chrome Browser
    When User open url "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard
    When User click on the dropdown
    And Click on "Customers" under the dropdown
    Then User click on the Add new button
