package org.venturatravel.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.venturatravel.ui.LoginPage.MSG_LOGIN_FAILED;


public class LoginError implements Question<String>{

    public static  LoginError message(){

        return new LoginError();
    }

    @Override
    public String answeredBy(Actor actor) {


        actor.attemptsTo(
                WaitUntil.the(MSG_LOGIN_FAILED, isCurrentlyVisible()).forNoMoreThan(60).seconds()
        );

        return Text.of(MSG_LOGIN_FAILED).viewedBy(actor).asString();
    }
}


