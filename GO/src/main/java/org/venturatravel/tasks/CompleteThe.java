package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.type.Type;

import static org.venturatravel.ui.TripBuilderPage.*;

public class CompleteThe implements Task {

    int total_days;
    int min_pax;
    int max_pax;

    public CompleteThe(int total_days, int min_pax, int max_pax) {

        this.total_days = total_days;
        this.min_pax = min_pax;
        this.max_pax = max_pax;
    }

    public static Performable detailSection(int total_days, int min_pax, int max_pax) {
        return Instrumented.instanceOf(CompleteThe.class)
                .withProperties(total_days, min_pax, max_pax);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Type.theValue(String.valueOf(min_pax)).into(INPUT_MIN_PAX),
                Type.theValue(String.valueOf(max_pax)).into(INPUT_MAX_PAX),
                Type.theValue(String.valueOf(total_days)).into(INPUT_TOTAL_DAYS)
        );
    }
}
