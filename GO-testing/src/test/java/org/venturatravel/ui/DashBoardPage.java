package org.venturatravel.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DashBoardPage extends PageObject {

    public static final Target ICON_VMEMBERS = Target.the("the 'VMembers' dashboard icon")
            .located(By.xpath("//div[@title='VMembers']"));

    public static final Target ICON_TRIP_BUILDER = Target.the("the 'Trip Builder' dashboard icon")
            .located(By.xpath("//div[@title='Trip Builder']"));

    public static final Target SERVICES_TEMPLATES = Target.the("the 'Templates' menu option")
            .located(By.xpath(" //span[contains(text(),'Templates')]"));

    public static final Target TAG_ROLE = Target.the("Tag Role")
            .located(By.xpath(" //label[contains(text(),'ROLES')]"));


}
