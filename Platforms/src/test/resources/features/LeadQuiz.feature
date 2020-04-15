Feature: Fairtrips
  As a Travel, I want to find my favourite travel experience.


  @FillOutLeadQuiz
  Scenario Outline: Fill out the main questionnaire.
    Given that the Traveler surfs to the Fairtrips web site
    When the Traveler tells us his plans <where> <how many> and <when>
    And the Traveler fill out the form

      | title | first name | Last name | email                            | Phone           |
      | Mr.   | Mauricio   | Ramirez   | automated-test@venturatravel.org | +57 300 3206240 |

    Then the Traveler should see the thanks message

    Examples:
      | Fairtrips | # | where      | how many   | when       |
      | Ecuador   | 1 | Andes      | 1          | 4 weeks    |
      |           | 2 | Coast      | 2          | 1-3 months |
      |           | 3 | Amazon     | 3+         | 4+ months  |
      |           | 4 | Don't know | Don't know | Don't know |


