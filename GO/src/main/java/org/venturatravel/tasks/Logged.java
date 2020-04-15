package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.venturatravel.questions.VMembersProfile;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static org.hamcrest.Matchers.containsString;
import static org.venturatravel.ui.VMembersPage.DROPDOWN_MENU;
import static org.venturatravel.ui.VMembersPage.MENU_LOGOUT;

public class Logged implements Task {

    private final String action;
    private static String user;
    private static String url;
    private static String email;
    private static String pass;


    public Logged(String action) {

        this.action = action;
    }

    public Logged(String action, String user, String url, String email, String pass) {

        this.action = action;
        Logged.user = user;
        Logged.url = url;
        Logged.email = email;
        Logged.pass = pass;
    }

    public static Performable out() {

        return Instrumented.instanceOf(Logged.class)
                .withProperties("Logout");
    }

    public static Performable in(String user, String url, String email, String pass) {

        return Instrumented.instanceOf(Logged.class)
                .withProperties("Login", user, url, email, pass);
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

    private void Login(Actor actor) {

        actor.has(Decided.loginIntoNewGoPlatform(url));
        actor.attemptsTo(LoginWith.user(email).password(pass));
        actor.should(seeThat("Name of 'My Profile' page", VMembersProfile.name(), containsString(user)));
    }

    private void Logout(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(DROPDOWN_MENU, isEnabled()).forNoMoreThan(30).seconds(),
                Click.on(DROPDOWN_MENU),
                Click.on(MENU_LOGOUT)
        );
    }
}
