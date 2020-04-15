Feature: Switch User
  As a Admin of Ventura Travel, I want to switch user and switch user back into the new GO platform.

  @SwitchUser
  Scenario Outline: Switch user on the new GO platform.
    Given that the Admin '<user>' logs into the '<url>' GO platform with user '<email>' and password '<password>'
    When the Admin changes the user '<switch user>' and sees the name of the new user on the profile page
    Then the Admin switch user back and see the name of the previous user '<user>' on the profile page

    Examples:
      | New GO   | user             | email                              | password   | url                                        | switch user       |
      | Platform | Mauricio Ramirez | mauricio.ramirez@venturatravel.org | M@uricio69 | https://go-staging.venturatravel.org/login | Franziska Umlauft |