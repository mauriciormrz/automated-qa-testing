package org.venturatravel.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://www.venturatravel.org/")
public class VenturaTravelHomePage extends PageObject {

    public static String ACCEPT_COOKIES = "//*[@id='vPrivacyBanner']/div/button";

    public static final Target LABEL_TRAVEL_WITH_US = Target.the("Option Travel with us")
            .located(By.xpath("//*[contains(text(),'Become an accomplished traveler')]"));
}
