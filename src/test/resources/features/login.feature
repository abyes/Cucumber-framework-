@login
  Feature: to validate login page
    Scenario: to validate successfull popup message
      Given I access the login page
      When user enter username "webdriver"
      And passoword webdriver123
      And click on submit button
      Then the success message should validate