package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import org.venturatravel.ui.CountryLandingPage;
import org.venturatravel.utilities.utils;

import static org.venturatravel.ui.CountryLandingPage.BTN_RESERVATION;

public class Select implements Task {

    private CountryLandingPage countryLandingPage = new CountryLandingPage();

    private static String departureDates;
    private static String departurePrice;

    private static Boolean waitingList;
    private static Boolean departures;

    public static Performable theDeparture() {
        return Instrumented
                .instanceOf(Select.class)
                .withProperties();
    }

    @Override
    @Step("{0} selects the Departure")
    public <T extends Actor> void performAs(T actor) {


        countryLandingPage.departuresTable();
        waitingList = false;
        departures = true;

        String rowDeparture = CountryLandingPage.getRowDeparture();
        String columnDeparture = CountryLandingPage.getColumnDeparture();

        if (rowDeparture == null) {
            rowDeparture = "1";
            waitingList = true;
            if (columnDeparture == null) {
                departures = false;
                return;
            }
        }

        departureDates = CountryLandingPage.getDepartureDate();
        departurePrice = CountryLandingPage.getDeparturePrice();

        utils.wait(500);
        actor.attemptsTo(
                Click.on(BTN_RESERVATION.of(rowDeparture, columnDeparture))
        );
    }

    public static String getDepartureDates() {
        return departureDates;
    }

    public static String getDeparturePrice() {
        return departurePrice;
    }

    public static Boolean isWaitingList() {
        return waitingList;
    }

    public static Boolean isDepartures() {
        return departures;
    }
}

