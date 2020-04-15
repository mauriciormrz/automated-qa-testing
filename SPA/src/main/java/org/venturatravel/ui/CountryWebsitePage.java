package org.venturatravel.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CountryWebsitePage extends PageObject {

    public static final Target IMG_GERMANY_WEBSITE = Target.the("the 'Germany' website image")
            .located(By.id("hs-link-module_1558085117074179_"));

    public static final Target IMG_FRANCE_WEBSITE = Target.the("the 'France' website image")
            .located(By.id("hs-link-module_1558085146288182_"));
}
