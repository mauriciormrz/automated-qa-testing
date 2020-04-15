package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.venturatravel.ui.DashBoardPage.*;
import static org.venturatravel.ui.ServiceTemplatePage.*;

public class DeleteAServiceTemplate implements Task {

    private String templateName;

    public DeleteAServiceTemplate(String templateName) {

        this.templateName = templateName;
    }

    public static Performable called(String templateName) {
        return Instrumented.instanceOf(DeleteAServiceTemplate.class)
                .withProperties(templateName);
    }

    @Override
    @Step("{0} has decided to delete a Service Template '#templateName'")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Click.on(ICON_TRIP_BUILDER),
                Click.on(SERVICES_TEMPLATES)
        );

        WebElement element =  getDriver().findElement(By.id("exploreTemplates"));
        List<WebElement> serviceTemplateList = element.findElements(By.tagName("a"));

        int cellsCount = serviceTemplateList.size();
        //int serviceCount = 0;

        for (int i = cellsCount - 1; i > 0; i--) {
            String cellText = serviceTemplateList.get(i).getText();
            if (cellText.equals(templateName)) {

                actor.attemptsTo(
                        Click.on(LNK_SUB_MENU.of(Integer.toString(i + 1))),
                        Click.on(OPTION_REMOVE),
                        Click.on(BTN_DELETE_TEMPLATE)
                );
                //return i + 1;
            }
        }
    }
}
