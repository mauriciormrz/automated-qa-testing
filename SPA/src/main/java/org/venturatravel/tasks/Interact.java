package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.venturatravel.utilities.utils;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static org.venturatravel.ui.HelperComponentPage.*;


public class Interact implements Task {

    private static String firstName;
    private static String lastName;
    private static String email;
    private static Boolean helperComponent;

    public static Boolean getHelperComponent() {
        return helperComponent;
    }


    public Interact(List<List<String>> data, int i) {

        firstName = data.get(i).get(0).trim();
        lastName = data.get(i).get(1).trim();
        email = data.get(i).get(2).trim();
    }

    public static Performable withTheHelperComponent(List<List<String>> data, int i) {
        return Instrumented
                .instanceOf(Interact.class)
                .withProperties(data, i);
    }

    @Override
    @Step("{0} fills out the contact form")
    public <T extends Actor> void performAs(T actor) {

        utils.wait(1001);
        helperComponent= false;

        //actor.attemptsTo(WaitUntil.the(AVATAR_CONTACT, isCurrentlyVisible()).forNoMoreThan(30).seconds());
        if (CurrentVisibility.of(AVATAR_CONTACT).viewedBy(actor).asBoolean()) {

            actor.attemptsTo(Click.on(AVATAR_CONTACT));
            utils.wait(1001);
            actor.attemptsTo(
                    Enter.theValue(firstName).into(FIRSTNAME),
                    Enter.theValue(lastName).into(LASTNAME),
                    Enter.theValue(email).into(EMAIL),
                    Enter.theValue("Test").into(MESSAGE)
            );

            actor.attemptsTo(
                    WaitUntil.the(SEND, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(SEND)
            );
            helperComponent = true;
        }
    }
}
