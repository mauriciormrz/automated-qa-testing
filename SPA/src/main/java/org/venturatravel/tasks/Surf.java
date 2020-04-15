package org.venturatravel.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.venturatravel.utilities.utils;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.venturatravel.ui.TailorMadePage.TXT_GROUP_TRIP;
import static org.venturatravel.ui.TravelWithUsPage.*;
import static org.venturatravel.ui.VenturaHomePage.*;

public class Surf implements Task {

    private String tourOperator;

    public Surf(String tourOperator) {
        this.tourOperator = tourOperator;
    }

    public static Performable toVenturaTravelWebSite(String tourOperator) {
        return instrumented(Surf.class, tourOperator);
    }

    @Override
    @Step("{0} navigates to the tour operator website link")
    public <T extends Actor> void performAs(T actor) {

        if (getDriver().findElement(By.xpath(ACCEPT_COOKIES)).isDisplayed()) {
            actor.attemptsTo(
                    WaitUntil.the(BTN_ACCEPT_COOKIES, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(BTN_ACCEPT_COOKIES)
            );
        }

        utils.wait(1002);

        actor.attemptsTo(
                Click.on(LBL_TRAVEL_WITH_US),
                WaitUntil.the(MENU_FIND_YOUR_TRIP, isClickable()).forNoMoreThan(30).seconds(),
                Click.on(MENU_FIND_YOUR_TRIP)
        );

        utils.wait(1002);

        actor.attemptsTo(
                WaitUntil.the(LNK_TOUR_OPERATOR.of(tourOperator), isClickable()).forNoMoreThan(30).seconds(),
                Click.on(LNK_TOUR_OPERATOR.of(tourOperator))
        );
    }
}
