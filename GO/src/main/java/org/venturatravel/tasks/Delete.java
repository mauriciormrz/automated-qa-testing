package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.thucydides.core.annotations.Step;
import org.venturatravel.ui.ServiceTemplatePage;


public class Delete implements Task {

    private static String serviceTemplateName;
    private static ServiceTemplatePage serviceTemplatePage = new ServiceTemplatePage();

    public Delete(String serviceTemplateName) {

        Delete.serviceTemplateName = serviceTemplateName;
    }

    public static Performable serviceTemplate(String serviceTemplateName) {

        return Instrumented.instanceOf(Delete.class)
                .withProperties(serviceTemplateName);
    }

    @Override
    @Step("{0} has decided to delete a Service Template")
    public <T extends Actor> void performAs(T actor) {

        serviceTemplatePage.deleteServiceTemplate(actor, serviceTemplateName);
    }
}

