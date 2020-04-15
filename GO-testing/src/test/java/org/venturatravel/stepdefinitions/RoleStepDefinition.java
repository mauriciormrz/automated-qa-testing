package org.venturatravel.stepdefinitions;



import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;


import org.openqa.selenium.WebDriver;
import org.venturatravel.questions.GoUsersRoles;
import org.venturatravel.tasks.AddARole;
import org.venturatravel.tasks.DeleteARole;
import org.venturatravel.tasks.EditTheGoUser;

import static java.util.function.Predicate.isEqual;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.venturatravel.tasks.EditTheGoUser.getNumberOfRoles;


public class RoleStepDefinition {

    private Actor actor;

    @Managed
    WebDriver hisBrowser;

    @Before
    public void prepare_stage() {

        actor = Actor.named("Mauricio");
        actor.can(BrowseTheWeb.with(hisBrowser));
    }

    @When("^that (.*) edits the '(.*)' info$")
    public void the_actor_edits_the_user_info(String actorName, String goUser) {

        actor.attemptsTo(EditTheGoUser.info(goUser));
    }


    @When("^s?he adds a new role '(.*)'$")
    public void add_a_new_role(String role) {

        actor.attemptsTo(AddARole.called(role));
    }


    @Then("^s?he verifies the new number of roles$")
    public void the_actor_verifies_the_new_number_of_roles() {

       // actor.should(seeThat("Record update successfully", GoUsersRoles.amount(), isEqual(getNumberOfRoles())));
    }


    @When("^s?he deletes the role '(.*)'$")
    public void delete_the_role_and_see_the_message(String role) {

        actor.attemptsTo(DeleteARole.called(role));
    }


    @After
    public void end_stage() {

        //System.out.println("end_stage");
        //utils.wait(1500);
    }
}

