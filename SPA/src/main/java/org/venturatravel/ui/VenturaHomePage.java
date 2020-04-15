package org.venturatravel.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.venturatravel.utilities.utils;


import static org.venturatravel.ui.HomeLandingPage.BTN_PRIVACY_POLICY;


@DefaultUrl("https://www.venturatravel.org/")

public class VenturaHomePage extends PageObject {

    public static String ACCEPT_COOKIES = "//*[@id='vPrivacyBanner']/div/button";

    public static final Target BTN_ACCEPT_COOKIES = Target.the("'Accept' button to store cookies")
            .located(By.cssSelector("#vPrivacyBanner > div > button"));


    public static final Target LBL_TRAVEL_WITH_US = Target.the("menu option 'Travel with us'")
            .located(By.cssSelector("#traveler .icon"));

    public static final String ID_BEST_SELLING_TRIP = "trip1";

    public static final Target LNK_BEST_SELLING_TRIP = Target.the("the 'Bestseller Trip'")
            .located(By.id(ID_BEST_SELLING_TRIP));


    public void surfCountryWebSite(Actor actor) {

        utils.wait(502);

        if (CurrentVisibility.of(BTN_PRIVACY_POLICY).viewedBy(actor).asBoolean()) {
            actor.attemptsTo(
                    Click.on(BTN_PRIVACY_POLICY)
            );
        }
    }
}

