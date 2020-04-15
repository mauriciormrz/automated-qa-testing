package org.venturatravel.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeLandingPage extends PageObject {

    public static String PRIVACY_POLICY = "//*[@id='vPrivacyBanner']/div/button";

    public static final Target BTN_PRIVACY_POLICY = Target.the("'Accept' button to store cookies")
            .located(By.xpath(PRIVACY_POLICY));

    public static final Target TYPE_OF_TRIP = Target.the("the 'Type of Trip' menu option")
            .located(By.xpath("//span[contains(text(),'Reisetyp') or contains(text(),'Voyage')]"));

    public static final Target INDIVIDUAL_TRIP = Target.the("Individual Trip")
            .located(By.xpath("//div[contains(text(),'Maßgeschneiderte Reise') or contains(text(),'Voyage Individuel')]"));

    public static final Target BTN_NO_PARTICIPATION = Target.the("Button 'No Participation'")
            .located(By.cssSelector("#step4_noparticipation_cta2"));
}

