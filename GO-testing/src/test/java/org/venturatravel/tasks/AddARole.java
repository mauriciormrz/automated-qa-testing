package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.venturatravel.questions.RecordUpdate;
import org.venturatravel.utilities.utils;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.hamcrest.CoreMatchers.containsString;
import static org.venturatravel.constants.Constants.RECORD_UPDATE_SUCCESSFULLY_MSG;
import static org.venturatravel.tasks.EditTheGoUser.addOneToTheNumberOfRolesValue;
import static org.venturatravel.ui.GoUserPage.*;

public class AddARole implements Task {

    private final String role;


    public AddARole(String role) {

        this.role = role;
    }

    public static Performable called(String role) {

        return Instrumented.instanceOf(AddARole.class)
                .withProperties(role);
    }

    @Override
    @Step("{0} Adds the role '#role'")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Scroll.to(TAG_ROLE));

        if (!CurrentVisibility.of(ADD_ROLE.of(role)).viewedBy(actor).asBoolean()) {

            actor.attemptsTo(
                    Scroll.to(TAG_ROLE),
                    Click.on(POINTER_ROLE)
            );

            getDriver().findElement(By.cssSelector(".Dropdown-Options-Popup [data-optionlabel*='" + role + "'")).click();

            utils.wait(1001);
            actor.attemptsTo(
                    WaitUntil.the(BTN_SAVE, isCurrentlyVisible()).forNoMoreThan(60).seconds(),
                    Click.on(BTN_SAVE)
            );

            actor.should(seeThat("Record updated successfully", RecordUpdate.message(), containsString(RECORD_UPDATE_SUCCESSFULLY_MSG)));
            addOneToTheNumberOfRolesValue();
        }

        actor.attemptsTo(
                Scroll.to(LNK_BACK),
                Click.on(LNK_BACK)
        );
    }
}
