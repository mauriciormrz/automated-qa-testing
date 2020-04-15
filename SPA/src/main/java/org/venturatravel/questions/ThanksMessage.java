package org.venturatravel.questions;

import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static org.venturatravel.constants.Constants.*;
import static org.venturatravel.ui.HelperComponentPage.TXT_THANKS_CONTACT;
import static org.venturatravel.ui.TailorMadePage.TXT_THANKS_RESERVATION;


public class ThanksMessage {

    public static Question<String> text(String thanksMessage) {

        switch (thanksMessage) {
            case THANKS_MESSAGE_RESERVATION:
                return actor -> Text.of(TXT_THANKS_RESERVATION)
                        .viewedBy(actor).asString();
            default:
                return actor -> Text.of(TXT_THANKS_CONTACT)
                        .viewedBy(actor).asString();
        }
    }

    public static String selectCountry(String countryWebsite) {

        String msg = countryWebsite.equals("Germany") ? THANKS_MESSAGE_GERMAN_RESERVATION : THANKS_MESSAGE_FRANCE_RESERVATION;
        return msg;
    }
}


