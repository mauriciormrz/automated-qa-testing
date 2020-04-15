Feature: Switch User
  As a Admin of Ventura Travel, I want to switch user and switch user back into the new GO platform.


  Background:
    Given that the Admin navigates to the homepage of the New GO platform
    When he enters his user 'mauricio.ramirez@venturatravel.org' and password 'M@uricio69'

  @SwitchUser
  Scenario Outline: Switch user on the new GO platform.
    Given that the Admin changes to the user '<switch user>' with email '<email>'
    When he should see the profile name '<switch user>'
    Then he switches user back
    And he should see the profile name '<user>'

    Examples:
      | New GO   | user                      | switch user       | email                       |
      | Platform | Mauricio Ramirez Restrepo | Franziska Umlauft | franziska@venturatravel.org |

