package org.venturatravel.stepdefinitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;
//import org.venturatravel.questions.LoginError;
//import org.venturatravel.questions.VMembersProfile;
//import org.venturatravel.tasks.Decided;
//import org.venturatravel.tasks.Logged;
//import org.venturatravel.tasks.LoginWith;
//import org.venturatravel.utilities.utils;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

import org.venturatravel.tasks.Decided;


public class LoginStepDefinition {

    //private Actor actor;

    @Managed
    WebDriver hisBrowser;

    @Before
   //public void prepareStage() {

   //    System.out.println("prepareStage");
   //    actor = Actor.named("Mauricio");
   //    actor.can(BrowseTheWeb.with(hisBrowser));
   //}

    public void setTheStage() {

        OnStage.setTheStage(new OnlineCast());
    }


    ////////////////////////////////////////////// @LoginSuccessful
    @Given("^that (.*) logs into the '(.*)' GO platform$")
    public void that_the_vMember_logs_into_the_GO_platform(String actor, String url) {

     //   actor.has(Decided.loginIntoNewGoPlatform(url));
        theActorCalled(actor).attemptsTo(Decided.loginIntoNewGoPlatform(url));
    }

    @When("^(.*) wants to enter with his user '(.*)' and password '(.*)'$")
    public void the_vMember_wants_to_enter_in_his_account(String userName, String email, String pass) {

     //   actor.attemptsTo(LoginWith.user(email).password(pass));
    }

    @Then("^(.*) can see the user name '(.*)' of the account$")
    public void the_vMember_can_see_the_user_name_of_the_account(String userName, String expectedName) {

    //    actor.should(seeThat("Name of 'My Profile' page", VMembersProfile.name(), equalTo(expectedName)));
    }

    @Then("^(.*) log outs$")
    public void the_vMember_log_outs(String userName) {

     //   actor.attemptsTo(Logged.out());
    }


    ////////////////////////////////////////////// @LoginFailed
    @Then("^(.*) see an error message with the text (.*)$")
    public void the_vMember_see_an_error_message(String userName, String errorMsg) {

     //   actor.should(seeThat("Login error message", LoginError.message(), containsString(errorMsg)));
    }

    @After
    public void endStage() {

        System.out.println("endStage");
     //   utils.wait(500);
    }
}
