package org.venturatravel.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


@Subject("the url redirected")
public class CurrentUrl implements Question<String> {

    @Override
    public String answeredBy(Actor actor) {
        return (getDriver().getCurrentUrl());
    }

    public String landingPage(String countryWebsite, String tourOperator) {

        String url =  tourOperator.toLowerCase() + ".";
        url += countryWebsite.equals("Germany") ?  "de":  "fr" ;
        return url;
    }

    public String tripLandingPage(String countryWebsite) {


        String url = countryWebsite.equals("Germany") ?  "vitailor":  "sur-mesure" ;
        return url;
    }

    public String reservationPage(String countryWebsite) {

        String url = countryWebsite.equals("Germany") ?  "danke":  "merci" ;
        return url;
    }
}
