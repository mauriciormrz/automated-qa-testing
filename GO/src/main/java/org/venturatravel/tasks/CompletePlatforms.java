package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.type.Type;
import org.openqa.selenium.By;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.venturatravel.ui.TripBuilderPage.*;

public class CompletePlatforms implements Task {

    private String length;
    private String host;

    public CompletePlatforms(String host, String length) {

        this.host = host;
        this.length= length;
    }

    public static Performable detailsForm(String host, String length) {

        return Instrumented.instanceOf(CompletePlatforms.class)
                .withProperties(host,length );
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Type.theValue(length).into(INPUT_LENGTH),
                Click.on(POINTER_HOST)
        );
        getDriver().findElement(By.cssSelector(".Dropdown-Options-Popup [data-optionlabel*='" + host + "'")).click();

    }
}
