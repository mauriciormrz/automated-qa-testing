package org.venturatravel.stepdefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.venturatravel.questions.CurrentUrl;
import org.venturatravel.questions.ThanksMessage;
import org.venturatravel.tasks.*;
import org.venturatravel.ui.VenturaHomePage;


import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.hamcrest.Matchers.containsString;
import static org.venturatravel.constants.Constants.THANKS_MESSAGE_RESERVATION;
import static org.venturatravel.ui.CountryLandingPage.*;
import static org.venturatravel.ui.HomeLandingPage.*;

import static org.venturatravel.ui.VenturaHomePage.*;


public class ReservationStepDefinition {


    private Actor actor;
    private CurrentUrl theCurrentUrl = new CurrentUrl();
    private VenturaHomePage venturaHomePage = new VenturaHomePage();
    private Boolean waitingList;
    private Boolean departures;

    @Managed
    WebDriver hisBrowser;

    @Before
    public void prepareStage() {

        System.out.println("prepareStage");
        actor = Actor.named("Mauricio");
        actor.can(BrowseTheWeb.with(hisBrowser));
    }


    @Given("^that (.*) browses to the url '(.*)' of the '(.*)' web site of the '(.*)' and selects the best-selling trip with Established Brand: (.*)$")
    public void that_the_Traveler_browses_to_the_url_of_the_country_web_site_of_the_tour_operator_and_selects_the_best_selling_trip(String nombreUsuario, String url, String countryWebsite, String tourOperator, String establishedBrand) {

        venturaHomePage.setDefaultBaseUrl(url);
        actor.attemptsTo(Open.browserOn().the(venturaHomePage));

        venturaHomePage.surfCountryWebSite(actor);

        actor.attemptsTo(
                Scroll.to(LNK_BEST_SELLING_TRIP),
                Click.on(LNK_BEST_SELLING_TRIP));

        if (establishedBrand.equals("No")) {
            actor.attemptsTo(
                    Click.on(BTN_NO_PARTICIPATION)
            );
        }
    }


    @When("^(.*) completes the web forms to book the trip on the '(.*)' web site$")
    public void the_Traveler_completes_the_web_forms_to_book_the_trip_on_the_country_web_site(String nombreUsuario, String countryWebsite, DataTable dtDatosForm) {

        List<List<String>> data = dtDatosForm.raw();
        int i = 1;

        actor.attemptsTo(
                Scroll.to(DATES_AND_PRICES),
                Click.on(DATES_AND_PRICES)
        );

        actor.attemptsTo(Select.theDeparture());
        departures = Select.isDepartures();

        if (departures) {
            waitingList = Select.isWaitingList();

            if (!waitingList) {
                actor.attemptsTo(FillOut.theTripDetails(countryWebsite, data, i));
                actor.attemptsTo(FillOut.personalInformation());

            } else {
                actor.attemptsTo(FillOut.contactInformation(countryWebsite, data, i));

            }
        }
    }

    @Then("^(.*) should see the summary reservation and check the trip on the '(.*)' web site$")
    public void the_Traveler_should_see_the_summary_reservation_and_check_the_trip_ont_the_country_web_site(String nombreUsuario, String countryWebsite) {

        if (departures) {
            if (!waitingList) {

                actor.attemptsTo(Check.theSummary(Select.getDepartureDates(), Select.getDeparturePrice()));
                actor.attemptsTo((Check.booking(countryWebsite)));
            } else {

                actor.should(seeThat("Thanks message", ThanksMessage.text(THANKS_MESSAGE_RESERVATION), containsString(ThanksMessage.selectCountry(countryWebsite))));
            }
        }
    }


    @Given("^that (.*) surfs to the tailor made trip page through the url '(.*)' of the '(.*)' web site of the '(.*)'$")
    public void that_the_Traveler_surfs_to_the_tailor_made_trip_page_through_the_url_of_the_web_site_of_the_tour_operator(String nombreUsuario, String url, String countryWebsite, String tourOperator) {

        actor.has(Decided.toSurfToTailorMadeTripPage(url, countryWebsite, tourOperator));
        actor.should(seeThat(theCurrentUrl, containsString(theCurrentUrl.tripLandingPage(countryWebsite))));
    }

    @When("^(.*) selects his trip preferences$")
    public void the_Traveler_selects_his_trip_preferences(String nombreUsuario, DataTable dtDatosForm) {

        List<List<String>> data = dtDatosForm.raw();
        int i = 1;

        actor.attemptsTo(Setup.hisTrip(data, i));
    }

    @After
    public void endStage() {

        System.out.println("endStage");
        //utils.wait(200);
    }
}


//document.querySelector("#trip1 .HighlightTrip__ImgShadow-bLzCpa").click();

// https://my.pingdom.com/newchecks/transactions#check=t82578
//it@viventura.de
//BfSfCBeRMBeUs2014
