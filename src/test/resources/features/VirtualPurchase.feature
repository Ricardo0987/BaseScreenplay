Feature: Clara Birthday
  Megan wants to buy the most expensive dress to clear on the page http://automationpractice.com/index.php

  @TestCase1
  Scenario: TestCase1 - show proof after authenticate and bought more expensive dress with register user

    Given enters the commerce page and authenticate using data index <1> from <VirtualPurchase> file
    When  buys the dress
    Then  should see the voucher generated

  @TestCase2
  Scenario: TestCase2 - show proof after authenticate and bought more expensive dress with unregister user

    Given enters the commerce page and authenticate using data index <2> from <VirtualPurchase> file
    When  buys the dress
    Then  should see the voucher generated

  @TestCase3
  Scenario: TestCase3 - show error after login without registration
    Given enters the commerce page and authenticate using data index <3> from <VirtualPurchase> file
    Then  should see the error message

