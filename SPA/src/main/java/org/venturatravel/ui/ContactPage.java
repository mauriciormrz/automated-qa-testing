package org.venturatravel.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ContactPage extends PageObject {

    public static final Target FIRSTNAME_CONTACT = Target.the("Firstname field")
            .located(By.xpath("//input[contains(@id,'firstname')]"));

    public static final Target LASTNAME_CONTACT = Target.the("Lastname field")
            .located(By.xpath("//input[contains(@id,'lastname')]"));

    public static final Target PHONE_CONTACT = Target.the("Phone field")
            .located(By.xpath("//input[contains(@id,'phone')]"));

    public static final Target EMAIL_CONTACT = Target.the("Email field")
            .located(By.xpath("//input[contains(@id,'email')]"));

    public static final Target MESSAGE_CONTACT = Target.the("Message field")
            .located(By.xpath("//textarea[contains(@id,'message')]"));

    public static final Target BTN_SEND_CONTACT = Target.the("Send button")
            .located(By.xpath("//input[@class='hs-button primary large']"));
}
