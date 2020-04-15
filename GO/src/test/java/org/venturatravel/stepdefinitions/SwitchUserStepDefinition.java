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
import org.venturatravel.questions.VMembersProfile;
import org.venturatravel.tasks.GoUsers;
import org.venturatravel.tasks.Logged;
import org.venturatravel.tasks.SwitchTo;
import org.venturatravel.ui.ServiceTemplatePage;
import org.venturatravel.utilities.utils;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.venturatravel.constants.Constants.RECORD_UPDATE_SUCCESSFULLY_MSG;

public class SwitchUserStepDefinition {

    private Actor actor;
    private ServiceTemplatePage serviceTemplatePage = new ServiceTemplatePage();

    @Managed
    WebDriver hisBrowser;

    @Before
    public void prepareStage() {

        actor = Actor.named("Mauricio");
        actor.can(BrowseTheWeb.with(hisBrowser));
    }


    @Given("^that (.*) '(.*)' has the role '(.*)' into the '(.*)' GO platform with user '(.*)' and password '(.*)'$")
    public void that_the_Travel_Specialist_has_the_role(String userName, String user, String role, String url, String email, String pass) {

        actor.attemptsTo(Logged.in(user, url, email, pass));

        actor.attemptsTo(GoUsers.toEdit(user));
        actor.attemptsTo(GoUsers.toAdd(role, RECORD_UPDATE_SUCCESSFULLY_MSG));

        actor.attemptsTo(Logged.out());

    }


    @Given("^(.*) '(.*)' logs into the '(.*)' GO platform with user '(.*)' and password '(.*)'$")
    public void that_the_User_logs_into_the_url_with_user_and_password(String userName, String user, String url, String email, String pass) {

        actor.attemptsTo(Logged.in(user, url, email, pass));
    }

    @When("^(.*) changes the user '(.*)' and sees the name of the new user on the profile page$")
    public void the_Admin_changes_the_user_and_sees_the_name_of_the_new_user_on_the_profile_page(String userName, String switchUser) {

        actor.has(SwitchTo.user(switchUser));
        actor.should(seeThat("Name of 'My Profile' page", VMembersProfile.name(), containsString(switchUser)));
    }

    @Then("^(.*) switch user back and see the name of the previous user '(.*)' on the profile page$")
    public void the_Admin_switch_user_back_and_see_the_name_of_the_previous_user_Mauricio_Ramirez_on_the_profile_page(String userName, String user) {

        actor.has(SwitchTo.previous(user));
        actor.should(seeThat("Name of 'My Profile' page", VMembersProfile.name(), containsString(user)));
    }

    @After
    public void endStage() {

        utils.wait(100);
    }
}


/*
  @AddDelRole
  Scenario Outline: Add/delete a role to a vMember
    Given the Admin '<user>' logs into the '<url>' GO platform with user '<email>' and password '<password>'
    When  the Admin performs the '<operation>' to the '<role>' of the '<vMember>
    Then the Admin verify the operation '<operation>'

    Examples:
      | New GO   | user                      | email                              | password   | vMember           | role   | operation | url                                        |
      | Platform | Mauricio Ramirez Restrepo | mauricio.ramirez@venturatravel.org | M@uricio69 | Franziska Umlauft | TESTER | add       | https://go-staging.venturatravel.org/login |
      | Platform | Mauricio Ramirez Restrepo | mauricio.ramirez@venturatravel.org | M@uricio69 | Franziska Umlauft | ADMIN  | add       | https://go-staging.venturatravel.org/login |
 */

