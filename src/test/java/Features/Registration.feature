Feature: Registration
  As a user
  I want to register on the website
  So that I can access the website's features

#  Note : The ID's are from assumptions

  Scenario Valid Registration
    Given I am on the registration page
    When I enter valid registration details
    And I click the submit button
    Then I should see a success message


  Scenario Registration with Newsletter Subscription
    Given I am on the registration page
    When I enter valid registration details with newsletter subscription
    And I click the submit button
    Then I should see a success message

