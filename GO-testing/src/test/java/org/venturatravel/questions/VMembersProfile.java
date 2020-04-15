package org.venturatravel.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static org.venturatravel.ui.VMemberPage.PROFILE_USER_NAME;


public class VMembersProfile implements Question<String> {

    public static VMembersProfile name(){

        return new VMembersProfile();
    }

    @Override
    public String answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(PROFILE_USER_NAME, isCurrentlyVisible()).forNoMoreThan(60).seconds()
        );
        return Text.of(PROFILE_USER_NAME).viewedBy(actor).asString();
    }
}

//public class VMembersProfile {
//
//    public static Question<String> name(){
//
//
//        return actor -> Text.of(VMemberPage.PROFILE_USER_NAME)
//                .viewedBy(actor).asString();
//    }
//}






