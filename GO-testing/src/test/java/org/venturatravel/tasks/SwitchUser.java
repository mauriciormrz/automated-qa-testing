package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;


import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.venturatravel.ui.VMemberPage.*;


public class SwitchUser implements Task {

    private final String action;
    private final String switchUser;


    public SwitchUser(String action, String switchUser) {
        this.action = action;
        this.switchUser = switchUser;
    }

    public static Performable named(String switchUser) {

        return Instrumented.instanceOf(SwitchUser.class)
                .withProperties("switch user named", switchUser);
    }

    public static Performable back() {

        return Instrumented.instanceOf(SwitchUser.class)
                .withProperties("switch user back", null);
    }

    public <T extends Actor> void switchUserNamed(T actor) {

        actor.attemptsTo(
                WaitUntil.the(DROPDOWN_MENU, isCurrentlyEnabled()).forNoMoreThan(30).seconds(),
                Click.on(DROPDOWN_MENU),
                WaitUntil.the(MENU_SWITCH_USER, isCurrentlyEnabled()).forNoMoreThan(30).seconds(),
                Click.on(MENU_SWITCH_USER),
                Type.theValue(switchUser).into(INPUT_SEARCH_SWITCH_USER),
                WaitUntil.the(BTN_SWITCH, isCurrentlyVisible()).forNoMoreThan(30).seconds(),
                Click.on(BTN_SWITCH),
                WaitUntil.the(BTN_SWITCH, isNotCurrentlyVisible()).forNoMoreThan(30).seconds()
        );
    }

    public <T extends Actor> void switchUserBack(T actor) {

        actor.attemptsTo(
                WaitUntil.the(DROPDOWN_MENU, isCurrentlyEnabled()).forNoMoreThan(30).seconds(),
                Click.on(DROPDOWN_MENU),
                WaitUntil.the(MENU_SWITCH_USER_BACK, isCurrentlyVisible()).forNoMoreThan(30).seconds(),
                Click.on(MENU_SWITCH_USER_BACK)
        );
    }

    @Override
    @Step("{0} switches to the account with the user: #switchUser")
    public <T extends Actor> void performAs(T actor) {

        switch (action) {
            case "switch user named":
                switchUserNamed(actor);
                break;
            case "switch user back":
                switchUserBack(actor);
                break;
        }
    }
}
