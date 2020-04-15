package org.venturatravel.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class TripLandingPage extends PageObject {
    public static final Target TYPE_OF_ACCOMODATION = Target.the("'Type of Accommodation' select")
            .located(By.id("control-input-booking-rooms-select"));

    public static final Target HALF_DOUBLE_ACCOMMODATION = Target.the("'Half Double Accommodation'")
            .located(By.xpath("//div[@data-id='30']"));

    public static final Target BTN_SUBMIT = Target.the("'Submit' button")
            .located(By.xpath("//*[@type='submit'][@role='button']"));

    public static final Target TYPE_OF_GENDER = Target.the("'Type of Gender' select")
            .located(By.id("control-input-booker-genres"));

    public static final Target GENDER = Target.the("'Gender' option")
            .locatedBy("//div[@data-id='{0}']");

    public static final Target NAME = Target.the("Name field")
            .located(By.name("name"));

    public static final Target LAST_NAME = Target.the("Lastname field")
            .located(By.name("lastname"));

    public static final Target EMAIL = Target.the("Email field")
            .located(By.name("email"));

    public static final Target PHONE = Target.the("Phone field")
            .located(By.name("phone"));

    public static final Target TYPE_OF_SALUTATION = Target.the("'Type of Salutation' select")
            .located(By.id("control-input-booker-salutations"));

    public static final Target SALUTATION = Target.the("'Salutation' option")
            .locatedBy("//div[@data-id='{0}']");

    public static final Target TERMS = Target.the("'Terms and Conditions' are accepted")
            .located(By.xpath("//div[@id='checkboxes-box']//span[1]"));

    public static final Target DEPARTURE_DATES = Target.the("'departure dates")
            .located(By.id("sm_departure_label"));

    public static final Target DEPARTURE_PRICE = Target.the("departure total value")
            .located(By.id("sm_total_value"));



}


