package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.venturatravel.questions.RecordUpdate;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static org.hamcrest.CoreMatchers.containsString;
import static org.venturatravel.constants.Constants.RECORD_UPDATE_SUCCESSFULLY_MSG;
import static org.venturatravel.tasks.EditTheGoUser.subtractOneToTheNumberOfRolesValue;
import static org.venturatravel.ui.GoUserPage.*;

public class DeleteARole implements Task {

    private final String role;

    public DeleteARole(String role) {

        this.role = role;
    }

    public static Performable called(String role) {
        return Instrumented.instanceOf(DeleteARole.class)
                .withProperties(role);
    }


    @Override
    @Step("{0} Subtracts the role '#role'")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Scroll.to(TAG_ROLE));

        if (CurrentVisibility.of(ADD_ROLE.of(role)).viewedBy(actor).asBoolean()) {

            actor.attemptsTo(
                    WaitUntil.the(CROSS_ROLE.of(role), isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(CROSS_ROLE.of(role)),
                    WaitUntil.the(BTN_SAVE, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(BTN_SAVE)
            );

            actor.should(seeThat("Record updated successfully", RecordUpdate.message(), containsString(RECORD_UPDATE_SUCCESSFULLY_MSG)));
            subtractOneToTheNumberOfRolesValue();
        }

        actor.attemptsTo(
                Scroll.to(LNK_BACK),
                Click.on(LNK_BACK)
        );

    }
}
