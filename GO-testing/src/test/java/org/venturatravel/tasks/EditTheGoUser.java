package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.venturatravel.ui.DashBoardPage.*;
import static org.venturatravel.ui.GoUserPage.*;


public class EditTheGoUser implements Task {

    private final String goUser;
    private static Integer numberOfRoles;

    public EditTheGoUser(String goUser) {

        this.goUser = goUser;
    }

    public static Performable info(String goUser) {

        return Instrumented.instanceOf(EditTheGoUser.class)
                .withProperties(goUser);
    }

    public static void addOneToTheNumberOfRolesValue() {

        numberOfRoles++;
    }

    public static void subtractOneToTheNumberOfRolesValue() {

        numberOfRoles--;
    }

    public static Integer getNumberOfRoles() {

        return numberOfRoles;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(ICON_VMEMBERS, isCurrentlyEnabled()).forNoMoreThan(60).seconds(),
                Click.on(ICON_VMEMBERS),
                Click.on(GO_USERS),
                Type.theValue(goUser).into(SEARCH)
        );

        actor.attemptsTo(
                WaitUntil.the(LOADING, isCurrentlyVisible()).forNoMoreThan(30).seconds(),
                WaitUntil.the(LOADING, isNotPresent()).forNoMoreThan(30).seconds()
        );

        numberOfRoles = Text.of(ROLE_VALUE).viewedBy(actor).asInteger();

        actor.attemptsTo(
                WaitUntil.the(ICON_EDIT, isCurrentlyEnabled()).forNoMoreThan(30).seconds(),
                Click.on(ICON_EDIT)
        );
    }
}
