package org.venturatravel.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class GalapatoursPage extends PageObject {

    public static String OK_COOKIES = "#notice-cookie-block > div> div.actions > button";

    public static final Target LABEL_FIND_YOUR_GALAPAGOS_CRUISE = Target.the("Label Find Your Galapagos Cruise")
            .located(By.xpath("//h1[@class='galapatours-banner-title']"));

    public static final Target CHECK_IN_DATE = Target.the("Check in date")
            .located(By.id("checkinDate"));

    public static final Target BUTTON_NEXT = Target.the("Next month")
            .located(By.xpath("//a[@class='ui-datepicker-next ui-corner-all']"));

    public static final Target BUTTON_SEARCH = Target.the("Button Search")
            .located(By.id("submit_location_home"));


}
