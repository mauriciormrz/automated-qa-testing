package org.venturatravel.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
import org.venturatravel.questions.LoginError;
import org.venturatravel.questions.VMembersProfile;
import org.venturatravel.tasks.Login;
import org.venturatravel.tasks.Navigate;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class LoginStepDefinition {

    private Actor actor;

    @Managed
    WebDriver hisBrowser;

    @Before
    public void prepare_stage() {

        System.out.println("prepareStage");
        actor = Actor.named("Mauricio");
        actor.can(BrowseTheWeb.with(hisBrowser));
    }

    @Given("^that (.*) navigates to the homepage of the New GO platform$")
    public void that_the_actor_navigates_to_the_homepage_of_New_GO_platform(String actorName) {

        actor.attemptsTo(Navigate.toTheHomePage());
    }

   @When("^s?he enters (?:his|her) user '(.*)' and password '(.*)'$")
   public void he_enter_his_user_and_password(String email, String password) {

       actor.attemptsTo(Login.user(email).password(password));
   }

   @Then("^s?he should see the profile name '(.*)'$")
   public void he_should_see_the_profile_name(String expectedName) {

       actor.should(seeThat(
               "Name of 'My Profile' page", VMembersProfile.name(), equalTo(expectedName)
       ));
   }

   @Then("^he should see an error message with the text (.*)$")
   public void he_should_see_an_error_message_with_the_text(String errorMsg) {

       actor.should(seeThat(
               "Login error message", LoginError.message(), containsString(errorMsg)
       ));
   }

    @And("^he log outs$")
    public void the_actor_log_outs() {

        actor.attemptsTo(Login.out());
    }

    @After
    public void end_stage() {

        //System.out.println("endStage");
        //utils.wait(500);
    }
}
