package org.venturatravel.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.venturatravel.ui.ServiceTemplatePage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;
import static org.venturatravel.ui.LoginPage.MSG_LOGIN_FAILED;
import static org.venturatravel.ui.ServiceTemplatePage.BTN_NEW_TEMPLATE;


public class ServiceTemplateExists implements Question<Boolean> {

    private static ServiceTemplatePage serviceTemplatePage = new ServiceTemplatePage();
    private String serviceTemplateName;

    public ServiceTemplateExists(String serviceTemplateName) {

        this.serviceTemplateName = serviceTemplateName;
    }

    public static ServiceTemplateExists itWasCreated(String serviceTemplateName) {

        return new ServiceTemplateExists(serviceTemplateName);
    }

    @Override
    @Step("{0} checks if the #serviceTemplateName exits")
    public Boolean answeredBy(Actor actor) {


        actor.attemptsTo(
                WaitUntil.the(BTN_NEW_TEMPLATE, isEnabled()).forNoMoreThan(30).seconds()
        );

        return serviceTemplatePage.findServiceTemplate(actor, serviceTemplateName) > 0;
    }
}