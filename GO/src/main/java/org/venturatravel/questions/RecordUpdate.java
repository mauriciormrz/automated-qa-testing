package org.venturatravel.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static org.venturatravel.ui.GoUsersPage.MSG_RECORD_UPDATE;
import static org.venturatravel.ui.LoginPage.MSG_LOGIN_FAILED;

public class RecordUpdate implements Question<String> {

    public static RecordUpdate message() {

        return new RecordUpdate();
    }

    @Override
    public String answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(MSG_RECORD_UPDATE, isCurrentlyVisible()).forNoMoreThan(30).seconds(),
                Click.on(MSG_RECORD_UPDATE)
        );
        return Text.of(MSG_RECORD_UPDATE).viewedBy(actor).asString();
    }
}
