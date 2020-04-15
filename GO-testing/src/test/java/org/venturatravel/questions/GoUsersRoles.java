package org.venturatravel.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static org.venturatravel.ui.GoUserPage.ROLE_VALUE;
import static org.venturatravel.ui.HomePage.MSG_LOGIN_FAILED;


public class GoUsersRoles implements Question<Integer> {

    public static GoUsersRoles amount(){

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

//public class GoUsersRoles {
//
//    public static Question<Integer> amount(){
//
//        return actor -> Text.of(ROLE_VALUE)
//                .viewedBy(actor).asInteger();
//    }
//}
