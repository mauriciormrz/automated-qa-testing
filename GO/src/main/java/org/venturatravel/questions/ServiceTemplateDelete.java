package org.venturatravel.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isEnabled;

import static org.venturatravel.ui.ServiceTemplatePage.MSG_TEMPLATE_DELETE;

public class ServiceTemplateDelete implements Question<String> {

    public static ServiceTemplateDelete message() {

        return new ServiceTemplateDelete();
    }

    @Override
    public String answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(MSG_TEMPLATE_DELETE, isCurrentlyVisible()).forNoMoreThan(30).seconds()
        );
        return Text.of(MSG_TEMPLATE_DELETE).viewedBy(actor).asString();
    }
}
