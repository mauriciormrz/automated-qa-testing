package org.venturatravel.tasks;

import net.bytebuddy.implementation.Implementation;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.ClickOnBy;

import static org.venturatravel.ui.TripBuilderPage.BTN_NEXT_STEP;

public class ContinueWith implements Task {

    public static Performable theNextStep() {
        return Instrumented.instanceOf(ContinueWith.class)
                .newInstance();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(BTN_NEXT_STEP)
        );
    }
}
