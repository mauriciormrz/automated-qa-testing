package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static org.venturatravel.ui.PlatformsHomePage.*;


public class TellUs implements Task {


    private static String when;
    private static String how_many;
    private static String where;
    private static String questionnaire;

    public TellUs(String where, String how_many, String when) {

        switch (where) {
            case "Andes":
                this.where = "1";
                break;
            case "Coast":
                this.where = "2";
                break;
            case "Amazon":
                this.where = "3";
                break;
            default:
                this.where = "4";
        }

        switch (how_many) {
            case "1":
            case "2":
            case "3+":
                this.how_many = how_many.substring(0,1);
                break;
            default:
                this.how_many = "4";
        }

        questionnaire = "3";
        switch (when) {
            case "4 weeks":
                this.when = "1";
                break;
            case "1 - 3 Months":
                this.when = "2";
                break;
            case "4+ Months":
                this.when = "3";
                break;
            default:
                this.when = "4";
        }
    }

    public static Performable thePlans(String when, String how_many, String where) {

        return Instrumented.instanceOf(TellUs.class)
                .withProperties(when, how_many, where);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(BTN_WHERE.of(where)),
                Click.on(BTN_HOW_MANY.of(how_many)),
                Click.on(BTN_WHEN.of(questionnaire,when))
        );
    }
}
