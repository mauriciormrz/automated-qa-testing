package org.venturatravel.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TravelWithUsPage extends PageObject {

    public static final Target MENU_FIND_YOUR_TRIP = Target.the("Menu option Find Your Trip")
            .located(By.xpath("//*[contains(@class,'hs-menu-item hs-menu-depth-1')]//a[contains(text(),'Find your trip')]"));


    public static final Target LABEL_GALAPATOURS = Target.the("Label Galapatours")
            .located(By.xpath("//p[contains(text(),'is an online booking portal for cruises on the Gal')]"));
}
