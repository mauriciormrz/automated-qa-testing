package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.venturatravel.ui.LoginPage;
import org.venturatravel.utilities.utils;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static org.venturatravel.ui.LoginPage.*;
import static org.venturatravel.ui.ServiceTemplatePage.BTN_NEW_TEMPLATE;

public class LoginWith implements Task {

    private final String user;
    private final String pass;

    public LoginWith(String user, String pass){
        this.user = user;
        this.pass = pass;
    }

    public static LoginBuilder user(String user) {

        return new LoginBuilder(user);
    }


    @Override
    @Step("{0} log ins to his account with the user: #user and password: #pass")
    public <T extends Actor> void performAs(T actor) {

        //utils.wait(1001);
        actor.attemptsTo(
                WaitUntil.the(EMAIL, isEnabled()).forNoMoreThan(30).seconds(),
                Type.theValue(user).into(EMAIL),
                WaitUntil.the(PASSWORD, isEnabled()).forNoMoreThan(30).seconds(),
                Type.theValue(pass).into(PASSWORD),
                Click.on(BTN_SIGN_IN)
        );
    }

    public static class LoginBuilder{

        private String user;

        public LoginBuilder(String user){
            this.user = user;
        }

        public Performable password(String pass){

            return Instrumented.instanceOf(LoginWith.class)
                    .withProperties(user,pass);
        }
    }
}
