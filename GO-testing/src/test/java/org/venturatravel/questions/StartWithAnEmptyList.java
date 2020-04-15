package org.venturatravel.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import org.venturatravel.ui.ApplicationHomePage;

public class StartWithAnEmptyList implements Interaction {

    ApplicationHomePage applicationHomePage;

    @Override
    @Step("{0} starts with an empty list")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Open.browserOn(applicationHomePage)
        );
    }
}
