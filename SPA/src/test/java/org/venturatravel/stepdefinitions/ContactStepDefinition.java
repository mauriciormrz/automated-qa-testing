package org.venturatravel.stepdefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.venturatravel.questions.ThanksMessage;
import org.venturatravel.tasks.Interact;
import org.venturatravel.ui.VenturaHomePage;
import org.venturatravel.utilities.utils;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.hamcrest.Matchers.containsString;
import static org.venturatravel.ui.TailorMadePage.TXT_THANKS_RESERVATION;

public class ContactStepDefinition {

    private Actor actor;
    private VenturaHomePage venturaHomePage = new VenturaHomePage();

    @Managed
    WebDriver hisBrowser;

    @Before
    public void prepareStage() {

        actor = Actor.named("Mauricio");
        actor.can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("^that (.*) browses to the url '(.*)' of the '(.*)' web site$")
    public void that_the_Traveler_browses_to_the_url_of_the_country_web_site(String nombreUsuario, String url, String countryWebsite) {

        venturaHomePage.setDefaultBaseUrl(url);
        actor.attemptsTo(Open.browserOn().the(venturaHomePage));

        venturaHomePage.surfCountryWebSite(actor);
    }

    @When("^(.*) interacts with the Helper-Component$")
    public void the_Traveler_interacts_with_the_Helper_Component(String nombreUsuario, DataTable dtDatosForm) {

        List<List<String>> data = dtDatosForm.raw();
        int i = 1;

        actor.attemptsTo(Interact.withTheHelperComponent(data, i));
    }


    @Then("^(.*) should see the '(.*)' message from the '(.*)' web site$")
    public void the_Traveler_should_see_the_Thanks_message(String nombreUsuario, String thanksMessage, String countryWebsite) {

        //if (Interact.getHelperComponent() ) {
            actor.attemptsTo(
                    WaitUntil.the(TXT_THANKS_RESERVATION, isPresent()).forNoMoreThan(30).seconds(),
                    Scroll.to(TXT_THANKS_RESERVATION));
            actor.should(seeThat("Thanks message", ThanksMessage.text(thanksMessage), containsString(ThanksMessage.selectCountry(countryWebsite))));
        //}
    }

    @After
    public void endStage() {

        utils.wait(10);
    }
}
