Feature: Clara Birthday
  Megan wants to buy the most expensive dress to clear on the page http://automationpractice.com/index.php

  @TestCase1
  Scenario: TestCase1 - SuccessfulCase; show proof after login and bought more expensive dress

    Given Megan enters the commerce page and register with user <user> and password <pass>
    When  Megan buys the dress
    Then  Megan should see the voucher generated

  @TestCase2
  Scenario: TestCase2 - SuccessfulCase; show proof after login and bought more expensive dress

    Given Megan enters the commerce page and logs with user <user> and password <pass>
    When  Megan buys the dress
    Then  Megan should see the voucher generated

