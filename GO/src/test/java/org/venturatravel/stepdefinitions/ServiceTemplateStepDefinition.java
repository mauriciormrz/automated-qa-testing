package org.venturatravel.stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.venturatravel.questions.ServiceTemplateDelete;
import org.venturatravel.questions.ServiceTemplateExists;
import org.venturatravel.tasks.Create;
import org.venturatravel.tasks.Delete;
import org.venturatravel.ui.ServiceTemplatePage;
import org.venturatravel.utilities.utils;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static org.hamcrest.Matchers.containsString;
import static org.venturatravel.ui.ServiceTemplatePage.ICON_NEW_TEMPLATE;

public class ServiceTemplateStepDefinition {

    private Actor actor;
    ServiceTemplatePage serviceTemplatePage = new ServiceTemplatePage();

    @Managed
    WebDriver hisBrowser;

    @Before
    public void prepareStage() {

        actor = Actor.named("Mauricio");
        actor.can(BrowseTheWeb.with(hisBrowser));
    }

    @When("^(.*) creates the new service template '(.*)'$")
    public void the_Travel_Specialist_creates_the_new_service_template(String userType, String serviceTemplateName) {

        actor.has(Create.newServiceTemplate(serviceTemplateName));
        actor.should(seeThat(ServiceTemplateExists.itWasCreated(serviceTemplateName)));
    }

    @Then("^(.*) deletes the new service template '(.*)'$")
    public void the_Travel_Specialist_deletes_the_new_service_template(String userType, String serviceTemplateName) {

        actor.attemptsTo(
                WaitUntil.the(ICON_NEW_TEMPLATE, isClickable()).forNoMoreThan(30).seconds(),
                Delete.serviceTemplate(serviceTemplateName)
        );
        actor.should(seeThat(ServiceTemplateDelete.message(), containsString("template deleted successfully")));
    }


    @After
    public void endStage() {

        utils.wait(500);
    }
}
