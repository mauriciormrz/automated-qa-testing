package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.type.Type;

import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;


import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

import static org.venturatravel.ui.ServiceTemplatePage.*;

public class Create implements Task {

    private static String serviceTemplateName;

    public Create(String serviceTemplateName) {

        Create.serviceTemplateName = serviceTemplateName;
    }

    public static Performable newServiceTemplate(String serviceTemplateName) {

        return Instrumented.instanceOf(Create.class)
                .withProperties(serviceTemplateName);
    }


    @Override
    @Step("{0} has decided to create a new Service Template")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(ICON_TRIP_BUILDER),
                Click.on(SERVICES_TEMPLATES)
        );

        if (!CurrentVisibility.of(SERVICE_TEMPLATE_NAME.of(serviceTemplateName)).viewedBy(actor).asBoolean()) {
            actor.attemptsTo(
                    Click.on(BTN_NEW_TEMPLATE),
                    WaitUntil.the(TITLE_TEMPLATE, isClickable()).forNoMoreThan(30).seconds(),
                    Type.theValue(serviceTemplateName).into(TITLE_TEMPLATE),
                    Click.on(BTN_SAVE_TEMPLATE)
            );
            //actor.attemptsTo(
            //        Check.whether(SERVICE_TEMPLATE_NAME.of(serviceTemplateName).resolveFor(actor).isPresent())
            //.andIfSo()
            //);
             getDriver().navigate().refresh();
        }

    }
}

