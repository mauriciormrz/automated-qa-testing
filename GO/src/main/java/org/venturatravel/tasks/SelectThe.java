package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;


import static org.venturatravel.ui.ServiceTemplatePage.ICON_TRIP_BUILDER;

import static org.venturatravel.ui.TripBuilderPage.*;

public class SelectThe implements Task {

    private static String tripType;


   public SelectThe(String tripType) {

       this.tripType = tripType;
   }


     public static Performable tripType(String tripType) {
         return Instrumented.instanceOf(SelectThe.class)
                 .withProperties(tripType);
     }


    @Override
    @Step("{0} selects the trip type #tripType ")
    public <T extends Actor> void performAs(T actor) {

       actor.attemptsTo(
               Click.on(ICON_TRIP_BUILDER),
               Click.on(TRIP_BUILDER),
               Click.on(BTN_TYPE_OF_TRIP.of(tripType)),
               Click.on(BTN_NEXT_STEP)
       );
    }
}
