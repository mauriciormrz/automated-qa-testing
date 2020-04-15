package org.venturatravel.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("https://go-staging.venturatravel.org")
public class HomePage extends PageObject {

    public static final Target EMAIL = Target.the("'Email Address*' field")
            .located(By.cssSelector("#email"));

    public static final Target PASSWORD = Target.the("'Password*' field")
            .located(By.xpath("//input[@name='password']"));

    public static final Target BTN_SIGN_IN = Target.the("The 'Sign In' button")
            .located(By.xpath("//span[contains(text(),'Sign in')]"));


    public static final Target MSG_LOGIN_FAILED = Target.the("The 'Sign In' error message")
            .located(By.cssSelector("#snackbar-message-id"));

}
