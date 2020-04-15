package org.venturatravel.actions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import org.venturatravel.tasks.AddTodoItems;
import org.venturatravel.ui.ApplicationHomePage;

import java.util.List;

public class StartWithAPopulatedList implements Interaction {

    private ApplicationHomePage applicationHomePage;
    private final List<String> tasks;

    public StartWithAPopulatedList(List<String> tasks) {

        this.tasks = tasks;
    }

    @Override
    @Step("{0} starts with an empty list")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Open.browserOn(applicationHomePage),
                AddTodoItems.called(tasks)
        );
    }
}
