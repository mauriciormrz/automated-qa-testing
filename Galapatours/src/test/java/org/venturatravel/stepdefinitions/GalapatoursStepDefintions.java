package org.venturatravel.stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.WebElementQuestion;

import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import org.venturatravel.actions.Browse;

import org.venturatravel.questions.TheLabel;
import org.venturatravel.tasks.FillOut;
import org.venturatravel.tasks.Surf;


import static java.lang.Thread.sleep;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.Matchers.equalTo;

import static org.venturatravel.ui.GalapatoursPage.*;


public class GalapatoursStepDefintions {


    private String idWindowHomePage;
    private Actor actor;

    @Managed
    WebDriver hisBrowser;

    @Before
    public void prepareStage(){

        System.out.println("prepareStage");
        actor = Actor.named("Mauricio");
        actor.can(BrowseTheWeb.with(hisBrowser));

    }

    @Given("^That Mauricio wants to find the best ships and routes$")
    public void thatMauricioWantsToFindTheBestShipsAndRoutes(){

        idWindowHomePage = getDriver().getWindowHandle();

        actor.wasAbleTo(Surf.toVenturaTravelWebSite());
        actor.attemptsTo(Browse.toNewTab(idWindowHomePage));
        actor.should(seeThat(WebElementQuestion.the(LABEL_FIND_YOUR_GALAPAGOS_CRUISE), WebElementStateMatchers.isVisible()));
    }


    @When("^he searches a cruise for (\\d+) passengers on (\\d+) (.*) (\\d+)$")
    public void heSearchesACruiseForPassengersOn(int numPassengers, int dayDeparture, String monthDeparture, int yearDeparture) {

        actor.attemptsTo(FillOut.theForm(numPassengers, dayDeparture, monthDeparture, yearDeparture));
    }


    @Then("^he should see (.*) of the Galapagos cruises$")
    public void heShouldSeeOfTheGalapagosCruises(String labelAvailabilities) throws Exception {

       actor.should(seeThat(TheLabel.is(), equalTo(labelAvailabilities)));
    }


    @After
    public void endStage(){

        System.out.println("endStage");
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
