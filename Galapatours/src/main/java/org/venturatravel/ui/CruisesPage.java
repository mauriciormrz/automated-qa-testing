package org.venturatravel.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CruisesPage {

    public static final Target LABEL_AVAILABILITIES_AND_PRICES = Target.the("Label AVAILABILITIES & PRICES")
            .located(By.xpath("//h1[contains(text(),'GALAPAGOS CRUISES: AVAILABILITIES & PRICES')]"));
}
