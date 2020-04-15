Feature: Reservation with a Tour Operator
  As a web user, I want to making a reservation  for a group or individual trip with one of the different
  tour operators (Viventura, Puraventura, Japaventura, Persiaventura, Chinaventura and Grekaventura)

  @BestsellerTrip
  Scenario Outline: Making a Reservation for a Bestseller Trip
    Given that the Traveler browses to the url '<URL>' of the '<Country>' web site of the '<Tour Operator>' and selects the best-selling trip with Established Brand: <Established Brands>
    When the Traveler completes the web forms to book the trip on the '<Country>' web site

      | Gender | Name     | Last name | email                            | Phone          |
      | Male   | Mauricio | Ramirez   | automated-test@venturatravel.org | +5743003206240 |

    Then the Traveler should see the summary reservation and check the trip on the '<Country>' web site

    Examples:
      | #  | Established Brands | Tour Operator | Country | URL                               |
      | 1  | Yes                | Viventura     | Germany | https://staging.viventura.de/     |
      | 2  | Yes                | Viventura     | France  | https://staging.viventura.fr/     |
      | 3  | No                 | Puraventura   | Germany | https://staging.puraventura.de/   |
      | 4  | Yes                | Puraventura   | France  | https://staging.puraventura.fr/   |
      | 5  | No                 | Japaventura   | Germany | https://staging.japaventura.de/   |
      | 6  | No                 | Japaventura   | France  | https://staging.japaventura.de/   |
      | 7  | No                 | Persiaventura | Germany | https://staging.persiaventura.de/ |
      | 8  | No                 | Persiaventura | France  | https://staging.persiaventura.fr/ |
      | 9  | No                 | Chinaventura  | Germany | https://staging.chinaventura.de/  |
      | 10 | No                 | Chinaventura  | France  | https://staging.chinaventura.fr/  |
      | 11 | No                 | Grekaventura  | Germany | https://staging.grekaventura.de/  |
      | 12 | No                 | Grekaventura  | France  | https://staging.grekaventura.fr/  |
      | 13 | No                 | Miaventura    | Germany | https://staging.miaventura.de/    |


  @TailorMadeRequest
  Scenario Outline: Request Tailor Made Trip
    Given that the Traveler surfs to the tailor made trip page through the url '<URL>' of the '<Country>' web site of the '<Tour Operator>'
    When the Traveler selects his trip preferences

      | Name     | Last name | email                            |
      | Mauricio | Ramirez   | automated-test@venturatravel.org |

    Then the Traveler should see the 'THANKS_MESSAGE_RESERVATION' message from the '<Country>' web site

    Examples:
      | # | Tour Operator | Country | URL                           |
      | 1 | Viventura     | Germany | https://staging.viventura.de/ |
      | 2 | Viventura     | France  | https://staging.viventura.fr/ |

