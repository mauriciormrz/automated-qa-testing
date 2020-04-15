Feature: Sign in to the new GO platform
  As a vMember of Ventura Travel, I want to login into the new GO platform.

  @LoginSuccessful
  Scenario Outline: Login correctly into the new GO platform.
    Given that the vMember logs into the '<url>' GO platform
    When the vMember wants to enter with his user '<email>' and password '<password>'
    Then the vMember can see the user name '<user>' of the account
    And the vMember log outs

    Examples:
      | New GO   | user                      | email                              | password   | url                                        |
      | Platform | Mauricio Ramirez Restrepo | mauricio.ramirez@venturatravel.org | M@uricio69 | https://go-staging.venturatravel.org/login |

  @LoginFailed
  Scenario Outline: Login failed on the new GO platform.
    Given that the vMember logs into the '<url>' GO platform
    When the vMember wants to enter with his user '<email>' and password '<password>'
    Then the vMember see an error message with the text Error: Error: Request failed with status code 401

    Examples:
      | New GO   | email                              | password    | url                                        |
      | Platform | mauricio.ramirez@venturatravel.org | M@uricio69_ | https://go-staging.venturatravel.org/login |