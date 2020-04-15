package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import org.venturatravel.ui.HomePage;

public class Navigate implements Task {

    private HomePage homePage = new HomePage();

    public static Performable toTheHomePage() {
        return Instrumented.instanceOf(Navigate.class)
                .newInstance();
    }

    @Override
    @Step("{0} browses to the new GO homepage")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Open.browserOn(homePage));
    }
}
