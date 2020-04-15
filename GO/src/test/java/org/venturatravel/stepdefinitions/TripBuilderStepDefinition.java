package org.venturatravel.stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import org.venturatravel.domain.TravelSpecialist;


import org.venturatravel.tasks.*;
import org.venturatravel.utilities.utils;


public class TripBuilderStepDefinition {

    private Actor actor;
    private static int reg = 0;

    @Steps(shared = true)
    TravelSpecialist ts;

    @Managed
    WebDriver hisBrowser;

    @Before
    public void prepareStage() {

        actor = Actor.named("Mauricio");
        actor.can(BrowseTheWeb.with(hisBrowser));

    }

    @Given("^(.*) selects the type of trip (.*)$")
    public void the_TS_selects_the_type_of_trip_Groups(String userType, String tripType) {

        actor.attemptsTo(SelectThe.tripType(tripType));
    }

    @When("^s?he enters the trip details of the name (.*)$")
    public void he_enters_the_trip_details_of_the_name_(String trip_Name) {

        actor.attemptsTo(FillOutThe.tripName(trip_Name));
    }

    @And("^s?he selects the market (.*)$")
    public void he_selects_the_market(String market) {

        actor.attemptsTo(ChooseThe.market(market));
    }


    @When("^s?he also enters the duration of the trip (\\d+) and the minimum (\\d+) and maximum (\\d+) size of the groups$")
    public void he_also_enters_the_duration_of_the_trip_and_the_minimum_and_maximum_size_of_the_groups(int total_days, int min_pax, int max_pax) {

        actor.attemptsTo(CompleteThe.detailSection(total_days, min_pax, max_pax));
    }

    @And("^adds? other fields like (.*), (.*), (.*), (.*), (.*), (\\d+), (.*) and (.*)$")
    public void other_fields_like(String trip_code, String start_destination, String end_destination,  String guidance_type, String trip_category, int average_cost, String meal_comments, String general_comments) {

        actor.attemptsTo(AddInfoTo.theTripDetailsForm(trip_code, start_destination, end_destination, guidance_type, trip_category, average_cost, meal_comments, general_comments));
    }


    @And("^including the host (.*) field and length (.*)$")
    public void including_the_host_field(String host, String length) {

        actor.attemptsTo(CompletePlatforms.detailsForm(host, length));
    }



    @And("^continue with the next step$")
    public void continue_with_the_next_step() {

        actor.attemptsTo(ContinueWith.theNextStep());
    }

    @After
    public void endStage() {

        utils.wait(100);
    }


}

/*

  Background:
    Given the TS 'Mauricio Ramirez Restrepo' logs into the 'https://go-staging.venturatravel.org' GO platform with user 'mauricio.ramirez@venturatravel.org' and password 'M@uricio69'

  @CreationTripBuilderPlatform
  Scenario Outline: Create a new Trip Builder for Groups
    Given the TS selects the type of trip <type_trip>
    When he enters the trip details of the name <trip_name>
    And he also enters the duration of the trip <total_days> and the minimum <min_pax> and maximum <max_pax> size of the groups
    And including the host <host> field
    And continue with the next step

    Examples:
      | id | type_trip | trip_name | min_pax | max_pax | total_days | host |
      | 1  | platform  | Colombia  | 16      | 20      | 15         | host |




 */