package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import org.venturatravel.actions.Browse;


public class Decided implements Task {

    private static String url;

    public Decided(String url) {

        this.url = url;
    }

    public static Performable loginIntoNewGoPlatform(String url) {
        return Instrumented.instanceOf(Decided.class).withProperties(url);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Browse.toHomePage(url));
    }
}



