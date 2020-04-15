package org.venturatravel.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;

import org.venturatravel.ui.VenturaTravelHomePage;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.venturatravel.ui.TravelWithUsPage.*;
import static org.venturatravel.ui.VenturaTravelHomePage.*;


public class Surf implements Task {

    private VenturaTravelHomePage venturaTravelHomePage = new VenturaTravelHomePage();


    public static Performable toVenturaTravelWebSite() {

        return instrumented(Surf.class);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Open.browserOn(venturaTravelHomePage));

        if (getDriver().findElement(By.xpath(ACCEPT_COOKIES)).isDisplayed()){
            actor.attemptsTo(Click.on(ACCEPT_COOKIES));
        }

        actor.attemptsTo(
                Click.on(LABEL_TRAVEL_WITH_US),
                Click.on(MENU_FIND_YOUR_TRIP)
        );

        actor.attemptsTo(
                WaitUntil.the(LABEL_GALAPATOURS, isEnabled()).forNoMoreThan(30).seconds(),
                Click.on(LABEL_GALAPATOURS)
        );
    }
}

