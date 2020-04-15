Feature: Trip Builder

  As a TS
  I want to build a trip using previously created services
  so that I can visualize the trip with its services in a timeline

  Background:
    Given the TS 'Mauricio Ramirez Restrepo' logs into the 'https://go-staging.venturatravel.org' GO platform with user 'mauricio.ramirez@venturatravel.org' and password 'M@uricio69'


  @CreationTripBuilderGroups
  Scenario Outline: Create a new Trip Builder for Groups
    Given the TS selects the type of trip <type_trip>
    When he enters the trip details of the name <trip_name>
    And he selects the market <market>
    And he also enters the duration of the trip <total_days> and the minimum <min_pax> and maximum <max_pax> size of the groups
    And adds other fields like <trip_code>, <start_destination>, <end_destination>, <guidance_type>, <trip_category>, <average_cost>, <meal_comments> and <general_comments>
    And continue with the next step

    Examples:
      | id | type_trip | trip_name | market | trip_code | start_destination | end_destination | min_pax | max_pax | total_days | guidance_type     | trip_category | average_cost | meal_comments | general_comments |
      | 1  | group     | Peru      | de_DE  | trip code | Adicora           | Ahuano          | 16      | 20      | 15         | TC the whole trip | Explorer      | 312          | Delicious     | Good trip        |

  @CreationTriBuilderTailor-Made
  Scenario Outline: Create a new Trip Builder for Tailor-Made
    Given the TS selects the type of trip <type_trip>
    When he enters the trip details of the name <trip_name>
    And he selects the market <market>
    And continue with the next step


    Examples:
      | id | type_trip  | trip_name | market |
      | 1  | individual | Ecuador   | fr_FR  |

  @CreationTripBuilderPlatform
  Scenario Outline: Create a new Trip Builder for Groups
    Given the TS selects the type of trip <type_trip>
    When he enters the trip details of the name <trip_name>
    And including the host <host> field and length <length>
    And continue with the next step

    Examples:
      | id | type_trip | trip_name | length | host    |
      | 1  | platform  | Colombia  | 2      | Alibaba |
