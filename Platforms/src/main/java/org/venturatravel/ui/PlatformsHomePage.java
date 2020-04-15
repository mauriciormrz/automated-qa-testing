package org.venturatravel.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://staging.polartours.com/")
public class PlatformsHomePage extends PageObject {

    public static final Target BTN_FIND_MY_TRIP_NOW = Target.the("Presentation action button 'FIND MY TRIP NOW'")
            .located(By.cssSelector("#presentation-action-button"));

    public static final Target BTN_WHERE = Target.the("Where do you want to travel button")
            .locatedBy("//button[@id='q1-opt{0}']");

    public static final Target BTN_HOW_MANY = Target.the("How many people will travel button")
            .locatedBy("//button[@id='q2-opt{0}']");

    public static final Target BTN_WHEN = Target.the("When would you like to go button")
            .locatedBy("//button[@id='q{0}-opt{1}']");

    public static final Target TXT_FIRST_NAME = Target.the("the 'First Name' field")
            .located(By.id("first-name"));

    public static final Target TXT_LAST_NAME = Target.the("the 'Last Name' field")
            .located(By.id("last-name"));

    public static final Target TXT_EMAIL = Target.the("the 'Email' field")
            .located(By.id("email"));

    public static final Target BTN_CONTINUE = Target.the("the 'Continue' button")
            .located(By.xpath("//span[contains(text(),'Continue')]"));

    public static final Target TXT_PHONE = Target.the("the 'Phone' field")
            .located(By.xpath("//input[@id='lead-quiz-phone']"));

    public static final Target BTN_GET_TRAVEL_OFFERS_NOW = Target.the("the 'Get Travel Offers Now' button")
            .located(By.xpath("//span[contains(text(),'Get Travel Offers now')]"));

    public static final Target TXT_THANKS_MESSAGE = Target.the("'Thanks message")
            .located(By.id("lead-quiz-confirmation-title"));

    public static String PRIVACY_POLICY = "#vPrivacyBanner > div > button";

    public static final Target BTN_PRIVACY_POLICY = Target.the("'Accept' button to store cookies")
            .located(By.cssSelector(PRIVACY_POLICY));

}
