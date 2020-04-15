package org.venturatravel.stepdefinitions;


import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.venturatravel.questions.TheItems;
import org.venturatravel.tasks.AddATodoItem;
import org.venturatravel.tasks.Start;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;


public class AddNewTasksStepDefinitions {

    @Before
    public void set_the_stage(){

        OnStage.setTheStage(new OnlineCast());
    }

    @Given("^that (.*) has an empty todo list$")
    public void that_the_actor_has_an_empty_todo_list(String actorName) throws Exception {

        OnStage.theActorCalled(actorName).attemptsTo(Start.withAnEmptyList());
    }

    @Given("^that (.*) has a list containing (.*)$")
    public void has_a_list_containing(String actorName, String s) throws Exception {

        List<String> tasks = new ArrayList<String>(Arrays.asList(s.split(",")));

        OnStage.theActorCalled(actorName).attemptsTo(Start.withATodoListOf(tasks));
    }

    @When("^s?he adds '(.*)' to (?:his|her) list$")
    public void he_adds_to_his_list(String taskName) throws Exception {

        OnStage.theActorInTheSpotlight().attemptsTo(AddATodoItem.called(taskName));
    }


    @Then("^'(.*)' should be recorded in (?:his|her) list$")
    public void should_be_recorded_in_his_list(String taskName) throws Exception {

        OnStage.theActorInTheSpotlight().should(seeThat(
                "The item displayed", TheItems.displayed(), hasItem(taskName)
        ));
    }

    @Then("^(?:his|her) todo list should contain (.*)$")
    public void list_should_contain(String s) throws Exception {

        List<String> expectedItems = new ArrayList<String>(Arrays.asList(s.split(",")));

        OnStage.theActorInTheSpotlight().should(seeThat(
                "the items displayed", TheItems.displayed(), equalTo(expectedItems)
        ));
    }
}
