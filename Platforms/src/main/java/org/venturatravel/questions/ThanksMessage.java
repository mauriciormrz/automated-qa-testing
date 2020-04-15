package org.venturatravel.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static org.venturatravel.ui.PlatformsHomePage.TXT_THANKS_MESSAGE;

public class ThanksMessage {

    public static Question<String> text(){
        return actor -> Text.of(TXT_THANKS_MESSAGE)
                .viewedBy(actor).asString();
    }
}
