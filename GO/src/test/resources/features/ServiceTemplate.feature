Feature: Service Template
  As a Travel Specialist of Ventura Travel, I want to work with Service Templates.

  @NewServiceTemplate
  Scenario Outline: Create and delete a new Service Template.
    #Given that the TS '<user>' has the role 'SENIOR' into the '<url>' GO platform with user '<email>' and password '<password>'
    And the TS '<user>' logs into the '<url>' GO platform with user '<email>' and password '<password>'
    When the TS creates the new service template '<service template>'
    Then the TS deletes the new service template '<service template>'

    Examples:
      | Platform | user             | email                              | password   | url                                        | service template |
      | New GO   | Mauricio Ramirez | mauricio.ramirez@venturatravel.org | M@uricio69 | https://go-staging.venturatravel.org/login | QA_test          |