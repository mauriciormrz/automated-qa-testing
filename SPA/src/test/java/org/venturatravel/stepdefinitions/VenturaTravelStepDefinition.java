package org.venturatravel.stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.venturatravel.questions.CurrentUrl;
import org.venturatravel.tasks.Browse;
import org.venturatravel.tasks.Surf;
import org.venturatravel.ui.VenturaHomePage;
import org.venturatravel.utilities.utils;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.Matchers.containsString;

public class VenturaTravelStepDefinition {

    private Actor actor;
    private String idWindowHomePage;
    private VenturaHomePage venturaHomePage = new VenturaHomePage();
    private CurrentUrl theCurrentUrl = new CurrentUrl();

    @Managed
    WebDriver hisBrowser;

    @Before
    public void prepareStage() {

        actor = Actor.named("Mauricio");
        actor.can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("^that (.*) wants to travel with Ventura TRAVEL$")
    public void that_the_traveler_wants_to_travel_with_Ventura_TRAVEL(String nombreUsuario) {

        idWindowHomePage = getDriver().getWindowHandle();
        actor.attemptsTo(Open.browserOn(venturaHomePage));
    }


    @When("^(.*) surfs to the '(.*)' web site of the '(.*)'$")
    public void the_traveler_surfs_to_the_country_website_of_the_tour_operator(String nombreUsuario, String countryWebsite, String tourOperator) {

        actor.wasAbleTo(Surf.toVenturaTravelWebSite(tourOperator));
        actor.attemptsTo(Browse.toNewTab(countryWebsite, tourOperator, idWindowHomePage));
    }



    @Then("^(.*) should see the url '(.*)' of the '(.*)' and '(.*)' web site$")
    public void the_traveler_should_see_the_url_of_the_tour_operator_and_country_website(String nombreUsuario, String url, String tourOperator, String countryWebsite) {

        actor.should(seeThat(theCurrentUrl, containsString(theCurrentUrl.landingPage(countryWebsite, tourOperator))));
    }

    @After
    public void endStage() {

        utils.wait(2);
    }
}
