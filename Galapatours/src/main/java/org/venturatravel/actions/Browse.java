package org.venturatravel.actions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.thucydides.core.annotations.Step;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;


public class Browse implements Interaction {

    String browserAction;
    String idWindowHomePage;

    public Browse(String browserAction, String idWindowHomePage){

        this.browserAction = browserAction;
        this.idWindowHomePage =idWindowHomePage;
    }

    public  static Browse toNewTab(String idWindowHomePage) {

        return Instrumented
                .instanceOf(Browse.class)
                .withProperties("browse to the new tab", idWindowHomePage);
    }

    public  static Browse toHomeTab(String idWindowHomePage) {

        return Instrumented
                .instanceOf(Browse.class)
                .withProperties("return to the previous tab", idWindowHomePage);
    }


    @Override
    @Step("{0} uses the browser to go to another tab #browserAction" )
    public <T extends Actor> void performAs(T actor) {

        if (("browse to the new tab").equals(browserAction)){
            for (String idTabs : getDriver().getWindowHandles()){
                if (!idTabs.equals(idWindowHomePage) ){
                    getDriver().switchTo().window(idTabs);
                }
            }
        }
        if (("return to the previous tab").equals(browserAction)) {
            getDriver().switchTo().window(idWindowHomePage);
        }
    }

}
