package org.venturatravel.stepdefinitions;


import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;

import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.venturatravel.questions.TheServiceTemplates;
import org.venturatravel.tasks.CreateAServiceTemplate;


import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

import static org.hamcrest.Matchers.hasItem;



public class ServiceTemplateStepDefinitions {

    private Actor actor;

    @Managed
    WebDriver hisBrowser;

    @Before
    public void prepare_stage() {

        actor = Actor.named("Mauricio");
        actor.can(BrowseTheWeb.with(hisBrowser));
    }


    @When("^that (.*) creates the template '(.*)'$")
    public void that_the_actor_creates_the_template(String actorName, String serviceTemplateName) {

        actor.attemptsTo(CreateAServiceTemplate.named(serviceTemplateName));
    }


    @And("^'(.*)' should be recorded in (?:his|her) template list$")
    public void should_be_recorded_in_his_list(String templateName) throws Exception {

        actor.should(seeThat(
                "The Template displayed", TheServiceTemplates.displayed(), hasItem(templateName)
        ));
    }

    @Then("^that (.*) deletes the template '(.*)'$")
    public void he_deletes_the_template(String actorName, String serviceTemplateName) {


        //actor.attemptsTo(DeleteAServiceTemplate.called(templateName));
        //actor.should(seeThat(ServiceTemplateDelete.message(), containsString("template deleted successfully")));
    }

}