package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import net.serenitybdd.screenplay.actions.type.Type;


import static org.venturatravel.ui.TripBuilderPage.TXT_TRIP_NAME;

public class FillOutThe implements Task {

    private  String trip_name;

    public FillOutThe(String trip_name){

        this.trip_name = trip_name;
    }


    public static Performable tripName(String trip_name) {
        return Instrumented.instanceOf(FillOutThe.class)
                .withProperties(trip_name);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                 Type.theValue(trip_name).into(TXT_TRIP_NAME)
        );

    }

}

