package org.venturatravel.stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.venturatravel.jdbc.domain.GoUser;
import org.venturatravel.tasks.Query;
import org.venturatravel.tasks.VerifyThe;
import org.venturatravel.utilities.utils;

import static org.venturatravel.tasks.Query.getActiveGoUsersWithBoss;
import static org.venturatravel.tasks.Query.getInactiveGoUsers;
import static org.venturatravel.tasks.VerifyThe.getResultGoUsers;


public class GreyBoxTestingStepDefinition {

    private Actor actor;

    @Managed
    WebDriver hisBrowser;

    @Before
    public void prepareStage() {

        actor = Actor.named("Mauricio");
        actor.can(BrowseTheWeb.with(hisBrowser));
    }


    @Given("^that (.*) consults the active vMembers in '(.*)'$")
    public void that_HR_consults_the_active_vMembers_in_DB(String userName, String db) {

        actor.attemptsTo(Query.theDatabase(db));
        System.out.println("   activeGoUsersWithBoss : " + getActiveGoUsersWithBoss().size());
        System.out.println("   inactiveGoUsers       : " + getInactiveGoUsers().size());
        System.out.println("   allGoUsers            : " + Query.getAllGoUsers().size());
    }

    @When("^(.*) verifies the status of the managers$")
    public void hr_verifies_the_status_of_the_managers(String userName) {

        actor.attemptsTo(VerifyThe.queryResults(getActiveGoUsersWithBoss(), getInactiveGoUsers()));
    }

    @Then("^(.*) lists the vMembers with inactive managers$")
    public void hr_lists_the_vMembers_with_inactive_managers(String userName) {

        int i=1;
        for (GoUser goUser : getResultGoUsers()) {
            System.out.println(i +". goUser_id: " + goUser.getId());
            i++;
        }
    }


    @After
    public void endStage() {

        utils.wait(500);
    }
}
