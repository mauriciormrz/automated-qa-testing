package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.venturatravel.questions.TodoListQuestions;
import org.venturatravel.ui.ServiceTemplatePage;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static org.venturatravel.ui.DashBoardPage.ICON_TRIP_BUILDER;
import static org.venturatravel.ui.DashBoardPage.SERVICES_TEMPLATES;
import static org.venturatravel.ui.ServiceTemplatePage.*;

public class CreateAServiceTemplate implements Task {

    private String serviceTemplateName;

    private static Boolean createTemplate;
    private static ServiceTemplatePage serviceTemplatePage = new ServiceTemplatePage();

    private TodoListQuestions todoListQuestions = new TodoListQuestions();

    public CreateAServiceTemplate(String serviceTemplateName) {

        this.serviceTemplateName = serviceTemplateName;
    }

    public static Performable named(String serviceTemplateName) {

        return Instrumented.instanceOf(CreateAServiceTemplate.class)
                .withProperties(serviceTemplateName);
    }


    @Override
    @Step("{0} has decided to create a new Service Template '#templateName'")
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                Click.on(ICON_TRIP_BUILDER),
                Click.on(SERVICES_TEMPLATES)
        );

        if (!CurrentVisibility.of(SERVICE_TEMPLATE_NAME.of(serviceTemplateName)).viewedBy(actor).asBoolean()) {

            actor.attemptsTo(
                    Click.on(BTN_NEW_TEMPLATE),
                    WaitUntil.the(TITLE_TEMPLATE, isClickable()).forNoMoreThan(30).seconds(),
                    Type.theValue(serviceTemplateName).into(TITLE_TEMPLATE),
                    Click.on(BTN_SAVE_TEMPLATE)
            );
            System.out.println("---------------------------------------------------------------------------------------------- NO EXISTE");
            createTemplate= true;

        } else {
            createTemplate = false;
            System.out.println("---------------------------------------------------------------------------------------------- EXISTE");
        }

        //utils.wait(160000);

        //actor.attemptsTo(
        //        Check.whether(SERVICE_TEMPLATE_NAME.of(templateName).resolveFor(actor).isPresent())
        //.andIfSo()
        //);

        // getDriver().navigate().refresh();

    }
}
