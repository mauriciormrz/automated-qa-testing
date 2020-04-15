package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.venturatravel.utilities.utils;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.venturatravel.ui.TailorMadePage.*;

import static org.venturatravel.ui.TailorMadePage.NAME;


public class Setup implements Task {

    private static String name;
    private static String lastName;
    private static String email;


    public Setup(List<List<String>> data, int i) {

        name = data.get(i).get(0).trim();
        lastName = data.get(i).get(1).trim();
        email = data.get(i).get(2).trim();
    }

    public static Performable hisTrip(List<List<String>> data, int i) {
        return Instrumented
                .instanceOf(Setup.class)
                .withProperties(data, i);
    }


    @Override
    @Step("{0} set up the tailor made trip")
    public <T extends Actor> void performAs(T actor) {

        utils.wait(1000);
        actor.attemptsTo(
                Scroll.to(TXT_GROUP_TRIP),
                WaitUntil.the(GREEN_BOX_TAILOR_MADE_TRIP, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(GREEN_BOX_TAILOR_MADE_TRIP)
        );

        actor.attemptsTo(
                Scroll.to(ACCOMODATION_STANDARD),
                Type.theValue(name).into(NAME),
                Type.theValue(lastName).into(LAST_NAME),
                Type.theValue(email).into(EMAIL)
        );

        actor.attemptsTo(
                WaitUntil.the(BTN_SEND, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(BTN_SEND)
        );
    }
}
