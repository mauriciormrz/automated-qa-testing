package org.venturatravel.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage extends UIInteractionSteps {

    public static final Target EMAIL = Target.the("'Email Address*' field")
            .located(By.id("email"));

    public static final Target PASSWORD = Target.the("'Password*'  field")
            .located(By.name("password"));

    public static final Target BTN_SIGN_IN = Target.the("The 'Sign In' button")
            .located(By.xpath("//span[contains(text(),'Sign in')]"));

    public static final Target MSG_LOGIN_FAILED = Target.the("The 'Sign In' error message")
            .located(By.cssSelector("#snackbar-message-id"));

}
