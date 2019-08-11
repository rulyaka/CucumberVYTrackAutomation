Feature: Navigation menu options
  Scenario: Go to Fleet, Vehicles as a driver
    Given I login as a "driver"
    When I navigate to "Fleet" "Vehicles"
    Then the page tile should be "Car - Entities - System - Car - Entities - System"
  @navigation
  Scenario: Go to Fleet, Vehicles as a sales manager
    Given I login as a "sales manager"
    When I navigate to "Fleet" "Vehicles"
    Then the page tile should be "All - Car - Entities - System - Car - Entities - System"
    And default page number should be 1