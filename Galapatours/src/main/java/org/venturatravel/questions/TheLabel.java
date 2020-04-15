package org.venturatravel.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static org.venturatravel.ui.CruisesPage.*;

public class TheLabel implements Question<String> {


    public static TheLabel is() {
        return new TheLabel();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(LABEL_AVAILABILITIES_AND_PRICES).viewedBy(actor).asString();
    }
}
