package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.venturatravel.questions.CurrentUrl;
import org.venturatravel.questions.ReservationSummary;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isNotCurrentlyVisible;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.venturatravel.ui.TripLandingPage.BTN_SUBMIT;
import static org.venturatravel.ui.TripLandingPage.TERMS;

public class Check implements Task {

    private String checkAction;
    private String departureDates;
    private String departurePrice;
    private String countryWebsite;

    private CurrentUrl theCurrentUrl = new CurrentUrl();


    public Check(String checkAction, String countryWebsite) {
        this.checkAction = checkAction;
        this.countryWebsite =countryWebsite;
    }

    public Check(String checkAction, String departureDates, String departurePrice) {
        this.checkAction = checkAction;
        this.departurePrice = departurePrice  + "€";
        this.departureDates = departureDates.substring(0, 8) + " - " + departureDates.substring(13, 21);
    }

    public static Performable theSummary(String departureDates, String departurePrice) {
        return Instrumented
                .instanceOf(Check.class)
                .withProperties("Summary", departureDates, departurePrice);
    }

    public static Performable booking(String countryWebsite) {
        return Instrumented
                .instanceOf(Check.class)
                .withProperties("Booking",countryWebsite);
    }

    public <T extends Actor> void CheckOfTheSummary(T actor) {

        actor.should(seeThat("the departure date of the reservation", ReservationSummary.departureDates(), equalTo(departureDates)));
        System.out.println(ReservationSummary.departureTotalPrice());
        Question<String> valor = ReservationSummary.departureTotalPrice();
        actor.should(seeThat("the tour price", ReservationSummary.departureTotalPrice(), equalTo(departurePrice)));
    }

    public <T extends Actor> void CheckBooking(T actor) {
        actor.attemptsTo(Click.on(BTN_SUBMIT));
        actor.attemptsTo(Click.on(TERMS));
        actor.attemptsTo(Click.on(BTN_SUBMIT));

        //utils.wait(8000);

        actor.attemptsTo(
                WaitUntil.the(BTN_SUBMIT, isNotCurrentlyVisible()).forNoMoreThan(30).seconds()
        );

        actor.should(seeThat(theCurrentUrl, containsString(theCurrentUrl.reservationPage(countryWebsite))));
    }

    @Override
    @Step("{0} checks the '#checkAction'")
    public <T extends Actor> void performAs(T actor) {
        switch (checkAction) {
            case "Summary":
                CheckOfTheSummary(actor);
                break;
            case "Booking":
                CheckBooking(actor);
                break;
        }
    }
}
