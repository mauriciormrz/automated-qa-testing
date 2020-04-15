package org.venturatravel.stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.venturatravel.questions.GoUsersRoles;
import org.venturatravel.questions.RecordUpdate;
import org.venturatravel.tasks.GoUsers;
import org.venturatravel.utilities.utils;

import java.util.function.Predicate;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isPresent;
import static org.hamcrest.Matchers.containsString;
import static org.venturatravel.constants.Constants.RECORD_UPDATE_SUCCESSFULLY_MSG;
import static org.venturatravel.ui.GoUsersPage.*;

public class RoleStepDefinition {

    private Actor actor;
    private int previous_roles_count;
    private boolean rolExist;

    @Managed
    WebDriver hisBrowser;

    @Before
    public void prepareStage() {

        actor = Actor.named("Mauricio");
        actor.can(BrowseTheWeb.with(hisBrowser));
    }

    @When("^(.*) edits the '(.*)' info$")
    public void the_Admin_edits_the_vMember_info(String userName, String vMember) {

        actor.attemptsTo(GoUsers.toEdit(vMember));
        previous_roles_count = GoUsers.getRoles_count();
    }

    @When("^add the role '(.*)' and see the message '(.*)'$")
    public void add_the_role_and_see_the_message(String role, String message) {

        actor.attemptsTo(GoUsers.toAdd(role, message));
        rolExist = GoUsers.getRolExist();

        if (!rolExist) {
            actor.should(seeThat("Record updated successfully", RecordUpdate.message(), containsString(message)));
        }
        actor.attemptsTo(
                Scroll.to(LNK_BACK),
                Click.on(LNK_BACK)
        );
    }

    @When("^(.*) performs the (.*) to the '(.*)' of the '(.*)$")
    public void the_Admin_perfoms_the_operation_to_the_role(String userName, String operation, String role, String vMember) {

        actor.attemptsTo(GoUsers.toEdit(vMember));
        previous_roles_count = GoUsers.getRoles_count();

        actor.attemptsTo(GoUsers.toAdd(role, RECORD_UPDATE_SUCCESSFULLY_MSG));
        rolExist = GoUsers.getRolExist();

    }

    @Then("^(.*) verify the operation (.*)$")
    public void the_Admin_verify_the_operation(String userName, String operation) {

        if (!rolExist) {
            actor.should(seeThat("Record updated successfully", RecordUpdate.message(), containsString(RECORD_UPDATE_SUCCESSFULLY_MSG)));
        }
        actor.attemptsTo(
                Scroll.to(LNK_BACK),
                Click.on(LNK_BACK)
        );

        if (rolExist) {
            actor.should(seeThat("Record exists previously", GoUsersRoles.count(), Predicate.isEqual(previous_roles_count)));
        } else {
            actor.should(seeThat("Record add successfully", GoUsersRoles.count(), Predicate.isEqual(previous_roles_count + 1)));
        }
    }


    @Then("^(.*) can see the increase in the number of vMember roles$")
    public void the_Admin_can_see_the_increase_in_the_number_of_vMember_roles(String userName) {

        if (rolExist) {
            actor.should(seeThat("Record exists previously", GoUsersRoles.count(), Predicate.isEqual(previous_roles_count)));
        } else {
            actor.should(seeThat("Record add successfully", GoUsersRoles.count(), Predicate.isEqual(previous_roles_count + 1)));
        }
    }

    @When("^delete the '(.*)' and see the message '(.*)'$")
    public void delete_the_role_and_see_the_message(String role, String message) {

        actor.attemptsTo(GoUsers.toDelete(role, message));
        rolExist = GoUsers.getRolExist();

        if (rolExist) {
            actor.should(seeThat("Record updated successfully", RecordUpdate.message(), containsString(message)));
        }
        actor.attemptsTo(
                Scroll.to(LNK_BACK),
                Click.on(LNK_BACK)
        );
    }

    @Then("^(.*) can see the decrease in the number of vMember roles$")
    public void the_Admin_can_see_the_decrease_in_the_number_of_vMember_roles(String userNam) {

        if (rolExist) {
            actor.should(seeThat("Record delete successfully", GoUsersRoles.count(), Predicate.isEqual(previous_roles_count - 1)));
        } else {
            actor.should(seeThat("Record does not exist previously", GoUsersRoles.count(), Predicate.isEqual(previous_roles_count)));
        }
    }

    @After
    public void endStage() {

        utils.wait(100);
    }
}
