@login @vyt-111
Feature: Login
  Agile story:
  As a user,
  when I enter valid login credentials
  I should be able to see the dashboard page

  @smoke @driver
  Scenario: Login as driver
    Given I am on the login page
    When I login as a driver
    Then I should be able to see the dashboard page

  @smoke @sales
  Scenario: Login as a sales manager
    Given I am on the login page
    When I login as a sales manager
    Then I should be able to see the dashboard page

  @store @database
  Scenario: Login as a store manager
    Given I am on the login page
    When I login as a store manager
    Then I should be able to see the dashboard page


