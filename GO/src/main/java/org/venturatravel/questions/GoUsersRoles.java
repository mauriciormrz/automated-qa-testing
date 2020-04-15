package org.venturatravel.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.serenitybdd.screenplay.waits.WaitUntilAngularIsReady;
import org.venturatravel.utilities.utils;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotPresent;
import static org.venturatravel.ui.GoUsersPage.LOADING;
import static org.venturatravel.ui.GoUsersPage.ROLE_VALUE;
import static org.venturatravel.ui.LoginPage.MSG_LOGIN_FAILED;


public class GoUsersRoles implements Question<Integer> {

    public static GoUsersRoles count() {
        return new GoUsersRoles();
    }

    @Override
    public Integer answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(ROLE_VALUE, isCurrentlyVisible()).forNoMoreThan(60).seconds()
        );

        return Text.of(ROLE_VALUE).viewedBy(actor).asInteger();
    }
}
