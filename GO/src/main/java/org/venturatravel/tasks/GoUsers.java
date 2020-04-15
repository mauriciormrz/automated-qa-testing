package org.venturatravel.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.actions.type.Type;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.venturatravel.utilities.utils;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;
import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.venturatravel.ui.GoUsersPage.*;

public class GoUsers implements Task {

    private final String action;

    private static String role;
    private static String vMember;
    private static Boolean rolExist;
    private static Integer roles_count;


    public GoUsers(String action, String vMember) {

        this.action = action;
        GoUsers.vMember = vMember;
    }

    public GoUsers(String action, String role, String message) {

        this.action = action;
        GoUsers.role = role;
    }


    public static Performable toEdit(String vMember) {

        return Instrumented.instanceOf(GoUsers.class)
                .withProperties("edit user", vMember);
    }

    public static Performable toAdd(String role, String message) {
        return Instrumented.instanceOf(GoUsers.class)
                .withProperties("add role", role, message);
    }

    public static Performable toDelete(String role, String message) {
        return Instrumented.instanceOf(GoUsers.class)
                .withProperties("delete role", role, message);
    }

    public static Boolean getRolExist() {

        return rolExist;
    }

    public static Integer getRoles_count() {

        return roles_count;
    }

    private void editUser(Actor actor) {

        actor.attemptsTo(
                Click.on(GO_USERS),
                Type.theValue(vMember).into(SEARCH)
        );

       actor.attemptsTo(
               WaitUntil.the(LOADING, isCurrentlyVisible()).forNoMoreThan(30).seconds(),
               WaitUntil.the(LOADING, isNotPresent()).forNoMoreThan(30).seconds()
       );


        roles_count = Text.of(ROLE_VALUE).viewedBy(actor).asInteger();

        actor.attemptsTo(
                WaitUntil.the(ICON_EDIT, isCurrentlyEnabled()).forNoMoreThan(30).seconds(),
                Click.on(ICON_EDIT),
                Scroll.to(TAG_ROLE)
        );
    }


    private void addRole(Actor actor) {

        rolExist = CurrentVisibility.of(ADD_ROLE.of(role)).viewedBy(actor).asBoolean();

        if (getRolExist()) {
            actor.attemptsTo(
                    WaitUntil.the(BTN_CANCEL, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(BTN_CANCEL)
            );

        } else {
            actor.attemptsTo(
                    WaitUntil.the(POINTER_ROLE, isEnabled()).forNoMoreThan(30).seconds(),
                    Click.on(POINTER_ROLE)
            );

            getDriver().findElement(By.cssSelector(".Dropdown-Options-Popup [data-optionlabel*='" + role + "'")).click();
            actor.attemptsTo(
                    WaitUntil.the(BTN_SAVE, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(BTN_SAVE)
            );

        }
    }

    private void deleteRole(Actor actor) {

        rolExist = CurrentVisibility.of(ADD_ROLE.of(role)).viewedBy(actor).asBoolean();

        if (getRolExist()) {
            actor.attemptsTo(
                    WaitUntil.the(CROSS_ROLE.of(role), isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(CROSS_ROLE.of(role)),
                    WaitUntil.the(BTN_SAVE, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(BTN_SAVE)
            );
        } else {
            actor.attemptsTo(
                    WaitUntil.the(BTN_CANCEL, isClickable()).forNoMoreThan(30).seconds(),
                    Click.on(BTN_CANCEL)
            );
        }
    }

    @Override
    @Step("{0} have decided #action a new rol to the #vMember")
    public <T extends Actor> void performAs(T actor) {

        switch (action) {
            case "edit user":
                editUser(actor);
                break;
            case "add role":
                addRole(actor);
                break;
            case "delete role":
                deleteRole(actor);
                break;
        }
    }

}

/*
        boolean esta =CurrentVisibility.of(ADD_ROLE.of(role)).viewedBy(actor).asBoolean();
        actor.attemptsTo(
                Check.whether(CurrentVisibility.of(ADD_ROLE.of(role)).viewedBy(actor).asBoolean())
                        .andIfSo(
                                WaitUntil.the(BTN_CANCEL, isEnabled()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_CANCEL)
                        )
                        .otherwise(
                                WaitUntil.the(BTN_SAVE, isEnabled()).forNoMoreThan(30).seconds(),
                                Click.on(BTN_SAVE)
                        )
        );
    }
 */
