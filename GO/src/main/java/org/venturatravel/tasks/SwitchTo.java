package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.venturatravel.utilities.utils;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.venturatravel.ui.VMembersPage.*;

public class SwitchTo implements Task {

    private final String action;
    private final String switchUser;

    public SwitchTo(String action ,String switchUser){
        this.action = action;
        this.switchUser = switchUser;
    }

    public static Performable user(String switchUser) {

        return Instrumented.instanceOf(SwitchTo.class)
                .withProperties("switch user", switchUser);
    }

    public static Performable previous(String switchUser) {

        return Instrumented.instanceOf(SwitchTo.class)
                .withProperties("switch user back", switchUser);
    }

    public <T extends Actor> void switchUser(T actor) {

        String[] arrUser = switchUser.split(" ", 0);
        String switchUserName = arrUser[0];
        String switchUserLastName = arrUser[1];

      //actor.attemptsTo(
      //        WaitUntil.the(DROPDOWN_MENU, isEnabled()).forNoMoreThan(30).seconds(),
      //        Click.on(DROPDOWN_MENU),
      //        Click.on(MENU_SWITCH_USER),
      //        Type.theValue(switchUserName).into(INPUT_SEARCH_SWITCH_USER)
      //);

      //actor.attemptsTo(
      //        WaitUntil.the(SWITCH_USER_NAME.of(switchUserLastName), isCurrentlyVisible()).forNoMoreThan(30).seconds(),
      //        Click.on(SWITCH_USER_NAME.of(switchUserLastName)),
      //        WaitUntil.the(BTN_SWITCH, isCurrentlyVisible()).forNoMoreThan(30).seconds(),
      //        Click.on(BTN_SWITCH),
      //        WaitUntil.the(BTN_SWITCH, isNotCurrentlyVisible()).forNoMoreThan(30).seconds()
      //);

        actor.attemptsTo(
                WaitUntil.the(DROPDOWN_MENU, isCurrentlyEnabled()).forNoMoreThan(30).seconds(),
                Click.on(DROPDOWN_MENU),
                WaitUntil.the(MENU_SWITCH_USER, isCurrentlyEnabled()).forNoMoreThan(30).seconds(),
                Click.on(MENU_SWITCH_USER),
                Type.theValue(switchUserName).into(INPUT_SEARCH_SWITCH_USER)
        );

        actor.attemptsTo(
                WaitUntil.the(SWITCH_USER_NAME.of(switchUserLastName), isCurrentlyVisible()).forNoMoreThan(30).seconds(),
                Click.on(SWITCH_USER_NAME.of(switchUserLastName))
        );

        utils.wait(1001);
        actor.attemptsTo(
                WaitUntil.the(BTN_SWITCH, isCurrentlyVisible()).forNoMoreThan(30).seconds(),
                Click.on(BTN_SWITCH),
                WaitUntil.the(BTN_SWITCH, isNotCurrentlyVisible()).forNoMoreThan(30).seconds()
        );
    }


    public <T extends Actor> void switchUserBack(T actor) {

        actor.attemptsTo(
                WaitUntil.the(DROPDOWN_MENU, isEnabled()).forNoMoreThan(30).seconds(),
                Click.on(DROPDOWN_MENU),
                Click.on(MENU_SWITCH_USER_BACK)
        );
    }

    @Override
    @Step("{0} switches to the account with the user: #switchUser")
    public <T extends Actor> void performAs(T actor) {

        switch (action) {
            case "switch user":
                switchUser(actor);
                break;
            case "switch user back":
                switchUserBack(actor);
                break;
        }
    }
}
