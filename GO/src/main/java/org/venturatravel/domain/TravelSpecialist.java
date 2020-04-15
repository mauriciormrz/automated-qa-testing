package org.venturatravel.domain;

import net.serenitybdd.core.steps.ScenarioActor;
import net.thucydides.core.annotations.Step;

import java.util.List;

public class TravelSpecialist extends ScenarioActor {

    @Step("#actor completes the forms for the {0} type trip")
    public void completesTheForms(Trip trip) {

        //System.out.println(trip);

    }

    public void fillsTheDataTrip(List<Trip> trips) {

       // System.out.println("Trips: " + trips);
       // Trip tripEcuador = new Trip.Builder("Ecuador en Verano")
       //         .setTypePlatform(null).build();
//
       // System.out.println(tripEcuador);
         trips.forEach(
                trip -> {
                    System.out.println("Trip type: " +trip.getTrip_type());
                });
    }
}
