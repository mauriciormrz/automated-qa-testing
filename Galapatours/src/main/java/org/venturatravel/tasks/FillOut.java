package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.By;


import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.venturatravel.ui.GalapatoursPage.*;
import static org.venturatravel.ui.TravelWithUsPage.LABEL_GALAPATOURS;


public class FillOut implements Task {

    private int numPassengers;
    private int dayDeparture;
    private String monthDeparture;
    private int yearDeparture;

    public FillOut(int numPassengers, int dayDeparture, String monthDeparture, int yearDeparture){

        this.numPassengers = numPassengers;
        this.dayDeparture = dayDeparture;
        this.monthDeparture = monthDeparture;
        this.yearDeparture = yearDeparture;
    }

    public static Performable theForm(int numPassengers, int dayDeparture, String monthDeparture, int yearDeparture) {

        return Instrumented
                .instanceOf(FillOut.class)
                .withProperties(numPassengers, dayDeparture, monthDeparture, yearDeparture);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        if (getDriver().findElement(By.cssSelector(OK_COOKIES)).isDisplayed()){
            actor.attemptsTo(Click.on(OK_COOKIES));
        }

        //actor.attemptsTo(
        //        WaitUntil.the(CHECK_IN_DATE, isEnabled()).forNoMoreThan(30).seconds(),
        //        Click.on(CHECK_IN_DATE)
        //);

        actor.attemptsTo(Click.on(BUTTON_SEARCH));

    }
}
