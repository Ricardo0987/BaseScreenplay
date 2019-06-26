Feature: Clara Birthday
  Megan wants to buy the most expensive dress to clear on the page http://automationpractice.com/index.php

  @TestCase1
  Scenario: TestCase1 - show proof after login and bought more expensive dress

    Given Megan enters the commerce page and register with user 'user' and password 'pass'
    When  Megan buys the dress
    Then  Megan should see the voucher generated

  @TestCase2
  Scenario: TestCase2 - show proof after login and bought more expensive dress

    Given Megan enters the commerce page and logs with user 'user' and password 'pass'
    When  Megan buys the dress
    Then  Megan should see the voucher generated

  @TestCase3
  Scenario: TestCase3 - show error after login without registration

#    Given Megan enters the commerce page and logs with user 'user' and password 'pass'
    Then  Megan should see the error message

