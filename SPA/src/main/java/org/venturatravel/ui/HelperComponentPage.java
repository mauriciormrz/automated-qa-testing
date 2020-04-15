package org.venturatravel.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HelperComponentPage extends PageObject {

    public static final Target AVATAR_CONTACT = Target.the("Avatar Contact")
            .located(By.xpath("//img[contains(@class,'FloatingAvatar__Avatar')]"));
     //     .located(By.xpath("//*[@id='floating-avatar']"));

    public static final Target FIRSTNAME = Target.the("Name field")
            .located(By.xpath("//input[contains(@id,'firstname') and contains(@id,'floating')]"));

    public static final Target LASTNAME = Target.the("Last Name field")
            .located(By.xpath("//input[contains(@id,'lastname') and contains(@id,'floating')]"));

    public static final Target EMAIL = Target.the("Email field")
            .located(By.xpath("//input[contains(@id,'email') and contains(@id,'floating')]"));

    public static final Target MESSAGE = Target.the("Message field")
            .located(By.xpath("//textarea[contains(@id,'message') and contains(@id,'floating')]"));

    public static final Target SEND = Target.the("Send button")
            .located(By.xpath("//form[contains(@id,'hsForm_') and contains(@id,'floating')]//input[@class='hs-button primary large']"));

    public static final Target NEWSLETTER = Target.the("Newsletter field")
            .located(By.xpath("//span[contains(text(),'Newsletter')]"));

    public static final Target TXT_THANKS_CONTACT = Target.the("Thanks message")
            .located(By.xpath("//span[contains(text(),'Merci pour votre message') or contains(text(),'Vielen Dank für')]"));
}

