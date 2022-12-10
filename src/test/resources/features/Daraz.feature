Feature: Daraz add to cart
  Scenario: User should added something in cart of daraz
    Given User is on daraz URL
    When User clicks on add to cart button
    Then product added in cart