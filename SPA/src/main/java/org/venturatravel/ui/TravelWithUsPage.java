package org.venturatravel.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TravelWithUsPage extends PageObject {

    public static final Target MENU_FIND_YOUR_TRIP = Target.the("menu option 'Find your trip'")
            .located(By.xpath("//*[contains(@class,'hs-menu-item hs-menu-depth-1')]//a[contains(text(),'Find your trip')]"));

    public static final Target LNK_TOUR_OPERATOR = Target.the("the tour operator link")
            .locatedBy("//span[contains(text(),'{0}')]");

}
