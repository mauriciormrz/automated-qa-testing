package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.venturatravel.ui.VenturaHomePage;
import org.venturatravel.utilities.utils;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyEnabled;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static org.venturatravel.ui.HomeLandingPage.*;

public class Decided implements Task {

    private String url;
    private String countryWebsite;
    private String tourOperator;

    private VenturaHomePage venturaHomePage = new VenturaHomePage();

    public Decided(String url, String countryWebsite, String tourOperator) {

        this.url = url;
        this.countryWebsite = countryWebsite;
        this.tourOperator = tourOperator;
    }

    public static Performable toSurfToTailorMadeTripPage(String url, String countryWebsite, String tourOperator) {
        return Instrumented
                .instanceOf(Decided.class)
                .withProperties(url, countryWebsite, tourOperator);
    }

    @Override
    @Step("{0} surfs to the 'Tailor Made Trip' page")
    public <T extends Actor> void performAs(T actor) {

        venturaHomePage.setDefaultBaseUrl(url);
        actor.attemptsTo(Open.browserOn().the(venturaHomePage));

        actor.attemptsTo(WaitUntil.the(BTN_PRIVACY_POLICY, isCurrentlyEnabled()).forNoMoreThan(30).seconds());
        if (CurrentVisibility.of(BTN_PRIVACY_POLICY).viewedBy(actor).asBoolean()) {
            actor.attemptsTo(
                    Click.on(BTN_PRIVACY_POLICY)
            );
        }


        actor.attemptsTo(
                Click.on(TYPE_OF_TRIP),
                Click.on(INDIVIDUAL_TRIP)
        );
    }
}


//div[contains(text(),'Chile')]
//a[@class='sc-bdVaJa sc-bwzfXH StyledFlex-eATlWb INVos']