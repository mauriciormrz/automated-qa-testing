Feature: Sign in to the new GO platform
  As a vMember of Ventura Travel, I want to login into the new GO platform.


 @LoginSuccessful
 Scenario Outline: Login into the new GO platform.
   Given that the Go User navigates to the homepage of the New GO platform
   When he enters his user '<email>' and password '<password>'
   Then he should see the profile name '<user name>'
   And he log outs

   Examples:
     | New GO   | user name                 | email                              | password   |
     | Platform | Mauricio Ramirez Restrepo | mauricio.ramirez@venturatravel.org | M@uricio69 |


 @LoginFailed
 Scenario Outline: Login failed on the new GO platform.
   Given that the vMember navigates to the homepage of the New GO platform
   When he enters his user '<email>' and password '<password>'
   Then he should see an error message with the text Error: Error: Request failed
   Examples:
     | New GO   | email                              | password    |
     | Platform | mauricio.ramirez@venturatravel.org | M@uricio69_ |