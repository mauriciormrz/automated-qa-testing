package org.venturatravel.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TailorMadePage extends PageObject {

    public static final Target GREEN_BOX_TAILOR_MADE_TRIP = Target.the("link 'Assemble the trip in just 2 steps'")
            .located(By.xpath("//a[@class='sc-bdVaJa sc-bwzfXH StyledFlex-eATlWb INVos']"));

    public static final Target NAME = Target.the("Name field")
            .located(By.name("first_name"));

    public static final Target LAST_NAME = Target.the("Last name field")
            .located(By.name("last_name"));

    public static final Target EMAIL = Target.the("Email field")
            .located(By.xpath("//input[@placeholder='myemail@example.com']"));

    public static final Target BTN_SEND = Target.the("the 'Send' button")
            .located(By.xpath("//button[contains(@id,'fixedbar-action-')]"));

    public static final Target LOADING = Target.the("the 'Loading' icon")
            .located(By.xpath("//div[@class='sc-bdVaJa StyledBox-huGWDM eMJQfB']"));

    public static final Target TXT_THANKS_RESERVATION = Target.the("Thanks message")
            .located(By.xpath("//span[@class='sc-bdVaJa StyledBox-huGWDM Text-bbIbrg kjbwFI']"));

    public static final Target TXT_GROUP_TRIP = Target.the("Group of trip text")
            .located(By.xpath("//span[contains(text(),'Gruppenreisen') or contains(text(),'Voyages en groupe')]"));

    public static final Target ACCOMODATION_STANDARD = Target.the("Accomodation Standard input")
            .located(By.id("accomodation-Standard"));

    public static final Target TXT_DEPARTURE_DATE = Target.the("Departure Date")
            .located(By.xpath("//span[contains(text(),'Reisetermin') or contains(text(),'Sélectionner une date de départ')]"));

}


