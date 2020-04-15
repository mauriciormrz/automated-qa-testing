package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyEnabled;
import static org.venturatravel.ui.PlatformsHomePage.*;

public class FillOut implements Task {

    private static String firstName;
    private static String lastName;
    private static String email;
    private static String phone;

    public FillOut(List<List<String>> data, int i) {

        firstName = data.get(i).get(1).trim();
        lastName = data.get(i).get(2).trim();
        email = data.get(i).get(3).trim();
        phone = data.get(i).get(4).trim();
    }

    public static Performable theForm(List<List<String>> data, int i) {

        return Instrumented.instanceOf(FillOut.class)
                .withProperties(data, i);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(firstName).into(TXT_FIRST_NAME),
                Enter.theValue(lastName).into(TXT_LAST_NAME),
                Enter.theValue(email).into(TXT_EMAIL),
                Click.on(BTN_CONTINUE)
        );

        actor.attemptsTo(
                WaitUntil.the(TXT_PHONE, isCurrentlyEnabled()).forNoMoreThan(30).seconds(),
                Type.theValue(phone).into(TXT_PHONE),
                Click.on(BTN_GET_TRAVEL_OFFERS_NOW)
        );
    }


}
