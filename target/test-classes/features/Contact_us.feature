@contactus
Feature: Contact us page
  Scenario: Validate the contact us page
    Given I access the webpage
    When i enter the user name
    And last name
    And email address
    And message
    And I click on success message
    Then the success message should display

  Scenario: Validate the contact us page- specific data
    Given I access the webpage
    When i enter the user name specific joe
    And last name specifi board
    And email address specific ak@gmail.com
    And message specific "test the scenarion   "
    And I click on success message
    Then the success message should display