package org.venturatravel.ui;

import net.serenitybdd.core.pages.PageObject;

import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.CurrentVisibility;
import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.screenplay.Actor;

import java.util.List;


public class ServiceTemplatePage extends PageObject {

    public static final Target ICON_TRIP_BUILDER = Target.the("the 'Trip Builder' dashboard icon")
            .located(By.xpath("//div[@title='Trip Builder']"));

    public static final Target SERVICES_TEMPLATES = Target.the("the 'Templates' menu option")
                .located(By.xpath("//*[@id='main-layout-root']/nav/div/div/div/div/ul[2]/a[2]"));

    public static final Target BTN_NEW_TEMPLATE = Target.the("the 'NEW TEMPLATE' button")
            .located(By.xpath("//span[contains(text(),'New Template')]"));

    public static final Target ICON_NEW_TEMPLATE = Target.the("the 'NEW TEMPLATE' button")
            .located(By.xpath("//a[@class='sc-gPEVay irdmEB']"));

    public static final Target TITLE_TEMPLATE = Target.the("the input template title")
            .located(By.xpath("//div[@placeholder='Add title here *']"));

    public static final Target BTN_SAVE_TEMPLATE = Target.the("the 'SAVE TEMPLATE' button")
            .located(By.xpath("//span[contains(text(),'Save')]"));

    public static final Target LNK_BACK_TO_DASHBOARD = Target.the("the 'Back to Dashboard' link")
            .located(By.xpath("//span[@class='pointer']"));

    public static final Target BTN_DELETE_TEMPLATE = Target.the("the 'DELETE TEMPLATE' button")
            .located(By.xpath("//span[contains(text(),'Yes, delete it')]"));

    public static final Target LNK_SUB_MENU = Target.the("the template sub-menu link")
            .locatedBy("//*[@id='exploreTemplates']/a[{0}]/*[3]");

    public static final Target OPTION_REMOVE = Target.the("the 'REMOVE' sub-menu option")
            .locatedBy("//span[contains(text(),'Remove')]");

    public static final Target MSG_TEMPLATE_DELETE = Target.the("'template deleted successfully' message")
            .located(By.xpath("//span[contains(text(),'template deleted successfully')]"));

    public static final Target SERVICE_TEMPLATE_NAME = Target.the("Service Template Name")
            .locatedBy("//span[contains(text(),'{0}')]");


    private List<WebElement> serviceTemplateList;

    private void updateServiceTemplateList(Actor actor) {

        actor.attemptsTo(
                Click.on(ICON_TRIP_BUILDER),
                Click.on(SERVICES_TEMPLATES)
        );
        WebElement element =  getDriver().findElement(By.id("exploreTemplates"));
        serviceTemplateList = element.findElements(By.tagName("a"));

      }

    public int findServiceTemplate(Actor actor, String serviceTemplate) {

        updateServiceTemplateList(actor);

        Boolean templateExist = CurrentVisibility.of(SERVICE_TEMPLATE_NAME.of("QA_test")).viewedBy(actor).asBoolean();

        int cellsCount = serviceTemplateList.size();

        for (int i = 0; i < cellsCount; i++) {
            String cellText = serviceTemplateList.get(i).getText();
            if (cellText.equals(serviceTemplate)) {
                return i;
            }
        }
        return -1;
    }

    public int deleteServiceTemplate(Actor actor, String serviceTemplateName) {

        updateServiceTemplateList(actor);

        int cellsCount = serviceTemplateList.size();
        int serviceCount = 0;

        for (int i = cellsCount - 1; i > 0; i--) {
            String cellText = serviceTemplateList.get(i).getText();
            if (cellText.equals(serviceTemplateName)) {

                actor.attemptsTo(
                        Click.on(LNK_SUB_MENU.of(Integer.toString(i + 1))),
                        Click.on(OPTION_REMOVE),
                        Click.on(BTN_DELETE_TEMPLATE)
                );
                return i + 1;
            }
        }
        return serviceCount;
    }
}
