package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Performable;
import org.venturatravel.actions.StartWithAPopulatedList;
import org.venturatravel.actions.StartWithAnEmptyList;

import java.util.List;

public class Start {


    public static Performable withAnEmptyList() {

        return Instrumented.instanceOf(StartWithAnEmptyList.class)
                .newInstance();
    }

    public static Performable withATodoListOf(List<String> tasks) {

        return Instrumented.instanceOf(StartWithAPopulatedList.class)
                .withProperties(tasks);

    }

}
