package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.ScrollTo;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.venturatravel.utilities.utils;
//import org.openqa.selenium.JavascriptExecutor;
//import org.venturatravel.ui.CountryLandingPage;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
//import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.venturatravel.ui.ContactPage.*;

import static org.venturatravel.ui.CountryLandingPage.DATES_AND_PRICES;
import static org.venturatravel.ui.TripLandingPage.*;

public class FillOut implements Task {

    private String travelForm;

    private static String countryWebsite;
    private static String gender;
    private static String name;
    private static String lastName;
    private static String email;
    private static String phone;

    public FillOut(String travelForm) {

        this.travelForm = travelForm;
    }

    public FillOut(String travelForm, String countryWebsite, List<List<String>> data, int id) {

        this.travelForm = travelForm;
        this.countryWebsite = countryWebsite;
        gender = data.get(id).get(0).trim();
        name = data.get(id).get(1).trim();
        lastName = data.get(id).get(2).trim();
        email = data.get(id).get(3).trim();
        phone = data.get(id).get(4).trim();
    }

    public FillOut(String travelForm, List<List<String>> data, int id) {

        this.travelForm = travelForm;
        gender = data.get(id).get(0).trim();
        name = data.get(id).get(1).trim();
        lastName = data.get(id).get(2).trim();
        email = data.get(id).get(3).trim();
        phone = data.get(id).get(4).trim();
    }

    public static Performable theTripDetails(String countryWebsite, List<List<String>> data, int id) {
        return Instrumented
                .instanceOf(FillOut.class)
                .withProperties("Details of the Trip", countryWebsite, data, id);
    }

    public static Performable personalInformation() {
        return Instrumented
                .instanceOf(FillOut.class)
                .withProperties("Personal Info");
    }

    public static Performable contactInformation(String countryWebsite, List<List<String>> data, int id) {
        return Instrumented
                .instanceOf(FillOut.class)
                .withProperties("Contact Info", countryWebsite, data, id);
    }

    public static Performable contactInformation(List<List<String>> data, int id) {
        return Instrumented
                .instanceOf(FillOut.class)
                .withProperties("Contact Info", countryWebsite, data, id);
    }

    public <T extends Actor> void detailsOfTheTrip(T actor) {

        actor.attemptsTo(
                WaitUntil.the(TYPE_OF_ACCOMODATION, isCurrentlyEnabled()).forNoMoreThan(30).seconds(),
                Click.on(TYPE_OF_ACCOMODATION)
        );

        actor.attemptsTo(
                WaitUntil.the(HALF_DOUBLE_ACCOMMODATION, isCurrentlyEnabled()).forNoMoreThan(30).seconds(),
                Click.on(HALF_DOUBLE_ACCOMMODATION)
        );

        actor.attemptsTo(Scroll.to(BTN_SUBMIT),
                Click.on(BTN_SUBMIT)
        );
    }

    public <T extends Actor> void personalInfo(T actor) {

        utils.wait(1001);
        actor.attemptsTo(
                WaitUntil.the(TYPE_OF_GENDER, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(TYPE_OF_GENDER),
                Click.on(GENDER.of(gender.toLowerCase())),
                Enter.theValue(name).into(NAME), Enter.theValue(lastName).into(LAST_NAME)
        );

        if (countryWebsite.equals("Germany")) {
            actor.attemptsTo(Click.on(TYPE_OF_SALUTATION), Click.on(SALUTATION.of("1")));
        }

        actor.attemptsTo(Enter.theValue(email).into(EMAIL), Enter.theValue(phone).into(PHONE));
    }

    public <T extends Actor> void contactInfo(T actor) {

        actor.attemptsTo(
                //WaitUntil.the(FIRSTNAME_CONTACT, isCurrentlyVisible()).forNoMoreThan(30).seconds(),
                //Scroll.to(FIRSTNAME_CONTACT),
                Enter.theValue(name).into(FIRSTNAME_CONTACT),
                Enter.theValue(lastName).into(LASTNAME_CONTACT),
                Enter.theValue(email).into(EMAIL_CONTACT),
                Enter.theValue(phone).into(PHONE_CONTACT),
                Enter.theValue("Test message").into(MESSAGE_CONTACT),
                Click.on(BTN_SEND_CONTACT));
    }


    @Override
    @Step("{0} fills out the web forms '#travelForm'")
    public <T extends Actor> void performAs(T actor) {

        switch (travelForm) {
            case "Details of the Trip":
                detailsOfTheTrip(actor);
                break;
            case "Contact Info":
                contactInfo(actor);
                break;
            case "Personal Info":
                personalInfo(actor);
                break;
        }
    }
}


