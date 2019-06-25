@E2E_WEB_SITE_EXTERIOR
@AuthenticateTransaction

Feature: Filiales WEB Site Authenticate
  A person must be able to access the Filiales Exterior - Bancolombia WEB Site and authenticate with credentials.

  @TestCase1
  Scenario Outline: TestCase1 - Successful access to the Filiales WEB Site

    Given I Upload the Transaction Data <index> of file <fileName> and browser <browser>
    When  I try to authenticate myself using my credentials
    Then can see the dashboard

    Examples:
      | index | fileName     | browser |
      | 1     | authenticate | chrome  |


  @TestCase2
  Scenario Outline: TestCase2 - Show error message when i try validate document to the Filiales WEB Site with invalid document

    Given I Upload the Transaction Data <index> of file <fileName> and browser <browser>
    When  I try to authenticate myself using my credentials
    Then I should see form error message

    Examples:
      | index | fileName     | browser |
      | 2     | authenticate | chrome  |

