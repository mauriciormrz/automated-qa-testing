package org.venturatravel.stepdefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.venturatravel.questions.ThanksMessage;
import org.venturatravel.tasks.FillOut;
import org.venturatravel.tasks.Surf;
import org.venturatravel.tasks.TellUs;
import org.venturatravel.utilities.utils;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.Matchers.*;

public class LeadQuizStepDefinition {

    private Actor actor;

    @Managed
    WebDriver hisBrowser;



    @Before
    public void prepareStage() {

        System.out.println("prepareStage");
        actor = Actor.named("Mauricio");

        actor.can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("^that (.*) surfs to the Fairtrips web site$")
    public void that_the_Traveler_browses_to_the_Fairtrips_web_site(String nombreUsuario) {

        actor.wasAbleTo(Surf.toHomePage());
    }

    @When("^(.*) tells us his plans (.*) (.*) and (.*)$")
    public void the_Traveler_tells_us_his_plans(String nombreUsuario, String where, String how_many, String when) {

        actor.attemptsTo(TellUs.thePlans(where, how_many, when));
    }

    @When("^(.*) fill out the form$")
    public void the_Traveler_fill_out_the_form(String nombreUsuario, DataTable dtDatosForm) {

        List<List<String>> data = dtDatosForm.raw();
        int i = 1;

        actor.attemptsTo(FillOut.theForm(data, i));
    }

    @Then("^(.*) should see the thanks message$")
    public void the_Traveler_should_see_the_thanks_message(String nombreUsuario) {

        actor.should(seeThat("Thanks message", ThanksMessage.text(), equalTo("Thank you! What's next?")));
    }

    @After
    public void endStage() {

        System.out.println("endStage");
    }
}
