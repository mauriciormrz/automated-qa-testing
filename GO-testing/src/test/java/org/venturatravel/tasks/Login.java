package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static org.venturatravel.ui.HomePage.*;
import static org.venturatravel.ui.VMemberPage.*;


public class Login implements Task {

    private String user;
    private String pass;
    private String action;

    public Login(String action, String user, String pass) {

        this.action = action;
        this.user = user;
        this.pass = pass;
    }

    public Login(String action) {

        this.action = action;
    }


    public static LoginBuilder user(String user) {

        return new LoginBuilder(user);
    }

    public static Performable out() {
        return Instrumented.instanceOf(Login.class)
                .withProperties("Logout");
    }

    private void Login(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(EMAIL, isEnabled()).forNoMoreThan(30).seconds(),
                Type.theValue(user).into(EMAIL),
                WaitUntil.the(PASSWORD, isEnabled()).forNoMoreThan(30).seconds(),
                Type.theValue(pass).into(PASSWORD),
                Click.on(BTN_SIGN_IN)
        );
    }

    private void Logout(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(DROPDOWN_MENU, isEnabled()).forNoMoreThan(30).seconds(),
                Click.on(DROPDOWN_MENU),
                Click.on(MENU_LOGOUT)
        );
    }


    @Override
    @Step("{0} have decided #action")
    public <T extends Actor> void performAs(T actor) {

        switch (action) {
            case "Login":
                Login(actor);
                break;
            case "Logout":
                Logout(actor);
                break;
        }
    }


    public static class LoginBuilder {

        private String user;

        public LoginBuilder(String user) {

            this.user = user;
        }

        public Performable password(String pass) {

            return Instrumented.instanceOf(Login.class)
                    .withProperties("Login", user, pass);
        }
    }
}
