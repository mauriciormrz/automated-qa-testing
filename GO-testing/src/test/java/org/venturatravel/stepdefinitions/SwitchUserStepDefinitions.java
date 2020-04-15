package org.venturatravel.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.venturatravel.tasks.SwitchUser;


public class SwitchUserStepDefinitions {

    private Actor actor;

    @Managed
    WebDriver hisBrowser;

    @Before
    public void prepare_stage() {

        actor = Actor.named("Mauricio");
        actor.can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("^that (.*) changes to the user '(.*)' with email '(.*)'$")
    public void the_Admin_changes_to_the_user(String actorName, String switchUser, String email) {

        actor.has(SwitchUser.named(switchUser + " :::  "+ email));
    }

    @Then("^s?he switches user back$")
    public void he_switches_user_back() {

        actor.has(SwitchUser.back());
    }

    @After
    public void end_stage() {

        //System.out.println("end_stage");
        //utils.wait(10);
    }
}

