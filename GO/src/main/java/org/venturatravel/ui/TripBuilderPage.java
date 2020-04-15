package org.venturatravel.ui;


import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TripBuilderPage  extends UIInteractionSteps {

    public static final Target TRIP_BUILDER = Target.the("the 'Trip Builder' menu option")
            .located(By.xpath("//span[contains(text(),'Trip Builder')]"));

    public static final Target BTN_TYPE_OF_TRIP = Target.the("What kind of trip are you creating?")
            .locatedBy("//div[contains(@id,'{0}')]");

    public static final Target BTN_NEXT_STEP = Target.the("the 'NEXT STEP' button")
            .located(By.cssSelector("#next-btn"));

    public final static Target TXT_TRIP_NAME = Target.the("Trip Name field")
            .locatedBy("#name");

    public static final Target POINTER_MARKET = Target.the("Pointer Market")
            .located(By.xpath("//div[@name='locale']//div[@class='pointer']"));

    public final static Target TXT_TRIP_CODE = Target.the("Trip Code field")
            .locatedBy("#trip_code");

    public static final Target POINTER_START_DESTINATION = Target.the("Pointer Start Destination")
            .located(By.xpath("//div[@name='start_destination']//div[@class='pointer']"));

    public static final Target POINTER_END_DESTINATION = Target.the("Pointer End Destination")
            .located(By.xpath("//div[@name='end_destination']//div[@class='pointer']"));

    public static final Target POINTER_GUIDANCE_TYPE = Target.the("Pointer Guidance Type")
            .located(By.xpath("//div[@name='guidance_type']//div[@class='pointer']"));

    public static final Target POINTER_TRIP_CATEGORY = Target.the("Pointer Trip Category")
            .located(By.xpath("//div[@name='trip_category']//div[@class='pointer']"));

    public final static Target INPUT_MIN_PAX = Target.the("Min Pax field")
            .locatedBy("#min_pax");

    public final static Target INPUT_MAX_PAX = Target.the("Max Pax field")
            .locatedBy("#max_pax");

    public final static Target INPUT_TOTAL_DAYS = Target.the("Total Days field")
            .locatedBy("#total_days");

    public final static Target INPUT_TOTAL_AVERAGE_PAX = Target.the("Total Average Pax field")
            .locatedBy("#avg_pax");

    public final static Target INPUT_LENGTH = Target.the("Length field")
            .locatedBy("#length");

    public static final Target POINTER_HOST = Target.the("Pointer End Host")
            .located(By.xpath("//div[@name='host']//div[@class='pointer']"));


}
