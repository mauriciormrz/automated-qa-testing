package org.venturatravel.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.venturatravel.ui.PlatformsHomePage;
import org.venturatravel.utilities.utils;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static org.venturatravel.ui.PlatformsHomePage.BTN_FIND_MY_TRIP_NOW;
import static org.venturatravel.ui.PlatformsHomePage.BTN_PRIVACY_POLICY;

public class Surf implements Task {

    private PlatformsHomePage platformsHomePage = new PlatformsHomePage();

    public static Performable toHomePage() {

        return instrumented(Surf.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Open.browserOn(platformsHomePage)
        );

        utils.wait(1001);
        if (CurrentVisibility.of(BTN_PRIVACY_POLICY).viewedBy(actor).asBoolean()) {
            actor.attemptsTo(
                    Click.on(BTN_PRIVACY_POLICY)
            );
        }

        utils.wait(1001);
        actor.attemptsTo(
                WaitUntil.the(BTN_FIND_MY_TRIP_NOW, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_FIND_MY_TRIP_NOW)
        );
    }
}
