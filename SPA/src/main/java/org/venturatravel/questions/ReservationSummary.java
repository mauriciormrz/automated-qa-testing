package org.venturatravel.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static org.venturatravel.ui.TripLandingPage.*;

public class ReservationSummary {

    public static Question<String> departureDates(){
        return actor -> Text.of(DEPARTURE_DATES)
                .viewedBy(actor).asString();
    }

    public static Question<String> departureTotalPrice(){
        return actor -> Text.of(DEPARTURE_PRICE)
                .viewedBy(actor).asString();
    }
}



