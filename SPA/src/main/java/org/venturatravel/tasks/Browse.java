package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.venturatravel.questions.CurrentUrl;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.venturatravel.ui.CountryWebsitePage.IMG_FRANCE_WEBSITE;
import static org.venturatravel.ui.CountryWebsitePage.IMG_GERMANY_WEBSITE;
import static org.venturatravel.ui.HomeLandingPage.BTN_PRIVACY_POLICY;
import static org.venturatravel.ui.HomeLandingPage.PRIVACY_POLICY;

public class Browse implements Task {

    private String browserAction;
    private String countryWebsite;
    private String tourOperator;
    private String idWindowHomePage;
    private String tourType;

    private CurrentUrl theCurrentUrl = new CurrentUrl();


    public Browse(String browserAction, String countryWebsite, String tourOperator, String idWindowHomePage) {

        this.browserAction = browserAction;
        this.countryWebsite = countryWebsite;
        this.tourOperator = tourOperator;
        this.idWindowHomePage = idWindowHomePage;

    }

    public Browse(String browserAction) {

        this.browserAction = browserAction;
    }

    public static Browse toNewTab(String countryWebsite, String tourOperator, String idWindowHomePage) {

        return Instrumented
                .instanceOf(Browse.class)
                .withProperties("browse to the new tab", countryWebsite, tourOperator, idWindowHomePage);
    }

    public static Browse toHomeTab(String idWindowHomePage) {

        return Instrumented
                .instanceOf(Browse.class)
                .withProperties("return to the previous tab", idWindowHomePage);
    }

    public static Performable theForm() {
        return Instrumented
                .instanceOf(Browse.class)
                .withProperties("browse to the reserve page");
    }

    @Override
    @Step("{0} uses the browser to go to the new tab of the country website")
    public <T extends Actor> void performAs(T actor) {

        if (("browse to the new tab").equals(browserAction)) {
            for (String idTabs : getDriver().getWindowHandles()) {
                if (!idTabs.equals(idWindowHomePage)) {
                    getDriver().switchTo().window(idTabs);
                }
            }
            switch (countryWebsite.toLowerCase()) {
                case "germany":
                    actor.attemptsTo(
                            WaitUntil.the(IMG_GERMANY_WEBSITE, isClickable()).forNoMoreThan(30).seconds(),
                            Click.on(IMG_GERMANY_WEBSITE),
                            WaitUntil.the(IMG_GERMANY_WEBSITE, isNotCurrentlyVisible()).forNoMoreThan(30).seconds()
                    );
                    break;
                case "france":
                    actor.attemptsTo(
                            WaitUntil.the(IMG_FRANCE_WEBSITE, isClickable()).forNoMoreThan(30).seconds(),
                            Click.on(IMG_FRANCE_WEBSITE),
                            WaitUntil.the(IMG_FRANCE_WEBSITE, isNotCurrentlyVisible()).forNoMoreThan(30).seconds()
                    );
                    break;
            }

        } else if (("return to the previous tab").equals(browserAction)) {
            getDriver().switchTo().window(idWindowHomePage);

        } else if (("browse to the reserve page").equals(browserAction)) {
            if (CurrentVisibility.of(BTN_PRIVACY_POLICY).viewedBy(actor).asBoolean()) {
                actor.attemptsTo(
                        Click.on(BTN_PRIVACY_POLICY)
                );
            }
        }
    }
}