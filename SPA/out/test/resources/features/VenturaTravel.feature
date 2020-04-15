Feature: Browse to the different brands
  As a web user, I want to surf to the countries web sites of the different tour operators:
  Viventura, Puraventura, Japaventura, Persiaventura, Chinaventura and Grekaventura.


  @VenturaTRAVEL
  Scenario Outline: Browsing the web site of the tour operator
    Given that the Traveler wants to travel with Ventura TRAVEL
    When the Traveler surfs to the '<country>' web site of the '<tour operator>'
    Then the Traveler should see the url '<url>' of the '<tour operator>' and '<country>' web site

    Examples:
      | #  | Description     | tour operator | country | url                               |
      | 1  | South America   | Viventura     | Germany | https://staging.viventura.de/     |
      | 2  | South America   | Viventura     | France  | https://staging.viventura.fr/     |
      | 3  | Central America | Puraventura   | Germany | https://staging.puraventura.de/   |
      | 4  | Central America | Puraventura   | France  | https://staging.puraventura.fr/   |
      | 5  | Asia            | Japaventura   | Germany | https://staging.japaventura.de/   |
      | 6  | Asia            | Japaventura   | France  | https://staging.japaventura.fr/   |
      | 7  | Asia            | Persiaventura | Germany | https://staging.persiaventura.de/ |
      | 8  | Asia            | Persiaventura | France  | https://staging.persiaventura.fr/ |
      | 9  | Asia            | Chinaventura  | Germany | https://staging.chinaventura.de/  |
      | 10 | Asia            | Chinaventura  | France  | https://staging.chinaventura.fr/  |