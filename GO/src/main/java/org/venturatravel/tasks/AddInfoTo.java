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

public class AddInfoTo implements Task {

    private static String trip_code;
    private static String start_destination;
    private static String end_destination;
    private static String guidance_type;
    private static String trip_category;
    private static int average_cost;
    private static String meal_comments;
    private static String general_comments;



    public AddInfoTo(String trip_code, String start_destination, String end_destination, String guidance_type, String trip_category, int average_cost, String meal_comments, String general_comments) {

        this.trip_code = trip_code;
        this.start_destination = start_destination;
        this.end_destination = end_destination;
        this.guidance_type = guidance_type;
        this.trip_category = trip_category;
        this.average_cost = average_cost;
        this.meal_comments = meal_comments;
        this.general_comments = general_comments;
    }


    public static Performable theTripDetailsForm(String trip_code, String start_destination, String end_destination, String guidance_type, String trip_category, int average_cost, String meal_comments, String general_comments) {
        return Instrumented.instanceOf(AddInfoTo.class)
                .withProperties(trip_code, start_destination, end_destination, guidance_type, trip_category, average_cost, meal_comments, general_comments);

    }


    @Override
    public <T extends Actor> void performAs(T actor) {

            actor.attemptsTo(
                    Type.theValue(trip_code).into(TXT_TRIP_CODE),
                    Click.on(POINTER_START_DESTINATION)
            );
            getDriver().findElement(By.cssSelector(".Dropdown-Options-Popup [data-optionlabel*='" + start_destination + "'")).click();

            actor.attemptsTo(Click.on(POINTER_END_DESTINATION));
            getDriver().findElement(By.cssSelector(".Dropdown-Options-Popup [data-optionlabel*='" + end_destination + "'")).click();

            actor.attemptsTo(Click.on(POINTER_GUIDANCE_TYPE));
            getDriver().findElement(By.cssSelector(".Dropdown-Options-Popup [data-optionlabel*='" + guidance_type + "'")).click();

            actor.attemptsTo(Click.on(POINTER_TRIP_CATEGORY));
            getDriver().findElement(By.cssSelector(".Dropdown-Options-Popup [data-optionlabel*='" + trip_category + "'")).click();
    }


}
