package org.venturatravel.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.venturatravel.utilities.utils;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static org.venturatravel.ui.VMembersPage.*;


public class VMembersProfile implements Question<String>{

    public static VMembersProfile name(){

        return new VMembersProfile();
    }

    @Override
    public String answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(PROFILE_USER, isCurrentlyVisible()).forNoMoreThan(60).seconds()
        );
        return Text.of(PROFILE_USER).viewedBy(actor).asString();

    }
}
/*
public class Vmembers {

    public static Question<String> profileTitle(){

        return actor -> Text.of(VmembersPage.PROFILE_TITLE)
                .viewedBy(actor).asString();
    }
}

 */

