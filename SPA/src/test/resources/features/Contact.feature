Feature: Contact with a Tour Operator
  As a web user, I want to contact  for a group or individual trip with one of the different
  tour operators (Viventura, Puraventura, Japaventura, Persiaventura, Chinaventura and Grekaventura)


  @TravelSpecialist
  Scenario Outline: Contact the Travel Specialist
    Given that the Traveler browses to the url '<URL>' of the '<Country>' web site
    When the Traveler interacts with the Helper-Component

      | Name     | Last name | email                            |
      | Mauricio | Ramirez   | automated-test@venturatravel.org |

    Then the Traveler should see the 'THANKS_MESSAGE_CONTACT' message from the '<Country>' web site

    Examples:
      | #  | Tour Operator | Country | URL                               |
      | 1  | Viventura     | Germany | https://staging.viventura.de/     |
      | 2  | Viventura     | France  | https://staging.viventura.fr/     |
      | 3  | Puraventura   | Germany | https://staging.puraventura.de/   |
      | 4  | Puraventura   | France  | https://staging.puraventura.fr/   |
      | 5  | Japaventura   | Germany | https://staging.japaventura.de/   |
      | 6  | Japaventura   | France  | https://staging.japaventura.fr/   |
      | 7  | Persiaventura | Germany | https://staging.persiaventura.de/ |
      | 8  | Persiaventura | France  | https://staging.persiaventura.fr/ |
      | 9  | Chinaventura  | Germany | https://staging.chinaventura.de/  |
      | 10 | Chinaventura  | France  | https://staging.chinaventura.fr/  |
      | 11 | Grekaventura  | Germany | https://staging.grekaventura.de/  |
      | 12 | Grekaventura  | France  | https://staging.grekaventura.fr/  |
      | 13 | Miaventura    | Germany | https://staging.miaventura.de/    |
