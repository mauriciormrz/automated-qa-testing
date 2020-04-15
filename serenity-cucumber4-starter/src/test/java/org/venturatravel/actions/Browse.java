package org.venturatravel.actions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import org.venturatravel.ui.LoginPage;

public class Browse implements Interaction {

    private LoginPage newGoHomePage = new LoginPage();
    private static String url;

    public Browse(String url){

        this.url = url;
    }


    public static Performable toHomePage(String url) {

        return Instrumented.instanceOf(Browse.class).withProperties(url);
    }


    @Override
    @Step("{0} browses to the url")
    public <T extends Actor> void performAs(T actor) {

        newGoHomePage.setDefaultBaseUrl(url);
        actor.attemptsTo(Open.browserOn(newGoHomePage));
    }






}
