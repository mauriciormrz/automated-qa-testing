package org.venturatravel.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import org.venturatravel.utilities.utils;

import java.util.List;

import static org.venturatravel.ui.DashBoardPage.ICON_TRIP_BUILDER;
import static org.venturatravel.ui.DashBoardPage.SERVICES_TEMPLATES;
import static org.venturatravel.ui.ServiceTemplatePage.SERVICE_TEMPLATE_LIST;

public class TheServiceTemplates {

    public static <T> Question<List<String>> displayed() {

        return actor -> Text.of(SERVICE_TEMPLATE_LIST).viewedBy(actor).asList();
    }

}


