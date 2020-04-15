package org.venturatravel.ui;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class GoUserPage extends PageObject {

    public static final Target TAG_ROLE = Target.the("Tag Role")
            .located(By.xpath(" //label[contains(text(),'ROLES')]"));

    public static final Target POINTER_ROLE = Target.the("Pointer Role")
            .located(By.xpath(" //div[@name='groups']//div[@class='pointer']"));

    public static final Target CROSS_ROLE = Target.the("Cross Role")
            .locatedBy(" //span[contains(text(),'{0}')]/..//*[contains(@role,'presentation')]");

    public static final Target ADD_ROLE = Target.the("Roles")
            .locatedBy(" //span[contains(text(),'{0}')]");

    public static final Target BTN_SAVE = Target.the("Save button")
            .located(By.xpath("//div[@id='FormNav_bottom']//span[@class='MuiButton-label'][contains(text(),'Save Changes')]"));

    public static final Target MSG_RECORD_UPDATE = Target.the("'record updated successfully' message")
            .located(By.xpath("//span[contains(text(),'Record updated successfully')]"));

    public static final Target ROLE_VALUE = Target.the("Amount of roles")
            .located(By.xpath("//tbody[@class='MuiTableBody-root']//td[7]"));

    public static final Target LNK_BACK = Target.the("Link back to Dashboard")
            .located(By.xpath("//*[contains(@class,'MuiTypography-root MuiTypography')]"));

    public static final Target GO_USERS = Target.the("the 'Go Users' dashboard option")
            .located(By.xpath("//span[contains(text(),'Go Users')]"));

    public static final Target SEARCH = Target.the("the 'Search...' field")
            .located(By.xpath("//input[@placeholder='Search...']"));

    public static final Target LOADING = Target.the("")
            .located(By.xpath("//*[@class='MuiCircularProgress-svg']"));

    public static final Target ICON_EDIT = Target.the("the 'Edit' icon")
            .located(By.xpath("//*[@class='MuiSvgIcon-root cursor-pointer MuiSvgIcon-colorPrimary']"));

}
